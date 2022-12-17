package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.*;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.*;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.Dragon;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.Scout;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.*;
import edu.fiuba.algo3.modelo.mapa.Base;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.vista.contenedoresAcciones.ContenedorAccion;
import edu.fiuba.algo3.vista.eventos.SeleccionCasilleroEventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
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
    private Map<Class, String> construcciones;
    private Map<Class, Color> construccionesColor;

    private Rectangle[][] mapaBaseVista;

    private Map<String, Color> recursosColor;
    public ContenedorMapa(Stage stage, AlgoStar juego, ContenedorAccion accion){
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

        this.mostrarMapa(juego.obtenerMapa());
        //this.crearBordeMapa();
    }

    private void mostrarMapa(Mapa mapa) {

        int tamanioMapa = mapa.obtenerTamanio();

        this.mapaBaseVista = new Rectangle[tamanioMapa][tamanioMapa];

        Group grupoDeCasilleros = new Group();
        Group grupoDeRecursos = new Group();
        Group grupoDeBases = new Group();
        Group grupoDeConstrucciones = new Group();

        this.setPrefSize(tamanioMapa* App.TAMANIO_CASILLERO, tamanioMapa* App.TAMANIO_CASILLERO);
        this.getChildren().addAll(grupoDeCasilleros,grupoDeRecursos,grupoDeBases,grupoDeConstrucciones);

        this.cargarBaseJugadorVista(crearBaseVista(mapa.obtenerBaseUno()),juego.obtenerJugadorUno().obtenerColor(),grupoDeBases);
        this.cargarBaseJugadorVista(crearBaseVista(mapa.obtenerBaseDos()),juego.obtenerJugadorDos().obtenerColor(),grupoDeBases);

        for (int i = 0; i < tamanioMapa; i++){
            for (int j = 0; j < tamanioMapa; j++){
                Casillero casilleroModelo = mapa.obtenerCasillero(i,j);
                Rectangle casilleroVista = crearCasilleroVista(casilleroModelo);
                mapaBaseVista[i][j] = casilleroVista;
                grupoDeCasilleros.getChildren().add(casilleroVista);
                grupoDeRecursos.getChildren().add(crearRecursoVista(casilleroModelo));
                grupoDeConstrucciones.getChildren().add(crearConstruccionVista(casilleroModelo));
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

    private Rectangle crearCasilleroVista(Casillero casilleroModelo){
        Rectangle casilleroVista = new Rectangle();
        casilleroVista.setWidth(App.TAMANIO_CASILLERO);
        casilleroVista.setHeight(App.TAMANIO_CASILLERO);
        casilleroVista.relocate(casilleroModelo.obtenerFila() * App.TAMANIO_CASILLERO,casilleroModelo.obtenerColumna() * App.TAMANIO_CASILLERO);
        casilleroVista.setFill(areasMapa.get(casilleroModelo.obtenerArea().getClass()));
        casilleroVista.setOnMouseClicked(new SeleccionCasilleroEventHandler(this.stage,this.accion,casilleroModelo,casilleroVista,mapaBaseVista));
        return casilleroVista;
    }

    private Text crearRecursoVista(Casillero casilleroModelo){
        Recurso recursoModelo = casilleroModelo.obtenerRecurso();
        Text recursoVista = new Text(recursosTexto.get(recursoModelo.getClass()));
        recursoVista.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        recursoVista.setFill(recursosColor.get(recursosTexto.get(recursoModelo.getClass())));
        recursoVista.relocate(casilleroModelo.obtenerFila()*App.TAMANIO_CASILLERO + 10,
                casilleroModelo.obtenerColumna()*App.TAMANIO_CASILLERO+10);
        return recursoVista;
    }

    private Text crearConstruccionVista(Casillero casilleroModelo){
        Construccion construccionModelo = casilleroModelo.obtenerConstruccion();
        Text construccionVista = new Text();
        if (construccionModelo != null) {
            construccionVista.setText(construcciones.get(construccionModelo.getClass()));
            construccionVista.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
            construccionVista.setFill(construccionesColor.get(construccionModelo.obtenerRazaMadre()));
            construccionVista.relocate(casilleroModelo.obtenerFila() * App.TAMANIO_CASILLERO,
                    casilleroModelo.obtenerColumna() * App.TAMANIO_CASILLERO);
        }
        return construccionVista;
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
        construcciones.put(AmoSupremo.class,"AS");
        construcciones.put(Zangano.class,"ZAN");
        construcciones.put(Zerling.class,"ZER");
        construcciones.put(Hidralisco.class,"H");
        construcciones.put(Mutalisco.class,"M");
        construcciones.put(Guardian.class,"GN");
        construcciones.put(Devorador.class,"DEV");
        construcciones.put(Zealot.class,"ZEA");
        construcciones.put(Dragon.class,"DRA");
        construcciones.put(Scout.class,"S");
    }

}
