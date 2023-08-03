package month08;

import java.util.ArrayList;
import java.util.List;

/**
 * ʱ�䣺2023/8/3
 * ����������
 *  ����һ��  ���ظ�Ԫ�� �� ���� �������� nums ��
 *  ���� ǡ�ø����������������� �� ��С���� ���䷶Χ�б� ��Ҳ����˵��nums ��ÿ��Ԫ�ض�ǡ�ñ�ĳ�����䷶Χ�����ǣ����Ҳ���������ĳ����Χ�������� nums ������ x ��
 *  �б��е�ÿ�����䷶Χ [a,b] Ӧ�ð����¸�ʽ�����
 *  "a->b" ����� a != b
 *  "a" ����� a == b
 * �����/���˼·��ʹ�û�������
 * ���룺��ƫ��
 */
public class Day03_summaryRanges {

    /**
     * ʱ�临�Ӷȣ�O��n�����ռ临�Ӷȣ�O��n��
     */
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> arrayList = new ArrayList<>();
        /* ����������� */
        if (nums == null || nums.length == 0) return new ArrayList<>();
        /* ʹ�û������� */
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[right] - 1 != nums[left]) {
                if (right - 1 == left) arrayList.add(String.valueOf(nums[left]));
                else arrayList.add(nums[left] + "->" + nums[right - 1]);
                left = right;
            }
            right++;
        }
        /* ���һ������Ĵ��� */
        if (right - 1 == left) arrayList.add(String.valueOf(nums[left]));
        else arrayList.add(nums[left] + "->" + nums[right - 1]);
        return arrayList;
    }

}