package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.Contenedor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.nio.file.Paths;

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
        AudioClip audio = new AudioClip(Paths.get("src/main/java/edu/fiuba/algo3/vista/audio/confirmacion.wav").toUri().toString());
        audio.play();
        this.cargarProximaEscena();
        stage.setScene(proximaEscena);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(false);
    }
}
