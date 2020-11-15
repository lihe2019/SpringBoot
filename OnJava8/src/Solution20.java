import java.util.ArrayDeque;
import java.util.Deque;

public class Solution20 {
    public static boolean isValid(String s) {
        if (s.length() == 0){
            return true;
        }
        Deque<Character> stack = new ArrayDeque<>();

        stack.addLast(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (stack.isEmpty()){
                stack.addLast(s.charAt(i));
            }else if (matching(stack.peekLast(), s.charAt(i))){
                stack.removeLast();
            }else{
                stack.addLast(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
    public static boolean matching(char a, char b){
        if (a == '(' && b == ')'){
            return true;
        }else if (a == '[' && b == ']'){
            return true;
        }else if (a == '{' && b == '}'){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        String a = "()[]{}";
        System.out.println(isValid(a));
    }
}


