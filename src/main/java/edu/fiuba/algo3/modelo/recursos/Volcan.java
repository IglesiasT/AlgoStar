package edu.fiuba.algo3.modelo.recursos;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Volcan extends Recurso{

    public Volcan(){
        super();
        setText("Δ");
        setFill(Color.RED);
        setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        this.cantidad = 5000;
    }
    public Volcan(int cantidad){
        super();
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        return this.getClass() == o.getClass();
    }
}
