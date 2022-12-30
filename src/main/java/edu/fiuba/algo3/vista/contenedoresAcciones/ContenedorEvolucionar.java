package edu.fiuba.algo3.vista.contenedoresAcciones;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.construcciones.unidades.Unidad;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.MutaliscoBase;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.vista.CanvasConVideo;
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

public class ContenedorEvolucionar extends VBox implements ContenedorAccion{

    private Stage stage;
    private AlgoStar juego;
    private Jugador jugador;
    private ComboBox<String> comboBoxUnidades;
    private ObservableList<String> unidades;
    private Unidad unidad;
    public ContenedorEvolucionar(Stage stage, AlgoStar juego, Jugador jugador){
        this.stage = stage;
        this.juego = juego;
        this.jugador = jugador;

        unidades = FXCollections.observableArrayList();
        unidades.addAll("Mutalisco a Guardian: Δ100 ❖50", "Mutalisco a Devorador: Δ50 ❖150");

        CanvasConVideo background = new CanvasConVideo("/videos/videoJuego.mp4") ;
        this.getChildren().add(background.obtenerCanvas());


        Label etiquetaTitulo = new Label();
        etiquetaTitulo.setFont(Font.font("Castellar", FontWeight.BOLD, 45));
        etiquetaTitulo.setText("MENU EVOLUCION");
        etiquetaTitulo.setTextFill(Color.WHITE);
        etiquetaTitulo.setTranslateX(20);
        etiquetaTitulo.setTranslateY(-50);

        this.getChildren().add(etiquetaTitulo);

        Label etiquetaSubtitulo = new Label();
        etiquetaSubtitulo.setFont(Font.font("Agency FB", FontWeight.BOLD, 25));
        etiquetaSubtitulo.setText("Elija la evolucion que quiere comprar y el mutalisco que quiere evolucionar");
        etiquetaSubtitulo.setTextFill(Color.WHITE);
        etiquetaSubtitulo.setTranslateX(20);
        etiquetaSubtitulo.setTranslateY(-35);

        this.getChildren().add(etiquetaSubtitulo);

        mostrarRecursos();

        this.pedirConstruccion();

        Button botonConfirmar = new Button();
        botonConfirmar.setFont(Font.font("Agency FB", FontWeight.BOLD, 20));
        botonConfirmar.setText("Confirmar");
        botonConfirmar.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        botonConfirmar.setTranslateX(700);
        botonConfirmar.setTranslateY(-50);

        this.getChildren().addAll(botonConfirmar);

        BotonConfirmarEventHandler botonConfirmarEventHandler = new BotonConfirmarEventHandler(this.stage,this);
        botonConfirmar.setOnAction(botonConfirmarEventHandler);

        this.pedirMutalisco();

    }

    private void pedirConstruccion(){
        comboBoxUnidades = new ComboBox<>(unidades);
        comboBoxUnidades.setValue("Elegir evolucion");
        comboBoxUnidades.setTranslateX(25);
        comboBoxUnidades.setTranslateY(-10);
        this.getChildren().add(comboBoxUnidades);
    }

    private void pedirMutalisco(){
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(new ContenedorMapa(this.stage,this.juego,this,false,true));
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setPannable(true);
        scrollPane.setTranslateX(20);
        scrollPane.setTranslateY(-20);
        scrollPane.setMaxWidth(860);
        scrollPane.setMaxHeight(700);
        scrollPane.setMinHeight(750);

        this.getChildren().add(scrollPane);
    }

    @Override
    public void setCasilleroElegido(Casillero casillero) {}

    @Override
    public void setUnidadElegida(Unidad unidad) {
        this.unidad = unidad;
    }

    @Override
    public Scene obtenerProximaEscena() {

        try {
            jugador.evolucionar(comboBoxUnidades.getValue(),(MutaliscoBase)unidad);
            AudioClip audio = new AudioClip(this.getClass().getResource("/sonidos/evolucion.wav").toString());
            audio.play();
            return new Scene(new ContenedorFinDeTurno(this.stage,this.juego,this.jugador,((MutaliscoBase) unidad).obtenerUbicacion()),800,800);
        }catch (Exception e){
            return new Scene(new ContenedorError(this.stage,this.juego,this.jugador),800,800);
        }
    }

    private void mostrarRecursos(){
        Label etiquetaRecursos = new Label();
        etiquetaRecursos.setFont(Font.font("Agency FB", FontWeight.BOLD, 25));
        etiquetaRecursos.setText("Recursos disponibles: " + jugador.obtenerRaza().obtenerRecursos());
        etiquetaRecursos.setTextFill(jugador.obtenerColor());
        etiquetaRecursos.setTextFill(Color.WHITE);
        etiquetaRecursos.setTranslateX(25);
        etiquetaRecursos.setTranslateY(-25);

        this.getChildren().add(etiquetaRecursos);
    }
}
