# AgentOS 文档
## 一、AgentOS Shell
本章对AgentOS的Shell特性、命令与使用做介绍
### 1.1 Shell启动参数
Shell启动参数格式： `shell [--network-enable <端口号>] <Script路径>`

参数含义：
* `--network-enable <端口号>`  表示启用网络功能，并设置给定端口号
## 二、AgentOS Script
本章对AgentOS能够读取、运行的Script文件结构做介绍。
### 2.1 Script文件夹结构
```
<Script名>
|
—— <Script名>.aoscript
|
—— "Scene"文件夹
```
&emsp;在Script名命名的文件夹下，需要建立主文件来存放Script的核心数据，主文件名与Script名应当保持一致，后缀名为aoscript；需要建立名为Scene的文件夹以存放各场景的数据。