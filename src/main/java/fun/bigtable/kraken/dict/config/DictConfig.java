package fun.bigtable.kraken.dict.config;

import fun.bigtable.kraken.dict.DefaultDictRepository;
import fun.bigtable.kraken.dict.DictRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class DictConfig {

    @Bean
    @ConditionalOnMissingBean(DictRepository.class)
    public DefaultDictRepository defaultDictRepository(){
        return new DefaultDictRepository();
    }

}
