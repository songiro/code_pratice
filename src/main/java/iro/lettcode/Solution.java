package iro.lettcode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**************************************
     * @问题描述: 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * @问题链接: https://leetcode-cn.com/problems/two-sum/
     * @所属题型:
     * @是否通过:
     * @时间: 2021/10/11
    **************************************/

   /**
   * @描述: 两数之和暴力破解法
   * @时间复杂度: O(N ^ 2) 其中 N 是数组中的元素数量。最坏情况下数组中任意两个数都要被匹配一次
   * @空间复杂度: O(1)
   * @时间: 2021/10/11
   **/
    public int[] twoSumInVolience2(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
    * @描述: 两数之和哈希表法
    * @时间复杂度:  O(N)，其中 N 是数组中的元素数量。对于每一个元素 x，我们可以 O(1) 地寻找 target - x。
     * @空间复杂度: O(N)，其中 N 是数组中的元素数量。主要为哈希表的开销。
     * @时间: 2021/10/11
    **/
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }


    /**************************************
     * @问题描述: 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target,写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     * @问题链接: https://leetcode-cn.com/problems/binary-search/
     * @所属题型: 二分法
     * @是否通过:
     * @时间: 2021/10/11
    **************************************/

    /**
    * @描述: 左开右闭区间
    * @时间复杂度:
    * @空间复杂度:
    * @时间: 2021/10/11
    **/
    public int search(int[] nums, int target) {
        if(target < nums[0] || target > nums[nums.length - 1]){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int middle = left + ((right - left)/2);
            if(nums[middle] > target){
                right = middle - 1; // target 在左区间，所以[left, middle - 1]
            }else if(nums[middle] < target){
                left = middle + 1;  // target 在右区间，所以[middle + 1, right]
            }else
                return middle; // 数组中找到目标值，直接返回下标
        }
        return  -1;
    }
    /**
    * @描述: 左闭右开区间
    * @时间复杂度:
    * @空间复杂度:
    * @时间: 2021/10/11
    **/
    public int search2(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid; // 数组中找到目标值，直接返回下标
            else if (nums[mid] < target)
                left = mid + 1; // target 在右区间，在[middle + 1, right)中
            else if (nums[mid] > target)
                right = mid; // target 在左区间，在[left, middle)中
        }
        return -1;
    }
}
