import java.util.Scanner;

public class lab6{
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        int wybor;
        boolean flag = true;
        while(flag){
            System.out.println("Wybierz zadanie: ");
            System.out.println("1. Kalkulator");
            System.out.println("2. Iloraz cechy i mantysy");
            System.out.println("3. Suma kwadratow cyfr");
            System.out.println("4. Wyjscie");
            try{
                wybor = scan.nextInt();
            }
            catch(Exception e){
                System.out.println("Podaj liczbe!");
                scan.next();
                continue;
            }
            switch(wybor){
                case 1:
                    kalkulator();
                    break;
                case 2:
                    ilorazCechyIMantysy();
                    break;
                case 3:
                    sumaKwadratowCyfr();
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("Nie ma takiej opcji!");
                    scan.next();
                    break;
            }
        }
    }

    public static void kalkulator(){
        boolean flag = true;
        while(flag){
            float a,b;
            int wybor;
            System.out.println("Podaj pierwsza liczbe: ");
            try{
                a = scan.nextFloat();
            }
            catch(Exception e){
                System.out.println("Podaj liczbe!");
                scan.next();
                continue;
            }
            System.out.println("Podaj druga liczbe: ");
            try{
                b = scan.nextFloat();
            }
            catch(Exception e){
                System.out.println("Podaj liczbe!");
                scan.next();
                continue;
            }
            System.out.println("Wybierz dzialanie: ");
            System.out.println("1. Dodawanie");
            System.out.println("2. Odejmowanie");
            System.out.println("3. Mnozenie");
            System.out.println("4. Dzielenie");
            System.out.println("5. Potegowanie");
            System.out.println("6. Pierwiastkowanie");
            System.out.println("7. Wyjscie");
            try{
                wybor=scan.nextInt();
            }
            catch(Exception e){
                System.out.println("Podaj liczbe!");
                scan.next();
                continue;
            }
            switch(wybor){
                case 1:
                    System.out.println("Wynik: " + (a+b));
                    break;
                case 2:
                    System.out.println("Wynik: " + (a-b));
                    break;
                case 3:
                    System.out.println("Wynik: " + (a*b));
                    break;
                case 4:
                    try{
                        System.out.println("Wynik: " + (a/b));
                    }
                    catch(ArithmeticException e){
                        System.out.println("Nie mozna dzielic przez 0!");
                    }
                    break;
                case 5:
                    System.out.println("Wynik: " + Math.pow(a,b));
                    break;
                case 6:
                    try{
                        System.out.println("Wynik: " + Math.sqrt(a));
                    }
                    catch(ArithmeticException e){
                        System.out.println("Nie mozna pierwiastkowac liczby ujemnej!");
                    }
                    break;
                case 7:
                    flag = false;
                    break;
                default:
                    System.out.println("Nie ma takiej opcji!");
                    break;
            }
        }
        scan.close();
    }

    public static void ilorazCechyIMantysy() {
        double iloraz;
        while (true) {
            System.out.println("Podaj liczbe zmiennoprzecinkowa: ");
            String input = scan.nextLine();
            try {
                double liczba = Double.parseDouble(input);
                double cecha = Math.floor(Math.log10(Math.abs(liczba))) + 1;
                double mantysa = liczba / Math.pow(10, cecha);
                if (mantysa == 0){
                    System.out.println("Mantysa nie moze byc rowna 0!");
                    continue;
                }
                iloraz = cecha / mantysa;
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("Niepoprawny format liczby!");
                scan.next();
            }
        }
        System.out.println("Iloraz cechy i mantysy to: " + iloraz);
    }

    public static void sumaKwadratowCyfr(){
        int num;
        while (true) {
            System.out.println("Podaj liczbe calkowita z zakresu <99,999>: ");
            try {
                num = scan.nextInt();
                if (num >= 99 && num <= 99999) {
                    break;
                }
                else {
                    System.out.println("Podana liczba nie nalezy do zakresu <99,999>!");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Niepoprawny format liczby!");
            }
        }
        int suma = 0;
        while (num > 0) {
            int cyfra = num % 10;
            suma += cyfra * cyfra;
            num /= 10;
        }
        System.out.println("Suma kwadratów cyfr podanej liczby to: " + suma);
    }
}