package libs.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;

import static libs.jackson.DealViews.*;

public class AccountMapper {
    static ObjectMapper mapper = getObjectMapper();

    //Spring: @JsonView(REQUEST_ALL)
    public String toRequest(Account account) throws JsonProcessingException {
        return mapper.writerWithView(REQUEST_DEAL)
                .writeValueAsString(account);
    }

    //@JsonView(UpdateView.class)
    public String toUpdate(Account account) throws JsonProcessingException {
        return mapper.writerWithView(UPDATE_DEAL)
                .writeValueAsString(account);
    }

    @SneakyThrows
    static <T> T readObject(String filePath, Class<T> objectType) {
        File file = new File(filePath);
        return mapper.readValue(file, objectType);
    }

    private static ObjectMapper getObjectMapper() {
        ObjectMapper result = new ObjectMapper();
        result.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        result.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return result;
    }
}
