package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static void task1() {
        double start = Math.PI / 15;
        System.out.print("+-----------+------------------+-----------------+\n");
        System.out.print("|     X     | Sin(x)           | e^x/x*lg(x)     |\n");
        System.out.print("+-----------+------------------+-----------------+\n");
        for (double x = start; x <= Math.PI; x += Math.PI / 15) {
            String sinRound = String.format("%.7f", Math.sin(x));
            String funRound = String.format("%.7f", Math.exp(x) / (x * Math.log(x)));
            String argRound = String.format("%.5f", x);
            String result = String.format("| %-10s | %-15s | %-15s |\n", argRound, sinRound, funRound);
            System.out.print(result);
        }
        System.out.print("+-----------+------------------+-----------------+\n");
    }

    static void task2(int [][] arrayNumbers) {
        int maxNegative = 0;

        for (int i = 0; i < arrayNumbers.length; i++)
            for (int j = 0; j < arrayNumbers[i].length; j++)
                if (arrayNumbers[i][j] < maxNegative)  maxNegative = arrayNumbers[i][j];

        System.out.print("Max negative: " + maxNegative);
    }

    static int [] bubbleSort (int [] array) {
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length - i - 1; j++)
                if (array[j] > array[j+1]) {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
        return array;
    }

    static void task3(int [][] arrayNumber) {

        System.out.print("\nМатрица до сортровки: \n");
        for (int i = 0; i < arrayNumber.length; i++) {
            System.out.print("|");
            for (int j = 0; j < arrayNumber[i].length; j++)
                System.out.print(String.format("%3s ", arrayNumber[i][j]));
            System.out.print("| \n");
        }

        for (int i = 0; i < arrayNumber.length; i++)
            arrayNumber[i] = bubbleSort(arrayNumber[i]);

        System.out.print("\nМатрица после сортровки: \n");
        for (int i = 0; i < arrayNumber.length; i++) {
            System.out.print("|");
            for (int j = 0; j < arrayNumber[i].length; j++)
                System.out.print(String.format("%3s ", arrayNumber[i][j]));
            System.out.print("| \n");
        }
    }

    static String task4 (int x1, int y1, int r1, int x2, int y2, int r2) {
        double lengthBetweenCenterCircles = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        if (x1 == x2 && y1 == y2 && r1 == r2) {
            return "Совпадают";
        }
        else if (lengthBetweenCenterCircles < r1 + r2) return "Пересекаются в двух точках";
        else if (lengthBetweenCenterCircles == r1 + r2) return "Пересекаются в одной точке";
        else return "Не пересекаются";
    }

//    static Colors task5(String color) {
//        Colors ab = Colors.Blue;
//        if (ab instanceof Colors) {
//            System.out.print("Is here");
//        }
//    }

    static double integral(double a, double b, Function function) {
        double area = 0d;
        double h = 0.001d;

        for (int i = 0; i < (b - a) / h; i++)
            area += h * function.func(a + i*h);

        return area;
    }

//    static double CountIntegralFromArrays (double [] argumentsArray, double [] valuesArray) {
//        double area = 0d;
//        double h = 0.01d;
//        for (int i = 0; i < argumentsArray.length; i++) {
//            area += valuesArray[i] + i*h;
//        }
//        return area;
//    }

    interface Function {
        public double func (double x);
    }

    static void task6(int from, int undo) {
        System.out.print("Task6\n\n");
        double step = 1;
        double argument = from;
        double [] Arguments = new double[undo - from];
        double [] Values = new double[undo - from];

        System.out.print("+-----------+----------------------------+\n");
        System.out.print("|     X     |       y(x)                 |\n");
        System.out.print("+-----------+----------------------------+\n");
        for (int i = 0; i < undo - from; i++) {
            Arguments[i] = argument;
            Values[i] = Math.exp(argument) - Math.pow(argument, 3);
            String funRound = String.format("%.7f", Values[i]);
            String argRound = String.format("%.5f", argument);
            String result = String.format("| %-10s | %-25s |\n", argRound, funRound);
            System.out.print(result);
            argument += step;
        }
        System.out.print("+-----------+----------------------------+\n");
        double area = integral(from, undo, x1 -> { return (Math.exp(x1) - Math.pow(x1, 3)); });
//        double areaArrays = CountIntegralFromArrays(Arguments, Values);
        System.out.print("Площадь: " + area);
//        System.out.print("\nПлощадь по массивам: " + areaArrays);
    }

    static void task7(int number, int base) {
        System.out.println("\n\nTask7");
        String numberToBase = "";
        int baseTemp;
        int tempCurrentNumberForDivide = number;
        ArrayList<Integer> numbersToBase = new ArrayList<Integer>();
        while (tempCurrentNumberForDivide >= 1) {
            baseTemp = tempCurrentNumberForDivide % base;
            tempCurrentNumberForDivide = tempCurrentNumberForDivide / base;
            numbersToBase.add(0, baseTemp);
        }
        for (int num : numbersToBase) numberToBase += num;
        if (Integer.toString(number, base).equals(numberToBase)) System.out.println("Оба метода совпали!");
        System.out.println("new base number: " + numberToBase);
    }

    static void task8(int n, int x){
        int[] a = new int[n+1];

        for (int i = 0; i < a.length; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите целое число: ");
            if (!scanner.hasNextInt()) {
                System.out.println("error");
                break;
            }
            else a[i] = scanner.nextInt();
        }
        for (int i = n-2, P = a[n] * x + a[n - 1]; i!=0 ; i--, P = P * x + a[i])
            System.out.println(P);

    }

    static void task9() {
        Pattern p = Pattern.compile("(\\+7|8)(\\s|\\-|\\d|\\()\\d{3}(\\)\\s|\\d|\\s|\\-|\\))\\d{3}(\\s|\\-|\\d)(\\d)($|\\d|\\b)(\\d{2}|\\d\\s\\d{2}|$|\\-\\d{2}|\\s\\d{2}|\\d|\\b)");
        String text = "+79043781661 +7 904 378 1661 +7 904 378 16 61\n" +
                "+7-904-378-16-61 +7(904)3781661 +7(904) 378-16 61\n" +
                "89043781661 8 904 378-16-61\n" +
                "Круглыми скобками могут быть выделены тол";
        Matcher m = p.matcher(text);
        while (m.find()) {
            int begin = m.start();
            int end = m.end();
            System.out.println(text.substring(begin, end));
        }
    }

    public static void main(String[] args) {


        Colors as = Colors.Blue;
        task1();

        int [][] twoDimArray = {{5,-7,3,-17, -52}, {7,0,-1,12}, {-8,1,2,3, -23}};
        task2(twoDimArray);

        int [][] matrix3 = {{5,-7,3}, {7,0,-1}, {-8,1,2}};
        task3(matrix3);

        System.out.print(task4(0,0,1,3,3,2));
        task6(4, 8);

        task7(29, 2);

        task8(3, 2);

        task9();


    }
}
