package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.vista.eventos.BotonNuevaPartidaEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorInicio extends VBox {
    public ContenedorInicio(Stage stage) {
        super();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        this.setBackground(new Background(new BackgroundFill(Color.valueOf("#D0CFE0"), CornerRadii.EMPTY, Insets.EMPTY)));

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        etiqueta.setText("AlgoStar");
        etiqueta.setTextFill(Color.web("#000000"));

        Button botonNuevaPartida = new Button();
        botonNuevaPartida.setText("Nueva partida");

        Scene proximaEscena = new Scene(new ContenedorElegirJugador(stage,new AlgoStar(),""), 800, 800);
        BotonNuevaPartidaEventHandler botonNuevaPartidaEventHandler = new BotonNuevaPartidaEventHandler(stage, proximaEscena);
        botonNuevaPartida.setOnAction(botonNuevaPartidaEventHandler);

        this.getChildren().addAll(etiqueta, botonNuevaPartida);
    }
}
