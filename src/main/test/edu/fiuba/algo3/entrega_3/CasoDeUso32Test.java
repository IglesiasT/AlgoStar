package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.estados.JuegoFinalizado;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso32Test {
    //Verificar el fin del juego.
    @Test
    public void elJuegoTerminaCuandoAlgunoDeLosJugadoresSeQuedaSinEdificios() {
        AlgoStar juego = new AlgoStar();
        String input = "Amparo\nVioleta\nZerg\nAmparoMaria\nRojo\nProtoss\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        juego.comenzarJuego() ;
        juego.siguienteTurno();
        juego.siguienteTurno();

        assertThrows(JuegoFinalizado.class, () -> juego.siguienteTurno());
    }
}
