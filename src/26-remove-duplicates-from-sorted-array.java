class Solution {
    public int removeDuplicates(int[] nums) {
        int sum = 0;
        int j = -1;
        for (int i = 0; i < nums.length; ) {
            if (i == 0 || nums[i] != nums[j]) {
                sum++;
                nums[++j] = nums[i];
                i++;
            } else
                i++;
        }
        return sum;
    }
}