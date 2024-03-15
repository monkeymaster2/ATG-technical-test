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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Click menu button'
WebUI.click(findTestObject('Swag Labs/MainPage/btn_Menubutton'))

'Wait for menu board is shown'
WebUI.waitForElementVisible(findTestObject('Swag Labs/MainPage/Menu/object_Menu'), 0)

'Verify menu board is shown'
WebUI.verifyElementPresent(findTestObject('Swag Labs/MainPage/Menu/object_Menu'), 0)

'Click logout'
WebUI.click(findTestObject('Swag Labs/MainPage/Menu/btn_Logoutbutton'))

'Verify logout successfully by checking login logo'
WebUI.waitForElementVisible(findTestObject('Swag Labs/LoginPage/logo_Loginlogo'), 0)

WebUI.verifyElementPresent(findTestObject('Swag Labs/LoginPage/logo_Loginlogo'), 0)

'Close browser'
WebUI.closeBrowser()