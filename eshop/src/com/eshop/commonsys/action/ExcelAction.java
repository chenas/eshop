package com.eshop.commonsys.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;

import com.base.framwork.action.BaseAction;
import com.eshop.model.ProductInfoModel;
import com.eshop.service.IProductInfoService;
import com.eshop.service.file.IExcelService;

/**
 * 上传excel并提取内容
 * @author chenas
 *
 */
public class ExcelAction extends BaseAction {
	
	@Resource
	private IExcelService excelService;

	@Resource
	private IProductInfoService productInfoService;
	
	//excel表格
	private File fileExcel;
	private String fileExcelFileName;
	private String fileExcelContentType;

	public String excelContent() throws IOException{
		//得到本工程下的/excels目录
		String targetDir = ServletActionContext.getServletContext().getRealPath("/excel");
		//在指定的目录创建文件
		File target = new File(targetDir, fileExcelFileName);
		//把上传的文件存进项目文件夹
		FileUtils.copyFile(fileExcel, target);
		
		List<ProductInfoModel> productInfoModels = new ArrayList<ProductInfoModel>();
		
		Workbook workbook = excelService.getWorkbook(fileExcel);
		Sheet sheet = workbook.getSheetAt(0);
		int rowNum = sheet.getLastRowNum();
		for(int i=1; i<=rowNum; i++){
			Row row = sheet.getRow(i);
			ProductInfoModel productInfoModel = new ProductInfoModel();
			productInfoModel.setProductid(excelService.getStrValue(row.getCell(0)));
			productInfoModel.setName(excelService.getStrValue(row.getCell(1)));
			productInfoModel.setPrice(excelService.getDoubleValue(row.getCell(2)));
			productInfoModel.setInprice(excelService.getDoubleValue(row.getCell(3)));
			productInfoModel.setRemainNumber(excelService.getIntValue(row.getCell(4)));
			productInfoModel.setImageBig(excelService.getStrValue(row.getCell(5)));
			productInfoModel.setDescription(excelService.getStrValue(row.getCell(6)));
			productInfoModel.setKeyword(excelService.getStrValue(row.getCell(7)));
			productInfoModels.add(productInfoModel);
		}
		for(int i=0; i<productInfoModels.size(); i++){
			productInfoService.insertEntity(productInfoModels.get(i), null);
		}
		log.info(workbook);
		System.out.println(workbook.getSheetAt(0).getRow(0).getCell(0).getStringCellValue());
		return SUCCESS;
	}

	public File getFileExcel() {
		return fileExcel;
	}

	public void setFileExcel(File fileExcel) {
		this.fileExcel = fileExcel;
	}

	public String getFileExcelFileName() {
		return fileExcelFileName;
	}

	public void setFileExcelFileName(String fileExcelFileName) {
		this.fileExcelFileName = fileExcelFileName;
	}

	public String getFileExcelContentType() {
		return fileExcelContentType;
	}

	public void setFileExcelContentType(String fileExcelContentType) {
		this.fileExcelContentType = fileExcelContentType;
	}
	
}
