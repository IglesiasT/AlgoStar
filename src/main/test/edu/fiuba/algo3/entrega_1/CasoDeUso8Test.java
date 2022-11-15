package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.tablero.Casillero;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso8Test {
    @Test
    public void asimiladorNoSePuedeConstruirSinLosRecursosSuficientes() {
        int mineralNecesario = 100;
        int gasNecesario = 0;
        Protoss razaProtoss = new Protoss(mineralNecesario - 20,gasNecesario);

        Casillero casillero = new Casillero(new Gas(),1, 1, new Tablero());

        assertThrows(NoSePuedeConstruir.class, () -> razaProtoss.construirAsimilador(casillero) );
    }

    @Test
    public void asimiladorSePuedeConstruirConLosRecursosSuficientes(){

        int mineralNecesario = 100;
        int gasNecesario = 0;
        Protoss razaProtoss = new Protoss(mineralNecesario,gasNecesario);

        Casillero casillero = new Casillero(new Gas(),1, 1, new Tablero());

        assertDoesNotThrow(() -> razaProtoss.construirAsimilador(casillero) );
    }

    @Test
    public void extractorNoSePuedeConstruirSinLosRecursosSuficientes() {

        Zerg razaZerg = new Zerg(0,0);

        Casillero casillero = new Casillero(new Gas(),1, 1, new Tablero());
        casillero.setEspacioDeConstruccion(new Moho());

        assertThrows(NoSePuedeConstruir.class, () -> razaZerg.construirExtractor(casillero) );
    }

    @Test
    public void extractorSePuedeConstruirConLosRecursosSuficientes(){

        int mineralNecesario = 100;
        int gasNecesario = 0;
        Zerg razaZerg = new Zerg(mineralNecesario,gasNecesario);

        Casillero casillero = new Casillero(new Gas(),1, 1, new Tablero());
        casillero.setEspacioDeConstruccion(new Moho());

        assertDoesNotThrow(() -> razaZerg.construirExtractor(casillero) );
    }

    @Test
    public void criaderoNoSePuedeConstruirSinLosRecursosSuficientes() {

        Zerg razaZerg = new Zerg(0,0);

        Casillero casillero = new Casillero(1, 1, new Tablero());

        assertThrows(NoSePuedeConstruir.class, () -> razaZerg.construirCriadero(casillero) );
    }

    @Test
    public void criaderoSePuedeConstruirConLosRecursosSuficientes(){

        int mineralNecesario = 50;
        int gasNecesario = 0;
        Zerg razaZerg = new Zerg(mineralNecesario,gasNecesario);

        Casillero casillero = new Casillero(1, 1, new Tablero());

        assertDoesNotThrow(() -> razaZerg.construirCriadero(casillero) );
    }

    @Test
    public void reservaDeReproduccionNoSePuedeConstruirSinLosRecursosSuficientes() {

        Zerg razaZerg = new Zerg(0,0);

        Casillero casillero = new Casillero(1, 1, new Tablero());
        casillero.setEspacioDeConstruccion(new Moho());

        assertThrows(NoSePuedeConstruir.class, () -> razaZerg.construirReservaDeProduccion(casillero) );
    }

    @Test
    public void reservaDeReproduccionSePuedeConstruirConLosRecursosSuficientes(){

        int mineralNecesario = 150;
        int gasNecesario = 0;
        Zerg razaZerg = new Zerg(mineralNecesario,gasNecesario);

        Casillero casillero = new Casillero(1, 1, new Tablero());
        casillero.setEspacioDeConstruccion(new Moho());

        assertDoesNotThrow(() -> razaZerg.construirReservaDeProduccion(casillero) );
    }

    @Test
    public void guaridaNoSePuedeConstruirSinLosRecursosSuficientes() {

        Tablero tablero = new Tablero();
        Casillero casillero1 = tablero.obtenerCasillero(1,1);
        Casillero casillero2 = tablero.obtenerCasillero(1,2);
        int mineralPrerrequisitos = 150;
        int gasPrerrequisitos = 0;

        Zerg razaZerg = new Zerg(mineralPrerrequisitos,gasPrerrequisitos);

        casillero1.setEspacioDeConstruccion(new Moho());
        casillero2.setEspacioDeConstruccion(new Moho());
        razaZerg.construirReservaDeProduccion(casillero1);

        assertThrows(NoSePuedeConstruir.class, () -> razaZerg.construirGuarida(casillero2) );
    }

    @Test
    public void guaridaSePuedeConstruirConLosRecursosSuficientes(){

        Tablero tablero = new Tablero();
        Casillero casillero1 = tablero.obtenerCasillero(1,1);
        Casillero casillero2 = tablero.obtenerCasillero(1,2);
        int mineralPrerrequisitos = 150;
        int gasPrerrequisitos = 0;

        int mineralNecesario = mineralPrerrequisitos + 200;
        int gasNecesario = gasPrerrequisitos + 100;
        Zerg razaZerg = new Zerg(mineralNecesario,gasNecesario);

        casillero1.setEspacioDeConstruccion(new Moho());
        casillero2.setEspacioDeConstruccion(new Moho());
        razaZerg.construirReservaDeProduccion(casillero1);


        assertDoesNotThrow(() -> razaZerg.construirGuarida(casillero2) );
    }

    @Test
    public void espiralNoSePuedeConstruirSinLosRecursosSuficientes() {

        Tablero tablero = new Tablero();
        Casillero casillero1 = tablero.obtenerCasillero(1,1);
        Casillero casillero2 = tablero.obtenerCasillero(1,2);
        Casillero casillero3 = tablero.obtenerCasillero(1,3);
        int mineralPrerrequisitos = 350;
        int gasPrerrequisitos = 100;
        Zerg razaZerg = new Zerg(mineralPrerrequisitos,gasPrerrequisitos);

        casillero1.setEspacioDeConstruccion(new Moho());
        casillero2.setEspacioDeConstruccion(new Moho());
        casillero3.setEspacioDeConstruccion(new Moho());
        razaZerg.construirReservaDeProduccion(casillero1);
        razaZerg.construirGuarida(casillero2);

        assertThrows(NoSePuedeConstruir.class, () -> razaZerg.construirEspiral(casillero3) );
    }

    @Test
    public void espiralSePuedeConstruirConLosRecursosSuficientes(){
        Tablero tablero = new Tablero();
        Casillero casillero1 = tablero.obtenerCasillero(1,1);
        Casillero casillero2 = tablero.obtenerCasillero(1,2);
        Casillero casillero3 = tablero.obtenerCasillero(1,3);
        int mineralPrerrequisitos = 350;
        int gasPrerrequisitos = 100;
        int mineralNecesario = mineralPrerrequisitos + 150;
        int gasNecesario = gasPrerrequisitos + 100;
        Zerg razaZerg = new Zerg(mineralNecesario,gasNecesario);

        casillero1.setEspacioDeConstruccion(new Moho());
        casillero2.setEspacioDeConstruccion(new Moho());
        casillero3.setEspacioDeConstruccion(new Moho());
        razaZerg.construirReservaDeProduccion(casillero1);
        razaZerg.construirGuarida(casillero2);



        assertDoesNotThrow(() -> razaZerg.construirEspiral(casillero3) );
    }

    @Test
    public void nexoMineralNoSePuedeConstruirSinLosRecursosSuficientes() {
        Protoss razaProtoss = new Protoss(0,0);

        Casillero casillero = new Casillero(new Mineral(),1, 1, new Tablero());

        assertThrows(NoSePuedeConstruir.class, () -> razaProtoss.construirNexoMineral(casillero) );
    }

    @Test
    public void nexoMineralSePuedeConstruirConLosRecursosSuficientes(){

        int mineralNecesario = 50;
        int gasNecesario = 0;
        Protoss razaProtoss = new Protoss(mineralNecesario,gasNecesario);

        Casillero casillero = new Casillero(new Mineral(),1, 1, new Tablero());

        assertDoesNotThrow(() -> razaProtoss.construirNexoMineral(casillero) );
    }

    @Test
    public void pilonNoSePuedeConstruirSinLosRecursosSuficientes(){
        Protoss razaProtoss = new Protoss(0,0);

        Casillero casillero = new Casillero(1, 1, new Tablero());

        assertThrows(NoSePuedeConstruir.class, () -> razaProtoss.construirPilon(casillero) );
    }

    @Test
    public void pilonSePuedeConstruirConLosRecursosSuficientes(){

        int mineralNecesario = 100;
        int gasNecesario = 0;
        Protoss razaProtoss = new Protoss(mineralNecesario,gasNecesario);

        Casillero casillero = new Casillero(1, 1, new Tablero());

        assertDoesNotThrow(() -> razaProtoss.construirPilon(casillero) );
    }

    @Test
    public void accesoNoSePuedeConstruirSinLosRecursosSuficientes(){

        Protoss razaProtoss = new Protoss(0,0);

        Casillero casillero = new Casillero(1, 1, new Tablero());
        casillero.setEspacioDeConstruccion(new RangoPilon());

        assertThrows(NoSePuedeConstruir.class, () -> razaProtoss.construirAcceso(casillero) );
    }

    @Test
    public void accesoSePuedeConstruirConLosRecursosSuficientes(){

        int mineralNecesario = 150;
        int gasNecesario = 0;
        Protoss razaProtoss = new Protoss(mineralNecesario,gasNecesario);

        Casillero casillero = new Casillero(1, 1, new Tablero());
        casillero.setEspacioDeConstruccion(new RangoPilon());

        assertDoesNotThrow(() -> razaProtoss.construirAcceso(casillero) );
    }

    @Test
    public void puertoEstelarNoSePuedeConstruirSinLosRecursosSuficientes(){

        Tablero tablero = new Tablero();
        Casillero casillero1 = tablero.obtenerCasillero(1,1);
        Casillero casillero2 = tablero.obtenerCasillero(1,2);
        int mineralPrerrequisitos = 150;
        int gasPrerrequisitos = 0;

        Protoss razaProtoss = new Protoss(mineralPrerrequisitos,gasPrerrequisitos);
        casillero1.setEspacioDeConstruccion(new RangoPilon());
        casillero2.setEspacioDeConstruccion(new RangoPilon());
        razaProtoss.construirAcceso(casillero1);

        assertThrows(NoSePuedeConstruir.class, () -> razaProtoss.construirPuertoEstelar(casillero2) );
    }

    @Test
    public void puertoEstelarSePuedeConstruirConLosRecursosSuficientes(){

        Tablero tablero = new Tablero();
        Casillero casillero1 = tablero.obtenerCasillero(1,1);
        Casillero casillero2 = tablero.obtenerCasillero(1,2);
        int mineralPrerrequisitos = 150;
        int gasPrerrequisitos = 0;
        int mineralNecesario = mineralPrerrequisitos + 150;
        int gasNecesario = gasPrerrequisitos + 150;

        Protoss razaProtoss = new Protoss(mineralNecesario,gasNecesario);
        casillero1.setEspacioDeConstruccion(new RangoPilon());
        casillero2.setEspacioDeConstruccion(new RangoPilon());
        razaProtoss.construirAcceso(casillero1);


        assertDoesNotThrow(() -> razaProtoss.construirPuertoEstelar(casillero2) );
    }
}
