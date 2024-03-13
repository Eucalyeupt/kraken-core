package fun.bigtable.kraken.util;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * 基于Gson的json工具类
 */
public class JsonUtils {

    private static Gson gson;

    public static Gson getInstance() {
        if (Objects.isNull(gson)) {
            synchronized (JsonUtils.class) {
                if (Objects.isNull(gson)) {
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    gsonBuilder.serializeNulls();
                    gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateAdapter());
                    gson = gsonBuilder.create();
                }
            }
        }
        return gson;
    }


    /**
     * 转 json 字符串
     */
    public static String toJson(Object o) {
        return getInstance().toJson(o);
    }

    /**
     * 转对象
     */
    public static <T> T parserObject(String json, Class<T> classOfT) {
        return getInstance().fromJson(json, classOfT);
    }


    /**
     * 自定义
     */
    public static <T> T parserCustom(String json, TypeToken<T> typeToken) {
        return getInstance().fromJson(json, typeToken.getType());
    }

    public static class LocalDateAdapter implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {
        @Override
        public JsonElement serialize(LocalDateTime localDateTime, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }

        @Override
        public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

            if (!json.isJsonNull()) {
                String asString = json.getAsString();
                return DateTimeUtils.parserDateTime(asString);
            }
            return null;
        }
    }

}
