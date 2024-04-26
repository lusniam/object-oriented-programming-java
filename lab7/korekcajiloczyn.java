import java.util.ArrayList;
import java.util.Scanner;

public class korekcajiloczyn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int iloczyn = 1;
        do{
            System.out.print("Podaj liczbe: ");
            int liczba = sc.nextInt();
            list.add(liczba);
            iloczyn *= liczba;
            list.sort(null);
            System.out.println("Iloczyn: " + iloczyn + " Lista: " + list);
            while(Math.abs(iloczyn)>256){
                int usunieta=list.remove(0);
                iloczyn /= usunieta;
                System.out.println("Iloczyn za duzy, usuwam liczbe " + usunieta);
                System.out.println("Iloczyn: " + iloczyn + " Lista: " + list);
            }
        }while(Math.abs(iloczyn)!=256);
        System.out.println("Koniec");
        System.out.println("Ostateczna lista: " + list);
        sc.close();
    }
}
