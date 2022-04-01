package CompanyUsers;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Map<String, List<String>> companies=new TreeMap<>();

        String input= sc.nextLine();

        while (!input.equals("End")){
            String[] info=input.split(" -> ");
            if (companies.containsKey(info[0])){
                if (!companies.get(info[0]).contains(info[1])){
                    companies.get(info[0]).add(info[1]);
                }

            }else {
                List<String> workersId=new ArrayList<>();
                workersId.add(info[1]);
                companies.put(info[0],workersId);

            }
            input= sc.nextLine();
        }

        for (String el:companies.keySet()) {
            System.out.printf("%s%n",el);
            companies.get(el).stream().forEach(e-> System.out.printf("-- %s%n",e));
        }
    }
}
