package libs.jackson;

import com.fasterxml.jackson.annotation.JsonView;
import libs.jackson.DataViews.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @JsonView(Warn.class)
    public int id;
    @JsonView(Info.class)
    public String name;
    public String email;
    @JsonView(Debug.class)
    public String password;
}
