package team3.swS.voca.main;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import team3.swS.common.Session;
import team3.swS.lvoca.vo.LvocaVO;
import team3.swS.voca.service.VocaService;
import team3.swS.voca.vo.VocaVO;

public class IntrNWordController {
	
	
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ImageView imageviewIntro;

	@FXML
	private Button btnVocaOut;

	@FXML
	private Button btnAdd;

	@FXML
	private Button btnCancel;

	@FXML
	private TextArea taFile;

	@FXML
    private TextArea taFileName;

	File selectedFile; // 선택할 파일

	
	/**
	 * 선택한 파일을 취소한다.
	 * 
	 * @param event
	 */
	@FXML
	void onCancel(ActionEvent event) {
		
		
		taFileName.clear();
		
		btnVocaOut.setDisable(true);
		btnAdd.setDisable(false);
		btnCancel.setDisable(false);
	}
	

	/**
	 * 추가할 파일을 선택하기 위한 메서드
	 * 
	 * @param event
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	@FXML
	void onVocaAdd(ActionEvent event) throws UnknownHostException, IOException {
		
		if(Session.memJoin == null) {
			alert("로그인을 하고 실행해 주세요.");
			return;
		}
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("All Files", "*.*"));

		selectedFile = fileChooser.showOpenDialog(null);

		if (selectedFile != null) {
			System.out.println(selectedFile.getName());
			taFileName.setText(selectedFile.getName());

			btnCancel.setDisable(false);
			btnAdd.setDisable(true);
			btnVocaOut.setDisable(false);
			// Excel_Json();
		}
		

	}
	
	/**
	 * 추가할 단어장을 디비에 저장하기 위한 메서드
	 * 
	 * @param event
	 */
	@FXML
	void onVocaOut(ActionEvent event) {
		
		btnVocaOut.setDisable(true);
		btnAdd.setDisable(false);
		btnCancel.setDisable(false);


		String path = selectedFile.getPath();
		String json = "";
		Gson gson = null;
		JsonObject object = null;
		
		// 확장자가 pdf파일인 경우에 실행
		if (path.contains(".pdf")) {
			PDFTextExtractor pdf = new PDFTextExtractor();

			// pdf파일에 있는 단어를 파싱해서 pdf_list에 넣기
			List<String> pdf_list = pdf.readParaFromPDF(path, 1, "", "");

			// LvocaVO에 파일이름과 날짜 셋팅하기
			LvocaVO lvo = new LvocaVO();
			
			// 파일 이름 불러오기
			int idx = selectedFile.getName().indexOf(".");
			lvo.setLvoca_name(selectedFile.getName().substring(0, idx) + "__empty");
			lvo.setLvoca_date("");
			lvo.setLvoca_mem_no(Session.memJoin.getMem_no());
			lvo.setLvoca_no("");
			
			
			String insertLVoca = service.addLVoca(lvo);
			if((Integer.parseInt(insertLVoca)) > 0) {
				String lvocaNo = service.select_LvocaNo();
				for (int i = 0; i < pdf_list.size(); i++) {
					gson = new Gson();
					object = new JsonObject();
					// 단어들을 key값 : word / value값 : 단어 로 설정한다.
					object.addProperty("word", pdf_list.get(i));
					json = gson.toJson(object);
//					System.out.println(json);
					pdf_Json_DB2(json, lvocaNo);
				}

			}}


	}
	
	
	
	private VocaService service;
	ObservableList<VocaVO> vocaList = FXCollections.observableArrayList();
	static List<String> jsonList = new ArrayList<String>();

	@FXML
	void initialize() {
		assert imageviewIntro != null : "fx:id=\"imageviewIntro\" was not injected: check your FXML file 'intrNWord.fxml'.";
		assert btnVocaOut != null : "fx:id=\"btnVocaOut\" was not injected: check your FXML file 'intrNWord.fxml'.";
		assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'intrNWord.fxml'.";
		assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'intrNWord.fxml'.";
		assert taFile != null : "fx:id=\"taFile\" was not injected: check your FXML file 'intrNWord.fxml'.";
		assert taFileName != null : "fx:id=\"taFileName\" was not injected: check your FXML file 'intrNWord.fxml'.";

		service = VocaService.getInstance();

		btnVocaOut.setDisable(true);
		btnAdd.setDisable(false);
		btnCancel.setDisable(false);
		
	}

	
	/**
	 * json을 DB로 변환하기
	 */
	
	public void Json_DB1() {
		
//		int seqResult = service.seqOfLvocaNo();
		
		for (int i = 0; i < jsonList.size(); i++) {
			
			VocaVO vo = new VocaVO();
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(jsonList.get(i));

			String no = element.getAsJsonObject().get("voca_no").getAsString();
			String mean = element.getAsJsonObject().get("voca_mean").getAsString();
			String word = element.getAsJsonObject().get("voca_word").getAsString();
			int learn_freq = element.getAsJsonObject().get("voca_learn_freq").getAsInt();
			int voca_frequency = element.getAsJsonObject().get("voca_frequency").getAsInt();
			//String voca_lvoca_no = element.getAsJsonObject().get("voca_lvoca_no").getAsString();
//			String name = element.getAsJsonObject().get("voca_name").getAsString();

			vo.setVoca_no(no);
			vo.setVoca_word(word);
			vo.setVoca_mean(mean);
			vo.setVoca_frequency(voca_frequency);
			vo.setVoca_learn_freq(learn_freq);
//			vo.setVoca_lvoca_no(voca_lvoca_no);
//			vo.setVoca_lvoca_no("l" + seqResult);
			
			int idx = selectedFile.getName().indexOf(".");
			vo.setVoca_name(selectedFile.getName().substring(0, idx));

			vocaList.add(vo);

//			System.out.println(vo);
			int fileResult = service.onFileDB(vo);
			if (fileResult > 0) {
				System.out.println("파일을 디비에 저장했습니다.");
			} else {
				System.out.println("파일을 디비에 저장하는것에 실패했습니다.");
			}

		}
		
	}
	
		
		/**
		 * pdf파일 -> json-> DB로 변환하기
		 */
		public void pdf_Json_DB2(String json, String seqResult) {
			VocaVO vo = new VocaVO();
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(json);

			
			String mean = "";
			String word = element.getAsJsonObject().get("word").getAsString();
			int learn_freq = 0;
			int voca_frequency = 1;
			
			Date dt = new Date();
			System.out.println(dt.toString());
			SimpleDateFormat sdf = new SimpleDateFormat("mmss"); 
			
			vo.setVoca_no("V"+ sdf.format(dt) + service.seqOfVocaNo());
			vo.setVoca_word(word);
			vo.setVoca_mean(mean);
			vo.setVoca_frequency(voca_frequency);
			vo.setVoca_learn_freq(learn_freq);
			vo.setVoca_lvoca_no(seqResult);
			
			int idx = selectedFile.getName().indexOf(".");
			vo.setVoca_name(selectedFile.getName().substring(0, idx));

			vocaList.add(vo);
			
//			for(VocaVO str : vocaList) {
//				System.out.println("\nVOCA_NO," + 
//						"VOCA_MEAN," + 
//						"VOCA_WORD," + 
//						"VOCA_LEARN_FREQ," + 
//						"VOCA_FREQUENCY," + 
//						"VOCA_LVOCA_NO," + 
//						"VOCA_NAME : \n" + str + "\n");
//			}

			int fileResult = service.onFileDB(vo);
			if (fileResult > 0) {
				System.out.println("파일을 디비에 저장했습니다.");
			} else {
				System.out.println("파일을 디비에 저장하는것에 실패했습니다.");
			}
		

	}
	

	/**
	 * EXCEL에서 Json으로 변환하기
	 */
	public void Excel_Json() {

		VocaExcelReader excelReader = new VocaExcelReader();

		// int idx = selectedFile.getName().indexOf(".");
		//
		// System.out.println(selectedFile.getName().substring(0, idx));
		// tfFileName.setText(selectedFile.getName().substring(0, idx));
//		String fileName = "D:/A_TeachingMaterial/5.MiddleProject/workspace/swS/res/초등영단어 800(알파벳순).xls.xlsx";
		
		String fileName = selectedFile.getPath();
		if (fileName.contains(".xlsx")) {
			System.out.println("==== xlsx ====");
			List<VocaVO> xlsxList = excelReader.xlsxToVocaVoList(fileName);
			printList(xlsxList);
		} else {
			System.out.println("==== xls ====");
			List<VocaVO> xlsList = excelReader.xlsToVocaVoList(fileName);
			printList(xlsList);
		}
	}

	
	/**
	 * json을 콘솔에 출력하기
	 * @param list
	 */
	public static void printList(List<VocaVO> list) {

		for (int i = 0; i < list.size(); i++) {

			Gson gson = new Gson();

			String json = gson.toJson(list.get(i));

			IntrNWordController ej = new IntrNWordController();
			ej.jsonList.add(json);
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
