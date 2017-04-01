/**
 * 
 */
package com.angie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 参数特殊字符过滤
 * @author Angie
 * github:https://github.com/Angie520
 * @date 2017年4月1日 下午3:24:34
 */
public class MHttpServletRequest extends HttpServletRequestWrapper {
	public MHttpServletRequest(HttpServletRequest request) {
        super(request);
    }
	
	@Override
    public String getParameter(String name) {
        // 返回值之前 先进行过滤
        return SpringBootDefenseXssApplication.stripXss(super.getParameter(SpringBootDefenseXssApplication.stripXss(name)));
    }

    @Override
    public String[] getParameterValues(String name) {
        // 返回值之前 先进行过滤
        String[] values = super.getParameterValues(SpringBootDefenseXssApplication.stripXss(name));
        if(values != null){
            for (int i = 0; i < values.length; i++) {
                values[i] = SpringBootDefenseXssApplication.stripXss(values[i]);
            }
        }
        return values;
    }
}
