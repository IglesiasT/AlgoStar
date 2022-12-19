package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Asimilador;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.NexoMineral;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Pilon;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Criadero;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.Dragon;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.Scout;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Guardian;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Hidralisco;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Mutalisco;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.Zerling;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso18Test {
    // Unidades Zerg
    @Test
    public void zerlingInflinge4DeDanioEnTierra(){
        // Arrange
        Zerling zerling = new Zerling();
        NexoMineral nexoMineral = new NexoMineral();
        int valorEsperado = 246;    //250 escudo - 4 ataque
        Raza raza = new Zerg();
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        recursos.agregar(new Mineral(1000));
        recursos.agregar(new Gas(1000));

        // Act

        zerling.nuevoTurno(raza);
        zerling.nuevoTurno(raza);

        zerling.construir(new Casillero(new AreaTerrestre(), 1, 1, new Mapa()), recursos);

        nexoMineral.establecerUbicacion(new Casillero(new AreaTerrestre(), 1, 2, new Mapa()));
        zerling.atacar(nexoMineral);

        // Assert
        assertEquals(valorEsperado, nexoMineral.obtenerEscudo());
    }

    @Test
    public void hidraliscoInflinge10DeDanioEnTierra(){
        // Arrange
        Hidralisco hidralisco = new Hidralisco();
        Raza raza = new Zerg();
        Pilon pilon = new Pilon();
        int valorEsperado = 290;    //290 escudo - 10 ataque
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        recursos.agregar(new Mineral(1000));
        recursos.agregar(new Gas(1000));

        // Act

        hidralisco.nuevoTurno(raza);
        hidralisco.nuevoTurno(raza);
        hidralisco.nuevoTurno(raza);
        hidralisco.nuevoTurno(raza);

        hidralisco.construir(new Casillero(new AreaTerrestre(), 1, 1, new Mapa()), recursos);
        pilon.establecerUbicacion(new Casillero(new AreaTerrestre(), 1, 2, new Mapa()));
        hidralisco.atacar(pilon);

        // Assert
        assertEquals(valorEsperado, pilon.obtenerEscudo());
    }

    @Test
    public void hidraliscoInflinge10DeDanioEnAire(){
        // Arrange
        Hidralisco hidralisco = new Hidralisco();
        Scout scout = new Scout();
        Raza raza = new Zerg();
        int valorEsperado = 90;    //100 escudo - 10 ataque
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        recursos.agregar(new Mineral(1000));
        recursos.agregar(new Gas(1000));

        // Act

        hidralisco.nuevoTurno(raza);
        hidralisco.nuevoTurno(raza);
        hidralisco.nuevoTurno(raza);
        hidralisco.nuevoTurno(raza);

        hidralisco.construir(new Casillero(new AreaTerrestre(), 1, 1, new Mapa()), recursos);
        scout.construir(new Casillero(new AreaTerrestre(), 1, 1, new Mapa()), recursos);
        hidralisco.atacar(scout);

        // Assert
        assertEquals(valorEsperado, scout.obtenerEscudo());
    }

    @Test
    public void mutaliscoInflinge9DeDanioEnTierra(){
        // Arrange
        Mutalisco mutalisco = new Mutalisco();
        Zealot zealot = new Zealot();
        Raza raza = new Zerg();
        int valorEsperado = 51;    //60 escudo - 9 ataque
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        recursos.agregar(new Mineral(1000));
        recursos.agregar(new Gas(1000));

        // Act

        mutalisco.nuevoTurno(raza);
        mutalisco.nuevoTurno(raza);
        mutalisco.nuevoTurno(raza);
        mutalisco.nuevoTurno(raza);
        mutalisco.nuevoTurno(raza);
        mutalisco.nuevoTurno(raza);
        mutalisco.nuevoTurno(raza);

        mutalisco.construir(new Casillero(new AreaTerrestre(), 1, 1, new Mapa()), recursos);
        zealot.construir(new Casillero(new AreaTerrestre(), 1, 1, new Mapa()), recursos);

        mutalisco.atacar(zealot);

        // Assert
        assertEquals(valorEsperado, zealot.obtenerEscudo());
    }

    @Test
    public void mutaliscoInflinge9DeDanioEnAire(){
        // Arrange
        Mutalisco mutalisco = new Mutalisco();
        Scout scout = new Scout();
        Raza raza = new Zerg();
        int valorEsperado = 91;    //100 escudo - 9 ataque
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        recursos.agregar(new Mineral(1000));
        recursos.agregar(new Gas(1000));

        // Act

        mutalisco.nuevoTurno(raza);
        mutalisco.nuevoTurno(raza);
        mutalisco.nuevoTurno(raza);
        mutalisco.nuevoTurno(raza);
        mutalisco.nuevoTurno(raza);
        mutalisco.nuevoTurno(raza);
        mutalisco.nuevoTurno(raza);

        mutalisco.construir(new Casillero(new AreaTerrestre(), 1, 1, new Mapa()), recursos);
        scout.construir(new Casillero(new AreaTerrestre(), 1, 1, new Mapa()), recursos);

        mutalisco.atacar(scout);

        // Assert
        assertEquals(valorEsperado, scout.obtenerEscudo());
    }

    @Test
    public void guardianInflinge25DeDanioEnTierra(){
        // Arrange
        Guardian guardian = new Guardian();
        Asimilador asimilador = new Asimilador();
        Raza raza = new Zerg();
        int valorEsperado = 425;    //450 escudo - 25 ataque
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        recursos.agregar(new Mineral(1000));
        recursos.agregar(new Gas(1000));

        // Act

        guardian.nuevoTurno(raza);
        guardian.nuevoTurno(raza);
        guardian.nuevoTurno(raza);
        guardian.nuevoTurno(raza);

        guardian.construir(new Casillero(new AreaTerrestre(), 1, 1, new Mapa()), recursos);
        asimilador.establecerUbicacion(new Casillero(new AreaTerrestre(), 1, 1, new Mapa()));
        guardian.atacar(asimilador);

        // Assert
        assertEquals(valorEsperado, asimilador.obtenerEscudo());
    }

    // Unidades Protoss
    @Test
    public void zealotInflinge8DeDanioEnTierra(){
        // Arrange
        Zealot zealot = new Zealot();
        Raza raza = new Protoss();
        ReservaDeReproduccion reserva = new ReservaDeReproduccion();
        int valorEsperado = 992;    //1000 vida - 8 ataque
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        recursos.agregar(new Mineral(1000));
        recursos.agregar(new Gas(1000));

        // Act

        zealot.nuevoTurno(raza);
        zealot.nuevoTurno(raza);
        zealot.nuevoTurno(raza);
        zealot.nuevoTurno(raza);

        zealot.construir(new Casillero(new AreaTerrestre(), 1, 1, new Mapa()), recursos);
        reserva.establecerUbicacion(new Casillero(new AreaTerrestre(), 1, 1, new Mapa()));
        zealot.atacar(reserva);

        // Assert
        assertEquals(valorEsperado, reserva.obtenerVida());
    }
    @Test
    public void dragonInflinge20DeDanioEnTierra(){
        // Arrange
        Dragon dragon = new Dragon();
        Criadero criadero = new Criadero();
        Raza raza = new Protoss();
        int valorEsperado = 480;    //500 vida - 20 ataque
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        recursos.agregar(new Mineral(1000));
        recursos.agregar(new Gas(1000));

        // Act

        dragon.nuevoTurno(raza);
        dragon.nuevoTurno(raza);
        dragon.nuevoTurno(raza);
        dragon.nuevoTurno(raza);
        dragon.nuevoTurno(raza);
        dragon.nuevoTurno(raza);

        dragon.construir(new Casillero(new AreaTerrestre(), 1, 1, new Mapa()), recursos);
        criadero.establecerUbicacion(new Casillero(new AreaTerrestre(), 1, 2, new Mapa()));
        dragon.atacar(criadero);

        // Assert
        assertEquals(valorEsperado, criadero.obtenerVida());
    }
    @Test
    public void dragonInflinge20DeDanioEnAire(){
        // Arrange
        Dragon dragon = new Dragon();
        Guardian guardian = new Guardian();
        Raza raza = new Protoss();
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        recursos.agregar(new Mineral(1000));
        recursos.agregar(new Gas(1000));
        int valorEsperado = 80;    //100 vida - 20 ataque

        // Act

        dragon.nuevoTurno(raza);
        dragon.nuevoTurno(raza);
        dragon.nuevoTurno(raza);
        dragon.nuevoTurno(raza);
        dragon.nuevoTurno(raza);
        dragon.nuevoTurno(raza);

        dragon.construir(new Casillero(new AreaTerrestre(), 1, 1, new Mapa()), recursos);
        guardian.construir(new Casillero(new AreaTerrestre(), 1, 1, new Mapa()), recursos);
        dragon.atacar(guardian);

        // Assert
        assertEquals(valorEsperado, guardian.obtenerVida());
    }
    @Test
    public void scoutInflinge8DeDanioEnTierra(){
        // Arrange
        Scout scout = new Scout();
        Criadero criadero = new Criadero();
        Raza raza = new Protoss();
        int valorEsperado = 492;    //500 vida - 8 ataque
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        recursos.agregar(new Mineral(1000));
        recursos.agregar(new Gas(1000));

        // Act

        scout.nuevoTurno(raza);
        scout.nuevoTurno(raza);
        scout.nuevoTurno(raza);
        scout.nuevoTurno(raza);
        scout.nuevoTurno(raza);
        scout.nuevoTurno(raza);
        scout.nuevoTurno(raza);
        scout.nuevoTurno(raza);
        scout.nuevoTurno(raza);

        scout.construir(new Casillero(new AreaTerrestre(), 1, 1, new Mapa()), recursos);
        criadero.establecerUbicacion(new Casillero(new AreaTerrestre(), 1, 2, new Mapa()));

        scout.atacar(criadero);

        // Assert
        assertEquals(valorEsperado, criadero.obtenerVida());
    }
    @Test
    public void scoutInflinge14DeDanioEnAire(){
        // Arrange
        Scout scout = new Scout();
        Mutalisco mutalisco = new Mutalisco();
        Raza raza = new Protoss();
        int valorEsperado = 106;    //120 vida - 14 ataque
        ListadoDeRecursos recursos = new ListadoDeRecursos();
        recursos.agregar(new Mineral(1000));
        recursos.agregar(new Gas(1000));

        // Act

        scout.nuevoTurno(raza);
        scout.nuevoTurno(raza);
        scout.nuevoTurno(raza);
        scout.nuevoTurno(raza);
        scout.nuevoTurno(raza);
        scout.nuevoTurno(raza);
        scout.nuevoTurno(raza);
        scout.nuevoTurno(raza);
        scout.nuevoTurno(raza);

        mutalisco.construir(new Casillero(new AreaEspacial(), 1, 1, new Mapa()), recursos);
        scout.construir(new Casillero(new AreaTerrestre(), 1, 1, new Mapa()), recursos);
        scout.atacar(mutalisco);

        // Assert
        assertEquals(valorEsperado, mutalisco.obtenerVida());
    }
}
