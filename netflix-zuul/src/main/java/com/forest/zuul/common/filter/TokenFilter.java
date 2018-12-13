package com.forest.zuul.common.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.forest.zuul.common.jwt.api.ResponseMgr;
import com.forest.zuul.common.jwt.api.TokenMgr;
import com.forest.zuul.common.jwt.config.Constant;
import com.forest.zuul.common.jwt.model.CheckResult;
import com.forest.zuul.common.jwt.model.SubjectModel;
import com.forest.zuul.common.utils.GsonUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import io.jsonwebtoken.Claims;

/**
 * 
 * @author forest
 *
 */
public class TokenFilter extends ZuulFilter {
	private final Logger logger = LoggerFactory.getLogger(TokenFilter.class);
	// 返回boolean确定filter是否执行
	@Override
	public boolean shouldFilter() {

		return true;
	}

	// 过滤器执行内容
	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String tokenStr = request.getHeader("Authorization");
		HttpServletResponse response = ctx.getResponse();
		String requestURL = request.getRequestURL().toString();
		logger.info("请求的URL地址：" + requestURL);
		if (tokenStr == null || tokenStr.equals("")) {
			//认证失败
	        response.setCharacterEncoding("utf-8");  //设置字符集
	        response.setContentType("text/html; charset=utf-8"); //设置相应格式
	        response.setStatus(401);
	        ctx.setSendZuulResponse(false); //不进行路由	     
	        ctx.setResponseBody(ResponseMgr.noLogin());       
	        return null;
		}
		// 验证JWT的签名，返回CheckResult对象
		CheckResult checkResult = TokenMgr.validateJWT(tokenStr);
		if (checkResult.isSuccess()) {
			Claims claims = checkResult.getClaims();
			logger.info("token校检通过checkResult：" + GsonUtil.objectToJsonStr(checkResult));
			SubjectModel user = GsonUtil.jsonStrToObject(claims.getSubject(), SubjectModel.class);
			logger.info("token校检通过user：" + GsonUtil.objectToJsonStr(user));
			// 校验用户信息是否合法
			return null;
		} else {
			switch (checkResult.getErrCode()) {
			// 签名过期，返回过期提示码
			case Constant.JWT_ERRCODE_EXPIRE:
				//认证失败
		        response.setCharacterEncoding("utf-8");  //设置字符集
		        response.setContentType("text/html; charset=utf-8"); //设置相应格式
		        response.setStatus(401);
		        ctx.setSendZuulResponse(false); //不进行路由
		        ctx.setResponseBody(ResponseMgr.loginExpire());  
				break;
			// 签名验证不通过
			case Constant.JWT_ERRCODE_FAIL:
				//认证失败
		        response.setCharacterEncoding("utf-8");  //设置字符集
		        response.setContentType("text/html; charset=utf-8"); //设置相应格式
		        response.setStatus(401);
		        ctx.setSendZuulResponse(false); //不进行路由
		        ctx.setResponseBody(ResponseMgr.loginExpire());  
				break;
			default:
				break;
			}
		}
		return null;
	}

	// 返回过滤器的类型：pre、route、post、error
	// PRE：请求被路由之前被调用，身份验证
	// ROUTING：将请求路由到微服务。
	// POST：路由到微服务之后执行
	// ERROR：在其他阶段发生错误时执行。
	@Override
	public String filterType() {

		return "pre";
	}

	// 返回int值，来确定filter的执行顺序，不同的过滤器允许返回相同的数字
	@Override
	public int filterOrder() {

		return 0;
	}

}
