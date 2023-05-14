package main.problem;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import main.util.Input;

public class _2652 implements Problem {

    @Override
    public void test(File file) {
        List<List<String>> inputs = Input.ofList(file, ",");
        for (List<String> input : inputs) {
            System.out.println("\ninput: " + input);

            int output = sumOfMultiples(input.stream().mapToInt(Integer::parseInt).toArray()[0]);

            System.out.println("output:" + output);
        }
    }

    public int sumOfMultiples(int n) {
        return IntStream.range(1, n + 1)
            .filter(x -> x % 3 == 0 || x % 5 == 0 || x % 7 == 0)
            .reduce(0, (a, b) -> a + b);
    }

}
