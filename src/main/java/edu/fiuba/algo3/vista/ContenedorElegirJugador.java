package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.controlador.BotonConfirmarEventHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

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

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        this.setBackground(new Background(new BackgroundFill(Color.valueOf("#D0CFE0"), CornerRadii.EMPTY, Insets.EMPTY)));

        Label etiquetaError = new Label();
        etiquetaError.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        etiquetaError.setText(error);
        etiquetaError.setTextFill(Color.RED);
        this.getChildren().add(etiquetaError);

        this.iniciarJugador("uno");

        Button botonConfirmar = new Button();
        botonConfirmar.setText("Confirmar");

        this.getChildren().addAll(botonConfirmar);

        BotonConfirmarEventHandler botonConfirmarEventHandler = new BotonConfirmarEventHandler(this.stage,this);
        botonConfirmar.setOnAction(botonConfirmarEventHandler);


    }

    public ContenedorElegirJugador(Stage stage,AlgoStar juego,String error, boolean segundoJugador) {
        super();
        this.stage = stage;
        this.juego = juego;
        this.segundoJugador = segundoJugador;

        this.razas = FXCollections.observableArrayList();
        razas.addAll("Protoss", "Zerg");

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        this.setBackground(new Background(new BackgroundFill(Color.valueOf("#D0CFE0"), CornerRadii.EMPTY, Insets.EMPTY)));

        Label etiquetaError = new Label();
        etiquetaError.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        etiquetaError.setText(error);
        etiquetaError.setTextFill(Color.RED);
        this.getChildren().add(etiquetaError);

        this.iniciarJugador("Dos");

        Button botonConfirmar = new Button();
        botonConfirmar.setText("Confirmar");

        this.getChildren().addAll(botonConfirmar);

        BotonConfirmarEventHandler botonConfirmarEventHandler = new BotonConfirmarEventHandler(this.stage,this);
        botonConfirmar.setOnAction(botonConfirmarEventHandler);

    }

    private void iniciarJugador(String numeroJugador){
        Label etiquetaJugadores = new Label();
        etiquetaJugadores.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        etiquetaJugadores.setText("Establecer jugador "+numeroJugador);
        etiquetaJugadores.setTextFill(Color.web("#000000"));
        this.getChildren().add(etiquetaJugadores);
        pedirNombre();
        pedirColor();
        pedirRaza();

    }


    private void pedirNombre(){
        Label label = new Label();
        textFieldNombreJugador = new TextField();
        textFieldNombreJugador.setText("Introducir nombre");

        this.getChildren().addAll(label, textFieldNombreJugador);
    }

    private void pedirColor() {
        colorPicker = new ColorPicker();
        this.getChildren().add(colorPicker);
    }

    private void pedirRaza(){
        comboBoxRazas = new ComboBox<>(razas);
        comboBoxRazas.setValue("Elegir Raza");

        this.getChildren().add(comboBoxRazas);
    }

    public void anotarJugadorUno(){
        juego.agregarJugadorUno(textFieldNombreJugador.getText(),colorPicker.getValue(),comboBoxRazas.getValue());
    }

    public void anotarJugadorDos(){
        juego.agregarJugadorDos(textFieldNombreJugador.getText(),colorPicker.getValue(),comboBoxRazas.getValue());
    }

    public Scene obtenerProximaEscena() {
        if (segundoJugador){
            try{anotarJugadorDos();
                juego.comenzarJuego();
                return new Scene(new ContenedorElegirAccion(this.stage,this.juego,juego.obtenerJugadorUno()),800,800);
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
