package lab5;

import java.awt.Color;

class Figura{
    protected
        int pole;
        int obwod;
    private
        Color kolor;
    protected
        void rysuj(){}
        void przesun(){}
        void usun(){}

    Figura(int pole, int obwod, Color kolor){
        this.pole = pole;
        this.obwod = obwod;
        this.kolor = kolor;
    }
    Figura(){
        this.pole = 0;
        this.obwod = 0;
        this.kolor = Color.BLACK;
    }
    public int getPole() {
        return pole;
    }

    public void setPole(int pole) {
        this.pole = pole;
    }

    public int getObwod() {
        return obwod;
    }

    public void setObwod(int obwod) {
        this.obwod = obwod;
    }

    public Color getKolor() {
        return kolor;
    }

    public void setKolor(Color kolor) {
        this.kolor = kolor;
    }
}

class Elipsa extends Figura{
    private
        int a;
        int b;
        int f1x;
        int f1y;
        int f2x;
        int f2y;
        int c;
    Elipsa(int a, int b, int f1x, int f1y, int f2x, int f2y, int c){
        this.a = a;
        this.b = b;
        this.f1x = f1x;
        this.f1y = f1y;
        this.f2x = f2x;
        this.f2y = f2y;
        this.c = c;
    }
    Elipsa(){
        this.a = 0;
        this.b = 0;
        this.f1x = 0;
        this.f1y = 0;
        this.f2x = 0;
        this.f2y = 0;
        this.c = 0;
    }
    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }
    public int getB() {
        return b;
    }
    public void setB(int b) {
        this.b = b;
    }
    public int getF1x() {
        return f1x;
    }
    public void setF1x(int f1x) {
        this.f1x = f1x;
    }
    public int getF1y() {
        return f1y;
    }
    public void setF1y(int f1y) {
        this.f1y = f1y;
    }
    public int getF2x() {
        return f2x;
    }
    public void setF2x(int f2x) {
        this.f2x = f2x;
    }
    public int getF2y() {
        return f2y;
    }
    public void setF2y(int f2y) {
        this.f2y = f2y;
    }
    public int getC() {
        return c;
    }
    public void obliczC(){
        this.c = (int)Math.sqrt(a*a - b*b);
    } 
}

class Wielokat extends Figura{
    protected
        int iloscBokow;
        int iloscWierzcholkow;
        int sumaKatowWewnetrznych;
    Wielokat(int iloscBokow, int iloscWierzcholkow, int sumaKatowWewnetrznych){
        this.iloscBokow = iloscBokow;
        this.iloscWierzcholkow = iloscWierzcholkow;
        this.sumaKatowWewnetrznych = sumaKatowWewnetrznych;
    }
    Wielokat(){
        this.iloscBokow = 0;
        this.iloscWierzcholkow = 0;
        this.sumaKatowWewnetrznych = 0;
    }
    public int getIloscBokow() {
        return iloscBokow;
    }
    public void setIloscBokow(int iloscBokow) {
        this.iloscBokow = iloscBokow;
    }
    public int getIloscWierzcholkow() {
        return iloscWierzcholkow;
    }
    public void setIloscWierzcholkow(int iloscWierzcholkow) {
        this.iloscWierzcholkow = iloscWierzcholkow;
    }
    public int obliczSumaKatowWewnetrznych(){
        return (iloscBokow - 2) * 180;
    }
}

class Okrag extends Elipsa{
    private
        int r;
        int srodekX;
        int srodekY;
    Okrag(int r, int srodekX, int srodekY){
        this.r = r;
        this.srodekX = srodekX;
        this.srodekY = srodekY;
    }
    Okrag(){
        this.r = 0;
        this.srodekX = 0;
        this.srodekY = 0;
    }
    public int getR() {
        return r;
    }
    public void setR(int r) {
        this.r = r;
    }
    public int getSrodekX() {
        return srodekX;
    }
    public void setSrodekX(int srodekX) {
        this.srodekX = srodekX;
    }
    public int getSrodekY() {
        return srodekY;
    }
    public void setSrodekY(int srodekY) {
        this.srodekY = srodekY;
    }
    public void obliczObwod(){
        this.obwod = (int)(2 * Math.PI * r);
    }
    public void obliczPole(){
        this.pole = (int)(Math.PI * r * r);
    }
}

class Trojkat extends Wielokat{
    private
        int a;
        int h;
    Trojkat(int a, int h){
        this.a = a;
        this.h = h;
    }
    Trojkat(){
        this.a = 0;
        this.h = 0;
    }
    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }
    public int getH() {
        return h;
    }
    public void setH(int h) {
        this.h = h;
    }
    public void obliczPole(){
        this.pole = (int)(0.5 * a * h);
    }
    public void obliczObwod(){
        this.obwod = 3 * a;
    }
}

class Kwadrat extends Wielokat{
    private
        int a;
    Kwadrat(int a){
        this.a = a;
    }
    Kwadrat(){
        this.a = 0;
    }
    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }
    public void obliczPole(){
        this.pole = a * a;
    }
    public void obliczObwod(){
        this.obwod = 4 * a;
    }
}

public class figura
{
    public static void main( String[] args )
    {
        Okrag okrag = new Okrag(5, 0, 0);
        okrag.obliczPole();
        okrag.obliczObwod();
        System.out.println("Pole okregu: " + okrag.getPole());
        System.out.println("Obwod okregu: " + okrag.getObwod());
        Kwadrat kwadrat = new Kwadrat(5);
        kwadrat.obliczPole();
        kwadrat.obliczObwod();
        System.out.println("Pole kwadratu: " + kwadrat.getPole());
        System.out.println("Obwod kwadratu: " + kwadrat.getObwod());
        Trojkat trojkat = new Trojkat(5, 5);
        trojkat.obliczPole();
        trojkat.obliczObwod();
        System.out.println("Pole trojkata: " + trojkat.getPole());
        System.out.println("Obwod trojkata: " + trojkat.getObwod());
    }
}
