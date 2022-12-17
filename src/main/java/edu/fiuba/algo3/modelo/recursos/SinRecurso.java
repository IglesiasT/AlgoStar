package edu.fiuba.algo3.modelo.recursos;

public class SinRecurso extends Recurso{

    @Override
    public int recolectar(int recolector) {
        return 0;
    }

    @Override
    public void ocupar(){}
}
