package com.forest.api.webapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.forest.api.common.web.BaseController;
import com.forest.api.entity.AppUser;
import com.forest.api.entity.Demo;
import com.forest.api.service.AppUserService;
import com.forest.api.service.DemoService;
import com.forest.common.jwt.api.TokenMgr;
import com.forest.common.jwt.config.Constant;
import com.forest.common.jwt.model.SubjectModel;
import com.forest.common.log.Log4j2Utils;
import com.forest.common.utils.CommonResult;
import com.forest.common.utils.IdGen;
import com.forest.common.utils.excel.ExportExcel;

/**
 * 
 * @author forest
 *
 */
@RestController
@RequestMapping(value = "/demo")
public class DemoController extends BaseController{

	@Value("${server.port}")
    String port;

	@Autowired
	private DemoService demoService;
	@Autowired
	private AppUserService appUserService;
	
    @RequestMapping(value="/hello", method= RequestMethod.GET)
    public CommonResult hello() throws InterruptedException {
    	
    	Logger log = Log4j2Utils.getExceptionLogger();
    	Logger log1 = Log4j2Utils.getBussinessLogger();
    	Logger log2 = Log4j2Utils.getDBLogger();
    	log.error("getExceptionLogger===日志测试");
    	log1.info("getBussinessLogger===日志测试");
    	log2.debug("getDBLogger===日志测试");
    	//Thread.sleep(1000000);
    	Demo d = demoService.get(new Demo());
        return new CommonResult(0000, d, "数据获取成功");
    }
    
    @RequestMapping(value="/login", method= RequestMethod.POST)
    @ResponseBody
    public CommonResult login(HttpServletResponse response,AppUser user) throws InterruptedException {
		try {
			AppUser appUser = appUserService.login(user);
			if(appUser!=null){
				if(StringUtils.equals(user.getPassword(), appUser.getPassword())){
					if(StringUtils.equals(appUser.getLoginFlag(), "0")) {
						return new CommonResult(1007, null, "您已经被禁止登录");
					}
					// 生成TOKEN
					SubjectModel sub = new SubjectModel(appUser.getId(), appUser.getLoginName());//用户信息
					String token = TokenMgr.createJWT(IdGen.uuid(), Constant.JWT_ISS,TokenMgr.generalSubject(sub), Constant.JWT_TTL);
					response.addHeader("Authorization", token);
					return new CommonResult(0000, appUser, "登陆成功");
				}else {
					return new CommonResult(1008, null, "密码错误");
				}
			}else{
				return new CommonResult(1009, null, "账号错误");
			}
		} catch (Exception e) {
			logger.error("登录异常:"+e.getMessage());
			return new CommonResult(500, null, "登录异常");
		}
    }
    @RequestMapping(value="/export", method= RequestMethod.GET)
    public CommonResult hello(HttpServletResponse response) throws InterruptedException, IOException {
    	AppUser user=new AppUser();
    	user.setLoginName("tyghh");
    	AppUser appUser = appUserService.login(user);
    	List<Object>  li=new ArrayList<Object>();
    	li.add(appUser);
    	String fileName = "export.xlsx";
    	new ExportExcel("用户数据", AppUser.class).setDataList(li).write(response, fileName).dispose();
        return null;
    }
}
