package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.ContenedorElegirJugadores;
import edu.fiuba.algo3.vista.ContenedorInicio;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("AlgoStar");

        ContenedorInicio contenedorInicio = new ContenedorInicio(stage);
        Scene escenaInicio = new Scene(contenedorInicio, 800, 800);

        stage.setScene(escenaInicio);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}