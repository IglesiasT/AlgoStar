package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.construcciones.unidades.Mutalisco;
import edu.fiuba.algo3.modelo.construcciones.unidades.Zealot;
import org.junit.jupiter.api.Test;

public class CasoDeUso20Test {
    @Test
    public void unidadAereaPuedeMoversePorAreaEspacial(){
        // Arrange
        Mutalisco unidadAerea = new Mutalisco();
    }

    @Test
    public void unidadNoAereaNoPuedeMoversePorAreaEspacial(){
        // Arrange
        Zealot unidadNoAerea = new Zealot();
    }
}
