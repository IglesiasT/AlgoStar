package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Criadero;
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
        Casillero casillero1 = mapa.obtenerCasillero(1, 1);
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

        ArrayList<? extends Casillero> casillerosConMoho =
                mapa.obtenerCasilleros(5,1, 1);

        // Assert
        for (Casillero casillero : casillerosConMoho){
            assert (casillero.contiene(new Moho()));
        }

    }

    @Test
    public void alConstruirElCriaderoEsteCreaUnRadioDeMohoDe5YLuegoDeUnTurnoNoSeExpande(){
        //Arrange
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1, 1);
        Criadero criadero = new Criadero();
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        boolean todosContienenMoho = false;

        // Act
        recursos.agregar(new Mineral());
        casillero1.setEspacioDeConstruccion(new Moho());
        criadero.construir(casillero1, recursos);
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();

        criadero.nuevoTurno();

        ArrayList<? extends Casillero> casillerosConMoho =
                mapa.obtenerCasilleros(6,1, 1);

        //Assert
        for (Casillero casillero : casillerosConMoho){
           todosContienenMoho = (casillero.contiene(new Moho()));
           if (!todosContienenMoho)
               break;
        }

        assert !todosContienenMoho;

    }

    @Test
    public void alConstruirElCriaderoEsteCreaUnRadioDeMohoDe5YLuegoDeDosTurnosSeExpande(){
        //Arrange
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1, 1);
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

        ArrayList<? extends Casillero> casillerosConMoho =
                mapa.obtenerCasilleros(6,1,1);

        //Assert
        for (Casillero casillero : casillerosConMoho){
            assert (casillero.contiene(new Moho()));
        }
    }
}
