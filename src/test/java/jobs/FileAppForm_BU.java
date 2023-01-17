package jobs;

import com.jcraft.jsch.*;
import elementsPage.Const;
import testData.ReadTestData;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

public class FileAppForm_BU {

    static String user = "qalos";
    static String pass = "P@ssw0rd";
    ReadTestData readTestData = new ReadTestData();
    public static String hit_job;
    static String getName = null;

    public void serverAkses() {
        String pthApprovalFile;
        String host;
        String e2e_host = "10.27.62.156";
        String uat_host = "10.27.62.157";

        String e2e_pathFile = "/cd/nasbdb/LOS_DEV/app-file/file-upload/";
        String uat_pathFile = "/cd/nasbdb/LOS_UAT/app-file/file-upload/";
        String hit_job = "cd /bdb/app/los-source/job-execute && ./npl-validation.sh && ./approval-proccess.sh";

        try {
            FileAppForm_BU.hit_job = hit_job;
            readTestData.testData();
            if (readTestData.environment.equals("E2E")) {
                pthApprovalFile = e2e_pathFile;
                host = e2e_host;

                System.out.println("HOST : " + host + ">>> Folder File : " + pthApprovalFile);
            } else {
                pthApprovalFile = uat_pathFile;
                host = uat_host;
                System.out.println("HOST : " + host + ">>> Folder File : " + pthApprovalFile);
            }

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");

            JSch jSch = new JSch();
            Session session = jSch.getSession(user, host);
            session.setPassword(pass);
            session.setConfig(config);
            session.connect();
            ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();
            System.out
                    .println("Session connected: " + session.isConnected());

            File folder = new File(Const.resultApprovalFile); //resultDataDummyFile
            File[] listOfFiles = folder.listFiles();


            // upload list file in local to server
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    System.out.println("File list in local machine ========== " + listOfFiles[i].getName());
                    if (listOfFiles[i].getName().contains("APPFILE")) {
                        getName = listOfFiles[i].getName();
                        channelSftp.put(Const.resultApprovalFile + getName, pthApprovalFile + listOfFiles[i].getName()); //resultDataDummyFile
                        if (readTestData.environment.equals("E2E")) {
                            channelSftp.chmod(747, e2e_pathFile + getName);
                        } else {
                            channelSftp.chmod(747, uat_pathFile + getName);
                        }
                    }
                }
            }
            System.out
                    .println("====================================================");
            System.out
                    .println("File list in server machine : " + getName);
            System.out.
                    println("================Consume Data Success=================");
            execJob(session);
            channelSftp.disconnect();
            session.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void execJob(Session session) {
        try {
            Channel channel = session.openChannel("exec");
            System.out.println("");
            System.out
                    .println("======================Run Job=======================");

//            ((ChannelExec) channel).setCommand(comndChmod);
//            ((ChannelExec) channel).setCommand("chmod 770 "+ getName);
//            System.out.println("run command :" + comndChmod + getName);
            System.out.println("");

            ((ChannelExec) channel).setCommand(hit_job);
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);

            InputStream in = channel.getInputStream();
            channel.connect();
            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) break;
                    System.out.print(new String(tmp, 0, i));
                }
                if (channel.isClosed()) {
                    System.out.println("exit-status: " + channel.getExitStatus());
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception ee) {
                }
            }
            channel.disconnect();
            session.disconnect();
            System.out.println("DONE");
            System.out
                    .println("===================Run Job Success==================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
