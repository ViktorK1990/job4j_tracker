package ru.job4j.lambda;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
public class LambdaUsage {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("eeee", "a", "ccc", "dddd", "bb");
        Comparator<String> comparator = (left, right) -> {
            System.out.println("Comapre"  + " "+ right.length() + " " + "and" + " " + left.length());
            return Integer.compare(right.length(), left.length());
        };
        strings.sort(comparator);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
