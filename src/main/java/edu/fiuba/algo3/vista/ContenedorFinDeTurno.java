package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonConfirmarEventHandler;
import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Objects;


public class ContenedorFinDeTurno extends VBox implements Contenedor {

    private Stage stage;
    private AlgoStar juego;
    private Jugador jugador;

    public ContenedorFinDeTurno(Stage stage, AlgoStar juego, Jugador jugador,Casillero casillero){
        super();
        this.stage = stage;
        this.juego = juego;
        this.jugador = jugador;

        CanvasConVideo background = new CanvasConVideo("/videos/videoJuego.mp4") ;
        this.getChildren().add(background.obtenerCanvas());

        this.setAlignment(Pos.CENTER);

        Label etiquetaTitulo = new Label();
        etiquetaTitulo.setFont(Font.font("Castellar", FontWeight.BOLD, 50));
        etiquetaTitulo.setText("Fin De Turno");
        etiquetaTitulo.setTextFill(Color.WHITE);
        etiquetaTitulo.setTranslateY(-575);
        this.getChildren().add(etiquetaTitulo);

        Pane mapa = new ContenedorMapa(stage,juego,casillero);
        mapa.setTranslateY(-550);
        mapa.setTranslateX(125);
        this.getChildren().add(mapa);

        Button botonConfirmar = new Button();
        botonConfirmar.setFont(Font.font("Agency FB", FontWeight.BOLD, 40));
        botonConfirmar.setText("Continuar");
        botonConfirmar.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        botonConfirmar.setTranslateY(-50);

        this.getChildren().addAll(botonConfirmar);

        BotonConfirmarEventHandler botonConfirmarEventHandler = new BotonConfirmarEventHandler(this.stage,this);
        botonConfirmar.setOnAction(botonConfirmarEventHandler);


    }

    public ContenedorFinDeTurno(Stage stage, AlgoStar juego, Jugador jugador){
        super();
        this.stage = stage;
        this.juego = juego;
        this.jugador = jugador;

        MediaView view = new MediaView();
        Media video = new Media(Objects.requireNonNull(getClass().getResource("/videos/videoJuego.mp4")).toExternalForm());
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
        etiquetaTitulo.setFont(Font.font("Castellar", FontWeight.BOLD, 60));
        etiquetaTitulo.setText("Fin De Turno");
        etiquetaTitulo.setTextFill(Color.WHITE);
        etiquetaTitulo.setTranslateY(-500);
        this.getChildren().add(etiquetaTitulo);

        Button botonConfirmar = new Button();
        botonConfirmar.setFont(Font.font("Agency FB", FontWeight.BOLD, 40));
        botonConfirmar.setText("Continuar");
        botonConfirmar.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        botonConfirmar.setTranslateY(-50);

        this.getChildren().addAll(botonConfirmar);

        BotonConfirmarEventHandler botonConfirmarEventHandler = new BotonConfirmarEventHandler(this.stage,this);
        botonConfirmar.setOnAction(botonConfirmarEventHandler);


    }

    private Jugador siguienteJugador(){
        if(this.jugador == juego.obtenerJugador(1)){
            return juego.obtenerJugador(2);
        }
        return  juego.obtenerJugador(1);
    }

    @Override
    public Scene obtenerProximaEscena() {
        try {
            juego.siguienteTurno(jugador);
            return new Scene(new ContenedorElegirAccion(this.stage, this.juego, siguienteJugador()), 800, 800);
        }catch (Exception e){
            AudioClip audio = new AudioClip(this.getClass().getResource("/sonidos/victoria.wav").toString());
            audio.play();
            return new Scene(new ContenedorFinDeJuego(stage,juego),800,800);
        }
    }
}
