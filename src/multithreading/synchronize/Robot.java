package multithreading.synchronize;

public class Robot {
   volatile boolean current = false;
    //boolean current = false;

    class Leg implements Runnable {
        String name;
        boolean leg;

        @Override
        public void run() {
            while (true) {
                if (leg == current) {
                    step();
                    Thread.yield();///передает управление другому потоку
                    current = !leg;
                }
            }
        }

        void step() {
            System.out.println("name = " + name);
        }

        public Leg(String name, boolean leg) {
            this.name = name;
            this.leg=leg;
        }
    }

    Leg left = new Leg("left", true);
    Leg right = new Leg("right", false);

    void start() {
        new Thread(left).start();
        new Thread(right).start();
        ///
    }

    public static void main(String[] args) {
        Robot robot=new Robot();
        robot.start();
    }


}