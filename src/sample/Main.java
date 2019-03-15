package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;





public class Main extends Application {

    LoginAuthentication check;
    Scene scene1, scene2, scene3, scene4;
    AccountInfo user;
    QueueHistory history;

    public static void main(String[]args){

        launch(args);
    }

    public void start(Stage primaryStage) throws Exception  {
        check = new LoginAuthentication();
        history = new QueueHistory();
        user = new AccountInfo(history);

        primaryStage.setTitle("Online Bank");

        Label userpinlabel = new Label("Please enter your 4 digit pin: ");
        PasswordField userpinfield = new PasswordField();
        Button deposit = new Button("deposit");
        TextField amountTXT1 = new TextField();
        TextField amountTXT2 = new TextField();
        Label inscene3 = new Label("Please enter value");
        Label inscene4 = new Label("Please enter value");
        Button submitscene3 = new Button("submit");
        Button submitscene4 = new Button("submit");
        Button withdraw = new Button("withdraw");
        //Button submitW = new Button("submit");
        Button balance = new Button("Check your balance");
        Label balanceTXT = new Label("balance");
        Button previous = new Button("previous transaction");
        Button next = new Button ("next transaction");
        Button logout = new Button("logout");
        Button back1 = new Button("Back");
        Button back2 = new Button("Back");
        Label errors = new Label("No errors");
        //Label transaction = new Label();
        Label startup = new Label();
        GridPane grid = new GridPane();
        GridPane grid1 = new GridPane();
        GridPane grid2 = new GridPane();
        GridPane grid3 = new GridPane();

        grid.add(userpinlabel, 0, 0);
        grid.add(userpinfield, 1, 0);
        Button submit = new Button("submit");
        grid.add(submit, 1, 3);
        grid.add(startup, 2, 3);
        grid1.add(deposit,0,0);
        //grid1.add(amountTXT, 3,1);
        //grid1.add(submitD,5,0);
        grid1.add(withdraw,0,2);
        //grid1.add(submitW,5,2);
        grid1.add(balance,0,4);
        grid1.add(balanceTXT,3,8);
        grid1.add(previous,0,5);
        grid1.add(next,4,5);
        //grid1.add(transaction,3,10);
        grid1.add(logout,5,12);
        grid2.add(errors,4,14);
        grid2.add(back1,3,2);
        grid2.add(inscene3,0,0);
        grid2.add(amountTXT1,3,0);
        grid2.add(submitscene3,5,0);
        grid3.add(inscene4,0,0);
        grid3.add(amountTXT2,3,0);
        grid3.add(submitscene4,5,0);
        grid3.add(back2,3,2);
        grid3.add(errors,4,14);


        submit.setOnAction(e -> {

                String code = userpinfield.getText();
                boolean valid = check.validate(code);

                if (valid) {

                    startup.setText(" ");
                    primaryStage.setScene(scene2);


                } else {

                    startup.setText("INCORRECT PIN");
                }
            });

            /*submitscene3.setOnAction(e ->{

                 int amountd = Integer.valueOf(amountTXT.getText()) ;
                 user.deposit(amountd);

            });*/

            /*submitW.setOnAction(e ->{

                if(!user.withdrawCheck(Integer.valueOf(amountTXT.getText()))){

                    errors.setText("INSUFFICIENT FUNDS");
                }
                else {
                    int amountw = Integer.valueOf(amountTXT.getText());
                    user.withdraw(amountw);
                    errors.setText("No errors");
                }
            });*/

            balance.setOnAction(e -> balanceTXT.setText(String.valueOf(user.getBalance())));

            previous.setOnAction(e ->{

                //history.previous();
                balanceTXT.setText(history.previous());

            });

            next.setOnAction(e ->{

                //history.next();
                balanceTXT.setText(history.next());
            });

            logout.setOnAction(e -> primaryStage.setScene(scene1));

            deposit.setOnAction(e ->{

                primaryStage.setTitle("Deposit");
                primaryStage.setScene(scene3);
            });

            submitscene3.setOnAction(e -> {

                int amountd = Integer.valueOf(amountTXT1.getText());
                user.deposit(amountd);
                amountTXT1.clear();
                });

            submitscene4.setOnAction(e -> {

                if (!user.withdrawCheck(Integer.valueOf(amountTXT2.getText()))) {

                    errors.setText("INSUFFICIENT FUNDS");
                } else {
                    int amountw = Integer.valueOf(amountTXT2.getText());
                    user.withdraw(amountw);
                    amountTXT2.clear();
                }
            });

                back1.setOnAction(e -> {

                    primaryStage.setTitle("Online Bank");
                    primaryStage.setScene(scene2);
                });

                back2.setOnAction(e -> {

                    primaryStage.setTitle("Online Bank");
                    primaryStage.setScene(scene2);
                });

            withdraw.setOnAction(e ->{

                primaryStage.setTitle("Withdraw");
                primaryStage.setScene(scene4);
            });


        scene1 = new Scene (grid,400,400);
        primaryStage.setScene(scene1);
        primaryStage.show();

        scene2 = new Scene (grid1,600,500);

        scene3 = new Scene (grid2,400,400);

        scene4 = new Scene (grid3,400,400);
    }

}