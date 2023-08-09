package month08;

import java.util.Stack;

/**
 * ʱ�䣺2023/8/9
 * ����������
 *  ����һ���ַ������ʽ s ������ʵ��һ�����������������㲢��������ֵ��
 *  ע��:������ʹ���κν��ַ�����Ϊ��ѧ���ʽ��������ú��������� eval() ��
 * �����/���˼·��ʹ��ջʵ��
 * ���룺����
 */
public class Day09_calculate {
    /**
     * ʱ�临�Ӷȣ�O��n�����ռ临�Ӷȣ�O��n��
     * ʹ��ջ������ �� ��ջ��Ԫ�ؽ����ۼƣ�ֱ������ ��
     * ���һ�����ֵ���һ��Ԫ��Ϊ - ���ȥ�����֣�������ϸ�����
     */
    public int calculate(String s) {
        /* ����������� */
        if (s == null || s.length() == 0) return -1;
        /* ��ʼ���� */
        s = "(" + s + ")"; // �������һ�εļ���
        Stack<String> stack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            /* ��ȡ��һ������ */
            StringBuilder sb = new StringBuilder();
            while (index < s.length() && s.charAt(index) == ' ') index++;
            if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                /* ������Ϊ���� */
                while (index < s.length() && ((s.charAt(index) >= '0' && s.charAt(index) <='9') || s.charAt(index) == ' ')) {
                    if (s.charAt(index) != ' ') sb.append(s.charAt(index));
                    index++;
                }
                stack.push(sb.toString());
            } else {
                char c = s.charAt(index++);
                if (c == ')') {
                    /* ��ʼ���� */
                    int res = 0;
                    while (!stack.peek().equals("(")) {
                        int num = Integer.parseInt(stack.pop()); // �����ֳ�ջ
                        /* ����� + �� - ��Ҫ����Ҳ��ջ */
                        if ("-".equals(stack.peek())) {
                            res -= num;
                            stack.pop();
                        } else {
                            res += num;
                            if ("+".equals(stack.peek())) stack.pop();
                        }
                    }
                    stack.pop(); // ���������Ƴ�
                    stack.push(String.valueOf(res));
                } else {
                    stack.push("" + c);
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }


}