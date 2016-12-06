package Aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by Administrator on 2016/12/2.
 */
@Service
public class AwareService implements BeanNameAware,ResourceLoaderAware {
    private String beanName;
    private ResourceLoader loader;
    public void setBeanName(String name) {
        this.beanName=name;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader=resourceLoader;
    }
    public void  outputResult(){
        System.out.println("Bean的名称为："+beanName);
        Resource resource=loader.getResource("classpath:likun/Aware/");
        try {
            System.out.println(IOUtils.toString(resource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
