package lab3;

import java.util.Scanner;

public class binary
{
    public static String getZeroSequences(String number){
        String res = "";
        int count = 0;
        for(int i = 0; i < number.length(); i++){
            if(number.charAt(i) == '0'){
                count++;
            }
            else{
                if(count > 0){
                    res += count + " ";
                    count = 0;
                }
            }
        }
        if(res.length() == 0)
            return "0";
        return res;
    }
    
    public static void main( String[] args )
    {
        System.out.println("Podaj dowolna liczbe: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        sc.close();
        System.out.println("Podano liczbe "+number);
        String bin=Integer.toBinaryString(number);
        System.out.println("Podana liczba w systemie binarnym to "+bin);
        String zeroes=getZeroSequences(bin);
        System.out.println("Zerowe sekwencje w liczbie binarnej: "+(zeroes.compareTo("0")==0 ? "brak" : zeroes));
        int max=0;
        for(String i:zeroes.split(" ")){
            if(Integer.valueOf(i)>max){
                max=Integer.valueOf(i);
            }
        }
        System.out.println(max==0 ? "Podana liczba binarna nie ma sekwencji zer" : "Najdluzsza sekwencja zer ma dlugosc "+max);
    }
}
