----------------About the app------------------
@desc		A mHealth Apps aiming at the improvement of undergraduates' hobbies.
@environment 	Eclipse + android environment (Can refer to the URL for the guidance of installing of android under eclipse: http://www.admin10000.com/document/5334.html ))
@execute 	Run in the eclipse.



-----------------软件使用指南-------------------
@date 2015/07/25
@author deryow

由于本软件使用的是本地的服务器，并且是用IP来识别服务器的，因此，需要在进行软件安装之前进行一些额外的配置。
敬请谅解。

以下是简单的使用手机和电脑连接的操作过程。
**前置条件：1. windows操作系统  2. Eclipse（其他工具未曾尝试）


1. 手机开热点给电脑连接。
2. 电脑连接手机热点后，通过cmd的ipconfig命令，或得“无线局域网适配器 WLAN:”对应的IP地址。
3. 然后，将该IP地址赋值给“CampusRun06011/src/com.example.campusrun1_0/AppointActivity.java”目录下的
   “curIp”变量。保存。
4. 然后，用数据线与电脑相连，选择运行方式为“Android Application”一键安装。
   (同时，在“CampusRun0611/bin”目录下，会产生软件的安装包。
5. 请尽情玩弄Campus Run.(请保持电脑与手机热点的连接状态）

PS：附带的安装包使用的IP是“192.168.43.7”