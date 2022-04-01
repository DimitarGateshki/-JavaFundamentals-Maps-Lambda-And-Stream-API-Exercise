package Courses;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> courses = new LinkedHashMap<>();
        Map<String, String> students = new TreeMap<>();

        String input = sc.nextLine();
        while (!input.equals("end")) {
            String[] info = input.split(" : ");

            if (!courses.containsKey(info[0])) {
                courses.put(info[0], 1);
            } else {
                int count = courses.get(info[0]) + 1;
                courses.put(info[0], count);
            }
            if (!students.containsKey(info[1])) {
                students.put(info[1], info[0]);
            }
            input = sc.nextLine();
        }

        courses.entrySet()
                .stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .forEach(c -> {
                    System.out.printf("%s: %d%n", c.getKey(), c.getValue());

                    students.entrySet().stream()
                            .forEach(s -> {
                                if (s.getValue().equals(c.getKey())) {
                                    System.out.printf("-- %s%n", s.getKey());
                                }
                            });
                });
    }
}
