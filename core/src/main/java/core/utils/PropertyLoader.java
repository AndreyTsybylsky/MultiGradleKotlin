package core.utils;

import core.excptions.NoPropertiesException;
import io.github.bonigarcia.wdm.config.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Properties;

public final class PropertyLoader {
    private  static final Logger LOGGER = LogManager.getLogger();
    private static Config config;

    private PropertyLoader(){}

    public static String returnConfigValue(final String property) throws NoPropertiesException {
        Properties properties = new Properties();

        try (InputStream propFileInpStream = PropertyLoader.class.getClassLoader()
                .getResourceAsStream( "config.properties")) {

            properties.load(propFileInpStream);
            LOGGER.debug(MessageFormat.format("Getting {0} inside file environment config.properties: {2}", property, properties.getProperty(property)));

            return properties.getProperty(property);
        } catch (IOException e) {
            LOGGER.error(MessageFormat.format("Property {0} or directory not found inside of configuration files", property), e);
            throw new NoPropertiesException("Without configuration file!");
        }
    }

    public static byte[] returnEnvironmentValue(final String property) throws NoPropertiesException {
        Properties properties = new Properties();

        try (InputStream propFileInpStream = PropertyLoader.class.getClassLoader()
                .getResourceAsStream("environment.properties")) {

            properties.load(propFileInpStream);
            LOGGER.debug(MessageFormat.format("Getting {0} inside file environment config.properties: {2}", property, properties.getProperty(property)));

            return properties.getProperty(property).getBytes(StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOGGER.error(MessageFormat.format("Property {0} or directory not found inside of configuration files", property), e);
            throw new NoPropertiesException("Without configuration file!");
        }
    }
}
