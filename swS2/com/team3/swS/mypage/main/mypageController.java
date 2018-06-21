package team3.swS.mypage.main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import team3.swS.common.RegCheck;
import team3.swS.common.Session;
import team3.swS.memJoin.vo.MemberJoinVo;
import team3.swS.mypage.service.MypageService;
import team3.swS.total.main.swMainMain;

public class mypageController {
	public RegCheck reg = new RegCheck();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton radioExam;

    @FXML
    private ToggleGroup interestThing;

    @FXML
    private RadioButton radioToiec;

    @FXML
    private RadioButton radioCompany;

    @FXML
    private RadioButton radioCommuny;

    @FXML
    private TextField txtFMileage;

    @FXML
    private Button btnMileageList;

    @FXML
    private TextField txtFEmail;

    @FXML
    private TextField txtFNumber;

    @FXML
    private TextField txtFNName;

    @FXML
    private TextField txtFPW;

    @FXML
    private TextField txtFID;

    @FXML
    private Button btnOk;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnGetout;

    @FXML
    void btnCancel(ActionEvent event) throws IOException {
    	
    	if(Session.memJoin.getMem_id().equals("admin") != true) {
    		Stage primaryStage = swMainMain.rootStage;
    		Parent root = FXMLLoader.load(getClass().getResource("../../total/view/LoginAfter.fxml"));
    		Scene scene = new Scene(root);
    		primaryStage.setTitle("afterMain");
    		primaryStage.setScene(scene);
    		primaryStage.show();
  	
    	} else if(Session.memJoin.getMem_id().equals("admin") != false) {
    		Stage primaryStage = swMainMain.rootStage;
    		Parent root = FXMLLoader.load(getClass().getResource("../../total/view/LoginAfterManage.fxml"));
    		Scene scene = new Scene(root);
    		primaryStage.setTitle("LoginAfterManage");
    		primaryStage.setScene(scene);
    		primaryStage.show();
    	}
    }

    @FXML
    void btnGetout(ActionEvent event) {
    	try {
    		Stage childStage = new Stage(StageStyle.UTILITY);
    		childStage.initModality(Modality.WINDOW_MODAL);
			childStage.initOwner(swMainMain.rootStage);
			childStage.setTitle("탈퇴");

			Parent childRoot = FXMLLoader.load(getClass().getResource("../view/getOut.fxml"));
			Scene scene = new Scene(childRoot);
			childStage.setScene(scene);
			childStage.show();
    		
		} catch (Exception e) {
			
		}
    }

    @FXML
    void btnMileageList(ActionEvent event) {
    	try {
    		
    		Stage childStage = new Stage(StageStyle.UTILITY);
    		childStage.initModality(Modality.WINDOW_MODAL);
			childStage.initOwner(swMainMain.rootStage);
			childStage.setTitle("내역");

			Parent childRoot = FXMLLoader.load(getClass().getResource("../view/buyList.fxml"));
			Scene scene = new Scene(childRoot);
			childStage.setScene(scene);
			childStage.show();
    		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
    }

    @FXML
    void btnOk(ActionEvent event) { 	
    	String interrest = interestThing.getSelectedToggle().getUserData().toString();
    	String password = txtFPW.getText();
    	String nick = txtFNName.getText();
    	String telno = txtFNumber.getText();
    	String email = txtFEmail.getText();
    	
    	if (txtFPW.getText().isEmpty()) {
    		alert("비밀번호를 입력해주세요");
    		return;
		}
    	
    	if (txtFNName.getText().isEmpty()) {
    		alert("닉네임을 입력해주세요");
    		return;
    	}
    	
    	if (txtFNumber.getText().isEmpty()) {
    		alert("전화번호를 입력해주세요");
    		return;
    	}
    	
    	if (txtFEmail.getText().isEmpty()) {
    		alert("이메일을 입력해주세요");
    		return;
    	}
    	
    	boolean pwResult = reg.passwordRegex(password);
    	if(pwResult == false) {
    		alert("비밀번호가 올바르지 않습니다.");
    		return;
    	}
    		
    	boolean nickResult = reg.nickRegex(nick);
    	if(nickResult == false) {
    		alert("닉네임이 올바르지 않습니다.");
    		return;
    	}
    	
    	boolean telResult = reg.telRegex(telno);
    	if(telResult == false) {
    		alert("전화번호가 올바르지 않습니다.");
    		return;
    	}
    	
    	boolean mailResult = reg.mailRegex(email);
    	if(mailResult == false) {
    		alert("이메일이 올바르지 않습니다.");
    		return;
    	}
    	
    	Session.memJoin.setMem_password(password);
    	Session.memJoin.setMem_nick(nick);
    	Session.memJoin.setMem_telno(telno);
    	Session.memJoin.setMem_email(email);
    	Session.memJoin.setMem_interrest(interrest);
    	
    	MemberJoinVo mvo = new MemberJoinVo();
    	mvo.setMem_id(Session.memJoin.getMem_id());
    	mvo.setMem_password(password);
    	mvo.setMem_nick(nick);
    	mvo.setMem_telno(telno);
    	mvo.setMem_email(email);
    	mvo.setMem_interrest(interrest);
    	
    	service.updateMember(mvo);
    	info(" 수정 되었습니다! ");
    }	

    @FXML
    void radioCommuny(ActionEvent event) {

    }

    @FXML
    void radioCompany(ActionEvent event) {

    }

    @FXML
    void radioExam(ActionEvent event) {

    }

    @FXML
    void radioToiec(ActionEvent event) {

    }

    @FXML
    void txtFEmail(ActionEvent event) {

    }

    @FXML
    void txtFID(ActionEvent event) {

    }

    @FXML
    void txtFMileage(ActionEvent event) {

    }

    @FXML
    void txtFNName(ActionEvent event) {

    }

    @FXML
    void txtFNumber(ActionEvent event) {

    }

    @FXML
    void txtFPW(ActionEvent event) {

    }
    
    private MypageService service;
    ObservableList<MemberJoinVo> memList = FXCollections.observableArrayList();
    
    @FXML
    void initialize() {
        assert radioExam != null : "fx:id=\"radioExam\" was not injected: check your FXML file 'mypageMain.fxml'.";
        assert interestThing != null : "fx:id=\"interestThing\" was not injected: check your FXML file 'mypageMain.fxml'.";
        assert radioToiec != null : "fx:id=\"radioToiec\" was not injected: check your FXML file 'mypageMain.fxml'.";
        assert radioCompany != null : "fx:id=\"radioCompany\" was not injected: check your FXML file 'mypageMain.fxml'.";
        assert radioCommuny != null : "fx:id=\"radioCommuny\" was not injected: check your FXML file 'mypageMain.fxml'.";
        assert txtFMileage != null : "fx:id=\"txtFMileage\" was not injected: check your FXML file 'mypageMain.fxml'.";
        assert btnMileageList != null : "fx:id=\"btnMileageList\" was not injected: check your FXML file 'mypageMain.fxml'.";
        assert txtFEmail != null : "fx:id=\"txtFEmail\" was not injected: check your FXML file 'mypageMain.fxml'.";
        assert txtFNumber != null : "fx:id=\"txtFNumber\" was not injected: check your FXML file 'mypageMain.fxml'.";
        assert txtFNName != null : "fx:id=\"txtFNName\" was not injected: check your FXML file 'mypageMain.fxml'.";
        assert txtFPW != null : "fx:id=\"txtFPW\" was not injected: check your FXML file 'mypageMain.fxml'.";
        assert txtFID != null : "fx:id=\"txtFID\" was not injected: check your FXML file 'mypageMain.fxml'.";
        assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'mypageMain.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'mypageMain.fxml'.";
        assert btnGetout != null : "fx:id=\"btnGetout\" was not injected: check your FXML file 'mypageMain.fxml'.";
        
        service = MypageService.getInstance();
        
        MemberJoinVo memVo = Session.memJoin; // 로그인한 세션값
        String id = Session.memJoin.getMem_id();
        String pw = Session.memJoin.getMem_password();
        String nick = Session.memJoin.getMem_nick();
        String tel = Session.memJoin.getMem_telno();
        String mail = Session.memJoin.getMem_email();
        String mile = Session.memJoin.getMem_mileage();
        String inter = Session.memJoin.getMem_interrest();
        
        txtFID.setText(id);
        txtFPW.setText(pw);
        txtFNName.setText(nick);
        txtFNumber.setText(tel);
        txtFEmail.setText(mail);
        txtFMileage.setText(mile);
        
        radioExam.setUserData("수능영어");
        radioToiec.setUserData("토익/토플");
        radioCompany.setUserData("직장영어");
        radioCommuny.setUserData("영어회화");
        
        if (radioExam.getText().equals(inter)) {
			radioExam.setSelected(true);
		} else if(radioToiec.getText().equals(inter)) {
			radioToiec.setSelected(true);
		} else if(radioCompany.getText().equals(inter)) {
			radioCompany.setSelected(true);
		} else {
			radioCommuny.setSelected(true);
		}
        
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
