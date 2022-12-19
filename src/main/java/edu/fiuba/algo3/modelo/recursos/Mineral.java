package edu.fiuba.algo3.modelo.recursos;

import java.util.Objects;

public class Mineral extends RecursoObtenido {

    public Mineral(int cantidad) {
        super(cantidad);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mineral that = (Mineral) o;
        return cantidad == that.cantidad;
    }
}
