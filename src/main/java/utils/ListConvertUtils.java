package utils;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ListConvertUtils {
    private  static final Logger LOGGER = LoggerFactory.getLogger(ListConvertUtils.class);

    public static <D> List<D> convertList(List<?> list, Class<D> clzDst){
        List<D> result = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(list)){
            list.forEach(r-> result.add(ConvertHelper.convert(r, clzDst)));
        }else{
            LOGGER.error("covert list fails, the list is null");
        }
        return result;
    }
}
