class Solution:
    def countSubIslands(self, grid1: List[List[int]], grid2: List[List[int]]) -> int:
        m = len(grid2)
        n = len(grid2[0])

        def dfs(grid,x,y,matrix):
            if x>=m or x<0 or y>=n or y<0 or grid[x][y]!=1:
                return True
            if matrix[x][y]!=1:
                return False
            grid2[x][y]=-1
            a = dfs(grid,x+1,y,matrix)
            b = dfs(grid,x,y+1,matrix)
            c = dfs(grid,x,y-1,matrix)
            d = dfs(grid,x-1,y,matrix)
            return a and b and c and d

        ans = 0
        for i in range(0,m):
            for j in range(0,n):
                if grid2[i][j]==1 and dfs(grid2,i,j,grid1):
                    ans = ans+1
        return ans