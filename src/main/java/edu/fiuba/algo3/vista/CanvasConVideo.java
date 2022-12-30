package edu.fiuba.algo3.vista;

import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.util.Objects;

public class CanvasConVideo {

    Pane canvas;

    public CanvasConVideo(String videoPath){
        MediaView view = new MediaView();
        Media video = new Media(Objects.requireNonNull(getClass().getResource(videoPath)).toExternalForm());
        MediaPlayer player = new MediaPlayer(video);
        view.setMediaPlayer(player);
        player.setAutoPlay(true);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.play();

        this.canvas = new Pane() ;
        this.canvas.getChildren().addAll(view);
    }

    public Pane obtenerCanvas(){
        return canvas;
    }
}
