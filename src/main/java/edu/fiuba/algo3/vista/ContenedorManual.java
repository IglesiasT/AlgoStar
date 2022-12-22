package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.controlador.BotonNuevaPartidaEventHandler;
import edu.fiuba.algo3.controlador.SeleccionUnidadesEventHandler;
import edu.fiuba.algo3.modelo.AlgoStar;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.List;

public class ContenedorManual extends VBox {
    public ContenedorManual(Stage stage) {
        super();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        this.setBackground(new Background(new BackgroundFill(Color.valueOf("#D0CFE0"), CornerRadii.EMPTY, Insets.EMPTY)));

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        etiqueta.setText("MANUAL");
        etiqueta.setTextFill(Color.BLACK);
        this.getChildren().add(etiqueta);

        areas();
        recursos();
        construcciones();
        unidades();

        Button botonNuevaPartida = new Button();
        botonNuevaPartida.setText("Nueva partida");

        Scene proximaEscena = new Scene(new ContenedorElegirJugador(stage, new AlgoStar(), ""), 800, 800);
        BotonNuevaPartidaEventHandler botonNuevaPartidaEventHandler = new BotonNuevaPartidaEventHandler(stage, proximaEscena);
        botonNuevaPartida.setOnAction(botonNuevaPartidaEventHandler);

        this.getChildren().add(botonNuevaPartida);
    }

    public void areas(){
        Pane panelManual = new Pane();
        panelManual.setBackground(new Background(new BackgroundFill(Color.valueOf("#D0CFE0"), CornerRadii.EMPTY, Insets.EMPTY)));

        Rectangle casilleroT = new Rectangle();
        casilleroT.setWidth(App.TAMANIO_CASILLERO);
        casilleroT.setHeight(App.TAMANIO_CASILLERO);
        casilleroT.setFill(Color.valueOf("#98C3A5"));
        Text explicacionT = new Text("Casillero en area terrestre");
        explicacionT.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        explicacionT.setFill(Paint.valueOf("#3B3856"));
        explicacionT.relocate(App.TAMANIO_CASILLERO + 15, 18);

        Rectangle casilleroE = new Rectangle();
        casilleroE.setWidth(App.TAMANIO_CASILLERO);
        casilleroE.setHeight(App.TAMANIO_CASILLERO);
        casilleroE.setFill(Color.valueOf("#9CA9D3"));
        casilleroE.setY(App.TAMANIO_CASILLERO + 15);
        Text explicacionE = new Text("Casillero en area espacial");
        explicacionE.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        explicacionE.setFill(Paint.valueOf("#3B3856"));
        explicacionE.relocate(App.TAMANIO_CASILLERO + 15, App.TAMANIO_CASILLERO + 15 + 18);

        Text explicacionCasillero = new Text("Para seleccionar un casillero haga click sobre el");
        explicacionCasillero.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        explicacionCasillero.setFill(Paint.valueOf("#3B3856"));
        explicacionCasillero.setY(App.TAMANIO_CASILLERO*2 + 15*2 + 18);

        panelManual.getChildren().addAll(casilleroT,explicacionT,casilleroE,explicacionE,explicacionCasillero);
        this.getChildren().add(panelManual);
    }

    public void recursos(){
        Pane panelManual = new Pane();
        panelManual.setBackground(new Background(new BackgroundFill(Color.valueOf("#D0CFE0"), CornerRadii.EMPTY, Insets.EMPTY)));

        Rectangle casilleroV = new Rectangle();
        casilleroV.setWidth(App.TAMANIO_CASILLERO);
        casilleroV.setHeight(App.TAMANIO_CASILLERO);
        casilleroV.setFill(Paint.valueOf("#B7B5CF"));

        Text volcan = new Text("Δ");
        volcan.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        volcan.setFill(Color.valueOf("#F9627D"));
        volcan.relocate(20,18);

        Text explicacionV = new Text("En el casillero hay un volcan");
        explicacionV.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        explicacionV.setFill(Paint.valueOf("#3B3856"));
        explicacionV.relocate(App.TAMANIO_CASILLERO + 15, 18);

        Rectangle casilleroN = new Rectangle();
        casilleroN.setWidth(App.TAMANIO_CASILLERO);
        casilleroN.setHeight(App.TAMANIO_CASILLERO);
        casilleroN.setFill(Color.valueOf("#B7B5CF"));
        casilleroN.setY(App.TAMANIO_CASILLERO + 15);

        Text nodo = new Text("❖");
        nodo.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        nodo.setFill(Color.valueOf("#A15BC7"));
        nodo.relocate(20,App.TAMANIO_CASILLERO + 15 + 18);

        Text explicacionN = new Text("En el casillero hay un nodo mineral");
        explicacionN.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        explicacionN.setFill(Paint.valueOf("#3B3856"));
        explicacionN.relocate(App.TAMANIO_CASILLERO + 15, App.TAMANIO_CASILLERO + 15 + 18);

        panelManual.getChildren().addAll(casilleroV,volcan,explicacionV,casilleroN,nodo,explicacionN);
        this.getChildren().add(panelManual);
    }

    public void construcciones(){
        Pane panelManual = new Pane();
        panelManual.setBackground(new Background(new BackgroundFill(Color.valueOf("#D0CFE0"), CornerRadii.EMPTY, Insets.EMPTY)));

        Text explicacion = new Text("Letras sobre el casillero idican que hay una construccion. " +
                "Apareceran en gris mientras esten en construccion y cambiaran al color del jugador una vez construidas");
        explicacion.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        explicacion.setFill(Paint.valueOf("#3B3856"));
        explicacion.setY(18);
        explicacion.setWrappingWidth(750);

        Rectangle casilleroC = new Rectangle();
        casilleroC.setWidth(App.TAMANIO_CASILLERO);
        casilleroC.setHeight(App.TAMANIO_CASILLERO);
        casilleroC.setFill(Color.valueOf("#98C3A5"));
        casilleroC.setY(App.TAMANIO_CASILLERO + 25);

        Text construccion = new Text("P");
        construccion.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        construccion.setFill(Color.valueOf("#3B3856"));
        construccion.setY(App.TAMANIO_CASILLERO + 25 + 18);

        Text explicacionL = new Text("Las letras dependen de la construccion. P: Pilon");
        explicacionL.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        explicacionL.setFill(Color.valueOf("#3B3856"));
        explicacionL.relocate(App.TAMANIO_CASILLERO + 15,App.TAMANIO_CASILLERO + 25 + 18);

        panelManual.getChildren().addAll(explicacion,casilleroC,construccion,explicacionL);
        this.getChildren().add(panelManual);
    }

    public void unidades(){
        Pane panelManual = new Pane();
        panelManual.setBackground(new Background(new BackgroundFill(Color.valueOf("#D0CFE0"), CornerRadii.EMPTY, Insets.EMPTY)));

        Text explicacion = new Text("Indica que hay por lo menos una unidad en ese casillero. Para ver que unidades son haga click en el punto.");
        explicacion.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        explicacion.setFill(Paint.valueOf("#3B3856"));
        explicacion.relocate(App.TAMANIO_CASILLERO + 15, 10);
        explicacion.setWrappingWidth(665);

        Rectangle casilleroU = new Rectangle();
        casilleroU.setWidth(App.TAMANIO_CASILLERO);
        casilleroU.setHeight(App.TAMANIO_CASILLERO);
        casilleroU.setFill(Color.valueOf("#B7B5CF"));

        MenuItem explicacionU1 = new MenuItem("Para seleccionar una unidad");
        MenuItem explicacionU2 = new MenuItem("haga click en ella.");
        List<MenuItem> menuItems = new LinkedList<>();
        menuItems.add(explicacionU1);
        menuItems.add(explicacionU2);

        Circle unidades = new Circle();
        unidades.setRadius(5);
        unidades.relocate(49,5);
        unidades.setFill(Color.valueOf("#FAEE87"));
        unidades.setOnMousePressed(new SeleccionUnidadesEventHandler(menuItems));

        panelManual.getChildren().addAll(explicacion,casilleroU,unidades);
        this.getChildren().add(panelManual);
    }
}
