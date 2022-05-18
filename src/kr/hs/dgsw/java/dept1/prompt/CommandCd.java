package kr.hs.dgsw.java.dept1.prompt;

import java.io.File;

public class CommandCd extends AbstractCommand {

	public CommandCd(File currentDirectory, String commandLine) {
		super(currentDirectory, commandLine);
	}

	@Override
	public File executeCommand() {
		String sign = commandLine.substring(3);
		String path = currentDirectory.getAbsolutePath();
		
		
		if(sign.equals("..")) {
			
			String folderName = path.substring(path.lastIndexOf("\\") + 1);
			String address=  path.replace(folderName, "");
			File file = new File(address);
			
			if(folderName != "") {
				return file;
			}
			else {
				System.out.println("cannot find the path");
				return currentDirectory;
			}
			
		}
		else {
			File file =  new File(path+"\\"+ sign +"\\");
			
			if(file.exists()) {
				return file;
			}
			else {
				System.out.println("cannot find the path");
				return currentDirectory;
			}	
		}
	}
}