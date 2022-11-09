package edu.fiuba.algo3.modelo;

public class Gas extends Recurso{

    @Override
    public void construirEdificio(Construccion construccion) {
        construccion.esGeneradorDeGas();
        this.cantidad = 5000;
    }

    @Override
    public int recolectar(String recolector) {
        return 0;
    }

}
