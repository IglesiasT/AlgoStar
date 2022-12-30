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

        CanvasConVideo background = new CanvasConVideo("/videos/videoJuego.mp4") ;
        this.getChildren().add(background.obtenerCanvas());

        this.setAlignment(Pos.CENTER);

        Label etiquetaTituloParte1 = new Label();
        etiquetaTituloParte1.setFont(Font.font("Castellar", FontWeight.BOLD, 50));
        etiquetaTituloParte1.setText("NO PUEDE REALIZAR");
        etiquetaTituloParte1.setTextFill(Color.WHITE);
        etiquetaTituloParte1.setTranslateY(-500);

        Label etiquetaTituloParte2 = new Label();
        etiquetaTituloParte2.setFont(Font.font("Castellar", FontWeight.BOLD, 50));
        etiquetaTituloParte2.setText("ESTA ACCION");
        etiquetaTituloParte2.setTextFill(Color.WHITE);
        etiquetaTituloParte2.setTranslateY(-475);

        this.getChildren().addAll(etiquetaTituloParte1 , etiquetaTituloParte2);


        Button botonConfirmar = new Button();
        botonConfirmar.setText("Volver");
        botonConfirmar.setFont(Font.font("Agency FB", FontWeight.BOLD, 20));
        botonConfirmar.setTranslateY(-400);

        this.getChildren().addAll(botonConfirmar);

        BotonConfirmarEventHandler botonConfirmarEventHandler = new BotonConfirmarEventHandler(this.stage,this);
        botonConfirmar.setOnAction(botonConfirmarEventHandler);


    }
    @Override
    public Scene obtenerProximaEscena() {
        return new Scene(new ContenedorElegirAccion(this.stage,this.juego,this.jugador),800,800);
    }
}
