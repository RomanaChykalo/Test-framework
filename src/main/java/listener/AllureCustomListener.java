package listener;

import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j;
import org.apache.cxf.helpers.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static java.lang.String.format;

@Log4j
public class AllureCustomListener extends TestListenerAdapter {
    private File logFile = new File("logs/log4j-Allure.log");

    @Override
    public void onStart(ITestContext context) {
        log.info("-------=======  Test \"" + context.getStartDate().toString() + "\" started =======-------");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("-------======= Test \"" + context.getEndDate().toString() + "\" finished =======-------");

        try {
            FileWriter writer = new FileWriter(logFile);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info(format("result : SUCCESS : %s", result.getMethod().getMethodName()));

    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("result : FAILURE " + result.getMethod().getMethodName().toUpperCase());
        log.info(Thread.currentThread().getName()+": Test failed: " + result.getName());
        if(Objects.nonNull(result.getThrowable())){
            result.getThrowable().printStackTrace();
        }
        appendLogToAllure();
    }

    @Attachment(value = "Test logs", type = "text/html")
    private byte[] appendLogToAllure() {
        try {
            log.info("Start read logs...........");
            Path path = Paths.get("test-output/log4j-Allure.log");
            return Files.readAllBytes(path);
        } catch (IOException e) {
            log.error("Can't read logs to Allure Report");
        }
        return null;
    }
/*

    @Attachment(value = "screenshot", type = "image/png")
    private byte[] getScreenshot() {
        log.info("Screenshot have been added to Allure Report.");
        return ((TakesScreenshot) DriverLoader.getDriver()).getScreenshotAs(OutputType.BYTES);
    }*/

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info(result.getMethod().getMethodName() + "result : SKIPPED");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.info("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName());
    }
}
