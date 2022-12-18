package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.vista.contenedoresAcciones.*;
import edu.fiuba.algo3.controlador.BotonConfirmarEventHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContenedorElegirAccion extends VBox implements Contenedor{

    private Stage stage;
    private AlgoStar juego;

    private ObservableList<String> acciones;
    private ComboBox<String> comboBoxAcciones;
    private Map<String, Scene> escenasAcciones;

    public ContenedorElegirAccion(Stage stage, AlgoStar juego, Jugador jugador){
        super();
        this.stage = stage;
        this.juego = juego;

        this.accionesPorRaza(jugador);

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        this.setBackground(new Background(new BackgroundFill(Color.valueOf("#D0CFE0"), CornerRadii.EMPTY, Insets.EMPTY)));

        Label etiquetaTurno = new Label();
        etiquetaTurno.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        etiquetaTurno.setText("Juega " + jugador.obtenerNombre());
        etiquetaTurno.setTextFill(jugador.obtenerColor());
        etiquetaTurno.setWrapText(true);
        this.getChildren().add(etiquetaTurno);

        Label etiquetaTitulo = new Label();
        etiquetaTitulo.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        etiquetaTitulo.setText("¿Que desea hacer?");
        etiquetaTitulo.setTextFill(Color.BLACK);
        this.getChildren().add(etiquetaTitulo);

        this.mostrarRecursos(jugador);
        this.mostrarEstados(jugador);

        this.pedirAccion();

        Button botonConfirmar = new Button();
        botonConfirmar.setText("Confirmar");

        this.getChildren().addAll(botonConfirmar);

        BotonConfirmarEventHandler botonConfirmarEventHandler = new BotonConfirmarEventHandler(this.stage,this);
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

    private void accionesPorRaza(Jugador jugador){
        this.acciones = FXCollections.observableArrayList();
        acciones.addAll("Mover", "Construir", "Atacar","Pasar Turno");

        this.escenasAcciones = new HashMap<>();
        escenasAcciones.put("Mover",new Scene(new ContenedorMover(this.stage,this.juego,jugador), 800,800));
        escenasAcciones.put("Construir",new Scene(new ContenedorConstruir(stage,juego,jugador),800,800));
        escenasAcciones.put("Atacar",new Scene(new ContenedorAtacarElegirAtacante(stage,juego,jugador),800,800));
        escenasAcciones.put("Pasar Turno", new Scene(new ContenedorFinDeTurno(this.stage,this.juego,jugador),800,800));

        if(jugador.obtenerRaza().getClass() == Zerg.class) {
            acciones.add("Engendrar");
            escenasAcciones.put("Engendrar",new Scene(new ContenedorEngendrar(this.stage,this.juego,jugador),800,800));
            acciones.add("Evolucionar");
            escenasAcciones.put("Evolucionar",new Scene(new ContenedorEvolucionar(this.stage,this.juego,jugador),800,800));

        }
    }

    private void mostrarRecursos(Jugador jugador){
        Label etiquetaRecursos = new Label();
        etiquetaRecursos.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        etiquetaRecursos.setText("Recursos disponibles: " + jugador.obtenerRaza().obtenerRecursos());
        etiquetaRecursos.setTextFill(jugador.obtenerColor());
        this.getChildren().add(etiquetaRecursos);
    }

    private void mostrarEstados(Jugador jugador){
        List<Construccion> construcciones = jugador.obtenerConstrucciones();
        if (!construcciones.isEmpty())
            for (Construccion construccion: construcciones){
                Label etiquetaConstruccion = new Label();
                etiquetaConstruccion.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                String[] construccionString = (construccion.getClass().toString().split("\\."));
                if (construccion.obtenerRazaMadre() == Zerg.class)
                    etiquetaConstruccion.setText(construccionString[construccionString.length - 1]+
                            " V"+String.valueOf(construccion.obtenerVida()));
                else etiquetaConstruccion.setText(construccionString[construccionString.length - 1]+
                        " V"+ construccion.obtenerVida() + " E"+ ((ConstruccionProtoss)construccion).obtenerEscudo());
                if (construccion.activa())
                    etiquetaConstruccion.setTextFill(jugador.obtenerColor());
                else etiquetaConstruccion.setTextFill(Color.GRAY);
                etiquetaConstruccion.setWrapText(true);
                this.getChildren().add(etiquetaConstruccion);
            }

    }


}
