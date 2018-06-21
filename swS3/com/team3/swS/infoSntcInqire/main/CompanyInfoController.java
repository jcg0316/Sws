package team3.swS.infoSntcInqire.main;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import team3.swS.infoSntcInqire.service.InfoService;
import team3.swS.infoSntcInqire.vo.InfoVO;

public class CompanyInfoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea Company;

    
    private InfoService service;

   	ObservableList<InfoVO> infoList = FXCollections.observableArrayList();
   	
    @FXML
    void initialize() {
        assert Company != null : "fx:id=\"Company\" was not injected: check your FXML file 'companyIntro.fxml'.";

        
        
        
        
        
    }
}
