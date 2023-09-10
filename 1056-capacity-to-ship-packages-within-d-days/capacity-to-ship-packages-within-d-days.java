class Solution {
    public int findMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
        }
        return max;
    }

    public int findSum(int[] nums){
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
        }
        return sum;
    }

    public int calculateDays(int [] nums, int mid){
        int days = 1;
        int load = 0;
        for(int i = 0;i<nums.length;i++){
            if(load + nums[i] > mid){
                days++;
                load=nums[i];
            }
            else{
                load+=nums[i];
            }
            
            
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = findMax(weights);
        int high = findSum(weights);
        while(low<=high){
            int mid = (high-low)/2+low;
            if(calculateDays(weights,mid)<=days){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}