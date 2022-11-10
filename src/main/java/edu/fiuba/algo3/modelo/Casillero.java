package edu.fiuba.algo3.modelo;

public class Casillero {

    private Recurso recurso;
    private EspacioDeConstruccion espacio;
    private Construccion construccion;

    public Casillero(){
        this.recurso = new SinRecurso();
        this.espacio = new SinEspacio();
        this.construccion = null;
    }
    public Casillero(Recurso recurso){
        this.recurso = recurso;
        this.espacio = new SinEspacio();
        this.construccion = null;
    }

    public void expandir(EspacioDeConstruccion espacioAExpandir){

    }

    public void setEspacioDeConstruccion(EspacioDeConstruccion espacio){
        this.espacio = espacio;
    }
    public void establecerConstruccion(Construccion construccionAEstablecer){
        if (this.construccion != null ){
            throw new NoSePuedeConstruir();
        }
        this.construccion = construccionAEstablecer;
    }

    public void destruirConstruccion(){
        this.construccion = null;
    }

    public Recurso obtenerRecurso() {
        return this.recurso;
    }

    public boolean contiene (Recurso recurso){
        return (this.recurso.getClass() == recurso.getClass());
    }
    public boolean contiene (EspacioDeConstruccion espacio){
        return (this.espacio.getClass() == espacio.getClass());
    }
}
