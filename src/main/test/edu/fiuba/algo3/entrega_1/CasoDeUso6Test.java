package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.construcciones.Criadero;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.tablero.Casillero;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CasoDeUso6Test {

    @Test
    public void alConstruirElCriaderoEsteCreaUnRadioDeMohoDe5(){
        //Arrange
        Tablero tablero = new Tablero();
        Casillero casillero1 = tablero.obtenerCasillero(10,10);
        Criadero criadero = new Criadero();

        //Act
        criadero.construirEnCasillero(casillero1);
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();

        ArrayList<? extends Casillero> casillerosConMoho = tablero.obtenerCasilleros(5,10,10);

        //Assert
        for (Casillero casillero : casillerosConMoho){
            assert (casillero.contiene(new Moho()));
        }

    }

    @Test
    public void alConstruirElCriaderoEsteCreaUnRadioDeMohoDe5YLuegoDeUnTurnoNoSeExpande(){
        //Arrange
        int limiteDeFilaInferiorEsperado = 4;
        int limiteDeFilaSuperionEsperado = 16;
        int limiteDeColumnaInferiorEsperado = 4;
        int limiteDeColumnaSuperionEsperado = 16;
        Tablero tablero = new Tablero();
        Casillero casillero1 = tablero.obtenerCasillero(10,10);
        Criadero criadero = new Criadero();

        //Act
        criadero.construirEnCasillero(casillero1);
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();

        criadero.nuevoTurno();


        //Assert
        for (int i = 0; i < 20; i++){
            assert !(tablero.obtenerCasillero(limiteDeFilaInferiorEsperado,i).contiene(new Moho()));
            assert !(tablero.obtenerCasillero(limiteDeFilaSuperionEsperado,i).contiene(new Moho()));
            assert !(tablero.obtenerCasillero(i,limiteDeColumnaInferiorEsperado).contiene(new Moho()));
            assert !(tablero.obtenerCasillero(i,limiteDeColumnaSuperionEsperado).contiene(new Moho()));
        }

    }

    @Test
    public void alConstruirElCriaderoEsteCreaUnRadioDeMohoDe5YLuegoDeDosTurnosSeExpande(){
        //Arrange
        Tablero tablero = new Tablero();
        Casillero casillero1 = tablero.obtenerCasillero(10,10);
        Criadero criadero = new Criadero();

        //Act
        criadero.construirEnCasillero(casillero1);
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();

        criadero.nuevoTurno();
        criadero.nuevoTurno();

        ArrayList<? extends Casillero> casillerosConMoho = tablero.obtenerCasilleros(6,10,10);

        //Assert
        for (Casillero casillero : casillerosConMoho){
            assert (casillero.contiene(new Moho()));
        }
    }
}
