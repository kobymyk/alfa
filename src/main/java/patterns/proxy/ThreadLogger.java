package patterns.proxy;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class ThreadLogger {
    ThreadLocal<UUID> threadId = new ThreadLocal<>();

    public void start() {
        threadId.set(UUID.randomUUID());
        log.info("start:{}", threadId.get());
    }

    public void end() {
        log.info("end:{}", threadId.get());
    }
}
