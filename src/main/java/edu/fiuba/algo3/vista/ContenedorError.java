package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.controlador.BotonConfirmarEventHandler;
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

public class ContenedorError extends VBox implements Contenedor{

    private Stage stage;
    private AlgoStar juego;
    private Jugador jugador;

    public ContenedorError(Stage stage, AlgoStar juego, Jugador jugador){
        super();
        this.stage = stage;
        this.juego = juego;
        this.jugador = jugador;

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
        etiquetaTitulo.setFont(Font.font("Castellar", FontWeight.BOLD, 50));
        etiquetaTitulo.setText("NO PUEDE REALIZAR ESTA ACCION");
        etiquetaTitulo.setTextFill(Color.WHITE);
        etiquetaTitulo.setTranslateY(-500);
        this.getChildren().add(etiquetaTitulo);

        Button botonConfirmar = new Button();
        botonConfirmar.setText("Volver");
        etiquetaTitulo.setFont(Font.font("Agency FB", FontWeight.BOLD, 20));
        etiquetaTitulo.setTranslateY(-400);

        this.getChildren().addAll(botonConfirmar);

        BotonConfirmarEventHandler botonConfirmarEventHandler = new BotonConfirmarEventHandler(this.stage,this);
        botonConfirmar.setOnAction(botonConfirmarEventHandler);


    }
    @Override
    public Scene obtenerProximaEscena() {
        return new Scene(new ContenedorElegirAccion(this.stage,this.juego,this.jugador),800,800);
    }
}
