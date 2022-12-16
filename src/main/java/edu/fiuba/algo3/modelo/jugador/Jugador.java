package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.mapa.Base;
import edu.fiuba.algo3.modelo.razas.*;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Jugador {
    private String nombre ;
    private Color color ;
    private Raza raza ;
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
            razaRaza = new Zerg();
        } else if (razaString.equals("Protoss")){
            razaRaza = new Protoss() ;
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

    public Jugador agregarJugadorDos(String nombreJugador, Color color, String razaJugador){
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
}
