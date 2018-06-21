package team3.swS.purchs.main;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import team3.swS.common.Session;
import team3.swS.memJoin.vo.MemberJoinVo;
import team3.swS.productManage.vo.ProdVO;
import team3.swS.purchs.service.OrdersService;
import team3.swS.purchs.vo.OrdersVO;

public class buyBoardController {

//	ProdVO prodVo=new ProdVO();
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnBuy;

	@FXML
	private Button btnCancel;

	@FXML
	private RadioButton radio1M;

	@FXML
	private ToggleGroup mileage;

	@FXML
	private RadioButton radio3M;

	@FXML
	private RadioButton radio6M;

	@FXML
	private RadioButton radio12M;

	@FXML
	private RadioButton radio24M;

	@FXML
	private RadioButton radioAll;

	@FXML
	private TextArea txtANotice;

	@FXML
	void btnBuy(ActionEvent event) {
		/*
		 * 세션에서 정지일자를 받아와서 오늘 날짜와 비교를 해서 오늘 날짜와 같거나 옛날이면 오늘 날짜로 업데이트 한다 오늘 날짜보다 미래에
		 * 정지된다면 그냥 별다른 작업없이 진행한다
		 */
		MemberJoinVo memVo = Session.memJoin; // 로그인한 세션저장

		SimpleDateFormat date2 = new SimpleDateFormat("yyMMdd");// 포맷
		Date date = new Date();// 오늘날짜
		int curruntTime = 0; // time - 현재시간 담을 곳
		int resultDiffTime = 0; // 두 시간의 차이를 저장할 곳

		int memEndday = (Integer.parseInt(memVo.getMem_endday())); // 멤버의 정지일자를 인트화

		curruntTime = (Integer.parseInt(date2.format(date))); // 현재 시간을 인트화
		resultDiffTime = memEndday - curruntTime;
		String strDay =String.valueOf(curruntTime);
		if (resultDiffTime <= 0) {	memVo.setMem_endday("" + curruntTime);	}
		String mile = mileage.getSelectedToggle().getUserData().toString();

		int num = mileageTot - Integer.parseInt(mile);

		String str = String.valueOf(num);

		memVo.setMem_mileage(str);
		memVo.setMem_no(memVo.getMem_no());

		String endday = "";
		try {
			endday = Session.memJoin.getMem_endday();

			System.out.println(Session.memJoin.getMem_id());
			System.out.println(Session.memJoin.getMem_endday());
			System.out.println(Session.memJoin.getMem_mileage());
			System.out.println("endday 생성에 성공했습니다");
			System.out.println(endday);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("endday 생성에 실패했습니다");
		}
		
		List<ProdVO> list=service.getDate();
		
		
			int ADD1 =Integer.parseInt(list.get(0).getVoucher_date());
			
			int ADD3 = Integer.parseInt(list.get(1).getVoucher_date());
			int ADD6 = Integer.parseInt(list.get(2).getVoucher_date());
			int ADD12 =Integer.parseInt(list.get(3).getVoucher_date());
			int ADD24 =Integer.parseInt(list.get(4).getVoucher_date());
			
			String name1=list.get(0).getVoucher_name();
			String name2=list.get(1).getVoucher_name();
			String name3=list.get(2).getVoucher_name();
			String name4=list.get(3).getVoucher_name();
			String name5=list.get(4).getVoucher_name();
			System.out.println(name1+name2+"========================================");
			
		
		int plusDay = 0;
		Calendar cal = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyMMdd");

		String month="";
		if (radio1M.isSelected()) {
			plusDay = ADD1;
			month=name1;
		} else if (radio3M.isSelected()) {
			plusDay = ADD3;
			month=name2;
		} else if (radio6M.isSelected()) {
			plusDay = ADD6;
			month=name3;
		} else if (radio12M.isSelected()) {
			plusDay = ADD12;
			month=name4;
		} else if (radio24M.isSelected()) {
			plusDay = ADD24;
			month=name5;
		}

		try {
			System.out.println();
			System.out.println();
			System.out.println(plusDay);
			System.out.println();
			System.out.println();
			Date date3 = df.parse(endday);
			cal.setTime(date3);

			cal.add(Calendar.DATE, plusDay);
			// cal.add(Calendar., amount);
			endday = df.format(cal.getTime());
			System.out.println(endday);

			memVo.setMem_endday(endday);

			int cnt = service.btnbuy(memVo);

			if (cnt > 0) {

				info("결제가 되었습니다 !");
			} else {
				info("결제실패!");
			}
			
			//
			Session.memJoin.getMem_no();
			OrdersVO ovo= new OrdersVO();
			
			ovo.setOrders_date(ovo.getOrders_date());
			ovo.setOrders_amount(str);
			ovo.setOrders_mem_no(memVo.getMem_no());
			ovo.setOrders_voucher_name(month);
			service.insertOrders(ovo);
			initialize();

		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("여기가 실패해");
		}

	}

	@FXML
	void btnCancel(ActionEvent event) {
		txtANotice.clear();
		txtANotice.setText(mileageMsg);
	}

	@FXML
	void radio1M(ActionEvent event) {
		txtANotice.clear();
		txtANotice.setText(mileageMsg + (mileageTot - 2000) + "마일리지가 남습니다.");

		if (mileageTot - 2000 < 0) {
			alert("금액이 부족합니다.");
			txtANotice.setText(mileageMsg + (mileageTot - 2000) + "마일리지가 부족합니다.");

		}
	}

	@FXML
	void radio3M(ActionEvent event) {
		txtANotice.clear();
		txtANotice.setText(mileageMsg + (mileageTot - 5000) + "마일리지가 남습니다.");
		if (mileageTot - 5000 < 0) {
			alert("금액이 부족합니다.");
			txtANotice.setText(mileageMsg + (mileageTot - 5000) + "마일리지가 부족합니다.");
		}
	}

	@FXML
	void radio6M(ActionEvent event) {
		txtANotice.clear();
		txtANotice.setText(mileageMsg + (mileageTot - 9500) + "마일리지가 남습니다.");
		if (mileageTot - 9500 < 0) {
			alert("금액이 부족합니다.");
			txtANotice.setText(mileageMsg + (mileageTot - 9500) + "마일리지가 부족합니다.");
		}
	}

	@FXML
	void radio12M(ActionEvent event) {
		txtANotice.clear();
		txtANotice.setText(mileageMsg + (mileageTot - 18000) + "마일리지가 남습니다.");
		if (mileageTot - 18000 < 0) {
			alert("금액이 부족합니다.");
			txtANotice.setText(mileageMsg + (mileageTot - 18000) + "마일리지가 부족합니다.");
		}
	}

	@FXML
	void radio24M(ActionEvent event) {
		txtANotice.clear();
		txtANotice.setText(mileageMsg + (mileageTot - 35000) + "마일리지가 남습니다.");
		if (mileageTot - 35000 < 0) {
			alert("금액이 부족합니다.");
			txtANotice.setText(mileageMsg + (mileageTot - 35000) + "마일리지가 부족합니다.");
		}
	}



	private int mileageTot = 0;
	String mileageMsg = "";

	private OrdersService service;

	@FXML
	void initialize() {
		assert btnBuy != null : "fx:id=\"btnBuy\" was not injected: check your FXML file 'buyBoard.fxml'.";
		assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'buyBoard.fxml'.";
		assert radio1M != null : "fx:id=\"radio1M\" was not injected: check your FXML file 'buyBoard.fxml'.";
		assert mileage != null : "fx:id=\"mileage\" was not injected: check your FXML file 'buyBoard.fxml'.";
		assert radio3M != null : "fx:id=\"radio3M\" was not injected: check your FXML file 'buyBoard.fxml'.";
		assert radio6M != null : "fx:id=\"radio6M\" was not injected: check your FXML file 'buyBoard.fxml'.";
		assert radio12M != null : "fx:id=\"radio12M\" was not injected: check your FXML file 'buyBoard.fxml'.";
		assert radio24M != null : "fx:id=\"radio24M\" was not injected: check your FXML file 'buyBoard.fxml'.";
		assert txtANotice != null : "fx:id=\"txtANotice\" was not injected: check your FXML file 'buyBoard.fxml'.";
		service = OrdersService.getInstance();
		List<ProdVO> list = service.getDate();
		mileageTot = Integer.parseInt(Session.memJoin.getMem_mileage());
		mileageMsg = "\n\n현재 회원님은,\n" + mileageTot + " 마일리지를 보유하고 있습니다.\n\n";
		txtANotice.setText(mileageMsg);
		int amount1=Integer.parseInt( list.get(0).getVoucher_amount());
		int amount2=Integer.parseInt( list.get(1).getVoucher_amount());
		int amount3=Integer.parseInt( list.get(2).getVoucher_amount());
		int amount4=Integer.parseInt( list.get(3).getVoucher_amount());
		int amount5=Integer.parseInt( list.get(4).getVoucher_amount());
		
		radio1M.setText(list.get(0).getVoucher_name()+"\t"+list.get(0).getVoucher_amount());
		radio3M.setText(list.get(1).getVoucher_name()+"\t"+list.get(1).getVoucher_amount());
		radio6M.setText(list.get(2).getVoucher_name()+"\t"+list.get(2).getVoucher_amount());
		radio12M.setText(list.get(3).getVoucher_name()+"\t"+list.get(3).getVoucher_amount());
		radio24M.setText(list.get(4).getVoucher_name()+"\t"+list.get(4).getVoucher_amount());
		
		radio1M.setUserData(amount1);
		radio3M.setUserData(amount2);
		radio6M.setUserData(amount3);
		radio12M.setUserData(amount4);
		radio24M.setUserData(amount5);
		System.out.println(""+amount1+amount2+"---------------------------");
		if (mileageTot < amount1) {
			radio1M.setDisable(true);
			radio3M.setDisable(true);
			radio6M.setDisable(true);
			radio12M.setDisable(true);
			radio24M.setDisable(true);
		} else if (mileageTot < amount2) {
			radio1M.setDisable(false);
			radio3M.setDisable(true);
			radio6M.setDisable(true);
			radio12M.setDisable(true);
			radio24M.setDisable(true);
		} else if (mileageTot < amount3) {
			radio1M.setDisable(false);
			radio3M.setDisable(false);
			radio6M.setDisable(true);
			radio12M.setDisable(true);
			radio24M.setDisable(true);
		} else if (mileageTot < amount4) {
			radio1M.setDisable(false);
			radio3M.setDisable(false);
			radio6M.setDisable(false);
			radio12M.setDisable(true);
			radio24M.setDisable(true);
		} else if (mileageTot < amount5) {
			radio1M.setDisable(false);
			radio3M.setDisable(false);
			radio6M.setDisable(false);
			radio12M.setDisable(false);
			radio24M.setDisable(true);
		}

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

	public void resetMemEndday() {
		SimpleDateFormat date2 = new SimpleDateFormat("yymmdd");
		Date date = new Date();
		String time = date2.format(date);
		System.out.println(time);
		if (Session.memJoin.getMem_endday().equals(time)) {
			Session.memJoin.setMem_endday(time);
		}

	}
}
