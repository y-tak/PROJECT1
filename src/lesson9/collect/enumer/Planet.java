package lesson9.collect.enumer;


import java.util.ArrayList;
import java.util.List;

enum PlanetEnum
{
    Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, Neptune, Pluto;
}
          ///----------------------------------------
public class Planet {
            private int mass;
            private PlanetEnum planetEnum;
            private double radius;
            private double radiusOrbit;



            public static void main(String[] args)
            {

                List <Planet> planets=new ArrayList<>();
                planets=new SunSystem().generate();

                for (Planet p:planets )
                {
                    System.out.println(" Планета "+p.getPlanetEnum()+" мaсса = " + p.getMass()+" радиус "+p.getRadius()+" радиус орбиты "
                            +p.getRadiusOrbit());

                }

            }




        public Planet(int mass, PlanetEnum planetEnum, double radius, double radiusOrbit) {
            this.mass = mass;
            this.planetEnum = planetEnum;
            this.radius = radius;
            this.radiusOrbit = radiusOrbit;
        }

        public int getMass() {
            return mass;
        }

        public PlanetEnum getPlanetEnum() {
            return planetEnum;
        }

        public double getRadius() {
            return radius;
        }

        public double getRadiusOrbit() {
            return radiusOrbit;
        }

        @Override
        public String toString() {
            return "Planet{" +
                    "mass=" + mass +
                    ", planetEnum=" + planetEnum +
                    ", radius=" + radius +
                    ", radiusOrbit=" + radiusOrbit +
                    '}';
        }

    }


class SunSystem{
    public List<Planet>  generate()
    {
        List<Planet> sunSystema=new ArrayList<>();
        sunSystema.add(new Planet(1256,PlanetEnum.Mercury,100,1000000));
        sunSystema.add(new Planet(1231,PlanetEnum.Venus,200,500000));
        sunSystema.add(new Planet(2222,PlanetEnum.Earth,300,3000000));
        sunSystema.add(new Planet(2115,PlanetEnum.Mars,800,9000000));
        sunSystema.add(new Planet(6541,PlanetEnum.Saturn,300,87000000));
        sunSystema.add(new Planet(2222,PlanetEnum.Jupiter,300,3000000));
        sunSystema.add(new Planet(2115,PlanetEnum.Neptune,8000,9000000));
        sunSystema.add(new Planet(65410,PlanetEnum.Uranus,30000,8700000));
        sunSystema.add(new Planet(7810,PlanetEnum.Pluto,70000,99999000));
        return sunSystema;
    }

    public SunSystem()
    {
        generate();
    }
}
