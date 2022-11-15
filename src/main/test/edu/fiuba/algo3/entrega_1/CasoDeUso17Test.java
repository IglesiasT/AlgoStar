package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.tablero.Casillero;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso17Test {

    @Test
    public void guaridaNoSePuedeConstruirSinReservaDeReproduccion() {

        Tablero tablero = new Tablero();
        Casillero casillero1 = tablero.obtenerCasillero(1,1);


        Zerg razaZerg = new Zerg(1000,1000);

        casillero1.setEspacioDeConstruccion(new Moho());

        assertThrows(NoSePuedeConstruir.class, () -> razaZerg.construirGuarida(casillero1) );
    }

    @Test
    public void espiralNoSePuedeConstruirSinGuarida() {

        Tablero tablero = new Tablero();
        Casillero casillero1 = tablero.obtenerCasillero(1,1);
        Casillero casillero2 = tablero.obtenerCasillero(1,2);


        Zerg razaZerg = new Zerg(1000,1000);

        casillero1.setEspacioDeConstruccion(new Moho());
        casillero2.setEspacioDeConstruccion(new Moho());

        razaZerg.construirReservaDeProduccion(casillero1);

        assertThrows(NoSePuedeConstruir.class, () -> razaZerg.construirEspiral(casillero2) );
    }

    @Test
    public void puertoEstelarNoSePuedeConstruirSinAcceso(){

        Tablero tablero = new Tablero();
        Casillero casillero = tablero.obtenerCasillero(1,1);

        Protoss razaProtoss = new Protoss(1000,1000);
        casillero.setEspacioDeConstruccion(new RangoPilon());

        assertThrows(NoSePuedeConstruir.class, () -> razaProtoss.construirPuertoEstelar(casillero) );
    }

}
