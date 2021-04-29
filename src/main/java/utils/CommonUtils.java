package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.*;

public class CommonUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtils.class);

    /**
     * 拷贝除了namespaceId，ownerId,ownerType属性到target中
     * @param source
     * @param target
     * @param <T>
     * @return
     */
    public static <T>T copyNotNullProperties( Object source, T target) {
        String[] s = {"getNamespaceId","getOwnerType","getOwnerId","setNamespaceId","setOwnerType","setOwnerId"};
        List<String> ignoreProperties = new ArrayList<>(Arrays.asList(s));
        return copyNotNullProperties(source,target,ignoreProperties);
    }

    /**
     * 拷贝source中非所有空属性,到target中对应属性中
     * @param source
     * @param target
     * @param <T>
     * @return
     */
    public static <T>T copyAllNotNullProperties( Object source, T target) {
        return copyNotNullProperties( source,target,null);
    }

    /**
     * 拷贝source中非空不在ignoreProperties中的属性,到target中对应属性中
     * @param source
     * @param target
     * @param ignoreProperties
     * @param <T>
     * @return
     */
    public static <T>T copyNotNullProperties( Object source, T target, List<String> ignoreProperties) {
        if(source==null) {
            return target;
        }
        Map<String, Method> getSetMethodMap = new HashMap();
        List<Method> getMethodList = new ArrayList();
        for (Method method : source.getClass().getMethods()) {
            String methodName = method.getName();
            if((methodName.startsWith("get")
                    ||  methodName.startsWith("set"))
                    && !"getClass".equals(methodName)
                    && (ignoreProperties==null || !ignoreProperties.contains(methodName))){
                if(methodName.startsWith("get")){
                    getMethodList.add(method);
                }
                getSetMethodMap.put(methodName,method);
            }
        }
        for (Method method : getMethodList) {
            String sourceGetMethodName = method.getName();
            String targetSetMethodName = sourceGetMethodName.replace("get","set");
            try {
                Object result = method.invoke(source);
                if(result==null){
                    continue;
                }
                if(isNeedPropertiesCopy(result)){
                    //如果需要深拷贝，这里先获取到目标类的需要深拷贝的属性
                    Method targetGetMethod = target.getClass().getMethod(sourceGetMethodName);
                    Object subtarget = targetGetMethod.invoke(target);
                    if(subtarget!=null) {
                        result = copyNotNullProperties(result, subtarget,null);
                    }
                }
                Method sourceSetMethod = getSetMethodMap.get(targetSetMethodName);
                Method targetMethod = target.getClass().getMethod(targetSetMethodName, sourceSetMethod.getParameterTypes());
                targetMethod.invoke(target, result);
            } catch (Exception e) {
                LOGGER.trace("source ChangeMethod = {}, targetMethod = {}, failed", sourceGetMethodName, targetSetMethodName,e);
            }
        }
        return target;
    }

    public static boolean isNeedPropertiesCopy(Object result){
        return !(result instanceof Byte
                || result instanceof Short
                || result instanceof Integer
                || result instanceof Long
                || result instanceof Float
                || result instanceof Double
                || result instanceof Character
                || result instanceof Boolean
                || result instanceof String
                || result instanceof Timestamp
                || result instanceof Date
                || result instanceof Collection);
    }

    public static String getStackTraceInfo(Exception e) {
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            e.printStackTrace(pw);//将出错的栈信息输出到printWriter中
            pw.flush();
            sw.flush();
            return sw.toString();
        } catch (Exception ex) {

            return "发生错误";
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
        }

    }
}
