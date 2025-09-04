package patterns.proxy.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SearchServiceImpl implements SearchService {
    @Override
    public void searchDocument() {
        log.info("searchDocument");
    }
}
