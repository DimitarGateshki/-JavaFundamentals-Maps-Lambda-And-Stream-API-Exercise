package Orders;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<String, ArrayList<Double>> products=new LinkedHashMap<>();

        String input=sc.nextLine();

        while (!input.equals("buy")){
            String[] productInfo=input.split("\\s+");
            double price=Double.parseDouble(productInfo[1]);
            double quantity=Double.parseDouble(productInfo[2]);
            ArrayList<Double> info=new ArrayList<>();
            info.add(price);
            info.add(quantity);

            if (!products.containsKey(productInfo[0])){
                products.put(productInfo[0],info);
            }else {
                double newQUANTITY=products.get(productInfo[0]).get(1)+quantity;
                ArrayList<Double> updateInfo=new ArrayList<>();
                updateInfo.add(price);
                updateInfo.add(newQUANTITY);
                products.put(productInfo[0],updateInfo);
            }

            input=sc.nextLine();
        }
        products.entrySet().stream()
                .forEach(el-> System.out.printf("%s -> %.2f%n",el.getKey(),
                        el.getValue().get(1)*el.getValue().get(0)));

    }
}
