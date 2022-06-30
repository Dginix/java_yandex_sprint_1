package org.yandex.firstsprint;

import java.lang.reflect.Array;
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
}
