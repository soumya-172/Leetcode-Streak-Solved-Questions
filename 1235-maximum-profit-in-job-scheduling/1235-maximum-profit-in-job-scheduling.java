class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        // tc -> O(NlogN)
        // sc -> O(N)
        
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        
        for(int i = 0; i < n; i++){
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        
        Arrays.sort(jobs, (a,b) -> a[1] - b[1]); // jobs array sorted in descending order by endtime
        
        TreeMap<Integer,Integer> dp = new TreeMap<>(); // it stores all the value in sorted manner
        dp.put(0,0);
        
        for(int[] job : jobs) {
            
            int val = job[2] + dp.floorEntry(job[0]).getValue(); // floorEntry() gives the lowest entry
            
            if(val > dp.lastEntry().getValue()){
                dp.put(job[1], val);
            }
        }
        
        return dp.lastEntry().getValue();
    }
}