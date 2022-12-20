package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.construcciones.unidades.Unidad;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.MutaliscoBase;
import edu.fiuba.algo3.modelo.mapa.Base;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.razas.*;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.Objects;

public class Jugador {
    private final String nombre ;
    private final Color color ;
    private final Raza raza ;
    private Base baseInicial;

    public Jugador(String nombre, Color color , String raza) {

        if (nombre.length() < 6){
            throw new NombreInvalido();
        }

        this.nombre = nombre ;
        this.color = color ;
        this.raza=stringARaza(raza);
    }

    private Raza stringARaza(String razaString){
        Raza razaRaza = null;
        if (razaString.equals("Zerg")) {
            razaRaza = new Zerg(200,0);
        } else if (razaString.equals("Protoss")){
            razaRaza = new Protoss(200,0) ;
        } else {
            throw new RazaInvalida() ;
        }
        return razaRaza;
    }

    public void setBaseInicial(Base baseInicial){
        this.baseInicial = baseInicial;
    }

    public int cantidadDeConstruccionesRealizadas(){
        return this.raza.construccionesRealizadas();
    }

    public Jugador crearUnJugadorDistinto(String nombreJugador, Color color, String razaJugador){
        Jugador jugadorDos = null;
        if ((!Objects.equals(this.nombre, nombreJugador))&&
                (!Objects.equals(this.color,color))&& (!Objects.equals(this.raza.getClass(), stringARaza(razaJugador).getClass()))){
            jugadorDos = new Jugador(nombreJugador,color,razaJugador);
        }
        return jugadorDos;
    }

    public Color obtenerColor(){
        return this.color;
    }
    public String obtenerNombre(){ return this.nombre; }
    public Raza obtenerRaza(){ return this.raza; }

    public void construir(String construccion, Casillero casillero){
        raza.construir(construccion,casillero);
    }
    public void engendrar(String unidad,Casillero casillero){((Zerg)raza).engendrar(unidad,casillero);}
    public void evolucionar(String unidad, MutaliscoBase mutalisco){
        ((Zerg)raza).evolucionar(unidad,mutalisco);
    }
    public void mover(Unidad unidad, Casillero casillero){unidad.moverse(casillero);}
    public void atacar(Unidad atacante, Construccion objetivo){raza.atacar(atacante,objetivo);}
    public List<Construccion> obtenerConstrucciones(){return raza.obtenerConstrucciones();}
}
