package utils;

import org.springframework.beans.BeanUtils;

public class ConvertHelper {
    private ConvertHelper() {
    }

    public static <T> T convert(Object src, Class<T> clzDst) {
        if (src == null) {
            return null;
        } else {
            try {
                T dst = clzDst.newInstance();
                BeanUtils.copyProperties(src, dst);
                return dst;
            } catch (IllegalAccessException | InstantiationException var3) {
                throw new RuntimeException(var3);
            }
        }
    }
}