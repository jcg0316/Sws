package team3.swS.memManagement.main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import team3.swS.common.Session;
import team3.swS.memJoin.vo.MemberJoinVo;
import team3.swS.memManagement.service.MemManageService;

public class MemAddController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtMile;

    @FXML
    private Button btnAdd;

    @FXML
    void btnAdd(ActionEvent event) {
    	MemberJoinVo member = Session.mileage;
    	String mileage = null;
    	String mvo = Session.mileage.getMem_mileage();
//    	String memNo = Session.mileage.getMem_no();
    	mileage=txtMile.getText();
    	int result=Integer.parseInt(mvo)+Integer.parseInt(mileage);
    	String plusStr=""+result;
    	System.out.println("----------------"+plusStr);
    	Session.mileage.setMem_mileage(plusStr);
    	if(plusStr.isEmpty()) {
    		alert("가격을 입력해주세요");
    		return;
    	}
    	String cnt=service.updateMemMile(member);
    	if(cnt!=null) {
    		info("지급성공");
    	}else {
    		info("지급실패");
    	}
    	Stage bc = (Stage) btnAdd.getScene().getWindow();
 	    bc.close();
 	    mac.refresh();
    }

    private MemManageService service;
    ObservableList<MemberJoinVo> memList = FXCollections.observableArrayList();

	private memManageController mac;
    @FXML
    void initialize() {
        assert txtMile != null : "fx:id=\"txtMile\" was not injected: check your FXML file 'memberAddMileage.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'memberAddMileage.fxml'.";
        
        service=MemManageService.getInstance();
    }
    public void alert(String msg) {
    	Alert alertWarning = new Alert(AlertType.WARNING);
    	alertWarning.setTitle("경고");
    	alertWarning.setContentText(msg);
    	alertWarning.showAndWait();
    }
    public void info(String msg) {
    	Alert alertInfo = new Alert(AlertType.INFORMATION);
    	alertInfo.setTitle("확인");
    	alertInfo.setContentText(msg);
    	alertInfo.showAndWait();
    }
	public void getMainControll(memManageController controller) {
		this.mac =controller;
	}
}
