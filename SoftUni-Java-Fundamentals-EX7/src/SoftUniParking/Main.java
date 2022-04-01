package SoftUniParking;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<String,String> parking=new LinkedHashMap<>();

        int commands=Integer.parseInt(sc.nextLine());

        String input="";

        for (int i = 0; i < commands; i++) {
            input=sc.nextLine();
            String[] command=input.split("\\s+");
            executeCommand(command,parking);
        }

        parking.entrySet().stream().forEach(car-> System.out.printf("%s => %s%n",car.getKey(),car.getValue()));

    }

    private static void executeCommand(String[] command, Map<String, String> parking) {
        if (command[0].equals("register")){
            if (!parking.containsKey(command[1])){
                parking.put(command[1],command[2] );
                System.out.printf("%s registered %s successfully%n",command[1],command[2]);
            }else {
                System.out.printf("ERROR: already registered with plate number %s%n",parking.get(command[1]));
            }
        }else {
            if (parking.containsKey(command[1])){
                parking.remove(command[1]);
                System.out.printf("%s unregistered successfully%n",command[1]);
            }else {
                System.out.printf("ERROR: user %s not found%n",command[1]);
            }
        }

    }
}

