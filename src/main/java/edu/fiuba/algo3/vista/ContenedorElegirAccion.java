package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import edu.fiuba.algo3.modelo.recursos.Volcan;
import edu.fiuba.algo3.vista.contenedoresAcciones.ContenedorAtacar;
import edu.fiuba.algo3.vista.contenedoresAcciones.ContenedorConstruir;
import edu.fiuba.algo3.vista.contenedoresAcciones.ContenedorMover;
import edu.fiuba.algo3.vista.eventos.BotonConfirmarAccionEventHandler;
import edu.fiuba.algo3.vista.eventos.BotonConfirmarJugadorEventHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class ContenedorElegirAccion extends VBox {

    private Stage stage;
    private AlgoStar juego;

    private ObservableList<String> acciones;
    private ComboBox<String> comboBoxAcciones;
    private Map<String, Scene> escenasAcciones;

    public ContenedorElegirAccion(Stage stage, AlgoStar juego, Jugador jugador){
        super();
        this.stage = stage;
        this.juego = juego;

        this.acciones = FXCollections.observableArrayList();
        acciones.addAll("Mover", "Construir", "Atacar");

        this.escenasAcciones = new HashMap<>();
        escenasAcciones.put("Mover",new Scene(new ContenedorMover(),800,800));
        escenasAcciones.put("Construir",new Scene(new ContenedorConstruir(stage,juego,jugador),800,800));
        escenasAcciones.put("Atacar",new Scene(new ContenedorAtacar(),800,800));

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Label etiquetaTurno = new Label();
        etiquetaTurno.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        etiquetaTurno.setText("Juega " + jugador.obtenerNombre());
        etiquetaTurno.setTextFill(jugador.obtenerColor());
        this.getChildren().add(etiquetaTurno);

        Label etiquetaTitulo = new Label();
        etiquetaTitulo.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        etiquetaTitulo.setText("¿Que desea hacer?");
        etiquetaTitulo.setTextFill(Color.BLACK);
        this.getChildren().add(etiquetaTitulo);

        this.pedirAccion();

        Button botonConfirmar = new Button();
        botonConfirmar.setText("Confirmar");

        this.getChildren().addAll(botonConfirmar);

        BotonConfirmarAccionEventHandler botonConfirmarEventHandler = new BotonConfirmarAccionEventHandler(this.stage,this);
        botonConfirmar.setOnAction(botonConfirmarEventHandler);
    }

    private void pedirAccion(){
        comboBoxAcciones = new ComboBox<>(acciones);
        comboBoxAcciones.setValue("Elegir accion");
        this.getChildren().add(comboBoxAcciones);
    }

    public Scene obtenerProximaEscena(){
        return escenasAcciones.get(comboBoxAcciones.getValue());
    }


}
