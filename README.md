#java-iserver 1.0.0 使用说明
一个基于servlet的简单的注解实现接口服务端 

##系统要求
``linux`` ``mac``

##JDK版本
``
1.8
``

##创建service类

```java
@ServiceBean (name=”testService”)   // 名称可不填，默认开头小写。ajax请求必须要与名称相同
public class TestService  implements IService{ // json返回方式
	@Override
	public Object execute(Map<String, String> params) throws Exception{
	Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success for inval : " + params.get("name"));
		return map;
	}
}
```


##配置web.xml
```xml
<context-param>
<!-- 文件名,可通过代码更改 com.eno.simple.iserver.web.tool.core.Constants.ANNO_XML_CONFIG_LOCATION -->
<param-name>iServiceConfigLocation</param-name>
<!-- xml地址,可以为classpath:com.eno.xx.xml 。 -->
<!-- 无classpath表示，在webroot根目录下的文件。 WEB-INF/iServiceConfigLocation.xml -->
<param-value>classpath:iServiceConfigLocation.xml</param-value>        
</context-param>
```

##iServiceConfigLocation.XML文件格式
```xml
<?xml version="1.0" encoding="UTF-8"?>
<config>
    <service>
		<list>
			<item>com.eno.test</item>
		</list>
	</service>
</config>
```


##必备url参数
###url地址: iserverHandler
* 参数名  : ANNO_BEAN
    * 备注 : service注解名(默认类名小写开头，可自定义)


##Html-ajax调用方式
```javascript
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>

<script type="text/javascript">
 function test(){
	 $.ajax({
		url:"iserverHandler",	// 请求的url地址,Struts2中就是请求的<action>的name
		type:"post",	// 提交方式
		data:{"ANNO_BEAN":"testService"},	// 提交的数据,一般使用JSON表示
		success:function(data){	// 请求成功后执行的操作
			alert(JSON.stringify(data);
		},
		error:function(data){	// 请求失败后执行的操作
			alert("error")
		}
	 }) 
 }

</script>
```
 

##关于作者
* [qq空间](http://user.qzone.qq.com/945891539)
 
