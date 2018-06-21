package team3.swS.pwSearch.main;

import java.net.URL;
import java.util.ResourceBundle;

import javax.mail.MessagingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import team3.swS.common.MailTest;
import team3.swS.idSearch.service.IdSearchService;
import team3.swS.memJoin.vo.MemberJoinVo;
import team3.swS.pwSearch.service.PwSearchService;

public class PwSearchController {
	public MailTest mt = new MailTest();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtFID;

    @FXML
    private TextField txtFPW;
    
    @FXML
    private Button btnSearch;

    @FXML
    private Button btnCancel;

    @FXML
    void btnCancel(ActionEvent event) {
    	Stage bc = (Stage) btnCancel.getScene().getWindow();
    	bc.close();
    }

    @FXML
    void btnSearch(ActionEvent event) {
    	MemberJoinVo mvo = new MemberJoinVo();
    	mvo.setMem_id(txtFID.getText());
    	mvo.setMem_email(txtFPW.getText());
    	MemberJoinVo searchIdMail = service.getIdMailSearchData(mvo);
    	
    	String from = "cksruddlek@gmail.com"; // 메일 보낸 사람
		String to = txtFPW.getText(); // 메일 받는 사람
		String subject = "This is your Account information.";// 제목
		String content = "Your PW is ["+ searchIdMail.getMem_password() +"]";// 내용
		
		if (from.trim().equals("")) {
			alert("보내는 사람을 입력하지 않았습니다.");
		} else if (to.trim().equals("")) {
			alert("이메일을 입력하지 않았습니다.");
		} else {
			try {
				// 메일보내기
				mt.sendEmail(from, to, subject, content);
				info("계정정보가 가입하신 이메일로 발송 되었습니다.");
			} catch (MessagingException me) {
				alert("메일 전송에 실패하였습니다.");
			} catch (Exception e) {
				alert("메일 전송에 실패하였습니다.");
			}
		}
    	
    	Stage bc = (Stage) btnCancel.getScene().getWindow();
    	bc.close();
    }

    @FXML
    void txtFID(ActionEvent event) {

    }

    @FXML
    void txtFPW(ActionEvent event) {

    }
    
    private PwSearchService service;
    ObservableList<MemberJoinVo> memList = FXCollections.observableArrayList();
    
    @FXML
    void initialize() {
        assert txtFID != null : "fx:id=\"txtFID\" was not injected: check your FXML file 'SearchPW.fxml'.";
        assert txtFPW != null : "fx:id=\"txtFPW\" was not injected: check your FXML file 'SearchPW.fxml'.";
        assert btnSearch != null : "fx:id=\"btnSearch\" was not injected: check your FXML file 'SearchPW.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'SearchPW.fxml'.";
        
        service = PwSearchService.getInstance(); 
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
