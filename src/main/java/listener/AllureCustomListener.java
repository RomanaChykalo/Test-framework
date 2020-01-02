package listener;

import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.String.format;

@Log4j
public class AllureCustomListener extends TestListenerAdapter {
    private static final String CSV_FILE_PATH = "src/test/resources/user_cred.csv";
    private static final String LOG_FILE = "logs/log4j-Allure.log";

    /*@Attachment(value = "CSV Attachment", type = "text/csv")
    private static byte[] attachFileType_CSV() {
        try {
            return fileToBytes(CSV_FILE_PATH);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    *//*To Convert the File to Bytes*//*
    private static byte[] fileToBytes(String fileName) throws Exception {
        byte[] logText = null;
        try {
            Path path = Paths.get(fileName);
            logText = Files.readAllBytes(path);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return logText;
    }

    @Override
    public void onStart(ITestContext context) {
        log.info("-------=======  Test \"" + context.getStartDate().toString() + "\" started =======-------");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("-------======= Test \"" + context.getEndDate().toString() + "\" finished =======-------");
        clearAllureLogDirectory();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        appendLogToAllure();
        log.info(format("result : SUCCESS : %s", result.getMethod().getMethodName()));
        clearAllureLogDirectory();
        attachFileType_CSV();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("result : FAILURE " + result.getMethod().getMethodName().toUpperCase());
        log.info(Thread.currentThread().getName() + ": Test failed: " + result.getName());
        appendLogToAllure();
    }

    @Attachment(value = "Test logs", type = "text/html")
    private synchronized byte[] appendLogToAllure() {
        byte[] bytes = null;
        try {
            bytes = fileToBytes(LOG_FILE);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return bytes;
    }

    private synchronized void clearAllureLogDirectory() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bw = null;
        try {
            fileInputStream = new FileInputStream(LOG_FILE);
            fileOutputStream = new FileOutputStream(LOG_FILE);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            bw = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            while (bufferedReader.read() != -1) {
                bw.write("");
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info(result.getMethod().getMethodName() + "result : SKIPPED");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.info(" Test Failed But Within Success Percentage for " + result.getMethod().getMethodName());
    }*/
}
