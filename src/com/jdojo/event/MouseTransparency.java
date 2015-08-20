// MouseTransparency.java
package com.jdojo.event;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MouseTransparency extends Application {
	private CheckBox mouseTransparentCbx = new CheckBox("Mouse Transparent");
	Circle circle = new Circle(50, 50, 50, Color.LIGHTGRAY);

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		Rectangle rect = new Rectangle(100, 100);
		rect.setFill(Color.RED);

		Group group = new Group();
		group.getChildren().addAll(rect, circle);
		
		HBox root = new HBox();
		root.setPadding(new Insets(20));
		root.setSpacing(20);
		root.getChildren().addAll(group, mouseTransparentCbx);

		// Add MOUSE_CLICKED event handlers to the circle and rectangle
		circle.setOnMouseClicked(e -> handleMouseClicked(e));
		rect.setOnMouseClicked(e -> handleMouseClicked(e));

		// Add an Action handler to the checkbox
		mouseTransparentCbx.setOnAction(e -> handleActionEvent(e));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Mouse Transparency");
		stage.show();
	}

	public void handleMouseClicked(MouseEvent e) {
		String target = e.getTarget().getClass().getSimpleName();
		String type = e.getEventType().getName();
		System.out.println(type + " on " + target);
	}

	public void handleActionEvent(ActionEvent e) {
		if (mouseTransparentCbx.isSelected()) {
			circle.setMouseTransparent(true);
		} else {
			circle.setMouseTransparent(false);
		}
	}
} 
