package month01;

import java.util.HashSet;
import java.util.Set;

public class Day03 {
    //======================================== 唯一摩尔斯密码词 =====================================
    /**
     * 给你一个字符串数组 words ，每个单词可以写成每个字母对应摩尔斯密码的组合。
     * 例如，"cab" 可以写成 "-.-..--..." ，(即 "-.-." + ".-" + "-..." 字符串的结合)。我们将这样一个连接过程称作 单词翻译 。
     * 对 words 中所有单词进行单词翻译，返回不同 单词翻译 的数量。
     */
    /**
     * 先对所有单子进行翻译，然后使用 hash 表
     * @param words
     * @return
     */
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> hashSet = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            char[] charArr = words[i].toCharArray();
            for (int j = 0; j < charArr.length; j++) {
                sb.append(arr[charArr[j]  - 'a']);
            }
            hashSet.add(sb.toString());
        }
        return hashSet.size();
    }
}
