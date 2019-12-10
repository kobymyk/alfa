package libs.jaxon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static libs.jaxon.DealViews.*;

public class AccountMapper {
    ObjectMapper mapper = new ObjectMapper();

    //Spring: @JsonView(REQUEST_ALL)
    public String toRequest(Account account) throws JsonProcessingException {
        String result = mapper.writerWithView(REQUEST_DEAL)
                .writeValueAsString(account);
        return result;
    }

    //@JsonView(UpdateView.class)
    public String toUpdate(Account account) throws JsonProcessingException {
        String result = mapper.writerWithView(UPDATE_DEAL)
                .writeValueAsString(account);
        return result;
    }
}
