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
import org.openqa.selenium.WebElement as WebElement

List<String> product = []

List<String> sortedProduct = []

WebUI.callTestCase(findTestCase('BuildingBlock/Login_Logout/Login'), [('username') : username, ('password') : password], 
    FailureHandling.STOP_ON_FAILURE)

'Select sorted method "By Name / By Price"'
switch (method) {
    case 'Name':
		'Take all product from web'
        List<String> currentProduct = WebUI.findWebElements(findTestObject('Swag Labs/MainPage/text_allProductName'), 10)

        for (WebElement item : currentProduct) {
            product.add(item.getText())
        }
        
		'Sort product by choosing from dropdown'
        WebUI.selectOptionByLabel(findTestObject('Swag Labs/MainPage/dropdown_sortDropdown'), sortBy, false)
		
		'Take all product after sorted'
        List<String> sortedProductElements = WebUI.findWebElements(findTestObject('Swag Labs/MainPage/text_allProductName'), 
            10)
		
		'Add product to a list'
        for (WebElement item : sortedProductElements) {
            sortedProduct.add(item.getText())
        }
        
		'Compare that product is sorted correctly by sorted the default product by name and compare with the sorted one'
        switch (sortBy) {
            case 'Name (A to Z)':
                assert product.sort().equals(sortedProduct) : FailureHandling.STOP_ON_FAILURE
                break
            case 'Name (Z to A)':
                assert product.sort{a, b -> b <=> a}.equals(sortedProduct) : FailureHandling.STOP_ON_FAILURE
                break
        }
        break
		
    case 'Price':
		'Take all product price from web'
        List<String> currentProduct = WebUI.findWebElements(findTestObject('Swag Labs/MainPage/text_productPrice'), 10)

        for (WebElement item : currentProduct) {
            product.add(item.getText())
        }
        
		'Sort product by choosing from dropdown'
        WebUI.selectOptionByLabel(findTestObject('Swag Labs/MainPage/dropdown_sortDropdown'), sortBy, false)
		
		'Take all product price after sorted'
        List<String> sortedProductElements = WebUI.findWebElements(findTestObject('Swag Labs/MainPage/text_productPrice'), 
            10)
		'Add product price to a list'
        for (WebElement item : sortedProductElements) {
            sortedProduct.add(item.getText())
        }
        
		'Compare that product is sorted correctly by sorted the default product by price and compare with the sorted one '
        switch (sortBy) {
            case 'Price (low to high)':
                assert product.collect{ it.replaceAll('\\$', '') as Float}.sort().equals(sortedProduct.collect{ it.replaceAll('\\$', '') as Float}) : FailureHandling.STOP_ON_FAILURE
                break
            case 'Price (high to low)':
                assert product.collect{ it.replaceAll('\\$', '') as Float}.sort{a, b ->  b <=> a}.equals(sortedProduct.collect{ it.replaceAll('\\$', '') as Float}) : FailureHandling.STOP_ON_FAILURE
                break
        }
        break
}

WebUI.callTestCase(findTestCase('BuildingBlock/Login_Logout/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

