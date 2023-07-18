class Solution:
    def longestWPI(self, hours: List[int]) -> int:
        n = len(hours)
        sum = [0] * (n+1)
        st = [0]

        for j,h in enumerate(hours,1):
            sum[j] = sum[j-1] + (1 if h > 8 else -1)
            if sum[j]<sum[st[-1]]:
                st.append(j)
        ans = 0
        for i in range(n,0,-1):
            while st and sum[i]>sum[st[-1]]:
               ans=max(ans,i-st[-1])
               st.pop()

        return ans