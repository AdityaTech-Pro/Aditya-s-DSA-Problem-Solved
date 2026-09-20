class Solution {
    public int maxArea(int[] height) {
        int startIndexOfContainer=0;
        int endIndexOfContainer=height.length-1;
        int cwmw=0;
        while(startIndexOfContainer < endIndexOfContainer){
            int minLine=Math.min(height[startIndexOfContainer], height[endIndexOfContainer]);
            int containerWidth=endIndexOfContainer - startIndexOfContainer;
            cwmw=Math.max(cwmw, minLine*containerWidth);
            if(height[startIndexOfContainer] <= height[endIndexOfContainer]){
                startIndexOfContainer++;
            }else{
                endIndexOfContainer--;
            }
        }
        return cwmw;
    }
}