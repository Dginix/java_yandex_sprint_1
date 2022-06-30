package org.yandex.firstsprint;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * @implNote Класс для для чтения и парсинга данных из файла
 */
public class ParseData {

    static void parseFileContent(String content){
        String[] lines = content.split("\\n");
        for(String line : lines){
            String[] lineContent = line.split(",");
            System.out.println(lineContent);
        }
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
