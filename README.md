# WMS
## 一、大家从github中拉取本项目到本地的空文件夹，使用git clone命令
## 二、在wms-project下面创建一个maven工程，以wms-test-project为例
## 三、在maven工程中引入auth-base依赖(它帮助你处理权限认证，引入后就不需要关注登录认证的问题了)，它里面包含了SpringSecurity、Oauth2、SpringBoot、SpringMVC、fastjson、log4j、wms-common依赖
## 四、添加自己需要的依赖，像mybatis、redis以及其它的
## 五、写配置文件，复制wms-auth下的bootstrap.yml到当前模块的资源文件下，把application.name改成自己模块的名称
## 六、在nacos中写自己的配置文件，nacos地址：http://117.50.181.29:8845/nacos，账号密码都是nacos。登录后进去配置管理下的配置列表，点wms分支，添加自己的配置文件
**注意：配置文件的命名需要根据你的application.name来，group统一填写wms-project**
