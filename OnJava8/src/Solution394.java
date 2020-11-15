import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution394 {
    public static String decodeString(String s) {
        String res = "";
        int length = s.length();
        char cur;
        String curString = "";

        for (int i = 0; i < length; i++) {
            cur = s.charAt(i);
            if (cur >= 'a' && cur <= 'z'){
                res += cur;
            }else if (cur >= 'A' && cur <= 'Z'){
                res += cur;
            }else if (cur >= '0' && cur <= '9'){
                int number = cur - '0';
                i++;
                cur = s.charAt(i);
                while (cur >= '0' && cur <= '9'){
                    number = number*10 + (cur - '0');
                    i++;
                    cur = s.charAt(i);
                }

                int j = i;
                Deque<Character> stack = new ArrayDeque<>();
                stack.addLast(cur);
                String sonString = "";


                while (!stack.isEmpty()){
                    j++;

                    if (s.charAt(j) == ']' && stack.size() == 1){
                        curString = decodeString(sonString);
                        if (j < length){
                            i = j;
                        }
                        break;
                    }else if (s.charAt(j) == '['){
                        stack.addLast(s.charAt(j));
                        sonString += s.charAt(j);
                    }else if (s.charAt(j) == ']'){
                        stack.removeLast();
                        sonString += s.charAt(j);
                    }
                    sonString += s.charAt(j);
                }
                res += SimpleDecode(number, curString);
            }
        }
        return res;

    }
    public static String SimpleDecode(int number, String str){
        String unit = str;
        for (int i = 0; i < number - 1; i++) {
            str += unit;
        }
        return str;
    }

    public static void main(String[] args) {
        String s = "1[a]2[bc]";
        System.out.println(decodeString(s));
    }
}
