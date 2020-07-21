package win32japi;

import jna.EnumWindowsProc;
import jna.User32Dll;
import com.sun.jna.Memory;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import win32japi.win32object.Window;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Windows {
    public static String getWindowTitle(NativeLong hWnd) throws WinAPIException {
        /**
         * 获取窗口标题
         * 传入窗口句柄
         * 返回GBK格式的字符串
         */

        //获取窗口标题长度
        int length= getWindowTitleLength(hWnd);
        if(length<=0){
            throw new WinAPIException("窗口标题长度异常");
        }

        //根据标题长度创建缓冲区字符串
        Pointer pointer=new Memory(length*2);

        //获取窗口标题内容
        int res= User32Dll.INSTANCE.GetWindowTextA( hWnd, pointer ,length+1);
        if(res<=0){
            throw new WinAPIException("获取窗口标题失败");
        }

        //从指针中获取字节数组
        byte[] bytes=pointer.getByteArray(0,res);

        //将字节数组按GBK编码转化为字符串
        String s= null;
        try {
            s = new String(bytes,"GBK");
        } catch (UnsupportedEncodingException e) {
            throw new WinAPIException("GBK编码转换失败");
        }
        return s;
    }

    public static int getWindowTitleLength(NativeLong hWnd){
        /**
         * 获取窗口标题长度
         * 传入窗口句柄
         * 返回标题长度
         */
        return User32Dll.INSTANCE.GetWindowTextLengthA(hWnd);
    }

    public static Window[] enumWindowsTitle(){
        /**
         * 枚举窗口
         * 返回窗口对象列表
         */
        ArrayList<Window> res=new ArrayList<Window>();
        User32Dll.INSTANCE.EnumWindows(new EnumWindowsProc() {
            @Override
            public boolean callback(NativeLong hwnd, int lParam) {
                if(User32Dll.INSTANCE.IsWindowVisible(hwnd)){
                    try {
                        res.add(new Window(hwnd,getWindowTitle(hwnd)));
                    } catch (WinAPIException e) {
                    }
                }
                return true;
            }
        },0);
        return res.toArray(new Window[0]);
    }
    public static void setWindowsPosition(NativeLong hwnd,int pos_x,int pos_y,int size_x,int size_y){
        /**
         * 设置窗口位置大小
         * 输入窗口句柄
         * 输入窗口位置XY
         * 输入窗口大小XY
         */
        boolean res=User32Dll.INSTANCE.SetWindowPos(hwnd,new NativeLong(0),pos_x,pos_y,size_x,size_y,0x4000);
    }
}
