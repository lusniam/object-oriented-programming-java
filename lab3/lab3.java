package lab3;

import java.util.Scanner;

class strmeth{
    public static int howMany(String str, Character chr){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == chr){
                count++;
            }
        }
        return count;
    }

    public static int sumAscii(String str){
        int res = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z' || str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                res+=str.charAt(i);
            }
        }
        return res;
    }

    public static char toChar(){
        System.out.println("Podaj liczbe z zakresu <33, 126>");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        return (char)num;
    }
}

public class lab3
{
    public static void main( String[] args )
    {
        System.out.println("3.1");
        System.out.println(strmeth.howMany("abracadabra", 'a'));

        System.out.println("3.2");
        System.out.println(strmeth.sumAscii("abracadabra"));

        System.out.println("3.3");
        System.out.println("Odczytana liczba daje znak "+strmeth.toChar());
    }
}
