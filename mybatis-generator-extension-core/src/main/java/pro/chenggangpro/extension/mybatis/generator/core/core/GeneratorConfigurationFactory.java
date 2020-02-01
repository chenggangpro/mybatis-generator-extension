package pro.chenggangpro.extension.mybatis.generator.core.core;

import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.exception.InvalidConfigurationException;
import pro.chenggangpro.extension.mybatis.generator.core.core.context.ContextGenerator;
import pro.chenggangpro.extension.mybatis.generator.core.option.GeneratorType;
import pro.chenggangpro.extension.mybatis.generator.core.properties.GeneratorExtensionProperties;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author: chenggang
 * @date 2019-10-22.
 */
public class GeneratorConfigurationFactory {

    private Map<GeneratorType, ContextGenerator> contextGeneratorContainer = new HashMap<>();

    public void addContextGenerator(ContextGenerator contextGenerator){
        this.contextGeneratorContainer.put(contextGenerator.targetGeneratorType(),contextGenerator);
    }

    public Configuration getConfiguration(){
        Configuration configuration = new Configuration();
        GeneratorExtensionProperties extensionProperties = PropertiesHolder.getInstance().getProperties();
        extensionProperties
                .getGenerateType()
                .stream()
                .sorted(Enum::compareTo)
                .map(item-> Optional.ofNullable(contextGeneratorContainer.get(item)))
                .filter(Optional::isPresent)
                .map(item->item.get().generateContext(extensionProperties))
                .forEachOrdered(configuration::addContext);
        try {
            configuration.validate();
        } catch (InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
        return configuration;
    }
}
