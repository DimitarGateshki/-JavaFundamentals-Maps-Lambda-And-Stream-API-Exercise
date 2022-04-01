package StudentAcademy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Map<String, List<Double>> students=new LinkedHashMap<>();

        int rows=Integer.parseInt(sc.nextLine());

        for (int i = 0; i < rows; i++) {
            String name=sc.nextLine();
            double grade=Double.parseDouble(sc.nextLine());

            if (students.containsKey(name)){
                students.get(name).add(grade);

            }else {
                List<Double> grades=new ArrayList<>();
                grades.add(grade);
                students.put(name,grades);
            }
        }

        students.entrySet()
                .stream().filter(e->e.getValue().stream()
                .mapToDouble(d->Double.valueOf(d))
                .average()
                .getAsDouble()>=4.50)
                .sorted((a1,a2)-> {
                    double second=a2.getValue().stream()
                            .mapToDouble(Double::doubleValue)
                            .average().getAsDouble();
                    double first=a1.getValue().stream()
                            .mapToDouble(Double::doubleValue)
                            .average().getAsDouble();
                    return Double.compare(second,first);
                } ).forEach(s-> System.out.printf("%s -> %.2f%n",s.getKey(),
                s.getValue().stream()
                        .mapToDouble(Double::doubleValue)
                        .average()
                        .getAsDouble()));
    }
}
