class Solution {

   List<String> result = new ArrayList<>();
   //记录每次的组合
   StringBuilder each = new StringBuilder();


    public List<String> letterCombinations(String digits) {
        //映射
        String[] letter =  {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //输入合法判断
        if(digits == null || digits.length()==0) return result;

        //多个集合组合，无需startIndex
        backtrack(digits, letter, 0);

        return result;
    }
    
    //参数需要一个记录遍历到第几个输入数字numth
    public void backtrack(String digits, String[] letter, int numth){
        //end req
        //叶子结点结束，遍历到numth 结束
        if(numth == digits.length()){
            result.add(each.toString());
            return;
        }

        //记录当前遍历的数字对应的字符串
        String str = letter[digits.charAt(numth) - '0'];

        //find combine
        for(int i=0; i<str.length();i++){
            //each（添加需要使用append）加入数字对应字符串的第i个，也就是每次取出str中的一个字母
            each.append(str.charAt(i));

            //回溯,从digits的下一个开始添加在each里面
            backtrack(digits,letter,numth+1);
            //去除最后一个，使用的是deleteCharAt
            each.deleteCharAt(each.length()-1);
        }
    }
}
