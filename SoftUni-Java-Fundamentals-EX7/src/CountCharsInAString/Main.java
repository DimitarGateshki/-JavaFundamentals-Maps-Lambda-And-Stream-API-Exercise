package CountCharsInAString;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<Character,Integer> letters=new LinkedHashMap<>();

        char[] word=sc.nextLine().toCharArray();

        for (char el:word) {

            if (el==' '){
                continue;
            }else if(letters.containsKey(el)){
                int value=letters.get(el)+1;
                letters.put(el,value);
            }else {
                letters.put(el,1);
            }
        }

        letters.entrySet().stream()
                .forEach(letter->System.out.printf("%c -> %d%n",letter.getKey(),letter.getValue()));

    }
}
