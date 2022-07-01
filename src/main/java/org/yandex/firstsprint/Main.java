package org.yandex.firstsprint;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean continueFlg = true;
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        int monthStart = 1;
        int monthCount = 3;
        int yearToWatch = 2022;

        System.out.println("""
                Доступные команды:\s
                1. Считать все месячные отчеты
                2. Счиатать годовой отчет
                3. Сверить отчеты
                4. Вывести информацию о всех месячных отчетах
                5. Вывести информацию о годовом отчете
                0. Для выхода из программы
                """);

        System.out.println("Введите код команды:");

        while(continueFlg){
            if(scanner.hasNextInt()){
                int userInput = scanner.nextInt();

                switch (userInput) {
                    case 1 -> {
                        System.out.println("Считать все месячные отчеты...");
                        for (int i = monthStart; i <= monthCount; i++) {
                            String formattedMonth = String.format("%02d", i);
                            String result = ParseData.readFileContent("data/m." +
                                    yearToWatch + formattedMonth + ".csv");
                            if (result != null) {
                                monthlyReport.addMonth(i, ParseData.parseMonthFileContent(result));
                            }
                        }
                    }
                    case 2 -> {
                        System.out.println("Счиатать годовой отчет...");
                        String result = ParseData.readFileContent("data/y."+yearToWatch+".csv");
                        if(result != null){
                            yearlyReport.addYear(yearToWatch, ParseData.parseYearFileContent(result));
                        }
                    }
                    case 3 -> System.out.println("Сверить отчеты...");
                    case 4 -> {
                        System.out.println("Вывести информацию о всех месячных отчетах...");
                        monthlyReport.analyzeReports();
                    }
                    case 5 -> {
                        System.out.println("Вывести информацию о годовом отчете...");
                        yearlyReport.analyzeReports();
                    }
                    case 0 -> {
                        continueFlg = false;
                        System.out.println("Выход из программы...");
                    }
                    default -> System.out.println("Неизвестный код команды!");
                }

            }
            else{
                System.out.println("Введите корректный код команды!");
                scanner.next();
            }
        }
    }
}