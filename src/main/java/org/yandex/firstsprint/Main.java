package org.yandex.firstsprint;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Доступные команды: \n" +
                "1. Считать все месячные отчеты\n" +
                "2. Счиатать годовой отчет\n" +
                "3. Сверить отчеты\n" +
                "4. Вывести информацию о всех месячных отчетах\n" +
                "5. Вывести информацию о годовом отчете\n" +
                "0. Для выхода из программы\n");

        System.out.println("Введите код команды:");

        boolean continueFlg = true;

        while(continueFlg){
            if(scanner.hasNextInt()){
                int userInput = scanner.nextInt();

                switch (userInput){
                    case 1:
                        System.out.println("Считать все месячные отчеты...");
                        String result = ParseData.readFileContent("data/m.202201.csv");
                        ParseData.parseFileContent(result);
                        break;

                    case 2:
                        System.out.println("Счиатать годовой отчет...");
                        break;

                    case 3:
                        System.out.println("Сверить отчеты...");
                        break;

                    case 4:
                        System.out.println("Вывести информацию о всех месячных отчетах...");
                        break;

                    case 5:
                        System.out.println("Вывести информацию о годовом отчете...");
                        break;

                    case 0:
                        continueFlg = false;
                        System.out.println("Выход из программы...");
                        break;

                    default:
                        System.out.println("Неизвестный код команды!");
                        break;
                }

            }
            else{
                System.out.println("Введите корректный код команды!");
                scanner.next();
            }
        }
    }
}