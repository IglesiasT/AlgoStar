package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso25Test {
    //requisitos para crear a los jugadores

    @Test
    public void noSePuedeCrearJugadorConNombreInvalido(){
        assertThrows(NombreInvalido.class, () -> new Jugador("Ampi" , "Violeta" , "Zerg") );
    }

    @Test
    public void noSePuedeCrearJugadorConRazaInvalida(){
        assertThrows(RazaInvalida.class, () -> new Jugador("Amparo" , "Violeta" , "Zer") );
    }

    @Test
    public void noSePuedenCrearDosJugadoresConElMismoNombreEnUnJuego () {

        AlgoStar juego = new AlgoStar();
        String input = "Amparo\nVioleta\nZerg\nAmparo\nRojo\nProtoss\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(DatosRepetidos.class, () -> juego.comenzarJuego());
    }

    @Test
    public void noSePuedenCrearDosJugadoresConElMismoColorEnUnJuego () {

        AlgoStar juego = new AlgoStar();
        String input = "Amparo\nVioleta\nZerg\nAmparo Maria\nVioleta\nProtoss\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(DatosRepetidos.class, () -> juego.comenzarJuego());
    }

    @Test
    public void noSePuedenCrearDosJugadoresConLaMismaRazaEnUnJuego () {

        AlgoStar juego = new AlgoStar();
        String input = "Amparo\nVioleta\nZerg\nAmparo Maria\nRojo\nZerg\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(DatosRepetidos.class, () -> juego.comenzarJuego());
    }
}
