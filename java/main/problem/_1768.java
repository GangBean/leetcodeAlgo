package main.problem;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import main.util.Input;

public class _1768 implements Problem {

    @Override
    public void test(File file) {
        List<List<String>> inputs = Input.ofList(file, ",");
        inputs.forEach(input -> {
            System.out.println("\ninput: " + input);
            String output = mergeAlternately(input.get(0), input.get(1));
            System.out.println("output: " + output);
        });
    }

    public String mergeAlternately(String word1, String word2) {
        List<Character> output = new LinkedList<>();
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < chars1.length && idx2 < chars2.length) {
            if (idx1 == idx2) {
                output.add(chars1[idx1++]);
                continue;
            }
            output.add(chars2[idx2++]);
        }
        for (int i = idx1 ; i < chars1.length; i++) {
            output.add(chars1[i]);
        }
        for (int i = idx2 ; i < chars2.length; i++) {
            output.add(chars2[i]);
        }
        return output.stream()
            .map(String::valueOf)
            .collect(Collectors.joining());
    }

}
