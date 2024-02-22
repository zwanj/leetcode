class Solution {
    //
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        //从1开始
        backtrack(n,k,1,0);
        return result;
    }

    public void backtrack(int n, int k, int startIndex,int sum){
        //cut extra
        if(sum >n) return;

        //end req
        if(path.size() == k){
            //k个数，所以在路径长度为k时,sum=n结束，也就是到叶子节点的时候结束
            if(sum == n){
                result.add(new ArrayList<>(path));//由于path一直在变化，所以要每次创建新的数组存放
            }
            return;
        }

        //find path
        for(int i=startIndex;i<=9-(k-path.size())+1;i++){
            //添加节点，计算sum
            path.add(i);
            sum+=i;
            
            //回溯
            backtrack(n,k,i+1,sum);
            sum-=i;
            path.removeLast();
        }
    }
}
