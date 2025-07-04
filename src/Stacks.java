import java.util.*;
import java.io.*;

public class Stacks {
    //https://neetcode.io/problems/validate-parentheses?list=blind75
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> k = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                k.add(c);
            }
            else {
                if (k.isEmpty() || k.peek() != map.get(c)) {
                    return false;
                }
                k.pop();
            }
        }
        return k.isEmpty();
    }
}
