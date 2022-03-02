package com.company;


import java.util.Scanner;

public class Main {

    public static void Task1 () {
        System.out.println("|Max Byte: \t\t" + Byte.MAX_VALUE + "\t\t\t\t\t\t\t|Min Byte: " + -Byte.MIN_VALUE);
        System.out.println("|Max Short: \t" + Short.MAX_VALUE + "\t\t\t\t\t|Min Short: " + -Short.MIN_VALUE);
        System.out.println("|Max Integer: \t" + Integer.MAX_VALUE + "\t\t\t\t\t|Min Integer: " + -Integer.MIN_VALUE);
        System.out.println("|Max Long: \t\t" + Long.MAX_VALUE + "\t\t\t|Min Long: " + -Long.MIN_VALUE);
        System.out.println("|Max Float: \t\t" + Float.MAX_VALUE + "\t\t\t|Min Float: " + -Float.MIN_VALUE);
        System.out.println("|Max Double: \t" + Double.MAX_VALUE + "\t\t|Min Double: " + -Double.MIN_VALUE);
    }

    public static Double Task2 (int[] array) {
        int temp = 1;
        int negative = 0;
        for (int item : array)
            if (item < 0) {
                temp *= item;
                negative++;
            }

        if (negative % 2 == 0)
            return Math.pow(temp, 1.0f / negative);

        return -Math.pow(-temp, 1.0f / negative);
    }

    public static String Task3(int R, int r, float x1, float x2) {
        double LengthToObject = Math.sqrt(Math.pow(x1 - x2, 2));
        if (LengthToObject > R) return "Не обнаружен";
        else if (LengthToObject <= R && LengthToObject > r) return "Обнаружен";
        else if (LengthToObject <= r) return "Тревога";
        return "Error";
    }

    public static void Task5(int number_10) {
        System.out.println("10: " + number_10);
        System.out.println("2: " + Integer.toBinaryString(number_10));
        System.out.println("8: " + Integer.toOctalString(number_10));
        System.out.println("16: " + Integer.toString(number_10, 64));
    }

    public static void Task6(int positionStart, int rows, int columns) {
        int positionChange = positionStart;
        System.out.print("\t");
        for (int i = 0; i < rows; i++)
            System.out.print(Integer.toHexString(i) + ' ');

        System.out.print('\n');
        for (int i = 0; i < columns; i++) {
            System.out.print(Integer.toHexString(positionChange) + '\t');
            for (int j = 0; j < rows; j++) {
                int change = (int) (positionStart + (i * 10) + j);
                System.out.print((char)change);
                positionChange = change;
                System.out.print(' ');
            }
            System.out.print('\n');
        }
    }

    public static void Task7(String str) {
        int CountLetters = 0;
        int LowerLetters = 0;
        int UpperCaseLetters = 0;
        int CountDigit = 0;
        int AnotherSymbols = 0;
        int AllSymbolsCount = str.length();

        for (int i = 0; i < str.length(); i++) {
            char sym = str.charAt(i);
            if (Character.isLetter(sym)) {
                CountLetters++;
                if (Character.isUpperCase(sym)) {
                    UpperCaseLetters++;
                } else LowerLetters++;
            }
//            if (sym >= 'A' && sym <= 'Z') { CountLetters++; UpperCaseLetters++; }
//            else if (sym >= 'a' && sym <= 'z') { CountLetters++; LowerLetters++; }
            else if (Character.isDigit(sym)) { CountDigit++; }
            else AnotherSymbols++;
        }
        System.out.println("Количество букв: " + CountLetters);
        System.out.println("Количество букв в нижнем регистре: " + LowerLetters);
        System.out.println("Количество букв в верхнем регистре: " + UpperCaseLetters);
        System.out.println("Количество арабских цифр: " + CountDigit);
        System.out.println("Количество других символов: " + AnotherSymbols);
        System.out.println("Всего символов: " + AllSymbolsCount);
    }

    public static int Task9(String str, String found) {
        int count = 0;
        int temp = 0;
        while((temp = str.indexOf(found, temp)) != -1) {
            temp++;
            count++;
        }
        return count;
    }

    public static void Task10(String str) {
        char[] strChars = str.toCharArray();
//        for (int i = 0; i < strChars.length; i++) {
//            char lastSymbol = strChars[strChars.length - 1];
//            for (int j = strChars.length - 1; j > 0; j--) {
//                strChars[j] = strChars[j - 1];
//            }
//            strChars[0] = lastSymbol;
//            for (char strChar: strChars) {
//                System.out.print(strChar);
//            }
//            for (int )
//            System.out.print("\n");
//        }
        for (int pos = 0; pos < strChars.length; pos++) {
            for (int i = pos; i < strChars.length; i++)
                System.out.print(strChars[i]);
            for (int j = 0; j < pos; j++)
                System.out.print(strChars[j]);
            System.out.println('\n');
        }
    }

    public static void main(String[] args) {
        //Task1
        System.out.println("\nЗадание 1:");
        Task1();

        //Task2
        System.out.println("\nЗадание 2:");
        int [] Array_for_first_task = {-1, -4, -2, 2, 3 ,5};
        System.out.println(Task2(Array_for_first_task));

        //Task3
        System.out.println("\nЗадание 3:");
        System.out.println(Task3(10, 5, 1.0f, 7.0f));

        //Task4
//        System.out.println("\nЗадание 4:");
//        Scanner scan = new Scanner(System.in);
//        System.out.print("Введите R: ");
//        int R = scan.nextInt();
//        System.out.print("Введите r: ");
//        int r = scan.nextInt();
//        System.out.println(Task3(R, r, 1.0f, 4.0f));

        //Task5
//        System.out.println("\nЗадание 5:");
//        System.out.println("Введите целое десятичное число: ");
//        int number_10 = scan.nextInt();
//        Task5(number_10);

        //Task6
        System.out.println("\nЗадание 6:");
        int start = 0x0400;
        Task6(start, 16, 16);

        //Task 7
        System.out.println("\nЗадание 7:" );
        Task7("aHello eorSOPfkld2519fmskmf902riomf akfm 90 af oaf9msf 9 k≤µ˚˜˜∫˙¥¨");

        //Task 8 ready

        //Task9
        System.out.println("\nЗадание 9:");
        System.out.println(Task9("aaaaaa", "aa"));

        //Task10
        System.out.println("\nЗадание 10:");
        Task10("abcd");
    }
}
d
