package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.CommonUtils;
import utils.WaitUtils;

public class UserMenuPage extends BasePage {

	public UserMenuPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "userNavLabel")
	public WebElement userMenu;

	@FindBy(xpath = "//div[@id='userNav-menuItems']/a")
	public List<WebElement> userMenuOptions;

	@FindBy(xpath = "//a[@title='My Profile']")
	public WebElement myProfile;

	@FindBy(id = "userNav-menuItems/a[2]")
	public WebElement mySettings;

	@FindBy(id = "userNav-menuItems/a[3]")
	public WebElement developersConsole;

	@FindBy(id = "userNav-menuItems/a[4]")
	public WebElement switchToLightningExperience;

	@FindBy(id = "userNav-menuItems/a[4]")
	public WebElement logout;

	// My profile
	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']")
	public WebElement editContactButton;

	@FindBy(xpath = "//div/h2[@id='contactInfoTitle']")
	public WebElement editProfilePopupwindow;

	@FindBy(id = "aboutTab")
	public WebElement aboutTab;

	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement aboutTabLastName;

	@FindBy(xpath = "//*[@value='Save All']")
	public WebElement saveAllButton;

	@FindBy(xpath = "//*[@id='tailBreadcrumbNode']")
	public WebElement userProfilePageNameDisplay;

	// Postlink
	@FindBy(css = "#publishereditablearea")
	public WebElement postLink;

	@FindBy(xpath = "/html/body")
	public WebElement postTextArea;

	@FindBy(xpath = "//input[@id='publishersharebutton']")
	public WebElement shareButton;

	// filelink

	@FindBy(xpath = "//*[@id='publisherAttachContentPost']")
	public WebElement filelink;

	@FindBy(xpath = "//a[@id='publisherAttachContentPost']/span[1]")
	public WebElement contentpost;

	@FindBy(css = "#chatterUploadFileAction")
	public WebElement Uploadfile;

	@FindBy(css = "#chatterFile")
	public WebElement Fileopen;

	@FindBy(css = "#publishersharebutton")
	public WebElement publish;

	@FindBy(xpath = "//input[@value='Cancel Upload']")
	public WebElement cancelUpload;

	@FindBy(id = "uploadLink")
	public WebElement updateButton;
	// Photo link

	@FindBy(xpath = "//*[@id=\"publisherAttachLinkPost\"]/span[1]")
	public WebElement photolink;

	@FindBy(id = "j_id0:uploadFileForm:uploadInputFile")
	public WebElement uploadphoto;

	@FindBy(name = "j_id0:uploadFileForm:uploadBtn")
	public WebElement uploadbutton;

	@FindBy(id = "publishersharebutton")
	public WebElement photosharebutton;

	@FindBy(id = "uploadPhotoContentId")
	public WebElement photoUploadIframe;

	@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadBtn']")
	public WebElement photoSaveButton;

	@FindBy(xpath = "//input[@id='j_id0:j_id7:save']")
	public WebElement photoSaveButton2;
	// My Settings
	// personallink

	@FindBy(xpath = "//*[@id=\'PersonalInfo_font\']")
	public WebElement personallink;

	@FindBy(xpath = "//*[@id=\"LoginHistory_font\"]")
	public WebElement loginHistorylink;

	@FindBy(xpath = "//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")
	public WebElement logindisplay;

	@FindBy(id = "contactInfoContentId")
	public WebElement iframeAboutTab;
	// Display&layoutlink

	@FindBy(xpath = "//*[@id=\"DisplayAndLayout_font\"]")
	public WebElement DisplayLayoutlink;

	@FindBy(id = "CustomizeTabs_font")
	public WebElement CustomizedTab;

	@FindBy(xpath = "//*[@id=\"p4\"]/option[9]")
	public WebElement customApp;

	@FindBy(xpath = "//*[@id=\"duel_select_0\"]/option[73]")
	public WebElement Availabletab;

	@FindBy(xpath = "//*[@id=\"duel_select_0_right\"]/img")
	public WebElement Add;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement save;

	@FindBy(id = "tabBar")
	public WebElement tabList;

	// Emaillink

	@FindBy(xpath = "//*[@id=\"EmailSetup_font\"]")
	public WebElement Emaillink;

	@FindBy(id = "EmailSettings_font")
	public WebElement MyEmailSettings;

	@FindBy(id = "sender_name")
	public WebElement Emailname;

	@FindBy(xpath = "//*[@id=\"sender_email\"]")
	public WebElement Emailaddress;

	@FindBy(xpath = "//*[@id=\"useremailSection\"]/table/tbody/tr[7]/td[2]/div")
	public WebElement BCCradiobutton;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement Saveonemail;

	// Calendar and Remainders
	@FindBy(id = "CalendarAndReminders_font")
	public WebElement CalendarAndReminders;

	@FindBy(xpath = "//*[@id=\"Reminders_font\"]")
	public WebElement ActivityRemainder;

	@FindBy(id = "testbtn")
	public WebElement OpenaTestRemainder;

	@FindBy(xpath = "//*[@id=\"summary\"]")
	public WebElement SampleEventPopup;

	@FindBy(css = "#displayBadge")
	public WebElement moderatorButton;

	@FindBy(id = "profileTab_sfdc.ProfilePlatformFeed")
	public WebElement profilePage;

	@FindBy(id = "contactTab")
	public WebElement contactTab;

	@FindBy(xpath = "//div[@class='cxfeeditem feeditem'][1]//p")
	public WebElement firstPostText;

	@FindBy(xpath = "(//*[@class='contentFileTitle'])[1]")
	public WebElement verifyFilePostElement;

	@FindBy(name = "j_id0:waitingForm")
	public WebElement spinnerIcon;

	@FindBy(id = "cropWaitingPage:croppingForm")
	public WebElement spinnerWhileCropping;

	@FindBy(id = "progressIcon")
	public WebElement fileUploadSpinner;

	public void selectUserMenu() {
		if (userMenu.isDisplayed()) {
			userMenu.click();
		} else {
			System.out.println("Element is not displayed");
		}
	}

	public boolean selectUserMenuOption(WebDriver driver, String option) {
		boolean isOptionVerified = false;
		logger.debug("Selecting an user menu option: "+option);
		WebElement userMenuOption = driver.findElement(By.xpath("//*[text()='" + option + "']"));
		if (WaitUtils.waitForElement(driver, userMenuOption)) {
			logger.debug(option+" was visible");
			userMenuOption.click();
			logger.debug(option+" was clicked");
			isOptionVerified = true;
		} else {
			System.out.println(option + " Option is not visible");
			logger.debug(option+" Could not be selected");
		}
		return isOptionVerified;
	}

	public void selectEditIcon(WebDriver driver) {
		if (WaitUtils.waitForElement(driver, editContactButton)) {
			editContactButton.click();
		} else {
			System.out.println("Edit contact button was not visible");
		}
	}

	public boolean verifyEditContactIframe(WebDriver driver) {
		boolean isIframeLoaded = false;
		if (WaitUtils.waitForElement(driver, iframeAboutTab)) {
			driver.switchTo().frame(iframeAboutTab);
			if (aboutTab.isDisplayed() && contactTab.isDisplayed()) {
				isIframeLoaded = true;
			} else {
				System.out.println("");
			}
		}
		return isIframeLoaded;
	}

	/**
	 * @param driver
	 * @param lastName
	 * @return
	 */
	public boolean verifyLastNameChangeInAboutTab(WebDriver driver, String lastName) {
		boolean isLastNameChanged = false;
		if (aboutTab.isDisplayed()) {
			aboutTab.click();
			aboutTabLastName.clear();
			aboutTabLastName.sendKeys(lastName);
			saveAllButton.click();
			driver.switchTo().parentFrame();
		}
		if (userProfilePageNameDisplay.isDisplayed()) {
			String actualName = userProfilePageNameDisplay.getText();
			if (actualName.contains(lastName)) {
				isLastNameChanged = true;
			} else {
				System.out.println("");
			}
		}
		return isLastNameChanged;
	}
	
	/**
	 * @param driver
	 * @param message
	 * @return
	 */
	public boolean verifyCreatePost(WebDriver driver, String message) {
		boolean isPostCreated = false;
		if(postLink.isDisplayed()) {
			postLink.click();
			driver.switchTo().frame(0);
			postTextArea.sendKeys(message);
			driver.switchTo().defaultContent();
			if(shareButton.isDisplayed()) {
				shareButton.click();
				isPostCreated = true;
			} else {
				
			}
		}
		return isPostCreated;
	}
	
	public boolean verifyFileUpload(WebDriver driver, String filePath) throws InterruptedException {
		boolean isFileUploadSuccess  = false;
		if(WaitUtils.waitForElement(driver, filelink)) {
			filelink.click();
			if(WaitUtils.waitForElement(driver, Uploadfile)) {
				Uploadfile.click();
			}
			if(WaitUtils.waitForElement(driver, Fileopen)) {
				Fileopen.sendKeys(filePath);
				shareButton.click();
				if(WaitUtils.waitForElementToDisappear(driver, cancelUpload)) {
					if(verifyFilePostElement.isDisplayed()) {
						isFileUploadSuccess = true;
					}
				}
			}
		}
		return isFileUploadSuccess;
	}
	
	public void clickOnUpdatePhotoButton(WebDriver driver) {
		CommonUtils.mouseHover(driver, moderatorButton);
		if(updateButton.isDisplayed()) {
			updateButton.click();
		}
	}
	
	public boolean verifyPhotoUpload(WebDriver driver, String imageFilePath) {
		boolean isPhotoUploadSuccess = false;
		this.clickOnUpdatePhotoButton(driver);
		driver.switchTo().frame(photoUploadIframe);
		if(WaitUtils.waitForElement(driver, uploadphoto)) {
			uploadphoto.sendKeys(imageFilePath);
			photoSaveButton.click();
		}
		if(WaitUtils.waitForElementToDisappear(driver, spinnerIcon) 
				&& WaitUtils.waitForElement(driver, photoSaveButton2)) {
			photoSaveButton2.click();
			if(WaitUtils.waitForElementToDisappear(driver, spinnerWhileCropping)) {
				isPhotoUploadSuccess = true;
			}
		}
		driver.switchTo().parentFrame();
		return isPhotoUploadSuccess;
	}
	
	

}
