package LegendaryFarming;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<String,Integer> keyMaterials=new HashMap<>(){{
            put("shards",0);
            put("fragments",0);
            put("motes",0);
        }};

        TreeMap<String,Integer> junk=new TreeMap<>();
        boolean condition=true;
        while (condition){
            String[] input=sc.nextLine().split("\\s+");
            for (int i = 0; i < input.length; i++) {
                int col=Integer.parseInt(input[i++]);
                String material=input[i].toLowerCase();
                if (keyMaterials.containsKey(material)) {
                    fillKey(keyMaterials, material, col);
                    if (check(keyMaterials,material)){
                        switch (material){
                            case "shards" :
                                System.out.println("Shadowmourne obtained!");
                                break;
                            case "fragments" :
                                System.out.println("Valanyr obtained!");
                                break;
                            case "motes" :
                                System.out.println("Dragonwrath obtained!");
                                break;
                        }
                        condition=false;
                        break;
                    }
                }else {
                    junkFill(junk,material,col);
                }

            }
        }

        keyMaterials.entrySet().stream()
                .sorted((e1,e2)->{
                    int res=e2.getValue().compareTo(e1.getValue());
                    if(res == 0) {
                        res = e1.getKey().compareTo(e2.getKey());
                    }
                    return res;
                }).forEach(e -> System.out.printf("%s: %d%n",e.getKey(),e.getValue()));
        junk.entrySet().stream()
                .forEach(e -> System.out.printf("%s: %d%n",e.getKey(),e.getValue()));

    }

    private static boolean check(HashMap<String, Integer> keyMaterials,String type) {
        int count=keyMaterials.get(type);
        if (count>=250) {
            count-=250;
            keyMaterials.put(type,count);
            return true;
        }else {
            return false;
        }
    }

    private static void junkFill(TreeMap<String, Integer> junk, String material, int col) {
        if (junk.containsKey(material)){
            col+=junk.get(material);
            junk.put(material,col);
        }else {
            junk.put(material,col);
        }
    }

    private static void fillKey(HashMap<String, Integer> keyMaterials, String material, int col) {
        col+=keyMaterials.get(material);
        keyMaterials.put(material,col);
    }

}
