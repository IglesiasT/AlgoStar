package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.controlador.BotonConfirmarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorFinDeTurno extends VBox implements Contenedor {

    private Stage stage;
    private AlgoStar juego;
    private Jugador jugador;

    public ContenedorFinDeTurno(Stage stage, AlgoStar juego, Jugador jugador){
        super();
        this.stage = stage;
        this.juego = juego;
        this.jugador = jugador;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        this.setBackground(new Background(new BackgroundFill(Color.valueOf("#D0CFE0"), CornerRadii.EMPTY, Insets.EMPTY)));

        Label etiquetaTitulo = new Label();
        etiquetaTitulo.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        etiquetaTitulo.setText("FIN DE TURNO");
        etiquetaTitulo.setTextFill(Color.BLACK);
        this.getChildren().add(etiquetaTitulo);

        Button botonConfirmar = new Button();
        botonConfirmar.setText("Continuar");

        this.getChildren().addAll(botonConfirmar);

        BotonConfirmarEventHandler botonConfirmarEventHandler = new BotonConfirmarEventHandler(this.stage,this);
        botonConfirmar.setOnAction(botonConfirmarEventHandler);


    }

    private Jugador siguienteJugador(){
        if(this.jugador == juego.obtenerJugadorUno()){
            return juego.obtenerJugadorDos();
        }
        return  juego.obtenerJugadorUno();
    }

    @Override
    public Scene obtenerProximaEscena() {
        try {
            juego.siguienteTurno(jugador);
            return new Scene(new ContenedorElegirAccion(this.stage, this.juego, siguienteJugador()), 800, 800);
        }catch (Exception e){
            return new Scene(new ContenedorFinDeJuego(stage,juego),800,800);
        }
    }
}
