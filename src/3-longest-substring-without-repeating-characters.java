class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] freq = new char[256];
        // 设定s的[left,right]子串无重复字符
        int l = 0, r = -1;
        int max = 0;
        while (l < s.length()){
            if (r == s.length() - 1){
                break;
            }
            //ASCII标记是否重复 0为未重复,超过0为重复
            if (freq[s.charAt(r + 1)] == 0){
                freq[s.charAt(r + 1)]++;
                r++;
                //记录当前最大无重复字符串长度
                max = Math.max(max, r - l + 1);
            } else {
                freq[s.charAt(l)]--;
                l++;
            }
        }
        return max;
    }

}