class Solution {
    public String intToRoman(int num) {
        char[] c1 = {'I','X','C','M'};
        char[] c2 = {'V','L','D'};
        String r = "";
        for(int i = 0; num != 0; i++) {
            int j = num%10;
            num/=10;
            if(j >= 4) {
                if(j == 4)
                    r += (c2[i] + "" + c1[i]);
                else if(j == 9)
                    r += (c1[i+1] + "" + c1[i]);
                else {

                    j-=5;
                    while(j!=0) {
                        r += c1[i];
                        j--;
                    }
                    r += c2[i];
                }
            }
            else {
                while(j!=0) {
                    r += c1[i];
                    j--;
                }
            }
        }
        String result = "";
        for(int i=0; i< r.length(); i++) {
            result += r.charAt(r.length()-1-i);
        }
        return result;
    }
}



//更加简单的解法 ， 效率更高
class Solution {
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};  // 罗马数字
        int[] arab = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};  // 阿拉伯数字
        int index = 0;
        while (num > 0) {
            int count = num / arab[index];
            while (count-- > 0) {
                ans.append(roman[index]);
            }
            num %= arab[index];
            index++;
        }
        return ans.toString();
    }
}
