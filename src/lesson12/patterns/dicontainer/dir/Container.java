package lesson12.patterns.dicontainer.dir;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

public class Container {
   private ArrayList<Class> classes;

    public Container(ArrayList<Class> classes) {
        this.classes = classes;
    }

    public void start() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        for (Class cls:classes)
        {
         if (cls.isAnnotationPresent(Component.class))   //проверяет анотацию
         {
            Object o=cls.getDeclaredConstructor().newInstance();// человек пустой
             Field[] fields=cls.getDeclaredFields();

             for (Field f:fields)
             {
                 if (f.isAnnotationPresent(AutoField.class))
                 {
                    f.setAccessible(true);

                     Object c = f.getType().getDeclaredConstructor().newInstance();///кошка пустая
                     f.set(o, c);
                     if (c.getClass().isAnnotationPresent(Configg.class)) {
                         Field[] fields1 = c.getClass().getDeclaredFields();

                         //считатаь свойства из файла конфиг
                         try (InputStream stream = Container.class.getClassLoader().getResourceAsStream("config.properties")) {
                             Properties pr = new Properties();
                             pr.load(stream);
                             for (Field f2 : fields1) {
                                 f2.setAccessible(true);
                                 f2.set(c, pr.getProperty(f2.getName()));///установили имя кошки

                             }


                         } catch (IOException e) {
                             e.printStackTrace();
                         }


                    }

                }
             }

             Method[] methods=cls.getDeclaredMethods();
             for (Method method:methods)
             {
                 if (method.isAnnotationPresent(AutoRun.class))
                 {
                     method.setAccessible(true);
                     method.invoke(o);
                 }
             }


         }
        }

    }
}
