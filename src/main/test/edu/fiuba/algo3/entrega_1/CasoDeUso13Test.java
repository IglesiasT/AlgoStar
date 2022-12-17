package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Criadero;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Nodo;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import org.junit.jupiter.api.Test;

public class CasoDeUso13Test {

    @Test
    public void seDestruyeCriaderoPeroElMohoQueda(){
        // Arrange
        Mapa mapa = new Mapa();
        Casillero casillero1 = mapa.obtenerCasillero(1,1);
        casillero1.setArea(new AreaTerrestre());
        casillero1.setRecurso(new SinRecurso());
        Criadero criadero = new Criadero();
        ListadoDeRecursos recursos = new ListadoDeRecursos();

        // Act
        recursos.agregar(new Mineral(2000));
        criadero.construir(casillero1, recursos);
        criadero.nuevoTurno(new Zerg());
        criadero.nuevoTurno(new Zerg());
        criadero.nuevoTurno(new Zerg());
        criadero.nuevoTurno(new Zerg());
        criadero.nuevoTurno(new Zerg());
        criadero.nuevoTurno(new Zerg());
        criadero.destruir();
        criadero.nuevoTurno(new Zerg());

        // Assert
        assert mapa.obtenerCasillero(1,3).contiene(new Moho());
    }
}
