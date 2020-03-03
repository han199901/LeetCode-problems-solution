class Solution {
    public static void merge(int[] A, int m, int[] B, int n) {
        int[] temp = new int[A.length];
        int x = 0, y = 0;
        int len = m + n;
        for (int i = 0; i < len; i++) {
            if (x < m && y < n) {
                if (B[y] < A[x])
                    temp[i] = B[y++];
                else
                    temp[i] = A[x++];
            } else {
                if (x < m)
                    temp[i] = A[x++];
                else
                    temp[i] = B[y++];
            }
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = temp[i];
        }
    }
}


/************  better method  ******************/
class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        // 先确保将其中一个数组中的数字遍历完
        while (m > 0 && n > 0) {
            // 对比选出较大的数放在 m + n - 1 的位置，并将选出此数的指针向前移动
            A[m + n - 1] = A[m - 1] > B[n - 1] ? A[m-- - 1] : B[n-- - 1];
        }
        // 剩下的数都比已经遍历过的数小
        // 如果 m 不为 0，则 A 没遍历完，都已经在 A 中不用再管
        // 如果 n 不为 0，则 B 没遍历完，直接全移到 A 中相同的位置
        while (n > 0) {
            A[n - 1] = B[n - 1];
            n--;
        }
    }
}