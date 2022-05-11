package kr.hs.dgsw.java.dept1.d0504;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {

	public void copy(String src, String target) {
		try {
			File file = new File(src);
			File file2 = new File(target);
			
			InputStream is = new FileInputStream(file);
			OutputStream os = new FileOutputStream(file2);
			
			int fileByte = 0;
			
			while((fileByte = is.read()) != -1) { 
				os.write(fileByte);
			}
			
			is.close();
			os.close();
		
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		FileCopy fileCopy = new FileCopy();
		fileCopy.copy("C:\\Users\\DGSW\\Pictures\\Saved Pictures\\Camera Roll\\30_활집.jpg", 
					"C:\\Users\\DGSW\\Pictures\\Saved Pictures\\Camera Roll\\abc.jpg"
				);
		
	}

}
