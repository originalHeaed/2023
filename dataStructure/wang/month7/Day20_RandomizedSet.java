package month7;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;

/**
 * ʱ�䣺2023/7/20
 * ����������
 *  ʵ��RandomizedSet �ࣺ
 *  RandomizedSet() ��ʼ�� RandomizedSet ����
 *  bool insert(int val) ��Ԫ�� val ������ʱ���򼯺��в����������� true �����򣬷��� false ��
 *  bool remove(int val) ��Ԫ�� val ����ʱ���Ӽ������Ƴ���������� true �����򣬷��� false ��
 *  int getRandom() ����������м����е�һ�����������֤���ô˷���ʱ���������ٴ���һ��Ԫ�أ���ÿ��Ԫ��Ӧ���� ��ͬ�ĸ��� �����ء�
 *  �����ʵ��������к�����������ÿ�������� ƽ�� ʱ�临�Ӷ�Ϊ O(1) ��
 * �����/���˼·��ʹ������ + hash ��
 * ���룺�е���˼
 */
public class Day20_RandomizedSet {

    /**
     * �������󳤶ȣ������������� 2 * 10^5��
     */
    private static final Integer MAX_LENGTH = 200001;

    /**
     * map ���Ԫ��ֵ��Ԫ���������е��±꣬��Ҫ���������ɾ��ʱʵ�� O��1��
     */
    private Map<Integer, Integer> map;

    /**
     * ��Ż�����Ԫ�أ�����ʵ���� O��1��ʱ�临�Ӷ��ڻ�ȡ���һ��Ԫ��
     */
    private int[] arr;

    /**
     * ��¼���һ������Ԫ���±�
     */
    private int count;

    public Day20_RandomizedSet() {
        map = new HashMap<>(MAX_LENGTH);
        arr = new int[MAX_LENGTH];
        count = -1;
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        arr[++count] = val;
        map.put(val, count);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        Integer index = map.remove(val);
        /* �����������һ��Ԫ�ز��䵽ɾ���ĵط� */
        arr[index] = arr[count];
        /* �������һ��Ԫ���� map �е��±꣨���ɾ���������һ��Ԫ�ؾͲ���Ҫ�����ˣ� */
        if (index != count) map.put(arr[count], index);
        count--;
        return true;
    }

    public int getRandom() {
        /* ����������� */
        if (count < 0) return -1;
        /* ��ȡ [0, count] ������±� */
        Random random = new Random();
        int i = random.nextInt(count + 1);
        return arr[i];
    }

    public static void main(String[] args) {
        System.out.println(10^5);
    }
}