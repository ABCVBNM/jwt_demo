# jwt_demo
A Java project that integrated JWT

### Step ###

1. 引入依赖
2. 编写TokenUtils类（在service包）

		1. 添加生成Token方法getToken
		2. 添加解析Token方法parseToken
		3. 添加验证Token方法verifyToken
3. 编写拦截器，拦截校验每次请求（在conf包）
4. 编写拦截器配置类，配置过滤的请求（在conf包）
5. 编写登陆类（在controller）

		1. 实现login方法，登陆后返回Token给上游
		2. 实现getUserInfoByToken方法，根据Token获取对应用户信息

