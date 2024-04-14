/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */




package com.mycompany.ex2;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;



/**
 * JavaFX App
 */
public class Ex2 extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Circle c1 = new Circle(50);
        c1.setCenterX(150);
        c1.setCenterY(80);
        c1.setStroke(Color.BLACK);
        c1.setStrokeWidth(3);
        c1.setVisible(false);
        Rectangle rec = new Rectangle(100, 80, 80, 80);
        rec.setStroke(Color.BLACK);

        Ellipse ellipse = new Ellipse();
        ellipse.setCenterX(150.0f);
        ellipse.setCenterY(80.0f);
        ellipse.setRadiusX(50.0f);
        ellipse.setRadiusY(25.0f);
        ellipse.setVisible(false);
        ellipse.setStroke(Color.BLACK);
        Pane p = new Pane();
        p.getChildren().addAll(c1, rec, ellipse);
        RadioButton r1 = new RadioButton("Circle");
        RadioButton r2 = new RadioButton("Square");
        RadioButton r3 = new RadioButton("Elipse");
        CheckBox chfill = new CheckBox("Fill ");
        r2.setSelected(true);
        HBox forRadio = new HBox(20);
        forRadio.getChildren().addAll(r1, r2, r3, chfill);
        forRadio.setAlignment(Pos.CENTER);
        chfill.setSelected(true);
        ToggleGroup radio = new ToggleGroup();
        r1.setToggleGroup(radio);
        r2.setToggleGroup(radio);
        r3.setToggleGroup(radio);

        VBox root = new VBox(20);
        root.getChildren().addAll(p, forRadio);

        r1.setOnAction(e -> {
            c1.setVisible(true);
            ellipse.setVisible(false);
            rec.setVisible(false);
        });

        r2.setOnAction(e -> {
            c1.setVisible(false);
            ellipse.setVisible(false);
            rec.setVisible(true);
        });
        r3.setOnAction(e -> {
            c1.setVisible(false);
            ellipse.setVisible(true);
            rec.setVisible(false);
        });

        chfill.setOnAction(e -> {
            if (chfill.isSelected()) {
                c1.setFill(Color.BLACK);
                rec.setFill(Color.BLACK);
                ellipse.setFill(Color.BLACK);
            } else {
                c1.setFill(Color.TRANSPARENT);
                rec.setFill(Color.TRANSPARENT);
                ellipse.setFill(Color.TRANSPARENT);
            }

        });

        Scene scene = new Scene(root, 300, 200);

        stage.setTitle("Lab4");
        stage.setScene(scene);
        stage.show();

    }



    public static void main(String[] args) {
        launch();
    }

}