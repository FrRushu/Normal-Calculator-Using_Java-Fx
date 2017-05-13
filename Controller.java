package sample;


import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {

    public Text outPut;
    private long number1=0;
    public String operator="";
    private boolean start =true;
    Model model = new Model();

    public void processNum(ActionEvent event){

        if(start){
            outPut.setText("");
            start=false;
        }
        String value = ((Button)event.getSource()).getText();
        outPut.setText(outPut.getText()+value);



    }

    public void processOp(ActionEvent event){

        String value = ((Button)event.getSource()).getText();

        if (!"=".equals(value)){
            if (!operator.isEmpty())
                return;

            operator = value;

            number1=Long.parseLong(outPut.getText());
            outPut.setText("");
        }
        else {

            if (operator.isEmpty())
                return;

            outPut.setText(String.valueOf(model.calculate(number1,Long.parseLong(outPut.getText()),operator)));
            operator="";
            start = true;

        }

    }
}
