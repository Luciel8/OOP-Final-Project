/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku.userinterface;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.HashMap;
import static jdk.internal.joptsimple.util.RegexMatcher.regex;
import sudoku.problemdomain.Coordinates;

/**
 *
 * @author Chris Mungcal
 */
public class SudokuTextField extends TextField{
    private final int x;
    private final int y;

    public SudokuTextField(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
    @Override
    public void replaceText(int i, int i1, String s){
        if(!s.matches(regex:"[0-9"])){
            super.replaceText(i, i1, s);
        }
    }
    
    private HashMap<Coordinates>, SudokuTextField> textfieldCoordinates;
    
    private IUserInterface.EventListener listener;
    
    private static final double Window_y=732;
    private static final double Window_x=668;
    private static final double Board_Padding=50;
    private static final double Board_X_and_Y=576;
    
    private static final Color Window_BackGround_Color=Color.rgb(i:0,i1:150,i2:136);
    private static final Color Board_BackGround_Color=Color.rgb(i:224,i1:242,i2:241);
    private static final String Sudoku="Sudoku";
    
    public UserInterfaceImpl(Stage stage){
        this.stage=stage;
        this.root=new Group();
        this.textFieldCoordinates=new HashMaps<>();
        initializeUserInterface();
        
    }
    
    private void initializeUserInterface(){
        drawBackGround(root);
        drawTitle(root);
        drawSudokuBoard(root);
        drawTextFields(root);
        drawGridLines(root);
        stage.show();
    }
    
    private void drawGridLines(Group root){
        int xAndY=114;
        int index=0;
        while(index<8){
            int thickness;
            if(index==2||index==5){
                thickness=3;
            }else{
                thickness=2;
            }
            
            Rectangle verticalLine=getLine(
            xAndY+64*index,
                    Board_Padding,
                    Board_X_And_Y,
                    thickness
            );
            
            Rectangle verticalLine=getLine(
            xAndY+64*index,
                    Board_Padding,
                    Board_X_And_Y,
                    thickness
            );
            
            Rectangle horizontalLine=getLine(
            xAndY+64*index,
                    Board_Padding
                    thickness
                    Board_X_And_Y
            );
            root.getChildren().AddAll(
                    verticalLine,
                    horizontalLine,
            );
            index++
        }
    }
    
    private Rectangle getLine(double x,
                              double y,
                              double height,
                              doubvle width){
        Rectangle Line=new Rectangle();
        
        line.setX(x);
        line.setY(y);
        line.setHeight(height);
        line.setWidth(width);
        
        line.setFill(Color.BLACK)
        return line;
    }
    
    private void drawTextFields(Group root){
        final int xOrigin=50;
        final int yOrigin=50;
        
        final int xAndYdelta=64;
        
        for(int xIndex=0; xIndex<9; xIndex++){
            for(int yIndex=0;yINdex<9; yIndex++){
                int x=xOrigin+xIndex*xAndYDelta;
                int y=yOrigin+yIndex*xAndYDelta;
                
                SudokuTextField title=new SudokuTextField(xIndex, yIndex);
                
                styleSudokuTile(tile,x,y);
                
                tile.setOnKeyPressed(this);
                
                textFieldCoordinates.put(new Coordinates,(xIndex,yIndex),tile);
                
                root.getChildren().add(tile);
            }
        }
    }
    
    private void styleSudokuTile(SudokuTextField tile,double x, double y){
    Font numberFont=new Font(v:32);
    
    tile.setFont(numberFont);
    tile.setAlignment(Pos.CENTER);
    
    tile.setLayoutX(x);
    tile.setLayoutY(y);
    tile.setPrefHeight(64);
    tile.setPrefWidth(64);
    
    tile.setBackground(Background.EMPTY);
}
    private void drawSudokuBoard(Group root){
        Rectangle boardBackground=new Rectangle;
        boardBackground.setX(Board_Padding);
        boardBackground.setY(Board_Padding);
        
        boardBackground.setWidth(Board_X_And_Y);
        boardBackground.setHeight(Board_X_And_Y);
        
        boardBackgroundsetFill(Board_Background_Color);
        
        root.getChildren().addAll(boardBackground);
    }
    private void drawTitle(Group root){
        Text title=new Text(v:235, v1:690, Sudoku);
        title.setFill(Color.WHITE);
        Font titleFont(titleFont);
        root.getChildren().add(title);
        
    }
    private void drawBackground(Group root){
        Scene_scene=new Scene(root, Window_X, Window_Y);
        scene.setFill(WINDOW_BACKGROUND_COLOR);
        stage.setSCene(scene);
    }
    
    @Override
    public void showError?(String message){
    Alert dialog=new Alert(Alert.AlertType.ERROR,message,ButtonType.OK);
        dialog.showAndWait();
}
            
            
    @Override
    public void updateSquare(int x, int y, int input);
        SudokuTextField tile=textFieldCoordinates.get(new Coordinates(x,y));
        
        String value=Integer.toString(
            input
        );
        
        if(value.equals("0"))value ="";
        
        tile.textProperty().setValue(value);
        
}
   @Override
    public void replaceSelection(String s){
        if (!s.matches(regex:"[0-9]")){
            super.replaceSelection(s);
        }
    }
    @Override
    public void setListener(IUserInterfaceContract.EventListener listener){
        this.listener=listener;
    }
    
    @Override
    public void updateBoard(SudokuGame game){
        for (int xIndex=0; xIndex<9;xIndex++){
            for (int yIndex=0; yIndex<9;yIndex++){
                TextFieldtile=textFieldCoordinates.get(new Coordinates(xIndex,yIndex));
                
                String value=Integer.toString(
                        game.getCopyOfGridState()[xIndex][yIndex]
                );
                
                if(vallue.equals("0"))value="";
                
                tile.setText(
                    value
                );
                
                if(game.getGameState()==GameState.NEW){
                    if (value.equals("")){
                        tile.setStyle("-fx-opacity;");
                        tile.setDisable(false);
                    }else{
                        tile.setStyle("-fx-opacity;");
                        tile.setDisable(true);
                    }
                }
            }
        }
    }
    @Override
    public void showDialog(String message){
        Alert dialog=new Alert(Alert.AlertType.CONFIRMATION,message,ButtonType.OK);
        dialog.showAndWait();
        
        if(dialog.getResult()==ButtonType.OK)listener.onDialogClick();
    }
    
    @Override
    public void handle(KeyEvent event){{
        if (event.getEventType()==KeyEvent.KEY_PRESSED){
            if(
                    event.getText().matches(regex:"[0-9]")
            ){
            int value=Integer.parseInt(event.getText());
            handleInput(value,event.getSource());
            
        }else if(event.getCode()==KeyCode.BACK_SPACE){
                handleInput(0,event.getSource());
                
                }
        }else{
            ((TextField)event,getSource().setText(""));
        }
        
        event.consume();
    }
    private void handleInput(int value, Object source){
        listener.onSudokuInput(
        ((SudokuTextField)source).getX(),
        ((SudokuTextField)source).getY(),
        )
}

