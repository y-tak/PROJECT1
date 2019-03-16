package homework4;

import java.util.Arrays;

public class Figure {
    String name;
    int[] x1=new int[2];
    int[] x2=new int[2];
    int[] x3=new int[2];
    int[] x4=new int[2];
    ///---------если 4 координаты  тогда прямоугольник Rectangle (x1,y1) (x2,y2) (x3,y3)(x4,y4)
    public Figure(int x11, int x12,int x21,int x22,int x31,int x32, int x41,int x42)
    {
        this.name = "Rectangle";
        this.x1[0]=x11;//--(x1,y1)
        this.x1[1]=x12;
        this.x2[0]=x21;//--(x2,y2)
        this.x2[1]=x22;
        this.x3[0]=x31;//--(x3,y3)
        this.x3[1]=x32;
        this.x4[0]=x41;//--(x4,y4)
        this.x4[1]=x42;

        }

///---------если 3 координаты  тогда треугольник Triangle (x1,y1) (x2,y2) (x3,y3)
    public Figure(int x11, int x12,int x21,int x22,int x31,int x32)
    {
        this.name = "Triangle";
        this.x1[0]=x11;//--(x1,y1)
        this.x1[1]=x12;
        this.x2[0]=x21;//--(x2,y2)
        this.x2[1]=x22;
        this.x3[0]=x31;//--(x2,y2)
        this.x3[1]=x32;
        this.x4[0]=0;//--(x4,y4)
        this.x4[1]=0;
        }

    ///---------если 2 координаты  тогда треугольник Circle (x1,y1) (x2,y2)
    public Figure(int x11, int x12,int x21,int x22)    {
        this.name = "Circle";
        this.x1[0]=x11;//--(x1,y1)
        this.x1[1]=x12;
        this.x2[0]=x21;//--(x2,y2)
        this.x2[1]=x22;
        this.x3[0]=0;//--(x3,y3)
        this.x3[1]=0;
        this.x4[0]=0;//--(x4,y4)
        this.x4[1]=0;
    }




    public double ploshad()
    {
        double ss1, ss2, ss3, ss4,  p;
        String name;
        name = this.name;
        switch (name)
        {
            case "Circle":
                ////(x1;y1)--(x2;y2)
                /// радиус
                ss1 = this.dlina(this.x1[0], this.x1[1], this.x2[0], this.x2[1]);
                 return Math.PI * Math.pow(ss1, 2); ///pi*r^2

            case "Rectangle":
                //стороны
                ////(x1;y1)--(x2;y2)
                ss1 = this.dlina(this.x1[0], this.x1[1], this.x2[0], this.x2[1]);
                ////(x1;y1)--(x4;y4)
                ss2 = this.dlina(this.x1[0], this.x1[1], this.x4[0], this.x4[1]);
                ////(x2;y2)--(x3;y3)
                  ss3=this.dlina(this.x3[0],this.x3[1],this.x2[0],this.x2[1]);
                ////(x3;y3)--(x4;y4)
               ss4=this.dlina(this.x3[0],this.x3[1],this.x4[0],this.x4[1]);
                return ss1 * ss2;
               // break;

            case "Triangle":
                //стороны треугольника
                ////(x1;y1)--(x2;y2)
                ss1 = this.dlina(this.x1[0], this.x1[1], this.x2[0], this.x2[1]);
                ////(x1;y1)--(x3;y3)
                ss2 = this.dlina(this.x1[0], this.x1[1], this.x3[0], this.x3[1]);
                ////(x2;y2)--(x3;y3)
                ss3 = this.dlina(this.x3[0], this.x3[1], this.x2[0], this.x2[1]);
                //по формуле Герона
                p = (ss1 + ss2 + ss3) / 2;
                return Math.sqrt(p * (p - ss1) * (p - ss2) * (p - ss3));


        }
        double ss5=0;
        return ss5;
    }
    public double perimetr()
    {
        double ss1, ss2, ss3, ss4,  p;
        String name;
        name = this.name;
        switch (name)
        {
            case "Circle":
                ////(x1;y1)--(x2;y2)
                /// радиус
                ss1 = this.dlina(this.x1[0], this.x1[1], this.x2[0], this.x2[1]);

                return 2*Math.PI *ss1; ///2*pi*r
            //break;
            case "Rectangle":
                //стороны
                ////(x1;y1)--(x2;y2)
                ss1 = this.dlina(this.x1[0], this.x1[1], this.x2[0], this.x2[1]);
                ////(x1;y1)--(x4;y4)
                ss2 = this.dlina(this.x1[0], this.x1[1], this.x4[0], this.x4[1]);
                   return 2*(ss1 +ss2);

            case "Triangle":
                //стороны треугольника
                ////(x1;y1)--(x2;y2)
                ss1 = this.dlina(this.x1[0], this.x1[1], this.x2[0], this.x2[1]);
                ////(x1;y1)--(x3;y3)
                ss2 = this.dlina(this.x1[0], this.x1[1], this.x3[0], this.x3[1]);
                ////(x2;y2)--(x3;y3)
                ss3 = this.dlina(this.x3[0], this.x3[1], this.x2[0], this.x2[1]);
                p = (ss1 + ss2 + ss3) ;
                return p;


        }
        double ss5=0;
        return ss5;
    }



    public double dlina(int xx1, int yy1,int xx2, int yy2)
    {
      double dl;
          dl=Math.sqrt(Math.pow(xx1-xx2,2)+Math.pow(yy1-yy2,2));
          return dl;
    }



    @Override
    public String toString()
    {
        return "Figure{" +
                "name='" + name + "с координатами: (x1,y1)--> " + Arrays.toString(x1)+
                " ;(x2,y2)--> "+Arrays.toString(x2)+" ;(x3,y3)--> "+Arrays.toString(x3)+" ;(x4,y4)--> "+Arrays.toString(x4)+'}';
    }






}
