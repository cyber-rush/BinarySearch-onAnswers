class Solution {
    public static int findTotalHrs(int piles[], int mid){
        int totalHours = 0;
        for(int i = 0;i<piles.length;i++){
            totalHours += Math.ceil((double)piles[i] / (double)mid);
        }
        return totalHours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<piles.length;i++){
            max = Math.max(max, piles[i]);
        }
        int low = 1;
        int high = max;
        while(low <= high){
            int mid = low + (high - low)/2;
            
            int totalHrs = findTotalHrs(piles, mid);
            
            if(totalHrs <= h){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}