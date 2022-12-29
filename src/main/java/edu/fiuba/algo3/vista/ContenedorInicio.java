package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonNuevaPartidaEventHandler;
import javafx.fxml.Initializable;
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

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ContenedorInicio extends VBox {

    public ContenedorInicio(Stage stage) {
        super();
        this.setAlignment(Pos.CENTER);

        MediaView view = new MediaView();
        Media video = new Media(Objects.requireNonNull(getClass().getResource("/videos/videoInicio.mp4")).toExternalForm());
        MediaPlayer player = new MediaPlayer(video);
        view.setMediaPlayer(player);
        player.setAutoPlay(true);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.play();



        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Castellar", FontWeight.BOLD, 110));
        etiqueta.setText("AlgoStar");
        etiqueta.setTextFill(Color.web("#FFFFFF"));
        etiqueta.minHeight(200);
        etiqueta.prefWidth(800);
        etiqueta.setTranslateY(-450);

        Button botonNuevaPartida = new Button();
        botonNuevaPartida.setBackground(new Background(new BackgroundFill(Color.valueOf("#FFFFFF"), CornerRadii.EMPTY, Insets.EMPTY)));
        botonNuevaPartida.setText("Comenzar");
        botonNuevaPartida.setFont(Font.font("Agency FB", FontWeight.BOLD, 20));
        botonNuevaPartida.setTranslateY(-400);

        Scene proximaEscena = new Scene(new ContenedorManual(stage), 800, 800);
        BotonNuevaPartidaEventHandler botonNuevaPartidaEventHandler = new BotonNuevaPartidaEventHandler(stage, proximaEscena);
        botonNuevaPartida.setOnAction(botonNuevaPartidaEventHandler);

        Pane background = new Pane() ;
        background.getChildren().addAll(view);

        this.getChildren().addAll(background, etiqueta, botonNuevaPartida);

    }

}
