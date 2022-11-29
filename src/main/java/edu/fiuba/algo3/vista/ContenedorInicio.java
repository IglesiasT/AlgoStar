package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ContenedorInicio extends VBox {
    public ContenedorInicio() {
        super();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        etiqueta.setText("AlgoStar");
        etiqueta.setTextFill(Color.web("#000000"));

        Button botonNuevaPartida = new Button();
        botonNuevaPartida.setText("Nueva partida");

        this.getChildren().addAll(etiqueta, botonNuevaPartida);
    }
}
