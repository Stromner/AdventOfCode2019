package day2;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.util.Arrays;

public class Day2 {
    public static void main(String[] args) throws ConfigurationException {
        Configuration properties = new PropertiesConfiguration("Day2Input.txt");
        String[] input = properties.getStringArray("input");
        int[] inputArray = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        part2BruteForce(inputArray);
    }

    public static int[] part1(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i += 4) {
            OpCode currentOperation = OpCode.fromIntValue(inputArray[i]);
            switch (currentOperation) {
                case ADD:
                    inputArray[inputArray[i + 3]] = inputArray[inputArray[i + 1]] + inputArray[inputArray[i + 2]];
                    break;
                case MUL:
                    inputArray[inputArray[i + 3]] = inputArray[inputArray[i + 1]] * inputArray[inputArray[i + 2]];
                    break;
                default:
                case FIN:
                    break;
            }
        }
        return inputArray;
    }

    public static void part2BruteForce(int[] inputArray) {
        int[] iterationArray = inputArray.clone();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                iterationArray[1] = i;
                iterationArray[2] = j;
                System.out.println("Input:" + Arrays.toString(iterationArray));
                part1(iterationArray);
                if (iterationArray[0] == 19690720) {
                    System.out.println("Transformed:" + Arrays.toString(iterationArray));
                    return;
                } else {
                    iterationArray = inputArray.clone();
                }
            }
        }
    }
}
