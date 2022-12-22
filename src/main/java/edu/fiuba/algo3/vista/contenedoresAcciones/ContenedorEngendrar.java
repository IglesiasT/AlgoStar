package edu.fiuba.algo3.vista.contenedoresAcciones;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.construcciones.unidades.Unidad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.vista.ContenedorError;
import edu.fiuba.algo3.vista.ContenedorFinDeTurno;
import edu.fiuba.algo3.vista.ContenedorMapa;
import edu.fiuba.algo3.controlador.BotonConfirmarEventHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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

public class ContenedorEngendrar extends VBox implements ContenedorAccion{
    private Stage stage;
    private AlgoStar juego;
    private Jugador jugador;
    private ComboBox<String> comboBoxUnidades;
    private ObservableList<String> unidades;
    private Casillero casillero;

    public ContenedorEngendrar(Stage stage, AlgoStar juego, Jugador jugador){
        this.stage = stage;
        this.juego = juego;
        this.jugador = jugador;

        unidades = FXCollections.observableArrayList();
        unidades.addAll("Zangano: Δ0 ❖25", "Zerling: Δ0 ❖25", "Mutalisco: Δ100 ❖100",
                "Hidralisco: Δ25 ❖75", "Amo Supremo: Δ0 ❖50");


        this.setSpacing(20);
        this.setPadding(new Insets(25));
        this.setBackground(new Background(new BackgroundFill(Color.valueOf("#D0CFE0"), CornerRadii.EMPTY, Insets.EMPTY)));

        Label etiquetaTitulo = new Label();
        etiquetaTitulo.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        etiquetaTitulo.setText("MENU ENGENDRADO");
        etiquetaTitulo.setTextFill(Color.BLACK);
        this.getChildren().add(etiquetaTitulo);

        Label etiquetaSubtitulo = new Label();
        etiquetaSubtitulo.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        etiquetaSubtitulo.setText("Elija la unidad que quiere comprar y el criadero en que la quiere engendrar");
        etiquetaSubtitulo.setTextFill(Color.BLACK);
        this.getChildren().add(etiquetaSubtitulo);

        mostrarRecursos();

        this.pedirConstruccion();

        Button botonConfirmar = new Button();
        botonConfirmar.setText("Confirmar");
        this.getChildren().addAll(botonConfirmar);
        BotonConfirmarEventHandler botonConfirmarEventHandler = new BotonConfirmarEventHandler(this.stage,this);
        botonConfirmar.setOnAction(botonConfirmarEventHandler);

        this.pedirCriadero();



    }

    private void pedirConstruccion(){
        comboBoxUnidades = new ComboBox<>(unidades);
        comboBoxUnidades.setValue("Elegir unidad");
        this.getChildren().add(comboBoxUnidades);
    }

    private void pedirCriadero(){
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(new ContenedorMapa(this.stage,this.juego,this,true,false));
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setPannable(true);
        this.getChildren().add(scrollPane);
    }

    @Override
    public void setCasilleroElegido(Casillero casillero) {
        this.casillero = casillero;
    }

    @Override
    public void setUnidadElegida(Unidad unidad) {}

    @Override
    public Scene obtenerProximaEscena() {
        try {
            jugador.engendrar(comboBoxUnidades.getValue(),casillero);
            AudioClip audio = new AudioClip(this.getClass().getResource("/engendrado.wav").toString());
            audio.play();
            return new Scene(new ContenedorFinDeTurno(this.stage,this.juego,this.jugador,casillero),800,800);
        }catch (Exception e){
            return new Scene(new ContenedorError(this.stage,this.juego,this.jugador),800,800);
        }
}

    private void mostrarRecursos(){
        Label etiquetaRecursos = new Label();
        etiquetaRecursos.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        etiquetaRecursos.setText("Recursos disponibles: " + jugador.obtenerRaza().obtenerRecursos());
        etiquetaRecursos.setTextFill(jugador.obtenerColor());
        this.getChildren().add(etiquetaRecursos);
    }
}
