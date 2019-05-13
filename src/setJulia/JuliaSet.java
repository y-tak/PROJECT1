package setJulia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class JuliaSet {

    private static  final Logger LOGGER=Logger.getLogger( JuliaSet.class.getName());
    static { LOGGER.setLevel(Level.ALL);
    try {
        ///логирование
        ///вывод в виде простого текста

           LOGGER.addHandler(new FileHandler("loggerJulia.log.xml"));
            FileHandler fileHandler=new FileHandler("loggerJulia.log");
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        }
///---рассмотреть аналоги для SET JULIA
    //f(z) = z2 + 0.279
    //f(z) = z3 + 0.400
    //f(z) = z4 + 0.484
    //f(z) = z5 + 0.544
    //f(z) = z6 + 0.590
    //f(z) = z7 + 0.626


    public static void main(String[] args) {
        ///f(z)=z^2+c  zx=zx*zx-zy*zy+cx; zy=2*zx*zy+cy;
        //Julia set,  https://en.wikipedia.org/wiki/Julia_set- теория

        final double CX,CY;//комплексное число c=cx+cy*i
        // /константы

//        System.out.println("введите CX = ");
//        Scanner in=new Scanner(System.in);
//        CX=Double.parseDouble(in.next());
//        System.out.println("введите CY = ");
//        CY=Double.parseDouble(in.next());
//

        //c = 0.45 + 0.1428i
        //c = −0.70176 − 0.3842i
        //c = −0.835 − 0.2321i
        //c = −0.8 + 0.156i
        //c = −0.7269 + 0.1889i
        //c = −0.8i
        //-------------дополнительно---
        //c= −1.7433419053321  +0.0000907687489i
        //c= −1.88488933694469 +8.1387⋅10−10i
        //с= −1.96680095       +0.00000478i
        //c= −1.7433419053321  +0.0000907687489,
        ///----------------------------

        ArrayList<Double> setCx=new ArrayList<>();
        ArrayList<Double> setCY=new ArrayList<>();
        ///--------вещественная часть числа--------
        setCx.add(0.45);
        setCx.add(-0.70176);
        setCx.add(-0.835);
        setCx.add(-0.8);
        setCx.add(-0.7269);
        setCx.add(0.0);
        setCx.add(-1.7433419053321);
        setCx.add(-1.88488933694469);
        setCx.add(-1.96680095);
        setCx.add(-1.7433419053321);
        ///-----------мнимая часть числа-------------
        setCY.add(0.14828);
        setCY.add(-0.3842);
        setCY.add(-0.2321);
        setCY.add(0.156);
        setCY.add(0.1889);
        setCY.add(-0.8);
        setCY.add(0.0000907687489);
        setCY.add(0.000000000081387);
        setCY.add(0.00000478);
        setCY.add(0.0000907687489);

///--------------------------10 констант-------------------

        for (int i=0;i<10;i++)
        {
            LOGGER.info("Cx"+ Arrays.toString(setCx.toArray())+""+"Cy"+ Arrays.toString(setCY.toArray()));
            funcF(setCx.get(i),setCY.get(i));
        }
    }



    public static void funcF(double cx, double cy)

    {

        double x,y,zx,zy,xt;
        x=0;y=0;zx=0;zy=0;xt=0;


      ///  ArrayList<Double> setZX=new ArrayList<>();
      ///  ArrayList<Double> setZY=new ArrayList<>();
        ArrayList<Double> arX=new ArrayList<>();
        ArrayList<Double> arY=new ArrayList<>();
         ///множества мандельброта - фракталы мандельброта, z^2+c
     //   Множество Мандельброта изначально было построено как каталог множеств Жюлиа:
        //каждой точке на комплексной плоскости соответствует своё множество Жюлиа.
//        Таким образом, если |zn|2 ⩽ 4 при любом числе итераций (на практике — при всех вычисленных итерациях),
//        то цвет точки чёрный, в противном случае он зависит от последнего значения n, при котором |zn|2 ⩽ 4.
//        Значение n, фактически, обозначает скорость движения zn в бесконечность и может быть просто индексом
//        в таблице цветов или использоваться как параметр в более сложном алгоритме.

        double x0=-2.1;
        double xn=1;
        double y0=-1;
        double yn=1;
        String color="black";

        ///----------заполнение множества
        for (int i=0;i<1000;i++ ) {
            arX.add(x0+(xn-x0)*i/1000);
            arY.add(y0+(yn-y0)*i/1000);
        }
        LOGGER.info("arX"+ Arrays.toString(arX.toArray()));
        LOGGER.info("arY"+ Arrays.toString(arY.toArray()));
        LOGGER.info(" cx "+ cx+" cy "+cy);
///--------------прогоняем 1000 раз и каждый раз рисуем определенным цветом-----------

        for (int i=0;i<1000;i++)
        {

            int iter = 0;
            int max_iter = 100;
            zx=arX.get(i);
            zy=arY.get(i);
            LOGGER.info("итерация "+i+": zx= " +  zx+ " zy= "+zy);


            ArrayList<Double> setZX=new ArrayList<>();
            ArrayList<Double> setZY=new ArrayList<>();

            while ((Math.pow(zx,2)-Math.pow(zy,2))<4 && iter< max_iter)
            {
                xt=Math.pow(zx,2)-Math.pow(zy,2);
                zx=2*zx*zy+cy;
                zy=xt+cx;

                setZY.add(zx);
                setZX.add(zy);

                iter++;
            }

            ///--------------для смены цвета-------------------
           /////COLOR вывод на экран setZX и setZY  с цветом color
            if (iter == max_iter)
                color="black";
            else
                color=" "+iter;

            LOGGER.info("setZX"+ Arrays.toString(setZX.toArray()));
            LOGGER.info("setZY"+ Arrays.toString(setZY.toArray()));

           /// drawPixel((x, y), color(iter))

        }



    }


}

