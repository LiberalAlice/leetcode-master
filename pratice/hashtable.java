package pratice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author：wuwei
 * @name：hashtable
 * @Date：2022/12/19 16:58
 */
public class hashtable {
    //快乐数
    HashSet<Integer> set = new HashSet<>();

    //有效的字母异位词
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (Character c : chars
        ) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        char[] array = t.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                Integer sum = map.get(array[i]);
                map.put(array[i], --sum);
            } else return false;
        }
        for (int i : map.values()
        ) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    //两个数组的交集
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums1
        ) {
            set.add(x);
        }
        for (int x : nums2
        ) {
            if (set.contains(x)) {
                list.add(x);
            }
        }
        return list.stream().mapToInt(x -> x).toArray();
    }

    public boolean isHappy(int n) {
        int[] a = new int[10];
        int index = 0;
        while (n > 0) {
            a[index++] = (int) (n % (Math.pow(10, index)));
            n /= 10;
        }
        n = 0;
        for (int x : a
        ) {
            n += x * x;
        }
        if (n == 1) {
            return true;
        }
        if (set.contains(n)) {
            return false;
        } else set.add(n);
        return isHappy(n);
    }

    //两数之和
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
            }
        }
        return result;
    }

    //四数相加 II
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums1) {
            for (int y : nums2) {
                int temp = x + y;
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }
        int count = 0;
        for (int x: nums3) {
            for (int y : nums4) {
                int temp = x + y;
                if (map.containsKey(0 - temp)) {
                    count += map.get(temp);
                }
            }
        }
        return count;
    }
    //赎金信
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        char[] chars = magazine.toCharArray();
        for (Character s: chars
             ) {
            arr[(s - 'a')] = 1;
        }
        char[] charArray = ransomNote.toCharArray();
        for (Character c: charArray
             ) {
            arr[(c - 'a')] -= 1;
        }
        for (int x: arr
             ) {
            if (x < 0) {
                return false;
            }
        }
        return true;
    }
}



