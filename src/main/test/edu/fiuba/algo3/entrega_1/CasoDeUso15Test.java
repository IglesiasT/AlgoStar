package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Asimilador;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Extractor;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.NexoMineral;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Zangano;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso15Test {
    @Test
    public void extractorNoRecolectaMasGasLuegoDeAgotadoElRecurso(){
        // Arrange
        Gas gasProducidoEsperado = new Gas(5000);
        Gas gasRecolectado = new Gas(0);
        Extractor extractor = new Extractor();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Mapa());
        casillero.setRecurso(new Volcan());
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        Zangano zangano1 = new Zangano();
        Zangano zangano2 = new Zangano();
        Zangano zangano3 = new Zangano();

        //Act
        recursos.agregar(new Mineral(100));
        casillero.setEspacioDeConstruccion(new Moho());
        extractor.construir(casillero, recursos);
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());

        zangano1.moverse(casillero);
        zangano2.moverse(casillero);
        zangano3.moverse(casillero);



        // 3 zanganos recolectan 30 por turno, en 167 turnos recolectan 5010, el volcan tiene 5000
        for(int i = 0; i<167; i++){
            gasRecolectado.agregar(extractor.producirGas());
        }

        // Assert
        assertEquals(gasProducidoEsperado,gasRecolectado);

    }

    @Test
    public void asimiladorNoRecolectaMasGasLuegoDeAgotadoElRecurso(){
        // Arrange
        Gas gasProducidoEsperado = new Gas(5000);
        Gas gasRecolectado = new Gas(0);
        Asimilador asimilador = new Asimilador();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Mapa());
        casillero.setRecurso(new Volcan());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        //Act
        recursos.agregar(new Mineral(100));
        casillero.setEspacioDeConstruccion(new Moho());
        asimilador.construir(casillero, recursos);


        // asimilador recolecta 20 por turno, en 251 turnos recolectan 5020, el volcan tiene 5000
        for(int i = 0; i<251; i++){
            gasRecolectado.agregar(asimilador.producirGas());
        }

        // Assert
        assertEquals(gasProducidoEsperado,gasRecolectado);

    }

    @Test
    public void zanganoNoRecolectaMasMineralLuegoDeAgotadoElRecurso(){
        //Arrange
        Mineral mineralProducidoEsperado = new Mineral(2000);
        Zangano zangano = new Zangano();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Mapa());
        casillero.setRecurso(new Nodo());


        //Act
        casillero.setEspacioDeConstruccion(new Moho());
        zangano.moverse(casillero);

        // un zangano recolecta 10 por turno, en 201 turnos recolecta 2010, el nodo tiene 2000
        Mineral mineralProducido = new Mineral(0);
        for(int i = 0; i<201; i++){
            mineralProducido.agregar(zangano.producir());
        }

        // Assert
        assertEquals(mineralProducidoEsperado, mineralProducido);

    }

    @Test
    public void nexoMineralNoRecolectaMasMineralLuegoDeAgotadoElRecurso(){
        // Arrange
        Mineral mineralProducidoEsperado = new Mineral(2000);
        Mineral mineralRecolectado = new Mineral(0);
        NexoMineral nexo = new NexoMineral();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Mapa());
        casillero.setRecurso(new Nodo());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral(2000));
        casillero.setEspacioDeConstruccion(new RangoPilon());
        nexo.construir(casillero, recursos);
        nexo.nuevoTurno(new Protoss());
        nexo.nuevoTurno(new Protoss());
        nexo.nuevoTurno(new Protoss());
        nexo.nuevoTurno(new Protoss());


        // nexo recolecta 20 por turno, en 101 turnos recolecta 2020, el nodo tiene 2000
        for(int i = 0; i<101; i++){
            mineralRecolectado.agregar(nexo.recolectarMineral());
        }

        // Assert
        assertEquals(mineralProducidoEsperado,mineralRecolectado);

    }
}
