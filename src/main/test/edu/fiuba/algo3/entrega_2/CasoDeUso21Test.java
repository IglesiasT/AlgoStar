package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.construcciones.Criadero;
import edu.fiuba.algo3.modelo.construcciones.unidades.Mutalisco;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.tablero.Casillero;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso21Test {

    @Test
    public void mutaliscoNoPuedeEvolucionarSinLosRecursosSuficientes(){
        int mineralPrerrequisitos = 650;
        int gasPrerrequisitos = 300;

        Zerg razaZerg = new Zerg(mineralPrerrequisitos,gasPrerrequisitos);
        Tablero tablero = new Tablero();
        Casillero casillero1 = tablero.obtenerCasillero(1,1);
        razaZerg.construirCriadero(casillero1);

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        Casillero casillero2 = tablero.obtenerCasillero(1,2);
        Casillero casillero3 = tablero.obtenerCasillero(1,3);
        Casillero casillero4 = tablero.obtenerCasillero(1,4);


        razaZerg.construirReservaDeProduccion(casillero2);
        razaZerg.construirGuarida(casillero3);
        razaZerg.construirEspiral(casillero4);
        Mutalisco mutalisco = razaZerg.engendrarMutalisco((Criadero) casillero1.obtenerConstruccion());

        assertThrows(NoSePuedeEngendrar.class, () -> razaZerg.evolucionarMutalisco(mutalisco));

    }

    @Test
    public void mutaliscoPuedeEvolucionarConLosRecursosSuficientes(){
        int mineralPrerrequisitos = 700;
        int gasPrerrequisitos = 400;

        Zerg razaZerg = new Zerg(mineralPrerrequisitos,gasPrerrequisitos);
        Tablero tablero = new Tablero();
        Casillero casillero1 = tablero.obtenerCasillero(1,1);
        razaZerg.construirCriadero(casillero1);

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        Casillero casillero2 = tablero.obtenerCasillero(1,2);
        Casillero casillero3 = tablero.obtenerCasillero(1,3);
        Casillero casillero4 = tablero.obtenerCasillero(1,4);


        razaZerg.construirReservaDeProduccion(casillero2);
        razaZerg.construirGuarida(casillero3);
        razaZerg.construirEspiral(casillero4);
        Mutalisco mutalisco = razaZerg.engendrarMutalisco((Criadero) casillero1.obtenerConstruccion());

        assertDoesNotThrow(() -> razaZerg.evolucionarMutalisco(mutalisco));

    }






}
