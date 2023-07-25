package month7;

/**
 * 时间：2023/7/25
 * 问题描述：将阿拉伯数字转为罗马数字
 * 切入点/解决思路：按照规律转即可
 * 感想：比普通稍难
 */
public class Day25_intToRoman {
    public String intToRoman(int num) {
        /* 特殊情况处理 */
        if (num <= 0) return "";
        /* 将数字转为罗马数字 */
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
     * 由于 num 值在 [1, 3999] 之间，因此可以使用这种方法
     */
    private String getRoma(int val, int digit) {
        char five = ' ';
        char single = ' ';
        switch (digit) {
            case 1: // 个位
                if (val == 4) return "IV";
                else if (val == 9) return "IX";
                five = 'V';
                single = 'I';
                break;
            case 2: // 十位
                if (val == 4) return "XL";
                else if (val == 9) return "XC";
                five = 'L';
                single = 'X';
                break;
            case 3: // 百位
                if (val == 4) return "CD";
                else if (val == 9) return "CM";
                five = 'D';
                single = 'C';
                break;
            case 4: // 千位
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