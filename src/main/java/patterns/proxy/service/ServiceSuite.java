package patterns.proxy.service;

import patterns.proxy.service.DocumentService;
import patterns.proxy.service.SearchService;

public interface ServiceSuite extends DocumentService, SearchService {
}
