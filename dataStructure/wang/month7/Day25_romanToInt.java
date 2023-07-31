package month7;

import java.util.HashMap;
import java.util.Map;

/**
 * ʱ�䣺2023/7/25
 * ��������������������תΪ����
 * �����/���˼·��ֱ��ת����
 * ���룺��ͨ
 */
public class Day25_romanToInt {
    /**
     * ÿ���������ֶ�Ӧ�İ���������
     */
    Map<Character, Integer> helper = new HashMap<Character, Integer>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};


    public int romanToInt(String s) {
        /* ����������� */
        if (s == null || s.length() == 0) return 0;
        int total = helper.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (needSub(s.charAt(i), s.charAt(i + 1))) total -= helper.get(s.charAt(i));
            else total += helper.get(s.charAt(i));
        }
        return total;
    }

    private boolean needSub(Character c1, Character c2) {
        switch (c1) {
            case 'I':
                if (c2 == 'V' || c2 == 'X') return true;
                break;
            case 'X':
                if (c2 == 'L' || c2 == 'C') return true;
                break;
            case 'C':
                if (c2 == 'D' || c2 == 'M') return true;
                break;
            default:
                break;
         }
        return false;
    }
}