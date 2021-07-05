# javasdkdemo 使用说明

------

使用 fabric-java-sdk 进行链代码的query和invoke

> * fabric服务
> * java 1.8+
> * 配置文件和证书

## 0	注意：
1  sdk配置参数，证书存放路径必须满足下面条件：

windows系统：必须指定到 javasdkdemo\config，如C:\javasdkdemo\config        后面不可以带''

linux系统：      必须指定到 javasdkdemo/config，如 /root/javasdkdemo/config  后面不可以带'/'

2 config目录存放orderer组织的管理员证书、organization组织的管理员证书和SDK配置文件。

其中所有管理员证书config目录中解压即可，SDK配置文件也解压。

3 运行java -jar javasdkdemo.jar
预期结果：前两行打印不影响程序运行，是正常的。后面两行是程序真正输出结果。

2020-09-23 21:14:19,110 WARN [org.hyperledger.fabric.sdk.helper.Config] - Failed to load any configuration from: config.properties. Using toolkit defaults

2020-09-23 21:14:20,499 INFO [org.hyperledger.fabric.sdk.Channel] - Channel Channel{id: 1, name: channel} eventThread started shutdown: false  thread: null

2020-09-23 21:14:22,668 INFO [handler.Main] - insert new data <testuser, 100> success

2020-09-23 21:14:22,688 INFO [handler.Main] - query key  value is 100


## 1、配置文件说明

重点关注organizations的配置项 cryptoPath 
client 使用的cryptoPath 的msp,tls证书与fabric交互。

## 2、Main文件说明

重点关注 main 方法的初始化，示例代码使用的 chaincode_example02.zip
```
public class Main {
	private static Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String args[]) throws Exception {
    	FabricHelper helper = FabricHelper.getInstance();
    	helper.setConfigPath("E:/opt/config/huawei.yaml");
    	helper.setChannelName("mychannel");
    	helper.setChaincodeName("haoccc");
    	helper.setAccessKey("5ed48dd21c15830c0f2068e03103f7078e7405a5");
    	
    	LoopInvoke(1);
    	//StartMultiTask(1,1);
    }
    
    public static void LoopInvoke(int loop) throws Exception{
    	FabricHelper helper = FabricHelper.getInstance();
    	for (int i=0; i<loop;i++){
        	helper.invokeBlockchain("invoke", new String[]{"a","b","100"});
        	String a=helper.queryBlockchain("query", new String[]{"a"});
        	String b=helper.queryBlockchain("query", new String[]{"a"});
        	logger.info("after invoke  a=" + a +", invoke b=" + b);
    	}
    }
```
## 3、国密的使用

> * 引用lib目录中的fabric-sdk-java-1.1.0-jar-with-dependencies.jar
> * 注释掉pom.xml中对社区fabric-sdk-java的引用


## 4、已知缺陷问题

> * 多组织背书需要调整下 invokeBlockchain 函数。
> * peer 会缓存连接，上时间不调用会有超时错误。
> * Jdk需使用1.8以上的64位版本，使用32位的jdk会出现如下错误
```
OpenSSL is not installed on the system
```

