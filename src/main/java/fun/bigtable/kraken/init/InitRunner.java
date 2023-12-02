package fun.bigtable.kraken.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class InitRunner {

    @Resource
    List<AbstractInitializer> abstractInitializers;

    private static final Logger log = LoggerFactory.getLogger(InitRunner.class);

    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        log.info("容器启动后初始化 start...");
        abstractInitializers.forEach(init -> {
            log.info(init.module() + "执行");
            init.init();
        });
        log.info("容器启动后初始化 end...");

    }
}
