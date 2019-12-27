package com.filter;

import com.netflix.zuul.IZuulFilter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description TODo
 * @Author LiXiuXiu
 * @Date 2019/12/27 下午 06:47
 */
public class MyZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //请求在被路由之前执行
        return FilterConstants.PRE_TYPE;//pre
    }

    @Override
    public int filterOrder() {
        // //请求头之前，查看请求参数
        return FilterConstants.PRE_DECORATION_FILTER_ORDER-1;//4
    }

    @Override
    public boolean shouldFilter() {
        //开启过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //获取请求上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //获取request请求
        HttpServletRequest request = currentContext.getRequest();
        String parameter = request.getParameter("access-token");
        //判断是否存在
        if(StringUtils.isBlank(parameter)){//不存在
            //不存在，未登陆，则拦截
            currentContext.setSendZuulResponse(false);
            //返回403
            currentContext.setResponseStatusCode(403);
        }
        return null;
    }
}
