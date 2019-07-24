package Demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class CreateWorkbook 
{
  @Test
  public void createworkbook() throws IOException
  {
	  XSSFWorkbook workbook = new XSSFWorkbook();
	  FileOutputStream out = new FileOutputStream(new File("DemoNewWB.xlsx"));
	  workbook.write(out);
	  out.close();
	  System.out.println("created");
  }
}
