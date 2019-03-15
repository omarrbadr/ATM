package sample;
//TODO

public class LoginAuthentication {

        int userPins;

    public LoginAuthentication(){

        this.userPins = 1234;
    }


    public boolean validate (String userpin){

        boolean result;
        String check = String.valueOf(userPins);

        if(check != null){

            result = check.equals(userpin);
        }
        else {

            result = false;
        }

        return result;
    }
}



/*submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String code = userpinfield.getText();
                boolean valid = check.validate(code);

                if (valid) {

                    startup.setText("Welcome Back");
                    primaryStage.setScene(scene2);

                } else {

                    startup.setText("INCORRECT PIN");
                    System.exit(0);
                }


            }
        });*/