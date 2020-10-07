package ru.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isEndless = args.length != 0 && args[0].equals("endless");
        String readLine;
        do {
            try {
                System.out.println("------------------");
                System.out.println("Введите выражение:");
                readLine = reader.readLine();
                if (readLine.equals("exit"))
                    break;
                Calculator calculator = new Calculator(readLine);
                System.out.println(calculator.countedResultAsString());
                if (!isEndless)
                    break;
            } catch (Exception e) {
                System.out.print("Ошибка:   ");
                System.out.println(e.getMessage());
                if (!isEndless)
                    break;
            }
        }
        while (true);
    }
}
