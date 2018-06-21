package team3.swS.lvoca.main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.ibatis.common.jdbc.exception.NestedSQLException;

import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Callback;
import team3.swS.common.Session;
import team3.swS.lvoca.service.LvocaService;
import team3.swS.lvoca.vo.LvocaVO;
import team3.swS.total.main.swMainMain;
import team3.swS.voca.vo.VocaVO;

public class LvocaController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableView<LvocaVO> vocaTable;

	@FXML
	private TableColumn<?, ?> chkCol;

	@FXML
	private TableColumn<?, ?> vocaNameCol; 

	@FXML
	private TableColumn<?, ?> dayCol;

	@FXML
	private Button btnLearn;

	@FXML
	private Button btnAdd;

	@FXML
	private Button btnExcelOut;

	@FXML
	private Button btnWordBookAdd;

	@FXML
	private Button btnDelete;

	File selectedFile; // 선택할 파일

	List<VocaVO> xlsxList; // 신버전 엑셀 리스트

	List<VocaVO> xlsList; // 구버전 엑셀 이스트

	String fileName; // 파일 이름

	String filePath; // 파일경로

	void vocaTable() {
		vocaTable.rowFactoryProperty();
	}

	@FXML
	void btnLearn(ActionEvent event) {
		if (vocaTable.getSelectionModel().getSelectedIndex() == -1) {
			alert("선택 하고 실행해 주세요.");
			return;
		}

		System.out.println("선택한 테이블의 아이템들 : ");

		// 선택한 파일의 lvoca_no값으로 단어와 뜻을 검색한다.
		String selected_table_LVocaNo = vocaTable.getSelectionModel().selectedItemProperty().get().getLvoca_no();
		Session.wordAndMean_list.addAll(service.findLVoca_WordAndMean(selected_table_LVocaNo)); // 단어전용세션에 담긴다
		// 선택한 파일의 lvoca_no값으로 단어와 뜻을 검색한다. 완료

		Parent popRoot;
		try {
			popRoot = FXMLLoader.load(getClass().getResource("../../learn/view/wordMemoryMain.fxml"));
			Stage primaryStage = new Stage(StageStyle.UTILITY);
			primaryStage.initModality(Modality.WINDOW_MODAL);
			primaryStage.initOwner(swMainMain.rootStage);
			Scene scene = new Scene(popRoot);
			primaryStage.setTitle("Join");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 뜻이 담겨진 단어장엑셀파일 -> 디비 -> 테이블뷰에 추가하기
	 * 
	 * @param event
	 */
	@FXML
	void onAdd(ActionEvent event) {
		chooseFile();
		if(selectedFile!=null) {
			excel_db();
		}

		lvocaList.clear();
		lvocaList.addAll(service.getAllVoca());
		vocaTable.setItems(lvocaList);

	}

	public void chooseFile() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("All Files", "*.*"));

		// 파일선택창으로 파일을 불러온다.
		selectedFile = fileChooser.showOpenDialog(null);

		// 파일을 선택했다면.
		if (selectedFile != null) {
			LVocaExcelReader lvocaExcelReader = new LVocaExcelReader();
			System.out.println(selectedFile.getName());

			fileName = selectedFile.getName();
			filePath = selectedFile.getPath();

			if (fileName.contains(".xlsx")) {
				System.out.println("==== xlsx ====");
				xlsxList = lvocaExcelReader.xlsxToLVocaVoList(filePath);
				// 콘솔에 출력함으로써 확인하기
				lvoca_Excel_Print(xlsxList);
			} else {
				System.out.println("==== xls ====");
				xlsList = lvocaExcelReader.xlsToLVocaVoList(filePath);
				// 콘솔에 출력함으로써 확인하기
				lvoca_Excel_Print(xlsList);
			}

		}
	}

	public static void lvoca_Excel_Print(List<VocaVO> list) {
		VocaVO vo;
		System.out.println("엑셀 출력");
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			vo = list.get(i);
			System.out.println(vo.toString());
		}
		System.out.println("엑셀 출력 끝");
	}

	/**
	 * 엑셀에 있는 데이터를 디비에 저장하기 위한 메서드
	 */
	public void excel_db() {

		if (filePath.contains(".xlsx")) {
			System.out.println(" xlsxList.size() : " +  xlsxList.size());
			Excel_Xlsx();
		}else{
			Excel_xls();
		}
	}

	/**
	 * 엑셀 신버전
	 */
	public void Excel_Xlsx() {

		VocaVO vo = new VocaVO();
		LvocaVO lvo = new LvocaVO();

		// 선택할 파일의 이름을 가져오기
		int idx = selectedFile.getName().indexOf(".");
		String select_FileName = selectedFile.getName().substring(0, idx);

		// lvo을 셋팅
		lvo.setLvoca_name(select_FileName);
		lvo.setLvoca_date("");
		lvo.setLvoca_mem_no(Session.memJoin.getMem_no());
		lvo.setLvoca_no("");

		// lvoca의 기본키를 가져오기 위해서 일단, lvo를 insert해주어야 한다.
		String insertLVoca = service.addLVoca(lvo);

		// insert 성공하면,
		if ((Integer.parseInt(insertLVoca)) > 0) {
			// lvoca_no의 값을 리턴한다.
			String lvocaNo = service.select_LvocaNo(insertLVoca);
			// 엑셀에 있는 데이터를 vo에 셋팅한다.
			
			for (int i = 0; i < xlsxList.size(); i++) {

				vo.setVoca_no("");
				vo.setVoca_mean(xlsxList.get(i).getVoca_mean());
				vo.setVoca_word(xlsxList.get(i).getVoca_word());
				vo.setVoca_learn_freq(xlsxList.get(i).getVoca_learn_freq());
				vo.setVoca_frequency(xlsxList.get(i).getVoca_frequency());
				vo.setVoca_lvoca_no(lvocaNo); // 리턴한 lvoca_no값을 셋팅한다.
				vo.setVoca_name(select_FileName); // 파일이름을 셋팅한다.

				// 엑셀에 있는 데이터를 DB에 저장한다.
				String result_excelToDB = service.Add_ExcelToDB(vo);
				if ((Integer.parseInt(result_excelToDB)) > 0) {
					System.out.println("디비에 저장 성공");
				} else {
					System.out.println("디비에 저장 실패!!");
				}
			}

		}

	}

	// 엑셀 구버전
	public void Excel_xls() {

//		VocaVO vo = new VocaVO();
		LvocaVO lvo = new LvocaVO();

		// 선택할 파일의 이름을 가져오기
		int idx = selectedFile.getName().indexOf(".");
		String select_FileName = selectedFile.getName().substring(0, idx);

		// lvo을 셋팅
		lvo.setLvoca_name(select_FileName);
		lvo.setLvoca_date("");
		lvo.setLvoca_mem_no(Session.memJoin.getMem_no());
		lvo.setLvoca_no("");

		// lvoca의 기본키를 가져오기 위한 작업
		String insertLVoca = service.addLVoca(lvo);

		if ((Integer.parseInt(insertLVoca)) > 0) {
			String lvocaNo = service.select_LvocaNo(insertLVoca);
			for (int i = 0; i < xlsList.size(); i++) {
				System.out.println("xlsList.size() : " + xlsList.size());
				VocaVO vo = new VocaVO();
				// vo에 셋팅하기
				vo.setVoca_no("");
				vo.setVoca_mean(xlsList.get(i).getVoca_mean());
				vo.setVoca_word(xlsList.get(i).getVoca_word());
				vo.setVoca_learn_freq(xlsList.get(i).getVoca_learn_freq());
				vo.setVoca_frequency(xlsList.get(i).getVoca_frequency());
				vo.setVoca_lvoca_no(lvocaNo);
				vo.setVoca_name(select_FileName);

				String result_excelToDB = service.Add_ExcelToDB(vo);
				if ((Integer.parseInt(result_excelToDB)) > 0) {
					System.out.println("디비에 저장 성공");
				} else {
					System.out.println("디비에 저장 실패!!");
				}
			}

		}
	}

	@FXML
	void onDelete(ActionEvent event) throws NestedSQLException {
		int cnt = 0;
		boolean chk = false;

		String selected_Item_LvocaNo = vocaTable.getSelectionModel().selectedItemProperty().get().getLvoca_no();
		cnt = service.onDelete_VocaBook(selected_Item_LvocaNo);
		int result_delete = service.onDelete_LVoca(selected_Item_LvocaNo);
		chk = lvocaList.remove(vocaTable.getSelectionModel().getSelectedItem());

	}

	/**
	 * 엑셀파일 받기
	 * 
	 * @param event
	 */
	@FXML
	void onExcelOut(ActionEvent event) {

		List<VocaVO> wordList = new ArrayList<VocaVO>();
//		List<VocaVO> wordListTemp = new ArrayList<VocaVO>();
//		wordList.addAll(service.getAllWord());
//		wordListTemp.addAll(wordList);
//		wordList.clear();
		String selected_table_LVocaNo = vocaTable.getSelectionModel().selectedItemProperty().get().getLvoca_no();
//		for (int i = 0; i < wordListTemp.size(); i++) {
//			if (wordListTemp.get(i).getVoca_lvoca_no().equals(selected_table_LVocaNo)) {
//				Session.wordAndMean_list.addAll(service.findLVoca_WordAndMean(selected_table_LVocaNo)); // 단어전용세션에 담긴다
//				wordList.addAll(Session.wordAndMean_list);
//			}
//		}
		Session.wordAndMean_list.clear();
		Session.wordAndMean_list.addAll(service.findLVoca_WordAndMean(selected_table_LVocaNo)); // 단어전용세션에 담긴다
		wordList.addAll(Session.wordAndMean_list);

		LVocaExcelWriter excelWriter = new LVocaExcelWriter();

		excelWriter.xlsWiter(wordList);

		excelWriter.xlsxWiter(wordList);

	}

	@FXML
	void onWordBookAdd(ActionEvent event) {
		
		
		try {
			Parent popRoot = FXMLLoader.load(getClass().getResource("../view/anotherWordBook.fxml"));
			Stage primaryStage = new Stage(StageStyle.UTILITY);
			// primaryStage.initModality(Modality.WINDOW_MODAL);
			primaryStage.initOwner(swMainMain.rootStage);
			Scene scene = new Scene(popRoot);
			primaryStage.setTitle("anotherWordBook");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private LvocaService service;
	ObservableList<VocaVO> vocaList = FXCollections.observableArrayList();
	ObservableList<LvocaVO> lvocaList = FXCollections.observableArrayList();

	@FXML
	void initialize() {
		assert vocaTable != null : "fx:id=\"vocaTable\" was not injected: check your FXML file 'wordMain.fxml'.";
		assert chkCol != null : "fx:id=\"chkCol\" was not injected: check your FXML file 'wordMain.fxml'.";
		assert vocaNameCol != null : "fx:id=\"vocaNameCol\" was not injected: check your FXML file 'wordMain.fxml'.";
		assert dayCol != null : "fx:id=\"dayCol\" was not injected: check your FXML file 'wordMain.fxml'.";
		assert btnLearn != null : "fx:id=\"btnLearn\" was not injected: check your FXML file 'wordMain.fxml'.";
		assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'wordMain.fxml'.";
		assert btnExcelOut != null : "fx:id=\"btnExcelOut\" was not injected: check your FXML file 'wordMain.fxml'.";
		assert btnWordBookAdd != null : "fx:id=\"btnWordBookAdd\" was not injected: check your FXML file 'wordMain.fxml'.";
		assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'wordMain.fxml'.";

		// service 객체 생성
		service = LvocaService.getInstance();

		// 컬럼설정
		vocaNameCol.setCellValueFactory(new PropertyValueFactory<>("lvoca_name"));
		dayCol.setCellValueFactory(new PropertyValueFactory<>("lvoca_date"));

		// TableView에 데이터 설정
		lvocaList.clear();
		lvocaList.addAll(service.getAllVoca());
		vocaTable.setItems(lvocaList);

	}

	// alert
	public void alert(String msg) {
		Alert alertWarning = new Alert(AlertType.WARNING);
		alertWarning.setTitle("경고");
		alertWarning.setContentText(msg);
		alertWarning.showAndWait();
	}

}
