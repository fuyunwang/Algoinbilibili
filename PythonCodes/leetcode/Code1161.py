import collections


class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        ans,level,queue,sum = 0,0,collections.deque(root),-inf

        while queue:
            s = 0
            level = level+1
            for i in range(len(queue)):
                node = queue.popleft()
                s = s+node.val
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            if sum<s:
                ans,sum=level,s
        return ans