package edu.fiuba.algo3.entrega_2;


import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.construcciones.Criadero;
import edu.fiuba.algo3.modelo.construcciones.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.construcciones.NexoMineral;
import edu.fiuba.algo3.modelo.construcciones.unidades.Guardian;
import edu.fiuba.algo3.modelo.construcciones.unidades.Hidralisco;
import edu.fiuba.algo3.modelo.construcciones.unidades.Mutalisco;
import edu.fiuba.algo3.modelo.construcciones.unidades.Zerling;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso22Test {

    @Test
    public void zerlingNoSePuedeEngendrarSinReservaDeReproduccion(){
        Zerg razaZerg = new Zerg(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        razaZerg.construirCriadero(casillero1);

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        assertThrows(NoSePuedeEngendrar.class, () -> razaZerg.engendrarZerling((Criadero) casillero1.obtenerConstruccion()));

    }

    @Test
    public void zerlingSePuedeEngendrarConReservaDeReproduccion(){
        Zerg razaZerg = new Zerg(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        razaZerg.construirCriadero(casillero1);

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);

        razaZerg.construirReservaDeProduccion(casillero2);

        assertDoesNotThrow(() -> razaZerg.engendrarZerling((Criadero) casillero1.obtenerConstruccion()));

    }

    @Test
    public void zerlingNoPuedeAtacarAntesDeQuePaseElTiempoDeConstruccion(){
        Zerg razaZerg = new Zerg(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        razaZerg.construirCriadero(casillero1);

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);

        razaZerg.construirReservaDeProduccion(casillero2);

        Zerling zerling = razaZerg.engendrarZerling((Criadero) casillero1.obtenerConstruccion());

        assertThrows(EdificioNoEstaOperativo.class, () -> zerling.atacar(new NexoMineral()));
    }

    @Test
    public void zerlingPuedeAtacarDespuesDeQuePaseElTiempoDeConstruccion(){
        Zerg razaZerg = new Zerg(1000,1000);
        NexoMineral nexoMineral = new NexoMineral();
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);

        nexoMineral.establecerUbicacion(mapa.obtenerCasillero(1, 3));
        razaZerg.construirCriadero(casillero1);

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);

        razaZerg.construirReservaDeProduccion(casillero2);

        Zerling zerling = razaZerg.engendrarZerling((Criadero) casillero1.obtenerConstruccion());
        zerling.establecerUbicacion(casillero2);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        assertDoesNotThrow(() -> zerling.atacar(nexoMineral));
    }

    @Test
    public void hidraliscoNoSePuedeEngendrarSinGuarida(){
        Zerg razaZerg = new Zerg(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        razaZerg.construirCriadero(casillero1);

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);

        razaZerg.construirReservaDeProduccion(casillero2);

        assertThrows(NoSePuedeEngendrar.class, () -> razaZerg.engendrarHidralisco((Criadero) casillero1.obtenerConstruccion()));

    }

    @Test
    public void hidraliscoSePuedeEngendrarConGuarida(){
        Zerg razaZerg = new Zerg(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        razaZerg.construirCriadero(casillero1);

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        Casillero casillero3 = mapa.obtenerCasillero(1,3);

        razaZerg.construirReservaDeProduccion(casillero2);
        razaZerg.construirGuarida(casillero3);

        assertDoesNotThrow(() -> razaZerg.engendrarHidralisco((Criadero) casillero1.obtenerConstruccion()));

    }

    @Test
    public void hidraliscoNoPuedeAtacarAntesDeQuePaseElTiempoDeConstruccion(){
        Zerg razaZerg = new Zerg(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        razaZerg.construirCriadero(casillero1);

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        Casillero casillero3 = mapa.obtenerCasillero(1,3);

        razaZerg.construirReservaDeProduccion(casillero2);
        razaZerg.construirGuarida(casillero3);

        Hidralisco hidralisco = razaZerg.engendrarHidralisco((Criadero) casillero1.obtenerConstruccion());

        assertThrows(EdificioNoEstaOperativo.class, () -> hidralisco.atacar(new NexoMineral()));
    }

    @Test
    public void hidraliscoPuedeAtacarDespuesDeQuePaseElTiempoDeConstruccion(){
        Zerg razaZerg = new Zerg(1000,1000);
        Mapa mapa = new Mapa();
        NexoMineral nexoMineral = new NexoMineral();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);

        nexoMineral.establecerUbicacion(mapa.obtenerCasillero(2,2));
        razaZerg.construirCriadero(casillero1);

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        Casillero casillero3 = mapa.obtenerCasillero(1,3);

        razaZerg.construirReservaDeProduccion(casillero2);
        razaZerg.construirGuarida(casillero3);

        Hidralisco hidralisco = razaZerg.engendrarHidralisco((Criadero) casillero1.obtenerConstruccion());
        hidralisco.establecerUbicacion(casillero3);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        assertDoesNotThrow(() -> hidralisco.atacar(nexoMineral));
    }

    @Test
    public void mutaliscoNoSePuedeEngendrarSinEspiral(){
        Zerg razaZerg = new Zerg(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        razaZerg.construirCriadero(casillero1);

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        Casillero casillero3 = mapa.obtenerCasillero(1,3);


        razaZerg.construirReservaDeProduccion(casillero2);
        razaZerg.construirGuarida(casillero3);

        assertThrows(NoSePuedeEngendrar.class, () -> razaZerg.engendrarMutalisco((Criadero) casillero1.obtenerConstruccion()));

    }

    @Test
    public void mutaliscoSePuedeEngendrarConEspiral(){
        Zerg razaZerg = new Zerg(1000,1000);
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


        razaZerg.construirReservaDeProduccion(casillero2);
        razaZerg.construirGuarida(casillero3);
        razaZerg.construirEspiral(casillero4);

        assertDoesNotThrow(() -> razaZerg.engendrarMutalisco((Criadero) casillero1.obtenerConstruccion()));

    }

    @Test
    public void mutaliscoNoPuedeAtacarAntesDeQuePaseElTiempoDeConstruccion(){
        Zerg razaZerg = new Zerg(1000,1000);
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


        razaZerg.construirReservaDeProduccion(casillero2);
        razaZerg.construirGuarida(casillero3);
        razaZerg.construirEspiral(casillero4);

        Mutalisco mutalisco = razaZerg.engendrarMutalisco((Criadero) casillero1.obtenerConstruccion());

        assertThrows(EdificioNoEstaOperativo.class, () -> mutalisco.atacar(new NexoMineral()));
    }

    @Test
    public void mutaliscoPuedeAtacarDespuesDeQuePaseElTiempoDeConstruccion(){
        Zerg razaZerg = new Zerg(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        NexoMineral nexoMineral = new NexoMineral();

        razaZerg.construirCriadero(casillero1);
        nexoMineral.establecerUbicacion(mapa.obtenerCasillero(3,3));
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        Casillero casillero4 = mapa.obtenerCasillero(1,4);


        razaZerg.construirReservaDeProduccion(casillero2);
        razaZerg.construirGuarida(casillero3);
        razaZerg.construirEspiral(casillero4);

        Mutalisco mutalisco = razaZerg.engendrarMutalisco((Criadero) casillero1.obtenerConstruccion());
        mutalisco.establecerUbicacion(casillero4);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        assertDoesNotThrow(() -> mutalisco.atacar(nexoMineral));
    }

    @Test
    public void guardianNoPuedeAtacarAntesDeQuePaseElTiempoDeConstruccion(){
        Zerg razaZerg = new Zerg(1000,1000);
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


        razaZerg.construirReservaDeProduccion(casillero2);
        razaZerg.construirGuarida(casillero3);
        razaZerg.construirEspiral(casillero4);

        Mutalisco mutalisco = razaZerg.engendrarMutalisco((Criadero) casillero1.obtenerConstruccion());

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        Guardian guardian = razaZerg.evolucionarMutalisco(mutalisco);

        assertThrows(EdificioNoEstaOperativo.class, () -> guardian.atacar(new NexoMineral()));
    }

    @Test
    public void guardianPuedeAtacarDespuesDeQuePaseElTiempoDeConstruccion(){
        Zerg razaZerg = new Zerg(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        NexoMineral nexoMineral = new NexoMineral();

        nexoMineral.establecerUbicacion(mapa.obtenerCasillero(3,3));
        razaZerg.construirCriadero(casillero1);

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        Casillero casillero4 = mapa.obtenerCasillero(1,4);


        razaZerg.construirReservaDeProduccion(casillero2);
        razaZerg.construirGuarida(casillero3);
        razaZerg.construirEspiral(casillero4);

        Mutalisco mutalisco = razaZerg.engendrarMutalisco((Criadero) casillero1.obtenerConstruccion());

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        Guardian guardian = razaZerg.evolucionarMutalisco(mutalisco);
        guardian.establecerUbicacion(casillero4);

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        assertDoesNotThrow(() -> guardian.atacar(nexoMineral));
    }


}
