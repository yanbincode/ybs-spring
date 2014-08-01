package security.manager;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * 在这个类中，最重要的是decide方法，如果不存在对该资源的定义，直接放行；否则，如果找到正确的角色，即认为拥有权限，并放行，<br>
 * 否则throw new AccessDeniedException("no right")
 * 
 * @author yanbin
 * 
 */
public class SimAccessDecisionManager implements AccessDecisionManager {

	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		
		// object is a URL.
		System.out.println(object.toString());

		// 循环遍历出配置信息，所请求的资源拥有的角色(一个资源对多个角色)
		Iterator<ConfigAttribute> iterator = configAttributes.iterator();
		while (iterator.hasNext()) {
			ConfigAttribute attribute = iterator.next();
			//访问所请求资源所需要的角色  
			String needRole = ((SecurityConfig) attribute).getAttribute();
			// 用户的角色  
			for (GrantedAuthority authority : authentication.getAuthorities()) {
				if (needRole.equals(authority.getAuthority())) {
					return;
				}
			}
		}
		throw new AccessDeniedException("no right");
	}

	@Override
	public boolean supports(ConfigAttribute arg0) {
		return true;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
