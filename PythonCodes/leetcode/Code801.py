class Solution(object):
    def minSwap(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: int
        """
        length = len(nums1)
        inf = float('inf')
        dp = [[inf]*2 for _ in range(length)]
        dp[0][0]=0
        dp[0][1]=1
        for i in range(1,length):
            if nums1[i-1]<nums1[i] and nums2[i-1]<nums2[i]:
                dp[i][0]=min(dp[i][0],dp[i-1][0])
                dp[i][1]=min(dp[i][1],dp[i-1][1]+1)
            if nums2[i-1]<nums1[i] and nums1[i-1]<nums2[i]:
                dp[i][0] = min(dp[i][0], dp[i - 1][1])
                dp[i][1] = min(dp[i][1], dp[i - 1][0] + 1)
        return min(dp[length-1][0],dp[length-1][1])