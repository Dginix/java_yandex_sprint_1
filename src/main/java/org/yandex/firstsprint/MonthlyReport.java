package org.yandex.firstsprint;

import java.lang.reflect.Array;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @implNote Создает отчет по месяцам из спарсенных до этого данных (вызывая специальный метод),
 * данные добавляются в хэш-мап
 */

public class MonthlyReport {
    HashMap<Integer, ArrayList<MonthData>> data = new HashMap<>();
    public void addMonth(int month, ArrayList<MonthData> monthDataList){
        data.put(month, monthDataList);
    }
    public void analyzeReports(){
        for(int month : data.keySet()){
            ArrayList<MonthData> currentMonthData = data.get(month);
            double maxValuable = 0;
            String maxValName = "";
            double maxExpense = 0;
            String maxExpName = "";
            for(MonthData item : currentMonthData){
                if(!item.isExpense){
                    double valuable = item.quantity*item.sumOfOne;
                    if(valuable > maxValuable){
                        maxValuable = valuable;
                        maxValName = item.itemName;
                    }
                }
                if(item.isExpense){
                    double expence = item.quantity*item.sumOfOne;
                    if(expence > maxExpense){
                        maxExpense = expence;
                        maxExpName = item.itemName;
                    }
                }
            }

            String resultMessage = MessageFormat.format("""
                            В месяце {0}:
                            - самый прибыльный товар: {1}, стоимостью {2}
                            - самая большая трата: {3}, стоимостью {4}""",
                            month, maxValName, maxValuable, maxExpName, maxExpense);

            System.out.println(resultMessage);
        }
    }
}
