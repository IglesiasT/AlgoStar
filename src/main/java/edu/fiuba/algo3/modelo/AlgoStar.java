package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.estados.Jugando;
import edu.fiuba.algo3.modelo.estados.Terminado;
import edu.fiuba.algo3.modelo.jugador.DatosRepetidos;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.*;
import javafx.scene.paint.Color;

public class AlgoStar {
    public static final int MAXIMOJUGADORES = 2;
    private ArrayList<Jugador> jugadores;
    private Mapa mapa ;
    private Estado estado;

    private int turnos;

    public AlgoStar (){

        this.jugadores = new ArrayList<>();
        this.mapa = new Mapa();
        this.turnos = 0;
    }

    public void comenzarJuego(){
        this.estado = new Jugando();
    }

    public void siguienteTurno(Jugador jugador){
        this.estado.jugar() ;
        jugador.obtenerRaza().nuevoTurno();
        this.turnos++;
        this.estado = this.terminarJuego(this.estado);
    }

    private Estado terminarJuego(Estado estado) {
        for (Jugador jugador : this.jugadores){
            if ( (jugador.cantidadDeConstruccionesRealizadas() == 0) && (this.turnos >= 2) ) {
                return new Terminado();
            }
        }
        return estado;
    }

    public void agregarJugadorUno(String nombreJugador, Color color, String razaJugador){
        Jugador jugadorUno = new Jugador(nombreJugador,color,razaJugador);
        jugadorUno.setBaseInicial(this.mapa.obtenerBaseUno());
        this.jugadores.add(jugadorUno);
    }
    public void agregarJugadorDos(String nombreJugador, Color color, String razaJugador){
        Jugador jugadorDos = this.jugadores.get(0).agregarJugadorDos(nombreJugador, color, razaJugador);
        if (jugadorDos != null){
            this.jugadores.add(jugadorDos);
            jugadorDos.setBaseInicial(this.mapa.obtenerBaseDos());
        }
        else {
            throw new DatosRepetidos();
        }
    }
    public Mapa obtenerMapa(){
        return this.mapa;
    }

    public Jugador obtenerJugadorUno(){
        return this.jugadores.get(0);
    }
    public Jugador obtenerJugadorDos(){
        return this.jugadores.get(1);
    }

}
