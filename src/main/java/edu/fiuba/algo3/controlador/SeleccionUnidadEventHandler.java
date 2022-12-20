package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.construcciones.unidades.Unidad;
import edu.fiuba.algo3.vista.contenedoresAcciones.ContenedorAccion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

public class SeleccionUnidadEventHandler implements EventHandler<ActionEvent> {

    private ContenedorAccion accion;
    private Unidad unidad;
    public SeleccionUnidadEventHandler(ContenedorAccion accion, Unidad unidad){
        this.accion = accion;
        this.unidad = unidad;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        AudioClip audio = new AudioClip(this.getClass().getResource("confirmacion.wav").toString());
        audio.play();
        accion.setUnidadElegida(unidad);
    }
}
