package org.feather.train.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

/**
 * @projectName: train
 * @package: org.feather.train.gateway
 * @className: GateWayApplication
 * @author: feather
 * @description: TODO
 * @since: 2023-06-22 22:25
 * @version: 1.0
 */
@SpringBootApplication
public class GateWayApplication {

    private static final Logger log = LoggerFactory.getLogger(GateWayApplication.class);
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(GateWayApplication.class);
        Environment env = app.run(args).getEnvironment();
        log.info("启动成功！！");
        log.info("网关地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"), env.getProperty("server.servlet.context-path"));
    }
}
