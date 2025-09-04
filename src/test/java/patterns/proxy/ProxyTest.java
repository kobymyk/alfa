package patterns.proxy;

import org.junit.Before;
import org.junit.Test;
import patterns.proxy.model.Document;
import patterns.proxy.service.ServiceSuite;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProxyTest {
    private ServiceSuite proxy;
    private Document document;

    @Before
    public void init() {
        InvocationHandler invocationHandler = new ProxyHandler();
        proxy = (ServiceSuite) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(),
                new Class[] { ServiceSuite.class },
                invocationHandler);

        document = Document.builder()
                .documentId(10)
                .documentName("documentName")
                .build();
    }

    @Test
    public void saveDocument() {
        int actual = proxy.saveDocument(document);
        assertEquals(document.getDocumentId(), actual);
    }

    @Test
    public void searchDocument() {
        Document actual = proxy.searchDocument(document.getDocumentName());
        assertNotNull(actual);
    }
}
