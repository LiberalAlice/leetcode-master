package pratice;

/**
 * @Author：wuwei
 * @name：nums
 * @Date：2022/12/13 13:51
 */
public class nums {

    // 二分查找
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left <= right) {
            if (nums[left] < target) {
                left++;
            } else if (nums[right] > target) {
                right--;
            } else break;
        }
        return left;
    }
    //移除元素
    public int removeElement(int[] nums, int val) {
        int right = 0;
        for (int left = 0; left < nums.length; left++) {
            if (nums[left] == val) {
                continue;
            }
            nums[right] = nums[left];
            right++;
        }
        return right;
    }
    //有序数组的平方
    public int[] sortedSquares(int[] nums) {
        int result[] = nums.clone();
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        while (left <= right && index >= 0) {
            if ((nums[right] * nums[right]) >= nums[left] * nums[left]) {
                nums[index] = nums[right] * nums[right];
                right--;
            } else {
                nums[index] = nums[left] * nums[left];
            }
            index--;
        }
        return result;
    }
    //长度最小的子数组
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int low = 0;
        int result = Integer.MAX_VALUE;
        for (int fast = 0; fast < nums.length; fast++) {
            sum += nums[fast];
            while (sum >= target) {
                result = Math.min(fast - low + 1, result);
                sum -= nums[low++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
