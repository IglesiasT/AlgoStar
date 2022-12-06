package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.ContenedorInicio;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    public static final int TAMANIO_CASILLERO = 30;

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