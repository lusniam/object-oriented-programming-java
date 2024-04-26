package lab3;

import java.util.Scanner;

public class cezar {
    public static String getStr(){
        System.out.println("Podaj tekst do zaszyfrowania: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        return str;
    }

    public static String szyfrCezar(String str,int shift){
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

    public static boolean palindrom(String str){
        for(int i = 0; i < str.length() / 2; i++){
            if(str.charAt(i) != str.charAt(str.length() - i - 1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = getStr();
        int shift = 3;
        String res = szyfrCezar(str,shift);
        System.out.println("Tekst po zaszyfrowaniu to "+res);
        res=szyfrCezar(res, -shift);
        System.out.println("Tekst po odszyfrowaniu: "+res);
        System.out.println("Czy ten tekst jest palindromem: "+(palindrom(res)?"tak":"nie"));
    }
}