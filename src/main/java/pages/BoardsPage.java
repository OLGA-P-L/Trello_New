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

    public BoardsPage typeBoardTitle(BoardDTO board){
        btnCreateBoard.click();
        inputBoardTitle.sendKeys(board.getBoardTitle());
        return this;
    }
    public PersonalBoardPage clickBtnCreateSubmitPositive(){
pause(5);
        btnCreateSubmit.click();
        return new PersonalBoardPage(driver);
    }

    public BoardsPage clickBtnCreateSubmitNegative(){
        btnCreateSubmit.click();
        return this;
    }
}
