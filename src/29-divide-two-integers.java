class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0 || divisor == 1)
            return dividend;
        else if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE)
                return -dividend;
            else
                return Integer.MAX_VALUE;
        } else {
            int sign = 1;
            if ((dividend ^ divisor) < 0)
                sign = -1;
            dividend = dividend < 0 ? dividend : -dividend;
            divisor = divisor < 0 ? divisor : -divisor;
            int result = Binary_Search(dividend, divisor);
            if (sign > 0)
                return result;
            else
                return -result;
        }

    }
    /**
     * 举个例子：11 除以 3 。
     * 首先11比3大，结果至少是1， 然后我让3翻倍，就是6，
     * 发现11比3翻倍后还要大，那么结果就至少是2了，那我让这个6再翻倍，
     * 得12，11不比12大，吓死我了，差点让就让刚才的最小解2也翻倍得到4了。
     * 但是我知道最终结果肯定在2和4之间。也就是说2再加上某个数，这个数是多少呢？
     * 我让11减去刚才最后一次的结果6，剩下5，我们计算5是3的几倍，也就是除法，看，递归出现了。
     */
    private static int Binary_Search(int dividend, int divisor) {
        if (dividend > divisor)
            return 0;
        int count = 1;
        int t_divisor = divisor;
        while ((t_divisor + t_divisor) >= dividend) {
            if (t_divisor < -1073741824) //MAX_VALUE / 2
                break;
            count += count;
            t_divisor += t_divisor;
        }
        return count + Binary_Search(dividend - t_divisor, divisor);
    }
}