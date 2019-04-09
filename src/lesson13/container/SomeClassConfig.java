package lesson13.container;

import lesson13.annotation.Exclude;
import lesson6.SomeClass;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

@Config(prefix = "some")
public class SomeClassConfig {
   
    private String name;
    
    private int version;

    public String getName() {
        return name;
    }
    /////--------------------------------------------

    public void setName(String name) {
        this.name = name;
    }
    /////--------------------------------------------

    public int getVersion() {
        return version;
    }

    //////------------------------------------------
    public void setVersion(int version) {
        this.version = version;
    }

    //////------------------------------------------
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        SomeClassConfig config = new SomeClassConfig();
        try (InputStream inputStream =
                     SomeClassConfig.class
                             .getClassLoader()
                             .getResourceAsStream("someClass.properties")) {

            Properties properties = new Properties();
            properties.load(inputStream);
            String name = properties.getProperty("name");
            int vertion = Integer.parseInt(properties.getProperty("version"));
            config.setName(name);
            config.setVersion(vertion);

        } catch (IOException e) {
            e.printStackTrace();
        }


//        Class<Someclass> someCla = Someclass.class;
//        Constructor<Someclass> someClassConstructor = someCla.getDeclaredConstructor(SomeClassConfig.class);
//        Someclass someClasss= someClassConstructor.newInstance(config);
//        System.out.println("1. someClasss  " + someClasss);


        Someclass someclass=new Someclass();
        someclass.setConfig(config);
        System.out.println("2. someclass = " + someclass);
        
        
        
        
    }

    @Override
    public String toString() {
        return "SomeClassConfig{" +
                "name='" + name + '\'' +
                ", version=" + version +
                '}';
    }
}

    @Config(prefix = "other")
    class OtherConfig {
        private String name;
    }

