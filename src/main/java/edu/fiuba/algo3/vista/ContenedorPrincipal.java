package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.areas.Area;
import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ContenedorPrincipal extends Pane {


    private final Stage stage;
    private Canvas canvas;

    private ArrayList<Area> areasMapa;
    public ContenedorPrincipal(Stage stage, AlgoStar juego){
        super();
        this.stage = stage;
        this.canvas = new Canvas();


        Label label = new Label();
        label.setText("contenedor principal");

        this.mostrarMenuRecursos();
        this.mostrarMapa(juego.obtenerMapa());

        this.getChildren().addAll(label);
    }

    private void mostrarMapa(Mapa mapa) {
        /*
        GridPane mapaVista = new GridPane();
        mapaVista.setGridLinesVisible(true);


        for (int i = 0; i < Mapa.FILAS; i++) {
            for (int j = 0; j < Mapa.COLUMNAS; j++) {
                mapaVista.add(new Rectangle(10, 10, Color.BLUE), i, j);
            }
        }


        this.getChildren().add(mapaVista);

         */
        mapa.mostrarMapa(this);
    }

    private void mostrarMenuRecursos(){

    }
}
