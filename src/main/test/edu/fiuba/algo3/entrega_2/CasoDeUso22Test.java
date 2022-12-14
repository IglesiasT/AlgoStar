package edu.fiuba.algo3.entrega_2;


import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.*;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.NexoMineral;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Criadero;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.Dragon;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.Scout;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Hidralisco;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.MutaliscoBase;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Zerling;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.estados.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.recursos.*;
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
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
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
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        razaZerg.construirCriadero(casillero1);

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        razaZerg.construirReservaDeReproduccion(casillero2);

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        assertDoesNotThrow(() -> razaZerg.engendrarZerling((Criadero) casillero1.obtenerConstruccion()));

    }

    @Test
    public void zerlingNoPuedeAtacarAntesDeQuePaseElTiempoDeConstruccion(){
        Zerg razaZerg = new Zerg(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        razaZerg.construirCriadero(casillero1);

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        razaZerg.construirReservaDeReproduccion(casillero2);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        Zerling zerling = razaZerg.engendrarZerling((Criadero) casillero1.obtenerConstruccion());

        assertThrows(EdificioNoEstaOperativo.class, () -> zerling.atacar(new NexoMineral()));
    }

    @Test
    public void zerlingPuedeAtacarDespuesDeQuePaseElTiempoDeConstruccion(){
        Zerg razaZerg = new Zerg(1000,1000);
        NexoMineral nexoMineral = new NexoMineral();
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        recursos.agregar(new Mineral(1000));
        recursos.agregar(new Gas(1000));

        nexoMineral.establecerUbicacion(mapa.obtenerCasillero(1, 3));
        razaZerg.construirCriadero(casillero1);

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        razaZerg.construirReservaDeReproduccion(casillero2);

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        Zerling zerling = razaZerg.engendrarZerling((Criadero) casillero1.obtenerConstruccion());
        zerling.construir(casillero2, recursos);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        assertDoesNotThrow(() -> zerling.atacar(nexoMineral));
    }

    @Test
    public void hidraliscoNoSePuedeEngendrarSinGuarida(){
        Zerg razaZerg = new Zerg(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        razaZerg.construirCriadero(casillero1);

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        razaZerg.construirReservaDeReproduccion(casillero2);

        assertThrows(ConstruccionPreviaNoConstruida.class, () -> razaZerg.engendrarHidralisco((Criadero) casillero1.obtenerConstruccion()));

    }

    @Test
    public void hidraliscoSePuedeEngendrarConGuarida(){
        Zerg razaZerg = new Zerg(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        razaZerg.construirCriadero(casillero1);


        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        razaZerg.construirReservaDeReproduccion(casillero2);

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        razaZerg.construirGuarida(casillero3);

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        assertDoesNotThrow(() -> razaZerg.engendrarHidralisco((Criadero) casillero1.obtenerConstruccion()));

    }

    @Test
    public void hidraliscoNoPuedeAtacarAntesDeQuePaseElTiempoDeConstruccion(){
        Zerg razaZerg = new Zerg(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        razaZerg.construirCriadero(casillero1);


        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        razaZerg.construirReservaDeReproduccion(casillero2);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.construirGuarida(casillero3);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        Hidralisco hidralisco = razaZerg.engendrarHidralisco((Criadero) casillero1.obtenerConstruccion());

        assertThrows(EdificioNoEstaOperativo.class, () -> hidralisco.atacar(new NexoMineral()));
    }

    @Test
    public void hidraliscoPuedeAtacarDespuesDeQuePaseElTiempoDeConstruccion(){
        Zerg razaZerg = new Zerg(1000,1000);
        Mapa mapa = new Mapa();
        NexoMineral nexoMineral = new NexoMineral();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());

        Casillero casillero2 = mapa.obtenerCasillero(2,2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new Nodo());
        nexoMineral.establecerUbicacion(casillero2);
        razaZerg.construirCriadero(casillero1);


        Casillero casillero3 = mapa.obtenerCasillero(1,2);
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        Casillero casillero4 = mapa.obtenerCasillero(1,3);
        casillero4.setArea(new AreaTerrestre());
        casillero4.setRecurso(new SinRecurso());

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        razaZerg.construirReservaDeReproduccion(casillero3);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.construirGuarida(casillero4);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        Hidralisco hidralisco = razaZerg.engendrarHidralisco((Criadero) casillero1.obtenerConstruccion());
        hidralisco.establecerUbicacion(casillero4);
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
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        razaZerg.construirCriadero(casillero1);


        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        razaZerg.construirReservaDeReproduccion(casillero2);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.construirGuarida(casillero3);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        assertThrows(ConstruccionPreviaNoConstruida.class, () -> razaZerg.engendrarMutalisco((Criadero) casillero1.obtenerConstruccion()));

    }

    @Test
    public void mutaliscoSePuedeEngendrarConEspiral(){
        Zerg razaZerg = new Zerg(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        razaZerg.construirCriadero(casillero1);


        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        Casillero casillero4 = mapa.obtenerCasillero(1,4);
        casillero4.setArea(new AreaTerrestre());
        casillero4.setRecurso(new SinRecurso());

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        razaZerg.construirReservaDeReproduccion(casillero2);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.construirGuarida(casillero3);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.construirEspiral(casillero4);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        assertDoesNotThrow(() -> razaZerg.engendrarMutalisco((Criadero) casillero1.obtenerConstruccion()));

    }

    @Test
    public void mutaliscoNoPuedeAtacarAntesDeQuePaseElTiempoDeConstruccion(){
        Zerg razaZerg = new Zerg(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        NexoMineral nexoMineral = new NexoMineral();

        razaZerg.construirCriadero(casillero1);
        Casillero casilleroNexo = mapa.obtenerCasillero(3,3);
        casilleroNexo.setArea(new AreaTerrestre());
        casilleroNexo.setRecurso(new Nodo());
        nexoMineral.establecerUbicacion(casilleroNexo);


        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        Casillero casillero4 = mapa.obtenerCasillero(1,4);
        casillero4.setArea(new AreaTerrestre());
        casillero4.setRecurso(new SinRecurso());

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        razaZerg.construirReservaDeReproduccion(casillero2);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.construirGuarida(casillero3);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.construirEspiral(casillero4);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        MutaliscoBase mutalisco = razaZerg.engendrarMutalisco((Criadero) casillero1.obtenerConstruccion());

        assertThrows(EdificioNoEstaOperativo.class, () -> mutalisco.atacar(nexoMineral));
    }

    @Test
    public void mutaliscoPuedeAtacarDespuesDeQuePaseElTiempoDeConstruccion(){
        Zerg razaZerg = new Zerg(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        NexoMineral nexoMineral = new NexoMineral();

        razaZerg.construirCriadero(casillero1);
        Casillero casilleroNexo = mapa.obtenerCasillero(3,3);
        casilleroNexo.setArea(new AreaTerrestre());
        casilleroNexo.setRecurso(new Nodo());
        nexoMineral.establecerUbicacion(casilleroNexo);


        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        Casillero casillero4 = mapa.obtenerCasillero(1,4);
        casillero4.setArea(new AreaTerrestre());
        casillero4.setRecurso(new SinRecurso());

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        razaZerg.construirReservaDeReproduccion(casillero2);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.construirGuarida(casillero3);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.construirEspiral(casillero4);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        MutaliscoBase mutalisco = razaZerg.engendrarMutalisco((Criadero) casillero1.obtenerConstruccion());
        mutalisco.moverse(casillero4);
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
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        NexoMineral nexoMineral = new NexoMineral();

        razaZerg.construirCriadero(casillero1);
        Casillero casilleroNexo = mapa.obtenerCasillero(3,3);
        casilleroNexo.setArea(new AreaTerrestre());
        casilleroNexo.setRecurso(new Nodo());
        nexoMineral.establecerUbicacion(casilleroNexo);



        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        Casillero casillero4 = mapa.obtenerCasillero(1,4);
        casillero4.setArea(new AreaTerrestre());
        casillero4.setRecurso(new SinRecurso());

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        razaZerg.construirReservaDeReproduccion(casillero2);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.construirGuarida(casillero3);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.construirEspiral(casillero4);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        MutaliscoBase mutalisco = razaZerg.engendrarMutalisco((Criadero) casillero1.obtenerConstruccion());

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        razaZerg.evolucionarMutaliscoAGuardian(mutalisco);

        assertThrows(EdificioNoEstaOperativo.class, () -> razaZerg.atacar(casillero1.obtenerUnidades().get(0),nexoMineral));
    }

    @Test
    public void guardianPuedeAtacarDespuesDeQuePaseElTiempoDeConstruccion(){
        Zerg razaZerg = new Zerg(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        NexoMineral nexoMineral = new NexoMineral();

        razaZerg.construirCriadero(casillero1);
        Casillero casilleroNexo = mapa.obtenerCasillero(3,3);
        casilleroNexo.setArea(new AreaTerrestre());
        casilleroNexo.setRecurso(new Nodo());
        nexoMineral.establecerUbicacion(casilleroNexo);



        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        Casillero casillero4 = mapa.obtenerCasillero(1,4);
        casillero4.setArea(new AreaTerrestre());
        casillero4.setRecurso(new SinRecurso());

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        razaZerg.construirReservaDeReproduccion(casillero2);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.construirGuarida(casillero3);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.construirEspiral(casillero4);
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        MutaliscoBase mutalisco = razaZerg.engendrarMutalisco((Criadero) casillero1.obtenerConstruccion());

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
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        razaProtoss.construirPilon(casillero1);

        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();


        assertThrows(ConstruccionPreviaNoConstruida.class, () -> razaProtoss.construirZealot(mapa.obtenerCasillero(1,2)));

    }

    @Test
    public void zealotSePuedeConstruirConAcceso(){
        Protoss razaProtoss = new Protoss(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        razaProtoss.construirPilon(casillero1);

        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());

        razaProtoss.construirAcceso(casillero2);
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        assertDoesNotThrow(() -> razaProtoss.construirZealot(casillero3));

    }

    @Test
    public void zealotNoPuedeAtacarAntesDeQuePaseElTiempoDeConstruccion(){
        Protoss razaProtoss = new Protoss(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        razaProtoss.construirPilon(casillero1);

        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());

        razaProtoss.construirAcceso(casillero2);
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        Zealot zealot = razaProtoss.construirZealot(casillero3);

        assertThrows(EdificioNoEstaOperativo.class, () -> zealot.atacar(new Criadero()));
    }

    @Test
    public void zealotPuedeAtacarDespuesDeQuePaseElTiempoDeConstruccion(){
        Protoss razaProtoss = new Protoss(1000,1000);
        Zerg razaZerg = new Zerg();
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        casillero2.setEspacioDeConstruccion(new Moho());
        ReservaDeReproduccion reserva = razaZerg.construirReservaDeReproduccion(casillero2);
        razaProtoss.construirPilon(casillero1);

        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        Casillero casillero4 = mapa.obtenerCasillero(2,1);
        casillero4.setArea(new AreaTerrestre());
        casillero4.setRecurso(new SinRecurso());


        razaProtoss.construirAcceso(casillero3);
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        Zealot zealot = razaProtoss.construirZealot(casillero4);

        zealot.nuevoTurno(razaProtoss);
        zealot.nuevoTurno(razaProtoss);
        zealot.nuevoTurno(razaProtoss);
        zealot.nuevoTurno(razaProtoss);
        zealot.nuevoTurno(razaProtoss);
        zealot.nuevoTurno(razaProtoss);
        zealot.nuevoTurno(razaProtoss);

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
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        razaProtoss.construirPilon(casillero1);

        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();


        assertThrows(ConstruccionPreviaNoConstruida.class, () -> razaProtoss.construirDragon(mapa.obtenerCasillero(1,2)));

    }

    @Test
    public void dragonSePuedeConstruirConAcceso(){
        Protoss razaProtoss = new Protoss(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        razaProtoss.construirPilon(casillero1);

        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());

        razaProtoss.construirAcceso(casillero2);
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        assertDoesNotThrow(() -> razaProtoss.construirDragon(casillero3));

    }

    @Test
    public void dragonNoPuedeAtacarAntesDeQuePaseElTiempoDeConstruccion(){
        Protoss razaProtoss = new Protoss(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        razaProtoss.construirPilon(casillero1);

        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());

        razaProtoss.construirAcceso(casillero2);
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

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
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());

        // Act
        casillero2.setEspacioDeConstruccion(new Moho());
        razaZerg.construirReservaDeReproduccion(casillero2);
        razaProtoss.construirPilon(casillero1);

        for (int i = 0; i < 12; i++) {
            razaProtoss.nuevoTurno();
            razaZerg.nuevoTurno();
        }

        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        Casillero casillero4 = mapa.obtenerCasillero(2,1);
        casillero4.setArea(new AreaTerrestre());
        casillero4.setRecurso(new SinRecurso());
        Casillero casillero5 = mapa.obtenerCasillero(2,2);
        casillero5.setArea(new AreaTerrestre());
        casillero5.setRecurso(new SinRecurso());
        casillero5.setEspacioDeConstruccion(new Moho());

        razaProtoss.construirAcceso(casillero3);
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        Dragon dragon = razaProtoss.construirDragon(casillero4);
        dragon.nuevoTurno(razaProtoss);
        dragon.nuevoTurno(razaProtoss);
        dragon.nuevoTurno(razaProtoss);
        dragon.nuevoTurno(razaProtoss);
        dragon.nuevoTurno(razaProtoss);
        dragon.nuevoTurno(razaProtoss);

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
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        razaProtoss.construirPilon(casillero1);

        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());

        razaProtoss.construirAcceso(casillero2);


        assertThrows(ConstruccionPreviaNoConstruida.class, () -> razaProtoss.construirScout(casillero3));

    }

    @Test
    public void scoutSePuedeConstruirConPuertoEstelar(){
        Protoss razaProtoss = new Protoss(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        razaProtoss.construirPilon(casillero1);

        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        Casillero casillero4 = mapa.obtenerCasillero(2,1);
        casillero4.setArea(new AreaTerrestre());
        casillero4.setRecurso(new SinRecurso());

        razaProtoss.construirAcceso(casillero2);
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.construirPuertoEstelar(casillero3);
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        assertDoesNotThrow(() -> razaProtoss.construirScout(casillero4));

    }

    @Test
    public void scoutNoPuedeAtacarAntesDeQuePaseElTiempoDeConstruccion(){
        Protoss razaProtoss = new Protoss(1000,1000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        razaProtoss.construirPilon(casillero1);

        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        Casillero casillero4 = mapa.obtenerCasillero(2,1);
        casillero4.setArea(new AreaTerrestre());
        casillero4.setRecurso(new SinRecurso());

        razaProtoss.construirAcceso(casillero2);
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.construirPuertoEstelar(casillero3);
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        Scout scout = razaProtoss.construirScout(casillero4);

        assertThrows(EdificioNoEstaOperativo.class, () -> scout.atacar(new Criadero()));
    }

    @Test
    public void scoutPuedeAtacarDespuesDeQuePaseElTiempoDeConstruccion(){
        Protoss razaProtoss = new Protoss(10000,10000);
        Zerg razaZerg = new Zerg(10000,10000);
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        casillero2.setEspacioDeConstruccion(new Moho());
        ReservaDeReproduccion reserva = razaZerg.construirReservaDeReproduccion(casillero2);
        razaProtoss.construirPilon(casillero1);

        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        Casillero casillero4 = mapa.obtenerCasillero(2,1);
        casillero4.setArea(new AreaTerrestre());
        casillero4.setRecurso(new SinRecurso());
        Casillero casillero5 = mapa.obtenerCasillero(2,2);
        casillero5.setArea(new AreaTerrestre());
        casillero5.setRecurso(new SinRecurso());

        razaProtoss.construirAcceso(casillero3);
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.construirPuertoEstelar(casillero4);
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();
        razaProtoss.nuevoTurno();

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

        assertDoesNotThrow(() -> scout.atacar(reserva));
    }



}
