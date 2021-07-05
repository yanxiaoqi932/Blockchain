package handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.CountDownLatch;

/**
 * run this main method and check result 
 */
public class Main {
	private static Logger logger = LoggerFactory.getLogger(Main.class);
	
    public static void main(String args[]) throws Exception {
    	FabricHelper helper = FabricHelper.getInstance();
        helper.setConfigCtx("C:\\Users\\86153\\javasdkdemo_src\\config\\demo-channel-sdk-config.yaml");
        LoopInvoke(1,"user","10000");
    }
    
    public static void LoopInvoke(int loop,String user,String num) throws Exception{
        FabricHelper helper = FabricHelper.getInstance();
        boolean resp;
        for (int i=0; i<loop;i++){  //loop代表执行转账和查账操作次数
            // 用户可以修改下面两行实现invoke的调用
            String[] data = {user,num};  //表示向testuser转账100
            resp = helper.invokeBlockchain("insert", data);  //开始转账操作
            if(resp == false) {
                logger.info("insert new data <" + data[0] + ", " +  data[1] + ">" + " fail");  //区块链转账失败
                return;
            }
            logger.info("insert new data <" + data[0] + ", " +  data[1] + ">" + " success");  //区块链转账成功

            // 用户可以修改下面两行实现query的调用
            String []name = {"testuser"};  //查询testuser当前余额
            String value = helper.queryBlockchain("query", name);
            logger.info("query key <" + name[0] + "> value is " + value);
    	}



    }
}