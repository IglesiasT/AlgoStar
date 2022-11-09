package edu.fiuba.algo3.modelo;

public class Casillero {

    private Recurso recurso;
    private EspacioDeConstruccion espacio;

    public Casillero(Recurso recurso){
        this.recurso = recurso;
        this.espacio = new SinEspacio();
    }


    public void construirEdificioZerg(Construccion construccion){
        espacio.construirEdificioZerg(construccion,recurso);
    }

    public void setEspacioDeConstruccion(EspacioDeConstruccion espacio){
        this.espacio = espacio;
    }
}
