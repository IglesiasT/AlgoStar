package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class Mineral extends Recurso{
    private HashMap mineralPorRecolector = new HashMap<String, Integer>();

    public Mineral(){
        this.cantidad = 2000;
        this.mineralPorRecolector.put("Zangano", 10);
        this.mineralPorRecolector.put("NexoMineral", 20);
    }

    public Mineral(int cantidad){
        this.cantidad = cantidad;
        this.mineralPorRecolector.put("Zangano", 10);
        this.mineralPorRecolector.put("NexoMineral", 20);
    }

    public int recolectar(String recolector){
        if (! mineralPorRecolector.containsKey(recolector)){
            return 0;
        }
        int cantidadRecolectada = (int) mineralPorRecolector.get(recolector);
        this.cantidad -= cantidadRecolectada;
        return cantidadRecolectada;
    }
}
