import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StartScreen extends Application
{
	
	private Pane pane = new Pane();
	private Scene scene = new Scene(pane, 500, 440);
	private TextArea t;
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		scene.getStylesheets().add("styles/style.css");
		pane.setId("pane");
		Font.loadFont(getClass().getResourceAsStream("Slabo.ttf"), 10);
		
		addText();
		
		
		
		addButtons(primaryStage);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	
	
	
	public void addText()
	{	
		t = new TextArea();
		t.setEditable(false);
		t.setId("text-padding");
		t.setWrapText(true);
		t.setMaxWidth(scene.getWidth()-50);
		t.layoutXProperty().bind(pane.widthProperty().subtract(t.widthProperty()).divide(2));
		t.setTranslateY(30);
		t.setFont(Font.font("Slabo 27px", 20));
		
		String content = "Are you ready to escape?";
		
		final Animation animation = new Transition() {
	        {
	            setCycleDuration(Duration.millis(2000));
	        }
	    
	        protected void interpolate(double frac) {
	            final int length = content.length();
	            final int n = Math.round(length * (float) frac);
	            t.setText(content.substring(0, n));
	        }
	    
	    };
	    
	    animation.play();
		
		pane.getChildren().addAll(t);
	}
	
	public void addButtons(Stage primaryStage)
	{
		Button zombies = new Button("Zombies");
		zombies.setId("dark-blue");
		zombies.setTranslateX(40);
		zombies.setFont(Font.font("Slabo 27px", 14));
		zombies.setTranslateY(230);
		zombies.setOnAction(e->{
			userInterface ui = new userInterface("zombies");
			try {
				ui.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		Button nerds = new Button("Nerd");
		nerds.setId("dark-blue");
		nerds.setTranslateX(210);
		nerds.setTranslateY(230);
		nerds.setFont(Font.font("Slabo 27px", 14));
		nerds.setOnAction(e->{
			userInterface ui = new userInterface("nerds");
			try {
				ui.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		Button elevator = new Button("Elevator");
		elevator.setId("dark-blue");
		elevator.setTranslateX(360);
		elevator.setTranslateY(230);
		elevator.setOnAction(e->{
			userInterface ui = new userInterface("elevator");
			try {
				ui.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		pane.getChildren().addAll(zombies, nerds, elevator);
	}
	
	public static void main(String[] args)
	{
		Application.launch(args);
	}
}
