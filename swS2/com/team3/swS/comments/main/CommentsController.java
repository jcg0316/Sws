package team3.swS.comments.main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import team3.swS.board.vo.searchVo.BoardVO;
import team3.swS.comments.service.CommentsService;
import team3.swS.comments.vo.CommentsVo;
import team3.swS.common.Session;

public class CommentsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TableView<CommentsVo> tableView;
    
    @FXML
    private TableColumn<?, ?> colNum;

    @FXML
    private TableColumn<?, ?> colText;

    @FXML
    private TableColumn<?, ?> colWriter;
    
    @FXML
    private TextField txtCom;
    
    @FXML
    private Button btnWrite;

    @FXML
    private Button btnDelete;

    @FXML
    void btnDelete(ActionEvent event) {
    	Session.commenttemp = tableView.getSelectionModel().getSelectedItem();
    	CommentsVo cvo = new CommentsVo();
    	cvo.setReply_no(Session.commenttemp.getReply_no());
    	service.deleteComments(cvo);
    	alert("댓글이 삭제 되었습니다!");
    	commentList.clear();
    	cvo.setReply_board_apticle_no(Session.boardtemp.getBoard_apticle_no());
    	cvo.setReply_no(Session.commenttemp.getReply_no());
    	cvo.setReply_descripyion("삭제된 글 입니다.");
    	commentList.addAll(service.getAllComments(cvo));
    }


    @FXML
    void btnWrite(ActionEvent event) {
    	CommentsVo cvo = new CommentsVo();
    	cvo.setReply_descripyion(txtCom.getText());
    	cvo.setReply_board_apticle_no(Session.boardtemp.getBoard_apticle_no());
    	cvo.setReply_mem_no(Session.memJoin.getMem_no());
    	cvo.setReply_mem_nick(Session.memJoin.getMem_nick());
    	
    	service.insertComments(cvo);
    	boolean result = commentList.add(cvo);
    	if(result) {
			info("댓글 입력 성공!");
		}else {
			alert("댓글 입력에 실패하였습니다.");
			return;
		}
    	commentList.clear();
    	commentList.addAll(service.getAllComments(cvo));
    }
    
    @FXML
    void txtCom(ActionEvent event) {

    }
    
    private CommentsService service;
    ObservableList<CommentsVo> commentList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
    	 assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'commentMain.fxml'.";
         assert colNum != null : "fx:id=\"colNum\" was not injected: check your FXML file 'commentMain.fxml'.";
         assert colText != null : "fx:id=\"colText\" was not injected: check your FXML file 'commentMain.fxml'.";
         assert colWriter != null : "fx:id=\"colWriter\" was not injected: check your FXML file 'commentMain.fxml'.";
         assert txtCom != null : "fx:id=\"txtCom\" was not injected: check your FXML file 'commentMain.fxml'.";
         assert btnWrite != null : "fx:id=\"btnWrite\" was not injected: check your FXML file 'commentMain.fxml'.";
         assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'commentMain.fxml'.";
        
        service = CommentsService.getInstance();
        
        
        colNum.setCellValueFactory(new PropertyValueFactory<>("reply_no"));
        colText.setCellValueFactory(new PropertyValueFactory<>("reply_descripyion"));
        colWriter.setCellValueFactory(new PropertyValueFactory<>("reply_mem_nick"));
        
        commentList.clear();
        CommentsVo cvo = new CommentsVo();
        cvo.setReply_board_apticle_no(Session.boardtemp.getBoard_apticle_no());
        
        
        commentList.addAll(service.getAllComments(cvo));
        tableView.setItems(commentList);
        
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
