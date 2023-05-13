package main.problem;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import main.util.Input;

public class _1929 implements Problem {

    @Override
    public void test(File file) {
        List<List<String>> inputs = Input.ofList(file, ",");
        for (List<String> input : inputs) {
            System.out.println("\ninput: " + input);

            int[] output = getConcatenation(
                input.stream().mapToInt(Integer::parseInt).toArray());

            System.out.println("output:" + Arrays.stream(output).boxed().collect(Collectors.toList()));
        }
    }

    public int[] getConcatenation(int[] nums) {
        int[] output = new int[nums.length * 2];
        int i = 0;
        for (int s : nums) {
            output[i] = s;
            output[i + nums.length] = s;
            i++;
        }
        return output;
    }

}
