package team3.swS.managePage.main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ManageBoardController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox vboxBoard;

    @FXML
    private Button btnMemManage;

    @FXML
    private Button btnBuyManage;

    @FXML
    private Button btnProductManage;

    @FXML
    void btnBuyManage(ActionEvent event) {
    	try {
    		Parent subRoot = FXMLLoader.load(getClass().getResource("../../setlManage/view/buyManage.fxml"));
    		vboxBoard.getChildren().clear();
    		vboxBoard.getChildren().add(subRoot);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnMemManage(ActionEvent event) {
    	try {
    		Parent subRoot = FXMLLoader.load(getClass().getResource("../../memManagement/view/memberManage.fxml"));
    		vboxBoard.getChildren().clear();
    		vboxBoard.getChildren().add(subRoot);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnProductManage(ActionEvent event) {
    	try {
    		Parent subRoot = FXMLLoader.load(getClass().getResource("../../productManage/view/productManage.fxml"));
    		vboxBoard.getChildren().clear();
    		vboxBoard.getChildren().add(subRoot);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
        assert vboxBoard != null : "fx:id=\"vboxBoard\" was not injected: check your FXML file 'manageBoard.fxml'.";
        assert btnMemManage != null : "fx:id=\"btnMemManage\" was not injected: check your FXML file 'manageBoard.fxml'.";
        assert btnBuyManage != null : "fx:id=\"btnBuyManage\" was not injected: check your FXML file 'manageBoard.fxml'.";
        assert btnProductManage != null : "fx:id=\"btnProductManage\" was not injected: check your FXML file 'manageBoard.fxml'.";

    }
}
