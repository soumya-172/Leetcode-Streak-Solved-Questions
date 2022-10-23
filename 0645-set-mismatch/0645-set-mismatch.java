class Solution {
    
    // missing and repeating number question
    
    public int[] findErrorNums(int[] nums) {
      long len = nums.length;
        
        long s = (len * (len + 1)) / 2;
        long p = (len * (len + 1) * (2 * len + 1)) / 6;
        
        long m_num = 0, r_num = 0;
        
        for(int i = 0; i < nums.length; i++){
            s -= (long) nums[i];
            p -= (long) nums[i] * (long) nums[i];
        }
        
        m_num = (s + p/s) / 2;
        r_num = m_num - s;
        
        int[] ans = new int[2];
        ans[0] = (int) r_num;
        ans[1] = (int) m_num;
        
        return ans;
    }
}