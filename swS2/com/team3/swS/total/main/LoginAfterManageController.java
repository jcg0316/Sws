package team3.swS.total.main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import team3.swS.common.Session;

public class LoginAfterManageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView mainLogo;

    @FXML
    private Button wordBoardBtn;

    @FXML
    private Button chargeBoardBtn;

    @FXML
    private Button buyBoardBtn;

    @FXML
    private Button memCenterBoardBtn;

    @FXML
    private Button manageBoardBtn;

    @FXML
    private HBox mainLogin;

    @FXML
    private Button btnMypage;

    @FXML
    private Button btnLogout;

    @FXML
    private Button mainPBtn;

    @FXML
    private Button mainUBtn;

    @FXML
    private Button mainCBtn;

    @FXML
    private VBox swMainBoard;

    @FXML
    void btnLogo(MouseEvent event) {
    	try {
    		Parent subRoot = FXMLLoader.load(getClass().getResource("../../voca/view/intrNWord.fxml"));
        	swMainBoard.getChildren().clear();
        	swMainBoard.getChildren().add(subRoot);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void btnLogout(ActionEvent event) throws IOException {
    	
    	Stage primaryStage = swMainMain.rootStage;
    	Parent root = FXMLLoader.load(getClass().getResource("../view/swMain.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("swMain");
		primaryStage.setScene(scene);
		primaryStage.show();
		Session.memJoin=null;
    }

    @FXML
    void btnMypage(ActionEvent event) {
    	try {
    		Parent subRoot = FXMLLoader.load(getClass().getResource("../../mypage/view/mypageMain.fxml"));
        	swMainBoard.getChildren().clear();
        	swMainBoard.getChildren().add(subRoot);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void buyBoardBtn(ActionEvent event) {
    	try {
    		Parent subRoot = FXMLLoader.load(getClass().getResource("../../purchs/view/buyBoard.fxml"));
        	swMainBoard.getChildren().clear();
        	swMainBoard.getChildren().add(subRoot);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    	
    }

    @FXML
    void chargeBoardBtn(ActionEvent event) {
    	try {
    		Parent subRoot = FXMLLoader.load(getClass().getResource("../../charge/view/chargeMain.fxml"));
        	swMainBoard.getChildren().clear();
        	swMainBoard.getChildren().add(subRoot);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void mainCBtn(ActionEvent event) throws IOException {
    	Parent subRoot = FXMLLoader.load(getClass().getResource("../../infoSntcInqire/view/companyIntro.fxml"));
    	swMainBoard.getChildren().clear();
    	swMainBoard.getChildren().add(subRoot);
    }

    @FXML
    void mainPBtn(ActionEvent event) {
    	try {
    		Parent subRoot = FXMLLoader.load(getClass().getResource("../../infoSntcInqire/view/personalInfoCont.fxml"));
        	swMainBoard.getChildren().clear();
        	swMainBoard.getChildren().add(subRoot);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void mainUBtn(ActionEvent event) {
    	try {
    		Parent subRoot = FXMLLoader.load(getClass().getResource("../../infoSntcInqire/view/usingTerms.fxml"));
        	swMainBoard.getChildren().clear();
        	swMainBoard.getChildren().add(subRoot);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void manageBoardBtn(ActionEvent event) {
    	try {
    		Parent subRoot = FXMLLoader.load(getClass().getResource("../../managePage/view/manageBoard.fxml"));
        	swMainBoard.getChildren().clear();
        	swMainBoard.getChildren().add(subRoot);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void memCenterBoardBtn(ActionEvent event) {
    	try {
    		Parent subRoot = FXMLLoader.load(getClass().getResource("../../cuscen/view/costomBoard.fxml"));
        	swMainBoard.getChildren().clear();
        	swMainBoard.getChildren().add(subRoot);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void wordBoardBtn(ActionEvent event) {
    	
    	try {
    		
    		Parent subRoot = FXMLLoader.load(getClass().getResource("../../lvoca/view/wordMain.fxml"));
        	swMainBoard.getChildren().clear();
        	swMainBoard.getChildren().add(subRoot);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
        assert mainLogo != null : "fx:id=\"mainLogo\" was not injected: check your FXML file 'LoginAfter.fxml'.";
        assert wordBoardBtn != null : "fx:id=\"wordBoardBtn\" was not injected: check your FXML file 'LoginAfter.fxml'.";
        assert chargeBoardBtn != null : "fx:id=\"chargeBoardBtn\" was not injected: check your FXML file 'LoginAfter.fxml'.";
        assert buyBoardBtn != null : "fx:id=\"buyBoardBtn\" was not injected: check your FXML file 'LoginAfter.fxml'.";
        assert memCenterBoardBtn != null : "fx:id=\"memCenterBoardBtn\" was not injected: check your FXML file 'LoginAfter.fxml'.";
        assert manageBoardBtn != null : "fx:id=\"manageBoardBtn\" was not injected: check your FXML file 'LoginAfter.fxml'.";
        assert mainLogin != null : "fx:id=\"mainLogin\" was not injected: check your FXML file 'LoginAfter.fxml'.";
        assert btnMypage != null : "fx:id=\"btnMypage\" was not injected: check your FXML file 'LoginAfter.fxml'.";
        assert btnLogout != null : "fx:id=\"btnLogout\" was not injected: check your FXML file 'LoginAfter.fxml'.";
        assert mainPBtn != null : "fx:id=\"mainPBtn\" was not injected: check your FXML file 'LoginAfter.fxml'.";
        assert mainUBtn != null : "fx:id=\"mainUBtn\" was not injected: check your FXML file 'LoginAfter.fxml'.";
        assert mainCBtn != null : "fx:id=\"mainCBtn\" was not injected: check your FXML file 'LoginAfter.fxml'.";
        assert swMainBoard != null : "fx:id=\"swMainBoard\" was not injected: check your FXML file 'LoginAfter.fxml'.";

        try {
    		Parent subRoot = FXMLLoader.load(getClass().getResource("../../voca/view/intrNWord.fxml"));
        	swMainBoard.getChildren().clear();
        	swMainBoard.getChildren().add(subRoot);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
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