# -- coding: utf-8 --
# @Time : 2023/8/14 12:40
# @Author : Fuyun Wang
# @Email : fuyunwang2021@gmail.com
# @Description: 匈牙利算法
from collections import defaultdict

if __name__ == '__main__':
    # 假设输入的方式是： 首先给定一行，分别包含了图中
    n1, n2, m = map(int, input().split())
    graph = defaultdict(list)

    for _ in range(m):
        a,b  = map(int,input().split())  # 依次枚举边相连的两个顶点
        graph[a].append(b)  # 构图

    st = [False] * (n2 + 1)  # 记录顶点是否访问
    match = [0] * (n2 + 1)  # 记录顶点所构成的匹配顶点，初始表示未匹配任何顶点
    def find(x):  # 含义：当输入当前顶点x时，是否可以增大匹配数，如果可以，返回True否则返回False
        for j in graph[x]:
            if not st[j]: # 当前邻居顶点未被访问
                st[j] = True
                if match[j] == 0 or find(match[j]):
                    match[j] = x
                    return True
        return False
    res = 0 # 记录最大匹配数
    for i in range(1,n1+1):
        if find(i):
            res = res + 1
    print(res)