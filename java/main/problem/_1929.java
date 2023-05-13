package main.problem;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import main.util.Input;

public class _1929 implements Problem {

    @Override
    public void test(File file) {
        List<List<String>> inputs = Input.ofList(file, ",");
        for (List<String> input : inputs) {
            System.out.println("\ninput: " + input);

            String[] output = new String[input.size() * 2];
            int i = 0;
            for (String s : input) {
                output[i] = s;
                output[i + input.size()] = s;
                i++;
            }

            System.out.println("output:" + Arrays.asList(output));
        }
    }

}
