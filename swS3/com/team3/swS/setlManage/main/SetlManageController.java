package team3.swS.setlManage.main;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.poi.xdgf.usermodel.section.GeometrySection;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import team3.swS.charge.vo.ChargeVO;
import team3.swS.common.Session;
import team3.swS.memJoin.vo.MemberJoinVo;
import team3.swS.productManage.vo.ProdVO;
import team3.swS.purchs.service.OrdersService;
import team3.swS.setlManage.service.SetlService;

public class SetlManageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuButton menuboxTime;

    @FXML
    private MenuItem menubox1Week;

    @FXML
    private MenuItem menubox1Month;

    @FXML
    private MenuItem menubox6Month;

    @FXML
    private MenuItem menubox1year;

    @FXML
    private MenuButton menuboxID;

    @FXML
    private MenuItem menuboxEmail;

    @FXML
    private MenuItem menuboxNum;

    @FXML
    private TextField txtFSearch;

    @FXML
    private Button btnOk;

    @FXML
    private TableView<ChargeVO> tableviewInfo;

    @FXML
    private TableColumn<?, ?> noCol;

    @FXML
    private TableColumn<?, ?> dateCol;

    @FXML
    private TableColumn<?, ?> mileageCol;

    @FXML
    private TableColumn<?, ?> appCol;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> bankCol;

    @FXML
    private TableColumn<?, ?> numCol;

    @FXML
    private Button btnMoneyOk;
    
    @FXML
    private Button btnExcelDown;
    
    @FXML
    private MenuItem menuboxTime2;
    
    @FXML
    private MenuItem menuboxID2;
    
    private SetlService service;
    ObservableList<ChargeVO> setlList=FXCollections.observableArrayList();
    ObservableList<MemberJoinVo> memList=FXCollections.observableArrayList();
    
    
    @FXML
    void btnExcelDown(ActionEvent event) {
    	
    	SetExcelWriter excelWriter = new SetExcelWriter();
    	
    	excelWriter.xlsWiter(setlList);
    	
    	excelWriter.xlsxWiter(setlList);
    	
    	info("저장되었습니다.");
    	
    	
    }

    @FXML
    void tableClick(MouseEvent event) {
    	
    }
    
    private int mileageTot = 0;
    
    ChargeVO chargeVo = new ChargeVO();
    MemberJoinVo memjoin = new MemberJoinVo();
    @FXML
    void btnMoneyOk(ActionEvent event) {
    	String mile = tableviewInfo.getSelectionModel().getSelectedItem().getCmile_amount();//클릭한 신청마일리지
    	String memNo = tableviewInfo.getSelectionModel().getSelectedItem().getCmile_mem_no();//클릭한 회원번호
    	String appro = tableviewInfo.getSelectionModel().getSelectedItem().getCmile_appro();//클릭한 회원승인신청
    	
    	if (appro.equals("승인")) {
    		alert("이미 충전신청이 완료된 회원입니다. 충전하실 수 없습니다.");
			return;
		} else {
			try {
				//신청 승인으로 바꾸기
				
				chargeVo.setCmile_appro("승인"); //승인으로 세팅
				String no = tableviewInfo.getSelectionModel().getSelectedItem().getCmile_order_no();//클릭한주문번호
				chargeVo.setCmile_order_no(no); //주문번호 세팅
				
				String cnt =service.updateChargeAppro(chargeVo);
				if (cnt.equals(null)) {
					info("해당 회원의 마일리지가 충전되었습니다");
				} 
				
			} catch (Exception e) {
				alert("해당 회원의 마일리지가 충전되었습니다");
				e.printStackTrace();
			}
			
		}
    	

    	//충전신청한 마일리지 값을 숫자형으로 바꿔서 원래 마일리지와 계산한 다음에 다시 String으로 변환한 뒤 세팅
    	chargeVo.setCmile_mem_no(memNo);
		memjoin.setMem_no(chargeVo.getCmile_mem_no());
		memjoin.setCmile_order_no(chargeVo.getCmile_order_no());
		
		String cnt2 =service.updateMemberMileage(memjoin);
		
    	//화면에 변경된 값 다시 출력
    	initialize();
    	
    }

    @FXML
    void btnOk(ActionEvent event) {
    	
    	MenuButton mbtn = new MenuButton();
    	
    	String mbtnTxt = mbtn.getText();
    
    	try {
    		//회원정보 검색
    		if(menuboxTime.getText().equals("기간설정") && menuboxID.getText().equals("회원정보설정")) {
    			alert("검색할 기간과 회원정보를 설정해 주세요.");
    			
    		}else if(menuboxID.getText().equals("기간설정")) {
    			alert("검색할 기간을 설정해 주세요.");
    			
    		}else if(menuboxID.getText().equals("회원정보설정")) {
    			alert("검색할 회원정보를 설정해 주세요.");
    			
    		}else if(txtFSearch.getText().isEmpty()==true) {
    			alert("검색할 내용을 입력해 주세요.");
    			
    		}else if(menuboxID.getText().equals("회원번호") && txtFSearch.getText()!=null && !txtFSearch.getText().equals("전체회원")) {
    			String user = txtFSearch.getText();
    			chargeVo.setCmile_mem_no(user);
    			
    			List<ChargeVO> setl = service.getChargeUserInfo(chargeVo);
    			setlList.clear();
    			setlList.addAll(setl);
    			tableviewInfo.setItems(setlList);
    			
    		} else if(menuboxID.getText().equals("이메일") && txtFSearch.getText()!=null) {
    			String user2 = txtFSearch.getText();
    			memjoin.setMem_email(user2);
    			chargeVo.setCmile_mem_no(memjoin.getMem_no());
    			
    			List<ChargeVO> setl = service.getChargeEmailInfo(memjoin);
    			setlList.clear();
    			setlList.addAll(setl);
    			tableviewInfo.setItems(setlList);
    			
    		} else if(menuboxID.getText().equals("전화번호") && txtFSearch.getText()!=null){
    			String user3 = txtFSearch.getText();
    			memjoin.setMem_telno(user3);
    			chargeVo.setCmile_mem_no(memjoin.getMem_no());
    			
    			List<ChargeVO> setl = service.getChargeTelInfo(memjoin);
    			setlList.clear();
    			setlList.addAll(setl);
    			tableviewInfo.setItems(setlList);
    			
    		} else if(menuboxID.getText().equals("회원번호") && txtFSearch.getText().equals("전체회원")) {
    			initialize();
    		}
    		
    		txtFSearch.clear();
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
//    	if(txtFSearch.getText().equals(null)) {
//    		alert("검색할 내용을 입력해 주세요.");
//    	
//    	}
    	
    	
    	
//    	Calendar cal = Calendar.getInstance();
//		SimpleDateFormat sdf1 = new SimpleDateFormat("yyMMdd");
//		String dateTime = sdf1.format(cal.getTime());
//    	
//    	if(menuboxTime.getText().equals("1주")) {
//    		int cnt = Integer.parseInt(dateTime) - 7;
//    		String dateUserTime = String.valueOf(cnt);
//    	}
		
    	
    }

    @FXML
    void menubox1Month(ActionEvent event) {
    	menuboxTime.setText("1개월");
    	chargeVo.setCmile_date("30");
    	memjoin.setCmile_date("30");
    }

    @FXML
    void menubox1Week(ActionEvent event) {
    	menuboxTime.setText("1주");
    	chargeVo.setCmile_date("7");
    	memjoin.setCmile_date("7");
    }

    @FXML
    void menubox1year(ActionEvent event) {
    	menuboxTime.setText("1년");
    	chargeVo.setCmile_date("365");
    	memjoin.setCmile_date("365");
    }

    @FXML
    void menubox6Month(ActionEvent event) {
    	menuboxTime.setText("6개월");
    	chargeVo.setCmile_date("180");
    	memjoin.setCmile_date("180");
    }

    @FXML
    void menuboxEmail(ActionEvent event) {
    	menuboxID.setText("이메일");
    	
    }

    @FXML
    void menuboxID(ActionEvent event) {
    	menuboxID.setText("회원정보설정");
    }

    @FXML
    void menuboxNum(ActionEvent event) {
    	menuboxID.setText("전화번호");
    }

    @FXML
    void menuboxTime(ActionEvent event) {
    	menuboxTime.setText("기간설정");
    
    }

    @FXML
    void txtFSearch(ActionEvent event) {

    }

    @FXML
    void menuboxID2(ActionEvent event) {
    	menuboxID.setText("회원번호");
    }
    
    @FXML
    void menuboxTime2(ActionEvent event) {
    	menuboxTime.setText("전체기간");
    	chargeVo.setCmile_date("500");
    	memjoin.setCmile_date("500");
    }
    
    

    @FXML
    void initialize() {
    	assert menuboxTime2 != null : "fx:id=\"menuboxTime2\" was not injected: check your FXML file 'buyManage.fxml'.";
    	assert menuboxTime != null : "fx:id=\"menuboxTime\" was not injected: check your FXML file 'buyManage.fxml'.";
        assert menubox1Week != null : "fx:id=\"menubox1Week\" was not injected: check your FXML file 'buyManage.fxml'.";
        assert menubox1Month != null : "fx:id=\"menubox1Month\" was not injected: check your FXML file 'buyManage.fxml'.";
        assert menubox6Month != null : "fx:id=\"menubox6Month\" was not injected: check your FXML file 'buyManage.fxml'.";
        assert menubox1year != null : "fx:id=\"menubox1year\" was not injected: check your FXML file 'buyManage.fxml'.";
        assert menuboxID != null : "fx:id=\"menuboxID\" was not injected: check your FXML file 'buyManage.fxml'.";
        assert menuboxID2 != null : "fx:id=\"menuboxID2\" was not injected: check your FXML file 'buyManage.fxml'.";
        assert menuboxEmail != null : "fx:id=\"menuboxEmail\" was not injected: check your FXML file 'buyManage.fxml'.";
        assert menuboxNum != null : "fx:id=\"menuboxNum\" was not injected: check your FXML file 'buyManage.fxml'.";
        assert txtFSearch != null : "fx:id=\"txtFSearch\" was not injected: check your FXML file 'buyManage.fxml'.";
        assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'buyManage.fxml'.";
        assert tableviewInfo != null : "fx:id=\"tableviewInfo\" was not injected: check your FXML file 'buyManage.fxml'.";
        assert noCol != null : "fx:id=\"noCol\" was not injected: check your FXML file 'buyManage.fxml'.";
        assert dateCol != null : "fx:id=\"dateCol\" was not injected: check your FXML file 'buyManage.fxml'.";
        assert mileageCol != null : "fx:id=\"mileageCol\" was not injected: check your FXML file 'buyManage.fxml'.";
        assert appCol != null : "fx:id=\"appCol\" was not injected: check your FXML file 'buyManage.fxml'.";
        assert nameCol != null : "fx:id=\"nameCol\" was not injected: check your FXML file 'buyManage.fxml'.";
        assert bankCol != null : "fx:id=\"bankCol\" was not injected: check your FXML file 'buyManage.fxml'.";
        assert numCol != null : "fx:id=\"numCol\" was not injected: check your FXML file 'buyManage.fxml'.";
        assert btnMoneyOk != null : "fx:id=\"btnMoneyOk\" was not injected: check your FXML file 'buyManage.fxml'.";
        assert btnExcelDown != null : "fx:id=\"btnExcelDown\" was not injected: check your FXML file 'buyManage.fxml'.";
        
        
        service = SetlService.getInstance();
		
		appCol.setCellValueFactory(new PropertyValueFactory<>("Cmile_appro"));
		noCol.setCellValueFactory(new PropertyValueFactory<>("Cmile_order_no"));
		mileageCol.setCellValueFactory(new PropertyValueFactory<>("Cmile_amount"));
		nameCol.setCellValueFactory(new PropertyValueFactory<>("Cmile_remit_name"));
		bankCol.setCellValueFactory(new PropertyValueFactory<>("Cmile_remit_bank"));
		numCol.setCellValueFactory(new PropertyValueFactory<>("Cmile_mem_no"));
		dateCol.setCellValueFactory(new PropertyValueFactory<>("Cmile_date"));
		
		List<ChargeVO> setl=service.getChargeInfo();
		setlList.clear();
		setlList.addAll(setl);
		tableviewInfo.setItems(setlList);
		
		
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
