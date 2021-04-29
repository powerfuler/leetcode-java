package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Steve
 * @version 1.0
 * @description 
 * @date 2018/12/3
 */
public class GetKeywordsUtils {
	
	private GetKeywordsUtils() {}

	/**
	 * <p>该方法可以提取出一段文本中，以特定开始标记、结束标记包裹的关键字。</p>
	 * <p>返回所有符合条件的关键字列表，关键字带着开始、结束标记。</p>
	 * <p>注意：开始标记和结束标记不能相同。</p>
	 * @param text 要处理的文本
	 * @param startParten 开头匹配方式
	 * @param endParten 结尾匹配方式
	 */
    public static List<String> getKeywordsWithPattern(String text,String startParten,String endParten){
        List<String> results = new ArrayList<>();

        char[] startPartenArray = startParten.toCharArray();
        char[] endPartenArray = endParten.toCharArray();
        char[] textArray = text.toCharArray();

        boolean beginFlag = false;
        StringBuffer tempSB = new StringBuffer();
        
        for (int i = 0; i < textArray.length; i++) {
            //判断是否开始匹配
            if (textArray[i] == startPartenArray[0]){
                if (checkPattern(text, startParten, i)){
                    beginFlag = true;
                }
            }
            //判断是否结束匹配
            if (textArray[i] == endPartenArray[0]){
                if (checkPattern(text, endParten, i)){
                    beginFlag = false;
                    tempSB.append(endParten);
                    results.add(tempSB.toString());
                    tempSB.setLength(0);
                    continue;
                }
            }
            if (beginFlag){
                tempSB.append(textArray[i]);
            }
        }
        return results;
    }

    /**
	 * <p>该方法可以提取出一段文本中，以特定开始标记、结束标记包裹的关键字。</p>
	 * <p>返回所有符合条件的关键字列表，关键字不带开始、结束标记。</p>
	 * <p>注意：开始标记和结束标记不能相同。</p>
	 * @param text 要处理的文本
	 * @param startParten 开头匹配方式
	 * @param endParten 结尾匹配方式
	 */
    public static List<String> getKeywordsWithoutPattern(String text,String startParten,String endParten){
        List<String> results = new ArrayList<>();

        char[] startPartenArray = startParten.toCharArray();
        char[] endPartenArray = endParten.toCharArray();
        char[] textArray = text.toCharArray();

        boolean beginFlag = false;
        StringBuffer tempSB = new StringBuffer();
        
        for (int i = 0; i < textArray.length; i++) {
            //判断是否开始匹配
            if (textArray[i] == startPartenArray[0]){
                if (checkPattern(text, startParten, i)){
                    beginFlag = true;
                }
            }
            //判断是否结束匹配
            if (textArray[i] == endPartenArray[0]){
                if (checkPattern(text, endParten, i)){
                    beginFlag = false;
                    results.add(tempSB.substring(startParten.length()));
                    tempSB.setLength(0);
                    continue;
                }
            }
            if (beginFlag){
                tempSB.append(textArray[i]);
            }
        }
        return results;
    }

    /**
	 * 将文本中的关键字替换为相应的值
	 * @param dataMap 数据map，key是要文本中要被替代的字段，value是替换的字段
	 * @param text 要处理的文本
	 * @param startParten 开头匹配方式
	 * @param endParten 结尾匹配方式
	 */
    public static String translate(Map<String, String> dataMap,String text, String startParten,String endParten) {
    	if (dataMap.size() < 1) {
			return text;
		}
    	StringBuffer textSB = new StringBuffer();
    	StringBuffer keySB = new StringBuffer();
    	
    	char[] startPartenArray = startParten.toCharArray();
        char[] endPartenArray = endParten.toCharArray();
        char[] textArray = text.toCharArray();

        boolean beginFlag = false;
        
        int endCount = 0;
        String key = null;
        String value = null;
        
        for (int i = 0; i < textArray.length; i++) {
        	
        	if (beginFlag || (i <= endCount && key != null) ) {
        		//这时正在进行关键字的匹配过程，不对textSB进行append操作
			}else {
				textSB.append(textArray[i]);
			}
        	
        	//关键字的匹配过程结束，用得到的value替换文本中的关键字
        	//在这里，要将key置为null，因为key不为null说明匹配过程还在进行
        	if (i == endCount && key != null) {
				value = dataMap.get(key);
				textSB.append(value);
				textSB.append(textArray[i]);
				key = null;
				value = null;
			}
        	
        	//判断是否开始匹配
            if (textArray[i] == startPartenArray[0]){
                if (checkPattern(text, startParten, i)){
                    beginFlag = true;
                    textSB.deleteCharAt(textSB.length() - 1);
                }
            }
            //判断是否结束匹配
            if (textArray[i] == endPartenArray[0]){
                if (checkPattern(text, endParten, i)){
                    beginFlag = false;
                    endCount = i + endParten.length();
                    
                    keySB.append(endParten);
                    key = keySB.toString();
                    
                    keySB.setLength(0);
                    
                    //如果结束了，就直接换值，不用等到下次循环开始了，因为没有下次循环了
                    if(i == textArray.length - 1){
                    	//关键字的匹配过程结束，用得到的value替换文本中的关键字
                    	//在这里，要将key置为null，因为key不为null说明匹配过程还在进行
                    	if (i == endCount - 1 && key != null) {
            				value = dataMap.get(key);
            				textSB.append(value);
            			}
                    }
                    continue;
                }
            }
            if (beginFlag){
            	keySB.append(textArray[i]);
            }
        }
    	return textSB.toString();
	}
    
    private static boolean checkPattern(String text,String pattern,int startIndex){
    	char[] patternArray = pattern.toCharArray();
    	char[] textArray = text.toCharArray();
    	
    	int count = 0;
    	for (int j = 0; j < patternArray.length; j++) {
            if (textArray[startIndex+j] == patternArray[j]){
            	count++;
            }else {
            	return false;
            }
        }
    	if (count == pattern.length()) {
			return true;
		}
    	return false;
    }
    
    public static void main(String[] args) {
    	Map<String, String> replaceMaps = new HashMap<>();
    	replaceMaps.put("${community.cityName}", "深圳市");
    	replaceMaps.put("${community.areaName}", "南山区");
    	replaceMaps.put("${community.address}", "左邻");
    	
    	String fieldName = "${community.cityName}---${community.areaName}---${community.address}";
//    	String fieldName = "${community.cityName}";
     	
    	String contractDocumentText = translate(replaceMaps, fieldName, "${", "}");
    	
    	System.out.println(contractDocumentText);
	}
	
}
