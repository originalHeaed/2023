package month7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ʱ�䣺2023/7/28
 * ����������
 *  ����һ���ַ��� s ��һ���ַ������� words�� words �������ַ��� ������ͬ��
 *   s �е� �����Ӵ� ��ָһ������  words �������ַ���������˳�����������������Ӵ���
 *  ���磬��� words = ["ab","cd","ef"]�� ��ô "abcdef"�� "abefcd"��"cdabef"�� "cdefab"��"efabcd"�� �� "efcdab" ���Ǵ����Ӵ��� "acdbef" ���Ǵ����Ӵ�����Ϊ�������κ� words ���е����ӡ�
 *  �������д����ִ��� s �еĿ�ʼ������������� ����˳�� ���ش𰸡�
 * �����/���˼·������ַ��� s ʹ�û�������
 * ���룺�����еȣ�С������
 */
public class Day28_findSubstring {
    /**
     * ʹ�û��������������Ӵ�
     * ʱ�临�Ӷȣ�O��max(m,n)
     * �ռ临�Ӷȣ�O��n��
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        /* ����������� */
        if (s == null || s.equals("") || words == null || words.length == 0) return res;
        /* ʹ�û������������������Ӵ� */
        int left = 0;
        int right = 0;
        int len = words[0].length(); // ���ʵĻ�������
        Map<String, Integer> map = new HashMap<>(); // ��¼��ǰ���������ڻ�δƥ�� words �е��ַ���
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        while (right < s.length()) {
            right += len;
            if (right >= s.length()) break;
            String tem = s.substring(right - left, right); // �������һ�������
            if (map.containsKey(tem)) {
                int time = map.get(tem) - 1;
                if (time == 0) map.remove(tem);
                else map.put(tem, time);
            }
        }
        return res;
    }
}