package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.vista.contenedoresAcciones.ContenedorAccion;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Arrays;

public class SeleccionCasilleroEventHandler implements EventHandler<MouseEvent> {
    private Stage stage;
    private ContenedorAccion accion;
    private Casillero casilleroModelo;
    private Rectangle casilleroVista;

    private Rectangle[][] mapaBaseVista;

    public SeleccionCasilleroEventHandler(Stage stage, ContenedorAccion accion,
                                          Casillero casilleroModelo, Rectangle casilleroVista, Rectangle[][] mapaBaseVista){
        this.stage = stage;
        this.accion = accion;
        this.casilleroModelo = casilleroModelo;
        this.casilleroVista = casilleroVista;
        this.mapaBaseVista = mapaBaseVista;
    }

    private void limpiarMapa(){
        for (Rectangle[] rectangles : mapaBaseVista) {
            for (Rectangle rectangle: rectangles) {
                rectangle.setStroke(Color.TRANSPARENT);
            }
        }
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        limpiarMapa();
        accion.setCasilleroElegido(casilleroModelo);
        casilleroVista.setStroke(Color.BLACK);
    }
}