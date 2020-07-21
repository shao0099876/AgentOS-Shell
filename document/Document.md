# AgentOS 文档
## AgentOS Shell
本章对AgentOS的Shell特性、命令与使用做介绍
### Shell启动参数
Shell启动参数格式： `shell [--network-enable <端口号>] <Script路径>`

参数含义：
* `--network-enable <端口号>`  表示启用网络功能，并设置给定端口号
## AgentOS Script
本章对AgentOS能够读取、运行的Script代码集合做介绍。
### Script文件夹结构
```
<Script名>
|
—— <Script名>.aoscript
|
—— "Scene"文件夹
```