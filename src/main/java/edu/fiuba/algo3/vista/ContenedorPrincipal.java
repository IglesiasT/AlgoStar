package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.AlgoStar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {
    private AlgoStar juego;
    public ContenedorPrincipal(Stage stage, AlgoStar juego){
        this.juego = juego;
        // manipular modelo
    }
}
