package team3.swS.productManage.main;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.poi.hsmf.datatypes.PropertyValue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import team3.swS.productManage.service.ProductAddService;
import team3.swS.productManage.vo.ProdVO;
import team3.swS.total.main.swMainMain;

public class ProductManageController {
	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<ProdVO> prodTable;
    
    @FXML
    private TableColumn<?, ?> noCol;

    @FXML
    private TableColumn<?, ?> dateCol;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> amountCol;

    @FXML
    private TableColumn<?, ?> delCol;

    @FXML
    private TableColumn<?, ?> categoryCol;

    @FXML
    private Button butAdd;

    @FXML
    private Button butUpdate;

//    @FXML
//    private Button butDel;

    @FXML
    void butAdd(ActionEvent event) {
    	
    	try {
			Stage childStage = new Stage(StageStyle.UTILITY);
			childStage.initModality(Modality.WINDOW_MODAL);
			childStage.initOwner(swMainMain.rootStage);
			childStage.setTitle("추가");

			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/productAdd.fxml"));
			Parent childRoot = loader.load();
			
			// FXML문서에 구성해놓은 컨트롤 객체 구하기
			// FXML문서의 컨틀롤에 설정해 놓은 ID값을 이용한다.
	    	
			
			ProductAddController proUpController = loader.getController();
//			proUpController.setData(prodVo);  // 새창에 데이터 보내기
			proUpController.setRefresh(this);
			
			Scene scene = new Scene(childRoot);
			childStage.setTitle("상품추가");
			childStage.setScene(scene);
			childStage.show();
			
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }

//    @FXML
//    void butDel(ActionEvent event) {
//    	ProdVO prodVo = prodTable.getSelectionModel().getSelectedItem(); 
//    	if(prodVo==null) {
//    		alert("삭제할 데이터를 선택한 후 사용하세요.");
//    		return;
//    	}
//    	String vNo = prodVo.getVoucher_no();
//    	int cnt =service.deleteProduct(vNo);
//    	if(cnt>0) {
//    		info("삭제성공");
//    	}else {
//    		info("삭제실패");
//    	}
//    	List<ProdVO> prod = service.getAllProduct();
//    	prodList.clear();
//    	prodList.addAll(prod);
//    	prodTable.setItems(prodList);
    	
//    }

    @FXML
    void butUpdate(ActionEvent event) {
    	try {
    		ProdVO prodVo = prodTable.getSelectionModel().getSelectedItem(); 
    		
    		if(prodVo==null) {
    	    		alert("수정할 데이터를 선택한 후 사용하세요.");
    	    		return;
    		}
    		
			Stage childStage = new Stage(StageStyle.UTILITY);
			childStage.initModality(Modality.WINDOW_MODAL);
			childStage.initOwner(swMainMain.rootStage);
			childStage.setTitle("상품수정");

			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/productUpdate.fxml"));
			
			Parent childRoot = loader.load();
			
			ProductUpdateController proUpController = loader.getController();
			proUpController.setData(prodVo);  // 새창에 데이터 보내기
			proUpController.setRefresh(this);
	    	
			Scene scene = new Scene(childRoot);
			childStage.setScene(scene);
			childStage.show();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }
    
    private ProductAddService service;
    
    ObservableList<ProdVO> prodList=FXCollections.observableArrayList();
    

    @FXML
    void initialize() {
        assert prodTable != null : "fx:id=\"prodTable\" was not injected: check your FXML file 'productManage.fxml'.";
        assert noCol != null : "fx:id=\"noCdl\" was not injected: check your FXML file 'productManage.fxml'.";
        assert dateCol != null : "fx:id=\"dateCol\" was not injected: check your FXML file 'productManage.fxml'.";
        assert nameCol != null : "fx:id=\"nameCol\" was not injected: check your FXML file 'productManage.fxml'.";
        assert amountCol != null : "fx:id=\"amountCol\" was not injected: check your FXML file 'productManage.fxml'.";
        assert delCol != null : "fx:id=\"delCol\" was not injected: check your FXML file 'productManage.fxml'.";
        assert categoryCol != null : "fx:id=\"categoryCol\" was not injected: check your FXML file 'productManage.fxml'.";
        assert butAdd != null : "fx:id=\"butAdd\" was not injected: check your FXML file 'productManage.fxml'.";
        assert butUpdate != null : "fx:id=\"butUpdate\" was not injected: check your FXML file 'productManage.fxml'.";
//        assert butDel != null : "fx:id=\"butDel\" was not injected: check your FXML file 'productManage.fxml'.";
        
        service= ProductAddService.getInstance();
        
        noCol.setCellValueFactory(new PropertyValueFactory<>("voucher_no"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("voucher_date"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("voucher_name"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("voucher_amount"));
        delCol.setCellValueFactory(new PropertyValueFactory<>("voucher_del"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("voucher_category"));
        
        List<ProdVO> prod = service.getAllProduct();
        prodList.clear();
        prodList.addAll(prod);
        prodTable.setItems(prodList);
        
//        prodTable.setOnMouseClicked(new EventHandler<Event>() {
//		
//        	public void handle(Event event) {
//        		try {
//        			Stage childStage = new Stage(StageStyle.UTILITY);
//        			childStage.initModality(Modality.WINDOW_MODAL);
//        			childStage.initOwner(primaryStage);
//        			childStage.setTitle("추가");
//
//        			Parent childRoot = FXMLLoader.load(getClass().getResource("../view/productUpdate.fxml"));
//        			// FXML문서에 구성해놓은 컨트롤 객체 구하기
//        			// FXML문서의 컨틀롤에 설정해 놓은 ID값을 이용한다.
//        	    	
//        			Scene scene = new Scene(childRoot);
//        			childStage.setTitle("상품추가");
//        			childStage.setScene(scene);
//        			childStage.show();
//        		} catch (IOException e1) {
//        			e1.printStackTrace();
//        		}
//        		
//        		
//        	};
//        });
        
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
    
    public void refresh() {
       	List<ProdVO> prod = service.getAllProduct();
    	prodList.clear();
    	prodList.addAll(prod);
    	prodTable.setItems(prodList);
    }
    
    
}