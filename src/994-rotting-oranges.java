//优先队列+BFS
class Solution {
    public int orangesRotting(int[][] grid) {
        int sum = 0;
        Queue<Integer> p = new LinkedList<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    p.add(i);
                    p.add(j);
                }
            }
        }

        while (!p.isEmpty() || !q.isEmpty()) {
            if (p.isEmpty() && !q.isEmpty()) {
                p = q;
                q = new LinkedList<Integer>();
                sum++;
            }
            int i = p.poll();
            int j = p.poll();
            int isub = i - 1, iadd = i + 1, jsub = j - 1, jadd = j + 1;
            if (isub >= 0 && grid[isub][j] == 1) {
                q.add(isub);
                q.add(j);
                grid[isub][j]++;
            }
            if (iadd < grid.length && grid[iadd][j] == 1) {
                q.add(iadd);
                q.add(j);
                grid[iadd][j]++;
            }
            if (jsub >= 0 && grid[i][jsub] == 1) {
                q.add(i);
                q.add(jsub);
                grid[i][jsub]++;
            }
            if (jadd < grid[i].length && grid[i][jadd] == 1) {
                q.add(i);
                q.add(jadd);
                grid[i][jadd]++;
            }

        }
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == 1)
                    return -1;
        return sum;
    }
}