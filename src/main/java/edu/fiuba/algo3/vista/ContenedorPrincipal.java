package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.AlgoStar;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {
    private final Stage stage;
    public ContenedorPrincipal(Stage stage, AlgoStar juego){
        super();
        this.stage = stage;

        Label label = new Label();
        label.setText("contenedor principal");

        this.mostrarMenuRecursos();
        this.mostrarMapa();

        this.getChildren().addAll(label);
    }

    private void mostrarMapa() {
    }

    private void mostrarMenuRecursos(){

    }
}
