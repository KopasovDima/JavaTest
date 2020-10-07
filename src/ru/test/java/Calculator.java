package ru.test.java;

import java.util.*;

public class Calculator {
    private static final List<String> supportedOperations = Arrays.asList("+", "-", "*", "/");
    private Number numberA;
    private Number numberB;
    private String operation;
    private int countedResult;

    Calculator(String initialString) throws Exception {
        if (initialString == null || initialString.length() == 0)
            throw new Exception("Не указана строка");
        initialString = initialString.toUpperCase();
        String[] parts = initialString.split(" ");
        if (parts.length != 3)
            throw new Exception("Неправильная строка");
        this.findOperation(parts[1]);
        this.findNumbers(parts[0], parts[2]);
        this.countResult();
    }

    private void findNumbers(String numberA, String numberB) throws Exception {
        Number tempNumberA = new Number(numberA);
        Number tempNumberB = new Number(numberB);
        if ((tempNumberA.isRoman() && !tempNumberB.isRoman()) || (!tempNumberA.isRoman() && tempNumberB.isRoman()))
            throw new Exception("Оба введённых числа должны быть либо арабскими, либо римскими одновременно");
        this.numberA = tempNumberA;
        this.numberB = tempNumberB;
    }

    private void findOperation(String part) throws Exception {
        if (!supportedOperations.contains(part))
            throw new Exception("Приведена неподдерживаемая операция: " + part);
        this.operation = part;
    }

    private void countResult() {
        switch (this.operation) {
            case "+":
                this.countedResult = this.numberA.getValue() + this.numberB.getValue();
                break;
            case "-":
                this.countedResult = this.numberA.getValue() - this.numberB.getValue();
                break;
            case "*":
                this.countedResult = this.numberA.getValue() * this.numberB.getValue();
                break;
            case "/":
                this.countedResult = this.numberA.getValue() / this.numberB.getValue();
        }
    }

    public String countedResultAsString() {
        return Number.convertToString(this.countedResult, this.numberA.isRoman());
    }
}
