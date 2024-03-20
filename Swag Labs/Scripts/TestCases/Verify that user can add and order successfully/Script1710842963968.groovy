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

WebUI.callTestCase(findTestCase('BuildingBlock/Login_Logout/Login'), [('username') : username, ('password') : password], 
    FailureHandling.STOP_ON_FAILURE)

'Add product to cart'
WebUI.click(findTestObject('Swag Labs/MainPage/btn_priceBarButton', [('product') : productName, ('button') : 'Add to cart']))

'Verify product is added successfully and "Remove" button is shown'
WebUI.verifyElementPresent(findTestObject('Swag Labs/MainPage/btn_priceBarButton', [('product') : productName, ('button') : 'Remove']), 
    1)

'Open shopping cart'
WebUI.click(findTestObject('Swag Labs/MainPage/icon_shoppingCart'))

'Verify product is added to cart'
WebUI.verifyElementPresent(findTestObject('Swag Labs/ShoppingCartPage/text_itemName', [('product') : productName]), 2)

WebUI.click(findTestObject('Swag Labs/ShoppingCartPage/btn_checkOutButton'))

'Verify title Page is "Checkout: Your Information"'
WebUI.verifyElementPresent(findTestObject('Swag Labs/universal_titlePage', [('title') : 'Checkout: Your Information']), 
    2)

'Input firstname, lastname, postalcode'
WebUI.setText(findTestObject('Swag Labs/ShoppingCartPage/CheckOutInformationPage/input_firstName'), 'Vinh')

WebUI.setText(findTestObject('Swag Labs/ShoppingCartPage/CheckOutInformationPage/input_lastName'), 'Truong')

WebUI.setText(findTestObject('Swag Labs/ShoppingCartPage/CheckOutInformationPage/input_postalCode'), '70000')

WebUI.click(findTestObject('Swag Labs/ShoppingCartPage/CheckOutInformationPage/btn_continueButton'))

'Verify title Page is "Checkout: Your Information"'
WebUI.verifyElementPresent(findTestObject('Swag Labs/universal_titlePage', [('title') : 'Checkout: Overview']), 2)

'Verify product added is shown'
WebUI.verifyElementPresent(findTestObject('Swag Labs/universal_productName', [('product') : productName]), 2)

'Click finish'
WebUI.click(findTestObject('Swag Labs/ShoppingCartPage/CheckOutOverview/button_finishButton'))

WebUI.verifyElementPresent(findTestObject('Swag Labs/universal_titlePage', [('title') : 'Checkout: Complete!']), 2)

'Logout and close browser'
WebUI.callTestCase(findTestCase('BuildingBlock/Login_Logout/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

