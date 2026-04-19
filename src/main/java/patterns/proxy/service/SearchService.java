package patterns.proxy.service;

import patterns.proxy.model.Document;

public interface SearchService {
    Document searchDocument(String documentName);
}
