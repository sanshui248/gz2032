package com.ibm.shiro;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

//@Configuration
public class ShiroConfig {

	@Bean
	@ConditionalOnMissingBean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
		defaultAAP.setProxyTargetClass(true);
		return defaultAAP;
	}
	//将自己的验证方式加入容器
	@Bean
	public UserRealm myShiroReaml() {
		UserRealm userRealm = new UserRealm();
		return userRealm;
	}
	//权限管理
	@Bean
	public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroReaml());
        return securityManager;
    }
	//Filter工厂
	@Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> map = new HashMap<>();
        //登出
       // map.put("/logout", "logout");
        map.put("/toIndex","anon");
        map.put("/login","anon");
        //对所有用户认证
        
        map.put("/**", "authc");
        
        //登录
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        //首页
        shiroFilterFactoryBean.setSuccessUrl("/toIndex");
        //错误页面,认证不通过跳转
       shiroFilterFactoryBean.setUnauthorizedUrl("/toError");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }
	
}
