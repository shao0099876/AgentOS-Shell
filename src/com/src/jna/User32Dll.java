package jna;

import com.sun.jna.*;

public interface User32Dll extends Library {
        User32Dll INSTANCE=(User32Dll) Native.load("User32",User32Dll.class);
        NativeLong GetForegroundWindow();
        /*
        int GetWindowTextLengthA(
            HWND hWnd
        );
        */
        int GetWindowTextLengthA(NativeLong hWnd);
        /*
        int GetWindowTextA(
          HWND  hWnd,
          LPSTR lpString,
          int   nMaxCount
        );
        */
        int GetWindowTextA(NativeLong hWnd, Pointer lpString, int nMaxCount);
        /*
        BOOL EnumWindows(
          WNDENUMPROC lpEnumFunc,
          LPARAM      lParam
        );
        */
        boolean EnumWindows(EnumWindowsProc lpEnumFunc,int lParam);
        /*
        int GetClassNameA(
          HWND  hWnd,
          LPSTR lpClassName,
          int   nMaxCount
        );
         */
        int GetClassNameA(NativeLong hWnd,Pointer lpClassName,int nMaxCount);
        /*
        BOOL IsWindowVisible(
          HWND hWnd
        );
         */
        boolean IsWindowVisible(NativeLong hWnd);
        /*
        BOOL SetWindowPos(
          HWND hWnd,
          HWND hWndInsertAfter,
          int  X,
          int  Y,
          int  cx,
          int  cy,
          UINT uFlags
        );
         */
        boolean SetWindowPos(NativeLong hWnd,NativeLong hWndInsertAfter,int X,int Y,int cx,int cy,int uFlags);
}
