package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.construcciones.Asimilador;
import edu.fiuba.algo3.modelo.construcciones.NexoMineral;
import edu.fiuba.algo3.modelo.construcciones.Pilon;
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
}
