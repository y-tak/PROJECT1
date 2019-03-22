package kontrol;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Hospital
{
    private Doctor doctor1;
    private Doctor doctor2;
    private Doctor doctor3;
    private Patient[] patient=new Patient[5];
    private Administration administrator;
    private Zapis[] jurnals = new Zapis[30];
    private MainDoctor mainDoctor;

    public Hospital()
    {
    }

    private void init(int d)
    {

        administrator =new Administration("Федоров","123");
        doctor1=new Doctor("Иванов ","111","хирург");
        doctor2=new Doctor("Селезнев","222","лор");
        doctor3=new Doctor("Васильев","333","терапевт");
        mainDoctor=new MainDoctor("Ленгард","555");



        ///--создали больницу



    }

    ///-----------------------------------
    private void openDoctor()
    {
        System.out.println("Добро Пожаловать доктор " );
        exit();
    }
////--------------------------------------
    private void openAdministrator()
    {
        System.out.println("Добро Пожаловать администратор" );
       //---проставляет активность записей
        for (int j = 0; j < jurnals.length; j++)
        {
            System.out.println(jurnals[j]);
            if (jurnals[j].isActiv()==false)
                jurnals[j].setActiv(true);
        }

        exit();
    }
    ///------------------------------------
    private void openMainDoctor()
    {
        System.out.println("Добро Пожаловать главный врач" );
        exit();
    }

    ///---------------для пациента---------------
    private void openPatient(Patient p)
    {
        System.out.println("Добро Пожаловать " +p.getName());
        System.out.println(doctor1);

        Scanner in2=new Scanner(System.in);

        System.out.println("Выбрать врача:" +doctor1.getName()+"1");
        System.out.println("Выбрать врача:" +doctor2.getName()+"2");
        System.out.println("Выбрать врача:" +doctor3.getName()+"3");

        String a=in2.nextLine();


        if (a.equals("1"))
          doctor2=this.doctor1;
        else if (a.equals("2"))
           doctor2=this.doctor2;
        else if (a.equals("3"))
           doctor2=this.doctor3;

        System.out.println("Введите дату и время: ГГ.MM.ДД ЧЧ:MM");
        String date1 = in2.nextLine();

        String number = "123";
           ///---добавлена запись
///---тут не работает
        Zapis zapis = new Zapis(doctor2, p, date1, number);
        zapis.setActiv(false);

          // int i = jurnals.length;

          // for (int j = 0; j < i; j++)
           //    {
           //        if (jurnals[j].hashCode() == zapis.hashCode())
           //    {
            //       System.out.println(" запись уже есть! поdторите ввод времени ");
           //        exit();
           //        return ;
           //    }
         //  }
               this.jurnals[0] = zapis;
        System.out.println("создана запись "+zapis);
               exit();

    }


    public void exit()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("вы хотите выйти y/n" );
        String r=in.next();
        if (r.equals("y"))
        { System.out.println("введите пароль" );
             String ff= in.next();
            this.open(ff);}


    }

    ///-----------------------------------
    public void open(String pas)
    {

        init(1);
        if (doctor1.getPassword().equals(pas))
        {///зашел doctor1
            openDoctor();
            return;
        }
        else if (doctor2.getPassword().equals(pas))
        {///зашел doctor1
            openDoctor();
            return;
        }
        else if (doctor3.getPassword().equals(pas))
        {///зашел doctor1
            openDoctor();
            return;
        }
        else if (administrator.getPassword().equals(pas))
        {///зашел doctor1
            openAdministrator();
            return;
        }
        else if (mainDoctor.getPassword().equals(pas))
        {///зашел doctor1
            openMainDoctor();
            return;
        }
        else

        {
            System.out.println(" это пациент");
            Patient patient=new Patient(pas);
            openPatient(patient);
            return;
        }




    }




    }




