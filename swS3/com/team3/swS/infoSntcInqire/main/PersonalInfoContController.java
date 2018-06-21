package team3.swS.infoSntcInqire.main;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import team3.swS.infoSntcInqire.service.InfoService;
import team3.swS.infoSntcInqire.vo.InfoVO;

public class PersonalInfoContController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea PersonalInfoCont;
    
    @FXML
    private VBox  vbTest;

    private InfoService service;

   	ObservableList<InfoVO> infoList = FXCollections.observableArrayList();
    @FXML
    void initialize() throws IOException {
        assert PersonalInfoCont != null : "fx:id=\"PersonalInfoCont\" was not injected: check your FXML file 'personalInfoCont.fxml'.";
        
//        service = InfoService.getInstance();
//        
//        List<InfoVO> info = service.getAllMember();
//        infoList.clear();
//        infoList.addAll(info);
//        PersonalInfoCont.setText(info.get(0).getInfo_contents());
    }
}
