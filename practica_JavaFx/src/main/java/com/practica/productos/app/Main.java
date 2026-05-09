package com.practica.productos.app;

import com.practica.productos.modelo.Producto;
import com.practica.productos.servicio.ProductoService;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    ProductoService servicio = new ProductoService();

    @Override
    public void start(Stage stage) {

        TextField campo = new TextField();

        TextArea area = new TextArea();
        area.setEditable(false);

        Button boton = new Button("Agregar");
        Button eliminar = new Button("Eliminar");
        Button buscar = new Button("Buscar");

        // AGREGAR
        boton.setOnAction(e -> {

            try {

                servicio.agregar(new Producto(campo.getText()));

                String texto = "";

                for (Producto p : servicio.listar()) {

                    texto += p.getNombre() + "\n";
                }

                area.setText(texto);

            } catch (Exception ex) {

                area.setText(ex.getMessage());
            }
        });

        // ELIMINAR
        eliminar.setOnAction(e -> {

            servicio.eliminar(campo.getText());

            String texto = "";

            for (Producto p : servicio.listar()) {

                texto += p.getNombre() + "\n";
            }

            area.setText(texto);
        });

        // BUSCAR
        buscar.setOnAction(e -> {

            Producto p = servicio.buscar(campo.getText());

            if (p != null) {

                area.setText("Encontrado: " + p.getNombre());

            } else {

                area.setText("Producto no encontrado");
            }
        });

        VBox layout = new VBox(10, campo, boton, eliminar, buscar, area);

        Scene scene = new Scene(layout, 400, 300);

        stage.setScene(scene);
        stage.setTitle("CRUD Productos");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}