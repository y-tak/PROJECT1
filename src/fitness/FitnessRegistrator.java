package fitness;

import lesson13.annotation.AnnotetionExample;

import java.lang.reflect.Method;
import java.util.*;

public class FitnessRegistrator {
    ////TODO: переписать для TreeSet || HashSet
    ///TreeSet
    Comparator<Human> userComparator = new NameComporator().thenComparing(new SoNameComporator());
    TreeSet<Human> inGym = new TreeSet<>(userComparator);
    TreeSet<Human> inPool = new TreeSet<>(userComparator);
    TreeSet<Human> inGroup = new TreeSet<>(userComparator);

    HashMap<String, TreeSet> hashMap = new HashMap<>();



    public void addHuman(Human human, FitnessServiceEnumeration type)  {
        ///в зависимости от type

        Boolean d= null;
        Boolean d1= null;
        try {
            d = MayAddHuman(human,type);
        } catch (NoAccessException e) {
            e.printStackTrace();
        }


      // System.out.println("type = " + type);
        if (FitnessServiceEnumeration.GYM.equals(type)) 
        {
            ///TODO: дописать метод может или не может добавить <20,
            // имеет ли данный клиент возможность заниматься в этом зале
            try {
                d1=IsKol(inGym);
            } catch (QueueException e) {
                e.printStackTrace();
            }

            if (d == true&&d1==true) {
                inGym.add(human);
              //  hashMap.put(human.getName(),inGym);
            }

        } 
        else if (FitnessServiceEnumeration.GROUP.equals(type))
        {

            try {
                d1=IsKol(inGroup);
            } catch (QueueException e) {
                e.printStackTrace();
            }
            if (d == true&&d1==true) {
                inGroup.add(human);
               // hashMap.put(human.getName(),inGroup);
            }

        }
        else if (FitnessServiceEnumeration.POOL.equals(type)) 
        {

            try {
                d1=IsKol(inPool);
            } catch (QueueException e) {
                e.printStackTrace();
            }
            if (d == true&&d1==true) {
                inPool.add(human);
              //  hashMap.put(human.getName(),inPool);
            }
        }



    }


    public TreeSet<Human> removealltree()
    {
       TreeSet<Human> treeSet1=new TreeSet<>();

       return treeSet1;

    }
    ///----получаем класс, получаем аннотации, создаем объект аннотации, вызываем методы у данного класса
    ///вернуться значения
    ///если разрешить или запретить


    public TreeSet<Human> getInGym() {
        return inGym;
    }

    public TreeSet<Human> getInPool() {
        return inPool;
    }

    public TreeSet<Human> getInGroup() {
        return inGroup;
    }

    public void setInGym(TreeSet<Human> inGym) {
        this.inGym = inGym;
    }

    public void setInPool(TreeSet<Human> inPool) {
        this.inPool = inPool;
    }

    public void setInGroup(TreeSet<Human> inGroup) {
        this.inGroup = inGroup;
    }

    private static boolean IsKol(TreeSet<Human> treset) throws QueueException
    {
        if ( treset.size()>20)
            return false;
        else
            return true;
    }

    private static boolean  MayAddHuman(Human human, FitnessServiceEnumeration type) throws NoAccessException
    {

        Class cl=human.getClass();
        ///текущее время
        int timeReal=13;

        AnnotetionExample example=new AnnotetionExample();
        if ((cl).isAnnotationPresent(AccessMode.class))
        {
            AccessMode as= (AccessMode) cl.getAnnotation(AccessMode.class);
            ///System.out.println("cl" + (cl).getAnnotation(AccessMode.class));
            String timeP=as.pool();
            String timeGr=as.group();
            String timeG=as.gym();



            if (type.equals(FitnessServiceEnumeration.POOL)&& timeReal>Integer.parseInt(timeP))
            {
               return false;
            };

            if (type.equals(FitnessServiceEnumeration.GYM)&& timeReal>Integer.parseInt(timeGr))
            {
                return false;
            };

            if (type.equals(FitnessServiceEnumeration.GYM)&& timeReal>Integer.parseInt(timeG))
            {
                return false;
            };

        }

        return true;
    }
}
///-----------------------------
class NameComporator implements Comparator<Human>
        {

                      @Override
            public int compare(Human o1, Human o2) {
                          return o1.getName().compareTo(o2.getName());
            }
        }

        //-----------------------------------------
class SoNameComporator implements Comparator<Human>
{

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getSoname().compareTo(o2.getSoname());
    }
}

