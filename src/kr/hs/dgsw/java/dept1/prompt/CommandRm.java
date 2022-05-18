package kr.hs.dgsw.java.dept1.prompt;

import java.io.File;

public class CommandRm extends AbstractCommand {
	
	public CommandRm(File currentDirectory, String commandLine) {
		super(currentDirectory, commandLine);
	}

	@Override
	public File executeCommand() throws UnknownCommandException {
	
		try {
			String fileName = commandLine.substring(3);
			String path = currentDirectory.getAbsolutePath();
			File file = new File(path + "\\" + fileName);
			file.delete();
		} catch(UnknownCommandException e) {
			System.out.println("cannot find the file");
			throw e;
		} finally {
			return currentDirectory;			
		}
		
	}
	
}
