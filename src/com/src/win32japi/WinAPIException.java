package win32japi;

public class WinAPIException extends Exception{
    String errinfo;
    public WinAPIException(String errinfo){
        this.errinfo=errinfo;
    }
    public String toString(){
        return "errinfo:"+errinfo;
    }
}
