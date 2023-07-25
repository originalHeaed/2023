package month7;

/**
 * ʱ�䣺2023/7/25
 * ����������
 * �����/���˼·��
 * ���룺
 */
public class Day25_lengthOfLastWord {
    public int lengthOfLastWord(String s) {
        /* ����������� */
        if (s == null || s.length() == 0) return 0;
        /* ��ʼ���� */
        int index = s.length() - 1;
        int total = 0;
        while (index >= 0 && s.charAt(index) == ' ') index--; // ȥ��ĩβ�ո�
        while (index >= 0 && s.charAt(index--) != ' ') total++;
        return total;
    }
}