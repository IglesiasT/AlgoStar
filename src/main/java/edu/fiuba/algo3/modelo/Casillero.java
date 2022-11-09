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


    public void construirEdificioZerg(Construccion construccion){
        espacio.construirEdificioZerg(construccion,recurso);
    }
    public void construirEdificioProtoss(Construccion construccion){
        espacio.construirEdificioProtoss(construccion,recurso);
    }



    public void setEspacioDeConstruccion(EspacioDeConstruccion espacio){
        this.espacio = espacio;
    }

    public Recurso obtenerRecurso() {
        return this.recurso;
    }
}
