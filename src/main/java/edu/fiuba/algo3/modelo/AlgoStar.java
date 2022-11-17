package edu.fiuba.algo3.modelo;

import java.util.LinkedList;

import edu.fiuba.algo3.modelo.jugador.DatosRepetidos;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.*;
import java.util.Scanner;

public class AlgoStar {
    private LinkedList <Jugador> jugadores;
    private Mapa mapa ;

    public AlgoStar (){
        this.jugadores = new LinkedList<>();
        this.mapa = new Mapa();
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
        jugadores.add ( new Jugador (DatosJugadorDos[0], DatosJugadorDos[1], DatosJugadorDos[2]) ) ;
    }

}
