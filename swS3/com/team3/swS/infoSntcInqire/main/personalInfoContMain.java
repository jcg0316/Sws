package team3.swS.infoSntcInqire.main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class personalInfoContMain extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(
					getClass().getResource("../view/personalInfoCont.fxml"));
			
			Scene scene = new Scene(root);
			primaryStage.setTitle("개인정보이용");
			primaryStage.setScene(scene);
			primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
