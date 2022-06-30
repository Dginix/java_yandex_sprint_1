package org.yandex.firstsprint;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @implNote Создает и хранит отчет за год
 */
public class YearlyReport {
    ArrayList<YearData> data;
    int year;
    public void addYear(int year, ArrayList<YearData> data){
        this.data = data;
        this.year = year;
    }
}
