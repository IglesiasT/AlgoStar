package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.estados.Jugando;
import edu.fiuba.algo3.modelo.estados.Terminado;
import edu.fiuba.algo3.modelo.jugador.DatosRepetidos;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.MaximoDeJugadoresAlcanzado;
import edu.fiuba.algo3.modelo.jugador.NoExisteElJugador;
import edu.fiuba.algo3.modelo.mapa.*;
import javafx.scene.paint.Color;

public class AlgoStar {
    private final ArrayList<Jugador> jugadores;
    private final Mapa mapa ;
    private Estado estado;
    private int turnos;
    private int maximoJugadores;

    public AlgoStar (){

        this.jugadores = new ArrayList<>();
        this.mapa = new Mapa();
        this.turnos = 0;
        this.maximoJugadores = 2;
    }

    public void comenzarJuego(){
        this.estado = new Jugando();
    }
    public void siguienteTurno(Jugador jugador){
        jugador.obtenerRaza().nuevoTurno();
        this.turnos++;
        this.estado = this.terminarJuego(this.estado);
        this.estado.jugar() ;
    }
    private Estado terminarJuego(Estado estado) {
        for (Jugador jugador : this.jugadores){
            if ( (jugador.cantidadDeConstruccionesRealizadas() == 0) && (this.turnos >= 2) ) {
                return new Terminado();
            }
        }
        return estado;
    }
    public Jugador obtenerGanador() {
        for (Jugador jugador : this.jugadores){
            if ( (jugador.cantidadDeConstruccionesRealizadas() == 0) && (this.turnos >= 2) ) {
                jugadores.remove(jugador);
                return jugadores.get(0);
            }
        }
        return null;
    }
    public void agregarJugador (String nombreJugador, Color color, String razaJugador){

        Jugador jugador;

        if (this.jugadores.size() == this.maximoJugadores) {
            throw new MaximoDeJugadoresAlcanzado();
        }
        else if(this.jugadores.isEmpty()){
            jugador = new Jugador(nombreJugador , color , razaJugador);
        } else {
            jugador = this.jugadores.get(0).crearUnJugadorDistinto(nombreJugador, color, razaJugador);
        }

        if (jugador != null){
            this.jugadores.add(jugador);
            jugador.setBaseInicial(this.mapa.obtenerBase(2));
        }
        else {
            throw new DatosRepetidos();
        }
    }
    public Mapa obtenerMapa(){
        return this.mapa;
    }
    public Jugador obtenerJugador (int numeroJugador) {
        if (this.jugadores.size() >= numeroJugador){
            return this.jugadores.get(numeroJugador-1) ;
        }else{
            throw new NoExisteElJugador();
        }
    }
}
