package utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.util.StringUtils;

public class PinYinHelper {

	/**
	 * 中文转拼音
	 * @param inputString
	 * @return
	 */
	public static String getPinYin(String inputString) {
	       if(inputString == null || inputString.isEmpty()) {
	           return "";
	       }
	       
	       HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
	       format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
	       format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
	       format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);

	       char[] input = inputString.trim().toCharArray();
	       StringBuffer output = new StringBuffer("");

	       try {
	           for (int i = 0; i < input.length; i++) {
	               if (Character.toString(input[i]).matches("[\u4E00-\u9FA5]+")) {
	                   String[] temp = PinyinHelper.toHanyuPinyinStringArray(input[i], format);
	                   output.append(temp[0]);
	                   output.append(" ");
	               } else {
                       output.append(Character.toString(input[i]));
                   }
	           }
	       } catch (BadHanyuPinyinOutputFormatCombination e) {
	           e.printStackTrace();
	       }
	       return output.toString();
	}
	
	/**
	 * 获取拼音的全部首字母
	 * @param pinyin
	 * @return
	 */
	public static String getFullCapitalInitial(String pinyin) {
	      if(StringUtils.isEmpty(pinyin)){
	    	  return pinyin;
	      }
	      
	      String[] pinyins = pinyin.split(" ");
	      
	      if(pinyins.length < 2){
	    	  return pinyin;
	      }
	      
	      String capitalInitial = "";
	      for (String string : pinyins) {
	    	  if(StringUtils.isEmpty(string) || StringUtils.isEmpty(string.trim())){
	    		  capitalInitial += string;
		      }else{
		    	String initial = string.toUpperCase();
		  		
		  		char[] input = initial.toCharArray();
		  		
		  		initial = String.valueOf(input[0]);
		  		
		  		if(!initial.matches("[A-Z]")){
		  			capitalInitial += string;
		  		}else{
		  			capitalInitial += initial;
		  		}
		      }
	      }
	      return capitalInitial;
	}
	
	
	
	/**
	 * 获取首个字母大写
	 * @param pinyin
	 * @return
	 */
	public static String getCapitalInitial(String pinyin){
		
//		pinyin = getPinYin(pinyin);
		
		if(StringUtils.isEmpty(pinyin)){
			return "~";
		}
		
		pinyin = pinyin.trim();
		
		if(StringUtils.isEmpty(pinyin)){
			return "~";
		}
		
		pinyin = pinyin.toUpperCase();
		
		char[] input = pinyin.toCharArray();
		
		pinyin = String.valueOf(input[0]);
		
		if(!pinyin.matches("[A-Z]")){
			pinyin = "~";
		}
		
		return pinyin;
	}
	
	public static void main(String[] args) {
		System.out.println(getPinYin("颜少凡").replaceAll(" ", ""));
		System.out.println(getFullCapitalInitial(getPinYin("颜少凡")));
		System.out.println(getStringFullCapitalInitial("航运-E7500/2GB/250GB/DVD/E1901H/Vista-Hone"));
	}

	/** 
     * 将单个字符（包括单个汉字或者单个英文字母）转换为小写字母 
     * @param c 
     * @return 
     */  
    public static String getCharacterPinYin(char c)  
    {  
        String[] pinyin=null;  
        HanyuPinyinOutputFormat format =new HanyuPinyinOutputFormat();  
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);  
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);//汉字没有声调  
        format.setVCharType(HanyuPinyinVCharType.WITH_V);  
        try{  
            pinyin = PinyinHelper.toHanyuPinyinStringArray(c, format);  
        }catch(BadHanyuPinyinOutputFormatCombination e){  
            e.printStackTrace();  
        }  
        // 如果c不是汉字，toHanyuPinyinStringArray会返回null  
        if (pinyin == null) {
            return ((Character)c).toString().toLowerCase();
        }
        // 只取一个发音，如果是多音字，仅取第一个发音  
        return pinyin[0];  
    }  
    
    /** 
     * 将包含中英文的字符串以小写英文字母的形式返回 
     * @param str 
     * @return 
     */  
    public static String getStringPinYin(String str)  
    {  
        StringBuilder sb = new StringBuilder();  
        String tempPinyin = null;  
        for (int i = 0; i < str.length(); ++i)  
        {  
            tempPinyin = getCharacterPinYin(str.charAt(i));  
            sb.append(tempPinyin);  
        }  
        return sb.toString();  
    }

	/**
	 * 获取文本的首字母
	 * @param str
	 * @return
	 */
	public static String getStringFullCapitalInitial(String str){
		return getFullCapitalInitial(getPinYin(str));
	}
}
