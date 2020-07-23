# AgentOS 文档
## 一、AgentOS Shell
本章对AgentOS的Shell特性、命令与使用做介绍
### 1.1 Shell启动参数
Shell启动参数格式： `shell [--network-enable <端口号>] <Script名> <Script根文件夹路径>`

参数含义：
* `--network-enable <端口号>`  表示启用网络功能，并设置给定端口号
## 二、AgentOS Script
本章对AgentOS能够读取、运行的Script文件结构做介绍。
### 2.1 Script结构
```
<Script名>
|
—— <Script名>.aosmanifest
|
—— "Scene"文件夹
```
&emsp;在Script名命名的文件夹下，需要建立主文件来存放Script的核心数据，主文件名与Script名应当保持一致，后缀名为aosmanifest；需要建立名为Scene的文件夹以存放各场景的数据。

&emsp;aoscript文件中应当以XML文本标记语言语法撰写，其结构如下：
```
<manifest>
    <scene>
        <id> [场景ID号] </id>
        <name> [场景名称] </name>
    </scene>
    <scene>...</scene>
    ...
</manifest>
```
### 2.2 Scene
&emsp;一个Script的运行基本单位是Scene场景。所有的操作都将基于某个特定的场景进行。

&emsp;一个场景的基本单位是图片，通过比较AOS捕获到的图片与用户给定图片的区别，可以判断当前程序运行于的场景。此外，为了部分实现自适应特性，AOS将对同一场景的所有图片取交集，获得一份场景特征图，用于优化识别过程。

&emsp;在应用中，用户只需给出场景截图即可，AOS将比较捕获到的图片与场景截图的相似度：
* 如果相似度为100%，则直接判定场景，不做其他处理；
* 如果高于90%则执行：
    1. 将该图片捕获并保存
    2. 与场景特征图比较，更新场景特征图
* 如果低于90%则枚举下一个场景特征图，重复判定
* 如果所有场景特征图相似度均不高于90%，则暂停运行，询问用户图片所属场景

&emsp;由于AOS在运行中会对场景做自适应学习，因此用户甚至可以在无输入的情况下，遵循AOS的引导进行标注学习。

AOS每次启动时将重新生成场景特征图，存储于内存，关闭即丢失。
