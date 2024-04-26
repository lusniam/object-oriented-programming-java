import java.util.Scanner;

public class pobierz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int liczba = 0;
        int suma = 0;
        int ilosc = 0;
        int iloczyn = 1;
        while(true){
            System.out.print("Podaj liczbę: ");
            liczba = sc.nextInt();
            if(liczba == 0) break;
            suma += liczba;
            ilosc++;
            iloczyn *= liczba;
        }
        System.out.println("Suma: " + suma);
        System.out.println("Ilość: " + ilosc);
        System.out.println("Iloczyn: " + iloczyn);
        sc.close();
    }
}
