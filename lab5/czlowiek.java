package lab5;

interface podstawowy{
    void jedz();
    void pij();
    void spij();
    void wstan();
}

interface szkola{
    void uczSie();
    void odrobLekcje();
    void idzDoSzkoly();
    void wrocDoDomu();
}

interface studia{
    void studiuj();
    void nieIdzNaZajecia();
    void idzNaWyklad();
    void idzNaCwiczenia();
}

interface praca{
    void pracuj();
    void placPodatki();
    void idzDoPracy();
    void wrocDoDomu();
}

interface emerytura{
    void odbierzEmeryture();
    void idzDoLekarza();
    void idzNaRynek();
    void idzPoLeki();
}

abstract class Czlowiek{
    abstract void jedz();
    abstract void pij();

    void ileLat(){
        System.out.println("Czlowiek ma 20 lat");
    }
    void cechy(){
        System.out.println("Czlowiek jest ssakiem");
    }
}

abstract class Dziecko extends Czlowiek{
    abstract void zabawa();
    abstract void obowiazki();
    void szkola(){
        System.out.println("Dziecko chodzi do szkoly");
    }
    void nauka(){
        System.out.println("Dziecko uczy sie");
    }
}

abstract class Dorosly extends Czlowiek{
    abstract void zabawa();
    abstract void obowiazki();
    void praca(){
        System.out.println("Dorosly pracuje");
    }
    void podatki(){
        System.out.println("Dorosly placi podatki");
    }
}

class Uczen extends Dziecko implements podstawowy, szkola{
    void zabawa(){
        System.out.println("Uczen bawi sie");
    }
    void obowiazki(){
        System.out.println("Uczen ma obowiazki");
    }
    public void jedz(){
        System.out.println("Uczen je");
    }
    public void pij(){
        System.out.println("Uczen pije");
    }
    public void spij(){
        System.out.println("Uczen spi");
    }
    public void wstan(){
        System.out.println("Uczen wstaje");
    }
    public void uczSie(){
        System.out.println("Uczen sie uczy");
    }
    public void odrobLekcje(){
        System.out.println("Uczen odrabia lekcje");
    }
    public void idzDoSzkoly(){
        System.out.println("Uczen idzie do szkoly");
    }
    public void wrocDoDomu(){
        System.out.println("Uczen wraca do domu");
    }
}

class Student extends Dziecko implements podstawowy, studia{
    void zabawa(){
        System.out.println("Student bawi sie");
    }
    void obowiazki(){
        System.out.println("Student ma obowiazki");
    }
    public void jedz(){
        System.out.println("Student je");
    }
    public void pij(){
        System.out.println("Student pije");
    }
    public void spij(){
        System.out.println("Student spi");
    }
    public void wstan(){
        System.out.println("Student wstaje");
    }
    public void studiuj(){
        System.out.println("Student studiuje");
    }
    public void nieIdzNaZajecia(){
        System.out.println("Student nie idzie na zajecia");
    }
    public void idzNaWyklad(){
        System.out.println("Student idzie na wyklad");
    }
    public void idzNaCwiczenia(){
        System.out.println("Student idzie na cwiczenia");
    }
}

class Emeryt extends Dorosly implements podstawowy, emerytura{
    void zabawa(){
        System.out.println("Emeryt bawi sie");
    }
    void obowiazki(){
        System.out.println("Emeryt ma obowiazki");
    }
    public void jedz(){
        System.out.println("Emeryt je");
    }
    public void pij(){
        System.out.println("Emeryt pije");
    }
    public void spij(){
        System.out.println("Emeryt spi");
    }
    public void wstan(){
        System.out.println("Emeryt wstaje");
    }
    public void odbierzEmeryture(){
        System.out.println("Emeryt odbiera emeryture");
    }
    public void idzDoLekarza(){
        System.out.println("Emeryt idzie do lekarza");
    }
    public void idzNaRynek(){
        System.out.println("Emeryt idzie na rynek");
    }
    public void idzPoLeki(){
        System.out.println("Emeryt idzie po leki");
    }
}



public class czlowiek 
{
    public static void main( String[] args )
    {
        Uczen uczen = new Uczen();
        Student student = new Student();
        Emeryt emeryt = new Emeryt();

        uczen.jedz();
        uczen.pij();
        uczen.spij();
        uczen.wstan();
        uczen.uczSie();
        uczen.odrobLekcje();
        uczen.idzDoSzkoly();
        uczen.wrocDoDomu();
        uczen.zabawa();
        uczen.obowiazki();
        uczen.szkola();
        uczen.nauka();
        uczen.ileLat();
        uczen.cechy();

        student.jedz();
        student.pij();
        student.spij();
        student.wstan();
        student.studiuj();
        student.nieIdzNaZajecia();
        student.idzNaWyklad();
        student.idzNaCwiczenia();
        student.zabawa();
        student.obowiazki();
        student.ileLat();
        student.cechy();

        emeryt.jedz();
        emeryt.pij();
        emeryt.spij();
        emeryt.wstan();
        emeryt.odbierzEmeryture();
        emeryt.idzDoLekarza();
        emeryt.idzNaRynek();
        emeryt.idzPoLeki();
        emeryt.zabawa();
        emeryt.obowiazki();
        emeryt.praca();
        emeryt.podatki();
        emeryt.ileLat();
        emeryt.cechy();
    }
}
