class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length;j++) {
                if(nums[i]>nums[j])
                    res[i]++;
                else if(nums[j]>nums[i])
                    res[j]++;
            }
        }
        return res;
    }
}