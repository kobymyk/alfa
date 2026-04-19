package patterns.proxy.service;

import lombok.extern.slf4j.Slf4j;
import patterns.proxy.model.Document;

@Slf4j
public class DocumentServiceImpl implements DocumentService {
    @Override
    public int saveDocument(Document document) {
        log.info("saveDocument:{}", document);
        return document.getDocumentId();
    }
}
