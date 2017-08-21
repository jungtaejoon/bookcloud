package bookcloud.service;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import bookcloud.dto.ForTax;

@Component
public class XlsView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		final int TAX_YEAR = Integer.parseInt(request.getParameter("tYear"));
		final int TAX_MONTH	= Integer.parseInt(request.getParameter("tMonth"));

		response.setHeader("Content-Disposition", "attachment; filename=\"Bookcloud " + TAX_YEAR + String.format("%02d", TAX_MONTH) + " invoice.xls\"");
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(TAX_YEAR, TAX_MONTH - 1, 1); 
		final int LAST_DAY_OF_THE_MONTH = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		@SuppressWarnings("unchecked")
		List<ForTax> list = (List<ForTax>)model.get("list");
		
        Sheet sheet = workbook.createSheet("책구름 계산서");
        
        int rowCount = 6;
        for(ForTax tax : list) {
        	
            Row taxRow = sheet.createRow(rowCount++);
            taxRow.createCell(0).setCellValue("05");
            taxRow.createCell(1).setCellValue(Integer.toString(TAX_YEAR) + String.format("%02d", TAX_MONTH) + Integer.toString(LAST_DAY_OF_THE_MONTH));
            taxRow.createCell(2).setCellValue(tax.getPubNum());
            taxRow.createCell(4).setCellValue(tax.getPubName());
            taxRow.createCell(5).setCellValue(tax.getPubCeo());
            taxRow.createCell(6).setCellValue(tax.getPubAddress());
            taxRow.createCell(7).setCellValue(tax.getWorkStyle());
            taxRow.createCell(8).setCellValue(tax.getWorkType());
            taxRow.createCell(9).setCellValue(tax.getPubEmail());
            taxRow.createCell(10).setCellValue(tax.getBsnum());
            taxRow.createCell(12).setCellValue(tax.getName());
            taxRow.createCell(13).setCellValue(tax.getCeo());
            taxRow.createCell(14).setCellValue(tax.getAddress());
            taxRow.createCell(17).setCellValue(tax.getEmail());
            taxRow.createCell(19).setCellValue(tax.getTaxPrice());
            taxRow.createCell(21).setCellValue(LAST_DAY_OF_THE_MONTH);
            taxRow.createCell(22).setCellValue("도서판매");
            taxRow.createCell(24).setCellValue(1);
            taxRow.createCell(26).setCellValue(tax.getTaxPrice());
            taxRow.createCell(53).setCellValue(tax.getYc().equals("영수") ? "01" : "02");
        }
		
	}

}
