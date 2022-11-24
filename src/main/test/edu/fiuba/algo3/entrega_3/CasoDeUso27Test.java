package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.construcciones.Criadero;
import edu.fiuba.algo3.modelo.construcciones.NexoMineral;
import edu.fiuba.algo3.modelo.construcciones.unidades.Mutalisco;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.RecursosInsuficientes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso27Test {

    //Verificar comportamiento y condiciones de evolución del Devorador

    @Test
    public void mutaliscoNoPuedeEvolucionarADevoradorSinLosRecursosSuficientes(){

        int mineralPrerrequisitos = 800;
        int gasPrerrequisitos = 300;

        Zerg razaZerg = new Zerg(mineralPrerrequisitos,gasPrerrequisitos);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        razaZerg.construirCriadero(casillero1);

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        Casillero casillero4 = mapa.obtenerCasillero(1,4);


        razaZerg.construirReservaDeReproduccion(casillero2);
        razaZerg.construirGuarida(casillero3);
        razaZerg.construirEspiral(casillero4);
        Mutalisco mutalisco = razaZerg.engendrarMutalisco((Criadero) casillero1.obtenerConstruccion());

        assertThrows(RecursosInsuficientes.class, () -> razaZerg.evolucionarMutaliscoADevorador(mutalisco));

    }

    @Test
    public void mutaliscoPuedeEvolucionarADevoradorConLosRecursosSuficientes(){

        int mineralPrerrequisitos = 800 + 150;
        int gasPrerrequisitos = 300 + 50;

        Zerg razaZerg = new Zerg(mineralPrerrequisitos,gasPrerrequisitos);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        razaZerg.construirCriadero(casillero1);

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        Casillero casillero4 = mapa.obtenerCasillero(1,4);


        razaZerg.construirReservaDeReproduccion(casillero2);
        razaZerg.construirGuarida(casillero3);
        razaZerg.construirEspiral(casillero4);
        Mutalisco mutalisco = razaZerg.engendrarMutalisco((Criadero) casillero1.obtenerConstruccion());

        assertDoesNotThrow(() -> razaZerg.evolucionarMutaliscoADevorador(mutalisco));

    }

}
