# -- coding: utf-8 --
# @Time : 2023/8/15 12:17
# @Author : Fuyun Wang
# @Email : fuyunwang2021@gmail.com
# @Description: 单调队列
from collections import deque
# 给定列表长度、滑动窗口长度，然后分别给出列表中元素，求窗口内最大值和最小值

if __name__ == '__main__':
    len, k = map(int,input().split())
    nums = list(map(int,input().split()))

    # 求最大值
    res_max = []
    queue = deque([]) # 维护单调递减队列， 存的是索引
    for i in range(len(nums)):
        if queue and i-queue[0]+1>k: # 超出了滑动窗口范围，弹出
            queue.popleft() # 弹出队头
        while queue and nums[queue[-1]]<=nums[i]:
            queue.pop() # 弹出队尾
        queue.append(i)
        if i>=k-1: # 此时说明当前唯一一定可以构成一个滑动窗口
            res_max.append(nums[queue[0]])
    print(''.join(map(str,res_max)))

    # 求最小值
    res_min = []
    queue = deque([])
    for i in range(len(nums)):
        if queue and i-queue[0]+1>k:
            queue.popleft()
        while queue and nums[queue[-1]]>=nums[i]:
            queue.pop()
        queue.append(i)
        if i>=k-1:
            res_min.append(nums[queue[0]])
    print(''.join(map(str,res_min)))