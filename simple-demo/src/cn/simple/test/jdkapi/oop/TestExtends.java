package cn.simple.test.jdkapi.oop;

public class TestExtends {
    public static void main( String[] args ) {
        Learn learn = new Supervise();
        learn.learn();
    }

    static abstract class Learn {
        public void learn() {
            System.out.println( "Learn.learn" );
            this.update();
        }

        public abstract void update();
    }

    static class LMS extends Learn {
        public void learn() {
            System.out.println( "LMS.learn" );
        }

        @Override
        public void update() {
            System.out.println( "LMS.update" );
        }
    }

    static class Supervise extends LMS {
        // public void learn() {
        // System.out.println( "Supervise.learn" );
        // }

        @Override
        public void update() {
            System.out.println( "Supervise.update" );
        }
    }

}
