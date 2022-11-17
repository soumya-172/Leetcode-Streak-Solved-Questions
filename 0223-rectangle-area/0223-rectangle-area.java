class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // for 1st rectangle
        long area1 = ((long) ax2 - (long) ax1) * ((long) ay2 - (long) ay1);
        //for 2nd rectangle
        long area2 = ((long) bx2 - (long) bx1) * ((long) by2 - (long) by1);
        
        // for overlapped area, and we taking max with 0 because if there were no overlap then the diff will becaome '-ve' then the max will be 0, and anything * 0 = 0 ,so, there will no overlap;
        long overlappedArea = Math.max((long) Math.min(ax2, bx2) - (long) Math.max(ax1,bx1), 0L) * Math.max((long) Math.min(ay2, by2) - (long) Math.max(ay1,by1), 0L);
        
        return (int) (area1 + area2 - overlappedArea);
    }
}