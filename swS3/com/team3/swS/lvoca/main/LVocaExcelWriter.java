package team3.swS.lvoca.main;

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
import team3.swS.voca.vo.VocaVO;

public class LVocaExcelWriter {
	
	public void xlsWiter(List<VocaVO> list) {
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
        cell.setCellValue("단어번호");
        
        cell = row.createCell(1);
        cell.setCellValue("단어");
        
        cell = row.createCell(2);
        cell.setCellValue("뜻");
        
        cell = row.createCell(3);
        cell.setCellValue("등장빈도수");
        
        cell = row.createCell(4);
        cell.setCellValue("단어빈도수");
        
        cell = row.createCell(5);
        cell.setCellValue("단어장번호");
        
        cell = row.createCell(6);
        cell.setCellValue("파일이름");
        
        
        // 리스트의 size 만큼 row를 생성
        VocaVO vo;
        for(int rowIdx=0; rowIdx < list.size(); rowIdx++) {
            vo = list.get(rowIdx);
            
            // 행 생성
            row = sheet.createRow(rowIdx+1);
            
            cell = row.createCell(0);
            cell.setCellValue(vo.getVoca_no());
            
            cell = row.createCell(1);
            cell.setCellValue(vo.getVoca_word());
            
            cell = row.createCell(2);
            cell.setCellValue(vo.getVoca_mean());
            
            cell = row.createCell(3);
            cell.setCellValue(vo.getVoca_frequency());
            
            cell = row.createCell(4);
            cell.setCellValue(vo.getVoca_learn_freq());
            
            cell = row.createCell(5);
            cell.setCellValue(vo.getVoca_lvoca_no());
            
            cell = row.createCell(6);
            cell.setCellValue(vo.getVoca_name());
            
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
    
    public void xlsxWiter(List<VocaVO> list) {
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
        cell.setCellValue("단어번호");
        
        cell = row.createCell(1);
        cell.setCellValue("단어");
        
        cell = row.createCell(2);
        cell.setCellValue("뜻");
        
        cell = row.createCell(3);
        cell.setCellValue("등장빈도수");
        
        cell = row.createCell(4);
        cell.setCellValue("단어빈도수");
        
        cell = row.createCell(5);
        cell.setCellValue("단어장번호");
        
        cell = row.createCell(6);
        cell.setCellValue("파일이름");
        
        // 리스트의 size 만큼 row를 생성
        VocaVO vo;
        for(int rowIdx=0; rowIdx < list.size(); rowIdx++) {
            vo = list.get(rowIdx);
            
            // 행 생성
            row = sheet.createRow(rowIdx+1);
            
            cell = row.createCell(0);
            cell.setCellValue(vo.getVoca_no());
            
            cell = row.createCell(1);
            cell.setCellValue(vo.getVoca_word());
            
            cell = row.createCell(2);
            cell.setCellValue(vo.getVoca_mean());
            
            cell = row.createCell(3);
            cell.setCellValue(vo.getVoca_frequency());
            
            cell = row.createCell(4);
            cell.setCellValue(vo.getVoca_learn_freq());
            
            cell = row.createCell(5);
            cell.setCellValue(vo.getVoca_lvoca_no());
            
            cell = row.createCell(6);
            cell.setCellValue(vo.getVoca_name());
            
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
