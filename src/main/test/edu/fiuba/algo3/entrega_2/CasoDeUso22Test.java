package edu.fiuba.algo3.entrega_2;


import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.construcciones.*;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.NexoMineral;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Criadero;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.Dragon;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.Scout;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Hidralisco;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Mutalisco;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Zerling;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso22Test {


    //Unidades Zerg
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

        assertThrows(ConstruccionPreviaNoConstruida.class, () -> razaZerg.engendrarZerling((Criadero) casillero1.obtenerConstruccion()));

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

        razaZerg.construirReservaDeReproduccion(casillero2);

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

        razaZerg.construirReservaDeReproduccion(casillero2);

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

        razaZerg.construirReservaDeReproduccion(casillero2);

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

        razaZerg.construirReservaDeReproduccion(casillero2);

        assertThrows(ConstruccionPreviaNoConstruida.class, () -> razaZerg.engendrarHidralisco((Criadero) casillero1.obtenerConstruccion()));

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

        razaZerg.construirReservaDeReproduccion(casillero2);
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

        razaZerg.construirReservaDeReproduccion(casillero2);
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

        razaZerg.construirReservaDeReproduccion(casillero2);
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


        razaZerg.construirReservaDeReproduccion(casillero2);
        razaZerg.construirGuarida(casillero3);

        assertThrows(ConstruccionPreviaNoConstruida.class, () -> razaZerg.engendrarMutalisco((Criadero) casillero1.obtenerConstruccion()));

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


        razaZerg.construirReservaDeReproduccion(casillero2);
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


        razaZerg.construirReservaDeReproduccion(casillero2);
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


        razaZerg.construirReservaDeReproduccion(casillero2);
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


        razaZerg.construirReservaDeReproduccion(casillero2);
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

        razaZerg.evolucionarMutaliscoAGuardian(mutalisco);

        assertThrows(EdificioNoEstaOperativo.class, () -> mutalisco.atacar(new NexoMineral()));
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


        razaZerg.construirReservaDeReproduccion(casillero2);
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

        razaZerg.evolucionarMutaliscoAGuardian(mutalisco);

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        assertDoesNotThrow(() -> mutalisco.atacar(nexoMineral));
    }



    //Unidades Protoss

    @Test
    public void zealotNoSePuedeConstruirSinAcceso(){
        Protoss razaProtoss = new Protoss(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        razaProtoss.construirPilon(casillero1);

        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();


        assertThrows(NoSePuedeConstruir.class, () -> razaProtoss.construirZealot(mapa.obtenerCasillero(1,2)));

    }

    @Test
    public void zealotSePuedeConstruirConAcceso(){
        Protoss razaProtoss = new Protoss(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        razaProtoss.construirPilon(casillero1);

        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        Casillero casillero3 = mapa.obtenerCasillero(1,3);

        razaProtoss.construirAcceso(casillero2);

        assertDoesNotThrow(() -> razaProtoss.construirZealot(casillero3));

    }

    @Test
    public void zealotNoPuedeAtacarAntesDeQuePaseElTiempoDeConstruccion(){
        Protoss razaProtoss = new Protoss(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        razaProtoss.construirPilon(casillero1);

        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        Casillero casillero3 = mapa.obtenerCasillero(1,3);

        razaProtoss.construirAcceso(casillero2);

        Zealot zealot = razaProtoss.construirZealot(casillero3);

        assertThrows(EdificioNoEstaOperativo.class, () -> zealot.atacar(new Criadero()));
    }

    @Test
    public void zealotPuedeAtacarDespuesDeQuePaseElTiempoDeConstruccion(){
        Protoss razaProtoss = new Protoss(1000,1000);
        Zerg razaZerg = new Zerg();
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setEspacioDeConstruccion(new Moho());
        ReservaDeReproduccion reserva = razaZerg.construirReservaDeReproduccion(casillero2);
        razaProtoss.construirPilon(casillero1);

        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        Casillero casillero4 = mapa.obtenerCasillero(2,1);


        razaProtoss.construirAcceso(casillero3);

        Zealot zealot = razaProtoss.construirZealot(casillero4);

        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        assertDoesNotThrow(() -> zealot.atacar(reserva));
    }

    @Test
    public void dragonNoSePuedeConstruirSinAcceso(){
        Protoss razaProtoss = new Protoss(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        razaProtoss.construirPilon(casillero1);

        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();


        assertThrows(NoSePuedeConstruir.class, () -> razaProtoss.construirDragon(mapa.obtenerCasillero(1,2)));

    }

    @Test
    public void dragonSePuedeConstruirConAcceso(){
        Protoss razaProtoss = new Protoss(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        razaProtoss.construirPilon(casillero1);

        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        Casillero casillero3 = mapa.obtenerCasillero(1,3);

        razaProtoss.construirAcceso(casillero2);

        assertDoesNotThrow(() -> razaProtoss.construirDragon(casillero3));

    }

    @Test
    public void dragonNoPuedeAtacarAntesDeQuePaseElTiempoDeConstruccion(){
        Protoss razaProtoss = new Protoss(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        razaProtoss.construirPilon(casillero1);

        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        Casillero casillero3 = mapa.obtenerCasillero(1,3);

        razaProtoss.construirAcceso(casillero2);

        Dragon dragon = razaProtoss.construirDragon(casillero3);

        assertThrows(EdificioNoEstaOperativo.class, () -> dragon.atacar(new Criadero()));
    }

    @Test
    public void dragonPuedeAtacarDespuesDeQuePaseElTiempoDeConstruccion(){
        // Arrange
        Protoss razaProtoss = new Protoss(1000,1000);
        Zerg razaZerg = new Zerg(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        Casillero casillero2 = mapa.obtenerCasillero(1,2);

        // Act
        casillero2.setEspacioDeConstruccion(new Moho());
        razaZerg.construirReservaDeReproduccion(casillero2);
        razaProtoss.construirPilon(casillero1);

        for (int i = 0; i < 12; i++) {
            razaProtoss.nuevoTurno();
            razaZerg.nuevoTurno();
        }

        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        Casillero casillero4 = mapa.obtenerCasillero(2,1);
        Casillero casillero5 = mapa.obtenerCasillero(2,2);

        razaProtoss.construirAcceso(casillero3);

        Dragon dragon = razaProtoss.construirDragon(casillero4);

        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        assertDoesNotThrow(() -> dragon.atacar(razaZerg.construirReservaDeReproduccion(casillero5)));
    }

    @Test
    public void scoutNoSePuedeConstruirSinPuertoEstelar(){
        Protoss razaProtoss = new Protoss(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        razaProtoss.construirPilon(casillero1);

        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        Casillero casillero3 = mapa.obtenerCasillero(1,3);

        razaProtoss.construirAcceso(casillero2);


        assertThrows(NoSePuedeConstruir.class, () -> razaProtoss.construirScout(casillero3));

    }

    @Test
    public void scoutSePuedeConstruirConPuertoEstelar(){
        Protoss razaProtoss = new Protoss(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        razaProtoss.construirPilon(casillero1);

        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        Casillero casillero4 = mapa.obtenerCasillero(2,1);

        razaProtoss.construirAcceso(casillero2);
        razaProtoss.construirPuertoEstelar(casillero3);

        assertDoesNotThrow(() -> razaProtoss.construirScout(casillero4));

    }

    @Test
    public void scoutNoPuedeAtacarAntesDeQuePaseElTiempoDeConstruccion(){
        Protoss razaProtoss = new Protoss(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        razaProtoss.construirPilon(casillero1);

        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        Casillero casillero4 = mapa.obtenerCasillero(2,1);

        razaProtoss.construirAcceso(casillero2);
        razaProtoss.construirPuertoEstelar(casillero3);

        Scout scout = razaProtoss.construirScout(casillero4);

        assertThrows(EdificioNoEstaOperativo.class, () -> scout.atacar(new Criadero()));
    }

    @Test
    public void scoutPuedeAtacarDespuesDeQuePaseElTiempoDeConstruccion(){
        Protoss razaProtoss = new Protoss(10000,10000);
        Zerg razaZerg = new Zerg(10000,10000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setEspacioDeConstruccion(new Moho());
        razaZerg.construirReservaDeReproduccion(casillero2);
        razaProtoss.construirPilon(casillero1);

        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        Casillero casillero4 = mapa.obtenerCasillero(2,1);
        Casillero casillero5 = mapa.obtenerCasillero(2,2);
        Casillero casillero6 = mapa.obtenerCasillero(3,1);

        razaProtoss.construirAcceso(casillero3);
        razaProtoss.construirPuertoEstelar(casillero4);

        Scout scout = razaProtoss.construirScout(casillero5);

        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        assertDoesNotThrow(() -> scout.atacar(razaZerg.construirReservaDeReproduccion(casillero6)));
    }



}
