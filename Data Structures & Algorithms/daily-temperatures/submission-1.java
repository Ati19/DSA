class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] out=new int[temperatures.length];
        Stack<Integer> stack=new Stack<>();
        stack.add(temperatures[0]);
        int k=0,i=k+1;
        while(k<temperatures.length-1){
             if( temperatures[i]>stack.peek() ){
                out[k]=i-k;
                k++;
                stack.pop();
                stack.add(temperatures[k]); //30,38,30,36,35,40,28
                i=k+1;
            }
            else if(i==temperatures.length-1 ){
                out[k]=0;
                k++;
                stack.pop();
                stack.add(temperatures[k]); //30,38,30,36,35,40,28
                i=k+1;
            }
            else{
                i++;
            }

        }
        return out;
    }
}
