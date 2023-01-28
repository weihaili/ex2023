package leetcdoe.ex20230128.testAnnotation.sdaopredis;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {

    private final static String SERVER_PORT = "80";

    private final static String REAL_IP_KEY = "X-Real-IP";

    private final static String FORWARD_IP_KEY = "X-Real-IP";

    private final static String PROXY_IP_KEY = "X-Real-IP";

    private final static String WL_PROXY_IP_KEY = "X-Real-IP";

    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static String getProjectPath() {
        return StringUtils.replace(getRequest().getServletContext().getContextPath(), "/", "\\");
    }

    public static String getServletPath() {
        return getRequest().getServletPath();
    }

    public static String getServerName() {
        return getRequest().getServerName();
    }

    public static String getServerPort() {
        return String.valueOf(getRequest().getServerPort());
    }

    public static String getRemoteAddr() {
        String ipAddr = getRequest().getHeader(REAL_IP_KEY);
        if (StringUtils.isNotBlank(ipAddr)) {
            return ipAddr;
        }
        ipAddr = getRequest().getHeader(FORWARD_IP_KEY);
        if (StringUtils.isNotBlank(ipAddr)) {
            return ipAddr;
        }
        ipAddr = getRequest().getHeader(PROXY_IP_KEY);
        if (StringUtils.isNotBlank(ipAddr)) {
            return ipAddr;
        }

        ipAddr = getRequest().getHeader(WL_PROXY_IP_KEY);
        if (StringUtils.isNotBlank(ipAddr)) {
            return ipAddr;
        }
        return null;
    }

    public static String getUrl() {
        return getServerName() + ":" + getServerPort() +getServletPath();
    }

}
