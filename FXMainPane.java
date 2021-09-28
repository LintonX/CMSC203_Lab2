import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button button1;
	Button button2; 
	Button button3; 
	Button button4;
	Button button5;
	Button button6;
	
	Label label;
	
	TextField text;
	
	//  declare two HBoxes
	HBox hbox1;
	HBox hbox2;
	
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager manager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		button1 = new Button("Hello");
		button2 = new Button("Howdy");
		button3 = new Button("Chinese");
		button4 = new Button("Clear");
		button5 = new Button("Exit");
		button6 = new Button("Spanish");
		
		label = new Label("Feedback:");
		
		text = new TextField();
		
		//  instantiate the HBoxes
		hbox1 = new HBox();
		hbox2 = new HBox();
		
		
		//student Task #4:
		//  instantiate the DataManager instance
		manager = new DataManager();
		//  set margins and set alignment of the components
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hbox1.getChildren().addAll(label, text);
		//  add the buttons to the other HBox
		hbox2.getChildren().addAll(button1, button2, button3, button6, button4, button5);
		
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(hbox1, hbox2);
		
		button1.setOnAction(new ButtonHandler());
		button2.setOnAction(new ButtonHandler());
		button3.setOnAction(new ButtonHandler());
		button4.setOnAction(new ButtonHandler());
		button5.setOnAction(new ButtonHandler());
		button6.setOnAction(new ButtonHandler());
		
		hbox1.setPadding(new Insets(10,0,2,0));
		hbox1.setSpacing(5);
		HBox.setMargin(button1, new Insets(5));
		HBox.setMargin(button2, new Insets(5));
		HBox.setMargin(button3, new Insets(5));
		HBox.setMargin(button4, new Insets(5));
		HBox.setMargin(button5, new Insets(5));
		HBox.setMargin(button6, new Insets(5));
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	
	private class ButtonHandler implements EventHandler<ActionEvent>{
	public void handle(ActionEvent event) {
		if (button1 == event.getTarget()) {
			text.setText(manager.getHello());
		}
		else if (button2 == event.getTarget()) {
			text.setText(manager.getHowdy());
		}
		else if (button3 == event.getTarget()) {
			text.setText(manager.getChinese());
		}
		else if (button4 == event.getTarget()) {
			text.setText("");
		}
		else if (button6 == event.getTarget()) {
			text.setText(manager.getSpanish());
		}
		else if (button5 == event.getTarget()) {
			Platform.exit();
			System.exit(0);
		}
	}
	}
}
	