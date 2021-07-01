package pro.chenggang.extension.mybatis.generator.core.context;

import org.mybatis.generator.config.Context;
import pro.chenggang.extension.mybatis.generator.option.GeneratorType;
import pro.chenggang.extension.mybatis.generator.properties.GeneratorExtensionProperties;

/**
 * @author: chenggang
 * @date 2020-01-21.
 */
public interface ContextGenerator {

    /**
     * generator type
     * @return
     */
    GeneratorType targetGeneratorType();

    /**
     * generateContext
     * @param extensionProperties
     * @return
     */
    Context generateContext(GeneratorExtensionProperties extensionProperties);
}
