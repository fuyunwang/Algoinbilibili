import collections


class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        ans = 0
        cnt = collections.Counter(chars)
        for word in words:
            w = collections.Counter(word)
            if all([w[i]<=cnt[i] for i in word]):
                ans = ans+len(word)
        return ans