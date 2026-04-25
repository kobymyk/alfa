package libs.jackson;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;

import static libs.jackson.DataViews.*;

public class AccountMapper {
    static ObjectMapper mapper = getObjectMapper();

    @SneakyThrows
    public String toStringByView(Account account, Class<?> viewClass) {
        return mapper.writerWithView(viewClass)
                .writeValueAsString(account);
    }

    @SneakyThrows
    //works for controller
    @JsonView(Warn.class)
    public String toStringForWarn(Account account) {
        return mapper.writeValueAsString(account);
    }

    @SneakyThrows
    static <T> T readObject(String filePath, Class<T> objectType) {
        File file = new File(filePath);
        return mapper.readValue(file, objectType);
    }

    private static ObjectMapper getObjectMapper() {
        ObjectMapper result = new ObjectMapper();
        result.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        //result.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
        result.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return result;
    }
}
