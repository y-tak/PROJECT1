package setJulia;


import logging.LoggedExample;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.*;
import java.util.logging.Formatter;

import static java.lang.Math.*;

public class Fractal {
    private static  final Logger LOGGER=Logger.getLogger(LoggedExample.class.getName());

    static {
        LOGGER.setLevel(Level.ALL);
         //-/--записать в файл в формате XML
        try {
            ///логирование
            LOGGER.addHandler(new FileHandler("loggerExampleFractal.log.xml"));

            ///вывод в виде простого текста
            FileHandler fileHandler=new FileHandler("loggerExampleFractal.log");
            //  fileHandler.setFormatter( new SimpleFormatter());
            fileHandler.setFormatter( new CustomFormatter());

            LOGGER.addHandler(fileHandler);

        } catch (IOException e)
        {LOGGER.warning("FileHandler не доступен");}

    }


    public static void main(String[] args) {

        ArrayList<Double> arX = new ArrayList<>();
        ArrayList<Double> arY = new ArrayList<>();
        double x0 = -2.1;
        double xn = 1;
        double y0 = -1;
        double yn = 1;
        double x, y, zx, zy, xt,cx,cy;
        int iter = 0;
        int max_iter = 100;

        ///------------------------


        ArrayList<Double> setCx=new ArrayList<>();
        ArrayList<Double> setCY=new ArrayList<>();
        ArrayList<Double> setTx=new ArrayList<>();
        ArrayList<Double> setTY=new ArrayList<>();
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

        for (int j = 0; j < 10; j++) {
            cx = setCx.get(j);
            cy = setCY.get(j);


            for (int i = 0; i < 1000; i++) {
                arX.add(x0 + (xn - x0) * i / 1000);
                arY.add(y0 + (yn - y0) * i / 1000);
            }

            for (int i = 0; i < 1000; i++) {
                zx = arX.get(i);
                zy = arY.get(i);

                double[] t = new double[2];
                t = Func(zx, zy, max_iter, cx, cy);

                setTx.add(t[0]);
                setTY.add(t[1]);
            }

            LOGGER.info("Множство ЖУЛИ для Сx: " + cx + "Сy:" + cy);
            LOGGER.info("Tx" + Arrays.toString(setTx.toArray()) + "" + "Ty" + Arrays.toString(setTY.toArray()));

        }
            ///--------------------------------------------------------------------------------
            ////Обычно вместо прямого вычисления последовательности E, T(E), T(T(E)),… для построения фракталов используют т. н. «игру в хаос»,
            // которая заключается в следующем. Выберем произвольную точку z0 на плоскости,
            // далее выберем случайно преобразование Ti1 и вычислим z1= Ti1(z0),
            // далее снова случайно выберем Ti2 и вычислим z1= Ti2(z0), и т. д.
            // Можно показать, что всё будет хорошо, и множество полученных точек будет в некотором смысле приближать множество F- атрактор

            //Sierpiński triangle  преобразование Vn+1=(Vn+Prn)/2, rn = random{1,2,3}..Prn- точки треугольника p1,p2,p3 - треугольник
            ///-------------Vn - вершины--------

            ArrayList<Double> setxx = new ArrayList<>();
            ArrayList<Double> setYy = new ArrayList<>();
           /////коррдинаты треугольника.........
            setxx.add(0.0);
            setxx.add(1.0);
            setxx.add(0.5);

            setYy.add(0.0);
            setYy.add(0.0);
            setYy.add(0.75);

            HashMap<Integer, ArrayList<Double>> pointsX = new HashMap<>();
            HashMap<Integer, ArrayList<Double>> pointsY = new HashMap<>();

            pointsX.put(0, setxx);
            pointsY.put(0, setYy);

            RandomT(pointsX, pointsY, max_iter);

            LOGGER.info("Треугольник Sierpinski");
            LOGGER.info("pointsX" + pointsX.toString() + "" + "pointsY" +pointsY.toString());

    }

    ///----------------------------------------------------------------
    public static void RandomT(HashMap<Integer, ArrayList<Double>> pointsX, HashMap<Integer, ArrayList<Double>> pointsY, int maxIterNum) {
        double zx;
        double zy;

        ArrayList<Double> sxx;
        ArrayList<Double> syy;
        ArrayList<Double> sxx1 = new ArrayList<>();
        ArrayList<Double> syy1 = new ArrayList<>();


        int cl;

        Random randNumber = new Random();

        for (int i = 0; i < maxIterNum; ++i) {

        // первый элемент
        sxx = pointsX.get(i);
        syy = pointsX.get(i);

        for (int j = 0; j < 3; j++) {
        cl = randNumber.nextInt(j);
        // pi -- вероятность, с которой выбираем преобразование Ti.
        sxx1.add((sxx.get(i) + sxx.get(cl)) * 0.5);
        syy1.add((syy.get(i) + syy.get(cl)) * 0.5);
        }
        pointsX.put(i, sxx1);
        pointsY.put(i, syy1);

        if (i > 100) { // Первых несколько итераций могут быть достаточно далеко от аттрактора.
        ///draw(z);//треугольник из трех вершин
        //color%2=0 -  черный, или color%2!=0  - белый
        }
        }


        }

    ///------------------------------------------

    public static double[] Func(double x, double y, int max_iter, double cx, double cy) {
///   f(z)=z^2+c;, f(z),f(f(z)),f(f(f(z))),.....
        //Теперь самое время перейти к описанию алгоритма времени убегания.
        // Пусть у нас для начала есть одно преобразование плоскости f.
        // Для каждой точки z плоскости начнём вычислять последовательность f(z), f(f(z)), f(f(f(z))),…
        // до тех пор пока либо число итераций не превысит некоторого заданного числа N,
        //   либо пока норма числа z не станет больше некоторого числа C=4.
        //   После этого цвет точки выбираем в соответствии с количеством произведённых итераций.

        int iter = 0;
        double xt;
        double[] t = new double[2];

        while ((pow(x, 2) - pow(y, 2)) < 4 && iter < max_iter) {
            xt = pow(x, 2) - pow(y, 2);
            x = 2 * x * y + cy;
            y = xt + cx;

            iter++;
        }
        //drawPixel((x, y), color(iter));
        t[0] = x;
        t[1] = y;

          return t;

    }
}


///-------------------------------------------

class CustomFormatter extends Formatter
{
    private final static  ThreadLocal<DateFormat> dateFormat =new ThreadLocal<DateFormat>()
    {
        protected DateFormat initialValue()
        {
            return  new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

        }

    };

    private String formatDate (long millis){
        return dateFormat.get().format(new Date(millis));}

    @Override
    public String format(LogRecord record) {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append('['+formatDate(record.getMillis())).append(']');
        stringBuilder.append('[').append(record.getLevel()).append(']');
        stringBuilder.append('[').append(record.getSourceClassName())
                .append('.').append(record.getSourceMethodName()).append(']');
        stringBuilder.append('-').append(record.getMessage()).append(' ');
        return  stringBuilder.toString();
    }

}