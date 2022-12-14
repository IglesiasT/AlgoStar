package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Criadero;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso1Test {

    @Test
    public void criaderoSeIniciaConTresLarvas() {
        // Arrange
        int valorEsperado = 3;
        Criadero criadero = new Criadero();

        // Act and Assert
        assertEquals(valorEsperado, criadero.larvasRestantes());
    }

    @Test
    public void engendroUnZanganoYConsumeUnaLarva(){
        // Arrange
        int valorEsperado = 2;
        Criadero criadero = new Criadero();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        Raza raza = new Zerg();

        // Act
        recursos.agregar(new Mineral(225));
        criadero.construir(casillero, recursos);

        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);

        criadero.engendrarZangano(recursos);

        // Assert
        assertEquals(valorEsperado, criadero.larvasRestantes());
    }

    @Test
    public void engendroUnZanganoPasaUnTurnoYVuelveAEstarLlenoElCriadero(){
        // Arrange
        int valorEsperado = 3;
        Criadero criadero = new Criadero();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        Raza raza = new Zerg();

        // Act
        recursos.agregar(new Mineral(225));

        criadero.construir(casillero, recursos);

        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);

        criadero.engendrarZangano(recursos);
        criadero.nuevoTurno(raza);

        // Assert
        assertEquals(valorEsperado, criadero.larvasRestantes());

    }

    @Test
    public void engendroDosZanganosPasaUnTurnoYSeRegeneraUnaLarvaDelCriadero(){
        // Arrange
        int valorEsperado = 2;
        Criadero criadero = new Criadero();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        Raza raza = new Zerg();

        // Act
        recursos.agregar(new Mineral(250));
        criadero.construir(casillero, recursos);


        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);

        criadero.engendrarZangano(recursos);
        criadero.engendrarZangano(recursos);
        criadero.nuevoTurno(raza);


        // Assert
        assertEquals(valorEsperado, criadero.larvasRestantes());

    }

    @Test
    public void engendroDosZanganosPasanDosTurnosYVuelveAEstarLlenoElCriadero(){
        //Arrange
        int valorEsperado = 3;
        Criadero criadero = new Criadero();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        Raza raza = new Zerg();

        // Act
        recursos.agregar(new Mineral(250));
        criadero.construir(casillero, recursos);

        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);

        criadero.engendrarZangano(recursos);
        criadero.engendrarZangano(recursos);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);


        //Assert
        assertEquals(valorEsperado, criadero.larvasRestantes());

    }

    @Test
    public void engendroTresZanganosPasaUnTurnoYSeRegeneraUnaLarvaDelCriadero(){
        //Arrange
        int valorEsperado = 1;
        Criadero criadero = new Criadero();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        Raza raza = new Zerg();

        // Act
        recursos.agregar(new Mineral(275));
        criadero.construir(casillero, recursos);

        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);


        criadero.engendrarZangano(recursos);
        criadero.engendrarZangano(recursos);
        criadero.engendrarZangano(recursos);

        criadero.nuevoTurno(raza);

        //Assert
        assertEquals(valorEsperado, criadero.larvasRestantes());

    }

    @Test
    public void engendroTresZanganosPasaUnTurnoYVuelveAEstarLlenoElCriadero(){
        //Arrange
        int valorEsperado = 3;
        Criadero criadero = new Criadero();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        Raza raza = new Zerg();

        // Act
        recursos.agregar(new Mineral(275));
        criadero.construir(casillero, recursos);

        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);


        criadero.engendrarZangano(recursos);
        criadero.engendrarZangano(recursos);
        criadero.engendrarZangano(recursos);

        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);


        //Assert
        assertEquals(valorEsperado, criadero.larvasRestantes());

    }
}
