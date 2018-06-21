package team3.swS.memManagement.main;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import team3.swS.common.Session;
import team3.swS.memJoin.vo.MemberJoinVo;
import team3.swS.memManagement.service.MemManageService;
import team3.swS.productManage.main.ProductAddController;
import team3.swS.productManage.vo.ProdVO;
import team3.swS.total.main.swMainMain;

public class memManageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuButton menubtnWriter;

    @FXML
    private MenuItem menubtnEmail;

    
    @FXML
    private TextField txtFSearch;

    @FXML
    private Button btnOk;

    @FXML
    private TableView<MemberJoinVo> memTable;

    @FXML
    private TableColumn<?, ?> noCol;

    @FXML
    private TableColumn<?, ?> passCol;

    @FXML
    private TableColumn<?, ?> nickCol;

    @FXML
    private TableColumn<?, ?> interCol;

    @FXML
    private TableColumn<?, ?> mailCol;

    @FXML
    private TableColumn<?, ?> mileCol;

    @FXML
    private TableColumn<?, ?> telCol;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private TableColumn<?, ?> stopCol;

    @FXML
    private TableColumn<?, ?> authorCol;

    @FXML
    private TableColumn<?, ?> enddayCol;

    @FXML
    private TableColumn<?, ?> ordernoCol;

    @FXML
    private Button btnRight;

    @FXML
    private Button btnStop;

    @FXML
    private Button btnMileage;
    

    @FXML
    void btnMileage(ActionEvent event) {
    	
    	try {
    		Session.mileage=null;
    		Session.mileage=memTable.getSelectionModel().getSelectedItem();
			Stage childStage = new Stage(StageStyle.UTILITY);
			childStage.initModality(Modality.WINDOW_MODAL);
			childStage.initOwner(swMainMain.rootStage);
			childStage.setTitle("지급");

			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/memberAddMileage.fxml"));
			Parent childRoot = loader.load();
			
	        
			MemAddController mac=loader.getController();
			mac.getMainControll(this);
			// FXML문서에 구성해놓은 컨트롤 객체 구하기
			// FXML문서의 컨틀롤에 설정해 놓은 ID값을 이용한다.
	    	
			
			List<MemberJoinVo>member2 = service.getMemberInfo();
			memList.clear();
			memList.addAll(member2);
			memTable.setItems(memList);
			
			
			Scene scene = new Scene(childRoot);
			childStage.setTitle("마일리지 지급");
			childStage.setScene(scene);
			childStage.show();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    	
    }

    @FXML
    void btnOk(ActionEvent event) {
    	
    	//회원정보검색
    	if(menubtnWriter.getText().equals("작성자")) {
    		String user = txtFSearch.getText();
    		MemberJoinVo mvo = new MemberJoinVo();
    		mvo.setMem_no(user);
    		
    		List<MemberJoinVo> member = service.getMemUserInfo(mvo);
    		memList.clear();
    		memList.addAll(member);
    		memTable.setItems(memList);
    	}else if(menubtnEmail.getText().equals("이메일")) {
    		String user2 = txtFSearch.getText();
    		MemberJoinVo mvo = new MemberJoinVo();
    		mvo.setMem_email(user2);
    		
    		List<MemberJoinVo> member =service.getMemEmailInfo(mvo);
    		memList.clear();
    		memList.addAll(member);
    		memTable.setItems(memList);
    	
    	
    		
    	}
    }

    @FXML
    void btnRight(ActionEvent event) {
    	String author = memTable.getSelectionModel().getSelectedItem().getMem_author();
    	String memNo =memTable.getSelectionModel().getSelectedItem().getMem_no();
    	if(author=="A") {
    		alert("관리자입니다.설정하실 수 없습니다.");
    		return;
    	}else {
    		try {
    			MemberJoinVo member = new MemberJoinVo();
    			member.setMem_author("A");
    			member.setMem_no(memNo);
				String cnt = service.updateMemAuthor(member);
				System.out.println(cnt+"..............................................");
				if(cnt!=null) {
					info("관리자로 승인 되었습니다.");
					List<MemberJoinVo> member2 = service.getMemberInfo();
			        memList.clear();
			        memList.addAll(member2);
			        memTable.setItems(memList);
					
				}
			} catch (Exception e) {
				info("승인 불가!");
				e.printStackTrace();
			}
    	}
    }

    @FXML
    void btnStop(ActionEvent event) {
    	String stop = memTable.getSelectionModel().getSelectedItem().getMem_stop();
    	String memNo= memTable.getSelectionModel().getSelectedItem().getMem_no();
    	
    	if(stop=="Y") {
    		alert("이미 정지상태인 회원입니다.");
    		return;
    	}else {
    		try {
				MemberJoinVo mvo=new MemberJoinVo();
				mvo.setMem_stop("Y");
				mvo.setMem_no(memNo);
				String cnt =service.updateMemStop(mvo);
				if(cnt!=null) {
					info("정지상태로 변경되었습니다.");
					List<MemberJoinVo>member2 = service.getMemberInfo();
			        memList.clear();
			        memList.addAll(member2);
			        memTable.setItems(memList);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    }

    @FXML
    void menubtnEmail(ActionEvent event) {
    	menubtnWriter.setText("이메일");
    }


    @FXML
    void menubtnWriter(ActionEvent event) {
    	menubtnWriter.setText("작성자");
    }

    @FXML
    void txtFSearch(ActionEvent event) {

    }

    private MemManageService service;
    
    ObservableList<MemberJoinVo> memList = FXCollections.observableArrayList();
    
    
    @FXML
    void initialize() {
        assert menubtnWriter != null : "fx:id=\"menubtnWriter\" was not injected: check your FXML file 'memberManage.fxml'.";
        assert menubtnEmail != null : "fx:id=\"menubtnEmail\" was not injected: check your FXML file 'memberManage.fxml'.";
        assert txtFSearch != null : "fx:id=\"txtFSearch\" was not injected: check your FXML file 'memberManage.fxml'.";
        assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'memberManage.fxml'.";
        assert memTable != null : "fx:id=\"memTable\" was not injected: check your FXML file 'memberManage.fxml'.";
        assert noCol != null : "fx:id=\"noCol\" was not injected: check your FXML file 'memberManage.fxml'.";
        assert passCol != null : "fx:id=\"passCol\" was not injected: check your FXML file 'memberManage.fxml'.";
        assert nickCol != null : "fx:id=\"nickCol\" was not injected: check your FXML file 'memberManage.fxml'.";
        assert interCol != null : "fx:id=\"interCol\" was not injected: check your FXML file 'memberManage.fxml'.";
        assert mailCol != null : "fx:id=\"mailCol\" was not injected: check your FXML file 'memberManage.fxml'.";
        assert mileCol != null : "fx:id=\"mileCol\" was not injected: check your FXML file 'memberManage.fxml'.";
        assert telCol != null : "fx:id=\"telCol\" was not injected: check your FXML file 'memberManage.fxml'.";
        assert idCol != null : "fx:id=\"idCol\" was not injected: check your FXML file 'memberManage.fxml'.";
        assert stopCol != null : "fx:id=\"stopCol\" was not injected: check your FXML file 'memberManage.fxml'.";
        assert authorCol != null : "fx:id=\"authorCol\" was not injected: check your FXML file 'memberManage.fxml'.";
        assert enddayCol != null : "fx:id=\"enddayCol\" was not injected: check your FXML file 'memberManage.fxml'.";
        assert btnRight != null : "fx:id=\"btnRight\" was not injected: check your FXML file 'memberManage.fxml'.";
        assert btnStop != null : "fx:id=\"btnStop\" was not injected: check your FXML file 'memberManage.fxml'.";
        assert btnMileage != null : "fx:id=\"btnMileage\" was not injected: check your FXML file 'memberManage.fxml'.";

        service= MemManageService.getInstance();
        noCol.setCellValueFactory(new PropertyValueFactory<>("mem_no"));
        passCol.setCellValueFactory(new PropertyValueFactory<>("mem_password"));
        nickCol.setCellValueFactory(new PropertyValueFactory<>("mem_nick"));
        interCol.setCellValueFactory(new PropertyValueFactory<>("mem_interrest"));
        mailCol.setCellValueFactory(new PropertyValueFactory<>("mem_email"));
        mileCol.setCellValueFactory(new PropertyValueFactory<>("mem_mileage"));
        telCol.setCellValueFactory(new PropertyValueFactory<>("mem_telno"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
        stopCol.setCellValueFactory(new PropertyValueFactory<>("mem_stop"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("mem_author"));
        enddayCol.setCellValueFactory(new PropertyValueFactory<>("mem_endday"));
        
        List<MemberJoinVo> member = service.getMemberInfo();
        memList.clear();
        memList.addAll(member);
        memTable.setItems(memList);
        
        
        
        
        
        
        
        
        
        
        
        
    }
    public void info(String msg) {
    	Alert alertInfo = new Alert(AlertType.INFORMATION);
    	alertInfo.setTitle("확인");
    	alertInfo.setContentText(msg);
    	alertInfo.showAndWait();
    }
    public void alert(String msg) {
    	Alert alertWarning = new Alert(AlertType.WARNING);
    	alertWarning.setTitle("경고");
    	alertWarning.setContentText(msg);
    	alertWarning.showAndWait();
    }
    public void refresh() {
       	List<MemberJoinVo> member = service.getMemberInfo();
    	memList.clear();
    	memList.addAll(member);
    	memTable.setItems(memList);
    }
}
