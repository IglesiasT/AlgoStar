package edu.fiuba.algo3.modelo;

public class Moho extends EspacioDeConstruccion{

    @Override
    public void construirEdificioZerg(Construccion construccion, Recurso recurso){
        recurso.construirEdificio(construccion);
    }

    @Override
    public void construirEdificioProtoss(Construccion construccion, Recurso recurso) throws NoSePuedeConstruir{
        throw new NoSePuedeConstruir();
    }
}
