class Solution {
    public int reverse(int x) {
        long r=0;
        int max = 0x7fffffff, min = 0x80000000;
        while(x!=0) {
            r*=10;
            r+=x%10;
            x/=10;
        }
        return r>max||r<min?0:(int)r;
    }
}