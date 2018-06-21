package team3.swS.board.main;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import team3.swS.board.service.BoardService;
import team3.swS.board.vo.searchVo.BoardVO;
import team3.swS.common.Session;
import team3.swS.total.main.swMainMain;

public class QAReadController {
	
	private QAController qc;

	public void setQc(QAController qc) {
		this.qc = qc;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtFTitle;

    @FXML
    private Button btnComment;
    
    @FXML
    private TextArea txtAInfo;

    @FXML
    private Button btnModify;

    @FXML
    private Button btnDelete;
    
    @FXML
    void btnComment(ActionEvent event) {
    	try {
    		Parent popRoot = FXMLLoader.load(getClass().getResource("../../comments/view/commentMain.fxml"));
    		Stage primaryStage = new Stage(StageStyle.UTILITY);
    		primaryStage.initModality(Modality.WINDOW_MODAL);
    		primaryStage.initOwner(swMainMain.rootStage);
    		Scene scene = new Scene(popRoot);
    		primaryStage.setTitle("Comments");
    		primaryStage.setScene(scene);
    		primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnDelete(ActionEvent event) {
    	BoardVO bvo = Session.boardtemp;
    	bvo.setBoard_title("삭제된 글 입니다.");
    	bvo.setBoard_contents("삭제된 글 입니다.");
    	service.deleteboard_A(bvo);
    	qc.init();
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
    	qc.init();
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
        assert txtFTitle != null : "fx:id=\"txtFTitle\" was not injected: check your FXML file 'qARead.fxml'.";
        assert txtAInfo != null : "fx:id=\"txtAInfo\" was not injected: check your FXML file 'qARead.fxml'.";
        assert btnModify != null : "fx:id=\"btnModify\" was not injected: check your FXML file 'qARead.fxml'.";
        assert btnComment != null : "fx:id=\"btnComment\" was not injected: check your FXML file 'qARead.fxml'.";
        assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'qARead.fxml'.";
        
        
//        if(!Session.memJoin.getMem_no().equals(Session.boardtemp.getBoard_mem_no()))
//        {
//        	txt
//        	alert("다른 회원의 글을 볼 수 없습니다.");
//        }
        
        if(!Session.memJoin.getMem_no().equals(Session.boardtemp.getBoard_mem_no())) {
        	
        	btnDelete.setVisible(false);
        	btnModify.setVisible(false);
        	
        	txtFTitle.setEditable(false);
        	txtAInfo.setEditable(false);
        	
        }
        
        service = BoardService.getInstance();
        
        BoardVO bvo = Session.boardtemp;
        txtFTitle.setText(bvo.getBoard_title());
        txtAInfo.setText(bvo.getBoard_contents());
        
        if(!Session.memJoin.getMem_no().equals(Session.boardtemp.getBoard_mem_no())) {
        	btnModify.setVisible(false);
        	btnDelete.setVisible(false);
        	
        	txtFTitle.setEditable(false);
        	txtAInfo.setEditable(false);
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
