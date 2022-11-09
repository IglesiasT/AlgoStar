package edu.fiuba.algo3.modelo;

public class Gas extends Recurso{

    private int cantidad;

    @Override
    public void construirEdificio(Construccion construccion) {
        construccion.esGeneradorDeGas();

    }

}
