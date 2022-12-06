package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.areas.Area;
import edu.fiuba.algo3.modelo.areas.AreaEspacial;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.estados.EstadoDeJuego;
import edu.fiuba.algo3.modelo.estados.Jugando;
import edu.fiuba.algo3.modelo.estados.Terminado;
import edu.fiuba.algo3.modelo.jugador.DatosRepetidos;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.*;
import edu.fiuba.algo3.modelo.razas.Raza;

import java.util.Scanner;

public class AlgoStar {
    public static final int MAXIMOJUGADORES = 2;
    private ArrayList<Jugador> jugadores;
    private Mapa mapa ;
    private EstadoDeJuego estado;

    private int turnos;

    public AlgoStar (){

        this.jugadores = new ArrayList<>();
        this.mapa = new Mapa();
        this.turnos = 0;
    }

    private String[] conseguirDatosDelJugador(Scanner lectura) {

        String[] datos = new String[3];

        System.out.println("\nIngrese su nombre: ");
        datos[0] = lectura.next();

        System.out.println("\nIngrese su color: ");
        datos[1] = lectura.next();

        System.out.println("\nIngrese su raza: \nZerg\nProtoss");
        datos[2] = lectura.next();

        return datos;
    }

    public void comenzarJuego(){

        Scanner lectura = new Scanner (System.in);

        String[] DatosJugadorUno = this.conseguirDatosDelJugador(lectura);
        String[] DatosJugadorDos = this.conseguirDatosDelJugador(lectura);

        for (int i=0; i<3 ; i++) {
            if (DatosJugadorDos[i].equals(DatosJugadorUno[i]) ) {
                throw new DatosRepetidos();
            }
        }

        jugadores.add ( new Jugador (DatosJugadorUno[0], DatosJugadorUno[1], DatosJugadorUno[2]) ) ;
        jugadores.get(0).setBaseInicial(mapa.obtenerBaseUno());
        jugadores.add ( new Jugador (DatosJugadorDos[0], DatosJugadorDos[1], DatosJugadorDos[2]) ) ;
        jugadores.get(1).setBaseInicial(mapa.obtenerBaseDos());

        this.estado = new Jugando();
    }

    public void siguienteTurno(){
        this.estado.jugar() ;
        this.turnos++;
        this.estado = this.terminarJuego(this.estado);
    }

    private EstadoDeJuego terminarJuego(EstadoDeJuego estado) {
        for (Jugador jugador : this.jugadores){
            if ( (jugador.cantidadDeConstruccionesRealizadas() == 0) && (this.turnos >= 2) ) {
                return new Terminado();
            }
        }
        return estado;
    }

    public void agregarJugador(String nombreJugador, Raza razaJugador){
        //this.jugadores.add(new Jugador(nombreJugador, razaJugador));
    }
    public Mapa obtenerMapa(){
        return this.mapa;
    }
}
