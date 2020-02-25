class Solution {
    public int romanToInt(String s) {
        char[] roman = {'M','D','C','L','X','V','I'};
        int[] arab = {1000,500,100,50,10,5,1};
        int pre=-1;
        int sum=0;
        for(int i=0; i<s.length(); i++) {
            for(int j=0; j<roman.length; j++) {
                if(roman[j]!=s.charAt(i))
                    continue;
                else if(j>=pre) {
                    sum+=arab[j];
                    pre=j;
                }
                else {
                    sum +=(-2*arab[pre]+arab[j]);
                }
            }
        }
        return sum;
    }
}