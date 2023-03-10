package top.itweixiang;

import java.util.Arrays;

/**
 * 《二分查找》
 * <p>
 * 请实现有重复数字的升序数组的二分查找
 * 给定一个 元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的第一个出现的target，如果目标值存在返回下标，否则返回 -1
 */
public class NC105 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 如果目标值存在返回下标，否则返回 -1
     *
     * @param nums   int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int mid = left + (right - left) / 2;

        while (left < right) {
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                //找到第一个点
                while (mid >= left && nums[mid] == target) {
                    mid--;
                }
                return mid + 1;
            }
            //中点条件
            mid = left + (right - left) / 2;
        }
        return -1;
    }
}
