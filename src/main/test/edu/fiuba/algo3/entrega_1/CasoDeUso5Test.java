package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Acceso;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.FueraDeRangoDePilon;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Espiral;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Extractor;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Guarida;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.mapa.CasilleroSinMoho;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso5Test {
    @Test
    public void extractorSePuedeConstruirEnUnCasilleroConMoho(){
        // Arrange
        Extractor extractor = new Extractor();
        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(), 1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        casillero.setEspacioDeConstruccion(new Moho());
        extractor.construir(casillero, recursos);

        // Assert
        assertEquals(Extractor.class, casillero.obtenerConstruccion().getClass());
    }

    @Test
    public void extractorNoSePuedeConstruirEnUnCasilleroSinMoho(){
        // Arrange
        Extractor extractor = new Extractor();
        Casillero casillero = new Casillero(new Gas(),new AreaTerrestre(),1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());

        // Assert
        assertThrows(CasilleroSinMoho.class,() -> extractor.construir(casillero, recursos));
    }

    @Test
    public void reservaDeReproduccionSePuedeConstruirEnUnCasilleroConMoho(){
        // Arrange
        ReservaDeReproduccion reserva = new ReservaDeReproduccion();
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        casillero.setEspacioDeConstruccion(new Moho());
        reserva.construir(casillero, recursos);

        // Assert
        assertEquals(ReservaDeReproduccion.class, casillero.obtenerConstruccion().getClass());
    }

    @Test
    public void reservaDeReproduccionNoSePuedeConstruirEnUnCasilleroSinMoho(){
        // Arrange
        ReservaDeReproduccion reserva = new ReservaDeReproduccion();
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());

        // Assert
        assertThrows(CasilleroSinMoho.class,() -> reserva.construir(casillero, recursos));
    }

    @Test
    public void guaridaSePuedeConstruirEnUnCasilleroConMoho(){
        // Arrange
        Guarida guarida = new Guarida();
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        recursos.agregar(new Gas());
        casillero.setEspacioDeConstruccion(new Moho());
        guarida.construir(casillero, recursos);

        // Assert
        assertEquals(Guarida.class, casillero.obtenerConstruccion().getClass());
    }

    @Test
    public void guaridaNoSePuedeConstruirEnUnCasilleroSinMoho(){
        // Arrange
        Guarida guarida = new Guarida();
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        recursos.agregar(new Gas());

        // Assert
        assertThrows(CasilleroSinMoho.class,() -> guarida.construir(casillero, recursos));
    }

    @Test
    public void espiralSePuedeConstruirEnUnCasilleroConMoho(){
        // Arrange
        Espiral espiral = new Espiral();
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        recursos.agregar(new Gas());
        casillero.setEspacioDeConstruccion(new Moho());
        espiral.construir(casillero, recursos);

        // Assert
        assertEquals(Espiral.class, casillero.obtenerConstruccion().getClass());
    }

    @Test
    public void espiralNoSePuedeConstruirEnUnCasilleroSinMoho(){
        // Arrange
        Espiral espiral = new Espiral();
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        recursos.agregar(new Gas());

        // Assert
        assertThrows(CasilleroSinMoho.class,() -> espiral.construir(casillero, recursos));
    }

    @Test
    public void accesoSePuedeConstruirEnUnCasilleroDentroDelRangoDelPilon(){
        // Arrange
        Acceso acceso = new Acceso();
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        recursos.agregar(new Gas());
        casillero.setEspacioDeConstruccion(new RangoPilon());
        acceso.construir(casillero, recursos);

        // Assert
        assertEquals(Acceso.class, casillero.obtenerConstruccion().getClass());
    }

    @Test
    public void accesoNoSePuedeConstruirEnUnCasilleroFueraDelRangoDelPilon(){
        // Arrange
        Acceso acceso = new Acceso();
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        recursos.agregar(new Gas());

        // Assert
        assertThrows(FueraDeRangoDePilon.class,() -> acceso.construir(casillero, recursos));
    }

    @Test
    public void puertoEstelarSePuedeConstruirEnUnCasilleroDentroDelRangoDelPilon(){
        // Arrange
        PuertoEstelar puerto = new PuertoEstelar();
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        recursos.agregar(new Gas());
        casillero.setEspacioDeConstruccion(new RangoPilon());
        puerto.construir(casillero, recursos);

        // Assert
        assertEquals(PuertoEstelar.class, casillero.obtenerConstruccion().getClass());
    }

    @Test
    public void puertoEstelarNoSePuedeConstruirEnUnCasilleroFueraDelRangoDelPilon(){
        // Arrange
        PuertoEstelar puerto = new PuertoEstelar();
        Casillero casillero = new Casillero(new AreaTerrestre(),1, 1, new Mapa());
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral());
        recursos.agregar(new Gas());

        // Assert
        assertThrows(FueraDeRangoDePilon.class,() -> puerto.construir(casillero, recursos));
    }

}
