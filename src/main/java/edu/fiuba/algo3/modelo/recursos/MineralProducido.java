package edu.fiuba.algo3.modelo.recursos;

import java.util.Objects;

public class MineralProducido {
    private int mineralProducido;

    public MineralProducido(int mineralProducido) {
        this.mineralProducido = mineralProducido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MineralProducido that = (MineralProducido) o;
        return mineralProducido == that.mineralProducido;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mineralProducido);
    }
}
