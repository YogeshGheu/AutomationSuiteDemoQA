package temp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class inter {
    public static void main(String[] args) {
        String str = "my name is yogesh";

        char[] charArr = str.toCharArray();
        Map<Character, Integer> count = new HashMap<>();

        for(char c : charArr){
            if(!count.containsKey(c)){
                count.put(c, 1);
            }else{
                count.put(c, count.get(c) + 1);
            }
        }

        StringBuilder unique = new StringBuilder();

        for(Character i : count.keySet()){
            if(count.get(i) == 1){
                unique.append(i);
            }
        }

        System.out.println(unique);


    }
}
