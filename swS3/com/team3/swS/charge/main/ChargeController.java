package team3.swS.charge.main;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import team3.swS.charge.service.ChargeService;
import team3.swS.charge.vo.ChargeVO;
import team3.swS.common.Session;
import team3.swS.memJoin.vo.MemberJoinVo;

public class ChargeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtFSender;

    @FXML
    private TextField txtFBank;

    @FXML
    private Button btnChargeOper;

    @FXML
    private Button btnCancel;

    @FXML
    private RadioButton radio5M;

    @FXML
    private ToggleGroup mileage;

    @FXML
    private RadioButton radio10M;

    @FXML
    private RadioButton radio30M;

    @FXML
    private RadioButton radio50M;

    @FXML
    private RadioButton radio100M;

    @FXML
    private RadioButton radio300M;

    @FXML
    private TextArea txtABank;

    @FXML
    void btnCancel(ActionEvent event) {
    	txtFSender.clear();
    	txtFBank.clear();
    }

    @FXML
    void btnChargeOper(ActionEvent event) {
    	
		String member=Session.memJoin.getMem_no();
		ChargeVO chargeVo=new ChargeVO();
//		ChargeVO addToMem_update = null ;
		String mile = mileage.getSelectedToggle().getUserData().toString();
		System.out.println("mile 찍히나 확인 " + mile);
		//송금자번호는.....
		chargeVo.setCmile_remit_name(txtFSender.getText());
		chargeVo.setCmile_remit_bank(txtFBank.getText());
		chargeVo.setCmile_amount(mile);
		chargeVo.setCmile_order_no(chargeVo.getCmile_order_no());
		chargeVo.setCmile_appro("미승인");
		chargeVo.setCmile_date(chargeVo.getCmile_date());
		chargeVo.setCmile_mem_no(member);
		String cv=null;
		try {              
			cv = service.insertCharge(chargeVo);
		} catch (Exception e) {
			System.out.println("cv 이쪽 실패");
			e.printStackTrace();
		}
		if(cv!=null) {
			alert("충전신청성공");
		}else {
			alert("충전신청실패");
		}
		
		
		
//		int num = mileageTot + Integer.parseInt(mile);
//		
//		String addMile = String.valueOf(num);
//		
//		memVo.setMem_mileage(addMile);
//		memVo.setMem_no(memVo.getMem_no());
//		
		
    }

    @FXML
    void radio100M(ActionEvent event) {

    }

    @FXML
    void radio10M(ActionEvent event) {

    }

    @FXML
    void radio300M(ActionEvent event) {

    }

    @FXML
    void radio30M(ActionEvent event) {

    }

    @FXML
    void radio50M(ActionEvent event) {

    }

    @FXML
    void radio5M(ActionEvent event) {

    }

    @FXML
    void txtFBank(ActionEvent event) {

    }

    @FXML
    void txtFSender(ActionEvent event) {

    }

    private ChargeService service;
    
    ObservableList<ChargeVO> chargeList = FXCollections.observableArrayList();
    @FXML
    void initialize() {
        assert txtFSender != null : "fx:id=\"txtFSender\" was not injected: check your FXML file 'chargeMain.fxml'.";
        assert txtFBank != null : "fx:id=\"txtFBank\" was not injected: check your FXML file 'chargeMain.fxml'.";
        assert btnChargeOper != null : "fx:id=\"btnChargeOper\" was not injected: check your FXML file 'chargeMain.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'chargeMain.fxml'.";
        assert radio5M != null : "fx:id=\"radio5M\" was not injected: check your FXML file 'chargeMain.fxml'.";
        assert mileage != null : "fx:id=\"mileage\" was not injected: check your FXML file 'chargeMain.fxml'.";
        assert radio10M != null : "fx:id=\"radio10M\" was not injected: check your FXML file 'chargeMain.fxml'.";
        assert radio30M != null : "fx:id=\"radio30M\" was not injected: check your FXML file 'chargeMain.fxml'.";
        assert radio50M != null : "fx:id=\"radio50M\" was not injected: check your FXML file 'chargeMain.fxml'.";
        assert radio100M != null : "fx:id=\"radio100M\" was not injected: check your FXML file 'chargeMain.fxml'.";
        assert radio300M != null : "fx:id=\"radio300M\" was not injected: check your FXML file 'chargeMain.fxml'.";
        assert txtABank != null : "fx:id=\"txtABank\" was not injected: check your FXML file 'chargeMain.fxml'.";

        service = ChargeService.getInstance();
        
//        mileageTot = Integer.parseInt(Session.memJoin.getMem_mileage());
        radio5M.setUserData("5000");
        radio10M.setUserData("10000");
        radio30M.setUserData("30000");
        radio50M.setUserData("50000");
        radio100M.setUserData("100000");
        radio300M.setUserData("300000");
        
        
//        List<ChargeVO> cv = service.getAllCharge();
//        chargeList.clear();
//        chargeList.addAll(cv);
        
    }
    public void alert(String msg) {
    	
    	Alert alertInformation = new Alert(AlertType.INFORMATION);
    	alertInformation.setTitle("충전");
    	alertInformation.setHeaderText("충전신청");
    	alertInformation.setContentText("충전신청을 완료했습니다.");
    	alertInformation.showAndWait();
    }
}
