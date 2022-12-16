package edu.fiuba.algo3.vista.contenedoresAcciones;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.vista.ContenedorMapa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
        construccionesZerg.addAll("Criadero",  "Extractor", "Reserva de reproduccion", "Espiral","Guarida");
        construccionesZerg.addAll("Zangano", "Zerling", "Mutalisco", "Hidralisco", "Guardian", "Devorador");

        ObservableList<String> construccionesProtoss = FXCollections.observableArrayList();
        construccionesProtoss.addAll("Pilon", "Asimilador", "Nexo Mineral", "Acceso", "Puerto Estelar");
        construccionesProtoss.addAll("Zealot", "Scout", "Dragon", "Amo Supremo");

        construccionesPorRaza = new HashMap<>();
        construccionesPorRaza.put(Protoss.class,construccionesProtoss);
        construccionesPorRaza.put(Zerg.class,construccionesZerg);

        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Label etiquetaTitulo = new Label();
        etiquetaTitulo.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        etiquetaTitulo.setText("MENU CONSTRUCCION");
        etiquetaTitulo.setTextFill(Color.BLACK);
        this.getChildren().add(etiquetaTitulo);

        this.pedirConstruccion();
        this.pedirUbicacion();

    }

    private void pedirConstruccion(){
        comboBoxConstrucciones = new ComboBox<>(construccionesPorRaza.get(jugador.obtenerRaza().getClass()));
        comboBoxConstrucciones.setValue("Elegir construccion");
        this.getChildren().add(comboBoxConstrucciones);
    }

    private void pedirUbicacion(){
        ContenedorMapa mapa = new ContenedorMapa(this.stage,this.juego,this);
        this.getChildren().add(mapa);
    }

    @Override
    public void setCasilleroElegido(Casillero casillero) {
        this.casillero = casillero;
    }
}
