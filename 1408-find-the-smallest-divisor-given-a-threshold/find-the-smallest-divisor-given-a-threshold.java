class Solution {
    public int findMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
        }
        return max;
    }
    public int findSum(int[] nums, int mid){
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum+=Math.ceil((double)nums[i]/(double)mid);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = findMax(nums);
        int ans = -1;
        while(low<=high){
            int mid = (high-low)/2 + low;

            if(findSum(nums,mid)<=threshold){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}