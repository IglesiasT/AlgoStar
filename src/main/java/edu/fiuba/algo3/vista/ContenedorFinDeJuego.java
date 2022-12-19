package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorFinDeJuego extends VBox {

    private Stage stage;
    private AlgoStar juego;
    private Jugador jugador;
    public ContenedorFinDeJuego(Stage stage,AlgoStar juego) {
        super();

        this.stage = stage;
        this.juego = juego;
        this.jugador = juego.obtenerGanador();

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        this.setBackground(new Background(new BackgroundFill(Color.valueOf("#D0CFE0"), CornerRadii.EMPTY, Insets.EMPTY)));

        Label etiquetaTitulo = new Label();
        etiquetaTitulo.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        etiquetaTitulo.setText("FIN DE JUEGO");
        etiquetaTitulo.setTextFill(Color.BLACK);
        this.getChildren().add(etiquetaTitulo);
        Label etiquetaGanador = new Label();
        etiquetaGanador.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        etiquetaGanador.setText("GANA");
        etiquetaGanador.setTextFill(jugador.obtenerColor());
        this.getChildren().add(etiquetaGanador);
        Label etiquetaJugador = new Label();
        etiquetaJugador.setFont(Font.font("Verdana", FontWeight.BOLD, 55));
        etiquetaJugador.setText(jugador.obtenerNombre().toUpperCase());
        etiquetaJugador.setTextFill(jugador.obtenerColor());
        this.getChildren().add(etiquetaJugador);

        Button botonFinalizar = new Button();
        botonFinalizar.setText("Finalizar");
        botonFinalizar.setOnAction(e -> Platform.exit());

        this.getChildren().addAll(botonFinalizar);

    }
}