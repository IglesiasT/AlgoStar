package edu.fiuba.algo3.vista.contenedoresAcciones;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.construcciones.unidades.Unidad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.vista.CanvasConVideo;
import edu.fiuba.algo3.vista.ContenedorError;
import edu.fiuba.algo3.vista.ContenedorFinDeTurno;
import edu.fiuba.algo3.vista.ContenedorMapa;
import edu.fiuba.algo3.controlador.BotonConfirmarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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

public class ContenedorMover extends VBox implements ContenedorAccion {

    private Stage stage;
    private AlgoStar juego;
    private Jugador jugador;
    private Casillero casillero;
    private Unidad unidad;


    public ContenedorMover(Stage stage, AlgoStar juego, Jugador jugador){
        this.stage = stage;
        this.juego = juego;
        this.jugador = jugador;

        CanvasConVideo background = new CanvasConVideo("/videos/videoJuego.mp4") ;
        this.getChildren().add(background.obtenerCanvas());

        Label etiquetaTitulo = new Label();
        etiquetaTitulo.setFont(Font.font("Castellar", FontWeight.BOLD, 45));
        etiquetaTitulo.setText("MENU MOVER");
        etiquetaTitulo.setTextFill(Color.WHITE);
        etiquetaTitulo.setTranslateX(20);
        etiquetaTitulo.setTranslateY(-100);

        this.getChildren().add(etiquetaTitulo);

        Label etiquetaSubtitulo = new Label();
        etiquetaSubtitulo.setFont(Font.font("Agency FB", FontWeight.BOLD, 25));
        etiquetaSubtitulo.setText("Elija unidad que quiere mover y el casillero de destino");
        etiquetaSubtitulo.setTextFill(Color.WHITE);
        etiquetaSubtitulo.setTranslateX(20);
        etiquetaSubtitulo.setTranslateY(-70);

        this.getChildren().add(etiquetaSubtitulo);

        Button botonConfirmar = new Button();
        botonConfirmar.setFont(Font.font("Agency FB", FontWeight.BOLD, 20));
        botonConfirmar.setText("Confirmar");
        botonConfirmar.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        botonConfirmar.setTranslateX(20);
        botonConfirmar.setTranslateY(-35);

        this.getChildren().addAll(botonConfirmar);
        BotonConfirmarEventHandler botonConfirmarEventHandler = new BotonConfirmarEventHandler(this.stage,this);
        botonConfirmar.setOnAction(botonConfirmarEventHandler);

        this.pedirUnidadYDestino();

    }

    private void pedirUnidadYDestino(){
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(new ContenedorMapa(this.stage,this.juego,this,true,true));
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setPannable(true);
        scrollPane.setTranslateX(20);
        scrollPane.setTranslateY(-20);
        scrollPane.setMaxWidth(855);
        scrollPane.setMaxHeight(700);
        scrollPane.setMinHeight(750);

        this.getChildren().add(scrollPane);
    }
    public void setCasilleroElegido(Casillero casillero) {
        this.casillero = casillero;
    }

    @Override
    public void setUnidadElegida(Unidad unidad) {this.unidad = unidad;}

    @Override
    public Scene obtenerProximaEscena() {
        try {
            jugador.mover(unidad,casillero);
            AudioClip audio = new AudioClip(this.getClass().getResource("/sonidos/movimiento.wav").toString());
            audio.play();
            return new Scene(new ContenedorFinDeTurno(this.stage,this.juego,this.jugador,casillero),800,800);
        }catch (Exception e){
            return new Scene(new ContenedorError(this.stage,this.juego,this.jugador),800,800);
        }
    }
}
