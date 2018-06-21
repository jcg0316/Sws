package team3.swS.board.main;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import team3.swS.board.service.BoardService;
import team3.swS.board.vo.searchVo.BoardVO;
import team3.swS.common.Session;
import team3.swS.total.main.swMainMain;

public class QAController {
	
	BoardVO bd = new BoardVO();
	
	private int limit;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<BoardVO> tableviewInfo;

    @FXML
    private TableColumn<?, ?> colunmNo;

    @FXML
    private TableColumn<?, ?> colunmTitle;

    @FXML
    private TableColumn<?, ?> colunmDate;

    @FXML
    private TableColumn<?, ?> colunmNick;

    @FXML
    private StackPane pagePanel;

    @FXML
    private Pagination noticePagination;

    @FXML
    private Button btnWrite;

    @FXML
    private MenuButton menubtn;

    @FXML
    private MenuItem menubtnNick;

    @FXML
    private MenuItem menubtnText;

    @FXML
    private MenuItem menubtnTitle;

    @FXML
    private TextField txtFSearch;

    @FXML
    private Button btnSearchOk;

    @FXML
	void MouseClickTable(MouseEvent event) {
		try {
			Session.boardtemp = null;
    		Session.boardtemp = tableviewInfo.getSelectionModel().getSelectedItem();
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/QARead.fxml"));
    		Parent popRoot = loader.load();
    		
    		QAReadController qaRead = loader.getController();
    		qaRead.setQc(this);
    		
    		Stage primaryStage = new Stage(StageStyle.UTILITY);
    		primaryStage.initModality(Modality.WINDOW_MODAL);
    		primaryStage.initOwner(swMainMain.rootStage);
    		Scene scene = new Scene(popRoot);
    		primaryStage.setTitle("notice");
    		primaryStage.setScene(scene);
    		primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    @FXML
    void btnSearchOk(ActionEvent event) {
    	if(txtFSearch.getText()==null) {
			alert("검색할 내용을 입력해 주세요.");
		}
    	
    	if(menubtn.getText().equals("검색내용")) {
    		alert("검색할 내용을 설정해 주세요.");
    		
    	}
    	if(menubtn.getText().equals("작성자")) {
    		String nick = txtFSearch.getText();
    		bd.setBoard_mem_nick(nick);
    		
    		List<BoardVO> mbjl = service.getAllBoard_Writer_B(bd);
    		boardList.clear();
    		boardList.addAll(mbjl);
    		tableviewInfo.setItems(boardList);
    		
    	} else if(menubtn.getText().equals("내용")) {
    		String con = txtFSearch.getText();
    		bd.setBoard_contents(con);
    		
    		List<BoardVO> mbjl = service.getAllBoard_Contents_B(bd);
    		boardList.clear();
    		boardList.addAll(mbjl);
    		tableviewInfo.setItems(boardList);
    		
    	} else if(menubtn.getText().equals("제목")){
    		String title = txtFSearch.getText();
    		bd.setBoard_title(title);
    		
    		List<BoardVO> mbjl = service.getAllBoard_Title_B(bd);
    		boardList.clear();
    		boardList.addAll(mbjl);
    		tableviewInfo.setItems(boardList);
    		
    	} 
    	
    	txtFSearch.clear();
    }

    @FXML
	void btnWrite(ActionEvent event) {
		try {
    		Parent popRoot = FXMLLoader.load(getClass().getResource("../view/QAWrite.fxml"));
    		Stage primaryStage = new Stage(StageStyle.UTILITY);
    		primaryStage.initModality(Modality.WINDOW_MODAL);
    		primaryStage.initOwner(swMainMain.rootStage);
    		Scene scene = new Scene(popRoot);
    		primaryStage.setTitle("QA");
    		primaryStage.setScene(scene);
    		primaryStage.showAndWait();
    		boardList.clear();
    		boardList.addAll(service.getAllBoard_C());
    		init();
    		
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    @FXML
    void menubtn(ActionEvent event) {

    }

    @FXML
    void menubtnNick(ActionEvent event) {
    	menubtn.setText("작성자");
    }

    @FXML
    void menubtnText(ActionEvent event) {
    	menubtn.setText("내용");
    }

    @FXML
    void menubtnTitle(ActionEvent event) {
    	menubtn.setText("제목");
    }

    @FXML
    void txtFSearch(ActionEvent event) {

    }
    
    private BoardService service;
    ObservableList<BoardVO> boardList = FXCollections.observableArrayList();
    
    @FXML
    void initialize() {
    	 assert tableviewInfo != null : "fx:id=\"tableviewInfo\" was not injected: check your FXML file 'qA.fxml'.";
         assert colunmNo != null : "fx:id=\"colunmNo\" was not injected: check your FXML file 'qA.fxml'.";
         assert colunmTitle != null : "fx:id=\"colunmTitle\" was not injected: check your FXML file 'qA.fxml'.";
         assert colunmDate != null : "fx:id=\"colunmDate\" was not injected: check your FXML file 'qA.fxml'.";
         assert colunmNick != null : "fx:id=\"colunmNick\" was not injected: check your FXML file 'qA.fxml'.";
         assert pagePanel != null : "fx:id=\"pagePanel\" was not injected: check your FXML file 'qA.fxml'.";
         assert noticePagination != null : "fx:id=\"noticePagination\" was not injected: check your FXML file 'qA.fxml'.";
         assert btnWrite != null : "fx:id=\"btnWrite\" was not injected: check your FXML file 'qA.fxml'.";
         assert menubtn != null : "fx:id=\"menubtn\" was not injected: check your FXML file 'qA.fxml'.";
         assert menubtnNick != null : "fx:id=\"menubtnNick\" was not injected: check your FXML file 'qA.fxml'.";
         assert menubtnText != null : "fx:id=\"menubtnText\" was not injected: check your FXML file 'qA.fxml'.";
         assert menubtnTitle != null : "fx:id=\"menubtnTitle\" was not injected: check your FXML file 'qA.fxml'.";
         assert txtFSearch != null : "fx:id=\"txtFSearch\" was not injected: check your FXML file 'qA.fxml'.";
         assert btnSearchOk != null : "fx:id=\"btnSearchOk\" was not injected: check your FXML file 'qA.fxml'.";
        
//	     if(tableviewInfo.getSelectionModel().getSelectedIndex() > 0){ 
//	    	 if(!Session.memJoin.getMem_no().equals(Session.boardtemp.getBoard_mem_no())){
//	    	   alert("다른 회원의 글을 볼 수 없습니다.");
//	       }
//	     }
         
         if(Session.memJoin == null) {
        	 btnWrite.setVisible(true);
         }else {
        	 btnWrite.setVisible(true);
         }
         
         
         try {
        	service = BoardService.getInstance();
        	
        	tableviewInfo.setItems(boardList);
        	
        	
        	limit = 19;
        	// Pagination의 페이지 번호를 변경했을 때 처리
        	noticePagination.currentPageIndexProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    changeTableView(newValue.intValue(), limit);
                }

            });
        	
        	setValueFactory();
            
            init();              
	
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void init() {
    	boardList.clear();
    	boardList.addAll(service.getAllBoard_C());
        resetPage();	// 전체 페이지수를 구한다.
        noticePagination.setCurrentPageIndex(0);  // 현재 페이지 번호를 설정한다. (페이지 번호는 1페이지가 0번부터 시작한다.)
        changeTableView(0, limit);  // TableView에 첫번째 페이지가 나타나도록 한다.
    }
    
    public void resetPage() {
    	noticePagination.setPageCount((int) (Math.ceil(boardList.size() * 1.0 / limit)));
    }
    
    private void changeTableView(int intValue, int limit) {
    	int newIndex = intValue * limit;  // 가져올 시작 index번호 구하기

        // List에서 페이지 번호에 맞는 범위의 데이터들을 구한다.
        List<BoardVO> trans = boardList.subList(Math.min(newIndex, boardList.size()), Math.min(boardList.size(), newIndex + limit));
        
        ObservableList<BoardVO> newList = FXCollections.observableArrayList(trans);
        tableviewInfo.setItems(newList);
    }
    
    private void setValueFactory() {
    	colunmNo.prefWidthProperty().bind(tableviewInfo.widthProperty().divide(5));
    	colunmNo.setCellValueFactory(new PropertyValueFactory<>("board_apticle_no"));
    	
    	colunmTitle.prefWidthProperty().bind(tableviewInfo.widthProperty().divide(5));
    	colunmTitle.setCellValueFactory(new PropertyValueFactory<>("board_title"));
    	
    	colunmDate.prefWidthProperty().bind(tableviewInfo.widthProperty().divide(5));
    	colunmDate.setCellValueFactory(new PropertyValueFactory<>("board_date"));
    	
    	colunmNick.prefWidthProperty().bind(tableviewInfo.widthProperty().divide(5));
    	colunmNick.setCellValueFactory(new PropertyValueFactory<>("board_mem_nick"));
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
}
