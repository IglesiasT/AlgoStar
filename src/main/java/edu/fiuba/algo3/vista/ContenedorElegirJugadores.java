package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.vista.eventos.BotonNuevaPartidaEventHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorElegirJugadores extends VBox {
    private Stage stage;
    private AlgoStar juego;
    public ContenedorElegirJugadores(Stage stage) {
        super();
        this.stage = stage;
        this.juego = new AlgoStar();

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Label etiquetaJugadores = new Label();
        etiquetaJugadores.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        etiquetaJugadores.setText("Establecer jugadores");
        etiquetaJugadores.setTextFill(Color.web("#000000"));
        this.getChildren().add(etiquetaJugadores);

        // Se pide los datos de los jugadores tantas veces como jugadores pueda haber en una partida
        for (int i = 1; i < AlgoStar.MAXIMOJUGADORES +1; i++) {
            this.mostrarPedidoDatosJugador(i);
        }

        Button botonNuevaPartida = new Button();
        botonNuevaPartida.setText("Nueva partida");

        Scene proximaEscena = new Scene(new ContenedorPrincipal(this.stage, this.juego), 800, 800);
        BotonNuevaPartidaEventHandler botonNuevaPartidaEventHandler = new BotonNuevaPartidaEventHandler(stage, proximaEscena);
        botonNuevaPartida.setOnAction(botonNuevaPartidaEventHandler);

        this.getChildren().addAll(botonNuevaPartida);
    }

    private void mostrarPedidoDatosJugador(int jugadorNumero){
        Label label = new Label();
        TextField textFieldNombreJugador = new TextField();

        label.setText("Jugador " + String.format("%d", jugadorNumero));
        textFieldNombreJugador.setText("Introducir nombre");

        this.getChildren().addAll(label, textFieldNombreJugador);
        this.mostrarOpcionesRazas();
        this.mostrarOpcionesColor();
        /*
        validar nombres
        validar razas no iguales
        validaciones pueden ser en contenedorPrincipal, teniendo atributos colecciones aca y pasandoselas
        para que el unico que toque datos del juego sea ese contenedor
        this.juego.agregarJugador(textFieldNombreJugador.getText(), raza);
        */
    }

    private void mostrarOpcionesColor() {
        ColorPicker colorPicker = new ColorPicker();
        //setear color al jugador
        this.getChildren().add(colorPicker);
    }

    private void mostrarOpcionesRazas(){
        ObservableList<String> razas = FXCollections.observableArrayList();
        razas.addAll("Protoss", "Zerg");    // pedir al juego las razas

        ComboBox<String> comboBoxRazas = new ComboBox(razas);
        comboBoxRazas.setValue("Elegir Raza");

        this.getChildren().add(comboBoxRazas);
    }
}
