package org.sterl.katas.roman;

/**
 * https://ccd-school.de/coding-dojo/function-katas/from-roman-numerals/
 */
public class RomanConverter {

    public int convert(String romanNumber) {
        int result = 0;

        if (romanNumber != null) {
            result = convertRomanNumber(romanNumber.trim().toUpperCase());
        }

        return result;
    }

    private int convertRomanNumber(final String romanNumber) {
        int result = 0;
        int biggestRomanNumber = 0;
        System.err.println("*** " + romanNumber + " ***");
        for (int i = 0; i < romanNumber.length(); ++i) {
            final char c = romanNumber.charAt(i);
            final int romanCharValue = convertRomanCharToInt(c);
            // verify if we have a roman number which is increasing
            if (romanCharValue >= biggestRomanNumber) {
                biggestRomanNumber = romanCharValue;
                System.err.print("Adding: " + c + "(" + romanCharValue + ") total: " + result);
                result = addOrSubtractRomanCharValue(result, romanCharValue);
            } else {
                // otherwise we have to restart the conversion
                result += convertRomanNumber(romanNumber.substring(i, romanNumber.length()));
                break;
            }
        }
        return result;
    }

    private static int addOrSubtractRomanCharValue(int currentValue, final int romanValue) {
        if (currentValue < romanValue) {
            currentValue = romanValue - currentValue;
            System.err.println(" - subtract = " + currentValue);
        } else {
            currentValue += romanValue;
            System.err.println(" - add      = " + currentValue);
        }
        return currentValue;
    }

    private static int convertRomanCharToInt(char romanNumber) {
        return switch (romanNumber) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

}
