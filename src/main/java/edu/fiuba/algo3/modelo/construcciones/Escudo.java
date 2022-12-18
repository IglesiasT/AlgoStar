package edu.fiuba.algo3.modelo.construcciones;

public class Escudo {
    private final int regeneracionPorTurno;

    private final int vidaMaxima;
    private int vida;
    private int danioNoMitigado;

    public Escudo(int vida){
        this.regeneracionPorTurno = 10;
        this.vidaMaxima = vida;
        this.vida = vida;
        this.danioNoMitigado = 0;
    }

    public void regenerar(){
        if(this.vida < vidaMaxima ) {
            this.vida += this.regeneracionPorTurno;
        }
    }

    public void recibirDanio(int danioInflingido){
        this.vida -= danioInflingido;
        if (this.vida < 0){
            this.danioNoMitigado = (this.vida * -1);
            this.vida = 0;
        }
    }

    public int obtenerDanioNoMitigado(){
        return this.danioNoMitigado;
    }
    public int obtenerVida(){
        return this.vida;
    }
}
