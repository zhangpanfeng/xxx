package com.darren.test.jsch;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.darren.test.util.StringUtil;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.jcraft.jsch.SftpProgressMonitor;

public class JSCHUtil {

    private static final String HOST = "localhost";
    private static final int PORT = 22;

    private ChannelSftp channel;
    private Session session;

    public ChannelSftp getChannel(Map<String, String> option, Properties config, int timeout) throws JSchException {
        if (option == null) {
            return null;
        }
        String host = StringUtil.isEmpty(option.get("host")) ? HOST : option.get("host");
        int port = StringUtil.isEmpty(option.get("port")) ? PORT : Integer.parseInt(option.get("port"));
        String userName = option.get("username");
        String password = option.get("password");
        // 创建JSch对象
        JSch jsch = new JSch();
        // 根据用户名，主机ip，端口获取一个Session对象
        session = jsch.getSession(userName, host, port);
        // 设置密码
        session.setPassword(password);

        if (config.getProperty("StrictHostKeyChecking") == null) {
            config.put("StrictHostKeyChecking", "no");
        }
        // 为Session对象设置properties
        session.setConfig(config);
        // 设置timeout时间
        session.setTimeout(timeout);
        // 通过Session建立链接
        session.connect();

        // 打开SFTP通道
        channel = (ChannelSftp) session.openChannel("sftp");
        // 建立SFTP通道的连接
        channel.connect();
        return channel;
    }

    public void upload(Map<String, String> files, SftpProgressMonitor monitor, int writeMode) throws SftpException {
        Set<String> keySet = files.keySet();
        for (String key : keySet) {
            channel.put(key, files.get(key), monitor, writeMode);
        }
    }

    public void closeChannel() {
        if (channel != null) {
            channel.quit();
            channel.disconnect();
        }

        if (session != null) {
            session.disconnect();
        }
    }
}
