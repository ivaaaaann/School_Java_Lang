package kr.hs.dgsw.java.dept1.prompt;

import java.io.File;
import java.util.Scanner;

public class SimpleCommander {

	protected final Scanner scanner;

	protected File currentDirectory;

	public SimpleCommander() {
		this.scanner = new Scanner(System.in);
		this.currentDirectory = new File("C:/");
	}

	public void execute() {
		try {
			/* 시작 prompt */
			System.out.println("Simple commander started");

			/* Loop */
			AbstractCommand command = null;
			while (true) {
				/* Prompt */
				this.showPrompt();

				/* Command 등록 */
				try {
					command = receiveCommand();
				} catch (Exception e) {
					System.out.println("Invalid command");
					continue;
				}

				/* Command 수행 */
				this.currentDirectory = command.executeCommand();
				
				/* Exit 조건 검사 */
				if (command.isExitCondition()) {
					System.out.println("cannot find the path");
					break;
				}
			}

			/* 자원 회수 */
			this.scanner.close();

			/* 종료 prompt */
			System.out.println("Simple commander terminated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected AbstractCommand receiveCommand() throws UnknownCommandException {
		String line = this.scanner.nextLine();

		return AbstractCommand.build(this.currentDirectory, line);
	}

	protected void showPrompt() {
		StringBuilder buffer = new StringBuilder();

		String path = this.currentDirectory.getAbsolutePath();

		buffer.append(path);
		buffer.append("> ");

		System.out.print(buffer.toString());
	}

}