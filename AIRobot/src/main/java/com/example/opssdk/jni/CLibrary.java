package com.example.opssdk.jni;

import java.net.URL;

import org.springframework.stereotype.Component;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * @author Administrator
 * @create 2019-05-20 15:44
 * @desc
 **/
@Component
public interface CLibrary extends Library
{
    // DLL文件默认路径为项目根目录，若DLL文件存放在项目外，请使用绝对路径。（此处：(Platform.isWindows()?"msvcrt":"c")指本地动态库msvcrt.dll）
	// CLibrary INSTANCE = (CLibrary) Native.loadLibrary("D:\\demo\\Dll-x64\\InLine_SDK_All_API.dll", CLibrary.class);
	CLibrary INSTANCE = (CLibrary) Native.loadLibrary(System.getProperty("java.library.path")+"\\Dll-x64\\InLine_SDK_All_API.dll", CLibrary.class);//dll文件不能使用相对路径

    /**
     * <p>Description: 首先初始化整个SDK的环境</p>
     * <p>CreateTime:2019/5/20 13:45</p>
     * <p>@author cb</p>
     *
     * @return boolean 返回false请检查环境所需求的库是否都已经添加
     */
    boolean _SDK_Install_InitDll();

    /**
     * <p>Description: 初始化整个SDK指令集传输的网络环境</p>
     * <p>CreateTime:2019/5/20 13:48</p>
     * <p>@author cb</p>
     *
     * @param  iPort iPort为一个int类型参数,目前初始化必须为12680
     * @param  networkModel networkModel为0初始化局域网 1初始化跨网段或者互联网
     * @return boolean 返回false请检查电脑防火墙，关闭即可。亦或者端口被占用
     */
    boolean _SDK_Install_InitNetworkManager(int iPort, int networkModel);

    /**
     * <p>Description: 添加定时曲目播放，实时曲目播放</p>
     * <p>CreateTime:2019/5/20 13:51</p>
     * <p>@author cb</p>
     *
     * @param  cTaskInfoList 为曲目列表名称,以符合 | 隔开，eg：1.mp3|2.mp3|，当只添加一首曲目的时候eg：1.mp3|
     * @param  idList 为终端设备ID号，以符合 | 隔开，eg：1 |2 ，当只添加一个终端的时候eg：1 |
     * @param  iTaskType 为播放类型，0的时候为列表顺序模式，播放完毕列表歌曲自动停止，1的时候为随机列表模式，2表示循环播放模式，不会自动停止
     * @param  startData 为任务的开始日期，如果不需要设置定时可以填写null
     * @param  startTime 为任务的开始时间，如果不需要设置定时可以填写null
     * @param  duration 为任务持续时间，不如不需要设置，填写0即可
     * @return int -1表示参数填写错误，-2表示设备ID号没填写正确，-3表示申请内存失败，
     *          返回非负数表示成功，中文歌曲默认是GB2312，否则会返回失败
     */
    int _SDK_Install_AddTask(String cTaskInfoList, String idList, int iTaskType,
                             String startData, String startTime, int duration);

    /**
     * <p>Description: 立即执行任务</p>
     * <p>CreateTime:2019/5/20 14:01</p>
     * <p>@author cb</p>
     *
     * @param  dwID dwID为addTask的返回值
     * @return dwID输入异常返回失败
     */
    boolean _SDK_Install_StartTask(long dwID);

    /**
     * <p>Description: 立即停止任务</p>
     * <p>CreateTime:2019/5/20 14:03</p>
     * <p>@author cb</p>
     *
     * @param  dwID dwID为addTask的返回值
     * @return dwID输入异常返回失败
     */
    boolean _SDK_Install_StopTask(long dwID);

    /**
     * <p>Description: 获取设备当前信息</p>
     * <p>CreateTime:2019/5/20 14:03</p>
     * <p>@author cb</p>
     *
     * @param  terminalID 为设备ID号，
     * @param  type 为需要查询的信息 传入0查询终端连接状态（返回0表示未连接 1表示链接），1查询当前设备音量(返回0-15)，2查询终端任务状态。(返回12表示空闲 0表示定时音乐 4表示实时寻呼等)
     * @return int
     */
    int _SDK_Install_GetTerminalInformation(long terminalID, int type);

    /**
     * <p>Description: 作用用于绑定一个网卡，当多网卡的时候需调用</p>
     * <p>CreateTime:2019/5/20 14:03</p>
     * <p>@author cb</p>
     *
     * @param  IPAddress 为当前需要绑定的IP地址
     */
    void _SDK_Install_BindNetwork(String IPAddress);

}
