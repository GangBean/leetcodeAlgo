package main;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class LeetcodeAlgoApplication {

    public static final String INPUT_PATH = "java/main/file/";

    public static final String PROBLEM_PATH = "main.problem._";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the problem number: ");
        String problemNumber = scanner.nextLine();

        String inputFilePath = INPUT_PATH + problemNumber + ".txt";
        File inputFile = new File(inputFilePath);

        if (!inputFile.exists()) {
            System.out.println("Input file does not exist: " + inputFilePath);
            return;
        }

        String problemClassName = PROBLEM_PATH + problemNumber;
        try {
            Class<?> problemClass = Class.forName(problemClassName);
            Object problemInstance = problemClass.getDeclaredConstructor().newInstance();
            problemClass.getMethod("test", File.class).invoke(problemInstance, inputFile);
        } catch (ClassNotFoundException e) {
            System.out.println("Input class does not exist: " + problemClassName);
            return;
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

}
