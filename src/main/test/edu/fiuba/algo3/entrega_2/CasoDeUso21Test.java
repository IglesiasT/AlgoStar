package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Criadero;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Mutalisco;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.recursos.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
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
        casillero1.setRecurso(new SinRecurso());
        casillero1.setArea(new AreaTerrestre());
        razaZerg.construirCriadero(casillero1);

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setRecurso(new SinRecurso());
        casillero2.setArea(new AreaTerrestre());
        casillero2.setEspacioDeConstruccion(new Moho());
        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        casillero3.setRecurso(new SinRecurso());
        casillero3.setArea(new AreaTerrestre());
        casillero3.setEspacioDeConstruccion(new Moho());
        Casillero casillero4 = mapa.obtenerCasillero(1,4);
        casillero4.setRecurso(new SinRecurso());
        casillero4.setArea(new AreaTerrestre());
        casillero4.setEspacioDeConstruccion(new Moho());


        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();


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
        casillero1.setRecurso(new SinRecurso());
        casillero1.setArea(new AreaTerrestre());
        razaZerg.construirCriadero(casillero1);

        Casillero casillero2 = mapa.obtenerCasillero(1,2);
        casillero2.setRecurso(new SinRecurso());
        casillero2.setArea(new AreaTerrestre());
        casillero2.setEspacioDeConstruccion(new Moho());
        Casillero casillero3 = mapa.obtenerCasillero(1,3);
        casillero3.setRecurso(new SinRecurso());
        casillero3.setArea(new AreaTerrestre());
        casillero3.setEspacioDeConstruccion(new Moho());
        Casillero casillero4 = mapa.obtenerCasillero(1,4);
        casillero4.setRecurso(new SinRecurso());
        casillero4.setArea(new AreaTerrestre());
        casillero4.setEspacioDeConstruccion(new Moho());

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();


        razaZerg.construirReservaDeReproduccion(casillero2);
        razaZerg.construirGuarida(casillero3);
        razaZerg.construirEspiral(casillero4);
        Mutalisco mutalisco = razaZerg.engendrarMutalisco((Criadero) casillero1.obtenerConstruccion());

        assertDoesNotThrow(() -> razaZerg.evolucionarMutaliscoAGuardian(mutalisco));

    }






}
