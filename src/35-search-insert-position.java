class Solution {
    public int searchInsert(int[] nums, int target) {
        int i, index = -1;
        for (i = 0; i < nums.length; i++) {
            if (target < nums[i]) {
                index = i;
                break;
            }
            if (target == nums[i])
                return i;
        }
        if (i == nums.length)
            return nums.length;
        if (index == -1)
            return 0;
        return index;
    }
}