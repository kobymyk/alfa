package patterns.proxy;

import org.junit.Test;
import patterns.proxy.service.ServiceSuite;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {

    @Test
    public void invoke() {
        InvocationHandler invocationHandler = new ProxyHandler();
        ServiceSuite proxy = (ServiceSuite) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(),
                new Class[] { ServiceSuite.class },
                invocationHandler);
        proxy.loadDocument();
        proxy.searchDocument();
    }
}
