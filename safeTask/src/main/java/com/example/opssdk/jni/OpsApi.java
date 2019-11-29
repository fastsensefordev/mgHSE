package com.example.opssdk.jni;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



/**
 * 音箱接口
 * <p>Title: OpsApi</p>
 * <p>Description: OpsApi</p>
 * <p>CreateTime: 2019/5/20 13:43</p>
 * @author cb
 * @version 1.0
 **/
@Component
public class OpsApi
{
	private final static Logger log = LoggerFactory.getLogger(OpsApi.class);
    /**
     * 任务唯一标志
     */
    public static int dwID = 0;
    /**
     * <p>Description:初始化</p>
     * <p>CreateTime:2019/11/14 14:22</p>
     * <p>@author dt</p>
     *
     */
    public static void init(String audioId,String musicPath) throws Exception
    {
//        if (!CLibrary.INSTANCE._SDK_Install_InitDll())
//        {
//            log.info("【初始化sdk失败！】");
//            throw new RuntimeException("初始化sdk失败");
//        }
//        log.info("【初始化sdk成功！】");
//
//        if (!CLibrary.INSTANCE._SDK_Install_InitNetworkManager(12680,0))
//        {
//            log.info("【初始化网络失败！】");
//            throw new RuntimeException("初始化网络失败");
//        }
//        log.info("【初始化网络成功！】");
//        Thread.sleep(6000);

        //TODO 可配置 多个网卡得情况使用该函数
//        CLibrary.INSTANCE._SDK_Install_BindNetwork("192.168.124.10");
//        Thread.sleep(3000);
//        log.info("###【绑定网卡成功！】###");
        

        //todo 可配置
//        dwID = CLibrary.INSTANCE._SDK_Install_AddTask("D:\\demo\\test.mp3|", "079|", 0,
//                null, null, 0);
        dwID = CLibrary.INSTANCE._SDK_Install_AddTask(musicPath+"|", audioId+"|", 0,
                null, null, 0);
        log.info("【添加任务dwID={}】", dwID);
    }

}
