package sample;

public class QueueHistory {

    private String[] history = new String[5];
    private int index;


    void pop(int add, int count) {

        index = count - 1;

        if (index <= 4 && index>=0) {
            if (add > 0) {

                history[index] = "deposit " + String.valueOf(add);

            } else if (add < 0) {

                history[index] = "withdraw " + (String.valueOf(-1 * add));
            }
        }
        else {

            replace();
            if (add > 0) {

                history[index-1] = "deposit " + String.valueOf(add);

            } else if(add < 0) {

                history[index-1] = "withdraw " + (String.valueOf(-1 * add));
                index--;
            }
        }
    }

     public String previous() {


        if(index == 0){

            return "END OF TRANSACTIONS";

        }
        else

        return history[--index];

    }

    public void replace(){

        int i;
        for(i=0;i<4;i++){

            history[i]=history[i+1];

        }

    }

    public String next(){



        if(index == 5){

            return "END OF TRANSACTIONS";
        }
            else

                return history[index++];
    }

}
