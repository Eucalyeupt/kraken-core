package fun.bigtable.kraken.constant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class EnumInitBiz implements CommandLineRunner {



    private static final Logger log = LoggerFactory.getLogger(EnumInitBiz.class);

    @Override
    public void run(String... args) throws Exception {
        try {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start("scan");
            List<IEnum> iEnums = scanAndExecute("fun.bigtable.*.*.bean");
            stopWatch.stop();

            stopWatch.start("print");
            for (IEnum iEnum : iEnums) {
                if (iEnum instanceof Enum<?>) {
                    Enum<?> e = (Enum<?>) iEnum;
                    String name = e.getClass().getName();
                    log.info(String.format("Clazz:%-30s Enum:%-10s Code:%-3d Name:%s ", name.substring(name.lastIndexOf(".") + 1), e.name(), iEnum.getCode(), iEnum.getName()));
                }
            }

            stopWatch.stop();
            log.info(stopWatch.prettyPrint());
        }catch (Exception e){
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 获取所有实现了IEnum的类
     */
    public List<IEnum> scanAndExecute(String basePackage) {

        List<IEnum> iEnums = new ArrayList<>();

        Set<Class<?>> enumClasses = findEnumImplementations(basePackage, IEnum.class);

        for (Class<?> enumClass : enumClasses) {
            if (enumClass.isEnum()) {
                Object[] enumConstants = enumClass.getEnumConstants();
                for (Object enumConstant : enumConstants) {
                    if (enumConstant instanceof IEnum ) {
                        IEnum iEnum = (IEnum) enumConstant;
                        iEnums.add(iEnum);
                    }
                }
            }
        }
        return iEnums;
    }

    /**
     * 获取某个包下的类
     *
     * @param basePackage 要扫描的包
     * @param interfaceType 实现的接口
     */
    public Set<Class<?>> findEnumImplementations(String basePackage, Class<?> interfaceType) {
        ClassPathScanningCandidateComponentProvider provider =
                new ClassPathScanningCandidateComponentProvider(false);

        provider.addIncludeFilter(new AssignableTypeFilter(interfaceType));

        Set<Class<?>> implementations = new HashSet<>();
        provider.findCandidateComponents(basePackage).forEach(beanDefinition -> {
            try {
                implementations.add(Class.forName(beanDefinition.getBeanClassName()));
            } catch (ClassNotFoundException e) {
                log.info(e.getMessage(),e);
            }
        });
        return implementations;
    }
}
