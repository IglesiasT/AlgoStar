package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.controlador.BotonConfirmarEventHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Objects;

public class ContenedorElegirJugador extends VBox implements Contenedor{
    private Stage stage;
    private AlgoStar juego;

    private TextField textFieldNombreJugador;
    private ColorPicker colorPicker;
    private ComboBox<String> comboBoxRazas;

    private boolean segundoJugador = false;

    private ObservableList<String> razas;


    public ContenedorElegirJugador(Stage stage,AlgoStar juego,String error) {
        super();
        this.stage = stage;
        this.juego = juego;

        this.razas = FXCollections.observableArrayList();
        razas.addAll("Protoss", "Zerg");

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
        this.setSpacing(20);

        Label etiquetaError = new Label();
        etiquetaError.setFont(Font.font("Agency FB", FontWeight.BOLD, 50));
        etiquetaError.setText(error);
        etiquetaError.setTextFill(Color.RED);
        etiquetaError.setTranslateY(-400);

        this.getChildren().add(etiquetaError);

        this.iniciarJugador("uno");

        Button botonConfirmar = new Button();
        botonConfirmar.setText("Confirmar");
        botonConfirmar.setFont(Font.font("Agency FB", FontWeight.BOLD, 20));
        botonConfirmar.setTranslateY(-100);
        botonConfirmar.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));


        this.getChildren().addAll(botonConfirmar);

        BotonConfirmarEventHandler botonConfirmarEventHandler = new BotonConfirmarEventHandler(this.stage,this);
        botonConfirmar.setOnAction(botonConfirmarEventHandler);


    }

    public ContenedorElegirJugador(Stage stage,AlgoStar juego,String error, boolean segundoJugador) {
        super();
        this.stage = stage;
        this.juego = juego;
        this.segundoJugador = segundoJugador;

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

        this.razas = FXCollections.observableArrayList();
        razas.addAll("Protoss", "Zerg");

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);

        Label etiquetaError = new Label();
        etiquetaError.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        etiquetaError.setText(error);
        etiquetaError.setTextFill(Color.RED);
        etiquetaError.setTranslateY(-400);
        this.getChildren().add(etiquetaError);

        this.iniciarJugador("Dos");

        Button botonConfirmar = new Button();
        botonConfirmar.setText("Confirmar");
        botonConfirmar.setTranslateY(-100);
        botonConfirmar.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        this.getChildren().addAll(botonConfirmar);

        BotonConfirmarEventHandler botonConfirmarEventHandler = new BotonConfirmarEventHandler(this.stage,this);
        botonConfirmar.setOnAction(botonConfirmarEventHandler);

    }

    private void iniciarJugador(String numeroJugador){
        Label etiquetaJugadores = new Label();
        etiquetaJugadores.setFont(Font.font("Castellar", FontWeight.BOLD, 50));
        etiquetaJugadores.setText("Establecer jugador "+numeroJugador);
        etiquetaJugadores.setTextFill(Color.web("#FFFFFF"));
        etiquetaJugadores.setTranslateY(-350);
        this.getChildren().add(etiquetaJugadores);
        pedirNombre();
        pedirColor();
        pedirRaza();

    }

    private void pedirNombre(){
        Label label = new Label();
        textFieldNombreJugador = new TextField();
        textFieldNombreJugador.setText("Introducir nombre");
        textFieldNombreJugador.setStyle( "-fx-text-fill: white" );
        textFieldNombreJugador.setFont(Font.font("Agency FB", FontWeight.BOLD, 25));
        textFieldNombreJugador.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        textFieldNombreJugador.setTranslateY(-325);

        this.getChildren().addAll(label, textFieldNombreJugador);
    }

    private void pedirColor() {
        colorPicker = new ColorPicker();
        colorPicker.setTranslateY(-250);
        colorPicker.setMinHeight(25);
        colorPicker.setStyle( "-fx-text-fill: white" );
        colorPicker.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        this.getChildren().add(colorPicker);
    }

    private void pedirRaza(){
        comboBoxRazas = new ComboBox<>(razas);
        comboBoxRazas.setValue("Elegir Raza");
        comboBoxRazas.setTranslateY(-175);
        comboBoxRazas.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        this.getChildren().add(comboBoxRazas);
    }

    public void anotarJugadorUno(){
        juego.agregarJugador(textFieldNombreJugador.getText(),colorPicker.getValue(),comboBoxRazas.getValue());
    }

    public void anotarJugadorDos(){
        juego.agregarJugador(textFieldNombreJugador.getText(),colorPicker.getValue(),comboBoxRazas.getValue());
    }

    public Scene obtenerProximaEscena() {
        if (segundoJugador){
            try{anotarJugadorDos();
                juego.comenzarJuego();
                return new Scene(new ContenedorElegirAccion(this.stage,this.juego,juego.obtenerJugador(1)),800,800);
            }catch (Exception e){
                return new Scene(new ContenedorElegirJugador(this.stage,this.juego, "DATOS INVALIDOS",true), 800,800);
            }
        }
        else
            try{anotarJugadorUno();
                return new Scene(new ContenedorElegirJugador(this.stage,this.juego, "",true), 800,800);
            }catch (Exception e){
                return new Scene(new ContenedorElegirJugador(this.stage,this.juego, "DATOS INVALIDOS"), 800,800);
            }
    }

}
