import java.util.ArrayList;
import java.util.Scanner;

public class korekcjasum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int suma = 0;
        do{
            System.out.print("Podaj liczbe: ");
            int liczba = sc.nextInt();
            list.add(liczba);
            suma += liczba;
            list.sort(null);
            System.out.println("Suma: " + suma + " Lista: " + list);
            if(suma>64){
                int usunieta=list.remove(list.size()-1);
                suma -= usunieta;
                System.out.println("Suma za duza, usuwam liczbe " + usunieta);
                System.out.println("Suma: " + suma + " Lista: " + list);
            }
        }while(suma!=64);
        System.out.println("Koniec");
        System.out.println("Ostateczna lista: " + list);
        sc.close();
    }
}
