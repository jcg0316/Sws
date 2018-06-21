package team3.swS.memJoin.main;

import java.net.URL;
import java.util.ResourceBundle;

import javax.mail.MessagingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import team3.swS.common.MailTest;
import team3.swS.memJoin.service.MemberJoinService;
import team3.swS.memJoin.vo.MemberJoinVo;
import team3.swS.common.RegCheck;


public class MemberJoinMainController {
	String au = null;
	boolean auok = false;
	
	public RegCheck reg = new RegCheck();
	public MailTest mt = new MailTest();
    
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtFID;

    @FXML
    private PasswordField txtFPW;

    @FXML
    private PasswordField txtFPWCon;

    @FXML
    private TextField txtFNName;

    @FXML
    private TextField txtFNumber;

    @FXML
    private TextField txtFEmail;

    @FXML
    private Button btnConfirmNumSend;

    @FXML
    private PasswordField txtFConfirmNum;

    @FXML
    private RadioButton radioEng;

    @FXML
    private ToggleGroup interestThing;

    @FXML
    private RadioButton radioToiec;
    

    @FXML
    private RadioButton radioCompany;

    @FXML
    private RadioButton radioComuny;

    @FXML
    private Button btnConfirmNumCheck;

    @FXML
    private Button btnOk;

    @FXML
    private Button btnCancel;

    @FXML
    void btnCancel(ActionEvent event) {
    	Stage bc = (Stage) btnCancel.getScene().getWindow();
    	bc.close();
    }

    @FXML
    void btnConfirmNumCheck(ActionEvent event) {
    	System.out.println(auok);
    	if (!(au.equals(txtFConfirmNum.getText()))) {
    		alert("인증번호가 맞지 않습니다.");
    		return;
    	}else {
    		info("인증 성공!");
    		auok = true;
    		System.out.println(auok);
    	}
    }

    @FXML
    void btnConfirmNumSend(ActionEvent event) {
    	MemberJoinVo mvo = new MemberJoinVo();
    	String email = txtFEmail.getText();
    	mvo.setMem_email(email);
    	
    	if(service.mailCheckMember(txtFEmail.getText()) == 1) {
    		alert("같은 이메일이 존재합니다.");
    		return;
		}
    	
    	int num = (int)(Math.random()*(899999+100000));
    	au = String.valueOf(num);
    	String from = "cksruddlek@gmail.com"; // 메일 보낸 사람
		String to = txtFEmail.getText(); // 메일 받는 사람
		String subject = "Thanks for signing up for swS";// 제목
		String content = "Your swS verification code is ["+ au +"]";// 내용
		
		if (from.trim().equals("")) {
			alert("보내는 사람을 입력하지 않았습니다.");
		} else if (to.trim().equals("")) {
			alert("이메일을 입력하지 않았습니다.");
		} else {
			try {
				// 메일보내기
				mt.sendEmail(from, to, subject, content);
				info("인증번호 발송이 완료 되었습니다.");
			} catch (MessagingException me) {
				alert("메일 전송에 실패하였습니다.");
			} catch (Exception e) {
				alert("메일 전송에 실패하였습니다.");
			}
		}
    	

    }

    @FXML
    void btnOk(ActionEvent event) {
    	String password = txtFPW.getText();
    	String nick = txtFNName.getText();
    	String email = txtFEmail.getText();
    	String telno = txtFNumber.getText();
    	String id = txtFID.getText();
    	String interrest = null;
    	
    	if(interestThing.getSelectedToggle() != null){
    		interrest = interestThing.getSelectedToggle().getUserData().toString();		
    	}
    	
    	if (txtFID.getText().isEmpty()) {
    		alert("아이디를 입력해주세요");
    		return;
    	}
    	
    	if (txtFPW.getText().isEmpty()) {
    		alert("비밀번호를 입력해주세요");
    		return;
		}
    	
    	if (txtFNName.getText().isEmpty()) {
    		alert("닉네임을 입력해주세요");
    		return;
    	}
    	
    	if (txtFEmail.getText().isEmpty()) {
    		alert("이메일을 입력해주세요");
    		return;
    	}
    	
    	if (txtFNumber.getText().isEmpty()) {
    		alert("전화번호를 입력해주세요");
    		return;
    	}
    	
    	if (txtFConfirmNum.getText().isEmpty()) {
    		alert("인증번호를 입력해주세요");
    		return;
    	}
    	
    	if (auok == false) {
    		alert("이메일 인증을 해주세요");
    		return;
    	}
    	
    	boolean idResult = reg.idRegex(id);
    	if(idResult == false) {
    		alert("아이디가 올바르지 않습니다.");
    		return;
    	}
    	
    	boolean pwResult = reg.passwordRegex(password);
    	if(pwResult == false) {
    		alert("비밀번호가 올바르지 않습니다.");
    		return;
    	}
    	
    	if(!(password.equals(txtFPWCon.getText()))) {
    		alert("재입력한 비밀번호가 일치하지 않습니다.");
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
    	
    	MemberJoinVo mvo = new MemberJoinVo();
    	mvo.setMem_password(password);
    	mvo.setMem_nick(nick);
    	mvo.setMem_email(email);
    	mvo.setMem_telno(telno);
    	mvo.setMem_id(id);
    	mvo.setMem_interrest(interrest);
    	
    	if(service.IdCheckMember(txtFID.getText()) == 0) {
			service.insertMember(mvo);
			boolean result = memList.add(mvo);
			if(result) {
				info("추가 성공!");
				Stage bc = (Stage) btnOk.getScene().getWindow();
				bc.close();
			}
		}else {
			alert("같은 아이디가 존재합니다.");
			return;
		}
    }

    @FXML
    void radioCompany(ActionEvent event) {

    }

    @FXML
    void radioComuny(ActionEvent event) {

    }

    @FXML
    void radioEng(ActionEvent event) {

    }

    @FXML
    void radioToiec(ActionEvent event) {

    }

    @FXML
    void txtFLevel(ActionEvent event) {

    }

    
    private MemberJoinService service;
    ObservableList<MemberJoinVo> memList = FXCollections.observableArrayList();
    
    
    @FXML
    void initialize() {
        assert txtFID != null : "fx:id=\"txtFID\" was not injected: check your FXML file 'Join.fxml'.";
        assert txtFPW != null : "fx:id=\"txtFPW\" was not injected: check your FXML file 'Join.fxml'.";
        assert txtFPWCon != null : "fx:id=\"txtFPWCon\" was not injected: check your FXML file 'Join.fxml'.";
        assert txtFNName != null : "fx:id=\"txtFNName\" was not injected: check your FXML file 'Join.fxml'.";
        assert txtFNumber != null : "fx:id=\"txtFNumber\" was not injected: check your FXML file 'Join.fxml'.";
        assert txtFEmail != null : "fx:id=\"txtFEmail\" was not injected: check your FXML file 'Join.fxml'.";
        assert btnConfirmNumSend != null : "fx:id=\"btnConfirmNumSend\" was not injected: check your FXML file 'Join.fxml'.";
        assert txtFConfirmNum != null : "fx:id=\"txtFConfirmNum\" was not injected: check your FXML file 'Join.fxml'.";
        assert radioEng != null : "fx:id=\"radioEng\" was not injected: check your FXML file 'Join.fxml'.";
        assert interestThing != null : "fx:id=\"interestThing\" was not injected: check your FXML file 'Join.fxml'.";
        assert radioToiec != null : "fx:id=\"radioToiec\" was not injected: check your FXML file 'Join.fxml'.";
        assert radioCompany != null : "fx:id=\"radioCompany\" was not injected: check your FXML file 'Join.fxml'.";
        assert radioComuny != null : "fx:id=\"radioComuny\" was not injected: check your FXML file 'Join.fxml'.";
        assert btnConfirmNumCheck != null : "fx:id=\"btnConfirmNumCheck\" was not injected: check your FXML file 'Join.fxml'.";
        assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'Join.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'Join.fxml'.";
        auok = false;
        
        service = MemberJoinService.getInstance();
        
        radioEng.setUserData("수능영어");
        radioToiec.setUserData("토익/토플");
        radioCompany.setUserData("직장영어");
        radioComuny.setUserData("영어회화");

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
