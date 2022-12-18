package edu.fiuba.algo3.modelo.estados;

public class EnConstruccion implements Estado {


    @Override
    public void jugar() {
        throw new EdificioNoEstaOperativo();
    }
}
