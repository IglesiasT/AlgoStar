package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.construcciones.ConstruccionPreviaNoConstruida;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso17Test {

    @Test
    public void guaridaNoSePuedeConstruirSinReservaDeReproduccion() {
        // Arrange
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        Zerg razaZerg = new Zerg(1000,1000);

        // Act
        casillero1.setEspacioDeConstruccion(new Moho());

        // Assert
        assertThrows(ConstruccionPreviaNoConstruida.class, () -> razaZerg.construirGuarida(casillero1) );
    }

    @Test
    public void espiralNoSePuedeConstruirSinGuarida() {
        // Arrange
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        Zerg razaZerg = new Zerg(1000,1000);

        // Act
        casillero1.setEspacioDeConstruccion(new Moho());
        casillero2.setEspacioDeConstruccion(new Moho());
        razaZerg.construirReservaDeReproduccion(casillero1);

        // Assert
        assertThrows(ConstruccionPreviaNoConstruida.class, () -> razaZerg.construirEspiral(casillero2) );
    }

    @Test
    public void puertoEstelarNoSePuedeConstruirSinAcceso(){
        // Arrange
        Mapa mapa = new Mapa();
        Casillero casillero = mapa.obtenerCasillero(1,1);
        Protoss razaProtoss = new Protoss(1000,1000);

        // Act
        casillero.setEspacioDeConstruccion(new RangoPilon());

        // Assert
        assertThrows(ConstruccionPreviaNoConstruida.class, () -> razaProtoss.construirPuertoEstelar(casillero) );
    }

}
