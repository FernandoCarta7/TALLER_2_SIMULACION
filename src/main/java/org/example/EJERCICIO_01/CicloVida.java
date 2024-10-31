package org.example.EJERCICIO_01;

import java.util.ArrayList;
import java.util.List;

public class CicloVida {


    public static void main(String[] args) {
        int a = 21,c = 15,m = 31,x0 = 21;

        System.out.printf("PUNTO A ");
        periodoDeVida(21,15,31,21);
        System.out.printf("PUNTO B ");
        periodoDeVida(13,9,128,7);
        System.out.printf("PUNTO C ");
        periodoDeVida(17,0,31,23);
        System.out.printf("PUNTO D ");
        periodoDeVida(121,1,256,17);
    }

    public static void periodoDeVida(int a, int c, int m, int x0){
        List<Integer> residuos = new ArrayList<>();

        int xi = x0;

        do {
            xi = ( ( a * xi ) + c ) % m;

            if ( residuos.size() != 0 ){
                /*Validar que el xi NO este en la lista de residuos para agregar
                    en caso de que esté el valor hacemos bandera = true
                * */
                residuos.add(xi);

            }else {
                residuos.add(xi);
            }
        }while ( !residuos.contains(x0) );

            System.out.printf("Ciclo de vida: " + residuos.size() + " iteraciones" + "\n");

    }
}
