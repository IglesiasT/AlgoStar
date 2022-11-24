package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.construcciones.Criadero;
import edu.fiuba.algo3.modelo.construcciones.unidades.Mutalisco;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.recursos.RecursosInsuficientes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso21Test {

    @Test
    public void mutaliscoNoPuedeEvolucionarSinLosRecursosSuficientes(){
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

        assertThrows(RecursosInsuficientes.class, () -> razaZerg.evolucionarMutaliscoAGuardian(mutalisco));

    }

    @Test
    public void mutaliscoPuedeEvolucionarConLosRecursosSuficientes(){
        int mineralPrerrequisitos = 900;
        int gasPrerrequisitos = 400;

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

        assertDoesNotThrow(() -> razaZerg.evolucionarMutaliscoAGuardian(mutalisco));

    }






}
