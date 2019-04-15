package fitness;

public class Main {

    public static void main(String[] args)  {

        FitnessRegistrator reg=new FitnessRegistrator();
        Client client=new Client("Ivanov","Dima",25);
        Client client1=new Client("Tortik","Vasy",20);

        DayClient dayClient=new DayClient("Popova","Victory",30);
        DayClient dayClient1=new DayClient("Gorodskay","Toma",37);
        FillDayClient fulDayClient=new FillDayClient("Kant","Immanuil",31);

       reg.addHuman(client,FitnessServiceEnumeration.GYM);
        reg.addHuman(dayClient1,FitnessServiceEnumeration.GYM);

       reg.addHuman(dayClient,FitnessServiceEnumeration.POOL);
       reg.addHuman(client1,FitnessServiceEnumeration.POOL);
       reg.addHuman(fulDayClient,FitnessServiceEnumeration.GROUP);
       reg.addHuman(client,FitnessServiceEnumeration.GROUP);

        FitnessLogger fitnessLogger=new FitnessLogger();
        fitnessLogger.addName(client);
        fitnessLogger.addName(client1);
        fitnessLogger.addName(dayClient);
        fitnessLogger.addName(dayClient1);
        fitnessLogger.addName(fulDayClient);


        System.out.println("всего в зале");
        for (Human iu:reg.inGym)
        {
            System.out.println(" " + iu.getSoname()+" "+iu.getName());
        }
        System.out.println("всего в бассейне");
        for (Human iu:reg.inPool)
        {
            System.out.println(" " + iu.getSoname()+" "+iu.getName());
        }

        System.out.println("всего в йоге");
        for (Human iu:reg.inGroup)
        {
            System.out.println(" " + iu.getSoname()+" "+iu.getName());
        }

        System.out.println(" удалили йогу");
        reg.setInGroup(reg.removealltree());
        System.out.println(" всего в йоге "+reg.inGroup.toString() );


       // System.out.println("всего в зале " + reg.inGym.toString());
       // System.out.println("всего в бассейне " + reg.getInPool().toString());
      //  System.out.println("всего в йоге" + reg.inGroup.toString());


    }
}
