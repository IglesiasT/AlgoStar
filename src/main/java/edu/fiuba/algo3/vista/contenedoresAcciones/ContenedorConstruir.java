package edu.fiuba.algo3.vista.contenedoresAcciones;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.construcciones.unidades.Unidad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
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
import java.util.HashMap;
import java.util.Map;

public class ContenedorConstruir extends VBox implements ContenedorAccion {

    private Stage stage;
    private AlgoStar juego;
    private Jugador jugador;


    private Map<Class, ObservableList<String>> construccionesPorRaza;
    private ComboBox<String> comboBoxConstrucciones;

    private Casillero casillero;

    public ContenedorConstruir(Stage stage, AlgoStar juego, Jugador jugador){
        this.stage = stage;
        this.juego = juego;
        this.jugador = jugador;

        CanvasConVideo background = new CanvasConVideo("/videos/videoJuego.mp4") ;
        this.getChildren().add(background.obtenerCanvas());

        ObservableList<String> construccionesZerg= FXCollections.observableArrayList();
        construccionesZerg.addAll("Criadero: Δ0 ❖100 T",  "Extractor: Δ0 ❖100 T",
                "Reserva de reproduccion: Δ0 ❖150 T", "Espiral: Δ100 ❖150 T","Guarida: Δ100 ❖200 T");

        ObservableList<String> construccionesProtoss = FXCollections.observableArrayList();
        construccionesProtoss.addAll("Nexo Mineral: Δ0 ❖50 T","Pilon: Δ0 ❖100 T", "Asimilador: Δ0 ❖100 T",
                "Acceso: Δ0 ❖150 T", "Puerto Estelar: Δ150 ❖150 T");
        construccionesProtoss.addAll("Zealot: Δ0 ❖100 T", "Dragon: Δ50 ❖125 T", "Scout: Δ150 ❖300 A");

        construccionesPorRaza = new HashMap<>();
        construccionesPorRaza.put(Protoss.class,construccionesProtoss);
        construccionesPorRaza.put(Zerg.class,construccionesZerg);

        Label etiquetaTitulo = new Label();
        etiquetaTitulo.setFont(Font.font("Castellar", FontWeight.BOLD, 45));
        etiquetaTitulo.setText("MENU CONSTRUCCION");
        etiquetaTitulo.setTextFill(Color.WHITE);
        etiquetaTitulo.setTranslateX(20);
        etiquetaTitulo.setTranslateY(-50);

        this.getChildren().add(etiquetaTitulo);

        Label etiquetaSubtitulo = new Label();
        etiquetaSubtitulo.setFont(Font.font("Agency FB", FontWeight.BOLD, 25));
        etiquetaSubtitulo.setText("Elija la construccion que quiere comprar y la ubicacion donde la quiere construir");
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

        this.pedirUbicacion();



    }

    private void pedirConstruccion(){
        comboBoxConstrucciones = new ComboBox<>(construccionesPorRaza.get(jugador.obtenerRaza().getClass()));
        comboBoxConstrucciones.setValue("Elegir construccion");
        comboBoxConstrucciones.setTranslateX(25);
        comboBoxConstrucciones.setTranslateY(-10);
        this.getChildren().add(comboBoxConstrucciones);
    }

    private void pedirUbicacion(){
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(new ContenedorMapa(this.stage,this.juego,this,true,false));
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
    public void setCasilleroElegido(Casillero casillero) {
        this.casillero = casillero;
    }

    @Override
    public void setUnidadElegida(Unidad unidad) {}

    @Override
    public Scene obtenerProximaEscena() {
        try {
            jugador.construir(comboBoxConstrucciones.getValue(),casillero);
            AudioClip audio = new AudioClip(this.getClass().getResource("/sonidos/construccion.wav").toString());
            audio.play();
            return new Scene(new ContenedorFinDeTurno(this.stage,this.juego,this.jugador,casillero),800,800);

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
