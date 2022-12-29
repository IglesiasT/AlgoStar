package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.controlador.BotonNuevaPartidaEventHandler;
import edu.fiuba.algo3.controlador.SeleccionUnidadesEventHandler;
import edu.fiuba.algo3.modelo.AlgoStar;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ContenedorManual extends VBox {
    public ContenedorManual(Stage stage) {
        super();
        this.setAlignment(Pos.CENTER);

        MediaView view = new MediaView();
        Media video = new Media(Objects.requireNonNull(getClass().getResource("/videos/videoInicio.mp4")).toExternalForm());
        MediaPlayer player = new MediaPlayer(video);
        view.setMediaPlayer(player);
        player.setAutoPlay(true);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.play();

        Pane background = new Pane() ;
        background.getChildren().addAll(view);
        this.getChildren().add(background);

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Castellar", FontWeight.BOLD, 60));
        etiqueta.setText("MANUAL");
        etiqueta.setTextFill(Color.WHITE);
        etiqueta.setTranslateY(-800);

        areas();
        recursos();
        construcciones();
        unidades();

        Button botonNuevaPartida = new Button();
        botonNuevaPartida.setText("Nueva partida");
        botonNuevaPartida.setFont(Font.font("Agency FB", FontWeight.BOLD, 20));
        botonNuevaPartida.setTranslateY(-20);
        botonNuevaPartida.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));


        Scene proximaEscena = new Scene(new ContenedorElegirJugador(stage, new AlgoStar(), ""), 850, 850);
        BotonNuevaPartidaEventHandler botonNuevaPartidaEventHandler = new BotonNuevaPartidaEventHandler(stage, proximaEscena);
        botonNuevaPartida.setOnAction(botonNuevaPartidaEventHandler);

        this.getChildren().addAll(etiqueta, botonNuevaPartida);

    }

    public void areas(){
        Pane panelManual = new Pane();

        Rectangle casilleroT = new Rectangle();
        casilleroT.setWidth(App.TAMANIO_CASILLERO);
        casilleroT.setHeight(App.TAMANIO_CASILLERO);
        casilleroT.setFill(Color.valueOf("#98C3A5"));
        Text explicacionT = new Text("Casillero en area terrestre");
        explicacionT.setFont(Font.font("Agency FB", FontWeight.BOLD, 25));
        explicacionT.setFill(Paint.valueOf("#FFFFFF"));
        explicacionT.relocate(App.TAMANIO_CASILLERO + 15, 18);

        casilleroT.setTranslateY(-700);
        casilleroT.setTranslateX(25);
        explicacionT.setTranslateY(-700);
        explicacionT.setTranslateX(25);

        Rectangle casilleroE = new Rectangle();
        casilleroE.setWidth(App.TAMANIO_CASILLERO);
        casilleroE.setHeight(App.TAMANIO_CASILLERO);
        casilleroE.setFill(Color.valueOf("#9CA9D3"));
        casilleroE.setY(App.TAMANIO_CASILLERO + 15);
        Text explicacionE = new Text("Casillero en area espacial");
        explicacionE.setFont(Font.font("Agency FB", FontWeight.BOLD, 25));
        explicacionE.setFill(Paint.valueOf("#FFFFFF"));
        explicacionE.relocate(App.TAMANIO_CASILLERO + 15, App.TAMANIO_CASILLERO + 15 + 18);

        casilleroE.setTranslateY(-675);
        casilleroE.setTranslateX(25);
        explicacionE.setTranslateY(-675);
        explicacionE.setTranslateX(25);

        Text explicacionCasillero = new Text("Para seleccionar un casillero haga click sobre él");
        explicacionCasillero.setFont(Font.font("Agency FB", FontWeight.BOLD, 25));
        explicacionCasillero.setFill(Paint.valueOf("#FFFFFF"));
        explicacionCasillero.setY(App.TAMANIO_CASILLERO*2 + 15*2 + 18);

        explicacionCasillero.setTranslateY(-650);
        explicacionCasillero.setTranslateX(25);

        panelManual.getChildren().addAll(casilleroT,explicacionT,casilleroE,explicacionE,explicacionCasillero);
        this.getChildren().add(panelManual);
    }

    public void recursos(){
        Pane panelManual = new Pane();

        Rectangle casilleroV = new Rectangle();
        casilleroV.setWidth(App.TAMANIO_CASILLERO);
        casilleroV.setHeight(App.TAMANIO_CASILLERO);
        casilleroV.setFill(Paint.valueOf("#FFFFFF"));

        Text volcan = new Text("Δ");
        volcan.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        volcan.setFill(Color.valueOf("#F9627D"));
        volcan.relocate(20,18);

        Text explicacionV = new Text("En el casillero hay un volcan");
        explicacionV.setFont(Font.font("Agency FB", FontWeight.BOLD, 25));
        explicacionV.setFill(Paint.valueOf("#FFFFFF"));
        explicacionV.relocate(App.TAMANIO_CASILLERO + 15, 18);


        casilleroV.setTranslateY(-450);
        casilleroV.setTranslateX(25);
        volcan.setTranslateY(-450);
        volcan.setTranslateX(25);
        explicacionV.setTranslateY(-450);
        explicacionV.setTranslateX(25);


        Rectangle casilleroN = new Rectangle();
        casilleroN.setWidth(App.TAMANIO_CASILLERO);
        casilleroN.setHeight(App.TAMANIO_CASILLERO);
        casilleroN.setFill(Color.valueOf("#FFFFFF"));
        casilleroN.setY(App.TAMANIO_CASILLERO + 15);

        Text nodo = new Text("❖");
        nodo.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        nodo.setFill(Color.valueOf("#A15BC7"));
        nodo.relocate(20,App.TAMANIO_CASILLERO + 15 + 18);

        Text explicacionN = new Text("En el casillero hay un nodo mineral");
        explicacionN.setFont(Font.font("Agency FB", FontWeight.BOLD, 25));
        explicacionN.setFill(Paint.valueOf("#FFFFFF"));
        explicacionN.relocate(App.TAMANIO_CASILLERO + 15, App.TAMANIO_CASILLERO + 15 + 18);

        casilleroN.setTranslateY(-425);
        casilleroN.setTranslateX(25);
        nodo.setTranslateY(-425);
        nodo.setTranslateX(25);
        explicacionN.setTranslateY(-425);
        explicacionN.setTranslateX(25);

        panelManual.getChildren().addAll(casilleroV,volcan,explicacionV,casilleroN,nodo,explicacionN);

        this.getChildren().addAll(panelManual);
    }

    public void construcciones(){
        Pane panelManual = new Pane();

        Text explicacion = new Text("Letras sobre el casillero idican que hay una construccion. " +
                "Apareceran en gris mientras esten en construccion y cambiaran al color del jugador una vez construidas");
        explicacion.setFont(Font.font("Agency FB", FontWeight.BOLD, 25));
        explicacion.setFill(Paint.valueOf("#FFFFFF"));
        explicacion.setY(18);
        explicacion.setWrappingWidth(750);

        explicacion.setTranslateY(-250);
        explicacion.setTranslateX(25);

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
        explicacionL.setFont(Font.font("Agency FB", FontWeight.BOLD, 25));
        explicacionL.setFill(Color.valueOf("#FFFFFF"));
        explicacionL.relocate(App.TAMANIO_CASILLERO + 15,App.TAMANIO_CASILLERO + 25 + 18);

        casilleroC.setTranslateY(-250);
        casilleroC.setTranslateX(25);
        construccion.setTranslateY(-250);
        construccion.setTranslateX(25);
        explicacionL.setTranslateY(-250);
        explicacionL.setTranslateX(25);

        panelManual.getChildren().addAll(explicacion,casilleroC,construccion,explicacionL);
        this.getChildren().add(panelManual);
    }

    public void unidades(){
        Pane panelManual = new Pane();
        panelManual.setBackground(new Background(new BackgroundFill(Color.valueOf("#D0CFE0"), CornerRadii.EMPTY, Insets.EMPTY)));

        Text explicacion = new Text("Indica que hay por lo menos una unidad en ese casillero. Para ver que unidades son haga click en el punto.");
        explicacion.setFont(Font.font("Agency FB", FontWeight.BOLD, 25));
        explicacion.setFill(Paint.valueOf("#FFFFFF"));
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

        explicacion.setTranslateY(-75);
        explicacion.setTranslateX(25);
        casilleroU.setTranslateY(-75);
        casilleroU.setTranslateX(25);
        unidades.setTranslateY(-75);
        unidades.setTranslateX(25);

        panelManual.getChildren().addAll(explicacion,casilleroU,unidades);
        this.getChildren().add(panelManual);
    }
}
