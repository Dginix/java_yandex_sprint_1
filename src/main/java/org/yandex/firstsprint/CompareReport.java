package org.yandex.firstsprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Сверка данных:
1. Подсчитывать две суммы: общие доходы и общие расходы по каждому ищ месяцев
2. Сверять полученные суммы с суммой доходов и расходов в отчете по году
Если обнаружена ошибка, программа должна выводить месяц, в котором обнаружено
несоответствие.
Если ошибок не обнаружено, должна выводиться только информация об успешном завершении
операции.
 */

public class CompareReport {
    public HashMap<Integer, ArrayList<MonthData>> dataMonth;
    public ArrayList<YearData> dataYear;
    public HashMap<Integer, HashMap<Boolean, Double>> dataSum;
    public CompareReport (HashMap<Integer, ArrayList<MonthData>> dataMonth, ArrayList<YearData> dataYear,
                          HashMap<Integer, HashMap<Boolean, Double>> dataSum){
        this.dataMonth = dataMonth;
        this.dataYear = dataYear;
        this.dataSum = dataSum;
    }
    public void getReport(){
        for(Map.Entry<Integer, HashMap<Boolean, Double>> entry : dataSum.entrySet()){
            for(YearData monthInYearData : dataYear){
                if(entry.getKey() == monthInYearData.month){
                    if(monthInYearData.isExpense && monthInYearData.amount != entry.getValue().get(true)){
                        System.out.println("отчеты не совпадают в месяце " + entry.getKey() +
                                " для расходов");
                    }
                    if(!monthInYearData.isExpense && monthInYearData.amount != entry.getValue().get(false)){
                        System.out.println("отчеты не совпадают в месяце " + entry.getKey() +
                                " для доходов");
                    }
                }
            }
        }
        System.out.println("Проверка завершена!");
    }
}
