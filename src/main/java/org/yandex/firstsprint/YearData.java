package org.yandex.firstsprint;

/**
 * @implNote Класс для хранения данных из таблицы годового отчета
 */

public class YearData {
    int month;
    double amount;
    boolean isExpense;

    public YearData(int month, double amount, boolean isExpense){
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
    }
}
