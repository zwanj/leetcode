class Solution {

    List<List<String>> result = new ArrayList<>();
    Deque<String> seq = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtrack(s,0);
        return result;
    }

    //startIndex是分割的起点
    public void backtrack(String s, int startIndex){
        //end seq:分割线在子串最后,记得new
        if(startIndex >=s.length()){
            result.add(new ArrayList<>(seq));
            return;
        }

        //find
        for(int i=startIndex;i<s.length();i++){
            //如果是回文，作为seq,不是回文，跳过
            if(isPalindrome(s,startIndex,i)){
                //截取子串seq用substring
                seq.addLast(s.substring(startIndex,i+1));
            }else{
                continue;
            }

            backtrack(s,i+1);
            //去除最后一个值
            seq.removeLast();

        }
    }

    // 判断s中某一段是否是回文
    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
