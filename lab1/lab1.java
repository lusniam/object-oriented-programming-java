package lab1;

public class lab1 
{
    public static void main( String[] args )
    {
        System.out.println( "1.1" );
        System.out.println( "Ucze sie programowania 5 lat, znam 5 jezykow, moj ulubiony to python" );
        System.out.println( "1.2" );
        int x, y;
        int z = 12;
        double i = 2.45;
        char znak = 'z';
        double j;
        x = 0;
        y = 444;
        j = 0.002;
        System.out.print("x = "+ x +", y = "+ y +", z = "+ z );
        System.out.println( "Nie wypisano zmiennych i = "+ i +", znak = "+ znak +" oraz j = "+ j );
        int zmienna1;
        String zmienna2;
        zmienna1 = 1;
        zmienna2 = "tekst";
        System.out.println( "zmienna1 = "+ zmienna1 +", zmienna2 = "+ zmienna2 );
        System.out.println( "1.3" );
        System.out.printf("i=%4.1f, j=%8.2e, x=%6d znak:%c\n", i, j, x, znak);
        //i będzie wyświetlone na 4 pozycjach z jedną cyfrą po kropce
        //j będzie wyświetlone na 8 pozycjach z dwoma cyframi po kropce w formacie zmiennopozycyjnym
        //x będzie wyświetlone na 6 pozycjach (spacje z przodu)
        //znak będzie wyświetlony jako pojedynczy znak
        System.out.println( "Po zmianach:" );
        System.out.printf("i=%4.5e, j=%8.5e, x=%6d znak:%c\n", i, j, x, znak);
    }
}
