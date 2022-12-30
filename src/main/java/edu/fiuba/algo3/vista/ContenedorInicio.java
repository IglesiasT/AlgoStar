package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonNuevaPartidaEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorInicio extends VBox {

    public ContenedorInicio(Stage stage) {
        super();
        this.setAlignment(Pos.CENTER);

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Castellar", FontWeight.BOLD, 110));
        etiqueta.setText("AlgoStar");
        etiqueta.setTextFill(Color.web("#FFFFFF"));
        etiqueta.setTranslateY(-450);

        Button botonNuevaPartida = new Button();
        botonNuevaPartida.setBackground(new Background(new BackgroundFill(Color.valueOf("#FFFFFF"), CornerRadii.EMPTY, Insets.EMPTY)));
        botonNuevaPartida.setText("Comenzar");
        botonNuevaPartida.setFont(Font.font("Agency FB", FontWeight.BOLD, 20));
        botonNuevaPartida.setTranslateY(-400);

        Scene proximaEscena = new Scene(new ContenedorManual(stage), 950, 950);
        BotonNuevaPartidaEventHandler botonNuevaPartidaEventHandler = new BotonNuevaPartidaEventHandler(stage, proximaEscena);
        botonNuevaPartida.setOnAction(botonNuevaPartidaEventHandler);
        botonNuevaPartida.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        CanvasConVideo background = new CanvasConVideo("/videos/videoInicio.mp4");

        this.getChildren().addAll(background.obtenerCanvas(), etiqueta, botonNuevaPartida);
    }
}
