package team3.swS.learn.main;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import team3.swS.common.Session;
import team3.swS.learn.service.LearnService;
import team3.swS.voca.vo.VocaVO;

/**
 * 단어 객체 ox 로 거르기 x만 있는 객체로 반환
 * 
 * @author elili
 *
 */
public class LearnController {
	private LearnService service;
	public static List<VocaVO> fillteredVocaVoListForX = new ArrayList<VocaVO>(); // 필터링된 리스트가 담길 곳 x
	public static List<VocaVO> fillteredVocaVoListForTotal = new ArrayList<VocaVO>(); // 필터링된 리스트가 담길 곳 전체

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private CheckBox chekboxWrong;

	@FXML
	private Button btnStart;

	@FXML
	private VBox learnBoard;
	
	
	@FXML
	void btnStart(ActionEvent event) {
		// 틀린문제만 할것인지, 모든 단어를 암기할것인지 선택.
		if (chekboxWrong.isSelected()) {
			System.out.println("Session.memJoin.getMem_no() : " + Session.memJoin.getMem_no());
			if(memToRemainDay() == true) {
				fillteringVocaVoToOX();
			} else {
				alert("기간이 만료되었습니다. \n 틀린단어를 암기하고 싶으면 마일리지를 충천해주시기 바랍니다.");
				return;
			}
			
		} else {
			fillteredVocaVoListForTotal.addAll(Session.wordAndMean_list);
		}

		try {
			Parent subRoot = FXMLLoader.load(getClass().getResource("../view/wordMemoryStart.fxml"));
			learnBoard.getChildren().clear();
			learnBoard.getChildren().add(subRoot);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 유료회원의 남아있는 일자
	 * @return
	 */
	public boolean memToRemainDay() {
		System.out.println("Session.memJoin.getMem_no() : " + Session.memJoin.getMem_no());
		int mem_remainDay = service.memberToEndDay(Session.memJoin.getMem_no());
		System.out.println("service.memberToEndDay(Session.memJoin.getMem_no() : " + mem_remainDay);
		if(mem_remainDay >= 0) {
			return true;
		} else {
			return false;
		}
	}

	@FXML
	void chekboxWrong(ActionEvent event) {

	}

	@FXML
	void initialize() {
		assert chekboxWrong != null : "fx:id=\"chekboxWrong\" was not injected: check your FXML file 'wordMemoryMain.fxml'.";
		assert btnStart != null : "fx:id=\"btnStart\" was not injected: check your FXML file 'wordMemoryMain.fxml'.";
		assert learnBoard != null : "fx:id=\"learnBoard\" was not injected: check your FXML file 'wordMemoryMain.fxml'.";
		
		service = LearnService.getInstance();
		
	}

	public void fillteringVocaVoToOX() {
//		System.out.println(" Session.wordAndMean_list.size()" + Session.wordAndMean_list.size());
//		System.out.println("fillteredVocaVoListForX.add(Session.wordAndMean_list. "
//				+ fillteredVocaVoListForX.addAll(Session.wordAndMean_list));
		fillteredVocaVoListForX.clear();
		for (int i = 0; i < Session.wordAndMean_list.size(); i++) {
			if (Session.wordAndMean_list.get(i).getVoca_learn_freq() < 0) {
				fillteredVocaVoListForX.add(Session.wordAndMean_list.get(i));
				
			}
			// else { fillteredVocaVoListForTotal.add(Session.wordAndMean_list.get(i)); }
//			System.out.println(fillteredVocaVoListForX.get(i).getVoca_word());

		}

	}
	
	/**
	 * 경고 메서드
	 * @param msg
	 */
	public void alert(String msg) {
    	Alert alertWarning = new Alert(AlertType.WARNING);
    	alertWarning.setTitle("경고");
    	alertWarning.setContentText(msg);
    	alertWarning.showAndWait();
    }
	
	/**
	 * 확인 메서드
	 * @param msg
	 */
	 public void info(String msg) {
	    	Alert alertInfo = new Alert(AlertType.INFORMATION);
	    	alertInfo.setTitle("확인");
	    	alertInfo.setContentText(msg);
	    	alertInfo.showAndWait();
	    }

}
