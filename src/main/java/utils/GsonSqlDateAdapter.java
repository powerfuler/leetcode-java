package utils;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.sql.Date;

public class GsonSqlDateAdapter implements JsonDeserializer<Date>, JsonSerializer<Date> {
    public GsonSqlDateAdapter() {
    }

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        return src != null ? new JsonPrimitive(src.getTime()) : null;
    }

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Long time = json.getAsLong();
        return time != null ? new Date(time) : null;
    }
}