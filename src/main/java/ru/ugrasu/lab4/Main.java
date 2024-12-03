package ru.ugrasu.lab4;

import java.util.Map;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        System.out.println(show(0));
        System.out.println(isTheSame("aasd", "asda"));
        System.out.println(isTheSame("as", "ass"));
        System.out.println(isTheSame("asd", "d"));
    }

    public static String show(int n) {
        if (n <= 0) {
            return "#";
        }
        int maxLength = n + 2;
        int offset = 1;
        StringBuilder result = new StringBuilder();
        result.append(" ".repeat(maxLength - offset++))
                .append("#\n")
                .append(" ".repeat(maxLength - offset++))
                .append("##\n");
        for (int i = n - 1; i >= 0; i--) {
            result.append(" ".repeat(maxLength - offset++))
                    .append("#");
            result.append("O".repeat(Math.max(0, n - i)));
            result.append("#\n");
        }

        n--;

        for (int i = 0; i < n; i++) {
            result.append(" ".repeat(maxLength - --offset + 1))
                    .append("#");
            result.append("O".repeat(n - i));
            result.append("#\n");
        }
        return result.append(" ".repeat(maxLength - --offset + 1))
                .append("##\n")
                .append(" ".repeat(maxLength - --offset + 1))
                .append("#")
                .toString();
    }

    private static boolean isTheSame(String first, String second) {
        Map<Character, Integer> firstMap = getMap(first);
        Map<Character, Integer> secondMap = getMap(second);
        return firstMap.equals(secondMap);
    }

    private static Map<Character, Integer> getMap(String first) {
        return first.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(c -> c, c -> 1, Integer::sum));
    }
}
