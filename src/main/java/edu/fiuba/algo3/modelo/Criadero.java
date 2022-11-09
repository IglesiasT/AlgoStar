package edu.fiuba.algo3.modelo;

public class Criadero extends Construccion{

    private int larvas;
    private int turnos;

    public Criadero (){
        this.larvas = 3;
        this.turnos = 0;
    }
    public int larvasRestantes() {
        return this.larvas;
    }

    public Zangano engendrarZangano() throws EdificioNoEstaOperativo {
        if (turnos < 4){
            throw new EdificioNoEstaOperativo();
        }
        this.larvas--;
        return new Zangano();
    }

    public void nuevoTurno(){
        this.turnos++;
        if (this.larvas <3){
            this.larvas++ ;
        }
    }
}
