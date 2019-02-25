package cn.com.demo.permission.configuration;

import cn.com.demo.permission.configuration.interceptor.UserInterceptor;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebBeanConfiguration {


    @Autowired
    private UserInterceptor userInterceptor;

    /**
     * 实例化WebMvcConfigurer接口
     *
     * @return
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            /**
             * 添加拦截器
             * @param registry
             */
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //新增需要拦截的上下文
                List<String> list = Lists.newArrayList();
                list.add("/common/url");
                list.add("/act2019/newYearAct/index");
                registry.addInterceptor(userInterceptor).addPathPatterns(list);
            }
        };
    }
}
