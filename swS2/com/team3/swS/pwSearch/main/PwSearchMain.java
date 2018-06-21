package team3.swS.pwSearch.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import team3.swS.total.main.swMainMain;

public class PwSearchMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("../view/SearchPW.fxml"));
		Scene scene = new Scene(root);
		primaryStage.initModality(Modality.WINDOW_MODAL);
		primaryStage.initOwner(swMainMain.rootStage);
		primaryStage.setTitle("pwSearch");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
