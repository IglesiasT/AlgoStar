package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.MutaliscoBase;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ContenedorElegirAccion extends VBox implements Contenedor{

    private Stage stage;
    private AlgoStar juego;
    private Jugador jugador;

    private ObservableList<String> acciones;
    private ComboBox<String> comboBoxAcciones;
    private Map<String, Scene> escenasAcciones;

    public ContenedorElegirAccion(Stage stage, AlgoStar juego, Jugador jugador){
        super();
        this.stage = stage;
        this.juego = juego;
        this.jugador = jugador;

        CanvasConVideo background = new CanvasConVideo("/videos/videoJuego.mp4") ;
        this.getChildren().add(background.obtenerCanvas());

        this.accionesPorRaza();

        this.setAlignment(Pos.CENTER);

        Label etiquetaTurno = new Label();
        etiquetaTurno.setFont(Font.font("Agency FB", FontWeight.LIGHT, 30));
        etiquetaTurno.setText("Es el turno de " + jugador.obtenerNombre());
        etiquetaTurno.setTextFill(jugador.obtenerColor());
        etiquetaTurno.setWrapText(true);
        etiquetaTurno.setTranslateY(-450);
        this.getChildren().add(etiquetaTurno);

        Label etiquetaTitulo = new Label();
        etiquetaTitulo.setFont(Font.font("Castellar", FontWeight.BOLD, 50));
        etiquetaTitulo.setText("¿Que desea hacer?");
        etiquetaTitulo.setTextFill(Color.WHITE);
        etiquetaTitulo.setTranslateY(-400);
        this.getChildren().add(etiquetaTitulo);

        this.mostrarRecursos();
        this.mostrarEstados();

        this.pedirAccion();

        Button botonConfirmar = new Button();
        botonConfirmar.setText("Confirmar");
        botonConfirmar.setFont(Font.font("Agency FB", FontWeight.LIGHT, 20));
        botonConfirmar.setTranslateY(-100);
        botonConfirmar.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        this.getChildren().addAll(botonConfirmar);

        BotonConfirmarEventHandler botonConfirmarEventHandler = new BotonConfirmarEventHandler(this.stage,this);
        botonConfirmar.setOnAction(botonConfirmarEventHandler);
    }

    private void pedirAccion(){
        comboBoxAcciones = new ComboBox<>(acciones);
        comboBoxAcciones.setValue("Elegir accion");
        comboBoxAcciones.setTranslateY(-350);
        comboBoxAcciones.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        this.getChildren().add(comboBoxAcciones);
    }

    public Scene obtenerProximaEscena(){
        return escenasAcciones.get(comboBoxAcciones.getValue());
    }

    private void accionesPorRaza(){
        this.acciones = FXCollections.observableArrayList();
        acciones.addAll("Mover", "Construir", "Atacar","Pasar Turno");

        this.escenasAcciones = new HashMap<>();
        escenasAcciones.put("Mover",new Scene(new ContenedorMover(this.stage,this.juego,jugador), 900,1000));
        escenasAcciones.put("Construir",new Scene(new ContenedorConstruir(stage,juego,jugador),900,1000));
        escenasAcciones.put("Atacar",new Scene(new ContenedorAtacarElegirAtacante(stage,juego,jugador),900,1000));
        escenasAcciones.put("Pasar Turno", new Scene(new ContenedorFinDeTurno(this.stage,this.juego,jugador),800,800));
        escenasAcciones.put("Elegir accion",new Scene(new ContenedorError(this.stage,this.juego,this.jugador),800,800));

        if(jugador.obtenerRaza().getClass() == Zerg.class) {
            acciones.add("Engendrar");
            escenasAcciones.put("Engendrar",new Scene(new ContenedorEngendrar(this.stage,this.juego,jugador),900,1000));
            acciones.add("Evolucionar");
            escenasAcciones.put("Evolucionar",new Scene(new ContenedorEvolucionar(this.stage,this.juego,jugador),900,1000));

        }
    }

    private void mostrarRecursos(){
        Label etiquetaRecursos = new Label();
        etiquetaRecursos.setFont(Font.font("Agency FB", FontWeight.MEDIUM, 20));;
        etiquetaRecursos.setText("Recursos disponibles: " + jugador.obtenerRaza().obtenerRecursos());
        etiquetaRecursos.setTextFill(jugador.obtenerColor());
        etiquetaRecursos.setTranslateY(-250);

        this.getChildren().add(etiquetaRecursos);
    }

    private void mostrarEstados(){
        List<Construccion> construcciones = jugador.obtenerConstrucciones();
        VBox panelConstrucciones = new VBox();
        panelConstrucciones.setAlignment(Pos.CENTER);

        if (!construcciones.isEmpty())
            for (Construccion construccion: construcciones){

                Label etiquetaConstruccion = new Label();
                etiquetaConstruccion.setFont(Font.font("Agency FB", FontWeight.BOLD, 20));
                String[] construccionString = (construccion.getClass().toString().split("\\."));

                if (construccion.obtenerRazaMadre() == Zerg.class)
                    if (construccion.getClass() == MutaliscoBase.class)
                        etiquetaConstruccion.setText(((MutaliscoBase) construccion).obtenerEstado()+
                            " V"+ construccion.obtenerVida());
                    else etiquetaConstruccion.setText(construccionString[construccionString.length - 1]+
                            " V"+ construccion.obtenerVida());
                else etiquetaConstruccion.setText(construccionString[construccionString.length - 1]+
                        " V"+ construccion.obtenerVida() + " E"+ ((ConstruccionProtoss)construccion).obtenerEscudo());

                if (construccion.activa())
                    etiquetaConstruccion.setTextFill(jugador.obtenerColor());
                else etiquetaConstruccion.setTextFill(Color.GRAY);

                etiquetaConstruccion.setWrapText(true);
                etiquetaConstruccion.setLayoutX(400-etiquetaConstruccion.getWidth());
                panelConstrucciones.getChildren().add(etiquetaConstruccion);
            }

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(panelConstrucciones);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefViewportHeight(200);
        scrollPane.setTranslateY(-200);
        scrollPane.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));

        this.getChildren().add(scrollPane);
    }


}
