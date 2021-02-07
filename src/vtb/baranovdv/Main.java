package vtb.baranovdv;

//Проверить правильность расстановок скобок в выражении, использующем скобки вида: “(”, “)”, “{”, “}”, “[”, “]”. Требование вложенности скобок разного вида не учитывать, т.е., например, последовательности скобок “({})[]” и “([{()}]}” — правильные.
//Скобки с консоли считывать одной строкой.
//Примечание: используйте стек, реализованный в предыдущем уроке.

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Map<Character, Character> brackets = new Hashtable<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a string");
        System.out.format("balanced: %b%n", isBalanced(s.next(), brackets));
    }

    public static boolean isBalanced(String str, Map<Character, Character> brk) {
        Stack<Character> stk = new Stack<>();
        for (char c : str.toCharArray()) {
            if (brk.containsValue(c)) {
                stk.push(c);
            }
            else {
                if (brk.containsKey(c)) {
                    if (stk.isEmpty() || !brk.get(c).equals(stk.pop())) {
                        return false;
                    }
                }
            }
        }
        return stk.isEmpty();
    }
}