package lab9;

import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class lab9{
    public static String getStr(){
        System.out.println("Podaj tekst do zaszyfrowania: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        return str;
    }

    public static String cezar(String str,int shift){
        String res = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                res += (char)((str.charAt(i) - 'a' + shift + ((str.charAt(i) - 'a' + shift)<0 ? 26 : 0)) % 26 + 'a');
            }
            else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                res += (char)((str.charAt(i) - 'A' + shift + ((str.charAt(i) - 'a' + shift)<0 ? 26 : 0)) % 26 + 'A');
            }
            else{
                res += str.charAt(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj nazwe pliku: ");
        String nazwaPliku = sc.nextLine();
        System.out.println("Podaj nazwe pliku do zapisu: ");
        String nazwazapisu = sc.nextLine();
        System.out.println("Wybiez opcje: ");
        System.out.println("1. Szyfrowanie cezara");
        System.out.println("2. Odszyfrowanie cezara");
        int opt = sc.nextInt();
        int shift;
        try{
            System.out.println("Podaj przesuniecie: ");
            shift = sc.nextInt();
            if(shift < 0 || shift > 26){
                sc.close();
                throw new Exception();
            }
            if(opt == 2)
                shift = -shift;
        }
        catch(Exception e){
            System.out.println("Podano nieprawidlowe przesuniecie");
            sc.close();
            return;
        }
        try{
            File file = new File(nazwazapisu);
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedReader br = new BufferedReader(new FileReader(new File(nazwaPliku)));
            String linia = null;
            while((linia = br.readLine()) != null){
                fw.append(cezar(linia,shift) + "\n");
            }
            fw.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Nie znaleziono pliku");
            sc.close();
            return;
        }
        catch(IOException e){
            System.out.println("Wystapil blad pliku:");
            System.out.println(e.getCause());
            sc.close();
            return;
        }
        catch(Exception e){
            System.out.println("Wystapil blad");
            sc.close();
            return;
        }
        sc.close();
    }
}