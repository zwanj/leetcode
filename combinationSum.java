class Solution {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //先对原数组排序
        Arrays.sort(candidates);
        //在一个set内组合需要startindex
        backtrack(candidates, target, 0, 0);
        return result;
    }

    public void backtrack(int[] candidates, int target, int sum, int startindex){
        //end req:sum>target || sum==target
        if(sum > target) return;
        if(sum == target){
            result.add(new ArrayList<>(path));
            return;
        }

        //find,遍历完每一个candidate元素
        for(int i=startindex;i<candidates.length;i++){
            path.add(candidates[i]);
            sum+=candidates[i];
            //从当前位置向后搜索，所以是i
            backtrack(candidates,target,sum,i);
            sum-=candidates[i];
            path.removeLast();
        }
    }
}
