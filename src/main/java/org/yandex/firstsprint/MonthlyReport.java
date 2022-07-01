package org.yandex.firstsprint;

import java.lang.reflect.Array;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @implNote Создает отчет по месяцам из спарсенных до этого данных (вызывая специальный метод),
 * данные добавляются в хэш-мап
 */

public class MonthlyReport {
    public HashMap<Integer, ArrayList<MonthData>> data = new HashMap<>();
    public HashMap<Integer, HashMap<Boolean, Double>> dataSum = new HashMap<>();
    public HashMap<Integer, MonthReportData> resultReport = new HashMap<>();
    public void addMonth(int month, ArrayList<MonthData> monthDataList){
        data.put(month, monthDataList);
    }
    public void analyzeReports(){
        for(int month : data.keySet()){
            ArrayList<MonthData> currentMonthData = data.get(month);
            MonthReportData result = new MonthReportData();

            double sumIncome = 0;
            double sumExpense = 0;

            for(MonthData item : currentMonthData){
                if(!item.isExpense){
                    double valuable = item.quantity*item.sumOfOne;
                    if(valuable > result.maxValuable){
                        result.maxValuable = valuable;
                        result.maxValName = item.itemName;
                    }
                    sumIncome += valuable;
                }
                else{
                    double expence = item.quantity*item.sumOfOne;
                    if(expence > result.maxExpense){
                        result.maxExpense = expence;
                        result.maxExpName = item.itemName;
                    }
                    sumExpense += expence;
                }
            }
            HashMap<Boolean, Double> inner = new HashMap<>();
            inner.put(true, sumExpense);
            inner.put(false, sumIncome);
            dataSum.put(month, inner);

            resultReport.put(month, result);
        }
    }

    public void gerReport(){
        for(Map.Entry<Integer, MonthReportData> entry : resultReport.entrySet()){
            String resultMessage = MessageFormat.format("""
                            В месяце {0}:
                            - самый прибыльный товар: {1}, стоимостью {2}
                            - самая большая трата: {3}, стоимостью {4}""",
                    entry.getKey(), entry.getValue().maxValName, entry.getValue().maxValuable,
                    entry.getValue().maxExpName, entry.getValue().maxExpense);

            System.out.println(resultMessage);
        }
    }
}
