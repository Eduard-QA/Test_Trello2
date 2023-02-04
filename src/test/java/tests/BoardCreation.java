package tests;

import model.Board;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase {

    @Test
    public void boardCreation1() {

        Board board = Board.builder().title("qa36").build();
        logger.info("Test board creation 1--"+board.getTitle());

        app.getBoard().initBoardCreation();
        app.getBoard().fillInBoardCreationForm(board);
        app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().isCreated();
        logger.info("Board is created--");

        Assert.assertTrue(app.getBoard().isCreated());

        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();

    }

    @Test
    public void boardCreation2() {
        Board board = Board.builder().title("qa36").build();

        int boardCountBeforeCreation = app.getBoard().getBoardCount();
        app.getBoard().initBoardCreation();
        app.getBoard().fillInBoardCreationForm(board);
        app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();
        int boardCountAfterCreation = app.getBoard().getBoardCount();
        //app.getBoard().pause(2000);
        //Assert.assertEquals(boardCountAfterCreation, boardCountBeforeCreation + 1 );
        //Assert.assertEquals(boardCountAfterCreation,boardCountBeforeCreation+1);


    }

    @Test
    public void boardCreation3() {
        Board board = Board.builder().title("qa36").build();

        int boardCountBeforeCreation = app.getBoard().getBoardCount();
        app.getBoard().initBoardCreation();
        app.getBoard().chooseBackground();
        app.getBoard().fillInBoardCreationForm(board);
        app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();
        int boardCountAfterCreation = app.getBoard().getBoardCount();
    }
}