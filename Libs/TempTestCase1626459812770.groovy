import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.contribution.WebUiDriverCleaner
import com.kms.katalon.core.mobile.contribution.MobileDriverCleaner
import com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner
import com.kms.katalon.core.windows.keyword.contribution.WindowsDriverCleaner
import com.kms.katalon.core.testng.keyword.internal.TestNGDriverCleaner


DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.windows.keyword.contribution.WindowsDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.testng.keyword.internal.TestNGDriverCleaner())


RunConfiguration.setExecutionSettingFile('C:\\Users\\lollal\\AppData\\Local\\Temp\\1\\Katalon\\Test Cases\\Canine_TestCases\\StudyCombinations\\Laxmi_Regression01\\TC20_Canine_StudyUBC-Breed_Diagnosis_PrimDiseaseSite_RespToTreatmt\\20210716_142332\\execution.properties')

TestCaseMain.beforeStart()

        TestCaseMain.runTestCase('Test Cases/Canine_TestCases/StudyCombinations/Laxmi_Regression01/TC20_Canine_StudyUBC-Breed_Diagnosis_PrimDiseaseSite_RespToTreatmt', new TestCaseBinding('Test Cases/Canine_TestCases/StudyCombinations/Laxmi_Regression01/TC20_Canine_StudyUBC-Breed_Diagnosis_PrimDiseaseSite_RespToTreatmt',[:]), FailureHandling.STOP_ON_FAILURE , true, true)
    
