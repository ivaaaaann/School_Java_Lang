package kr.hs.dgsw.java.dept1.prompt;

import java.io.File;

public class CommandCd extends AbstractCommand {

	public CommandCd(File currentDirectory, String commandLine) {
		super(currentDirectory, commandLine);
	}

	@Override
	public File executeCommand() {
		File file =  new File(currentDirectory+"\\"+ commandLine.substring(3)+"\\");
		if(file.exists()) {
			return file;
		}
		else {
			System.out.println("cannot find the path");
			return currentDirectory;
		}	
	}
}