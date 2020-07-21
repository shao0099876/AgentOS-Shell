package jna;

import com.sun.jna.NativeLong;
import com.sun.jna.win32.StdCallLibrary;
/*
BOOL CALLBACK EnumWindowsProc(
  _In_ HWND   hwnd,
  _In_ LPARAM lParam
);
 */
public interface EnumWindowsProc extends StdCallLibrary.StdCallCallback {
    boolean callback(NativeLong hwnd,int lParam);
}
