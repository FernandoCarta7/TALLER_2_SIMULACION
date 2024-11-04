package org.example.EJERCICIO_01;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CicloVida {


    public static void main(String[] args) {

        System.out.println("--------------------PUNTO A-------------------- ");
        periodoDeVida(21,15,31,21);

        System.out.println("--------------------PUNTO B-------------------- ");
        periodoDeVida(13,9,128,7);

        System.out.println("--------------------PUNTO C-------------------- ");
        periodoDeVida(17,31,23);

        System.out.println("--------------------PUNTO D-------------------- ");
        periodoDeVida(121,256,17, false);
    }

    public static void periodoDeVida(int a, int c, int m, int x0){

        List<Integer> residuos = new ArrayList<>();
        List<Double> aleatorios = new ArrayList<>();
        double aleatorio;

        int xi = ( ( a * x0 ) + c ) % m;
        residuos.add(xi); //Lista de xi
        aleatorio = (double) (xi) / ( m - 1 );
        aleatorios.add(aleatorio);
        DecimalFormat df = new DecimalFormat("#.0000");

        xi = ( ( a * xi ) + c ) % m;
        aleatorio = (double) (xi) / ( m - 1 );

        while ( !residuos.contains(xi)  ){
            residuos.add(xi);
            aleatorios.add(aleatorio); //Lista de ri

            xi = ( ( a * xi ) + c ) % m;
            aleatorio = (double) xi / ( m - 1 );

        }
        //residuos.sort((Integer l, Integer b) -> l.compareTo(b));
        System.out.println("Ciclo de vida: " + residuos.size() + " iteraciones");
        for (int i = 0; i < aleatorios.size(); i++) {
            if (aleatorios.get(i) >= 1) {
                System.out.println(" r" + i + ": " + df.format(aleatorios.get(i)) + "\t x" + i + ": " + xi);
            }else {
                System.out.println(" r" + (i + 1) + ": 0" + df.format(aleatorios.get(i)) + "\t x" + (i + 1) + ": " + residuos.get(i));
            }
        }

    }
    public static void periodoDeVida(int a, int m, int x0){

        List<Integer> residuos = new ArrayList<>();
        List<Double> aleatorios = new ArrayList<>();
        double aleatorio;

        int xi = (  a * x0  ) % m;
        residuos.add(xi); //Lista de xi
        aleatorio = (double) (xi) / ( m - 1 );
        aleatorios.add(aleatorio);
        DecimalFormat df = new DecimalFormat("#.0000");

        xi = (  a * xi  ) % m;
        aleatorio = (double) (xi) / ( m - 1 );

        while ( !residuos.contains(xi)  ){
            residuos.add(xi);
            aleatorios.add(aleatorio); //Lista de ri

            xi = (  a * xi  ) % m;
            aleatorio = (double) xi / ( m - 1 );

        }
        //residuos.sort((Integer l, Integer b) -> l.compareTo(b));
        System.out.println("Ciclo de vida: " + residuos.size() + " iteraciones");
        for (int i = 0; i < aleatorios.size(); i++) {
            if (aleatorios.get(i) >= 1) {
                System.out.println(" r" + i + ": " + df.format(aleatorios.get(i)) + "\t x" + i + ": " + xi);
            }else {
                System.out.println(" r" + (i + 1) + ": 0" + df.format(aleatorios.get(i)) + "\t x" + (i + 1) + ": " + residuos.get(i));
            }
        }

    }
    public static void periodoDeVida(int a, int m, int x0, boolean bandera){

        List<Integer> residuos = new ArrayList<>();
        List<Double> aleatorios = new ArrayList<>();
        double aleatorio;

        int xi = ( a + x0  ) % m;
        residuos.add(xi); //Lista de xi
        aleatorio = (double) (xi) / ( m - 1 );
        aleatorios.add(aleatorio);
        DecimalFormat df = new DecimalFormat("#.0000");

        xi = (  a + xi ) % m;
        aleatorio = (double) (xi) / ( m - 1 );

        while ( !residuos.contains(xi)  ){
            residuos.add(xi);
            aleatorios.add(aleatorio); //Lista de ri

            xi = ( a + xi ) % m;
            aleatorio = (double) xi / ( m - 1 );

        }
        //residuos.sort((Integer l, Integer b) -> l.compareTo(b));
        System.out.println("Ciclo de vida: " + residuos.size() + " iteraciones");
        for (int i = 0; i < aleatorios.size(); i++) {
            if (aleatorios.get(i) >= 1) {
                System.out.println(" r" + i + ": " + df.format(aleatorios.get(i)) + "\t x" + i + ": " + xi);
            }else {
                System.out.println(" r" + (i + 1) + ": 0" + df.format(aleatorios.get(i)) + "\t x" + (i + 1) + ": " + residuos.get(i));
            }
        }

    }

}
