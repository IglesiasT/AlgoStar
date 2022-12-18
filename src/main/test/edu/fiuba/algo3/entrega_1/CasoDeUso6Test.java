package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Criadero;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import org.junit.jupiter.api.Test;

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
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);

        ArrayList<? extends Casillero> casillerosConMoho =
                mapa.obtenerCasilleros(5,1, 1);

        // Assert
        for (Casillero casillero : casillerosConMoho){
            assert !casillero.puedeMoverse(new AreaTerrestre()) || (casillero.contiene(new Moho()));
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
        boolean todosContienenMoho = false;

        // Act
        recursos.agregar(new Mineral(2000));
        casillero1.setEspacioDeConstruccion(new Moho());
        criadero.construir(casillero1, recursos);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);

        criadero.nuevoTurno(raza);

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
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);

        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);

        ArrayList<? extends Casillero> casillerosConMoho =
                mapa.obtenerCasilleros(6,1,1);

        //Assert
        for (Casillero casillero : casillerosConMoho){
            assert !casillero.puedeMoverse(new AreaTerrestre()) || (casillero.contiene(new Moho()));
        }
    }
}
