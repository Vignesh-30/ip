package duke.ui;

import java.util.Scanner;

public class Ui {

    public static final String LINE = "\t____________________________________________________________";

    public static void printLine() {
        System.out.println(LINE);
    }

    public static void printInvalidNumber(String taskType) {
        printLine();
        System.out.println("\t☹ Error! Invalid input.");
        System.out.println("\tPlease provide a task number for \"" + taskType + "\" command.");
        System.out.println("\tPlease use \"list\" command to see your task numbers.");
        printLine();
    }

    public static void printEmptyCommand(String taskType) {
        printLine();
        System.out.println("\t☹ Error! \"" + taskType + "\" command cannot be empty.");
        System.out.println("\tPlease provide more details");
        printLine();
    }

    public static void printInvalidFormat(String taskType) {
        printLine();
        System.out.println("\t☹ Error! Invalid format for \"" + taskType + "\" command.");
        printLine();
    }

    public static void printEmptyFile() {
        printLine();
        System.out.println("\tSaved file is empty.");
        printLine();
    }

    public static void printIncorrectTaskFormat() {
        printLine();
        System.out.println("\t☹ Error! Tasks saved in incorrect format.");
        printLine();
    }

    public static void printFileCreated(boolean fileCreated) {
        if (fileCreated) {
            printLine();
            System.out.println("\tFile \"duke.txt\" created!");
            printLine();
        } else {
            printLine();
            System.out.println("\t☹ Error! Failed to create file.");
            printLine();
        }
    }

    public static void printGreetMessage() {
        printLine();
        System.out.println("\tHello! I'm Duke.");
        System.out.println("\tHow can I help you today?\n");
        printLine();
    }

    public static void printExitMessage() {
        printLine();
        System.out.println("\tBye! Remember to finish your tasks.\n");
        printLine();
    }

    public static void printInvalidCommand() {
        printLine();
        System.out.println("\t☹ Error! Please input a valid command!");
        printLine();
    }

    public static String getUserInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static void printFileContents(Scanner s) {
        printLine();
        System.out.println("\tHere are your stored tasks!");
        int index = 1;
        while (s.hasNext()) {
            System.out.println("\t" + index + ". " + s.nextLine());
            index++;
        }
        printLine();
    }
}