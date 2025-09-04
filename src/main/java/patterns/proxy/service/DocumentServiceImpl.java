package patterns.proxy.service;

import lombok.extern.slf4j.Slf4j;
import patterns.proxy.service.DocumentService;

@Slf4j
public class DocumentServiceImpl implements DocumentService {
    @Override
    public void loadDocument() {
        log.info("loadDocument");
    }
}
