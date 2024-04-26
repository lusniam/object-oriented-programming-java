package lab2;

class zmienne
{
    int i;
    char c;
    String s;

    public zmienne() {
    }

    public void wyswietl() {
        System.out.println("int: " + i);
        System.out.println("char: " + c);
        System.out.println("String: " + s);
    }

    public static void liczby(){
        for (int i = 0; i < 54; i++) {
            System.out.println(i);
        }
    }
}

class Uczen{
    public String imie,nazwisko;
    public int wiek;
    public double srednia;

    public Uczen(){
        this.imie = "Jan";
        this.nazwisko = "Kowalski";
        this.wiek = 18;
        this.srednia = 4.5;
    }

    public Uczen(String imie, String nazwisko, int wiek, double srednia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.srednia = srednia;
    }

    public String dane(){
        return imie + " " + nazwisko + ", lat " + wiek + ", srednia " + srednia;
    }
}

class Owoc{
    public String nazwa;
    public String kolor;
    public double masa;
    public String krajPochodzenia;

    public Owoc(String nazwa, String kolor, double masa, String krajPochodzenia) {
        this.nazwa = nazwa;
        this.kolor = kolor;
        this.masa = masa;
        this.krajPochodzenia = krajPochodzenia;
    }

    public String dajNazwe(){
        return nazwa;
    }

    public String dajKolor(){
        return kolor;
    }

    public double dajWage(){
        return masa;
    }

    public String dajKrajPochodzenia(){
        return krajPochodzenia;
    }
}

class Petle{
    public static void whileLoop(){
        int i = 5;
        int j=0;
        int tab[] = new int[15];
        while(i <= 80){
            tab[j] = i;
            i++;
            j++;
            if(j==15){
                for(int k:tab){
                    System.out.print(k+" ");
                }
                System.out.println();
                j=0;
            }
        }
    }
    public static void doWhileLoop(){
        int i = 5;
        int j=0;
        int tab[] = new int[15];
        do{
            tab[j] = i;
            i++;
            j++;
            if(j==15){
                for(int k:tab){
                    System.out.print(k+" ");
                }
                System.out.println();
                j=0;
            }
        }while(i <= 80);
    }

    public static void forLoop(){
        int tab[] = new int[15];
        for(int i=5;i<=80;i++){
            int index=(i-5)%15;
            if(index==0&&i>5){
                for(int j:tab){
                    System.out.print(j+" ");
                }
                System.out.println();
            }
            tab[index] = i;
        }
    }

    public static void forEachLoop(){
        int tab[] = new int[75];
        for(int i=0;i<75;i++){
            tab[i] = i+5;
        }
        for(int i:tab){
            System.out.print(i+" ");
            if(i>5&&(i-5)%15==0){
                System.out.println();
            }
        }
        System.out.println();
    }
}

class maths{
    public static void trojkat(int a, int b, int c){
        System.out.print("Z bokow o dlugosci: "+a+", "+b+", "+c);
        if(a+b>c && a+c>b && b+c>a){
            System.out.println("Mozna zbudowac trojkat");
            if(a==b && b==c){
                System.out.println("Trojkat jest rownoboczny");
            }
            else if(a==b || b==c || a==c){
                System.out.println("Trojkat jest rownoramienny");
            }
            else{
                System.out.println("Trojkat jest roznoboczny");
            }
        }
        else{
            System.out.println("Nie mozna zbudowac trojkata");
        }
    }

    public static void calkowite(){
        for(int i=11;i<=111;i++){
            if(i%13==0){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    public static void fibonacci(int n){
        int a=0,b=1,c;
        if(n>0)
            System.out.print(a+" ");
        if(n>1)
            System.out.print(b+" ");
        for(int i=0;i<n-2;i++){
            c=a+b;
            System.out.print(c+" ");
            a=b;
            b=c;
        }
        System.out.println();
    }
}

public class lab2
{
    public static void main( String[] args )
    {
        System.out.println( "2.1" );
        zmienne z = new zmienne();
        z.wyswietl();

        System.out.println( "2.2" );
        zmienne.liczby();

        System.out.println( "2.3" );
        Uczen u1 = new Uczen();
        Uczen u2 = new Uczen("Damian", "Dvorak", 21, 3.5);
        Uczen u3 = new Uczen();
        Uczen u4 = new Uczen("Krzysztof", "Podloga", 24, 4.0);
        System.out.println("Uczen 1: " + u1.dane());
        System.out.println("Uczen 2: " + u2.dane());
        System.out.println("Uczen 3: " + u3.dane());
        System.out.println("Uczen 4: " + u4.dane());

        System.out.println( "2.4" );
        Owoc o1 = new Owoc("Jablko", "Czerwony", 0.2, "Polska");
        Owoc o2 = new Owoc("Banan", "Zolty", 0.3, "Ekwador");
        Owoc o3 = new Owoc("Pomarancza", "Pomaranczowy", 0.4, "Hiszpania");
        System.out.println("Kolor owocu 2: "+o2.dajKolor());
        System.out.println("Nazwa owocu 3: "+o3.dajNazwe());
        System.out.println("Waga owocu 1: "+o1.dajWage());
        System.out.println("Kraj pochodzenia owocu 3: "+o3.dajKrajPochodzenia());
    
        System.out.println( "2.5" );
        System.out.println("Petla while:");
        Petle.whileLoop();
        System.out.println("Petla do while:");
        Petle.doWhileLoop();
        System.out.println("Petla for:");
        Petle.forLoop();
        System.out.println("Petla for each:");
        Petle.forEachLoop();

        System.out.println( "2.6" );
        maths.trojkat(3,4,5);

        System.out.println( "2.7" );
        maths.calkowite();

        System.out.println( "2.8" );
        maths.fibonacci(10);
    }
}
