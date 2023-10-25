class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        if(eq.equals("="))
            answer = ineq.equals(">")? (n>=m? 1 : 0) : (n<=m? 1 : 0);
        else
            answer = ineq.equals(">")? (n>m? 1 : 0) : (n<m? 1 : 0);  
        return answer;
    }
}