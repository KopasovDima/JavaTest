package ru.test.java;

public class Number {
    private final int value;
    private boolean isRoman;

    public Number(String number) throws Exception {
        int result;
        if (number.contains(".") || number.contains(","))
            throw new Exception("Дробные числа не поддерживаются");
        try {
            result = Integer.parseInt(number);
            this.isRoman = false;
        }
        catch (Exception e) {
            result = convertFromRoman(number);
            this.isRoman = true;
        }
        if (result == 0)
            throw new Exception("Число 0 не поддерживается");
        if (result > 10)
            throw new Exception("Значения больше 10 не поддерживаются");
        if (result < 0)
            throw new Exception("Отрицательные значения не поддерживаются");
        this.value = result;
    }

    public static String convertToString(int resultValue, boolean isRoman) {
        if (isRoman)
            return convertToRoman(resultValue);
        else
            return Integer.toString(resultValue);
    }

    public int getValue() {
        return value;
    }

    public boolean isRoman() {
        return isRoman;
    }

    private static int convertFromRoman(String romanString) throws Exception {
        int result = 0;
        for (int i = 0; i < romanString.length(); i++) {
            int s1 = intFromRomanChar(romanString.charAt(i));
            if (i + 1 < romanString.length()) {
                int s2 = intFromRomanChar(romanString.charAt(i + 1));
                if (s1 < s2) {
                    result = result + s2 - s1;
                    i++;
                } else
                    result = result + s1;
            } else {
                result = result + s1;
                i++;
            }
        }
        return result;
    }

    private static int intFromRomanChar(char r) throws Exception {
        switch (r) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            default:
                throw new Exception("'" + r + "' не поддерживается в римском варианте");
        }
    }

    private static String convertToRoman(int number) {
        String result = "";
        if (number < 0) {
            result += "В римских числах не предусмотрены отрицательные значения, но всё же: -";
            number *= -1;
        }
        if (number == 0)
            return "Я без понятия как отобразит 0 в римских символах";
        for (int i = Integer.toString(number).length(); i > 0; i--)
            result = result.concat(romanSymbolFromInt((int)(number%Math.pow(10, i) - number%Math.pow(10, i - 1))));
        return result;
    }

    private static String romanSymbolFromInt(int i) {
        switch (i) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";
            case 20:
                return "XX";
            case 30:
                return "XXX";
            case 40:
                return "XL";
            case 50:
                return "L";
            case 60:
                return "LX";
            case 70:
                return "LXX";
            case 80:
                return "LXXX";
            case 90:
                return "XC";
            case 100:
                return "C";
            default:
                return "";
        }
    }
}
