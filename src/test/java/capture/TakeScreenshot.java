package capture;

import badanUsaha.LibUtils;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import elementsPage.Const;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import testData.ReadTestData;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeScreenshot {
    String pthFileImageName = Const.pthFileImage;
    ImageExcel imageExcel = new ImageExcel();
    ReadTestData readTestData = new ReadTestData();
    public static String screenshotAbsolute;

    public void capture(WebDriver driver) {
        readTestData.testData();
        try {
            String pattern = Const.pPattern;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String formattedToday = simpleDateFormat.format(new Date());

            String pictName     = readTestData.tagName + formattedToday.substring(0, 6) + "/" + "" + formattedToday + Const.extPict;
            String folderReport = "test-output\\Selenix-Spark";
            String fullPathName = folderReport + "/" + pictName;
            Thread.sleep(Const.delay);
            File src_screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File Dest = new File(fullPathName);
            String screenshotAbsolute = Dest.getAbsolutePath();

            FileUtils.copyFile(src_screenshot, Dest);
            byte[] imgBytes = IOUtils.toByteArray(new FileInputStream(fullPathName));

            LibUtils.capture.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(pictName).build());
//            LibUtils.capture.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromBase64String(Base64.getEncoder().encodeToString(imgBytes)).build());

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    public void copyCapture() throws IOException {
        File dir = new File("test-output\\Selenix-Spark");
        File[] files = dir.listFiles();
//        if (files == null || files.length == 0) {
//            return null;
//        }

        File lastModifiedFile = files[0];
        String s = lastModifiedFile.toString();
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];

            }
        }
//        return lastModifiedFile;


    }
    public void captureRobot(int i, String pictName, String sheet) {

        try {
            Robot robotObject = new Robot();
            Rectangle screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage tmp = robotObject.createScreenCapture(screenSize);

            String pattern = Const.pPattern;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String formattedToday = simpleDateFormat.format(new Date());

            String path = pthFileImageName + formattedToday + Const.extPict;
            ImageIO.write(tmp,"png", new File(path));
            imageExcel.insertImages(path, i, pictName, sheet);


        }catch (Exception e){
            e.getCause();
        }
    }


    public static void main(String[] args) {
        TakeScreenshot takeScreenshot = new TakeScreenshot();
        takeScreenshot.captureRobot(5,"test","Capture Approval Badan Usaha");
    }
}
