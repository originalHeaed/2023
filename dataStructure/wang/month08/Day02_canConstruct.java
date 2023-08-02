package month08;

import java.util.HashMap;
import java.util.Map;

/**
 * ʱ�䣺2023/8/2
 * ����������
 *  ���������ַ�����ransomNote �� magazine ���ж� ransomNote �ܲ����� magazine ������ַ����ɡ�
 *  ������ԣ����� true �����򷵻� false ��
 *  magazine �е�ÿ���ַ�ֻ���� ransomNote ��ʹ��һ�Ρ�
 * �����/���˼·��ʹ�� map ֱ�ӽ��
 * ���룺��
 */
public class Day02_canConstruct {
    /**
     * ʱ�临�Ӷȣ�O��n + m�����ռ临�Ӷȣ�O��1��
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        /* ����������� */
        if (ransomNote == null || magazine == null || ransomNote.length() > magazine.length()) return false;
        /* ʹ�� map ��� */
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            map.put(ransomNote.charAt(i), map.getOrDefault(ransomNote.charAt(i), 0) + 1);
        }
        for (int i = 0; i < magazine.length(); i++) {
            if (map.containsKey(magazine.charAt(i))) {
                if (map.get(magazine.charAt(i)) == 1) {
                    map.remove(magazine.charAt(i));
                } else {
                    map.put(magazine.charAt(i), map.get(magazine.charAt(i)) - 1);
                }
            }
        }
        return map.isEmpty();
    }

}