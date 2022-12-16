package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.jugador.DatosRepetidos;
import edu.fiuba.algo3.modelo.jugador.NombreInvalido;
import edu.fiuba.algo3.modelo.jugador.RazaInvalida;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso25Test {
    //requisitos para crear a los jugadores

    @Test
    public void noSePuedeCrearJugadorConNombreInvalido(){
        assertThrows(NombreInvalido.class, () -> new Jugador("Ampi" , Color.BLUE, "Zerg") );
    }

    @Test
    public void noSePuedeCrearJugadorConRazaInvalida(){
        assertThrows(RazaInvalida.class, () -> new Jugador("Amparo" , Color.BLUE , "Zer") );
    }

    @Test
    public void noSePuedenCrearDosJugadoresConElMismoNombreEnUnJuego () {

        AlgoStar juego = new AlgoStar();
        juego.agregarJugadorUno("Amparo" , Color.BLUE, "Zerg");

        assertThrows(DatosRepetidos.class, () -> juego.agregarJugadorDos("Amparo" , Color.RED, "Protoss"));
    }

    @Test
    public void noSePuedenCrearDosJugadoresConElMismoColorEnUnJuego () {

        AlgoStar juego = new AlgoStar();
        juego.agregarJugadorUno("Amparo" , Color.BLUE, "Zerg");

        assertThrows(DatosRepetidos.class, () -> juego.agregarJugadorDos("Mariaa" , Color.BLUE, "Protoss"));
    }

    @Test
    public void noSePuedenCrearDosJugadoresConLaMismaRazaEnUnJuego () {

        AlgoStar juego = new AlgoStar();
        juego.agregarJugadorUno("Amparo" , Color.BLUE, "Zerg");

        assertThrows(DatosRepetidos.class, () -> juego.agregarJugadorDos("Mariaa" , Color.RED, "Zerg"));
    }

    @Test
    public void sePuedeCrearLosJugadoresConDatosValidos() {
        AlgoStar juego = new AlgoStar();
        juego.agregarJugadorUno("Amparo" , Color.BLUE, "Zerg");

        assertDoesNotThrow(() -> juego.agregarJugadorDos("Mariaa" , Color.RED, "Protoss"));

    }
}
