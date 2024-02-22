class Solution {
    //定义两个，result和path(用链表方便删除添加)
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        //数组是从1开始的
        backtrack(n,k,1);

        return result;
    }

    public void backtrack(int n, int k, int startIndex){
        //end req
        if(path.size()== k){
            result.add(new ArrayList<>(path));
            return;
        }

        //find
        for(int i=startIndex;i<=n-(k-path.size())+1;i++){//注意这个地方，i从start开始，要<=
            path.add(i);
            //依旧是这个数组，所以n、k不变，但是从下一个开始所以i+1
            backtrack(n,k,i+1);
            path.removeLast();
        }
    }
}
