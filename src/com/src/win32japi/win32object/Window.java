package win32japi.win32object;

import com.sun.jna.NativeLong;
import win32japi.Windows;

public class Window {
    public NativeLong hWnd;
    public String title;
    public Window(NativeLong hWnd, String title){
        this.hWnd=hWnd;
        this.title=title;
    }

    public void setPosSize(int pos_x, int pos_y,int size_x,int size_y) {
        Windows.setWindowsPosition(hWnd,pos_x,pos_y,size_x,size_y);
    }
}
