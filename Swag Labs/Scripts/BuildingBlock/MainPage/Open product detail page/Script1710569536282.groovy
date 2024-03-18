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

WebUI.verifyElementPresent(findTestObject('Swag Labs/MainPage/text_productName', [('product') : productName]), 3)

switch (method) {
    case 'name':
        WebUI.click(findTestObject('Swag Labs/MainPage/text_productName', [('product') : productName]))
		break
		
    case 'image':
        WebUI.click(findTestObject('Swag Labs/MainPage/img_productImage', [('product') : productName]))
		break
		
	default:
		WebUI.click(findTestObject('Swag Labs/MainPage/text_productName', [('product') : productName]))
		break
}

WebUI.verifyElementPresent(findTestObject('Swag Labs/DetailPage/object_inventoryDetailPage'), 3)

