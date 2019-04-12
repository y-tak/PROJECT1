package fitness;

import java.util.ArrayList;

public class FitnessRegistrator
{
    ////TODO: переписать для TreeSet || HashSet
    ///TreeSet
    ArrayList<Human> inGym=new ArrayList<>();
    ArrayList<Human> inPool=new ArrayList<>();
    ArrayList<Human> inGroup=new ArrayList<>();

 ///HashMap<String,TreeSet>
    public void addHuman(Human human,FitnessServiceEnumeration type)
    {
        ///в зависимости от type

        if (FitnessServiceEnumeration.GYM.equals(type))
        {
            ///TODO: дописать метод может или не может добавить <20,
            // имеет ли данный клиент возможность заниматься в этом зале

            inGym.add(human);
        }
        else if (FitnessServiceEnumeration.GROUP.equals(type))
        {}
        else if (FitnessServiceEnumeration.POOL.equals(type))
        {}

    }


    ///----получаем класс, получаем аннотации, создаем объект аннотации, вызываем методы у данного класса
    ///вернуться значения
    ///если разрешить или запретить


//    AnnotetionExample example = new AnnotetionExample();
////    Method[] methods = example.getClass().getDeclaredMethods();
////        for (Method method: methods){
////    Annotation[] annotations = method.getDeclaredAnnotations();
////    System.out.println(Arrays.toString(annotations));
////
////    method.isAnnotationPresent(MetodInfo.class);
////
////    MetodInfo methodInfo = method.getDeclaredAnnotation(MetodInfo.class);
////    System.out.println(methodInfo);
////    if (methodInfo != null){
////        System.out.println(methodInfo.pool());
////        System.out.println(methodInfo.gym());
////        System.out.println(methodInfo.group());
////    }
}


