
"
Start BFS from all rotten orange point  and grow in radially with time 
and atlast all check all oranges are rotten or not 
which can also be done
"
class Solution {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        // put all initially rotten orange into queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) q.offer(new int[] { i, j }); 
                else if (grid[i][j] == 1) fresh += 1;
            }
        }
        q.offer(null); // mark for intial rooten orange
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int time = 0;
        while (q.size() > 1) {
            int[] cor = q.poll();

            if (cor == null) {
                time++;
                q.offer(null);
                continue;
            }

            // explore all neighbour on these coordinates
            for (int d[] : dir) {
                int x = d[0] + cor[0];
                int y = d[1] + cor[1];
                if (x < 0 || y < 0 || x >= m || y >= n) continue;
                if (grid[x][y] == 1) {
                    fresh -= 1;
                    q.offer(new int[] { x, y });
                    grid[x][y] = 2;
                }
            }
        }

        return fresh==0?time:-1;
    }
}
