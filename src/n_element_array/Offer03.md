#! https://zhuanlan.zhihu.com/p/609953678
# 剑指 Offer 03. 数组中重复的数字

> 找出数组中重复的数字。
>
> 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

> 链接：https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof


## 方法一
使用集合,遍历数组如果当前遍历的数已经在集合中则返回这个数,否则将当前数放入集合中,直到遍历完成。

&nbsp;

&nbsp;

## 方法二
使用集合的方法没有充分利用题目条件，空间复杂度为$O(n)$。对于长度为$n$的数组nums，并且$nums[i] \in [0, n - 1]$。如果数组中没有重复元素，将数组排序后有$nums[i] == i$。如果数组中有重复元素，假设重复元素为$x$, 则下标$x$会对应多个元素。

从左到右遍历数组，如果 $nums[i] == i$ 则继续遍历下一个。否则，判断 $nums[nums[i]]$与$nums[i]$ 是否相等，如果相等则找到了两个重复的数，直接返回 $nums[i]$ 即可。

如果不相等，交换 $nums[nums[i]]$ 与 $nums[i]$ 的位置，即将元素 $nums[i]$ 放到位置 $nums[i]$ 上，将元素 $nums[nums[i]]$ 放到位置 $i$ 上。这样就将元素$nums[i]$放到了排序后它应该在的位置上。重复以上步骤直到$nums[i] == i$或找到重复数字。

C++
```C++
int findRepeatNumber(vector<int>& nums) {
        int i = 0;
        while (i < nums.size()) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
            i++;
        }
        return -1;
    }
```

&nbsp;

Java
```Java
class Solution {
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        
        while (i < nums.length) {
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
            i++;
        }
        return -1;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
```


&nbsp;

Python

```Python
class Solution:
    def findRepeatNumber(self, nums: List[int]) -> int:
        i = 0
        while i < len(nums):
            while nums[i] != i:
                if nums[i] == nums[nums[i]]:
                    return nums[i]
                tmp = nums[i]
                nums[i] = nums[tmp]
                nums[tmp] = tmp
            
            i += 1
        
        return -1
```
