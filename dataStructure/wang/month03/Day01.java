package month03;

import sun.applet.Main;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Day01 {
    public int leastBricks(List<List<Integer>> wall) {
        /* 特殊情况处理 */
        if (wall == null || wall.size() == 0) return -1;
        /* 获取每行砖缝隙所处位置，并将其存入 map，key 为缝隙位置，value 为出现次数 */
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int position = 0; // 改行缝隙所处位置
            int n = list.size() - 1;
            for (int i = 0; i < n; i++) {
                position += list.get(i);
                map.put(position, map.getOrDefault(position, 0) + 1);
            }
        }
        /* 获取 map 中出现次数最多的缝隙 */
        int maxTime = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxTime = maxTime > entry.getValue() ?  maxTime : entry.getValue();
        }
        /* 获取需要穿越的墙数 */
        return wall.size() - maxTime;
    }

    /**
     * 时间复杂度：O（n^2）
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        /* 特殊情况处理 */
        if (s == null || s.length() == 1) return false;
        int n = s.length() / 2;
        /* 使用暴力法获取重复串 */
        for (int i = 1; i <= n; i++) {
            boolean help = help(s.substring(0, i), s);
            if (help) return true;
        }
        return false;
    }

    /**
     * 判断 s 是否由 unit 组成
     * @param unit
     * @param s
     * @return true - 是，false - 否
     */
    private boolean help(String unit, String s) {
        /* 特殊情况判断 */
        if ("".equals(unit)) return false;

        int left = unit.length();
        int right = left + unit.length();
        while (right <= s.length()) {
            if (!unit.equals(s.substring(left, right))) return false;
            left = right;
            right = left + unit.length();
        }
        /* 整个 s 全部由 unit 组成，没有多余的字符 */
        if (left == s.length()) return true;
        return false;
    }

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("123");
        List list2 = list;
        list2.add(43);
        Object o = list2.get(1);
        System.out.println(o);
    }
}
