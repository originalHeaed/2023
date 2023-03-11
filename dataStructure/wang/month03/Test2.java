package month03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test2 {
    /**
     * 计算新词总数
     * 使用双指针
     */
    public static int heper(String content, String word) {
        /* 特殊情况判断 */
        if (content.equals(word)) return 1;
        if (content.length() < word.length() || word.length() == 0) return 0;
        /* 进行处理 */
        Map<Character, Integer> map1 = new HashMap<>(); // 获取 word 出现的所有字符,以及出现次数
        Map<Character, Integer> map2 = new HashMap<>(); // 获取 content 可能出现的目标字符,以及出现次数
        int res = 0;
        for (char c : word.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        char[] contentChars = content.toCharArray();
        int left = 0;
        int right = 0;
        for (; right < contentChars.length; right++) {
            if (right < contentChars.length) map2.put(contentChars[right], map2.getOrDefault(contentChars[right], 0) + 1);
            /* 判断窗口是否需要收缩 */
            if ((right - left + 1) == word.length()) {
                if (mapIsEqual(map1, map2)) res++;
                int time = map2.get(contentChars[left]) - 1;
                // 将窗口左边收缩
                if (time == 0) map2.remove(contentChars[left]);
                else map2.put(contentChars[left], time);
                left++;
            }
        }
        return res;
    }

    /**
     * 比较两个 map 中数据是否一致
     */
    public static boolean mapIsEqual(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if (map1.size() != map2.size()) return false;
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            /* key 不存在或 value 不相等 */
            if (!map2.containsKey(entry.getKey()) || map2.get(entry.getKey()) != entry.getValue()) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        /* 获取输入数据 */
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine();
        String word = scanner.nextLine();
        /* 获取结果 */
        System.out.println(heper(content, word));
    }
}
