package month08;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * ʱ�䣺2023/8/8
 * ����������
 *  ����һ���ַ��� path ����ʾָ��ĳһ�ļ���Ŀ¼�� Unix ��� ����·�� ���� '/' ��ͷ�������㽫��ת��Ϊ���Ӽ��Ĺ淶·����
 *  �� Unix �����ļ�ϵͳ�У�һ���㣨.����ʾ��ǰĿ¼�������⣬������ ��..�� ��ʾ��Ŀ¼�л�����һ����ָ��Ŀ¼�������߶������Ǹ������·������ɲ��֡�������������б�ܣ�����'//'��������Ϊ����б�� '/' �� ���ڴ����⣬�κ�������ʽ�ĵ㣨���磬'...'��������Ϊ�ļ�/Ŀ¼���ơ�
 *  ��ע�⣬���ص� �淶·�� ������ѭ������ʽ��
 *  ʼ����б�� '/' ��ͷ��
 *  ����Ŀ¼��֮�����ֻ��һ��б�� '/' ��
 *  ���һ��Ŀ¼����������ڣ����� �� '/' ��β��
 *  ���⣬·���������Ӹ�Ŀ¼��Ŀ���ļ���Ŀ¼��·���ϵ�Ŀ¼���������� '.' �� '..'����
 *  ���ؼ򻯺�õ��� �淶·�� ��
 * �����/���˼·��ʹ��ջ
 * ���룺�е�ƫ��
 */
public class Day08_simplifyPath {
    /**
     * ʱ�临�Ӷȣ�O��n�����ռ临�Ӷȣ�O��n��
     * ���ڸ�������һ��������Ч�ĵ� unix ���·����
     * ������������ļ���ջ������ "." ֱ�Ӻ��ԣ����� ".." ��ջ��Ԫ���Ƴ�
     * ���ջ��Ԫ���ó�ƴ�Ӽ���
     */
    public String simplifyPath(String path) {
        /* ����������� */
        if (path == null || path.length() == 0) return path;
        /* ��ȡ�򻯺����Ч·�� */
        Deque<String> stack = new ArrayDeque<>();
        char[] chars = path.toCharArray();
        StringBuilder sb;
        int index = 0;
        while (index < chars.length) {
            sb = new StringBuilder();
            /* ���� "/" */
            while (index < chars.length && chars[index] == '/') index++;
            /* ��ȡ�ַ� */
            while (index < chars.length && chars[index] != '/') sb.append(chars[index++]);
            /* ���ַ����д��� */
            String tem = sb.toString();
            if (sb.length() == 0 || ".".equals(tem)) continue;
            else if ("..".equals(tem)) {
                if (!stack.isEmpty()) stack.pop();
            }
            else stack.push(tem);
        }
        /* ƴ����Ч�ַ��� */
        StringBuffer res =  new StringBuffer();
        if (stack.isEmpty()) res.append("/");
        else {
            while (!stack.isEmpty()) {
                res.append("/").append(stack.pollLast());
            }
        }
        return res.toString();
    }
}