package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Objects;

public class ContenedorFinDeJuego extends VBox {

    private Stage stage;
    private AlgoStar juego;
    private Jugador jugador;
    public ContenedorFinDeJuego(Stage stage,AlgoStar juego) {
        super();

        this.stage = stage;
        this.juego = juego;
        this.jugador = juego.obtenerGanador();

        MediaView view = new MediaView();
        Media video = new Media(Objects.requireNonNull(getClass().getResource("/videos/videoInicio.mp4")).toExternalForm());
        MediaPlayer player = new MediaPlayer(video);
        view.setMediaPlayer(player);
        player.setAutoPlay(true);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.play();

        Pane background = new Pane() ;
        background.getChildren().addAll(view);
        this.getChildren().add(background);

        this.setAlignment(Pos.CENTER);

        Label etiquetaTitulo = new Label();
        etiquetaTitulo.setFont(Font.font("Castellar", FontWeight.BOLD, 70));
        etiquetaTitulo.setText("FIN DE JUEGO");
        etiquetaTitulo.setTextFill(Color.WHITE);
        etiquetaTitulo.setTranslateY(-400);
        this.getChildren().add(etiquetaTitulo);

        Label etiquetaGanador = new Label();
        etiquetaGanador.setFont(Font.font("Castellar", FontWeight.BOLD, 35));
        etiquetaGanador.setText("GANADOR:");
        etiquetaGanador.setTextFill(jugador.obtenerColor());
        etiquetaGanador.setTranslateY(-350);
        this.getChildren().add(etiquetaGanador);

        Label etiquetaJugador = new Label();
        etiquetaJugador.setFont(Font.font("Agency FB", FontWeight.BOLD, 70));
        etiquetaJugador.setText(jugador.obtenerNombre().toUpperCase());
        etiquetaJugador.setTextFill(jugador.obtenerColor());
        etiquetaJugador.setTranslateY(-300);
        this.getChildren().add(etiquetaJugador);

        Button botonFinalizar = new Button();
        botonFinalizar.setText("Finalizar");
        etiquetaJugador.setFont(Font.font("Agency FB", FontWeight.BOLD, 55));
        botonFinalizar.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        botonFinalizar.setTranslateY(-100);

        botonFinalizar.setOnAction(e -> Platform.exit());

        this.getChildren().addAll(botonFinalizar);

    }
}