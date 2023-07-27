package month7;

import java.util.ArrayList;
import java.util.List;

/**
 * ʱ�䣺2023/7/27
 * ����������
 * ����һ���������� words ��һ������ maxWidth �������Ű浥�ʣ�ʹ���Ϊÿ��ǡ���� maxWidth ���ַ������������˶�����ı���
 * ��Ӧ��ʹ�� ��̰���㷨�� �����ø����ĵ��ʣ�Ҳ����˵�������ܶ����ÿ���з��õ��ʡ���Ҫʱ���ÿո� ' ' ��䣬ʹ��ÿ��ǡ���� maxWidth ���ַ���
 * Ҫ�󾡿��ܾ��ȷ��䵥�ʼ�Ŀո����������ĳһ�е��ʼ�Ŀո��ܾ��ȷ��䣬�������õĿո���Ҫ�����Ҳ�Ŀո�����
 * �ı������һ��ӦΪ����룬�ҵ���֮�䲻�������Ŀո�
 * �����/���˼·��ûɶ�ѵ�
 * ���룺һ��
 */
public class Day27_fullJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        /* ����������� */
        if (words == null || words.length == 0 || maxWidth <= 0) return res;
        int index = 0;
        while (index < words.length) {
            /* 1. ��Ҫ������Ҫ����ĵ��� */
            int length = words[index++].length(); // �Ѽ��뵥�ʵ��ܳ���
            int i = 1; // �Ѽ���ĵ��ʸ���
            /* �Ѿ�������е����ܳ��� + ����ÿ������һ���ո�ָ�  <= maxWitdh ��������п��Լ���ĵ�������*/
            while (index < words.length) {
                if ((length + words[index].length() + i) <= maxWidth) {
                    length += words[index].length();
                    i++;
                } else break;
                index++;
            }
            /* 2. �����ʽ���ƴ�� */
            StringBuilder sb = new StringBuilder();
            StringBuilder space = new StringBuilder(); // ÿ�����ʼ��ƽ����Ҫ���Ŀո�
            int total = 0; // ǰ���ٸ������Ҫ�������һ���ո񣨵��ո��޷�ƽ���ֲ��ڼ��֮��ʱ�����ּ����Ҫ���ⲹ��ո�
            if (index == words.length) {
                /* ���һ�У����ʼ���ո����Ϊһ */
                space.append(' ');
            } else {
                /* ֻ�м���ĵ��ʸ������� 1 һ��������Ҫ���㵥��֮��Ŀո����� */
                for (int j = 0; i > 1 && j < ((maxWidth - length) / (i - 1)); j++) {
                    space.append(' ');
                }
                total = i > 1 ? (maxWidth - length) % (i - 1) : 0;
            }
            /* ƴ���ַ��� */
            while (i > 0) {
                sb.append(words[index - i--]);
                if (i <= 0) break;
                sb.append(space);
                if (total-- > 0) sb.append(' ');
            }
            /* ĩβ�ո��� */
            for (int j = maxWidth - sb.length(); j > 0; j--) {
                sb.append(' ');
            }
            res.add(sb.toString());
        }
        return res;
    }
}