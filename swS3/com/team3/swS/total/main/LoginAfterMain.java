package team3.swS.total.main;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginAfterMain extends Application {

	// define your offsets here
	private double xOffset = 0;
	private double yOffset = 0;

	public static Stage rootStage;


	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("../view/LoginAfter.fxml"));
		
		primaryStage.initStyle(StageStyle.UNDECORATED);
		
		// grab your root here
		root.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				xOffset = event.getSceneX();
				yOffset = event.getSceneY();
			}
		});

		// move around here
		root.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				primaryStage.setX(event.getScreenX() - xOffset);
				primaryStage.setY(event.getScreenY() - yOffset);
			}
		});

		Scene scene = new Scene(root);
		primaryStage.setTitle("Main");
		primaryStage.setScene(scene);
		scene.getStylesheets().add(getClass().getResource("label.css").toExternalForm());
//		scene.getStylesheets().add("label.css");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
