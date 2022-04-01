package AMinerTask;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<String,Integer> materials=new LinkedHashMap<>();

        String input= sc.nextLine();
        while (!input.equals("stop")) {
            int quantity=Integer.parseInt(sc.nextLine());
            checkMaterials(materials,input,quantity);
            input=sc.nextLine();
        }

        materials.entrySet()
                .stream()
                .forEach(letter->System.out.printf("%s -> %d%n",letter.getKey(),letter.getValue()));

    }



    private static void checkMaterials(Map<String, Integer> materials, String input, int quantity) {
        if (materials.containsKey(input)){
            int currentQuantity=materials.get(input)+quantity;
            materials.put(input,currentQuantity);
        }else {
            materials.put(input,quantity);

        }
    }

}
