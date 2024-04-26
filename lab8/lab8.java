package lab8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class lab8 {
    public interface str{
        public void wypisz(String s);
    }

    public static void wypiszListe(ArrayList<String> lista, str s){
        System.out.println("Lista przedmiotow do zaliczenia: ");
        for(String str : lista){
            s.wypisz(str);
        }
    }

    public static void zad1(Scanner scan){
        ArrayList<String> lista = new ArrayList<String>();
        System.out.println("Podaj liczbe przedmiotow do zaliczenia: ");
        int n = scan.nextInt();
        scan.nextLine();
        for(int i=0; i<n; i++){
            System.out.println("Podaj przedmiot: ");
            lista.add(scan.nextLine());
        }
        wypiszListe(lista, (s) -> System.out.println(s));
    }

    public static <T> T[] sortujTablice(T[] lista, Comparator<T> c){
        for (int i = 0; i < lista.length; i++) {
            for (int j = 0; j < lista.length - 1; j++) {
                if (c.compare(lista[j], lista[j + 1]) > 0) {
                    T temp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temp;
                }
            }
        }
        return lista;
    }

    public static void zad2(Scanner scan){
        System.out.println("Podaj rozmiar tablicy do posortowania: ");
        int n = scan.nextInt();
        scan.nextLine();
        Integer[] lista = new Integer[n];
        for(int i=0; i<n; i++){
            System.out.println("Podaj liczbe: ");
            lista[i] = scan.nextInt();
            scan.nextLine();
        }
        System.out.println("Lista przed sortowaniem: ");
        for(Integer i : lista){
            System.out.println(i);
        }
        System.out.println("Lista po sortowaniu: ");
        sortujTablice(lista, (a, b) -> a.compareTo(b));
        for(Integer i : lista){
            System.out.println(i);
        }
    }

    public static <T> ArrayList<T> sortujListe(ArrayList<T> lista, Comparator<T> c){
        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < lista.size() - 1; j++) {
                if (c.compare(lista.get(j), lista.get(j + 1)) > 0) {
                    T temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }
        return lista;
    }

    public static void zad3(Scanner scan){
        ArrayList<String> lista = new ArrayList<String>();
        System.out.println("Podaj rozmiar listy do posortowania: ");
        int n = scan.nextInt();
        scan.nextLine();
        for(int i=0; i<n; i++){
            System.out.println("Podaj element: ");
            lista.add(scan.nextLine());
        }
        System.out.println("Lista przed sortowaniem: ");
        for(String s : lista){
            System.out.println(s);
        }
        System.out.println("Lista po sortowaniu: ");
        sortujListe(lista, (a, b) -> Integer.valueOf(a.length()).compareTo(Integer.valueOf(b.length())));
        for(String s : lista){
            System.out.println(s);
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Poda numer zadania: ");
        int n = scan.nextInt();
        scan.nextLine();
        switch(n){
            case 1:
                zad1(scan);
                break;
            case 2:
                zad2(scan);
                break;
            case 3:
                zad1(scan);
                break;
            default:
                System.out.println("Nie ma takiego zadania");
                break;
        }
        scan.close();
    }
}
