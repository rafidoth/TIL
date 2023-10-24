# 162. Find Peak Element

[Problem Link](https://leetcode.com/problems/find-peak-element/)
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.

```java
class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int start = 1;
        int end = len -2;
        if(len==1|| nums[0]>nums[1]) return 0;
        else if (nums[len-1]>nums[len-2]) return len-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid]>nums[mid -1]&& nums[mid]> nums[mid+1]) return mid;
            else if(nums[mid+1]> nums[mid]){
                start = mid + 1;
            }else{ // [1,5,1,2,1]
                end = mid -1;
            }
        }
        return -1;
    }
}
```
