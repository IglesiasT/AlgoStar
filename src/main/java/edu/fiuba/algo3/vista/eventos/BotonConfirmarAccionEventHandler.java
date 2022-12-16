package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.vista.ContenedorElegirAccion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonConfirmarAccionEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene proximaEscena;
    private ContenedorElegirAccion contenedor;

    public BotonConfirmarAccionEventHandler(Stage stage, ContenedorElegirAccion contenedor){
        this.stage = stage;
        this.contenedor = contenedor;
    }

    private void cargarProximaEscena(){
        this.proximaEscena = contenedor.obtenerProximaEscena();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.cargarProximaEscena();
        stage.setScene(proximaEscena);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(false);
    }
}
