package team3.swS.cuscen.main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import team3.swS.common.Session;

public class CustomMainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox vboxBoard;

    @FXML
    private Button btnNotice;

    @FXML
    private Button btnQA;

    @FXML
    private Button btnHelp;

    @FXML
    void btnHelp(ActionEvent event) {
    	try {
    		Parent subRoot = FXMLLoader.load(getClass().getResource("../../board/view/Help.fxml"));
    		vboxBoard.getChildren().clear();
    		vboxBoard.getChildren().add(subRoot);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnNotice(ActionEvent event) {
    	try {
    		Parent subRoot = FXMLLoader.load(getClass().getResource("../../board/view/notice.fxml"));
    		vboxBoard.getChildren().clear();
    		vboxBoard.getChildren().add(subRoot);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnQA(ActionEvent event) {
    	if(Session.memJoin == null) {
    		alert("로그인을 하고 실행해 주세요.");
    		return;
    	}
    	try {
    		Parent subRoot = FXMLLoader.load(getClass().getResource("../../board/view/QA.fxml"));
    		vboxBoard.getChildren().clear();
    		vboxBoard.getChildren().add(subRoot);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
        assert vboxBoard != null : "fx:id=\"vboxBoard\" was not injected: check your FXML file 'costomBoard.fxml'.";
        assert btnNotice != null : "fx:id=\"btnNotice\" was not injected: check your FXML file 'costomBoard.fxml'.";
        assert btnQA != null : "fx:id=\"btnQA\" was not injected: check your FXML file 'costomBoard.fxml'.";
        assert btnHelp != null : "fx:id=\"btnHelp\" was not injected: check your FXML file 'costomBoard.fxml'.";

    }
    
 // alert
    public void alert(String msg) {
    	Alert alertWarning = new Alert(AlertType.WARNING);
    	alertWarning.setTitle("경고");
    	alertWarning.setContentText(msg);
    	alertWarning.showAndWait();
    }
    
    // info
    public void info(String msg) {
    	Alert alertInfo = new Alert(AlertType.INFORMATION);
    	alertInfo.setTitle("확인");
    	alertInfo.setContentText(msg);
    	alertInfo.showAndWait();
    }
}
