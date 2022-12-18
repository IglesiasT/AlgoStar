package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.*;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.*;
import edu.fiuba.algo3.modelo.construcciones.unidades.Unidad;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.RangoPilon;
import edu.fiuba.algo3.modelo.mapa.Base;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.vista.contenedoresAcciones.ContenedorAccion;
import edu.fiuba.algo3.controlador.SeleccionCasilleroEventHandler;
import edu.fiuba.algo3.controlador.SeleccionUnidadEventHandler;
import edu.fiuba.algo3.controlador.SeleccionUnidadesEventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ContenedorMapa extends Pane {


    private final Stage stage;
    private Canvas canvas;

    private AlgoStar juego;
    private ContenedorAccion accion;

    private Map<Class, Color> areasMapa;
    private Map<Class, String> recursosTexto;
    private Map<Class, String> construcciones;
    private Map<Class, Color> construccionesColor;
    private Map<Class, String> unidades;
    private Map<Class, String> unidadesDuenio;

    private Rectangle[][] mapaBaseVista;

    private Map<String, Color> recursosColor;
    public ContenedorMapa(Stage stage, AlgoStar juego, ContenedorAccion accion, boolean seleccionCasillero,boolean seleccionUnidad){
        super();
        this.stage = stage;
        this.canvas = new Canvas();
        this.juego = juego;
        this.accion = accion;

        this.areasMapa = new HashMap<>();
        areasMapa.put(AreaTerrestre.class,Color.valueOf("#98C3A5"));
        areasMapa.put(AreaEspacial.class, Color.valueOf("#9CA9D3"));

        this.recursosTexto = new HashMap<>();
        recursosTexto.put(Volcan.class,"Δ");
        recursosTexto.put(Nodo.class,"❖");
        recursosTexto.put(SinRecurso.class,"");

        this.recursosColor = new HashMap<>();
        recursosColor.put("Δ",Color.valueOf("#F9627D"));
        recursosColor.put("❖",Color.valueOf("#A15BC7"));
        recursosColor.put("",Color.TRANSPARENT);

        cargarDiccionarioConstrucciones();

        this.construccionesColor = new HashMap<>();
        construccionesColor.put(juego.obtenerJugadorUno().obtenerRaza().getClass(),juego.obtenerJugadorUno().obtenerColor());
        construccionesColor.put(juego.obtenerJugadorDos().obtenerRaza().getClass(),juego.obtenerJugadorDos().obtenerColor());

        this.unidadesDuenio = new HashMap<>();
        unidadesDuenio.put(juego.obtenerJugadorUno().obtenerRaza().getClass(),juego.obtenerJugadorUno().obtenerNombre());
        unidadesDuenio.put(juego.obtenerJugadorDos().obtenerRaza().getClass(),juego.obtenerJugadorDos().obtenerNombre());

        this.mostrarMapa(juego.obtenerMapa(),seleccionCasillero,seleccionUnidad);
    }



    private void mostrarMapa(Mapa mapa, boolean seleccionCasillero,boolean seleccionUnidad) {

        int tamanioMapa = mapa.obtenerTamanio();

        this.mapaBaseVista = new Rectangle[tamanioMapa][tamanioMapa];

        Group grupoDeCasilleros = new Group();
        Group grupoDeRecursos = new Group();
        Group grupoDeBases = new Group();
        Group grupoDeConstrucciones = new Group();
        Group grupoDeUnidades = new Group();
        Group grupoDeEspacios = new Group();

        this.setPrefSize(tamanioMapa* App.TAMANIO_CASILLERO, tamanioMapa* App.TAMANIO_CASILLERO);
        this.getChildren().addAll(grupoDeCasilleros,grupoDeEspacios,grupoDeRecursos,grupoDeBases,
                grupoDeConstrucciones,grupoDeUnidades);

        this.cargarBaseJugadorVista(crearBaseVista(mapa.obtenerBaseUno()),juego.obtenerJugadorUno().obtenerColor(),grupoDeBases);
        this.cargarBaseJugadorVista(crearBaseVista(mapa.obtenerBaseDos()),juego.obtenerJugadorDos().obtenerColor(),grupoDeBases);

        for (int i = 0; i < tamanioMapa; i++){
            for (int j = 0; j < tamanioMapa; j++){
                Casillero casilleroModelo = mapa.obtenerCasillero(i,j);
                Rectangle casilleroVista = crearCasilleroVista(casilleroModelo,seleccionCasillero);
                mapaBaseVista[i][j] = casilleroVista;
                grupoDeCasilleros.getChildren().add(casilleroVista);
                grupoDeEspacios.getChildren().add(crearEspacioDeConstruccionVista(casilleroModelo));
                grupoDeRecursos.getChildren().add(crearRecursoVista(casilleroModelo));
                grupoDeConstrucciones.getChildren().add(crearConstruccionVista(casilleroModelo));
                grupoDeUnidades.getChildren().add(crearUnidadVista(casilleroModelo,seleccionUnidad));
            }
        }

    }

    private Rectangle crearBaseVista(Base baseModelo){
        Rectangle baseVista = new Rectangle();
        //baseVista.setWidth(App.TAMANIO_CASILLERO*(Base.RADIO*2 +1) -1 );
        //baseVista.setHeight(App.TAMANIO_CASILLERO*(Base.RADIO*2 +1) -1 );
        baseVista.setWidth(10);
        baseVista.setHeight(10);
        baseVista.setFill(Color.TRANSPARENT);
        //baseVista.relocate((baseModelo.obtenerUbicacion().obtenerFila()-Base.RADIO) * App.TAMANIO_CASILLERO,
        //        (baseModelo.obtenerUbicacion().obtenerColumna()-Base.RADIO) * App.TAMANIO_CASILLERO );

        baseVista.relocate((baseModelo.obtenerUbicacion().obtenerFila()) * App.TAMANIO_CASILLERO,
                (baseModelo.obtenerUbicacion().obtenerColumna()) * App.TAMANIO_CASILLERO );
        return baseVista;
    }

    private void cargarBaseJugadorVista(Rectangle baseVista,Color colorJugador,Group grupoDeBases){
        baseVista.setFill(colorJugador);
        grupoDeBases.getChildren().add(baseVista);

    }

    private Rectangle crearCasilleroVista(Casillero casilleroModelo,boolean conSeleccion){
        Rectangle casilleroVista = new Rectangle();
        casilleroVista.setWidth(App.TAMANIO_CASILLERO);
        casilleroVista.setHeight(App.TAMANIO_CASILLERO);
        casilleroVista.relocate(casilleroModelo.obtenerFila() * App.TAMANIO_CASILLERO,casilleroModelo.obtenerColumna() * App.TAMANIO_CASILLERO);
        casilleroVista.setFill(areasMapa.get(casilleroModelo.obtenerArea().getClass()));
        if (conSeleccion)
            casilleroVista.setOnMouseClicked(new SeleccionCasilleroEventHandler(this.stage,this.accion,casilleroModelo,casilleroVista,mapaBaseVista));
        return casilleroVista;
    }

    private Text crearRecursoVista(Casillero casilleroModelo){
        Recurso recursoModelo = casilleroModelo.obtenerRecurso();
        Text recursoVista = new Text(recursosTexto.get(recursoModelo.getClass()));
        recursoVista.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        recursoVista.setFill(recursosColor.get(recursosTexto.get(recursoModelo.getClass())));
        recursoVista.relocate(casilleroModelo.obtenerFila()*App.TAMANIO_CASILLERO + 20,
                casilleroModelo.obtenerColumna()*App.TAMANIO_CASILLERO+18);
        return recursoVista;
    }

    private Text crearConstruccionVista(Casillero casilleroModelo){
        Construccion construccionModelo = casilleroModelo.obtenerConstruccion();
        Text construccionVista = new Text();
        if (construccionModelo != null) {
            construccionVista.setText(construcciones.get(construccionModelo.getClass()));
            construccionVista.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
            if(!construccionModelo.activa())
                construccionVista.setFill(Color.GRAY);
            else
                construccionVista.setFill(construccionesColor.get(construccionModelo.obtenerRazaMadre()));
            construccionVista.relocate(casilleroModelo.obtenerFila() * App.TAMANIO_CASILLERO,
                    casilleroModelo.obtenerColumna() * App.TAMANIO_CASILLERO);
        }
        return construccionVista;
    }

    private Circle crearUnidadVista(Casillero casilleroModelo,boolean seleccionUnidad){
        boolean unidadModelo = !casilleroModelo.obtenerUnidades().isEmpty();
        Circle unidadVista = new Circle();
        unidadVista.setFill(Color.TRANSPARENT);
        List<MenuItem> menuItems = new LinkedList<>();
        if (unidadModelo){
            List<Unidad> unidadesModelo = casilleroModelo.obtenerUnidades();
            for (Unidad unidad: unidadesModelo){
                String[] unidadString = (unidad.getClass().toString().split("\\."));
                MenuItem unidadOpcion = new MenuItem(unidadString[unidadString.length - 1] + " " + unidadesDuenio.get(unidad.obtenerRazaMadre()));
                if(seleccionUnidad) {
                    unidadOpcion.setOnAction(new SeleccionUnidadEventHandler(accion, unidad));
                }
                menuItems.add(unidadOpcion);
            }
            unidadVista.setOnMousePressed(new SeleccionUnidadesEventHandler(menuItems));


            unidadVista.setRadius(5);
            unidadVista.relocate(casilleroModelo.obtenerFila() * App.TAMANIO_CASILLERO+49,casilleroModelo.obtenerColumna() * App.TAMANIO_CASILLERO+5);
            unidadVista.setFill(Color.valueOf("#FAEE87"));

        }
        return unidadVista;
    }

    private Rectangle crearEspacioDeConstruccionVista(Casillero casilleroModelo){
        Rectangle espacioVista = new Rectangle();
        espacioVista.setWidth(Math.sqrt(2)*App.TAMANIO_CASILLERO);
        espacioVista.setHeight(3);
        espacioVista.relocate(casilleroModelo.obtenerFila() * App.TAMANIO_CASILLERO-((espacioVista.getWidth()-App.TAMANIO_CASILLERO)/2),casilleroModelo.obtenerColumna() * App.TAMANIO_CASILLERO+(double)(App.TAMANIO_CASILLERO/2)-1.5);
        if(casilleroModelo.contiene(new Moho())) {
            espacioVista.setRotate(45);
            espacioVista.setFill(Color.valueOf("#72AC83"));
        }
        else if (casilleroModelo.contiene(new RangoPilon())) {
            espacioVista.setRotate(135);
            espacioVista.setFill(Color.valueOf("#6478B9"));
        }
        else espacioVista.setFill(Color.TRANSPARENT);
        return espacioVista;
    }

    private void cargarDiccionarioConstrucciones(){
        this.construcciones =new HashMap<>();
        construcciones.put(Criadero.class,"C");
        construcciones.put(ReservaDeReproduccion.class,"R");
        construcciones.put(Extractor.class,"EX");
        construcciones.put(Guarida.class,"GA");
        construcciones.put(Espiral.class,"ESP");
        construcciones.put(NexoMineral.class,"NM");
        construcciones.put(Pilon.class,"P");
        construcciones.put(Asimilador.class,"ASIM");
        construcciones.put(Acceso.class,"ACC");
        construcciones.put(PuertoEstelar.class,"PE");
    }

}
