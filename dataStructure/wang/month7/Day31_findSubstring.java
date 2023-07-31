package month7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ʱ�䣺2023/7/31
 * ����������
 *  ����һ���ַ��� s ��һ���ַ������� words�� words �������ַ��� ������ͬ��
 *   s �е� �����Ӵ� ��ָһ������  words �������ַ���������˳�����������������Ӵ���
 *  ���磬��� words = ["ab","cd","ef"]�� ��ô "abcdef"�� "abefcd"��"cdabef"�� "cdefab"��"efabcd"�� �� "efcdab" ���Ǵ����Ӵ��� "acdbef" ���Ǵ����Ӵ�����Ϊ�������κ� words ���е����ӡ�
 *  �������д����Ӵ��� s �еĿ�ʼ������������� ����˳�� ���ش𰸡�
 * �����/���˼·��ʹ�ñ����� + ˫ָ��
 * ���룺
 */
public class Day31_findSubstring {
    /**
     * ʹ�ñ�������ʱ�临�Ӷȣ�O��n * m��,n - �ַ����ĳ��ȣ�m ������ĳ���
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        /* ����������� */
        if (s == null || s.equals("") || words == null || words.length == 0 || words[0].length() == 0) return res;
        /* ʹ�ñ����� */
        int baseLen = words[0].length();
        int totalLen = baseLen * words.length;
        String[] arr = new String[s.length() - baseLen + 1]; // �� s ��ÿ����ĸβ�ף�����Ϊ baseLen ���ַ�������
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.substring(i, i + baseLen);
        }
        /* ��¼ words �е��ַ��� */
        Map<String, Integer> map = new HashMap<>();
        for (int k = 0; k < words.length; k++) {
            map.put(words[k], map.getOrDefault(words[k], 0) + 1);
        }
        /* �жϵ� i ���ַ���ʼ��ɵ��ַ����Ƿ�Ϊ�����Ӵ� */
        for (int i = 0; i < arr.length; i++) {
            if ((i + totalLen - 1) >= s.length()) break;
            /* �ж� [i, i + totalLen - 1] ��ɵ��Ӵ��Ƿ�Ϊ�����Ӵ� */
            Map<String, Integer> tem = new HashMap<>();
            boolean isSub = true;
            for (int j = 0; j < words.length; j++) {
                Integer targetTime = map.get(arr[i + j * baseLen]);
                tem.put(arr[i + j * baseLen], tem.getOrDefault(arr[i + j * baseLen], 0) + 1);
                Integer targetTem = tem.get(arr[i + j * baseLen]);
                if (targetTime == null || targetTem > targetTime) {
                    isSub = false;
                    break; // �����Ը��ַ�Ϊ��
                }
            }
            /* ��� map �е��ַ���ȫ����ƥ���꣬���ʾ [i, i + totalLen - 1] ������Ϊ�����Ӵ� */
            if (isSub) res.add(i);
        }
        return res;
    }

    /**
     * ʱ�临�Ӷȣ�O��n * m����n - ���ʵĳ��ȣ�m �ַ�������
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        /* ����������� */
        if (s == null || s.equals("") || words == null || words.length == 0 || words[0].length() == 0) return res;
        /* ʹ�ñ����� */
        int baseLen = words[0].length();
        int totalLen = baseLen * words.length;
        /* �� s ��ÿ����ĸβ�ף�����Ϊ baseLen ���ַ������� */
        String[] arr = new String[s.length() - baseLen + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.substring(i, i + baseLen);
        }
        /* ��¼ words �е��ַ��� */
        Map<String, Integer> map = new HashMap<>();
        for (int k = 0; k < words.length; k++) {
            map.put(words[k], map.getOrDefault(words[k], 0) + 1);
        }
        /* ʹ�û������ڷ����ж��Ƿ�Ϊ�����Ӵ� */
        for (int i = 0; i < baseLen; i++) {
            if ((i + totalLen - 1) >= s.length()) break;
            int left = i;
            int right = i;
            Map<String, Integer> tem = new HashMap<>();
            while (right < arr.length) {
                Integer time1 = map.get(arr[right]);
                tem.put(arr[right], tem.getOrDefault(arr[right], 0) + 1);
                Integer time2 = tem.get(arr[right]);
                /* ��ǰ right ָ��ĵ��ʲ��� words �л򽫸õ��ʼ��봮���Ӵ�����ĳ�����ʶ��ˣ������ָ�뿪ʼ������ֱ���Թ�һ����ǰ����Ϊֹ */
                if (time1 == null || time2 > time1) {
                    while (left <= right) {
                        tem.put(arr[left], tem.get(arr[left]) - 1);
                        Integer count = tem.get(arr[left]);
                        if (count == 0) tem.remove(arr[left]);
                        if (arr[left].equals(arr[right])) {
                            left += baseLen;
                            break;
                        }
                        left += baseLen;
                    }
                }
                /* �����ǰ�������ڵĳ��ȵ��� words ���е����ܳ��ȣ����ʾ����һ�������Ӵ� */
                if ((right + baseLen - left) == totalLen) res.add(left);
                right += baseLen;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String  i = "12";
        System.out.println(i.substring(0, 2));
    }

}