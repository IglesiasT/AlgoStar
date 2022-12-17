package edu.fiuba.algo3.vista.contenedoresAcciones;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.vista.ContenedorError;
import edu.fiuba.algo3.vista.ContenedorFinDeTurno;
import edu.fiuba.algo3.vista.ContenedorMapa;
import edu.fiuba.algo3.vista.eventos.BotonConfirmarEventHandler;
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

        ObservableList<String> construccionesZerg= FXCollections.observableArrayList();
        construccionesZerg.addAll("Criadero: Δ0 ❖200 T",  "Extractor: Δ0 ❖100 T",
                "Reserva de reproduccion: Δ0 ❖150 T", "Espiral: Δ100 ❖150 T","Guarida: Δ100 ❖200 T");
        //construccionesZerg.addAll("Zangano", "Zerling", "Mutalisco", "Hidralisco", "Guardian", "Devorador", "Amo Supremo");

        ObservableList<String> construccionesProtoss = FXCollections.observableArrayList();
        construccionesProtoss.addAll("Nexo Mineral: Δ0 ❖50 T","Pilon: Δ0 ❖100 T", "Asimilador: Δ0 ❖100 T",
                "Acceso: Δ150 ❖200 T", "Puerto Estelar: Δ150 ❖150 T");
        construccionesProtoss.addAll("Zealot: Δ0 ❖100 T", "Dragon: Δ50 ❖125 T", "Scout: Δ150 ❖300 A");

        construccionesPorRaza = new HashMap<>();
        construccionesPorRaza.put(Protoss.class,construccionesProtoss);
        construccionesPorRaza.put(Zerg.class,construccionesZerg);

        this.setSpacing(20);
        this.setPadding(new Insets(25));
        this.setBackground(new Background(new BackgroundFill(Color.valueOf("#D0CFE0"), CornerRadii.EMPTY, Insets.EMPTY)));

        Label etiquetaTitulo = new Label();
        etiquetaTitulo.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        etiquetaTitulo.setText("MENU CONSTRUCCION");
        etiquetaTitulo.setTextFill(Color.BLACK);
        this.getChildren().add(etiquetaTitulo);

        mostrarRecursos();

        this.pedirConstruccion();

        Button botonConfirmar = new Button();
        botonConfirmar.setText("Confirmar");
        this.getChildren().addAll(botonConfirmar);
        BotonConfirmarEventHandler botonConfirmarEventHandler = new BotonConfirmarEventHandler(this.stage,this);
        botonConfirmar.setOnAction(botonConfirmarEventHandler);

        this.pedirUbicacion();



    }

    private void pedirConstruccion(){
        comboBoxConstrucciones = new ComboBox<>(construccionesPorRaza.get(jugador.obtenerRaza().getClass()));
        comboBoxConstrucciones.setValue("Elegir construccion");
        this.getChildren().add(comboBoxConstrucciones);
    }

    private void pedirUbicacion(){
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(new ContenedorMapa(this.stage,this.juego,this));
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
    public Scene obtenerProximaEscena() {
        try {
            jugador.construir(comboBoxConstrucciones.getValue(),casillero);
            return new Scene(new ContenedorFinDeTurno(this.stage,this.juego,this.jugador),800,800);
        }catch (Exception e){
            return new Scene(new ContenedorError(this.stage,this.juego,this.jugador),800,800);
        }
    }

    private void mostrarRecursos(){
        Label etiquetaRecursos = new Label();
        etiquetaRecursos.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        etiquetaRecursos.setText("Recursos disponibles: " + jugador.obtenerRaza().obtenerRecursos());
        etiquetaRecursos.setTextFill(Color.BLACK);
        this.getChildren().add(etiquetaRecursos);
    }
}
