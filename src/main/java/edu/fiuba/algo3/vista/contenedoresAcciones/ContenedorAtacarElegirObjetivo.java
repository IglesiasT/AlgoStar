package edu.fiuba.algo3.vista.contenedoresAcciones;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.construcciones.unidades.Unidad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.vista.ContenedorError;
import edu.fiuba.algo3.vista.ContenedorFinDeTurno;
import edu.fiuba.algo3.vista.ContenedorMapa;
import edu.fiuba.algo3.controlador.BotonConfirmarEventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.Objects;

public class ContenedorAtacarElegirObjetivo extends VBox implements ContenedorAccion {

    private Stage stage;
    private AlgoStar juego;
    private Jugador jugador;
    private Unidad atacante;
    private Construccion objetivo;


    public ContenedorAtacarElegirObjetivo(Stage stage, AlgoStar juego, Jugador jugador,String objetivo,Unidad atacante) {
        this.stage = stage;
        this.juego = juego;
        this.jugador = jugador;
        this.atacante = atacante;

        this.setSpacing(20);
        this.setPadding(new Insets(25));
        this.setBackground(new Background(new BackgroundFill(Color.valueOf("#D0CFE0"), CornerRadii.EMPTY, Insets.EMPTY)));

        Label etiquetaTitulo = new Label();
        etiquetaTitulo.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        etiquetaTitulo.setText("MENU ATACAR");
        etiquetaTitulo.setTextFill(Color.BLACK);
        this.getChildren().add(etiquetaTitulo);

        Label etiquetaSubtitulo = new Label();
        etiquetaSubtitulo.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        etiquetaSubtitulo.setText("Elija "+objetivo+" que quiere atacar");
        etiquetaSubtitulo.setTextFill(Color.BLACK);
        this.getChildren().add(etiquetaSubtitulo);

        Button botonConfirmar = new Button();
        botonConfirmar.setText("Confirmar");
        this.getChildren().addAll(botonConfirmar);
        BotonConfirmarEventHandler botonConfirmarEventHandler = new BotonConfirmarEventHandler(this.stage, this);
        botonConfirmar.setOnAction(botonConfirmarEventHandler);
        if(Objects.equals(objetivo, "Unidad"))
            this.pedirUnidad();
        else
            this.pedirConstruccion();

    }
    private void pedirUnidad() {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(new ContenedorMapa(this.stage, this.juego, this, false, true));
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setPannable(true);
        this.getChildren().add(scrollPane);
    }
    private void pedirConstruccion(){
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(new ContenedorMapa(this.stage,this.juego,this,true,false));
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setPannable(true);
        this.getChildren().add(scrollPane);
    }

    public void setCasilleroElegido(Casillero casillero) {
        this.objetivo = casillero.obtenerConstruccion();
    }

    @Override
    public void setUnidadElegida(Unidad unidad) {
        this.objetivo = (Construccion) unidad;
    }

    @Override
    public Scene obtenerProximaEscena() {
        try {
            jugador.atacar(atacante, objetivo);
            AudioClip audio = new AudioClip(this.getClass().getResource("/ataque.wav").toString());
            audio.play();
            return new Scene(new ContenedorFinDeTurno(this.stage, this.juego, this.jugador,objetivo.obtenerUbicacion()), 800, 800);
        } catch (Exception e) {
            return new Scene(new ContenedorError(this.stage, this.juego, this.jugador), 800, 800);
        }
    }

}
