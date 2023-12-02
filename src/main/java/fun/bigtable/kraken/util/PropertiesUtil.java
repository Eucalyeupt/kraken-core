package fun.bigtable.kraken.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 *
 */
public class PropertiesUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesUtil.class);

    private PropertiesUtil() {
    }

    public static Properties readProperties(String name) {
        final Properties properties = new Properties();
        InputStreamReader inputStreamReader = null;
        InputStream inputStream = null;
        try {
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
            if (inputStream == null) {
                return null;
            }
            inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            properties.load(inputStreamReader);
        } catch (IOException e) {
            LOGGER.error("读取配置文件异常", e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
            } catch (IOException e) {
                LOGGER.error("关闭文件异常", e);
            }

        }
        return properties;
    }

}
