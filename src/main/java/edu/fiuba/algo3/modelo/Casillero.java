package edu.fiuba.algo3.modelo;

public class Casillero {

    private Recurso recurso;
    private EspacioDeConstruccion espacio;

    public Casillero(){
        this.recurso = new SinRecurso();
        this.espacio = new SinEspacio();
    }
    public Casillero(Recurso recurso){
        this.recurso = recurso;
        this.espacio = new SinEspacio();
    }

    public void expandir(EspacioDeConstruccion espacioAExpandir){

    }

    public void setEspacioDeConstruccion(EspacioDeConstruccion espacio){
        this.espacio = espacio;
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
