package q011_020.q012_整数转罗马数字.code;

public class Solution1 {
    public String intToRoman(int num) {
        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] str = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < nums.length; i++){
            int value = nums[i];
            String s = str[i];
            while(num >= value){
                num -= value;
                res.append(s);
            }
            if(num == 0) {
                break;
            }
        }
        return res.toString();
    }
}