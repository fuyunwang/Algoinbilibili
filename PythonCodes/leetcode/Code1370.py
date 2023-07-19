import collections


class Solution:
    def sortString(self, s: str) -> str:
        s_counter = collections.Counter(s)
        result = []
        flag = False
        while s_counter:
            keys = list(s_counter.keys())
            keys = sorted(keys,reverse=flag)
            flag = not flag
            result.append(''.join(keys))
            s_counter = s_counter-collections.Counter(keys)
        return ''.join(result)