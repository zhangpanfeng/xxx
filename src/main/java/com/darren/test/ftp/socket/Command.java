package com.darren.test.ftp.socket;

public enum Command {
    // 输入用户名
    USER,
    // 输入密码
    PASS,
    // 切换被动模式
    PASV,
    // 上传文件
    STOR,
    // 切换上传目录
    CWD,
    // 列出文件列表
    LIST,
    // 退出
    QUIT,
    // 下载
    RETR;

}
