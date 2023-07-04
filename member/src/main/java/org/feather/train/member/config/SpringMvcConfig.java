package org.feather.train.member.config;

import jakarta.annotation.Resource;
import org.feather.train.common.interceptor.LogInterceptor;
import org.feather.train.common.interceptor.MemberInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @projectName: train
 * @package: org.feather.train.member.config
 * @className: SpringMvcConfig
 * @author: feather
 * @description: TODO
 * @since: 2023-07-04 8:41
 * @version: 1.0
 */

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    @Resource
    LogInterceptor logInterceptor;

    @Resource
    MemberInterceptor memberInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(logInterceptor);

        registry.addInterceptor(memberInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/member/hello",
                        "/member/member/send-code",
                        "/member/member/login"
                );
    }
}