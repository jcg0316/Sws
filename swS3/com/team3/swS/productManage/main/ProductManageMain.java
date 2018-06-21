package team3.swS.productManage.main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProductManageMain extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/productManage.fxml"));
		Parent root = loader.load();
		
		ProductManageController proManaController = loader.getController();
		proManaController.setPrimaryStage(primaryStage);
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("ProductManage");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
