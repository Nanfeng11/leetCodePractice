//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 2838 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if(s.length()%2==0){
            Stack<Character> stack = new Stack();
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(c=='(' || c=='[' || c=='{'){
                    stack.push(c);
                }else if(c==')'){
                    if(!stack.isEmpty() && stack.peek()=='('){
                        stack.pop();
                    }else{
                        return false;
                    }
                }else if(c==']'){
                    if(!stack.isEmpty() && stack.peek()=='['){
                        stack.pop();
                    }else{
                        return false;
                    }
                }else if(c=='}'){
                    if(!stack.isEmpty() && stack.peek()=='{'){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
