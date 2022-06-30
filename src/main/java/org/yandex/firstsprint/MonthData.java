package org.yandex.firstsprint;

/**
 * @implNote Класс для хранения данных из таблицы месячного отчета
 */

public class MonthData {
    String itemName;
    boolean isExpense;
    long quantity;
    double sumOfOne;

    public MonthData(String itemName, boolean isExpense, long quantity, double sumOfOne){
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }
}
