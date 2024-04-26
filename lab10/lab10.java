package lab10;

import java.util.Random;

class Zad1 implements Runnable {
    Random rand;
    public Zad1() {
        rand = new Random();
    }
    public Zad1(Random r){
        rand = r;
    }
    synchronized public void run(){
        for(int i = 0; i < 10; i++){
        System.out.println(rand.nextInt(0,100));
        try{
            this.wait(1000);
        }
        catch(InterruptedException e){
            System.out.println("Interrupted");
        }
        }
    }
}



public class lab10 {
    public static void main(String[] args) {
        zad1();
    }

    private static void zad1(){
        Random rand = new Random();
        Thread[] threads = new Thread[10];
        for(int i = 0; i < 10; i++){
            threads[i] = new Thread(new Zad1(rand));
            threads[i].start();
            System.out.println(threads[i].getName() + " started");;
        }
    }

    
}