package org.example.EJERCICIO_4;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio4 {
    /*Realizar la prueba de uniformidad a los primeros 100 números
    * aleatoris de los siguientes generadores
    *   xi+1 = (1117 · xi + 3057) mod 1679567; semilla 1457
    *   xi+1 = (2177 · xi + 2367)) mod 1351867; semilla 1117
    * */

    public static void main(String[] args) {

        int a = 1117, c = 2057, m = 1679567, x0 = 1457, iteraciones = 100;
        
        var listaA =periodoDeVida(a,c,m,x0,iteraciones);

        a = 2177; c = 2367; m = 1351867; x0 = 1117;
        periodoDeVida(a,c,m,x0,iteraciones);
    }


    public static List<Double> periodoDeVida(int a, int c, int m, int x0, int iteraciones){

        List<Integer> residuos = new ArrayList<>();
        List<Double> pseudoAleatorios = new ArrayList<>();

        int xi = x0;
        double ri = 0;


        for (int i = 0; i < iteraciones; i++) {
            xi = ( ( a * xi ) + c ) % m;
            ri = ( xi ) / ( m - 1 );
            residuos.add(xi);
            pseudoAleatorios.add(ri);
            //residuos.sort((Integer p, Integer l) -> p.compareTo(l));

        }
        System.out.println("Ciclo de vida: " + residuos.size() + " iteraciones");
        return pseudoAleatorios;
    }
}
