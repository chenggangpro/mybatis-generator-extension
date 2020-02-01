package pro.chenggangpro.extension.mybatis.generator.core.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import pro.chenggangpro.extension.mybatis.generator.core.option.GeneratorType;
import pro.chenggangpro.extension.mybatis.generator.core.option.LombokConfig;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author: chenggang
 * @date 2020-01-21.
 */
@Getter
@Setter
@ToString
public class GeneratorExtensionProperties {

    /**
     * properties file name(yaml)
     */
    public static final String PROPERTIES_FILE_NAME_YAML = "mybatis-generator.yaml";
    /**
     * properties file name(yml)
     */
    public static final String PROPERTIES_FILE_NAME_YML = "mybatis-generator.yml";

    /**
     * base package
     */
    private String basePackage;
    /**
     * java/xml parentLocation
     */
    private String parentLocation = "";
    /**
     * java location
     */
    private String javaLocation = "src/main/java";
    /**
     * xml location
     */
    private String mapperXmlLocation = "src/main/resources";
    /**
     * model location
     */
    private String modelPackage = "entity.model";
    /**
     * mapper package
     */
    private String mapperInterfacePackage = "mapper";
    /**
     * xml package
     */
    private String mapperXmPackage = "mapper";
    /**
     * jdbc driver class name
     */
    private String driverClass;
    /**
     * jdbc connection url
     */
    private String connectionUrl;
    /**
     * jdbc username
     */
    private String username;
    /**
     * jdbc password
     */
    private String password;
    /**
     * target tableName
     */
    private Set<String> tableName;
    /**
     * table trim pattern
     */
    private String tableTrimPattern="";
    /**
     * lombok config
     */
    private LinkedHashSet<LombokConfig> lombok;
    /**
     * generator type
     */
    private Set<GeneratorType> generateType;
    /**
     * generate column comment
     */
    private Boolean generateComment = true;

    public void validateByDefault(){
        Stream.of(this.getClass().getDeclaredFields())
                .filter(field -> {
                    if("basePackage".equals(field.getName())){
                        return false;
                    }
                    return String.class.isAssignableFrom(field.getType());
                })
                .peek(field -> field.setAccessible(true))
                .forEach(field -> {
                    Object fieldValue = null;
                    try {
                        fieldValue = field.get(this);
                    } catch (IllegalAccessException e) {}
                    if(Objects.isNull(fieldValue)){
                        throw new IllegalArgumentException("Mybatis Generator Properties ( " + field.getName() + " ) Must Be Set");
                    }
                    String fieldStringValue = (String) fieldValue;
                    if(StringUtils.isEmpty(fieldStringValue)){
                        throw new IllegalArgumentException("Mybatis Generator Properties ( " + field.getName() + " ) Must Be Set");
                    }
                });
        if(StringUtils.isEmpty(this.basePackage)){
            throw new IllegalArgumentException("Mybatis Generator Properties ( basePackage ) Must Be Set");
        }
        if(Objects.isNull(tableName) || tableName.isEmpty()){
            tableName = new HashSet<>();
            tableName.add("%");
        }
        if(Objects.isNull(lombok)){
            lombok = new LinkedHashSet<>();
        }
        if(Objects.isNull(generateType) || generateType.isEmpty()){
            generateType = new HashSet<>();
            generateType.add(GeneratorType.SIMPLE);
            generateType.add(GeneratorType.DYNAMIC);
        }
        if(!"".equals(parentLocation) && !parentLocation.endsWith("/")){
            parentLocation = parentLocation + "/";
        }
        if(Objects.isNull(generateComment)){
            this.generateComment = true;
        }
    }

}
