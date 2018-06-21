package team3.swS.infoSntcInqire.main;

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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import team3.swS.infoSntcInqire.service.InfoService;
import team3.swS.infoSntcInqire.vo.InfoVO;

public class InfoMainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<InfoVO> tableView;
    
    @FXML
    private TableColumn<?, ?> noCol;

    @FXML
    private TableColumn<?, ?> contentsCol;
    
    @FXML
    private Button btnAdd;

    @FXML
    void btnAdd(ActionEvent event) {
    	try {
			Stage childStage = new Stage(StageStyle.UTILITY);
			childStage.initModality(Modality.NONE);
			childStage.setTitle("추가");

			Parent childRoot = FXMLLoader.load(getClass().getResource("../view/InfoMain.fxml"));
			// FXML문서에 구성해놓은 컨트롤 객체 구하기
			// FXML문서의 컨틀롤에 설정해 놓은 ID값을 이용한다.
	    	
			Scene scene = new Scene(childRoot);
			childStage.setTitle("회원정보");
			childStage.setScene(scene);
			childStage.show();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }

    private InfoService service;

	ObservableList<InfoVO> infoList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'InfoMain.fxml'.";
        assert noCol != null : "fx:id=\"noCol\" was not injected: check your FXML file 'InfoMain.fxml'.";
        assert contentsCol != null : "fx:id=\"contentsCol\" was not injected: check your FXML file 'InfoMain.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'InfoMain.fxml'.";
        
        service = InfoService.getInstance();
        
        noCol.setCellValueFactory(new PropertyValueFactory<>("INFO_NO"));
        contentsCol.setCellValueFactory(new PropertyValueFactory<>("INFO_CONTENTS"));
        
        List<InfoVO> info = service.getAllMember();
        infoList.clear();
        infoList.addAll(info);
		tableView.setItems(infoList);
    }
}
