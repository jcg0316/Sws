package team3.swS.productManage.main;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import team3.swS.productManage.service.ProductAddService;
import team3.swS.productManage.vo.ProdVO;

public class ProductUpdateController {
	private ProductManageController refresh;


	public void setRefresh(ProductManageController refresh) {
		this.refresh = refresh;
	}


	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private Label lblNO;
    
    @FXML
    private VBox vbAdd;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtDel;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnClose;

    @FXML
    void btnClose(ActionEvent event) {
    	Stage bc = (Stage) btnClose.getScene().getWindow();
 	    bc.close();
 	    
 	    List<ProdVO> prod =  service.getAllProduct() ;
        prodList.clear();
        prodList.addAll(prod);
 	   
    }

    @FXML
    void btnUpdate(ActionEvent event) {
    	
    	String amount = txtAmount.getText();
    	String name = txtName.getText();
    	String date = txtDate.getText();
    	String del = txtDel.getText();
    	
    		
    	if(amount.isEmpty()) {
    		alert("가격이 비었습니다.");
    		return;
    	}
    	if(name.isEmpty()) {
    		alert("이름이 비었습니다.");
    		return;
    	}
    	if(date.isEmpty()) {
    		alert("기간이 비었습니다.");
    		return;
    	}
    	if(del.isEmpty()) {
    		alert("삭제여부가 비었습니다.");
    		return;
    	}
    	ProdVO pv = new ProdVO();
    	pv.setVoucher_no(lblNO.getText());
    	pv.setVoucher_amount(txtAmount.getText());
    	pv.setVoucher_name(txtName.getText());
    	pv.setVoucher_date(txtDate.getText());
    	pv.setVoucher_del(txtDel.getText());
    
    	
    	int cnt =service.updateProduct(pv);
    	if(cnt>0) {
    		info("수정성공");
    	}else {
    		info("수정실패");
    	}
    	//prodList.addAll(pv);
    	refresh.refresh();
    	
    	Stage bc = (Stage) btnClose.getScene().getWindow();
 	    bc.close();
 	    
    }
    
    
    private ProductAddService service;
    
    ObservableList<ProdVO> prodList=FXCollections.observableArrayList();
    
    public void setData(ProdVO prodVo) {
    	lblNO.setText(prodVo.getVoucher_no());
    	txtAmount.setText(prodVo.getVoucher_amount());
    	txtName.setText(prodVo.getVoucher_name());
    	txtDate.setText(prodVo.getVoucher_date());
    	txtDel.setText(prodVo.getVoucher_del());
    	
    }
    

    @FXML
    void initialize() {
        assert vbAdd != null : "fx:id=\"vbAdd\" was not injected: check your FXML file 'productUpdate.fxml'.";
        assert txtAmount != null : "fx:id=\"txtAmount\" was not injected: check your FXML file 'productUpdate.fxml'.";
        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'productUpdate.fxml'.";
        assert txtDate != null : "fx:id=\"txtDate\" was not injected: check your FXML file 'productUpdate.fxml'.";
        assert txtDel != null : "fx:id=\"txtDel\" was not injected: check your FXML file 'productUpdate.fxml'.";
        assert btnUpdate != null : "fx:id=\"btnUpdate\" was not injected: check your FXML file 'productUpdate.fxml'.";
        assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'productUpdate.fxml'.";
        assert lblNO != null : "fx:id=\"lblNO\" was not injected: check your FXML file 'productUpdate.fxml'.";
        service= ProductAddService.getInstance();
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
