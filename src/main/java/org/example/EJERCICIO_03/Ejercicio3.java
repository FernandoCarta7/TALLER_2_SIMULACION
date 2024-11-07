package org.example.EJERCICIO_03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class Ejercicio3 {
    public static void main(String[] args) {

        List<Double> listaXi = periodoDeVida(121,553,177,23);
        double [][] histograma = histograma(listaXi);
        pruebaChiCuadrada(histograma, 177, listaXi.size());

    }

    public static List<Double> periodoDeVida(int a, int c, int m, int x0){

        List<Integer> residuos = new ArrayList<>();
        List<Double> aleatorios = new ArrayList<>();


        int xi = ( ( a * x0 ) + c ) % m;
        double ri = (double) xi/( m - 1 );

        do{
            residuos.add(xi);
            aleatorios.add(ri);

            xi = ( (a * xi) + c ) % m;
            ri = (double) xi/( m - 1 );
        }while (!residuos.contains(xi));

        System.out.println("Ciclo de vida: " + residuos.size() + " iteraciones");
        pruebaMedia(aleatorios,m);


        return aleatorios;
    }

    public static void pruebaMedia(List<Double> residuos, int m){
        double media = media(residuos);
        double acumulador = 0;
        double restaCuadrado = 0.0;
        double varianza = 0.0;

        for (int i = 0; i < residuos.size(); i++) {
            restaCuadrado = residuos.get(i) - media;
            restaCuadrado = restaCuadrado*restaCuadrado;
            acumulador = acumulador + restaCuadrado;
        }
        varianza = acumulador / (residuos.size() - 1);
        System.out.println("Varianza : " + varianza);

        
    }

    public static double media(List<Double> lista){
        double media = 0.0;
        for (int i = 0; i < lista.size(); i++) {
            media = media + lista.get(i);
        }
        media = media / lista.size();
        System.out.println("Media : " + media);
        return media;
    }

    public static double [][] histograma( List<Double> listaXi ){

        double menor = Double.MAX_VALUE;
        double mayor = Double.MIN_VALUE;
        double rango = 0.0;
        int intervalos = 0;
        double anchoIntervalo = 0.0; //w
        double [] intervalo; //Aqui voy a guardar en cada posición cuantos datos hay en cada intervalo
        double posInt = 0.0;
        int [] frecuencia;
        double [][] histograma;

        for (int i = 0; i < listaXi.size(); i++) {
            if (menor > listaXi.get(i)) {
                menor = listaXi.get(i);
            }
            if(mayor < listaXi.get(i)){
                mayor = listaXi.get(i);
            }
        }
        rango = mayor - menor;
        intervalos = (int) Math.sqrt(listaXi.size());
        anchoIntervalo = rango / intervalos; //w
        posInt = menor + anchoIntervalo;

        //Creación intervalos
        intervalo = new double[intervalos + 1];
        intervalo [0] = menor;
        for (int i = 1; i < intervalo.length; i++) {
            intervalo [i] = intervalo[i-1] + anchoIntervalo;
        }

        //Calculo de la frecuencia
        frecuencia = new int[intervalos + 1];
        for (int i = 0; i < intervalo.length; i++) {

            for (int j = 0; j < listaXi.size(); j++) {
                if (i == 0){
                    if (listaXi.get(j) <= intervalo[i]){
                        frecuencia[i] = frecuencia[i] + 1;
                    }
                } else {
                    if ( (intervalo[ i - 1 ] < listaXi.get(j)) && (listaXi.get(j) <= intervalo[i])){
                        frecuencia[i] = frecuencia[i] + 1;
                    }
                }

            }
        }
        histograma = new double[2][intervalo.length];

        for (int i = 0; i < histograma.length; i++) {
            for (int j = 0; j < histograma[0].length; j++) {
                if ( i == 0 ) histograma[i][j] = frecuencia[j];
                else  histograma[i][j] = intervalo[j];
            }
        }

        for (int i = 0; i < listaXi.size(); i++) {
            System.out.printf(listaXi.get(i) + ", ");
        }
        return histograma;
    }

    public static double pruebaChiCuadrada( double[][] histograma, int m, int sizeXi ){

        int k = histograma[0].length; // Tamaño del intervalo de la frecuencia
        double frecuenciaEsperada = (double) (sizeXi) / k; //Cantidad de datos / intervalo de la frecuencia
        double restaFrecuencias = 0.0;
        double sumatoria = 0.0;

        //int gradoLibertad = k-1;

        for (int i = 0; i < k ; i++) {
            restaFrecuencias = histograma[0][i] - frecuenciaEsperada;
            restaFrecuencias = restaFrecuencias * restaFrecuencias;
            sumatoria = sumatoria + ( restaFrecuencias / frecuenciaEsperada);
        }
        System.out.println("\n\t Prueba chi cuadrada x^2 : " + sumatoria);


        return sumatoria;
    }
}
