package application;

import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;

/**
 * An attempt to implement momento with a button 
 * @author Lawrence
 *
 */
public class ResetButton extends Button{

	/**
	 * Quit the program
	 * @param label
	 */
    public ResetButton(String text){
 
        this.setText(text);
        this.setLayoutX(500);
        this.setOnAction(event -> {
                System.out.println("Quitted Successfully");
                System.exit(1);
        });
      
    }

}
