package lab4;

import java.util.Random;

class Okrag{
    float x;
    float y;
    float r;

    Okrag(){
        Random random = new Random();
        this.x = 5 + random.nextFloat(91);
        this.y = 5 + random.nextFloat(91);
        this.r = 1 + random.nextFloat(5);
    }

    static Okrag[] getTab(int size){
        Okrag[] tab = new Okrag[size];
        for (int i = 0; i < size; i++) {
            tab[i] = new Okrag();
        }
        return tab;
    }

    static String sprawdzPolozenie(Okrag ok1, Okrag ok2){
        float odleglosc = (float)Math.sqrt(Math.pow(ok1.x-ok2.x,2)+Math.pow(ok1.y-ok2.y,2));
        if(odleglosc<ok1.r+ok2.r)
            return "pokrywajace sie";
        else if(odleglosc==ok1.r+ok2.r)
            return "styczne zewnetrznie";
        else if(odleglosc==Math.abs(ok1.r-ok2.r))
            return "styczne wewnetrznie";
        else if(odleglosc>Math.abs(ok1.r-ok2.r) && odleglosc<ok1.r+ok2.r)
            return "przecinaja sie";
        else
            return "rozlaczne";
    }

    static void printTab(Okrag[] tab){
        for (Okrag okrag : tab) {
            System.out.printf("(%.2f, %.2f, %.2f)\n",okrag.x,okrag.y,okrag.r);
        }
    }
}

public class lab4
{
    static int[] get100tab() {
        int[] tab = new int[100];
        for (int i = 0; i < 100; i++) {
            tab[i] = i;
        }
        return tab;
    }

    static void print100tab(int[] tab) {
        float srednie[] = new float[10];
        for (int i = 0; i < 100; i++) {
            System.out.printf("%02d, ",tab[i]);
            srednie[i%10] += tab[i];
            if(i%10==9)
                System.out.println();
        }
        System.out.println("Średnie:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%02.0f, ",srednie[i]/10);
        }
        System.out.println();
    }

    static int[][] getDoubleTab(){
        Random random = new Random();
        int size = 10 + random.nextInt(11);
        int[][] tab = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(i==j || i+j==size-1)
                    if( random.nextBoolean())    
                        tab[i][j] = -1;
                    else
                        tab[i][j] = 1;
                else
                    tab[i][j] = -20 + random.nextInt(41);
            }
        }
        return tab;
    }

    static float obliczStosunek(int [][] tab){
        int sumaX = 0;
        int sumaY = 0;
        for(int i=0;i<tab.length;i++){
            for(int j=0;j<tab.length;j++){
                if(i%2==0)
                    sumaX += tab[i][j];
                else
                    sumaY += tab[j][i];
            }
        }
        return (float)sumaX/sumaY;
    }

    public static void main( String[] args )
    {
        System.out.println( "4.1" );
        int[] tab = get100tab();
        print100tab(tab);

        System.out.println( "4.2" );
        int[][] doubleTab = getDoubleTab();
        for (int i = 0; i < doubleTab.length; i++) {
            for (int j = 0; j < doubleTab.length; j++) {
                System.out.printf("%3d, ",doubleTab[i][j]);
            }
            System.out.println();
        }
        System.out.println("Stosunek szukany w zadaniu 4.2 wynosi "+obliczStosunek(doubleTab));
        
        System.out.println( "4.3" );
        Okrag[] tabOkregow = Okrag.getTab(10);
        Okrag.printTab(tabOkregow);
        for (int i = 0; i < tabOkregow.length; i++) {
            for (int j = i+1; j < tabOkregow.length; j++) {
                System.out.printf("Okregi %d i %d sa %s\n",i,j,Okrag.sprawdzPolozenie(tabOkregow[i],tabOkregow[j]));
            }
        }
    }
}
