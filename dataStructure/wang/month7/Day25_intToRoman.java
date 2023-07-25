package month7;

/**
 * ʱ�䣺2023/7/25
 * ����������������������תΪ��������
 * �����/���˼·�����չ���ת����
 * ���룺����ͨ����
 */
public class Day25_intToRoman {
    public String intToRoman(int num) {
        /* ����������� */
        if (num <= 0) return "";
        /* ������תΪ�������� */
        int digit = 0;
        String res = "";
        while (num > 0) {
            int val = num % 10;
            digit++;
            num /= 10;
            res = getRoma(val, digit) + res;
        }
        return res;
    }

    /**
     * ���� num ֵ�� [1, 3999] ֮�䣬��˿���ʹ�����ַ���
     */
    private String getRoma(int val, int digit) {
        char five = ' ';
        char single = ' ';
        switch (digit) {
            case 1: // ��λ
                if (val == 4) return "IV";
                else if (val == 9) return "IX";
                five = 'V';
                single = 'I';
                break;
            case 2: // ʮλ
                if (val == 4) return "XL";
                else if (val == 9) return "XC";
                five = 'L';
                single = 'X';
                break;
            case 3: // ��λ
                if (val == 4) return "CD";
                else if (val == 9) return "CM";
                five = 'D';
                single = 'C';
                break;
            case 4: // ǧλ
                single = 'M';
                break;
        }
        StringBuilder sb = new StringBuilder();
        if (val >= 5) {
            sb.append(five);
            val -= 5;
        }
        for (int i = 0; i < val; i++) {
            sb.append(single);
        }
        return sb.toString();
    }
}