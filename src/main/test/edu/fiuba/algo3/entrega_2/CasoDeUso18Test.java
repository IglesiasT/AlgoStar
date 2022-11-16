package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.construcciones.*;
import edu.fiuba.algo3.modelo.construcciones.unidades.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso18Test {
    // Unidades Zerg
    @Test
    public void zerlingInflinge4DeDanioEnTierra(){
        // Arrange
        Zerling zerling = new Zerling();
        NexoMineral nexoMineral = new NexoMineral();
        int valorEsperado = 246;    //250 escudo - 4 ataque

        // Act
        zerling.nuevoTurno();
        zerling.nuevoTurno();
        zerling.atacar(nexoMineral);

        // Assert
        assertEquals(valorEsperado, nexoMineral.obtenerEscudo());
    }

    @Test
    public void hidraliscoInflinge10DeDanioEnTierra(){
        // Arrange
        Hidralisco hidralisco = new Hidralisco();
        Pilon pilon = new Pilon();
        int valorEsperado = 290;    //290 escudo - 10 ataque

        // Act
        hidralisco.nuevoTurno();
        hidralisco.nuevoTurno();
        hidralisco.nuevoTurno();
        hidralisco.nuevoTurno();
        hidralisco.atacar(pilon);

        // Assert
        assertEquals(valorEsperado, pilon.obtenerEscudo());
    }

    @Test
    public void hidraliscoInflinge10DeDanioEnAire(){
        // Arrange
        Hidralisco hidralisco = new Hidralisco();
        Scout scout = new Scout();
        int valorEsperado = 90;    //100 escudo - 10 ataque

        // Act
        hidralisco.nuevoTurno();
        hidralisco.nuevoTurno();
        hidralisco.nuevoTurno();
        hidralisco.nuevoTurno();
        hidralisco.atacar(scout);

        // Assert
        assertEquals(valorEsperado, scout.obtenerEscudo());
    }

    @Test
    public void mutaliscoInflinge9DeDanioEnTierra(){
        // Arrange
        Mutalisco mutalisco = new Mutalisco();
        Zealot zealot = new Zealot();
        int valorEsperado = 51;    //60 escudo - 9 ataque

        // Act
        mutalisco.atacar(zealot);

        // Assert
        assertEquals(valorEsperado, zealot.obtenerEscudo());
    }

    @Test
    public void mutaliscoInflinge9DeDanioEnAire(){
        // Arrange
        Mutalisco mutalisco = new Mutalisco();
        Scout scout = new Scout();
        int valorEsperado = 91;    //100 escudo - 9 ataque

        // Act
        mutalisco.atacar(scout);

        // Assert
        assertEquals(valorEsperado, scout.obtenerEscudo());
    }

    @Test
    public void guardianInflinge25DeDanioEnTierra(){
        // Arrange
        Guardian guardian = new Guardian();
        Asimilador asimilador = new Asimilador();
        int valorEsperado = 425;    //450 escudo - 25 ataque

        // Act
        guardian.atacar(asimilador);

        // Assert
        assertEquals(valorEsperado, asimilador.obtenerEscudo());
    }

    // Unidades Protoss
    @Test
    public void zealotInflinge8DeDanioEnTierra(){
        // Arrange
        Zealot zealot = new Zealot();
        ReservaDeReproduccion reserva = new ReservaDeReproduccion();
        int valorEsperado = 992;    //1000 vida - 8 ataque

        // Act
        zealot.atacar(reserva);

        // Assert
        assertEquals(valorEsperado, reserva.obtenerVida());
    }
    @Test
    public void dragonInflinge20DeDanioEnTierra(){
        // Arrange
        Dragon dragon = new Dragon();
        Criadero criadero = new Criadero();
        int valorEsperado = 480;    //500 vida - 20 ataque

        // Act
        dragon.atacar(criadero);

        // Assert
        assertEquals(valorEsperado, criadero.obtenerVida());
    }
    @Test
    public void dragonInflinge20DeDanioEnAire(){
        // Arrange
        Dragon dragon = new Dragon();
        Guardian guardian = new Guardian();
        int valorEsperado = 80;    //100 vida - 20 ataque

        // Act
        dragon.atacar(guardian);

        // Assert
        assertEquals(valorEsperado, guardian.obtenerVida());
    }
    @Test
    public void scoutInflinge8DeDanioEnTierra(){
        // Arrange
        Scout scout = new Scout();
        Criadero criadero = new Criadero();
        int valorEsperado = 492;    //500 vida - 8 ataque

        // Act
        scout.atacar(criadero);

        // Assert
        assertEquals(valorEsperado, criadero.obtenerVida());
    }
    @Test
    public void scoutInflinge14DeDanioEnAire(){
        // Arrange
        Scout scout = new Scout();
        Mutalisco mutalisco = new Mutalisco();
        int valorEsperado = 106;    //120 vida - 14 ataque

        // Act
        scout.atacar(mutalisco);

        // Assert
        assertEquals(valorEsperado, mutalisco.obtenerVida());
    }
}
