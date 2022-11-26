package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.construcciones.Criadero;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CasoDeUso6Test {

    @Test
    public void alConstruirElCriaderoEsteCreaUnRadioDeMohoDe5(){
        // Arrange
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(10,10);
        Criadero criadero = new Criadero();
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        casillero1.setEspacioDeConstruccion(new Moho());
        criadero.construir(casillero1, recursos);
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();

        ArrayList<? extends Casillero> casillerosConMoho = mapa.obtenerCasilleros(5,10,10);

        // Assert
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
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(10,10);
        Criadero criadero = new Criadero();
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        casillero1.setEspacioDeConstruccion(new Moho());
        criadero.construir(casillero1, recursos);
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();

        criadero.nuevoTurno();


        //Assert
        for (int i = 0; i < 20; i++){
            assert !(mapa.obtenerCasillero(limiteDeFilaInferiorEsperado,i).contiene(new Moho()));
            assert !(mapa.obtenerCasillero(limiteDeFilaSuperionEsperado,i).contiene(new Moho()));
            assert !(mapa.obtenerCasillero(i,limiteDeColumnaInferiorEsperado).contiene(new Moho()));
            assert !(mapa.obtenerCasillero(i,limiteDeColumnaSuperionEsperado).contiene(new Moho()));
        }

    }

    @Test
    public void alConstruirElCriaderoEsteCreaUnRadioDeMohoDe5YLuegoDeDosTurnosSeExpande(){
        //Arrange
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(10,10);
        Criadero criadero = new Criadero();
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        casillero1.setEspacioDeConstruccion(new Moho());
        criadero.construir(casillero1, recursos);
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();

        criadero.nuevoTurno();
        criadero.nuevoTurno();

        ArrayList<? extends Casillero> casillerosConMoho = mapa.obtenerCasilleros(6,10,10);

        //Assert
        for (Casillero casillero : casillerosConMoho){
            assert (casillero.contiene(new Moho()));
        }
    }
}
