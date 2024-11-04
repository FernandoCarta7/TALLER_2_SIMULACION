package org.example.EJERCICIO_02;

import org.example.EJERCICIO_01.CicloVida;

import java.util.ArrayList;
import java.util.List;

public class CicloVida2 {
    public static void main(String[] args) {
        //periodoDeVida(137,47,17,301," A "); // X0 = 30 escogido arbitrariamente
        periodoDeVida(191,17,23,23, " B "); // X0 = 15 escogido arbitrariamente
        //periodoDeVida(237,71,37,195, " C "); // X0 = 19 escogido arbitrariamente
        //periodoDeVida(117,31,19,57, " D "); // X0 = 5 escogido arbitrariamente
        //periodoDeVida(157,47,37,99, " E "); // X0 = 9 escogido arbitrariamente
        //periodoDeVida(321,11,27,177, " F "); // X0 = 17 escogido arbitrariamente

    }
    //xi = ( ( a * xi ) + c ) % m;
    public static void periodoDeVida(int a, int c, int m, int x0, String inciso){

        List<Integer> residuos = new ArrayList<>();
        List<Double> pseudoAleatorios = new ArrayList<>();

        int xi = 0;
        double ri = 0;

        xi = ( ( a * xi ) + c ) % m;
        ri = ( xi ) / ( m - 1 );
        while ( !residuos.contains(xi) ){

            residuos.add(xi);
            pseudoAleatorios.add(ri);

            xi = ( ( a * xi ) + c ) % m;
            ri = ( xi ) / ( m - 1 );
            //residuos.sort((Integer p, Integer l) -> p.compareTo(l));
        }

        System.out.println("Inciso -" + inciso + "- ciclo de vida: " + residuos.size() + " iteraciones");
    }

}
