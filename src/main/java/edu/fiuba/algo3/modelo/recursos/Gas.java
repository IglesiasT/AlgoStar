package edu.fiuba.algo3.modelo.recursos;

import java.util.List;
import java.util.Objects;

public class Gas extends RecursoObtenido {

    public Gas(int cantidad) {
        super(cantidad);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gas that = (Gas) o;
        return cantidad == that.cantidad;
    }
}
