import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class userInterface extends Application
{
	public String keeper = "0";
	public String currentStory = "";
	
	private Pane pane = new Pane();
	private Scene scene = new Scene(pane, 500, 440);
	
	private TextArea t;
	private Button b1, b2, newGame;
	private Label timerLabel = new Label("here");
	private int counter = 15;
	
	private Stage publicStage;
	
	public userInterface(String cs)
	{
		currentStory = cs;
		
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		scene.getStylesheets().add("styles/style.css");
		pane.setStyle("-fx-background: #d3d3d3;");
		pane.setId("pane");
		Font.loadFont(getClass().getResourceAsStream("Slabo.ttf"), 10);
		
		chooseStory();
		passStage(primaryStage);
		
		pane.getChildren().add(timerLabel);
		
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public void chooseStory()
	{
		if(currentStory == "zombies")
		{
			begin(Zombies._00, Zombies._01, Zombies._0);
		}
		else if (currentStory.equals("nerds"))
		{
			begin(Nerds._00, Nerds._01, Nerds._0);
		}
	}
	
	public void addText(String promptText)
	{
		
		t = new TextArea();
		t.setEditable(false);
		t.setText(promptText);
		t.setId("text-padding");
		t.setWrapText(true);
		t.setMaxWidth(scene.getWidth()-50);
		t.layoutXProperty().bind(pane.widthProperty().subtract(t.widthProperty()).divide(2));
		t.setTranslateY(30);
		t.setFont(Font.font("Slabo 27px", 14));
		pane.getChildren().addAll(t);
	}
	
	public void addButton(String buttonOneText, String buttonTwoText)
	{
	
		b1 = new Button(buttonOneText);
		b1.setId("dark-blue");
		b1.setTranslateY(200);
		b1.setFont(Font.font("Slabo 27px", 14));
		b1.layoutXProperty().bind(pane.widthProperty().subtract(b1.widthProperty()).divide(2));
		b1.setMaxWidth(scene.getWidth()-50);
		b1.setWrapText(true);
		b1.setOnAction(e->{
			keeper+="0";
			
			if(currentStory == "zombies")
			{
				checkZombies();
			}
			else if (currentStory.equals("nerds"))
			{
				checkNerds();
			}
		});
		
		
		
		b2 = new Button(buttonTwoText);
		b2.setId("dark-blue");
		b2.setTranslateY(260);
		b2.setFont(Font.font("Slabo 27px", 14));
		b2.setMaxWidth(scene.getWidth()-50);
		b2.setWrapText(true);
		b2.layoutXProperty().bind(pane.widthProperty().subtract(b2.widthProperty()).divide(2));
		b2.setOnAction(e->{
			keeper+="1";
			
			if(currentStory.equals("zombies"))
			{
				checkZombies();
			}
			else if (currentStory.equals("nerds"))
			{
				checkNerds();
			}
		});
		
		
		pane.getChildren().addAll(b1, b2);
	}
	
	public void clear()
	{
		t.setText("");
		b1.setText("");
		b2.setText("");
	}
	
	public void checkZombies()
	{
		switch(keeper)
		{
			case "0":  break;
			
			case "00": clear();update(Zombies._000, Zombies._001, Zombies._00Prompt); break;
			case "000": clear();update(Zombies._0000, Zombies._0001, Zombies._000Prompt);break;
			case "0000": clear();update("", "", Zombies._0000Prompt);deathScreen();break;
			case "001": clear();update("", "", Zombies._001Prompt);deathScreen();break;
			case "0001": clear();update(Zombies._00010, Zombies._00011, Zombies._0001Prompt);break;
			case "00010": clear();update("", "", Zombies._00010Prompt);deathScreen();break;
			
			case "01": clear();update(Zombies._010, Zombies._011, Zombies._01Prompt); break;
			case "011": clear();update("", "", Zombies._011Prompt); deathScreen();break;
			case "010": clear();update(Zombies._0100, Zombies._0101, Zombies._010Prompt); break;
			case "0101": clear();update("", "", Zombies._0101Prompt); deathScreen();break;
			case "0100": clear();update(Zombies._01000, Zombies._01001, Zombies._0100Prompt); break;
			case "01001": clear();update("", "", Zombies._01001Prompt); deathScreen(); break;
			
		}
	}
	
	
	public void checkNerds()
	{
		switch(keeper)
		{
			case "0":  break;
			
			case "00": clear();update(Nerds._000, Nerds._001, Nerds._00Prompt);break;
			case "000": clear();update("", "", Nerds._000Prompt);deathScreen(); break;
			case "001": clear();update(Nerds._0010, Nerds._0011, Nerds._001Prompt);break;
			case "0011": clear();update("", "", Nerds._0011Prompt);deathScreen();break;
			case "0010": clear();update(Nerds._00100, Nerds._00101, Nerds._0010Prompt);break;
			case "00100": clear();update("", "", Nerds._00100Prompt);deathScreen();break;
			case "00101": clear();update("", "", Nerds._00101Prompt);deathScreen();break;
			
			
			case "01": clear();update(Nerds._010, Nerds._011, Nerds._01Prompt); break;
			case "011": clear();update(Nerds._0110, Nerds._0111, Nerds._011Prompt); break;
			case "010": clear();update("", "", Nerds._010Prompt); deathScreen();break;
			case "0110": clear();update("", "", Nerds._0110Prompt); deathScreen();break;
			case "0111": clear();update(Nerds._01110, Nerds._01111, Nerds._0111Prompt); break;
			case "01110": clear();update("", "", Nerds._01110Prompt); deathScreen(); break;
			case "01111": clear();update("", "", Nerds._01111Prompt); deathScreen(); break;
			
		}
	}
	
	public void passStage(Stage ps)
	{
		publicStage = ps;
	}
	
	public void deathScreen()
	{
		
		StartScreen ss = new StartScreen();
		pane.getChildren().removeAll(b1, b2);
		newGame = new Button("Start Again");
		newGame.setId("dark-blue");
		newGame.setTranslateY(200);
		newGame.setFont(Font.font("Slabo 27px", 14));
		newGame.layoutXProperty().bind(pane.widthProperty().subtract(newGame.widthProperty()).divide(2));
		newGame.setOnAction(e->{
			try {
				ss.start(publicStage);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		pane.getChildren().add(newGame);
	}
	
	
	public void update(String bOneText, String bTwoText, String promptText)
	{
		t.setText(promptText);
		b1.setText(bOneText);
		b2.setText(bTwoText);
		
	}
	
	public void begin(String bOneText, String bTwoText, String promptText)
	{
		addText(promptText);
		addButton(bOneText, bTwoText);
	}
	
	public static void main(String[] args)
	{
		Application.launch(args);
	}

}
