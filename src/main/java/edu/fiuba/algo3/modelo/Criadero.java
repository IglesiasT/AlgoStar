package edu.fiuba.algo3.modelo;

public class Criadero extends Construccion{

    private int maximoDeLarvas;
    private int larvas;
    private int turnos;

    public Criadero (){
        this.maximoDeLarvas = 3;
        this.larvas = this.maximoDeLarvas;
        this.turnos = 0;
        this.turnosParaConstruirse = 4;
    }
    public int larvasRestantes() {
        return this.larvas;
    }

    public Zangano engendrarZangano() throws EdificioNoEstaOperativo {
        if (turnos < this.turnosParaConstruirse){
            throw new EdificioNoEstaOperativo();
        }
        this.larvas--;
        return new Zangano();
    }

    public void nuevoTurno(){
        this.turnos++;
        if (this.larvas < this.maximoDeLarvas){
            this.larvas++ ;
        }
    }
}
