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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import team3.swS.board.service.BoardService;
import team3.swS.board.vo.searchVo.BoardVO;
import team3.swS.common.Session;

public class NoticeReadController {
	
	private NoticeController nc;
	
	public void setNc(NoticeController nc) {
		this.nc = nc;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox readNotice;

    @FXML
    private TextField txtFTitle;

    @FXML
    private TextArea txtAInfo;

    @FXML
    private Button btnModify;
    
    @FXML
    private Button btnDelete;

    @FXML
    void btnDelete(ActionEvent event) {
    	BoardVO bvo = Session.boardtemp;
    	bvo.setBoard_title("삭제된 글 입니다.");
    	bvo.setBoard_contents("삭제된 글 입니다.");
    	service.deleteboard_A(bvo);
    	nc.init();
    	alert("게시글이 삭제 되었습니다!");
    	
    	Stage bc = (Stage) btnDelete.getScene().getWindow();
    	bc.close();
    }

    @FXML
    void btnModify(ActionEvent event) {
    	BoardVO bvo = Session.boardtemp;
    	bvo.setBoard_title(txtFTitle.getText());
    	bvo.setBoard_contents(txtAInfo.getText());
    	service.updateboard_A(bvo);
    	nc.init();
    	info(" 게시글이 수정 되었습니다! ");
    	Stage bc = (Stage) btnModify.getScene().getWindow();
    	bc.close();
    }

    @FXML
    void txtFTitle(ActionEvent event) {

    }
    
    private BoardService service;
    ObservableList<BoardVO> boardList = FXCollections.observableArrayList();
    
    @FXML
    void initialize() {
        assert readNotice != null : "fx:id=\"readNotice\" was not injected: check your FXML file 'noticeRead.fxml'.";
        assert txtFTitle != null : "fx:id=\"txtFTitle\" was not injected: check your FXML file 'noticeRead.fxml'.";
        assert txtAInfo != null : "fx:id=\"txtAInfo\" was not injected: check your FXML file 'noticeRead.fxml'.";
        assert btnModify != null : "fx:id=\"btnModify\" was not injected: check your FXML file 'noticeRead.fxml'.";
        assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'noticeRead.fxml'.";

        service = BoardService.getInstance();
        
        BoardVO bvo = Session.boardtemp;
        txtFTitle.setText(bvo.getBoard_title());
        txtAInfo.setText(bvo.getBoard_contents());
        
//        if(Session.memJoin.getMem_no().equals(Session.boardtemp.getBoard_mem_no())) {
        if(!Session.memJoin.getMem_author().equals("A")) {
        	btnModify.setVisible(false);
        	btnDelete.setVisible(false);
        	
        	txtAInfo.setEditable(false);
        	txtFTitle.setEditable(false);
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
