package study.mycat.config;


import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * @desc Druid配置
 * @author ashui
 * @date 2018/4/30.
 */
@Configuration
public class DruidConfig {


    @Value("${druid.loginUsername:druid}")
    private String loginUsername;

    @Value("${druid.loginPassword:druid}")
    private String loginPassword;

    @Value("${druid.allow:127.0.0.1}")
    private String allow;

    @Value("${druid.deny:}")
    private String deny;

    @Bean
    public ServletRegistrationBean servletRegistration() {
        //添加初始化参数：initParams
        ServletRegistrationBean servletRegistration = new ServletRegistrationBean(new StatViewServlet());
        servletRegistration.addUrlMappings("/druid/*");
        //白名单
        if(StringUtils.isEmpty(allow)){
            servletRegistration.addInitParameter("allow", allow);
        }
        //IP黑名单 (存在共同时，deny优先于allow)
        if(StringUtils.isEmpty(deny)) {
            servletRegistration.addInitParameter("deny", deny);
        }
        //登录查看信息的账号密码.
        servletRegistration.addInitParameter("loginUsername", loginUsername);
        servletRegistration.addInitParameter("loginPassword", loginPassword);
        //是否能够重置数据.
        servletRegistration.addInitParameter("resetEnable", "false");
        return servletRegistration;
    }
}