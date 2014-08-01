1、安全包括两个主要操作， “认证”和“验证”（或权限控制）。这就是Spring Security 面向的两个主要方向。
“认证” 是为用户建立一个他所声明的主体的过程， （“主体”一般是指用户，设备或可以在你系统中执行行动的其他系统）。
“验证”指的一个用户能否在你的应用中执行某个操作。在到达授权判断之前，身份的主体已经由身份验证过程建立了

2、过滤器的指定位置 ：

CHANNEL_FILTER 
	ChannelProcessingFilter
	http/intercept-url@requires-channel
	
CONCURRENT_SESSION_FILTER
	ConcurrentSessionFilter
	session-management/concurrency-control
	
SECURITY_CONTEXT_FILTER
	SecurityContextPersistenceFilter
	http

LOGOUT_FILTER 
	LogoutFilter 
	http/logout
	
X509_FILTER 
	X509AuthenticationFilter 
	http/x509
	
PRE_AUTH_FILTER
	AstractPreAuthenticatedProcessingFilter 
	Subclasses N/A
	
CAS_FILTER 
	CasAuthenticationFilter 
	N/A
	
FORM_LOGIN_FILTER
	UsernamePasswordAuthenticationFilter
	http/form-login
	
BASIC_AUTH_FILTER 
	BasicAuthenticationFilter 
	http/http-basic
	
SERVLET_API_SUPPORT_FILTER
	SecurityContextHolderAwareFilter
	http/@servlet-api-provision
	
REMEMBER_ME_FILTER
	RememberMeAuthenticationFilter
	http/remember-me

ANONYMOUS_FILTER 
	SessionManagementFilter 
	http/anonymous

SESSION_MANAGEMENT_FILTER
	AnonymousAuthenticationFilter
	session-management
	
EXCEPTION_TRANSLATION_FILTER
	FilterSecurityInterceptor 
	http
	
SWITCH_USER_FILTER
	SwitchUserAuthenticationFilter
	N/A