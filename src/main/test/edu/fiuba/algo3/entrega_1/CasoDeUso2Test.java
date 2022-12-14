package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.*;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.*;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.*;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.estados.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.mapa.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso2Test {

    @Test
    public void pasanTresTurnosYCriaderoNoEstaOperativo(){
        //Arrange
        Criadero criadero = new Criadero();
        Raza raza = new Zerg();

        //Act

        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);


        //Assert
        assertThrows(EdificioNoEstaOperativo.class, () -> criadero.engendrarZangano(new ListadoDeRecursos()));
    }

    @Test
    public void pasanCuatroTurnosYCriaderoEstaOperativo(){
        //Arrange
        Criadero criadero = new Criadero();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        recursos.agregar(new Mineral(25));
        Raza raza = new Zerg();

        //Act
        criadero.establecerUbicacion(casillero);

        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);
        criadero.nuevoTurno(raza);


        //Assert
        assertDoesNotThrow(() ->criadero.engendrarZangano(recursos));
    }

    @Test
    public void pasanOnceTurnosYReservaDeReproduccionNoEstaOperativo(){
        //Arrange
        ReservaDeReproduccion reserva = new ReservaDeReproduccion();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Mapa());
        Raza raza = new Zerg();

        //Act
        casillero.setEspacioDeConstruccion(new Moho());
        reserva.establecerUbicacion(casillero);


        reserva.nuevoTurno(raza);
        reserva.nuevoTurno(raza);
        reserva.nuevoTurno(raza);
        reserva.nuevoTurno(raza);
        reserva.nuevoTurno(raza);
        reserva.nuevoTurno(raza);
        reserva.nuevoTurno(raza);
        reserva.nuevoTurno(raza);
        reserva.nuevoTurno(raza);
        reserva.nuevoTurno(raza);
        reserva.nuevoTurno(raza);


        //Assert
        assert(!reserva.activa());
    }

    @Test
    public void pasanDoceTurnosYReservaDeReproduccionEstaOperativo(){
        // Arrange
        ReservaDeReproduccion reserva = new ReservaDeReproduccion();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Mapa());
        Raza raza = new Zerg();

        // Act
        casillero.setEspacioDeConstruccion(new Moho());
        reserva.establecerUbicacion(casillero);

        reserva.nuevoTurno(raza);
        reserva.nuevoTurno(raza);
        reserva.nuevoTurno(raza);
        reserva.nuevoTurno(raza);
        reserva.nuevoTurno(raza);
        reserva.nuevoTurno(raza);
        reserva.nuevoTurno(raza);
        reserva.nuevoTurno(raza);
        reserva.nuevoTurno(raza);
        reserva.nuevoTurno(raza);
        reserva.nuevoTurno(raza);
        reserva.nuevoTurno(raza);

        // Assert
        assert(reserva.activa());
    }

    @Test
    public void extractorNoEstaOperativoAntesDeSeisTurnos(){
        // Arrange
        Extractor extractor = new Extractor();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Mapa());

        // Act
        casillero.setEspacioDeConstruccion(new Moho());
        extractor.establecerUbicacion(casillero);
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());

        // Assert
        assert(!extractor.activa());
    }

    @Test
    public void extractorEstaOperativoLuegoDeSeisTurnos(){
        // Arrange
        Extractor extractor = new Extractor();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Mapa());

        //Act
        casillero.setEspacioDeConstruccion(new Moho());
        extractor.establecerUbicacion(casillero);
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());
        extractor.nuevoTurno(new Zerg());

        //Assert
        assert(extractor.activa());
    }

    @Test
    public void pasanOnceTurnosYGuaridaNoEstaOperativo(){
        // Arrange
        Guarida guarida = new Guarida();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Mapa());
        Raza raza = new Zerg();

        // Act
        casillero.setEspacioDeConstruccion(new Moho());
        guarida.establecerUbicacion(casillero);

        guarida.nuevoTurno(raza);
        guarida.nuevoTurno(raza);
        guarida.nuevoTurno(raza);
        guarida.nuevoTurno(raza);
        guarida.nuevoTurno(raza);
        guarida.nuevoTurno(raza);
        guarida.nuevoTurno(raza);
        guarida.nuevoTurno(raza);
        guarida.nuevoTurno(raza);
        guarida.nuevoTurno(raza);
        guarida.nuevoTurno(raza);


        // Assert
        assert(!guarida.activa());
    }

    @Test
    public void pasanDoceTurnosYGuaridaEstaOperativo(){
        // Arrange
        Guarida guarida = new Guarida();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        Raza raza = new Zerg();

        // Act
        recursos.agregar(new Mineral(2000));
        recursos.agregar(new Gas(2000));
        casillero.setEspacioDeConstruccion(new Moho());

        guarida.nuevoTurno(raza);
        guarida.nuevoTurno(raza);
        guarida.nuevoTurno(raza);
        guarida.nuevoTurno(raza);
        guarida.nuevoTurno(raza);
        guarida.nuevoTurno(raza);
        guarida.nuevoTurno(raza);
        guarida.nuevoTurno(raza);
        guarida.nuevoTurno(raza);
        guarida.nuevoTurno(raza);
        guarida.nuevoTurno(raza);
        guarida.nuevoTurno(raza);

        // Assert
        assert(guarida.activa());
    }

    @Test
    public void pasanNueveTurnosYEspiralNoEstaOperativo(){
        // Arrange
        Espiral espiral = new Espiral();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Mapa());
        Raza raza = new Zerg();

        // Act
        casillero.setEspacioDeConstruccion(new Moho());
        espiral.establecerUbicacion(casillero);

        espiral.nuevoTurno(raza);
        espiral.nuevoTurno(raza);
        espiral.nuevoTurno(raza);
        espiral.nuevoTurno(raza);
        espiral.nuevoTurno(raza);
        espiral.nuevoTurno(raza);
        espiral.nuevoTurno(raza);
        espiral.nuevoTurno(raza);
        espiral.nuevoTurno(raza);


        // Assert
        assert(!espiral.activa());
    }

    @Test
    public void pasanDiezTurnosYEspiralEstaOperativo(){
        // Arrange
        Espiral espiral = new Espiral();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Mapa());
        Raza raza = new Zerg();

        // Act
        casillero.setEspacioDeConstruccion(new Moho());
        espiral.establecerUbicacion(casillero);

        espiral.nuevoTurno(raza);
        espiral.nuevoTurno(raza);
        espiral.nuevoTurno(raza);
        espiral.nuevoTurno(raza);
        espiral.nuevoTurno(raza);
        espiral.nuevoTurno(raza);
        espiral.nuevoTurno(raza);
        espiral.nuevoTurno(raza);
        espiral.nuevoTurno(raza);
        espiral.nuevoTurno(raza);

        // Assert
        assert(espiral.activa());
    }

    @Test
    public void nexoMineralNoEstaOperativoAntesDeCuatroTurnos(){
        // Arrange
        NexoMineral nexo = new NexoMineral();

        // Act
        nexo.nuevoTurno(new Protoss());
        nexo.nuevoTurno(new Protoss());
        nexo.nuevoTurno(new Protoss());

        // Assert
        assert(!nexo.activa());;
    }

    @Test
    public void nexoMineralEstaOperativoLuegoDeCuatroTurnos(){
        // Arrange
        NexoMineral nexo = new NexoMineral();

        // Act
        nexo.nuevoTurno(new Protoss());
        nexo.nuevoTurno(new Protoss());
        nexo.nuevoTurno(new Protoss());
        nexo.nuevoTurno(new Protoss());

        // Assert
        assert(nexo.activa());;
    }

    @Test
    public void pilonNoEstaOperativoAntesDeCincoTurnos(){
        // Ararnge
        Pilon pilon = new Pilon();

        // Act
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());

        // Assert
        assertThrows(EdificioNoEstaOperativo.class, pilon::energizar);
    }

    @Test
    public void pilonEstaOperativoLuegoDeCincoTurnos(){
        // Ararnge
        Pilon pilon = new Pilon();

        // Act
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());
        pilon.nuevoTurno(new Protoss());

        // Assert
        assertDoesNotThrow(pilon::energizar);
    }

    @Test
    public void asimiladorNoEstaOperativoAntesDeSeisTurnos(){
        // Arrange
        Asimilador asimilador = new Asimilador();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Mapa());

        // Act
        asimilador.establecerUbicacion(casillero);
        asimilador.nuevoTurno(new Protoss());
        asimilador.nuevoTurno(new Protoss());
        asimilador.nuevoTurno(new Protoss());
        asimilador.nuevoTurno(new Protoss());
        asimilador.nuevoTurno(new Protoss());

        // Assert
        assert(!asimilador.activa());;
    }
    @Test
    public void asimiladorEstaOperativoLuegoDeSeisTurnos(){
        // Arrange
        Asimilador asimilador = new Asimilador();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Mapa());

        // Act;
        asimilador.establecerUbicacion(casillero);
        asimilador.nuevoTurno(new Protoss());
        asimilador.nuevoTurno(new Protoss());
        asimilador.nuevoTurno(new Protoss());
        asimilador.nuevoTurno(new Protoss());
        asimilador.nuevoTurno(new Protoss());
        asimilador.nuevoTurno(new Protoss());

        // Assert
        assert(asimilador.activa());;
    }

    @Test
    public void accesoNoEstaOperativoAntesDeOchoTurnos(){
        // Arrange
        Acceso acceso = new Acceso();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Mapa());
        Raza raza = new Protoss();

        // Act
        casillero.setEspacioDeConstruccion(new RangoPilon());
        acceso.establecerUbicacion(casillero);

        acceso.nuevoTurno(raza);
        acceso.nuevoTurno(raza);
        acceso.nuevoTurno(raza);
        acceso.nuevoTurno(raza);
        acceso.nuevoTurno(raza);
        acceso.nuevoTurno(raza);
        acceso.nuevoTurno(raza);


        // Assert
        assert(!acceso.activa());
    }
    @Test
    public void accesoEstaOperativoLuegoDeOchoTurnos(){
        // Arrange
        Acceso acceso = new Acceso();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Mapa());
        Raza raza = new Protoss();

        // Act
        casillero.setEspacioDeConstruccion(new RangoPilon());
        acceso.establecerUbicacion(casillero);

        acceso.nuevoTurno(raza);
        acceso.nuevoTurno(raza);
        acceso.nuevoTurno(raza);
        acceso.nuevoTurno(raza);
        acceso.nuevoTurno(raza);
        acceso.nuevoTurno(raza);
        acceso.nuevoTurno(raza);
        acceso.nuevoTurno(raza);

        // Assert
        assert(acceso.activa());

    }

    @Test
    public void puertoEstelarNoEstaOperativoAntesDeDiezTurnos(){
        // Arrange
        PuertoEstelar puertoEstelar = new PuertoEstelar();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Mapa());
        Raza raza = new Protoss();

        // Act
        casillero.setEspacioDeConstruccion(new RangoPilon());
        puertoEstelar.establecerUbicacion(casillero);

        puertoEstelar.nuevoTurno(raza);
        puertoEstelar.nuevoTurno(raza);
        puertoEstelar.nuevoTurno(raza);
        puertoEstelar.nuevoTurno(raza);
        puertoEstelar.nuevoTurno(raza);
        puertoEstelar.nuevoTurno(raza);
        puertoEstelar.nuevoTurno(raza);
        puertoEstelar.nuevoTurno(raza);
        puertoEstelar.nuevoTurno(raza);

        // Assert
        assert(!puertoEstelar.activa());
    }
    @Test
    public void puertoEstelarEstaOperativoLuegoDeDiezTurnos(){
        // Arrange
        PuertoEstelar puertoEstelar = new PuertoEstelar();
        Casillero casillero = new Casillero(new AreaTerrestre(),1,1,new Mapa());
        Raza raza = new Protoss();

        // Act
        casillero.setEspacioDeConstruccion(new RangoPilon());
        puertoEstelar.establecerUbicacion(casillero);

        puertoEstelar.nuevoTurno(raza);
        puertoEstelar.nuevoTurno(raza);
        puertoEstelar.nuevoTurno(raza);
        puertoEstelar.nuevoTurno(raza);
        puertoEstelar.nuevoTurno(raza);
        puertoEstelar.nuevoTurno(raza);
        puertoEstelar.nuevoTurno(raza);
        puertoEstelar.nuevoTurno(raza);
        puertoEstelar.nuevoTurno(raza);
        puertoEstelar.nuevoTurno(raza);

        // Assert
        assert(puertoEstelar.activa());
    }
}
