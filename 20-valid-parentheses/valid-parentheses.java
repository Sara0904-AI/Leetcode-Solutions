class Solution {
    public boolean isValid(String s) {
       int n=s.length();
       if(n%2!=0) return false; 
    Stack<Character> stack=new Stack<>();

    for (char c:s.toCharArray()){
        if (c=='(') stack.push(')');
        else if (c=='{') stack.push('}');
        else if (c=='[') stack.push(']');
        else{
            if(stack.isEmpty() || stack.pop() != c) return false;
        }
    }
        return stack.isEmpty();
            }
}