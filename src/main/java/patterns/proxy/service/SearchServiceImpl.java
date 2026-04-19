package patterns.proxy.service;

import lombok.extern.slf4j.Slf4j;
import patterns.proxy.model.Document;

@Slf4j
public class SearchServiceImpl implements SearchService {
    @Override
    public Document searchDocument(String documentName) {
        log.info("searchDocument:{}", documentName);
        return Document.builder()
                .documentName(documentName)
                .build();
    }
}
