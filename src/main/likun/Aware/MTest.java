package Aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Administrator on 2016/12/2.
 */
public class MTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AwareConfig.class);

        AwareService awareService=context.getBean(AwareService.class);
        awareService.outputResult();
        context.close();

    }
}
