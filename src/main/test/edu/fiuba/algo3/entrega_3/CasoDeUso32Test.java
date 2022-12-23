package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.estados.JuegoFinalizado;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso32Test {
    //Verificar el fin del juego.
    @Test
    public void elJuegoTerminaCuandoAlgunoDeLosJugadoresSeQuedaSinEdificios() {
        AlgoStar juego = new AlgoStar();
        juego.agregarJugador("Amparo" , Color.BLUE, "Zerg");
        juego.agregarJugador("Mariaa" , Color.RED, "Protoss");

        juego.comenzarJuego() ;
        juego.siguienteTurno(juego.obtenerJugador(1));

        assertThrows(JuegoFinalizado.class, () -> juego.siguienteTurno(juego.obtenerJugador(2)));
    }
}
