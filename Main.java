package com.company;

import java.awt.*;
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
                if (maxNegative == 0 && arrayNumbers[i][j] < maxNegative) maxNegative = arrayNumbers[i][j];
                else if (Math.abs(arrayNumbers[i][j]) < Math.abs(maxNegative) && arrayNumbers[i][j] < 0)  {
                    maxNegative = arrayNumbers[i][j];
                }

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

    enum task4Answers {
        Equal,
        SecondCircleNested,
        FirstCircleNested,
        Contact1Point,
        Contact2Points,
        NoContact
    }

    public static task4Answers task4(int x1, int y1, int r1, int x2, int y2, int r2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));

        if(distance == 0 && r1 == r2) return task4Answers.Equal;
        else if(r1 >= r2 + distance) return task4Answers.SecondCircleNested;
        else if(r2 >= r1 + distance) return task4Answers.FirstCircleNested;
        else if(distance == r1 + r2) return task4Answers.Contact1Point;
        else if(distance < r1 + r2) return task4Answers.Contact2Points;
        else return task4Answers.NoContact;
    }

    public static double countArea(double[] arguments, double[] values) {
        double area = 0, base = arguments[1] - arguments[0];
        for (double value : values) {
            area += base * value;
        }
        return area;
    }

    static void task6Test(int from, int to) {
        System.out.print("\nTask6\n\n");
        final double ACCURACITY = 100;
        final int SIZE = 100;
        double step = (to - from) / ACCURACITY;
        double [] Arguments = new double[SIZE];
        double [] Values = new double[SIZE];
        double argument = from;
        System.out.print("+-----------+----------------------------+\n");
        System.out.print("|     X     |       y(x)                 |\n");
        System.out.print("+-----------+----------------------------+\n");
        for (int i = 0; i < SIZE; i++) {
            Arguments[i] = argument;
            Values[i] = Math.exp(argument) - Math.pow(argument, 3);
            String argRound = String.format("%.5f", Arguments[i]);
            String funRound = String.format("%.7f", Values[i]);
            String result = String.format("| %-10s | %-25s |\n", argRound, funRound);
            System.out.print(result);
            argument = argument + step;
        }
        System.out.print("+-----------+----------------------------+\n");
        double areaArrays = countArea(Arguments, Values);
        System.out.print("\nПлощадь по массивам: " + Math.abs(areaArrays));
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
        System.out.print("\n\nTask 8");
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
        Pattern p = Pattern.compile("(([+]7|8)(-| |)?(\\d{3}|[(]\\d{3}[)])(-| |)?\\d{3}(-| |)?\\d{2}(-| |)?\\d{2})|(2|3)(-| |)?\\d{2}(-| |)?\\d{2}(-| |)?\\d{2}");
        String text = "Мои номера 220-30-40 и 8904-378-16-61 не считая служебных";
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
        task6Test(0, 4);

        task7(29, 2);

        task8(3, 2);

        task9();

    }
}
