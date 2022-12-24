package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.*;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.*;
import edu.fiuba.algo3.modelo.construcciones.unidades.Unidad;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.MutaliscoBase;
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
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.util.*;

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

        cargarDiccionariosVista();

        this.mostrarMapa(juego.obtenerMapa(),seleccionCasillero,seleccionUnidad);
    }

    public ContenedorMapa(Stage stage, AlgoStar juego, Casillero casillero){
        super();
        this.stage = stage;
        this.canvas = new Canvas();
        this.juego = juego;

        cargarDiccionariosVista();

        this.mostrarMapa(casillero);
    }


    private void cargarDiccionariosVista(){
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
        construccionesColor.put(juego.obtenerJugador(1).obtenerRaza().getClass(),juego.obtenerJugador(1).obtenerColor());
        construccionesColor.put(juego.obtenerJugador(2).obtenerRaza().getClass(),juego.obtenerJugador(2).obtenerColor());

        this.unidadesDuenio = new HashMap<>();
        unidadesDuenio.put(juego.obtenerJugador(1).obtenerRaza().getClass(),juego.obtenerJugador(1).obtenerNombre());
        unidadesDuenio.put(juego.obtenerJugador(2).obtenerRaza().getClass(),juego.obtenerJugador(2).obtenerNombre());
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

        this.cargarBaseJugadorVista(crearBaseVista(mapa.obtenerBase(1)),juego.obtenerJugador(1).obtenerColor(),grupoDeBases);
        this.cargarBaseJugadorVista(crearBaseVista(mapa.obtenerBase(2)),juego.obtenerJugador(2).obtenerColor(),grupoDeBases);

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

    private void mostrarMapa(Casillero casilleroCentro) {

        this.setBackground(new Background(new BackgroundFill(Color.valueOf("#B7B5CF"), CornerRadii.EMPTY, Insets.EMPTY)));

        int tamanioMapa = 9;

        this.mapaBaseVista = new Rectangle[tamanioMapa][tamanioMapa];

        Group grupoDeCasilleros = new Group();
        Group grupoDeRecursos = new Group();
        Group grupoDeConstrucciones = new Group();
        Group grupoDeUnidades = new Group();
        Group grupoDeEspacios = new Group();

        this.setPrefSize(tamanioMapa* App.TAMANIO_CASILLERO, tamanioMapa* App.TAMANIO_CASILLERO);
        this.getChildren().addAll(grupoDeCasilleros,grupoDeEspacios,grupoDeRecursos,
                grupoDeConstrucciones,grupoDeUnidades);

        ArrayList<? extends Casillero> casilleros = casilleroCentro.obtenerCasilleros(4);

        for (Casillero casillero: casilleros){
            int filaVista = casillero.obtenerFila() - casilleroCentro.obtenerFila() + 4;
            int columnaVista = casillero.obtenerColumna() - casilleroCentro.obtenerColumna() + 4;

            Rectangle casilleroVista = crearCasilleroVista(casillero,false);
            casilleroVista.relocate(filaVista* App.TAMANIO_CASILLERO,columnaVista* App.TAMANIO_CASILLERO);
            mapaBaseVista[filaVista][columnaVista] = casilleroVista;
            grupoDeCasilleros.getChildren().add(casilleroVista);

            Rectangle espacioVista = crearEspacioDeConstruccionVista(casillero);
            espacioVista.relocate(filaVista* App.TAMANIO_CASILLERO-((espacioVista.getWidth()-App.TAMANIO_CASILLERO)/2),
                    columnaVista* App.TAMANIO_CASILLERO+(double)(App.TAMANIO_CASILLERO/2)-1.5);
            grupoDeEspacios.getChildren().add(espacioVista);

            Text recursoVista = crearRecursoVista(casillero);
            recursoVista.relocate(filaVista*App.TAMANIO_CASILLERO + 20,columnaVista*App.TAMANIO_CASILLERO+18);
            grupoDeRecursos.getChildren().add(recursoVista);

            Text construccionVista = crearConstruccionVista(casillero);
            construccionVista.relocate(filaVista* App.TAMANIO_CASILLERO,columnaVista* App.TAMANIO_CASILLERO);
            grupoDeConstrucciones.getChildren().add(construccionVista);

            Circle unidadVista = crearUnidadVista(casillero,false);
            unidadVista.relocate(filaVista*App.TAMANIO_CASILLERO + 49,columnaVista*App.TAMANIO_CASILLERO+5);
            grupoDeUnidades.getChildren().add(unidadVista);

        }

    }

    private Rectangle crearBaseVista(Base baseModelo){
        Rectangle baseVista = new Rectangle();
        baseVista.setWidth(10);
        baseVista.setHeight(10);
        baseVista.setFill(Color.TRANSPARENT);
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
        casilleroVista.setFill(areasMapa.get(casilleroModelo.obtenerArea()));
        if (conSeleccion)
            casilleroVista.setOnMouseClicked(new SeleccionCasilleroEventHandler(this.stage,this.accion,casilleroModelo,casilleroVista,mapaBaseVista));
        return casilleroVista;
    }

    private Text crearRecursoVista(Casillero casilleroModelo){
        Class <? extends Recurso> recursoModelo = casilleroModelo.obtenerRecurso();
        Text recursoVista = new Text(recursosTexto.get(recursoModelo));
        recursoVista.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        recursoVista.setFill(recursosColor.get(recursosTexto.get(recursoModelo)));
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
                MenuItem unidadOpcion;
                if (unidad.getClass() == MutaliscoBase.class)
                    unidadOpcion = new MenuItem(((MutaliscoBase) unidad).obtenerEstado() + " " + unidadesDuenio.get(unidad.obtenerRazaMadre()));
                else unidadOpcion = new MenuItem(unidadString[unidadString.length - 1] + " " + unidadesDuenio.get(unidad.obtenerRazaMadre()));
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
        if(casilleroModelo.obtenerEspacio() == Moho.class) {
            espacioVista.setRotate(45);
            espacioVista.setFill(Color.valueOf("#72AC83"));
        }
        else if (casilleroModelo.obtenerEspacio() == RangoPilon.class) {
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
