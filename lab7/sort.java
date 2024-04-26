import java.util.ArrayList;
import java.util.Scanner;

public class sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int suma = 0;
        int iloczyn = 1;
        do{
            System.out.print("Podaj liczbe: ");
            int liczba = sc.nextInt();
            list.add(liczba);
            suma += liczba;
            iloczyn *= liczba;
            System.out.println("Suma: " + suma + " Iloczyn: " + iloczyn);
        }while(Math.abs(suma) < 250 && Math.abs(iloczyn) < 3000000);
        System.out.println("Koniec");
        list.sort(null);
        System.out.println("Lista: " + list.reversed());
        sc.close();
    }
}
