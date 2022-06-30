package org.yandex.firstsprint;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * @implNote Класс для для чтения и парсинга данных из файла
 */
public class ParseData {

    static ArrayList<MonthData> parseMonthFileContent(String content){
        String[] lines = content.split("\\n");
        ArrayList<MonthData> resultList = new ArrayList<>();

        for(int i = 1; i < lines.length; i++){
            String[] lineContent = lines[i].split(",");
            resultList.add(new MonthData(lineContent[0], Boolean.parseBoolean(lineContent[1]),
                    Long.parseLong(lineContent[2]), Double.parseDouble(lineContent[3])));
        }
        return resultList;
    }

    static String readFileContent(String path){
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e){
            System.out.println("Невозможно считать файл\n" +
                    e);
            return null;
        }
    }
}
