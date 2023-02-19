package duke.storage;

import duke.Duke;
import duke.command.Command;
import duke.tasklist.TaskList;
import duke.ui.Ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {

    public static void doEditFile(String path) throws IOException {
        File fileName = new File(path);
        FileWriter savedFile = new FileWriter(fileName, false);
        for (int index = 0; index < Duke.taskCount; index++) {
            savedFile.write(TaskList.retrieveTask(index));
            savedFile.write(System.getProperty("line.separator"));
        }
        savedFile.write(System.getProperty("line.separator"));
        savedFile.close();
    }

    public static void openFile(String path) {
        try {
            File fileName = new File(path);
            if (fileName.createNewFile()) {
                Ui.printFileCreated(true);
            } else printFile(fileName);
        } catch (IOException e) {
            Ui.printFileCreated(false);
        } catch (IndexOutOfBoundsException e) {
            Ui.printIncorrectTaskFormat();
        }
    }

    private static void printFile(File fileName) throws FileNotFoundException {
        Scanner s = new Scanner(fileName);
        if (!s.hasNext()) {
            Ui.printEmptyFile();
        } else Ui.printFileContents(s);
        extractData(fileName);
    }

    public static void extractData(File fileName) throws FileNotFoundException {
        Scanner s = new Scanner(fileName);
        int count = 1;
        while (s.hasNext()) {
            Duke.toPrint = false;
            String currentLine = s.nextLine();
            String userCommand = currentLine.substring(4);
            TaskList.handleUserCommand(userCommand);
            String markStatus = currentLine.substring(0, 4);
            if (markStatus.equals("[X] ")) {
                Command.doCommandMark(count);
            } else if (!markStatus.equals("[ ] ")) {
                Ui.printIncorrectTaskFormat();
            }
            count++;
        }
        Duke.toPrint = true;
    }
}