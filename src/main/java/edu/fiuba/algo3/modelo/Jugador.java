package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.razas.*;

public class Jugador {
    private String nombre ;
    private String color ;
    private Raza raza ;

    public Jugador(String nombre, String color , String raza) {

        if (nombre.length() < 6){
            throw new NombreInvalido();
        }

        this.nombre = nombre ;
        this.color = color ;

        if (raza.equals("Zerg")) {
            this.raza = new Zerg();
        } else if (raza.equals("Protoss")){
            this.raza = new Protoss() ;
        } else {
            throw new RazaInvalida() ;
        }
    }
}
