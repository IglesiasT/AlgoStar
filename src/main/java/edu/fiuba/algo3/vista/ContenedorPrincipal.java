package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.AlgoStar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {
    private final Stage stage;
    private AlgoStar juego;
    public ContenedorPrincipal(Stage stage, AlgoStar juego){
        super();
        this.juego = juego;
        this.stage = stage;

        Label label = new Label();
        label.setText("contenedor principal");

        // manipular modelo

        this.getChildren().addAll(label);
    }
}
