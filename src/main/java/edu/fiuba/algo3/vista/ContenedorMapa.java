package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.mapa.Base;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.vista.contenedoresAcciones.ContenedorAccion;
import edu.fiuba.algo3.vista.eventos.SeleccionCasilleroEventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class ContenedorMapa extends Pane {


    private final Stage stage;
    private Canvas canvas;

    private AlgoStar juego;
    private ContenedorAccion accion;

    private Map<Class, Color> areasMapa;
    private Map<Class, String> recursosTexto;

    private Map<String, Color> recursosColor;
    public ContenedorMapa(Stage stage, AlgoStar juego, ContenedorAccion accion){
        super();
        this.stage = stage;
        this.canvas = new Canvas();
        this.juego = juego;
        this.accion = accion;

        this.areasMapa = new HashMap<>();
        areasMapa.put(AreaTerrestre.class,Color.GREEN);
        areasMapa.put(AreaEspacial.class,Color.BLUE);

        this.recursosTexto = new HashMap<>();
        recursosTexto.put(Volcan.class,"Δ");
        recursosTexto.put(Mineral.class,"❖");
        recursosTexto.put(SinRecurso.class,"");

        this.recursosColor = new HashMap<>();
        recursosColor.put("Δ",Color.RED);
        recursosColor.put("❖",Color.BLACK);
        recursosColor.put("",Color.TRANSPARENT);

        Label label = new Label();
        label.setText("contenedor principal");

        this.mostrarMenuRecursos();
        this.mostrarMapa(juego.obtenerMapa());

        this.getChildren().addAll(label);
    }

    private void mostrarMapa(Mapa mapa) {

        int tamanioMapa = mapa.obtenerTamanio();

        Group grupoDeCasilleros = new Group();
        Group grupoDeRecursos = new Group();
        Group grupoDeBases = new Group();

        this.setPrefSize(tamanioMapa* App.TAMANIO_CASILLERO, tamanioMapa* App.TAMANIO_CASILLERO);
        this.getChildren().addAll(grupoDeCasilleros,grupoDeRecursos,grupoDeBases);

        this.cargarBaseJugadorVista(crearBaseVista(mapa.obtenerBaseUno()),juego.obtenerJugadorUno().obtenerColor(),grupoDeBases);
        this.cargarBaseJugadorVista(crearBaseVista(mapa.obtenerBaseDos()),juego.obtenerJugadorDos().obtenerColor(),grupoDeBases);

        for (int i = 0; i < tamanioMapa; i++){
            for (int j = 0; j < tamanioMapa; j++){
                Casillero casilleroModelo = mapa.obtenerCasillero(i,j);
                grupoDeCasilleros.getChildren().add(crearCasilleroVista(casilleroModelo));
                grupoDeRecursos.getChildren().add(crearRecursoVista(casilleroModelo));
            }
        }

    }

    private Rectangle crearBaseVista(Base baseModelo){
        Rectangle baseVista = new Rectangle();
        baseVista.setWidth(App.TAMANIO_CASILLERO*(Base.RADIO*2 +1) -1 );
        baseVista.setHeight(App.TAMANIO_CASILLERO*(Base.RADIO*2 +1) -1 );
        baseVista.setFill(Color.TRANSPARENT);
        baseVista.relocate((baseModelo.obtenerUbicacion().obtenerFila()-Base.RADIO) * App.TAMANIO_CASILLERO+150,
                (baseModelo.obtenerUbicacion().obtenerColumna()-Base.RADIO) * App.TAMANIO_CASILLERO+60);

        return baseVista;
    }

    private void cargarBaseJugadorVista(Rectangle baseVista,Color colorJugador,Group grupoDeBases){
        baseVista.setStroke(colorJugador);
        baseVista.setStrokeWidth(2);

        grupoDeBases.getChildren().add(baseVista);

    }

    private Rectangle crearCasilleroVista(Casillero casilleroModelo){
        Rectangle casilleroVista = new Rectangle();
        casilleroVista.setWidth(App.TAMANIO_CASILLERO);
        casilleroVista.setHeight(App.TAMANIO_CASILLERO);
        casilleroVista.relocate(casilleroModelo.obtenerFila() * App.TAMANIO_CASILLERO +150,casilleroModelo.obtenerColumna() * App.TAMANIO_CASILLERO+60);
        casilleroVista.setFill(areasMapa.get(casilleroModelo.obtenerArea().getClass()));
        casilleroVista.setOnMouseClicked(new SeleccionCasilleroEventHandler(this.stage,this.accion,casilleroModelo));
        return casilleroVista;
    }

    private Text crearRecursoVista(Casillero casilleroModelo){
        Recurso recursoModelo = casilleroModelo.obtenerRecurso();
        Text recursoVista = new Text(recursosTexto.get(recursoModelo.getClass()));
        recursoVista.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        recursoVista.setFill(recursosColor.get(recursosTexto.get(recursoModelo.getClass())));
        recursoVista.relocate(casilleroModelo.obtenerFila()*App.TAMANIO_CASILLERO + 150,
                casilleroModelo.obtenerColumna()*App.TAMANIO_CASILLERO+60);
        return recursoVista;
    }
    private void mostrarMenuRecursos(){

    }
}
