package pro.chenggangpro.extension.mybatis.generator.core;

import org.junit.Assert;
import org.junit.Test;
import pro.chenggangpro.extension.mybatis.generator.core.core.PropertiesHolder;
import pro.chenggangpro.extension.mybatis.generator.core.properties.GeneratorExtensionProperties;

/**
 * @author: chenggang
 * @date 2020-02-01.
 */
public class PropertiesTests {

    @Test
    public void testReadProperties(){
        GeneratorExtensionProperties properties = PropertiesHolder.getInstance().getProperties();
        Assert.assertNotNull(properties);
        properties.validateByDefault();
        System.out.println(properties);
    }
}
