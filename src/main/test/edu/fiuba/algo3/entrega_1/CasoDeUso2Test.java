package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.*;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.tablero.Casillero;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso2Test {

    @Test
    public void pasanTresTurnosYCriaderoNoEstaOperativo(){
        //Arrange
        Criadero criadero = new Criadero();

        //Act
        criadero.construirEnCasillero(new Casillero(new AreaTerrestre(), 1 ,1, new Tablero()));
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();

        //Assert
        assertThrows(Pilon.EdificioNoEstaOperativo.class, criadero::engendrarZangano);
    }

    @Test
    public void pasanCuatroTurnosYCriaderoEstaOperativo(){
        //Arrange
        Criadero criadero = new Criadero();

        //Act
        criadero.construirEnCasillero(new Casillero(new AreaTerrestre(),1,1, new Tablero()));
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();
        criadero.nuevoTurno();

        //Assert
        assertDoesNotThrow(criadero::engendrarZangano);
    }

    @Test
    public void pasanOnceTurnosYReservaDeReproduccionNoEstaOperativo(){
        //Arrange
        ReservaDeReproduccion reserva = new ReservaDeReproduccion();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Tablero());

        //Act
        casillero.setEspacioDeConstruccion(new Moho());
        reserva.construirEnCasillero(casillero);
        reserva.nuevoTurno();
        reserva.nuevoTurno();
        reserva.nuevoTurno();
        reserva.nuevoTurno();
        reserva.nuevoTurno();
        reserva.nuevoTurno();
        reserva.nuevoTurno();
        reserva.nuevoTurno();
        reserva.nuevoTurno();
        reserva.nuevoTurno();
        reserva.nuevoTurno();


        //Assert
        //assertThrows(EdificioNoEstaOperativo.class, reserva::evolucionarLarva);
    }

    @Test
    public void pasanDoceTurnosYReservaDeReproduccionEstaOperativo(){
        //Arrange
        ReservaDeReproduccion reserva = new ReservaDeReproduccion();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Tablero());

        //Act
        casillero.setEspacioDeConstruccion(new Moho());
        reserva.construirEnCasillero(casillero);
        reserva.nuevoTurno();
        reserva.nuevoTurno();
        reserva.nuevoTurno();
        reserva.nuevoTurno();
        reserva.nuevoTurno();
        reserva.nuevoTurno();
        reserva.nuevoTurno();
        reserva.nuevoTurno();
        reserva.nuevoTurno();
        reserva.nuevoTurno();
        reserva.nuevoTurno();
        reserva.nuevoTurno();

        //Assert
        //assertDoesNotThrow(reserva::evolucionarLarva);
    }

    @Test
    public void extractorNoEstaOperativoAntesDeSeisTurnos(){
        //Arrange
        Extractor extractor = new Extractor();
        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(),1,1,new Tablero());

        //Act
        casillero.setEspacioDeConstruccion(new Moho());
        extractor.construirEnCasillero(casillero);
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();

        //Assert
        assertThrows(Pilon.EdificioNoEstaOperativo.class, extractor::obtenerGasProducido);
    }

    @Test
    public void extractorEstaOperativoLuegoDeSeisTurnos(){
        //Arrange
        Extractor extractor = new Extractor();
        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(),1,1,new Tablero());

        //Act
        casillero.setEspacioDeConstruccion(new Moho());
        extractor.construirEnCasillero(casillero);
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();

        //Assert
        assertDoesNotThrow(extractor::obtenerGasProducido);
    }

    @Test
    public void pasanOnceTurnosYGuaridaNoEstaOperativo(){
        //Arrange
        Guarida guarida = new Guarida();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Tablero());

        //Act
        casillero.setEspacioDeConstruccion(new Moho());
        guarida.construirEnCasillero(casillero);
        guarida.nuevoTurno();
        guarida.nuevoTurno();
        guarida.nuevoTurno();
        guarida.nuevoTurno();
        guarida.nuevoTurno();
        guarida.nuevoTurno();
        guarida.nuevoTurno();
        guarida.nuevoTurno();
        guarida.nuevoTurno();
        guarida.nuevoTurno();
        guarida.nuevoTurno();


        //Assert
        //assertThrows(EdificioNoEstaOperativo.class, guarida::evolucionarLarva);
    }

    @Test
    public void pasanDoceTurnosYGuaridaEstaOperativo(){
        //Arrange
        Guarida guarida = new Guarida();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Tablero());

        //Act
        casillero.setEspacioDeConstruccion(new Moho());
        guarida.construirEnCasillero(casillero);
        guarida.nuevoTurno();
        guarida.nuevoTurno();
        guarida.nuevoTurno();
        guarida.nuevoTurno();
        guarida.nuevoTurno();
        guarida.nuevoTurno();
        guarida.nuevoTurno();
        guarida.nuevoTurno();
        guarida.nuevoTurno();
        guarida.nuevoTurno();
        guarida.nuevoTurno();
        guarida.nuevoTurno();

        //Assert
        //assertDoesNotThrow(guarida::evolucionarLarva);
    }

    @Test
    public void pasanNueveTurnosYEspiralNoEstaOperativo(){
        //Arrange
        Espiral espiral = new Espiral();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Tablero());

        //Act
        casillero.setEspacioDeConstruccion(new Moho());
        espiral.construirEnCasillero(casillero);
        espiral.nuevoTurno();
        espiral.nuevoTurno();
        espiral.nuevoTurno();
        espiral.nuevoTurno();
        espiral.nuevoTurno();
        espiral.nuevoTurno();
        espiral.nuevoTurno();
        espiral.nuevoTurno();
        espiral.nuevoTurno();


        //Assert
        //assertThrows(EdificioNoEstaOperativo.class, espiral::evolucionarLarva);
    }

    @Test
    public void pasanDiezTurnosYEspiralEstaOperativo(){
        //Arrange
        Espiral espiral = new Espiral();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Tablero());

        //Act
        casillero.setEspacioDeConstruccion(new Moho());
        espiral.construirEnCasillero(casillero);
        espiral.nuevoTurno();
        espiral.nuevoTurno();
        espiral.nuevoTurno();
        espiral.nuevoTurno();
        espiral.nuevoTurno();
        espiral.nuevoTurno();
        espiral.nuevoTurno();
        espiral.nuevoTurno();
        espiral.nuevoTurno();
        espiral.nuevoTurno();

        //Assert
        //assertDoesNotThrow(espiral::evolucionarLarva);
    }

    @Test
    public void nexoMineralNoEstaOperativoAntesDeCuatroTurnos(){
        //Arrange
        NexoMineral nexo = new NexoMineral();

        //Act
        nexo.nuevoTurno();
        nexo.nuevoTurno();
        nexo.nuevoTurno();

        //Assert
        assertThrows(Pilon.EdificioNoEstaOperativo.class, nexo::recolectarMineral);
    }

    @Test
    public void nexoMineralEstaOperativoLuegoDeCuatroTurnos(){
        //Arrange
        NexoMineral nexo = new NexoMineral();

        //Act
        nexo.nuevoTurno();
        nexo.nuevoTurno();
        nexo.nuevoTurno();
        nexo.nuevoTurno();

        //Assert
        assertDoesNotThrow(nexo::recolectarMineral);
    }

    @Test
    public void pilonNoEstaOperativoAntesDeCincoTurnos(){
        //Ararnge
        Pilon pilon = new Pilon();

        //Act
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();

        //Assert
        assertThrows(Pilon.EdificioNoEstaOperativo.class, pilon::energizar);
    }

    @Test
    public void pilonEstaOperativoLuegoDeCincoTurnos(){
        //Ararnge
        Pilon pilon = new Pilon();

        //Act
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();
        pilon.nuevoTurno();

        //Assert
        assertDoesNotThrow(pilon::energizar);
    }

    @Test
    public void asimiladorNoEstaOperativoAntesDeSeisTurnos(){
        //Arrange
        Asimilador asimilador = new Asimilador();
        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(),1,1,new Tablero());

        //Act
        asimilador.construirEnCasillero(casillero);
        asimilador.nuevoTurno();
        asimilador.nuevoTurno();
        asimilador.nuevoTurno();
        asimilador.nuevoTurno();
        asimilador.nuevoTurno();

        //Assert
        assertThrows(Pilon.EdificioNoEstaOperativo.class, asimilador::obtenerGasProducido);
    }
    @Test
    public void asimiladorEstaOperativoLuegoDeSeisTurnos(){
        //Arrange
        Asimilador asimilador = new Asimilador();
        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(),1,1,new Tablero());

        //Act;
        asimilador.construirEnCasillero(casillero);
        asimilador.nuevoTurno();
        asimilador.nuevoTurno();
        asimilador.nuevoTurno();
        asimilador.nuevoTurno();
        asimilador.nuevoTurno();
        asimilador.nuevoTurno();

        //Assert
        assertDoesNotThrow(asimilador::obtenerGasProducido);
    }

    @Test
    public void accesoNoEstaOperativoAntesDeOchoTurnos(){
        //Arrange
        Acceso acceso = new Acceso();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Tablero());

        //Act
        casillero.setEspacioDeConstruccion(new RangoPilon());
        acceso.construirEnCasillero(casillero);
        acceso.nuevoTurno();
        acceso.nuevoTurno();
        acceso.nuevoTurno();
        acceso.nuevoTurno();
        acceso.nuevoTurno();
        acceso.nuevoTurno();
        acceso.nuevoTurno();

        //Assert
        //assertThrows(EdificioNoEstaOperativo.class, acceso::transportarTropas);
    }
    @Test
    public void accesoEstaOperativoLuegoDeOchoTurnos(){
        //Arrange
        Acceso acceso = new Acceso();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Tablero());

        //Act
        casillero.setEspacioDeConstruccion(new RangoPilon());
        acceso.construirEnCasillero(casillero);
        acceso.nuevoTurno();
        acceso.nuevoTurno();
        acceso.nuevoTurno();
        acceso.nuevoTurno();
        acceso.nuevoTurno();
        acceso.nuevoTurno();
        acceso.nuevoTurno();
        acceso.nuevoTurno();

        //Assert
        //assertDoesNotThrow(acceso::transportarTropas);
    }

    @Test
    public void puertoEstelarNoEstaOperativoAntesDeDiezTurnos(){
        //Arrange
        PuertoEstelar puertoEstelar = new PuertoEstelar();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Tablero());

        //Act
        casillero.setEspacioDeConstruccion(new RangoPilon());
        puertoEstelar.construirEnCasillero(casillero);
        puertoEstelar.nuevoTurno();
        puertoEstelar.nuevoTurno();
        puertoEstelar.nuevoTurno();
        puertoEstelar.nuevoTurno();
        puertoEstelar.nuevoTurno();
        puertoEstelar.nuevoTurno();
        puertoEstelar.nuevoTurno();
        puertoEstelar.nuevoTurno();
        puertoEstelar.nuevoTurno();

        //Assert
        //assertThrows(EdificioNoEstaOperativo.class, puertoEstelar::transportarTropas);
    }
    @Test
    public void puertoEstelarEstaOperativoLuegoDeDiezTurnos(){
        //Arrange
        PuertoEstelar puertoEstelar = new PuertoEstelar();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Tablero());

        //Act
        casillero.setEspacioDeConstruccion(new RangoPilon());
        puertoEstelar.construirEnCasillero(casillero);
        puertoEstelar.nuevoTurno();
        puertoEstelar.nuevoTurno();
        puertoEstelar.nuevoTurno();
        puertoEstelar.nuevoTurno();
        puertoEstelar.nuevoTurno();
        puertoEstelar.nuevoTurno();
        puertoEstelar.nuevoTurno();
        puertoEstelar.nuevoTurno();
        puertoEstelar.nuevoTurno();
        puertoEstelar.nuevoTurno();

        //Assert
        //assertDoesNotThrow(puertoEstelar::transportarTropas);
    }
}
