class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] freq = new char[256];
        // �趨s��[left,right]�Ӵ����ظ��ַ�
        int l = 0, r = -1;
        int max = 0;
        while (l < s.length()){
            if (r == s.length() - 1){
                break;
            }
            //ASCII����Ƿ��ظ� 0Ϊδ�ظ�,����0Ϊ�ظ�
            if (freq[s.charAt(r + 1)] == 0){
                freq[s.charAt(r + 1)]++;
                r++;
                //��¼��ǰ������ظ��ַ�������
                max = Math.max(max, r - l + 1);
            } else {
                freq[s.charAt(l)]--;
                l++;
            }
        }
        return max;
    }

}