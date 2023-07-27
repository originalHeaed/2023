package month7;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间：2023/7/27
 * 问题描述：
 * 给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * 切入点/解决思路：没啥难点
 * 感想：一般
 */
public class Day27_fullJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        /* 特殊情况处理 */
        if (words == null || words.length == 0 || maxWidth <= 0) return res;
        int index = 0;
        while (index < words.length) {
            /* 1. 需要本行需要加入的单词 */
            int length = words[index++].length(); // 已加入单词的总长度
            int i = 1; // 已加入的单词个数
            /* 已经加入该行单词总长度 + 假设每个单词一个空格分隔  <= maxWitdh 来计算该行可以加入的单词数量*/
            while (index < words.length) {
                if ((length + words[index].length() + i) <= maxWidth) {
                    length += words[index].length();
                    i++;
                } else break;
                index++;
            }
            /* 2. 将单词进行拼接 */
            StringBuilder sb = new StringBuilder();
            StringBuilder space = new StringBuilder(); // 每个单词间隔平均需要填充的空格
            int total = 0; // 前多少个间隔需要额外填充一个空格（但空格无法平均分布在间隔之间时，部分间隔需要额外补充空格）
            if (index == words.length) {
                /* 最后一行，单词间隔空格个数为一 */
                space.append(' ');
            } else {
                /* 只有加入的单词个数超过 1 一个，才需要计算单词之间的空格数量 */
                for (int j = 0; i > 1 && j < ((maxWidth - length) / (i - 1)); j++) {
                    space.append(' ');
                }
                total = i > 1 ? (maxWidth - length) % (i - 1) : 0;
            }
            /* 拼接字符串 */
            while (i > 0) {
                sb.append(words[index - i--]);
                if (i <= 0) break;
                sb.append(space);
                if (total-- > 0) sb.append(' ');
            }
            /* 末尾空格数 */
            for (int j = maxWidth - sb.length(); j > 0; j--) {
                sb.append(' ');
            }
            res.add(sb.toString());
        }
        return res;
    }
}