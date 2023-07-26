package month7;

/**
 * ʱ�䣺2023/7/26
 * ����������
 *  ��дһ�������������ַ��������е������ǰ׺��
 *  ��������ڹ���ǰ׺�����ؿ��ַ��� ""��
 * �����/���˼·����������˼·
 * ���룺��
 */
public class Day26_longestCommonPrefix {

    /**
     * ʱ�临�Ӷȣ�O(n * m)���ռ临�Ӷȣ�O��n����m ���ǰ׺�ĳ���
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        /* ����������� */
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        /* ��ʼ�������ǰ׺ */
        int index = 0;
        while (isEqual(strs, index)) index++;
        return strs[0].substring(0, index);
    }

    private boolean isEqual(String[] arr, int index) {
        if (index >= arr[0].length()) return false;
        for (int i = 1; i < arr.length; i++) {
            if (index >= arr[i].length() || arr[i].charAt(index) != arr[0].charAt(index)) return false;
        }
        return true;
    }
}