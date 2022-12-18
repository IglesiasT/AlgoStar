package edu.fiuba.algo3.vista.contenedoresAcciones;

import edu.fiuba.algo3.modelo.construcciones.unidades.Unidad;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.vista.Contenedor;

public interface ContenedorAccion extends Contenedor {
    void setCasilleroElegido(Casillero casillero);
    void setUnidadElegida(Unidad unidad);
}
