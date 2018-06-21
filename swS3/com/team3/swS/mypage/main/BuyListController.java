package team3.swS.mypage.main;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import team3.swS.common.Session;
import team3.swS.mypage.service.MypageService;
import team3.swS.mypage.vo.VoucherVO;

public class BuyListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<VoucherVO> tableviewBuy;

    @FXML
    private TableColumn<?, ?> columnSysdate;
    
    @FXML
    private TableColumn<?, ?> columnNO;

    @FXML
    private TableColumn<?, ?> columnName;

    @FXML
    private TableColumn<?, ?> columnBuy;

    @FXML
    private TableColumn<?, ?> columnDate;

    @FXML
    private Button btnOut;

    @FXML
    void btnOut(ActionEvent event) {
    	Stage bc = (Stage) btnOut.getScene().getWindow();
 	    bc.close();
    }

    private MypageService service;
    ObservableList<VoucherVO> voucherList=FXCollections.observableArrayList();

	
    @FXML
    void initialize() {
        assert tableviewBuy != null : "fx:id=\"tableviewBuy\" was not injected: check your FXML file 'buyList.fxml'.";
        assert columnNO != null : "fx:id=\"columnNO\" was not injected: check your FXML file 'buyList.fxml'.";
        assert columnName != null : "fx:id=\"columnName\" was not injected: check your FXML file 'buyList.fxml'.";
        assert columnBuy != null : "fx:id=\"columnBuy\" was not injected: check your FXML file 'buyList.fxml'.";
        assert columnDate != null : "fx:id=\"columnDate\" was not injected: check your FXML file 'buyList.fxml'.";
        assert btnOut != null : "fx:id=\"btnOut\" was not injected: check your FXML file 'buyList.fxml'.";
        assert columnSysdate != null : "fx:id=\"columnSysdate\" was not injected: check your FXML file 'buyList.fxml'.";
        service = MypageService.getInstance();
//        OrdersVO OrdersVO = null;
        List<VoucherVO> list = new ArrayList<>();
//        VoucherVO voucherVO=new VoucherVO();
        String member=Session.memJoin.getMem_no();
        list = service.getAllVoucher(member);//값이 들어간 상태
        
//        voucherVO.setOrders_mem_no(OrdersVO.getOrders_mem_no());
//        voucherVO.setVoucher_amount(OrdersVO.getOrders_amount());
//        voucherVO.setVoucher_date(OrdersVO.getOrders_date());
//        voucherVO.setVoucher_name(OrdersVO.getOrders_voucher_name());
//        voucherVO.setVoucher_no(OrdersVO.ge);
        
       
        
        System.out.println("세션확인 : " + member);
        
        
        
        columnNO.setCellValueFactory(new PropertyValueFactory<>("voucher_no"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("voucher_name"));
        columnBuy.setCellValueFactory(new PropertyValueFactory<>("voucher_amount"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("voucher_date"));
        columnSysdate.setCellValueFactory(new PropertyValueFactory<>("voucher_sysdate"));
        
        voucherList.clear();
        voucherList.addAll(list);
        tableviewBuy.setItems(voucherList);
        
    }

public void info(String msg) {
	Alert alertInfo = new Alert(AlertType.INFORMATION);
	alertInfo.setTitle("확인");
	alertInfo.setContentText(msg);
	alertInfo.showAndWait();
}
}
