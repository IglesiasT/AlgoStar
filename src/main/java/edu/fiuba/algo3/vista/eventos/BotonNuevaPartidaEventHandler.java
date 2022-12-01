package edu.fiuba.algo3.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonNuevaPartidaEventHandler implements EventHandler<ActionEvent> {
    private Stage stage;
    private Scene proximaEscena;

    public BotonNuevaPartidaEventHandler(Stage stage, Scene proximaEscena){
        this.stage = stage;
        this.proximaEscena = proximaEscena;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(proximaEscena);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(false);
    }
}