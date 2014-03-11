/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.sztaki.ilab.longneck;

import hu.sztaki.ilab.longneck.bootstrap.Hook;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

/**
 *
 * @author Geszler Döme <gdome@ilab.sztaki.hu>
 */
public class CvdHook implements Hook, ResourceLoaderAware {
    
    private ResourceLoader resourceLoader;

    public Properties getDefaultProperties() {
        return new Properties();
    }

    public void init(Properties properties, ApplicationContext context) {
        // Do nothing
    }

    public List<URL> getSchemas() throws IOException {
        List<URL> schemas = new ArrayList<URL>(1);
        schemas.add(resourceLoader.getResource(
                "classpath:META-INF/schema/longneck-cvd.xsd").getURL());
        
        return schemas;
    }

    public List<URL> getMappings() throws IOException {
        List<URL> mappings = new ArrayList<URL>(1);
        
        mappings.add(resourceLoader.getResource(
                "classpath:META-INF/castor/longneck-cvd.mapping.xml").getURL());
        
        return mappings;
    }

    public void setResourceLoader(ResourceLoader rl) {
        resourceLoader = rl;
    }
}
