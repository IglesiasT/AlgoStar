package edu.fiuba.algo3.vista.contenedoresAcciones;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.construcciones.unidades.Unidad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.vista.ContenedorMapa;
import edu.fiuba.algo3.controlador.eventos.BotonConfirmarEventHandler;
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

public class ContenedorAtacarElegirAtacante extends VBox implements ContenedorAccion {

    private Stage stage;
    private AlgoStar juego;
    private Jugador jugador;
    private Casillero casillero;
    private ComboBox<String> comboBoxTipos;
    private Unidad unidad;


    public ContenedorAtacarElegirAtacante(Stage stage, AlgoStar juego, Jugador jugador){
        this.stage = stage;
        this.juego = juego;
        this.jugador = jugador;

        this.setSpacing(20);
        this.setPadding(new Insets(25));
        this.setBackground(new Background(new BackgroundFill(Color.valueOf("#D0CFE0"), CornerRadii.EMPTY, Insets.EMPTY)));

        Label etiquetaTitulo = new Label();
        etiquetaTitulo.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        etiquetaTitulo.setText("MENU ATACAR");
        etiquetaTitulo.setTextFill(Color.BLACK);
        this.getChildren().add(etiquetaTitulo);

        Label etiquetaSubtitulo = new Label();
        etiquetaSubtitulo.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        etiquetaSubtitulo.setText("Elija la unidad que quiere usar para atacar y si quiere acar una construccion o unidad enemiga");
        etiquetaSubtitulo.setTextFill(Color.BLACK);
        this.getChildren().add(etiquetaSubtitulo);

        this.pedirTipoDeObjetivo();

        Button botonConfirmar = new Button();
        botonConfirmar.setText("Confirmar");
        this.getChildren().addAll(botonConfirmar);
        BotonConfirmarEventHandler botonConfirmarEventHandler = new BotonConfirmarEventHandler(this.stage,this);
        botonConfirmar.setOnAction(botonConfirmarEventHandler);

        this.pedirUnidad();



    }

    private void pedirTipoDeObjetivo(){
        ObservableList<String> tipos = FXCollections.observableArrayList();
        tipos.addAll("Edificio","Unidad");
        comboBoxTipos = new ComboBox<>(tipos);
        comboBoxTipos.setValue("Elegir tipo de objetivo");
        this.getChildren().add(comboBoxTipos);
    }

    private void pedirUnidad(){
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(new ContenedorMapa(this.stage,this.juego,this,false,true));
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setPannable(true);
        this.getChildren().add(scrollPane);
    }
    public void setCasilleroElegido(Casillero casillero) {}

    @Override
    public void setUnidadElegida(Unidad unidad) {this.unidad = unidad;}

    @Override
    public Scene obtenerProximaEscena() {
        return new Scene(new ContenedorAtacarElegirObjetivo(stage,juego,jugador,comboBoxTipos.getValue(),unidad),800,800);
    }
}
