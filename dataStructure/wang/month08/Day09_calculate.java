package month08;

import java.util.Stack;

/**
 * 时间：2023/8/9
 * 问题描述：
 *  给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *  注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * 切入点/解决思路：使用栈实现
 * 感想：困难
 */
public class Day09_calculate {
    /**
     * 时间复杂度：O（n），空间复杂度：O（n）
     * 使用栈，遇到 ） 将栈内元素进行累计，直到遇到 （
     * 如果一个数字的上一个元素为 - 则减去该数字，否则加上该数字
     */
    public int calculate(String s) {
        /* 特殊情况处理 */
        if (s == null || s.length() == 0) return -1;
        /* 开始计算 */
        s = "(" + s + ")"; // 方便最后一次的计算
        Stack<String> stack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            /* 获取下一个内容 */
            StringBuilder sb = new StringBuilder();
            while (index < s.length() && s.charAt(index) == ' ') index++;
            if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                /* 该内容为数字 */
                while (index < s.length() && ((s.charAt(index) >= '0' && s.charAt(index) <='9') || s.charAt(index) == ' ')) {
                    if (s.charAt(index) != ' ') sb.append(s.charAt(index));
                    index++;
                }
                stack.push(sb.toString());
            } else {
                char c = s.charAt(index++);
                if (c == ')') {
                    /* 开始计算 */
                    int res = 0;
                    while (!stack.peek().equals("(")) {
                        int num = Integer.parseInt(stack.pop()); // 将数字出栈
                        /* 如果是 + 或 - 需要将其也出栈 */
                        if ("-".equals(stack.peek())) {
                            res -= num;
                            stack.pop();
                        } else {
                            res += num;
                            if ("+".equals(stack.peek())) stack.pop();
                        }
                    }
                    stack.pop(); // 将左括号移除
                    stack.push(String.valueOf(res));
                } else {
                    stack.push("" + c);
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }


}