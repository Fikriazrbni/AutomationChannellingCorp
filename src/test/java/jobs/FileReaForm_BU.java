package jobs;

import com.jcraft.jsch.*;
import elementsPage.Const;
import testData.ReadTestData;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

public class FileReaForm_BU {

    static String user        = "qalos";//qalos applos
    static String pass        = "P@ssw0rd";
    ReadTestData readTestData = new ReadTestData();
    static String getName     = null;
    static String getName2    = null;
    public static String hit_job;

    public void serverAkses() {
        String pthBUFile;
        String pthPengurusFile;
        String host;
        String e2e_host              = "10.27.62.156";
        String uat_host              = "10.27.62.157";

        String e2e_pathFile_BU       = "/cd/nasbdb/LOS_DEV/realisasi-file/file-upload-realization/";
        String uat_pathFile_BU       = "/cd/nasbdb/LOS_UAT/realisasi-file/file-upload-realization/";

        String e2e_pathFile_Pengurus = "/cd/nasbdb/LOS_DEV/realisasi-file/realizationOtherFile/";
        String uat_pathFile_Pengurus = "/cd/nasbdb/LOS_UAT/realisasi-file/realizationOtherFile/";

        String hit_job = "cd /bdb/app/los-source/job-execute && ./realization-process.sh";

        try {
            FileReaForm_BU.hit_job = hit_job;
            readTestData.testData();
            if (readTestData.environment.equals("E2E")) {
                pthBUFile       = e2e_pathFile_BU;
                pthPengurusFile = e2e_pathFile_Pengurus;
                host            = e2e_host;

                System.out.println("HOST : " + host + ">>> Folder File : " + pthBUFile);
                System.out.println("HOST : " + host + ">>> Folder File : " + pthPengurusFile);
            } else {
                pthBUFile       = uat_pathFile_BU;
                pthPengurusFile = uat_pathFile_Pengurus;
                host            = uat_host;
                System.out.println("HOST : " + host + ">>> Folder File : " + pthBUFile);
                System.out.println("HOST : " + host + ">>> Folder File : " + pthPengurusFile);
            }

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");

            JSch jSch       = new JSch();
            Session session = jSch.getSession(user, host);
            session.setPassword(pass);
            session.setConfig(config);
            session.connect();
            ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();
            System.out.println("Session connected: " + session.isConnected());

            File folder     = new File(Const.resultApprovalFile); //resultDataDummyFile
            File[] listOfFiles = folder.listFiles();


            // upload list file in local to server
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    System.out.println("File list in local machine ========== " + listOfFiles[i].getName());
                    if (listOfFiles[i].getName().contains("REAFILE")) {
                        getName = listOfFiles[i].getName();
                        channelSftp.put(Const.resultApprovalFile + getName, pthBUFile + listOfFiles[i].getName());
                        if (readTestData.environment.equals("E2E")) {
                            channelSftp.chmod(747, e2e_pathFile_BU + getName);
                        } else {
                            channelSftp.chmod(747, uat_pathFile_BU + getName);
                        }
                    } else if (listOfFiles[i].getName().contains("PENGURUS")) {
                        getName2 = listOfFiles[i].getName();
                        channelSftp.put(Const.resultApprovalFile + getName2, pthPengurusFile + listOfFiles[i].getName());
                        if (readTestData.environment.equals("E2E")) {
                            channelSftp.chmod(747, e2e_pathFile_Pengurus + getName2);
                        } else {
                            channelSftp.chmod(747, uat_pathFile_Pengurus + getName2);
                        }
                    }
                }
            }
            System.out.println("====================================================");
            System.out.println("File list in server machine Badan Usaha : " + getName);
            System.out.println("File list in server machine Pengurus    : " + getName2);
            System.out.println("================Consume Data Success=================");
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
            System.out.println("======================Run Job=======================");
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
            System.out.println("===================Run Job Success==================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
