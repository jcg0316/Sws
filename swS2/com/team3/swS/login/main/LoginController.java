package team3.swS.login.main;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import team3.swS.common.Session;
import team3.swS.login.service.LoginService;
import team3.swS.memJoin.vo.MemberJoinVo;
import team3.swS.total.main.swMainMain;

public class LoginController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtFID;

	@FXML
	private PasswordField txtFPW;

	@FXML
	private Button btnOk;

	@FXML
	private Button btnCancel;

	@FXML
	void btnCancel(ActionEvent event) {
		Stage bc = (Stage) btnCancel.getScene().getWindow();
		bc.close();
	}

	// @FXML
	// void setOnKeyPressed(KeyEvent event) {
	//
	// }
	//

	@FXML
	void btnOk(ActionEvent event) throws IOException {
		try {
			MemberJoinVo mvo = new MemberJoinVo();
			mvo.setMem_id(txtFID.getText());
			mvo.setMem_password(txtFPW.getText());
			MemberJoinVo logdata = service.getLoginData(mvo);
			if (logdata != null && logdata.getMem_id().equals("admin") != true && logdata.getMem_stop().equals("N")) {
				Session.memJoin = logdata;
				System.out.println("세션 생성 완료");
				info("로그인 되었습니다.");
				Stage primaryStage = swMainMain.rootStage;
				Parent root = FXMLLoader.load(getClass().getResource("../../total/view/LoginAfter.fxml"));
				Scene scene = new Scene(root);
				primaryStage.setTitle("afterMain");
				primaryStage.setScene(scene);
				scene.getStylesheets().add(getClass().getResource("logIn_Out_admin.css").toExternalForm());
				primaryStage.show();

				Stage bc = (Stage) btnOk.getScene().getWindow();
				bc.close();
			} else if (logdata != null && logdata.getMem_id().equals("admin") != false) {
				Session.memJoin = logdata;
				System.out.println("세션 생성 완료");
				info("관리자로 로그인 되었습니다.");
				Stage primaryStage = swMainMain.rootStage;
				Parent root = FXMLLoader.load(getClass().getResource("../../total/view/LoginAfterManage.fxml"));
				Scene scene = new Scene(root);
				primaryStage.setTitle("LoginAfterManage");
				primaryStage.setScene(scene);
				scene.getStylesheets().add(getClass().getResource("logIn_Out_admin.css").toExternalForm());
				primaryStage.show();

				Stage bc = (Stage) btnOk.getScene().getWindow();
				bc.close();
			} else {
				if (logdata.getMem_stop().equals("Y")) {
					alert("정지 되어있는 회원입니다.");
					return;
				} else {
					alert("아이디 또는 비밀번호가 일치하지 않습니다.");
					return;
				}
			}
		} catch (Exception e) {
			alert("로그인 조건에 부합하지 않습니다.");
		}
	}

	@FXML
	void txtFID(ActionEvent event) {

	}

	@FXML
	void txtFPW(ActionEvent event) {

	}

	private LoginService service;
	ObservableList<MemberJoinVo> memList = FXCollections.observableArrayList();

	@FXML
	void initialize() {
		assert txtFID != null : "fx:id=\"txtFID\" was not injected: check your FXML file 'Login.fxml'.";
		assert txtFPW != null : "fx:id=\"txtFPW\" was not injected: check your FXML file 'Login.fxml'.";
		assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'Login.fxml'.";
		assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'Login.fxml'.";

		service = LoginService.getInstance();
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
