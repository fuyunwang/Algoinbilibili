# -- coding: utf-8 --
# @Time : 2023/8/15 12:17
# @Author : Fuyun Wang
# @Email : fuyunwang2021@gmail.com
# @Description: 单调栈

# 给定列表长度和列表中元素，求每个数左边第一个比它小的数
if __name__ == '__main__':
    len = map(int,input())
    nums = list(map(int,input()))

    res = [] # 存结果
    stack = [] # 维护一个单调递增栈，可以存索引，可以存值。为了统一，这次我们的模板代码都是存值
    for i in range(len):
        while stack and stack[-1]>=nums[i]:
            stack.pop()
        if stack:
            res.append(stack[-1])
        else:
            res.append(-1)
        stack.append(nums[i])
    print(''.join(map(str,res)))

class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        res = {}
        stack = [] # 单调递减栈
        for i in range(len(nums2)-1,-1,-1):
            while stack and stack[-1]<=nums2[i]:
                stack.pop()
            if stack:
                res[nums2[i]] = stack[-1]
            else:
                res[nums2[i]] = -1
            stack.append(nums2[i])
        return [res.get(x,-1) for x in nums1]