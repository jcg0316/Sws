package team3.swS.board.main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import team3.swS.board.service.BoardService;
import team3.swS.board.vo.searchVo.BoardVO;
import team3.swS.common.Session;

public class QAWriteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtFTitle;

    @FXML
    private TextArea txtAInfo;

    @FXML
    private Button btnOk;

    @FXML
    private Button btnCancel;

    @FXML
    void btnCancel(ActionEvent event) {
    	txtFTitle.clear();
    	txtAInfo.clear();
    	Stage bc = (Stage) btnCancel.getScene().getWindow();
 	    bc.close();
    }

    @FXML
    void btnOk(ActionEvent event) {
    	BoardVO bvo = new BoardVO();
    	bvo.setBoard_title(txtFTitle.getText());
    	bvo.setBoard_contents(txtAInfo.getText());
    	bvo.setBoard_mem_no(Session.memJoin.getMem_no());
		bvo.setBoard_mem_nick(Session.memJoin.getMem_nick());
		
    	service.insertboard_C(bvo);
    	boolean result = boardList.add(bvo);
    	if(result) {
			info("게시글 입력 성공!");
			Stage bc = (Stage) btnOk.getScene().getWindow();
			bc.close();
		}else {
			alert("게시글 입력에 실패하였습니다.");
			return;
		}
    }

    @FXML
    void txtFTitle(ActionEvent event) {

    }
    
    private BoardService service;
    ObservableList<BoardVO> boardList = FXCollections.observableArrayList();
    	
    @FXML
    void initialize() {
        assert txtFTitle != null : "fx:id=\"txtFTitle\" was not injected: check your FXML file 'qAWrite.fxml'.";
        assert txtAInfo != null : "fx:id=\"txtAInfo\" was not injected: check your FXML file 'qAWrite.fxml'.";
        assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'qAWrite.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'qAWrite.fxml'.";
        
        service = BoardService.getInstance();
        
        	btnOk.setVisible(true);
        	btnCancel.setVisible(true);
        	
        	txtFTitle.setEditable(true);
        	txtAInfo.setEditable(true);
        	
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
