package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.Asimilador;
import edu.fiuba.algo3.modelo.construcciones.Extractor;
import edu.fiuba.algo3.modelo.construcciones.NexoMineral;
import edu.fiuba.algo3.modelo.construcciones.unidades.Zangano;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.GasProducido;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.MineralProducido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso15Test {
    @Test
    public void extractorNoRecolectaMasGasLuegoDeAgotadoElRecurso(){
        //Arrange
        GasProducido gasProducidoEsperado = new GasProducido(5000);
        Extractor extractor = new Extractor();
        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(),1,1,new Mapa());
        casillero.setEspacioDeConstruccion(new Moho());
        Zangano zangano1 = new Zangano();
        Zangano zangano2 = new Zangano();
        Zangano zangano3 = new Zangano();

        //Act
        extractor.construirEnCasillero(casillero);
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();

        zangano1.nuevoTurno();
        zangano2.nuevoTurno();
        zangano3.nuevoTurno();

        extractor.asignarZangano(zangano1);
        extractor.asignarZangano(zangano2);
        extractor.asignarZangano(zangano3);

        // 3 zanganos recolectan 30 por turno, en 167 turnos recolectan 5010, el volcan tiene 5000
        for(int i = 0; i<167; i++){
            extractor.nuevoTurno();
        }
        assertEquals(gasProducidoEsperado,extractor.obtenerGasProducido());

    }

    @Test
    public void asimiladorNoRecolectaMasGasLuegoDeAgotadoElRecurso(){
        //Arrange
        GasProducido gasProducidoEsperado = new GasProducido(5000);
        Asimilador asimilador = new Asimilador();
        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(),1,1,new Mapa());

        //Act
        asimilador.construirEnCasillero(casillero);
        asimilador.nuevoTurno();
        asimilador.nuevoTurno();
        asimilador.nuevoTurno();
        asimilador.nuevoTurno();
        asimilador.nuevoTurno();
        asimilador.nuevoTurno();


        // asimilador recolecta 20 por turno, en 251 turnos recolectan 5020, el volcan tiene 5000
        for(int i = 0; i<251; i++){
            asimilador.nuevoTurno();
        }
        assertEquals(gasProducidoEsperado,asimilador.obtenerGasProducido());

    }

    @Test
    public void zanganoNoRecolectaMasMineralLuegoDeAgotadoElRecurso(){
        //Arrange
        MineralProducido mineralProducidoEsperado = new MineralProducido(2000);
        Zangano zangano = new Zangano();
        Casillero casillero = new Casillero(new Mineral(),new AreaTerrestre(),1,1,new Mapa());
        casillero.setEspacioDeConstruccion(new Moho());

        //Act
        zangano.ubicar(casillero);
        zangano.nuevoTurno();

        // un zangano recolecta 10 por turno, en 201 turnos recolecta 2010, el nodo tiene 2000
        int mineralProducido = 0;
        for(int i = 0; i<201; i++){
            mineralProducido += zangano.producir();
        }
        assertEquals(mineralProducidoEsperado, new MineralProducido(mineralProducido));

    }

    @Test
    public void nexoMineralNoRecolectaMasMineralLuegoDeAgotadoElRecurso(){
        //Arrange
        MineralProducido mineralProducidoEsperado = new MineralProducido(2000);
        NexoMineral nexo = new NexoMineral();
        Casillero casillero = new Casillero(new Mineral(),new AreaTerrestre(),1,1,new Mapa());
        casillero.setEspacioDeConstruccion(new RangoPilon());

        //Act
        nexo.construirEnCasillero(casillero);
        nexo.nuevoTurno();
        nexo.nuevoTurno();
        nexo.nuevoTurno();
        nexo.nuevoTurno();


        // nexo recolecta 20 por turno, en 101 turnos recolecta 2020, el nodo tiene 2000
        for(int i = 0; i<101; i++){
            nexo.nuevoTurno();
        }
        assertEquals(mineralProducidoEsperado,nexo.obtenerMineralProducido());

    }
}
