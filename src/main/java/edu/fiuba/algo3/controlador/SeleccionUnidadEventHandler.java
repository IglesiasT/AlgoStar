package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.construcciones.unidades.Unidad;
import edu.fiuba.algo3.vista.contenedoresAcciones.ContenedorAccion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SeleccionUnidadEventHandler implements EventHandler<ActionEvent> {

    private ContenedorAccion accion;
    private Unidad unidad;
    public SeleccionUnidadEventHandler(ContenedorAccion accion, Unidad unidad){
        this.accion = accion;
        this.unidad = unidad;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        accion.setUnidadElegida(unidad);
    }
}
