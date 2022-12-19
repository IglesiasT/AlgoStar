package edu.fiuba.algo3.modelo.construcciones;

public class Escudo {
    private final int regeneracionPorTurno;

    private final int vidaMaxima;

    private int vida;
    public Escudo(int vida){
        this.regeneracionPorTurno = 10;
        this.vidaMaxima = vida;
        this.vida = vida;
    }
    public void regenerar(){
        if(this.vida < vidaMaxima ) {
            this.vida += this.regeneracionPorTurno;
        }
    }

    public int recibirDanio(int danioInflingido){
        int danioNoMitigado = 0;
        this.vida -= danioInflingido;
        if (this.vida < 0){
            danioNoMitigado = (this.vida * -1);
            this.vida = 0;
        }

        return danioNoMitigado;
    }

    public int obtenerVida(){
        return this.vida;
    }
}
