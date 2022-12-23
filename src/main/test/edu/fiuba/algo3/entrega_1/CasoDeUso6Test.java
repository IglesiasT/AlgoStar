package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Criadero;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Extractor;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.CasilleroSinMoho;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class CasoDeUso6Test {

    @Test
    public void alConstruirElCriaderoEsteCreaUnRadioDeMohoDe5(){
        // Arrange
        Mapa mapa = new Mapa();
        Raza raza = new Zerg();
        Casillero casillero1 = mapa.obtenerCasillero(1, 1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        Criadero criadero = new Criadero();
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral(2000));
        casillero1.setEspacioDeConstruccion(new Moho());
        criadero.construir(casillero1, recursos);

        ArrayList<? extends Casillero> casillerosConMoho = mapa.obtenerCasilleros(5,1, 1);
        casillerosConMoho.remove(casillero1);
        for (Casillero casillero : casillerosConMoho){
            casillero.setArea(new AreaTerrestre());
            casillero.setRecurso(new SinRecurso());
        }


        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);




        // Assert
        for (Casillero casillero : casillerosConMoho){
            assertDoesNotThrow(() ->casillero.establecerConstruccion(new ReservaDeReproduccion()));
        }

    }

    @Test
    public void alConstruirElCriaderoEsteCreaUnRadioDeMohoDe5YLuegoDeUnTurnoNoSeExpande(){
        //Arrange
        Mapa mapa = new Mapa();
        Raza raza = new Zerg();
        Casillero casillero1 = mapa.obtenerCasillero(1, 1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        Criadero criadero = new Criadero();
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral(2000));
        casillero1.setEspacioDeConstruccion(new Moho());
        criadero.construir(casillero1, recursos);

        ArrayList<? extends Casillero> casillerosConMoho = mapa.obtenerCasilleros(6,1, 1);
        casillerosConMoho.remove(casillero1);
        for (Casillero casillero : casillerosConMoho){
            casillero.setArea(new AreaTerrestre());
            casillero.setRecurso(new SinRecurso());
        }

        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);

        criadero.nuevoTurno(raza);


        //Assert
        assertThrows(CasilleroSinMoho.class,() -> {
            for (Casillero casillero : casillerosConMoho) {
                casillero.establecerConstruccion(new ReservaDeReproduccion());
            }
        });

    }

    @Test
    public void alConstruirElCriaderoEsteCreaUnRadioDeMohoDe5YLuegoDeDosTurnosSeExpande(){
        //Arrange
        Mapa mapa = new Mapa();
        Raza raza = new Zerg();
        Casillero casillero1 = mapa.obtenerCasillero(1, 1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        Criadero criadero = new Criadero();
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral(2000));
        casillero1.setEspacioDeConstruccion(new Moho());
        criadero.construir(casillero1, recursos);

        ArrayList<? extends Casillero> casillerosConMoho = mapa.obtenerCasilleros(6,1, 1);
        casillerosConMoho.remove(casillero1);
        for (Casillero casillero : casillerosConMoho){
            casillero.setArea(new AreaTerrestre());
            casillero.setRecurso(new SinRecurso());
        }

        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);

        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);


        //Assert
        for (Casillero casillero : casillerosConMoho){
            assertDoesNotThrow(() ->casillero.establecerConstruccion(new ReservaDeReproduccion()));
        }
    }
}
