package fun.bigtable.kraken;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class KrakenCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(KrakenCoreApplication.class, args);
    }

}
