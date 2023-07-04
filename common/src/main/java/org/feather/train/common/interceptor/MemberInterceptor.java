package org.feather.train.common.interceptor;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.feather.train.common.context.LoginMemberContext;
import org.feather.train.common.resp.MemberLoginResp;
import org.feather.train.common.utils.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @projectName: train
 * @package: org.feather.train.common.interceptor
 * @className: MemberInterceptor
 * @author: feather
 * @description:  拦截器：Spring框架特有的，常用于登录校验，权限校验，请求日志打印
 * @since: 2023-07-04 8:38
 * @version: 1.0
 */
@Component
public class MemberInterceptor   implements HandlerInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(MemberInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取header的token参数
        String token = request.getHeader("token");
        if (StrUtil.isNotBlank(token)) {
            LOG.info("获取会员登录token：{}", token);
            JSONObject loginMember = JwtUtil.getJSONObject(token);
            LOG.info("当前登录会员：{}", loginMember);
            MemberLoginResp member = JSONUtil.toBean(loginMember, MemberLoginResp.class);
            LoginMemberContext.setMember(member);
        }
        return true;
    }
}
