class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 1000000000;
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (!isEatUp(piles, h, mid)) {
                low = mid + 1;
            }
            else{
                high = mid;
            }  
        }
        
        return low;
    }
    
    public boolean isEatUp(int[] piles, int h, int k) {
        int time = 0;
        for (int pile : piles) {
            int addition = pile % k == 0 ? 0 : 1;
            time = time + pile / k + addition;
        }
        
        return time <= h;
    }
}
