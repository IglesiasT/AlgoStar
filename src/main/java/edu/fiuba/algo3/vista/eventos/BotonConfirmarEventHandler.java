package edu.fiuba.algo3.vista.eventos;

import edu.fiuba.algo3.vista.Contenedor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonConfirmarEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene proximaEscena;
    private Contenedor contenedor;

    public BotonConfirmarEventHandler(Stage stage, Contenedor contenedor){
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
