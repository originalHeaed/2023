package month08;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 时间：2023/8/8
 * 问题描述：
 *  给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 *  在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 *  请注意，返回的 规范路径 必须遵循下述格式：
 *  始终以斜杠 '/' 开头。
 *  两个目录名之间必须只有一个斜杠 '/' 。
 *  最后一个目录名（如果存在）不能 以 '/' 结尾。
 *  此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 *  返回简化后得到的 规范路径 。
 * 切入点/解决思路：使用栈
 * 感想：中等偏下
 */
public class Day08_simplifyPath {
    /**
     * 时间复杂度：O（n），空间复杂度：O（n）
     * 由于给出的是一个绝对有效的的 unix 风格路径，
     * 因此遇到正常文件入栈，遇到 "." 直接忽略，遇到 ".." 将栈顶元素移除
     * 最后将栈的元素拿出拼接即可
     */
    public String simplifyPath(String path) {
        /* 特殊情况处理 */
        if (path == null || path.length() == 0) return path;
        /* 获取简化后的有效路径 */
        Deque<String> stack = new ArrayDeque<>();
        char[] chars = path.toCharArray();
        StringBuilder sb;
        int index = 0;
        while (index < chars.length) {
            sb = new StringBuilder();
            /* 过滤 "/" */
            while (index < chars.length && chars[index] == '/') index++;
            /* 获取字符 */
            while (index < chars.length && chars[index] != '/') sb.append(chars[index++]);
            /* 对字符进行处理 */
            String tem = sb.toString();
            if (sb.length() == 0 || ".".equals(tem)) continue;
            else if ("..".equals(tem)) {
                if (!stack.isEmpty()) stack.pop();
            }
            else stack.push(tem);
        }
        /* 拼接有效字符串 */
        StringBuffer res =  new StringBuffer();
        if (stack.isEmpty()) res.append("/");
        else {
            while (!stack.isEmpty()) {
                res.append("/").append(stack.pollLast());
            }
        }
        return res.toString();
    }
}