package pages;

import dto.BoardDTO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BoardsPage extends BasePage{
    public BoardsPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
    }
@FindBy(xpath = "//li[@data-testid='create-board-tile']")
    WebElement btnCreateBoard;

    @FindBy(xpath = "//input[@data-testid='create-board-title-input']")
    WebElement inputBoardTitle;

   @FindBy(xpath = "//button[@data-testid='create-board-submit-button']")
   WebElement btnCreateSubmit;

   /* @FindBy(xpath = "//*[text()='Create']")
    WebElement btnCreateSubmit;*/

    @FindBy(xpath = "//span[@class='QMKgZFIlTLiEJN']")
    WebElement popUpBoardDelete;

    public BoardsPage typeBoardTitle(BoardDTO board){
        btnCreateBoard.click();
        inputBoardTitle.sendKeys(board.getBoardTitle());
        return this;
    }
    public PersonalBoardPage clickBtnCreateSubmitPositive(){
pause(2000);
        btnCreateSubmit.click();
        return new PersonalBoardPage(driver);
    }

    public BoardsPage clickBtnCreateSubmitNegative(){
        btnCreateSubmit.click();
        return this;
    }

    public boolean isElementClickable_btnCreateSubmit(){
        return isElementClickable(btnCreateSubmit, 10);
    }

    public boolean isTextPopUpPresent(){
        return isTextInElementPresent(popUpBoardDelete, "Board deleted.", 5);
    }
}
