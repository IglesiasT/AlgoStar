package edu.fiuba.algo3.controlador;

import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import java.util.List;

public class SeleccionUnidadesEventHandler implements EventHandler<MouseEvent> {
    private List<MenuItem> menuItems;
    private ContextMenu menu;
    public SeleccionUnidadesEventHandler(List<MenuItem> menuItems){
        this.menuItems = menuItems;
        this.menu = new ContextMenu();
        for(MenuItem item: this.menuItems){
            menu.getItems().add(item);
        }
    }
    @Override
    public void handle(MouseEvent mouseEvent) {
        AudioClip audio = new AudioClip(this.getClass().getResource("confirmacion.wav").toString());
        audio.play();
        menu.show((Node)mouseEvent.getSource(), Side.RIGHT, 5, 5);
        mouseEvent.consume();
    }
}
