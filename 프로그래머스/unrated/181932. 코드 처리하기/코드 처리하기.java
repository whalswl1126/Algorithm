class Solution {
    public String solution(String code) {
        String answer = "";
        int mode = 0;
        for(int i=0; i<code.length(); i++) {
            String s = code.substring(i, i+1);
            if(s.equals("1"))
                mode = Math.abs(mode - 1);
            else if(mode==0 && i%2==0)
                answer += s;
            else if(mode==1 && i%2==1)
                answer += s;
        }
        return answer.length()==0 ? "EMPTY" : answer;
    }
}