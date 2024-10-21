package tests;

import dto.BoardDTO;
import dto.UserDTO;
import manager.ApplicationManager;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.PersonalBoardPage;

import java.util.Random;

public class BoardsTests extends ApplicationManager {


    UserDTO user = UserDTO.builder()
            .email("loyolya@gmail.com")
            .password("Beauty19812010$").
            build();
    BoardsPage boardsPage = new BoardsPage(getDriver());

    @BeforeMethod
    public void loginBeforeBoards(){
        HomePage homePage = new HomePage(getDriver());
        boardsPage = homePage.clickBtnLogin()
                .typeEmail(user)
                .typePassword(user);
    }

    @Test
    public void createBoardPositive(){
        //int i = (int) ((System.currentTimeMillis()/1000)%3600);
        int i = new Random().nextInt(1000) + 1000;

        BoardDTO board = BoardDTO.builder()
                .boardTitle("QA44-"+i)
                .build();
        //HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(
                /*homePage.clickBtnLogin()
                .typeEmail(user)
                .typePassword(user)*/
                boardsPage.typeBoardTitle(board)
                .clickBtnCreateSubmitPositive()
                .isTextInElementPresent_nameBoard(board.getBoardTitle()));
    }

    @Test
    public void createBoardNegative(){

        BoardDTO board = BoardDTO.builder()
                .boardTitle("    ")
                .build();

        Assert.assertFalse(boardsPage.typeBoardTitle(board)
                .clickBtnCreateSubmitNegative()
                .isElementClickable_btnCreateSubmit(), "element is clickable");
    }

    @Test
    public void deleteBoardPositiveTest(BoardDTO board){
        /*int i = new Random().nextInt(1000) + 1000;

        BoardDTO board = BoardDTO.builder()
                .boardTitle("QA44-"+i)
                .build();*/

        PersonalBoardPage personalBoardPage = boardsPage
                .typeBoardTitle(board)
                .clickBtnCreateSubmitPositive();

        if(personalBoardPage.isTextInElementPresent_nameBoard(board.getBoardTitle())){
            Assert.assertTrue(personalBoardPage.deleteBoard(board).isTextPopUpPresent());
        }else {
            Assert.fail("board isn't create");
        }
        ;

    }
}
