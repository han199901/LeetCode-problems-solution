class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int newArr[] = new int[nums1.length+nums2.length];
        int i1=0,i2=0;
        for(int i=0; i<newArr.length; i++) {
            if(i1>=nums1.length) {
                newArr[i] = nums2[i2++];
            }
            else if(i2>=nums2.length) {
                newArr[i] = nums1[i1++];
            }
            else {
                if(nums1[i1]>nums2[i2])
                    newArr[i] = nums2[i2++];
                else
                    newArr[i] = nums1[i1++];
            }
        }
        if(newArr.length%2==0)
            return (double) (newArr[newArr.length/2-1]+newArr[newArr.length/2])/2;
        else
            return newArr[newArr.length/2];
    }
}