package test.com.treats.euc.services;


import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.ByteArrayOutputStream;


import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;





public class ExceltoByte {

	public ArrayList<Object[]> getTableData(){
        ArrayList<Object[]> tableDataList = null;
        
        tableDataList = new ArrayList<Object[]>();
        
        Object[] objArray = new Object[4];
        objArray[0] = "CounterParty Acronym";
        objArray[1] = "CounterParty Short Name";
        objArray[2] = "Deal Number";
        objArray[3] = "Value Date";
        tableDataList.add(objArray);
        Object[] objArray1 = new Object[4];
        objArray1[0] = "AAAAAAA";
        objArray1[1] = "AA BANK";
        objArray1[2] = "SPT181009999";
        objArray1[3] = "31May2018";
        tableDataList.add(objArray1);
            
        return tableDataList;
    }
	
	public void doExport(ArrayList<Object[]> dataList){
        /*if(dataList != null && !dataList.isEmpty()){*/
        	System.out.println("Exporting...");
            HSSFWorkbook workBook = new HSSFWorkbook();
            HSSFSheet sheet = workBook.createSheet();
            
            /*if(dataList != null && !dataList.isEmpty()){*/
	            short rowNo = 0;
	            for (Object[] objects : dataList) {
	                HSSFRow row = sheet.createRow(rowNo);
	                row.createCell((short)0).setCellValue(objects[0].toString());
	                row.createCell((short)1).setCellValue(objects[1].toString());
	                row.createCell((short)2).setCellValue(objects[2].toString());
	                row.createCell((short)3).setCellValue(objects[3].toString());
	                rowNo++;
	            }
            /*}*/
             
            
            /*String file = "D:/Hackathon/test.xls";*/
            try{
                /*FileOutputStream fos = new FileOutputStream(file);
                workBook.write(fos);
                fos.flush();*/
            	System.out.println("Converting Excel to Byte...");
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                workBook.write(baos);
                byte[] xls = baos.toByteArray();
                System.out.println("Printing Byte...");
                System.out.println(xls);
                workBook.close();
                
                
              
                
            /*}catch(FileNotFoundException e){
                e.printStackTrace();
                System.out.println("Invalid directory or file not found");*/
            }catch(IOException e){
                e.printStackTrace();
                System.out.println("Error occurred while writting excel file to directory");
            }
        /*}*/
    }
    
	
	
	public static void main(final String[] args) throws IOException {
		ExceltoByte exceltoByte = new ExceltoByte();
        ArrayList<Object[]> dataList = exceltoByte.getTableData();
        if(dataList != null && dataList.size() > 0){
        	System.out.println("Printing dataList:");
        	System.out.println(dataList);
        	exceltoByte.doExport(dataList);
        	System.out.println("Byte is generated from Excel");
        	//detecting the file type
		    /*  BodyContentHandler handler = new BodyContentHandler();
		      
		      Metadata metadata = new Metadata();
		      FileInputStream inputstream = new FileInputStream(new File(
		    		  "D:/Hackathon/test.xlsx"));
		      
		      ParseContext pcontext = new ParseContext();

	      
		    //OOXml parser
		      /*OOXMLParser  msofficeparser = new OOXMLParser (); */
		    /*  OfficeParser msofficeparser = new OfficeParser();
		      msofficeparser.parse(inputstream, handler, metadata,pcontext);
		      System.out.println("Contents of the document:" + handler.toString());
		      System.out.println("Metadata of the document:");
		      String[] metadataNames = metadata.names();

		      for(String name : metadataNames) {
		         System.out.println(name + ": " + metadata.get(name));
		      }
		      System.out.println("SUCCESSFUL!");*/
        }else{
            System.out.println("There is no data available in the table to export");
        }
    }
	

}
