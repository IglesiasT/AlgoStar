package edu.fiuba.algo3.modelo.construcciones;

public abstract class ConstruccionZerg extends Construccion{

    public ConstruccionZerg(){
        super();
    }
    @Override
    public void recibirDanio(int danioInflingido) {
        this.vida -= danioInflingido;
        if (this.vida <= 0){
            //this.ubicacion.destruirConstruccion();
            destruir();
        }
    }

    @Override
    protected void regenerar() {
        if (this.vida < this.vidaMaxima){
            this.vida += 5;
        }
    }
}
