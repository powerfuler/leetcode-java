package q071_080.q076_2;

class Solution {
    public String minWindow(String s, String t) {
        //charDiff 记录asc字符出现次数
        int[] charDiff = new int[128];
        //diffCnt 记录charDiff差异的数组个数，diffCnt=0表示满足t中所有字符出现频率。
        int diffCnt = 0;
        // other表示当前多余字符数，minOhter表示历史最少多余字符数。此问题求解就是满足diffCnt=0情况下minOhter最小;
        int other =0,minOther=Integer.MAX_VALUE;
        //lp左指针，rp右指针，minlp和minrp(历史最小解的lp和rp)
        int lp=0,rp=0,minlp=-1,minrp=-1;
        //初始化字典数组，将t中出现字符频率置为负值。
        for (int i=0;i<t.length();i++){
            if ( 0 == charDiff[t.charAt(i)]--)
                diffCnt++;
        }
        while(rp<s.length()){
            //往右遍历字符串，不断读取字符
            charDiff[s.charAt(rp)]++;
            //charDiff[]变0表示有一个t字符的出现频率被满足。diffCnt -1
            if (charDiff[s.charAt(rp)] == 0){
                if (--diffCnt == 0){
                    //如果diffCnt=0，则不断删除左侧(lp)所在字母，压缩满足频率的子串长度
                    while(diffCnt == 0){
                        //满足diffCnt==0，比较当前other和历史最小，如果小于minohter,更新minlp,minrp,minOther
                        if (other < minOther){
                            minlp = lp;
                            minrp = rp;
                            minOther = other;
                        }
                        //减去lp所在字符。
                        charDiff[s.charAt(lp)]--;
                        //当charDiff==-1表示不满足t的字符频率，diffCnt需要+1（diffCnt是记录差异字符数不是频率，只有-1才操作）
                        if (charDiff[s.charAt(lp)] == -1)
                            diffCnt++;
                        //多余字符数-1
                        if (charDiff[s.charAt(lp)] >= 0) 
                            other--;   
                        lp++;
                    }
                }
            }
            //多余字符数+1
            if (charDiff[s.charAt(rp)] >0)
                other++;
            rp++;
        }
        if (minlp == -1)
            return "";
        else
            return s.substring(minlp,minrp+1);

    }
}