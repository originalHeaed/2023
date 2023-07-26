package month7;

import java.util.Arrays;

/**
 * ʱ�䣺2023/7/26
 * ����������
 *  ��һ�������ַ��� s ���ݸ��������� numRows ���Դ������¡������ҽ��� Z �������С�
 *  ��һ�������ַ��� s ���ݸ��������� numRows ���Դ������¡������ҽ��� Z �������С�
 * �����/���˼·��ֱ�Ӳ���ȡģ�㷨
 * ���룺��
 */
public class Day26_convert {
    /**
     * ʱ�临�Ӷȣ�O��n��
     * �ռ临�Ӷȣ�O��n��
     */
    public String convert(String s, int numRows) {
        /* ���⴦�� */
        if (s == null || s.length() == 0 || numRows <= 1) return s;
        /* ��ȡÿ�еĴ����� */
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) builders[i] = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            for (int i = 0; i < numRows && index < s.length(); i++, index++) {
                builders[i].append(s.charAt(index));
            }
            for (int i = numRows - 2; i > 0 && index < s.length(); i--, index++) {
                builders[i].append(s.charAt(index));
            }
        }
        /* ƴ�����ս�� */
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            res.append(builders[i].toString());
        }
        return res.toString();
    }
}