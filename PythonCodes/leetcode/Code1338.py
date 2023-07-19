import collections


class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        freq = collections.Counter(arr)
        count = 0
        ans = 0
        for val,cnt in freq.most_common():
            count = count+cnt
            ans = ans+1
            if count*2 >= len(arr):
                break
        return ans