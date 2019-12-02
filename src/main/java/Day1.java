import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.util.Arrays;

public class Day1 {
    private static int[] modules;

    public static void main(String[] args) throws ConfigurationException {
        Configuration properties = new PropertiesConfiguration("Day1Input.txt");
        String[] input = properties.getStringArray("module");
        modules = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        part1();
        part2();
    }

    private static void part1() throws ConfigurationException {
        int fuel = 0;
        for (int module : modules) {
            fuel += calculateFuel(module);
        }

        System.out.println("Part 1 output: " + fuel);
    }

    private static void part2() throws ConfigurationException {
        int fuel = 0;
        for (int module : modules) {
            fuel += calculateFuleForFule(module);
        }

        System.out.println("Part 1 output: " + fuel);
    }

    private static int calculateFuleForFule(int mass) {
        int fuel = calculateFuel(mass);

        if (fuel <= 0) {
            return 0;
        }
        return fuel + calculateFuleForFule(fuel);
    }

    private static int calculateFuel(int mass) {
        return mass / 3 - 2;
    }
}
