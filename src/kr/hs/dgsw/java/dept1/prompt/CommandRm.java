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
			if(file.exists()) {
				System.out.print("정말로 삭제하시겠습니까? : ");
				String res = scanner.nextLine();
				if(res.equals("y")||res.equals("Y")) {
					file.delete();
				}
			}else {
				System.out.println("파일을 찾을 수 없습니다.");
			}
			
		} catch(UnknownCommandException e) {
			System.out.println("cannot find the file");
			throw e;
		} finally {
			return currentDirectory;			
		}
		
	}
	
}
