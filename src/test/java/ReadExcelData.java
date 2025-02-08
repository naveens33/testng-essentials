import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelData {
    public static String[][] getData() throws IOException {
        FileInputStream file = new FileInputStream(new File("C:\\Users\\Me\\IdeaProjects\\testng-essentials\\src\\test\\java\\TestData.xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheet("NewBiller");
        System.out.println(sheet.getLastRowNum());
        System.out.println(sheet.getRow(0).getLastCellNum());
        String[][] data = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for(int i=0;i<sheet.getLastRowNum();i++){
            for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return data;
    }
//    public static void main(String[] args) throws IOException {
//        String[][] data = getData();
//        for(int i=0;i<data.length;i++){
//            for(int j=0;j<data[i].length;j++){
//                System.out.print(data[i][j]+" ");
//            }
//            System.out.println();
//        }
//    }
}
