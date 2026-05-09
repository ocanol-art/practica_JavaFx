package com.practica.productos.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Label label = new Label("Hola JavaFX");

        VBox layout = new VBox(label);

        Scene scene = new Scene(layout, 300, 200);

        stage.setScene(scene);
        stage.setTitle("CRUD Productos");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}