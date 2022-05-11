package kr.hs.dgsw.java.dept1.prompt;

import java.io.File;

public class CommandLs extends AbstractCommand {

	public CommandLs(File currentDirectory, String commandLine) {
		super(currentDirectory, commandLine);
	}

	@Override
	public File executeCommand() {
		
	
		File dir =  new File(currentDirectory+"");
		
		File[] listFiles = dir.listFiles();
		
		for(File file : listFiles) {
			System.out.println(file.getName());
		}
		
		return currentDirectory;
	}
	
}