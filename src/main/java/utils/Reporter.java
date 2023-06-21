package utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

@SuppressWarnings("deprecation")
public abstract class Reporter {
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTest node;
	
	
	public String testCaseName, testDescription, nodes, authors,category;
	public String excelFileName, currentDateTime;
	
	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void startReport() {
		DateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy HH-mm-ss");
		Date today = Calendar.getInstance().getTime();
		currentDateTime = dateformat.format(today);
		
		reporter = new ExtentHtmlReporter("./reports/result_"+currentDateTime+".html");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("UNIVERSITY OF CHICAGO - LET'S TALK");
		reporter.config().setReportName("UNIVERSITY OF CHICAGO - LET'S TALK - AUTOMATION EXECUTION REPORT");
		
		//reporter.setAppendExisting(false); 
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
    @BeforeClass
	public void report() throws IOException {
		test = extent.createTest(testCaseName, testDescription);
		test.assignAuthor(authors);
		//test.assignCategory(category);  
		test.assignCategory(nodes);  
		//test.assignCategory(nodes);
		//node.assignCategory(nodes);
	}
    
    public abstract long takeSnap();
    public void reportStep(String dec, String status,boolean bSnap ) {
    	MediaEntityModelProvider img = null;
		if(bSnap && !status.equalsIgnoreCase("INFO")){
		//if(bSnap==false && !status.equalsIgnoreCase("INFO")){
			long snapNumber = 100000L;
			snapNumber = takeSnap();
			try {
				img = MediaEntityBuilder.createScreenCaptureFromPath
						("./../reports/images/"+snapNumber+".jpg").build();
			} catch (IOException e) {
				
			}
		}
    	if(status.equalsIgnoreCase("pass")) {
    		//node.pass(dec,img);
    		test.pass(dec,img);
    	} else if(status.equalsIgnoreCase("fail")) {
    		test.fail(dec, img); 
    	}
    }
    
    public void reportStep(String desc, String status) {
    	if(status.equalsIgnoreCase("pass")) {
    		reportStep(desc, status, true);
    	}else if(status.equalsIgnoreCase("fail")) {
    		reportStep(desc, status, false);
    	}
		
	}

    
    @AfterSuite
    public void stopReport() {
    	extent.flush();
    }

}