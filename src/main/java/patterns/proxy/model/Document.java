package patterns.proxy.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Document {
    private int documentId;
    private String documentName;
}
