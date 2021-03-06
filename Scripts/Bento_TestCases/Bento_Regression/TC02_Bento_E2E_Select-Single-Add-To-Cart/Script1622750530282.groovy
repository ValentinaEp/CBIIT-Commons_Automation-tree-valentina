import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import org.openqa.selenium.firefox.FirefoxBinary as FirefoxBinary
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions as FirefoxOptions
import org.openqa.selenium.support.ui.ExpectedConditions as ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait as WebDriverWait
import java.nio.file.Path as Path
import java.nio.file.Paths as Paths
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW

/*This test script:
 - Opens the browser of choice: Chrome, Firefox or Edge
 - Driver opened by Katalon is used in Selenium.
 - Takes the Query from input excel and fetches data from Neo4j database.
   Saves the results from neo4j and application in the same name mentioned in the input excel.
 - Clicks on the Cases button in the Navbar of ICDC's homepage.
 - Clicks on the Filter 'Breed' from left pane
 - Selects the specific check box from 'Breed' filter.
 - Reads the results displayed for the selected filter (from all the pages in UI) and saves in the excel mentioned in Input file
 - Reads Neo4j DB using the query from Input file and saves the data in the excel mentioned in Input file
 - Reads Neo4j excel and Webdata excel as lists and compares the data.
 */
WebUI.closeBrowser()

//WebUI.openBrowser('')
//WebUI.maximizeWindow()
//CustomKeywords.'ctdc.utilities.runtestcaseforKatalon.testSetup'('')

CustomKeywords.'ctdc.utilities.runtestcaseforKatalon.RunKatalon'('TC10_Bento_MultiFilter_Diagnosis-TumorSize-ERStatus-PRStatus-EndocrineTher-FileAssoc.xlsx')

WebUI.click(findTestObject('Bento/NavBar/Bento_Cases-Btn'))

//WebUI.click(findTestObject('Bento/Cases_page/Filter/FilterByCases_Facet'))

WebUI.waitForElementClickable(findTestObject('Bento/Cases_page/Filter/Diagnosis/DIAGNOSIS_Ddn'), 10)
CustomKeywords.'ctdc.utilities.runtestcaseforKatalon.clickTab'('Bento/Filter/Diagnosis/DIAGNOSIS_Ddn')
CustomKeywords.'ctdc.utilities.runtestcaseforKatalon.clickTab'('Object Repository/Bento/Filter/Diagnosis/TubularCarcinoma_Chkbx')
Thread.sleep(5000) //only if a wait is added, this step passes in headless browsers

WebUI.waitForElementClickable(findTestObject('Bento/Cases_page/Filter/TumorSize/TumorSize_Ddn'), 10)
CustomKeywords.'ctdc.utilities.runtestcaseforKatalon.clickTab'('Object Repository/Bento/Filter/TumorSize/TumorSize_Ddn')
CustomKeywords.'ctdc.utilities.runtestcaseforKatalon.clickTab'('Object Repository/Bento/Filter/TumorSize/3_to_4_Chkbx')
Thread.sleep(2000) //only if a wait is added, this step passes in headless browsers
 
WebUI.waitForElementClickable(findTestObject('Bento/Cases_page/Filter/ERStatus/ERStatus_Ddn'), 10)
CustomKeywords.'ctdc.utilities.runtestcaseforKatalon.clickTab'('Object Repository/Bento/Filter/ERStatus/ERStatus_Ddn')
CustomKeywords.'ctdc.utilities.runtestcaseforKatalon.clickTab'('Object Repository/Bento/Filter/ERStatus/Negative_Chkbx')
Thread.sleep(2000) //only if a wait is added, this step passes in headless browsers

WebUI.waitForElementClickable(findTestObject('Bento/Cases_page/Filter/PRStatus/PRStatus_Ddn'), 10)
CustomKeywords.'ctdc.utilities.runtestcaseforKatalon.clickTab'('Object Repository/Bento/Filter/PRStatus/PRStatus_Ddn')
CustomKeywords.'ctdc.utilities.runtestcaseforKatalon.clickTab'('Object Repository/Bento/Filter/PRStatus/Positive_Chkbx')
Thread.sleep(2000) //only if a wait is added, this step passes in headless browsers

WebUI.waitForElementClickable(findTestObject('Bento/Cases_page/Filter/EndocrineTherapy/ENDOCRINETHERAPY_Ddn'), 10)
CustomKeywords.'ctdc.utilities.runtestcaseforKatalon.clickTab'('Object Repository/Bento/Filter/EndocrineTherapy/ENDOCRINETHERAPY_Ddn')
CustomKeywords.'ctdc.utilities.runtestcaseforKatalon.clickTab'('Object Repository/Bento/Filter/EndocrineTherapy/Other_Chkbx')
WebUI.waitForElementClickable(findTestObject('Bento/Cases_page/Filter/EndocrineTherapy/ENDOCRINETHERAPY_Ddn'), 10)
//clicking on the the drop down again, so that the following filters in Filter by Samples/Files is easy to click
CustomKeywords.'ctdc.utilities.runtestcaseforKatalon.clickTab'('Object Repository/Bento/Filter/EndocrineTherapy/ENDOCRINETHERAPY_Ddn')
Thread.sleep(3000) //only if a wait is added, this step passes in headless browsers

 
//clicking the Cases tab
WebUI.waitForElementPresent(findTestObject('Bento/Cases_page/BentoResults_Cases_Tab'), 5)
CustomKeywords.'ctdc.utilities.runtestcaseforKatalon.clickTab'('Bento/BentoResults_Cases_Tab')
WebUI.waitForElementPresent(findTestObject('Bento/Cases_page/Bento_CasesTable'), 5)
WebUI.maximizeWindow()

CustomKeywords.'ctdc.utilities.runtestcaseforKatalon.Select_case_checkbox'('BENTO-CASE-9065', 'one')
CustomKeywords.'ctdc.utilities.runtestcaseforKatalon.clickTab'('Object Repository/Bento/Bento_AddSelectedFiles_Btn')


WebUI.click(findTestObject('Bento/Cases_page/Bento_MyFilesCart_Btn'))


WebUI.maximizeWindow()
WebUI.click(findTestObject('Bento/FileCentricCart_page/Bento_DownloadManifest_Btn'))

