class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] nsr=new int[n];
        Deque<Integer> stack=new ArrayDeque<>();
        //nsr-nsl-1 *i
        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()){
                nsr[i]=n;
            }
            else if(heights[stack.peek()]>=heights[i]){
                while(!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                   nsr[i]=n;
                }
                else{
                    nsr[i]=stack.peek();
                }
            }
            else{
                nsr[i]=stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        int[] nsl=new int[n];
        for(int i=0;i<n;i++){
            if(stack.isEmpty()){
                nsl[i]=-1;
            }
            else if(heights[stack.peek()]>=heights[i]){
                while(!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                   nsl[i]=-1;
                }
                else{
                    nsl[i]=stack.peek();
                }
            }
            else{
                nsl[i]=stack.peek();
            }
            stack.push(i);
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(((nsr[i]-nsl[i]-1)*heights[i]),max);
        }
        return max;
    }
}
