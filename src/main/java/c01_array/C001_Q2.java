package c01_array;

import java.util.HashMap;
import java.util.Set;

public class C001_Q2 {
    public boolean isred(String s) {
        if (s==null ||s.length()==0){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        // write code here
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]==' '){
                continue;
            }
            if(map.containsKey(chars[i])){
                int x = map.get(chars[i]);
                x++;
                map.put(chars[i], x);
            }else{
                map.put(chars[i], 1);
            }
        }
        if (map.get('r')==null||map.get('e')==null||map.get('d')==null){
            return false;
        }
        int n = chars.length/3;
        int num = map.get('r');
        int num2 = map.get('e');
        int num3 = map.get('d');
        if (num!=n || num!=num2 || num2!=num3){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "rrededder";
        C001_Q2 c001_q2 = new C001_Q2();
        boolean isred = c001_q2.isred(s);
        System.out.println(isred);
    }
}
