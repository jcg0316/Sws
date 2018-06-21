package team3.swS.mypage.main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import team3.swS.common.Session;
import team3.swS.memJoin.vo.MemberJoinVo;
import team3.swS.mypage.service.MypageService;

public class GetoutController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField passFPW;

    @FXML
    private Button btnOk;
    
    @FXML
    private Button btnCancel;

    @FXML
    void btnCancel(ActionEvent event) {
    	passFPW.clear();
    	Stage bc = (Stage) btnCancel.getScene().getWindow();
 	    bc.close();
    }
    
    @FXML
    void btnOk(ActionEvent event) {
    	String pw =Session.memJoin.getMem_password(); 
    	if (pw.equals(passFPW.getText())) {
    		try {
    			service.deleteMember(pw);	
    			info("탈퇴하였습니다.");
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	
    	Stage bc = (Stage) btnCancel.getScene().getWindow();
 	    bc.close();
    }

    @FXML
    void passFPW(ActionEvent event) {

    }
    
    private MypageService service;
    ObservableList<MemberJoinVo> memList = FXCollections.observableArrayList();
    
    @FXML
    void initialize() {
        assert passFPW != null : "fx:id=\"passFPW\" was not injected: check your FXML file 'getOut.fxml'.";
        assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'getOut.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'getOut.fxml'.";
        
        service = MypageService.getInstance();
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
