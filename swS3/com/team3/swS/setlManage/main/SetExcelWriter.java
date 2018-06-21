package team3.swS.setlManage.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import team3.swS.charge.vo.ChargeVO;
import team3.swS.voca.vo.VocaVO;

public class SetExcelWriter {
	
	public void xlsWiter(List<ChargeVO> list) {
        // 워크북 생성
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 워크시트 생성
        HSSFSheet sheet = workbook.createSheet();
        // 행 생성
        HSSFRow row = sheet.createRow(0);
        // 쎌 생성
        HSSFCell cell;
        
        // 헤더 정보 구성
        cell = row.createCell(0);
        cell.setCellValue("NO");
        
        cell = row.createCell(1);
        cell.setCellValue("날짜");
        
        cell = row.createCell(2);
        cell.setCellValue("마일리지 신청");
        
        cell = row.createCell(3);
        cell.setCellValue("승인여부");
        
        cell = row.createCell(4);
        cell.setCellValue("입금자명");
        
        cell = row.createCell(5);
        cell.setCellValue("은행명");
        
        cell = row.createCell(6);
        cell.setCellValue("회원번호");
        
        
        // 리스트의 size 만큼 row를 생성
        ChargeVO vo;
        for(int rowIdx=0; rowIdx < list.size(); rowIdx++) {
            vo = list.get(rowIdx);
            
            // 행 생성
            row = sheet.createRow(rowIdx+1);
            
            cell = row.createCell(0);
            cell.setCellValue(vo.getCmile_order_no());
            
            cell = row.createCell(1);
            cell.setCellValue(vo.getCmile_date());
            
            cell = row.createCell(2);
            cell.setCellValue(vo.getCmile_amount());
            
            cell = row.createCell(3);
            cell.setCellValue(vo.getCmile_appro());
            
            cell = row.createCell(4);
            cell.setCellValue(vo.getCmile_remit_name());
            
            cell = row.createCell(5);
            cell.setCellValue(vo.getCmile_remit_bank());
            
            cell = row.createCell(6);
            cell.setCellValue(vo.getCmile_mem_no());
            
        }
        
        // 입력된 내용 파일로 쓰기
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
        	new ExtensionFilter("All Files", "*.*")	
        );
        
        File selectedFile = fileChooser.showSaveDialog(null);
        if(selectedFile != null) {
        	System.out.println(selectedFile.getPath());
        }
        
        File file = new File(selectedFile.getPath() + ".xls");
        
        FileOutputStream fos = null;
        
        try {
            fos = new FileOutputStream(file);
            workbook.write(fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(workbook!=null) workbook.close();
                if(fos!=null) fos.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void xlsxWiter(List<ChargeVO> list) {
        // 워크북 생성
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 워크시트 생성
        XSSFSheet sheet = workbook.createSheet();
        // 행 생성
        XSSFRow row = sheet.createRow(0);
        // 쎌 생성
        XSSFCell cell;
        
        // 헤더 정보 구성
        cell = row.createCell(0);
        cell.setCellValue("NO");
        
        cell = row.createCell(1);
        cell.setCellValue("날짜");
        
        cell = row.createCell(2);
        cell.setCellValue("마일리지 신청");
        
        cell = row.createCell(3);
        cell.setCellValue("승인여부");
        
        cell = row.createCell(4);
        cell.setCellValue("입금자명");
        
        cell = row.createCell(5);
        cell.setCellValue("은행명");
        
        cell = row.createCell(6);
        cell.setCellValue("회원번호");
        
        // 리스트의 size 만큼 row를 생성
        ChargeVO vo;
        for(int rowIdx=0; rowIdx < list.size(); rowIdx++) {
            vo = list.get(rowIdx);
            
            // 행 생성
            row = sheet.createRow(rowIdx+1);
            
            cell = row.createCell(0);
            cell.setCellValue(vo.getCmile_order_no());
            
            cell = row.createCell(1);
            cell.setCellValue(vo.getCmile_date());
            
            cell = row.createCell(2);
            cell.setCellValue(vo.getCmile_amount());
            
            cell = row.createCell(3);
            cell.setCellValue(vo.getCmile_appro());
            
            cell = row.createCell(4);
            cell.setCellValue(vo.getCmile_remit_name());
            
            cell = row.createCell(5);
            cell.setCellValue(vo.getCmile_remit_bank());
            
            cell = row.createCell(6);
            cell.setCellValue(vo.getCmile_mem_no());
            
        }
        
        // 입력된 내용 파일로 쓰기
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
        	new ExtensionFilter("All Files", "*.*")	
        );
        
        File selectedFile = fileChooser.showSaveDialog(null);
        if(selectedFile != null) {
        	System.out.println(selectedFile.getPath());
        }
        
        File file = new File(selectedFile.getPath()+ ".xlsx");
        
        FileOutputStream fos = null;
        
        try {
            fos = new FileOutputStream(file);
            workbook.write(fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(workbook!=null) workbook.close();
                if(fos!=null) fos.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
