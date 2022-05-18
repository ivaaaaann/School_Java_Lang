package kr.hs.dgsw.java.dept1.prompt;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommandLs extends AbstractCommand {

	public CommandLs(File currentDirectory, String commandLine) {
		super(currentDirectory, commandLine);
	}

	public String fileSizeTransform (long fileSize) {
				
			String Byte = "B";
			
			if(fileSize > 1024) {
				fileSize /= 1024;
				Byte = "KB";
			}
			if(fileSize > 1024) {
				fileSize /= 1024;
				Byte = "MB";
			}
			if(fileSize > 1024) {
				fileSize /= 1024;
				Byte = "GB";
			}
			return fileSize + Byte;
		
		}
				
	@Override
	public File executeCommand() {
		
	
		File dir =  new File(currentDirectory+"");
		File[] listFiles = dir.listFiles();
		
		for(File file : listFiles) {
			long modifiedTime = file.lastModified();
			Date unixModifiedTime = new Date(modifiedTime);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String validModifiedDate = dateFormat.format(unixModifiedTime);
			String division = file.isFile() ? "     " : "<DIR>";
			String size = fileSizeTransform(file.length()); 
			
			if(division == "<DIR>") {
				size = " ";
			}
			
			System.out.println(validModifiedDate + "  " + division + " " +  size  + " " + file.getName());
		}
			
		
		return currentDirectory;
	}
	
}