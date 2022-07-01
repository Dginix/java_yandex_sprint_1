package org.yandex.firstsprint;

import java.lang.reflect.Array;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/*
При вызове этой функции программа должна выводить следующие данные:
1. Рассматриваемый год
2. Прибыль по каждому месяцу (разница доходов и расходов)
3. Сроедний расход за все месяцы в году
4. Средний доход за все месяцы в году
 */

/**
 * @implNote Создает и хранит отчет за год
 */
public class YearlyReport {
    public ArrayList<YearData> data;
    int year;
    public void addYear(int year, ArrayList<YearData> data){
        this.data = data;
        this.year = year;
    }
    public void analyzeReports(){
        double avgIncome;
        double sumIncome = 0.0;
        double avgExpense;
        double sumExpense = 0.0;
        ArrayList<Integer> monthsAll = new ArrayList<>();
        for(YearData field : data){
            monthsAll.add(field.month);
            if(field.isExpense) sumExpense+= field.amount;
            else sumIncome+=field.amount;
        }
        List<Integer> monthsUniq = monthsAll.stream().distinct().toList();

        avgIncome = sumIncome/monthsUniq.size();
        avgExpense = sumExpense/monthsUniq.size();

        HashMap<Integer, Double> profitData = new HashMap<>();

        for(Integer month : monthsUniq){
            double profitVal = 0.0;
            for(YearData field : data){
                if(month == field.month){
                    if(field.isExpense) profitVal -= field.amount;
                    else profitVal += field.amount;
                }
            }
            profitData.put(month, profitVal);
        }

        for(Integer month : profitData.keySet()){
            String resultMessage = MessageFormat.format("""
                            В месяце {0} прибыль составляет {1}""",
                    month, profitData.get(month));

            System.out.println(resultMessage);
        }
        System.out.println("Средний расход за все месяцы составляет " + avgExpense);
        System.out.println("Средний доход за все месяцы составляет " + avgIncome);
    }
}
