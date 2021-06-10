package q031_040.q038_外观数列.code;

public class Solution2 {
    public String countAndSay(int n) {
        String s = "1";
        for(int i=0; i<n-1; i++){
            s = describe(s);
        }
        return s;
    }

    String describe(String s){
        StringBuilder res = new StringBuilder();
        if(s.length()==1){
            res.append("1");
            res.append(s);
        }

        int num = 1;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                num += 1;

            }else{
                res.append(num);
                res.append(s.charAt(i-1));
                num = 1;
            }
            if(i==s.length()-1){
                res.append(num);
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}