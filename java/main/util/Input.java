package main.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Input {

    public static List<String> ofList(File file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static List<List<String>> ofList(File file, String delimiter) {
        List<List<String>> resultList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(delimiter);
                List<String> list = new ArrayList<>();
                for (String str : data) {
                    list.add(str.trim());
                }
                resultList.add(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

}
