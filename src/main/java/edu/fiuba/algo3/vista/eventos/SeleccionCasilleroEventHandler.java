package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.vista.contenedoresAcciones.ContenedorAccion;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SeleccionCasilleroEventHandler implements EventHandler<MouseEvent> {
    private Stage stage;
    private ContenedorAccion accion;
    private Casillero casilleroSeleccionado;

    public SeleccionCasilleroEventHandler(Stage stage, ContenedorAccion accion, Casillero casilleroSeleccionado){
        this.stage = stage;
        this.accion = accion;
        this.casilleroSeleccionado = casilleroSeleccionado;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        accion.setCasilleroElegido(casilleroSeleccionado);
    }
}