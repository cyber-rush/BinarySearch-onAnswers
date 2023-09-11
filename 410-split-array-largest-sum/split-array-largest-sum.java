class Solution {
    public List<Integer> findMaxAndSum(int[] nums){
        List<Integer> list = new ArrayList<Integer>();
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
            }
            sum+=nums[i];
        }
        list.add(max);
        list.add(sum);
        return list;
    }
    public int subArrayCount(int[] nums, int mid){
        int sum = 0;
        int subArrays = 1;
        for(int i = 0;i<nums.length;i++){
            if(sum+nums[i]<=mid){
                sum+=nums[i];
            }
            else{
                subArrays++;
                sum=nums[i];
            }
        }
        return subArrays;
    }
    public int splitArray(int[] nums, int k) {
        int low = findMaxAndSum(nums).get(0);
        int high = findMaxAndSum(nums).get(1);

        while(low<=high){
            int mid = (high-low)/2+low;
            int countSubArrays = subArrayCount(nums,mid);

            if(countSubArrays<=k){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}