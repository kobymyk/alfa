package patterns.proxy;

import patterns.proxy.service.DocumentService;
import patterns.proxy.service.DocumentServiceImpl;
import patterns.proxy.service.SearchService;
import patterns.proxy.service.SearchServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ProxyHandler implements InvocationHandler {
    private static final ExecutorService executorService = Executors.newCachedThreadPool();
    private final DocumentService documentService;
    private final SearchService searchService;
    private final ThreadLogger threadLogger;

    public ProxyHandler() {
        documentService = new DocumentServiceImpl();
        searchService = new SearchServiceImpl();
        threadLogger = new ThreadLogger();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        threadLogger.start();
        Future<Object> future = executorService.submit(() -> invokeMethod(method, args));
        Object result = future.get(100000L, TimeUnit.MICROSECONDS);
        threadLogger.end();
        return result;
    }

    private Object invokeMethod(Method method, Object[] args) {
        Object result;
        threadLogger.start();
        try {
            if (method.getDeclaringClass() == DocumentService.class) {
                result = method.invoke(documentService, args);
            } else if (method.getDeclaringClass() == SearchService.class) {
                result = method.invoke(searchService, args);
            } else {
                throw new RuntimeException("Unsupported method");
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        threadLogger.end();
        return result;
    }
}
