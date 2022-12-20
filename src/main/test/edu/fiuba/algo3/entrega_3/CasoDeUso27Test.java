package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Asimilador;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Criadero;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Devorador;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.MutaliscoBase;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.Scout;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso27Test {

    //Verificar comportamiento y condiciones de evolución del Devorador

    @Test
    public void mutaliscoNoPuedeEvolucionarADevoradorSinLosRecursosSuficientes(){

        int mineralPrerrequisitos = 800;
        int gasPrerrequisitos = 300;

        Zerg razaZerg = new Zerg(mineralPrerrequisitos,gasPrerrequisitos);
        Casillero casillero = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero.setArea(new AreaTerrestre());
        casillero.setRecurso(new SinRecurso());
        razaZerg.construirCriadero(casillero);

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();

        Casillero casillero1 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        casillero1.setEspacioDeConstruccion(new Moho());
        Casillero casillero2 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        casillero2.setEspacioDeConstruccion(new Moho());
        Casillero casillero3 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        casillero3.setEspacioDeConstruccion(new Moho());


        razaZerg.construirReservaDeReproduccion(casillero1);
        razaZerg.construirGuarida(casillero2);
        razaZerg.construirEspiral(casillero3);
        MutaliscoBase mutalisco = razaZerg.engendrarMutalisco((Criadero) casillero.obtenerConstruccion());

        assertThrows(RecursosInsuficientes.class, () -> razaZerg.evolucionarMutaliscoADevorador(mutalisco));

    }

    @Test
    public void mutaliscoPuedeEvolucionarADevoradorConLosRecursosSuficientes(){

        int mineralPrerrequisitos = 800 + 150;
        int gasPrerrequisitos = 300 + 50;

        Zerg razaZerg = new Zerg(mineralPrerrequisitos,gasPrerrequisitos);
        Casillero casillero1 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        casillero1.setEspacioDeConstruccion(new Moho());
        Casillero casillero2 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero2.setArea(new AreaTerrestre());
        casillero2.setRecurso(new SinRecurso());
        casillero2.setEspacioDeConstruccion(new Moho());
        Casillero casillero3 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero3.setArea(new AreaTerrestre());
        casillero3.setRecurso(new SinRecurso());
        casillero3.setEspacioDeConstruccion(new Moho());
        Casillero casillero4 = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        casillero4.setArea(new AreaTerrestre());
        casillero4.setRecurso(new SinRecurso());
        casillero4.setEspacioDeConstruccion(new Moho());
        razaZerg.construirCriadero(casillero1);

        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();
        razaZerg.nuevoTurno();


        razaZerg.construirReservaDeReproduccion(casillero2);
        razaZerg.construirGuarida(casillero3);
        razaZerg.construirEspiral(casillero4);
        MutaliscoBase mutalisco = razaZerg.engendrarMutalisco((Criadero) casillero1.obtenerConstruccion());

        assertDoesNotThrow(() -> razaZerg.evolucionarMutaliscoADevorador(mutalisco));

    }

    @Test
    public void devoradorInflinge15DeDanioEnAire(){
        // Arrange
        Devorador devorador = new Devorador();
        Scout scout = new Scout();
        int valorEsperado = 85;    //100 escudo - 15 ataque
        Casillero casillero1 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero1.setArea(new AreaTerrestre());;
        Raza raza = new Zerg();
        Casillero casillero2 = new Casillero(new AreaEspacial(), 1 , 1 , new Mapa());
        casillero2.setArea(new AreaEspacial());

        // Act


        devorador.nuevoTurno(raza);
        devorador.nuevoTurno(raza);
        devorador.nuevoTurno(raza);
        devorador.nuevoTurno(raza);

        devorador.establecerUbicacion(casillero1);
        scout.establecerUbicacion(casillero2);
        devorador.atacar(scout);

        // Assert
        assertEquals(valorEsperado, scout.obtenerEscudo());
    }

    @Test
    public void devoradorNoPuedeAtacarTierra(){
        // Arrange
        Devorador devorador = new Devorador();
        Asimilador asimilador = new Asimilador();
        int resultadoEsperado = 900;
        Casillero casillero1 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero1.setArea(new AreaTerrestre());;
        Raza raza = new Zerg();
        Casillero casillero2 = new Casillero(new AreaTerrestre(), 1 , 1 , new Mapa());
        casillero2.setArea(new AreaTerrestre());

        // Act

        devorador.nuevoTurno(raza);
        devorador.nuevoTurno(raza);
        devorador.nuevoTurno(raza);
        devorador.nuevoTurno(raza);

        devorador.establecerUbicacion(casillero1);
        asimilador.establecerUbicacion(casillero2);
        devorador.atacar(asimilador);

        assertEquals(asimilador.obtenerEscudo()+asimilador.obtenerVida(),resultadoEsperado);

    }

}
