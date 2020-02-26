class Solution {
    public String longestCommonPrefix(String[] strs) {
        char c;
        int minLen = 100000000;
        String r = "";
        for(int i=0; i<strs.length; i++) {
            if (strs[i].length() < minLen)
                minLen = strs[i].length();
        }
        if (minLen==0||strs.length==0)
            return "";
        for(int i=0; i<minLen; i++) {
            for(int j=0;j<strs.length; j++) {
                if (strs[j].charAt(i)!=strs[0].charAt(i)) {
                    return r;
                }
            }
            r += strs[0].charAt(i);
        }
        return r;
    }
}