//将数字逆置后和原数字对比
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int r=0,y=0;
        int q=x;
        while(q!=0) {
            r=q%10;
            y=y*10+r;
            q=q/10;
        }
        return y==x;
    }
}