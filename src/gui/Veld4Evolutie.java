package gui;


import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 *
 * @author Kenzo
 */
public class Veld4Evolutie extends VBox
{
    private int score=0;
    private final Label scoreLabel = new Label();;
    
    public Veld4Evolutie() 
    {
        Rectangle rectangle1 = new Rectangle(60, 60, Color.RED);
        Rectangle rectangle2 = new Rectangle(60, 80, Color.RED);
        Rectangle rectangle3 = new Rectangle(60, 100, Color.RED);
        Rectangle rectangle4 = new Rectangle(60, 120, Color.RED);
        Rectangle rectangle5 = new Rectangle(60, 140, Color.RED);
        Rectangle rectangle6 = new Rectangle(60, 160, Color.RED);
        Rectangle rectangle7 = new Rectangle(60, 180, Color.RED);
        Rectangle rectangle8 = new Rectangle(60, 200, Color.RED);
        Rectangle rectangle9 = new Rectangle(60, 220, Color.RED);
        
        HBox hbox1 = new HBox();
        HBox hbox2 = new HBox();
        Label text = new Label("Score: ");
        scoreLabel.setText("0");
        Label info = new Label("2= oefenen met begeleider, 7= alleen oefenen, 9= klaar voor rijexamen");
        info.setTranslateX(10);
        hbox2.getChildren().addAll(text,scoreLabel,info);
  
        rectangle1.setStroke(Color.BLACK);
        rectangle1.setTranslateY(180);
        rectangle1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                if (rectangle1.getFill() == Color.RED) {
                    rectangle1.setFill(Color.GREEN);
                    updateScore(1);
                } else {
                    rectangle1.setFill(Color.RED);
                    updateScore(-1);
                }
            }
        });
        
        rectangle2.setStroke(Color.BLACK);
        rectangle2.setTranslateY(160);
        rectangle2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                if (rectangle2.getFill() == Color.RED) {
                    rectangle2.setFill(Color.GREEN);
                    updateScore(1);
                } else {
                    rectangle2.setFill(Color.RED);
                    updateScore(-1);
                }
            }
        });
        
        rectangle3.setStroke(Color.BLACK);
        rectangle3.setTranslateY(140);
        rectangle3.setOnMouseClicked(new EventHandler<MouseEvent>() {
           public void handle(MouseEvent me) {
                if (rectangle3.getFill() == Color.RED) {
                    rectangle3.setFill(Color.GREEN);
                    updateScore(1);
                } else {
                    rectangle3.setFill(Color.RED);
                    updateScore(-1);
                }
            }
        });
        
        rectangle4.setStroke(Color.BLACK);
        rectangle4.setTranslateY(120);
        rectangle4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                if (rectangle4.getFill() == Color.RED) {
                    rectangle4.setFill(Color.GREEN);
                    updateScore(1);
                } else {
                    rectangle4.setFill(Color.RED);
                    updateScore(-1);
                }
            }
        });
        rectangle5.setStroke(Color.BLACK);
        rectangle5.setTranslateY(100);
        rectangle5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                if (rectangle5.getFill() == Color.RED) {
                    rectangle5.setFill(Color.GREEN);
                    updateScore(1);
                } else {
                    rectangle5.setFill(Color.RED);
                    updateScore(-1);
                }
            }
        });
        
        rectangle6.setStroke(Color.BLACK);
        rectangle6.setTranslateY(80);
        rectangle6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                if (rectangle6.getFill() == Color.RED) {
                    rectangle6.setFill(Color.GREEN);
                    updateScore(1);
                } else {
                    rectangle6.setFill(Color.RED);
                    updateScore(-1);
                }
            }
        });
        rectangle7.setStroke(Color.BLACK);
        rectangle7.setTranslateY(60);
        rectangle7.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                if (rectangle7.getFill() == Color.RED) {
                    rectangle7.setFill(Color.GREEN);
                    updateScore(1);
                } else {
                    rectangle7.setFill(Color.RED);
                    updateScore(-1);
                }
            }
        });
        rectangle8.setStroke(Color.BLACK);
        rectangle8.setTranslateY(40);
        rectangle8.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                if (rectangle8.getFill() == Color.RED) {
                    rectangle8.setFill(Color.GREEN);
                    updateScore(1);
                } else {
                    rectangle8.setFill(Color.RED);
                    updateScore(-1);
                }
            }
        });
        rectangle9.setStroke(Color.BLACK);
        rectangle9.setTranslateY(20);
        rectangle9.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                if (rectangle9.getFill() == Color.RED) {
                    rectangle9.setFill(Color.GREEN);
                    updateScore(1);
                } else {
                    rectangle9.setFill(Color.RED);
                    updateScore(-1);
                }
            }
        });
        
        hbox1.getChildren().addAll(rectangle1,rectangle2,rectangle3,rectangle4,rectangle5,rectangle6,rectangle7,rectangle8,rectangle9);
        
        
        
        
        this.getChildren().addAll(hbox2,hbox1);
    }
    private void updateScore(int inkomend)
    {
        score=score+inkomend;
        scoreLabel.setText(""+score);
    }
}
