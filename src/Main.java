import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {

    Rectangle r4 = new Rectangle();
    Rectangle r3 = new Rectangle();
    Rectangle r2 = new Rectangle();
    Rectangle r1 = new Rectangle();

    Board board = new Board();
    GridPane grid2 = new GridPane();
    GridPane grid = new GridPane();

    final Text actiontarget = new Text();

    @Override
    public void start(Stage primaryStage) {
        int size;
        Disk disk1 = new Disk(size=4);
        Disk disk2 = new Disk(size=3);
        Disk disk3 = new Disk(size=2);
        Disk disk4 = new Disk(size=1);

        board.add(disk1);
        board.add(disk2);
        board.add(disk3);
        board.add(disk4);

        primaryStage.setTitle("Tower of hanoi");

        GridPane.setColumnSpan(grid2,5);

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(10);


        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(40);
        grid2.setVgap(5);

        grid.add(grid2,0,0);

        r4.setWidth(40);
        r4.setHeight(20);
        r4.setFill(Color.rgb(255, 55, 55));
        grid2.add(r4, 1, 0);

        r3.setWidth(60);
        r3.setHeight(20);
        r3.setFill(Color.web("EFFF3B"));
        grid2.add(r3, 1, 0);

        r2.setWidth(80);
        r2.setHeight(20);
        r2.setFill(Color.rgb(91, 127, 255));
        grid2.add(r2, 1, 0);

        r1.setWidth(100);
        r1.setHeight(20);
        r1.setFill(Color.web("FFA717"));
        grid2.add(r1, 1, 0);

        Button btn12 = new Button("-->");
        HBox hbBtn12 = new HBox(10);
        hbBtn12.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn12.getChildren().add(btn12);
        grid.add(hbBtn12, 0, 5);

        Button btn13 = new Button("<--");
        HBox hbBtn13 = new HBox(10);
        hbBtn13.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn13.getChildren().add(btn13);
        grid.add(hbBtn13, 0, 6);

        Button btn21 = new Button("<--");
        HBox hbBtn21 = new HBox(10);
        hbBtn21.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn21.getChildren().add(btn21);
        grid.add(hbBtn21, 1, 6);

        Button btn23 = new Button("-->");
        HBox hbBtn23 = new HBox(10);
        hbBtn23.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn23.getChildren().add(btn23);
        grid.add(hbBtn23, 1, 5);

        Button btn31 = new Button("-->");
        HBox hbBtn31 = new HBox(10);
        hbBtn31.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn31.getChildren().add(btn31);
        grid.add(hbBtn31, 2, 5);

        Button btn32 = new Button("<--");
        HBox hbBtn32 = new HBox(10);
        hbBtn32.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn32.getChildren().add(btn32);
        grid.add(hbBtn32, 2, 6);

        grid.add(actiontarget, 2, 7);

        update();

        btn12.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (board.isBigger12()) {
                    Disk flytter=board.getDisklist1().getFirst();
                    board.getDisklist1().removeFirst();
                    board.getDisklist2().addFirst(flytter);

                    update();
                }
            }
        });

        btn13.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (board.isBigger13()) {
                    board.getDisklist3().addFirst(board.getDisklist1().getFirst());
                    board.getDisklist1().removeFirst();
                    update();
                }
            }
        });

        btn21.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (board.isBigger21()) {
                    board.getDisklist1().addFirst(board.getDisklist2().getFirst());
                    board.getDisklist2().removeFirst();
                    update();
                }
            }
        });

        btn23.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (board.isBigger23()) {
                    board.getDisklist3().addFirst(board.getDisklist2().getFirst());
                    board.getDisklist2().removeFirst();
                    update();
                }
            }
        });

        btn31.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (board.isBigger31()) {
                    board.getDisklist1().addFirst(board.getDisklist3().getFirst());
                    board.getDisklist3().removeFirst();
                    update();
                }
            }
        });

        btn32.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (board.isBigger32()) {
                    board.getDisklist2().addFirst(board.getDisklist3().getFirst());
                    board.getDisklist3().removeFirst();
                    update();
                }
            }
        });

        Scene scene = new Scene(grid, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void update(){

        grid2.getChildren().remove(0);
        grid2.getChildren().remove(0);
        grid2.getChildren().remove(0);
        grid2.getChildren().remove(0);
        int x=0;
        int y=0;


        if(board.getDisklist1().size()==3){
            y=1;
        }
        if(board.getDisklist1().size()==2){
            y=2;
        }
        if(board.getDisklist1().size()==1){
            y=3;
        }

        while(board.getDisklist1().size()>x){

            if(board.getDisklist1().get(x).getSize()==1){
                grid2.add(r4,0,y);
            }
            if(board.getDisklist1().get(x).getSize()==2){
                grid2.add(r3, 0, y);
            }
            if(board.getDisklist1().get(x).getSize()==3){
                grid2.add(r2, 0, y);
            }
            if(board.getDisklist1().get(x).getSize()==4){
                grid2.add(r1, 0, y);
            }
            x++;
            y++;
        }

        x=0;
        y=0;
        if(board.getDisklist2().size()==3){
            y=1;
        }
        if(board.getDisklist2().size()==2){
            y=2;
        }
        if(board.getDisklist2().size()==1){
            y=3;
        }

        while(board.getDisklist2().size()>x){
            if(board.getDisklist2().get(x).getSize()==1){
                grid2.add(r4,1,y);
            }
            if(board.getDisklist2().get(x).getSize()==2){
                grid2.add(r3, 1, y);
            }
            if(board.getDisklist2().get(x).getSize()==3){
                grid2.add(r2, 1, y);
            }
            if(board.getDisklist2().get(x).getSize()==4){
                grid2.add(r1, 1, y);
            }
            x++;
            y++;
        }

        x=0;
        y=0;
        if(board.getDisklist3().size()==4){
            actiontarget.setFill(Color.GOLD);
            actiontarget.setText("Congratulations!");
        }
        if(board.getDisklist3().size()==3){
            y=1;
        }
        if(board.getDisklist3().size()==2){
            y=2;
        }
        if(board.getDisklist3().size()==1){
            y=3;
        }
        while(board.getDisklist3().size()>x){
            if(board.getDisklist3().get(x).getSize()==1){
                grid2.add(r4,2,y);
            }
            if(board.getDisklist3().get(x).getSize()==2){
                grid2.add(r3, 2, y);
            }
            if(board.getDisklist3().get(x).getSize()==3){
                grid2.add(r2, 2, y);
            }
            if(board.getDisklist3().get(x).getSize()==4){
                grid2.add(r1, 2, y);
            }
            x++;
            y++;
        }
    }



    public static void main(String[] args) {
        launch(args);


        int x;
        int y = 1;

        Scanner keyboard = new Scanner(System.in);

        int size = 4;
        Disk disk1 = new Disk(size);
        size = 3;
        Disk disk2 = new Disk(size);
        size = 2;
        Disk disk3 = new Disk(size);
        size = 1;
        Disk disk4 = new Disk(size);

        Board board = new Board();
        board.add(disk1);
        board.add(disk2);
        board.add(disk3);
        board.add(disk4);

        while (y == 1) {
            System.out.println(board);
            x = keyboard.nextInt();

            if (x == 12 && board.isBigger12()) {
                board.getDisklist2().addFirst(board.getDisklist1().getFirst());
                board.getDisklist1().removeFirst();
                x = 0;
            }
            if (x == 13 && board.isBigger13()) {
                board.getDisklist3().addFirst(board.getDisklist1().getFirst());
                board.getDisklist1().removeFirst();
                x = 0;
            }
            if (x == 23 && board.isBigger23()) {
                board.getDisklist3().addFirst(board.getDisklist2().getFirst());
                board.getDisklist2().removeFirst();
                x = 0;
            }
            if (x == 21 && board.isBigger21()) {
                board.getDisklist1().addFirst(board.getDisklist2().getFirst());
                board.getDisklist2().removeFirst();
                x = 0;
            }
            if (x == 31 && board.isBigger31()) {
                board.getDisklist1().addFirst(board.getDisklist3().getFirst());
                board.getDisklist3().removeFirst();
                x = 0;
            }
            if (x == 32 && board.isBigger32()) {
                board.getDisklist2().addFirst(board.getDisklist3().getFirst());
                board.getDisklist3().removeFirst();
                x = 0;
            }

            if (x != 0) {
                System.out.println("Error");
            }


        }


    }
}
