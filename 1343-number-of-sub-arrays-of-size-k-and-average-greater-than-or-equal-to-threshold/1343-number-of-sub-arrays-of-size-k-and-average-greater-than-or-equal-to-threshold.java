class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        int count = 0;
        
        int i = 0;
        int j = k + i - 1;
        
        while(j < arr.length){
            int sum = 0;
            
            for(int l = i; l <= j; l++){
                sum += arr[l];
            }
            
            double aveg = sum / k;
            
            if(aveg >= threshold){
                count++;
            }
            
            i += 1;
            j = k + i - 1;
        }
        
        return count;
    }
}