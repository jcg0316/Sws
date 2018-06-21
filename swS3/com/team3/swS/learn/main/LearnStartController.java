package team3.swS.learn.main;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import team3.swS.common.Session;
import team3.swS.learn.service.LearnService;
import team3.swS.lvoca.main.LvocaController;
import team3.swS.voca.vo.VocaVO;

/**
 * 이곳에서 객체를 받아서 할당해준다
 * 
 * @author elili
 *
 */
public class LearnStartController {
	List<VocaVO> fillteredVocaVoListForX;
	List<VocaVO> fillteredVocaVoListForTotal;
	int i = 0;
	private WebEngine engine1;
	private WebEngine engine2;
	private LearnService service;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label labCount;

	@FXML
	private Label wordEng;

	@FXML
	private Label wordKor;

	@FXML
	private Button btnO;

	@FXML
	private Button btnX;

	@FXML
	private WebView webview1;

	@FXML
	private WebView webview2;

	@FXML
	void btnO(ActionEvent event) {
	
			// 학습빈도의 +-를 업데이트 해줘야 한다
			if (fillteredVocaVoListForTotal.size() != 0) { // 전체 단어부분
				if (i == fillteredVocaVoListForTotal.size()) {
					alert("학습이 1바퀴 완료되었습니다.");
					System.out.println("학습이 1바퀴 완료되었습니다.");
					return;
				}
				String eng = fillteredVocaVoListForTotal.get(i).getVoca_word();
				String kor = fillteredVocaVoListForTotal.get(i).getVoca_mean();
				wordEng.setText(eng);
				wordKor.setText(kor);

				engine1.load("http://small.dic.daum.net/search.do?q="+ wordEng.getText()+ "&dic=eng");
				engine2.load("https://m.youtube.com/results?search_query=" + wordEng.getText());

				int OInput = service.btnOInputed(fillteredVocaVoListForTotal.get(i));

			} else { // x 단어부분
				if (i == fillteredVocaVoListForX.size()) {
					alert("학습이 1바퀴 완료되었습니다.");
					System.out.println("학습이 1바퀴 완료되었습니다.");
					return;
				}
				String eng = fillteredVocaVoListForX.get(i).getVoca_word();
				String kor = fillteredVocaVoListForX.get(i).getVoca_mean();
				wordEng.setText(eng);
				wordKor.setText(kor);
				engine1.load("http://small.dic.daum.net/search.do?q="+ wordEng.getText()+ "&dic=eng");
//				engine1.load("http://dic.impact.pe.kr/ecmaster-cgi/search.cgi?kwd=" + wordEng.getText()
//						+ "&bool=and&word=yes");
				engine2.load("https://m.youtube.com/results?search_query=" + wordEng.getText());
				int OInput = service.btnOInputed(fillteredVocaVoListForX.get(i));
			}
			i++;
		
	}

	@FXML
	void btnX(ActionEvent event) {
		
			// 학습빈도의 +-를 업데이트 해줘야 한다
			if (fillteredVocaVoListForTotal.size() != 0) { // 전체 단어부분
				if (i == fillteredVocaVoListForTotal.size()) {
					alert("학습이 1바퀴 완료되었습니다.");
					System.out.println("학습이 1바퀴 완료되었습니다.");
					return;
				}
				String eng = fillteredVocaVoListForTotal.get(i).getVoca_word();
				String kor = fillteredVocaVoListForTotal.get(i).getVoca_mean();
				wordEng.setText(eng);
				wordKor.setText(kor);

				engine1.load("http://small.dic.daum.net/search.do?q="+ wordEng.getText()+ "&dic=eng");
				engine2.load("https://m.youtube.com/results?search_query=" + wordEng.getText());

				int XInput = service.btnXInputed(fillteredVocaVoListForTotal.get(i));

			} else {
				if (i == fillteredVocaVoListForX.size()) {
					alert("학습이 1바퀴 완료되었습니다.");
					System.out.println("학습이 1바퀴 완료되었습니다.");
					return;
				}
				String eng = fillteredVocaVoListForX.get(i).getVoca_word();
				String kor = fillteredVocaVoListForX.get(i).getVoca_mean();
				wordEng.setText(eng);
				wordKor.setText(kor);

				engine1.load("http://small.dic.daum.net/search.do?q="+ wordEng.getText()+ "&dic=eng");
				engine2.load("https://m.youtube.com/results?search_query=" + wordEng.getText());
				int XInput = service.btnXInputed(fillteredVocaVoListForX.get(i));
			}
			i++;
		

	}

	@FXML
	void initialize() {
		assert labCount != null : "fx:id=\"labCount\" was not injected: check your FXML file 'wordMemoryStart.fxml'.";
		assert wordEng != null : "fx:id=\"wordEng\" was not injected: check your FXML file 'wordMemoryStart.fxml'.";
		assert wordKor != null : "fx:id=\"wordKor\" was not injected: check your FXML file 'wordMemoryStart.fxml'.";
		assert btnO != null : "fx:id=\"btnO\" was not injected: check your FXML file 'wordMemoryStart.fxml'.";
		assert btnX != null : "fx:id=\"btnX\" was not injected: check your FXML file 'wordMemoryStart.fxml'.";
		assert webview1 != null : "fx:id=\"webview1\" was not injected: check your FXML file 'wordMemoryStart.fxml'.";
		assert webview2 != null : "fx:id=\"webview2\" was not injected: check your FXML file 'wordMemoryStart.fxml'.";
		i = 0;
		
		engine1 = webview1.getEngine();
		engine2 = webview2.getEngine();
		service = LearnService.getInstance();

		engine1.load("http://small.dic.daum.net/search.do?q=input&dic=eng");
		engine2.load("https://m.youtube.com/results?search_query=input");
		fillteredVocaVoListForTotal = LearnController.fillteredVocaVoListForTotal;
		fillteredVocaVoListForX = LearnController.fillteredVocaVoListForX;
		System.out.println(fillteredVocaVoListForTotal.size());
		System.out.println(fillteredVocaVoListForX.size());
	}

	// alert
	public void alert(String msg) {
		Alert alertWarning = new Alert(AlertType.INFORMATION);
		alertWarning.setContentText(msg);
		alertWarning.showAndWait();
	}

}
