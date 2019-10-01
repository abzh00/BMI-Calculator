package sample;
import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {

    private static final DecimalFormat df = new DecimalFormat("#.0");
    // GUI controls defined in FXML and used by the controller's code
    @FXML
    private TextField TFW;
    @FXML
    private TextField TFH;
    @FXML
    private TextField TFBMI;
    @FXML
    private TextField TFBMI2;
    @FXML
    private ImageView IMG;

    // calculates and displays the tip and total amounts
    @FXML
    private void calculateButtonPressed(ActionEvent event) {
        try {
            double weight = Double.parseDouble(TFW.getText());
            double height = Double.parseDouble(TFH.getText());
            double bmi = weight/((height/100)*(height/100));
            TFBMI.setText(String.valueOf(df.format(bmi)));
            Image image1 = new Image("https://is3-ssl.mzstatic.com/image/thumb/Purple128/v4/c1/1d/fa/c11dfafd-a965-fc48-8961-825a8c75f549/source/512x512bb.jpg");
            IMG.setImage(image1);
            if (bmi < 18.5){
                TFBMI2.setText("Underweight");
                Image image2 = new Image("https://echelonsfl.files.wordpress.com/2012/12/2.jpg?w=584");
                IMG.setImage(image2);
            }else if (18.5 <= bmi && bmi < 25){
                TFBMI2.setText("Normal weight");
                Image image3 = new Image("https://images5.yesmagazine.ru/upload/cache_img/f07/f077877c56907dc337c9369cdc786f8a_fitted_660x880.jpg");
                IMG.setImage(image3);
            }else if (25 <= bmi && bmi < 30){
                TFBMI2.setText("Overweight");
                Image image4 = new Image("http://famewatcher.com/wp-content/uploads/2010/10/brendan-fraser-2.jpg");
                IMG.setImage(image4);
            }else if(30<= bmi){
                TFBMI2.setText("Obesity");
                Image image5 = new Image("https://medialeaks.ru/wp-content/uploads/2019/01/1-29.jpg");
                IMG.setImage(image5);
            }else{
                TFBMI2.setText("Invalid input");
                IMG.setImage(image1);
            }




        }
        catch (NumberFormatException ex) {
            TFW.setText("in kilograms");
            TFW.selectAll();
            TFW.requestFocus();
            TFW.setText("in centimetres");
            TFH.selectAll();
            TFH.requestFocus();
            Image image1 = new Image("https://is3-ssl.mzstatic.com/image/thumb/Purple128/v4/c1/1d/fa/c11dfafd-a965-fc48-8961-825a8c75f549/source/512x512bb.jpg");
            IMG.setImage(image1);
        }
    }



    // called by FXMLLoader to initialize the controller
    public void initialize() {
        Image image1 = new Image("https://is3-ssl.mzstatic.com/image/thumb/Purple128/v4/c1/1d/fa/c11dfafd-a965-fc48-8961-825a8c75f549/source/512x512bb.jpg");
        IMG.setImage(image1);
    }
}
