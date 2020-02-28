class Solution {
    public int removeElement(int[] nums, int val) {
        int cur = -1;
        int length = 0;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] != val) {
                length++;
                nums[++cur] = nums[i];
                i++;
            } else
                i++;
        }
        return length;
    }
}