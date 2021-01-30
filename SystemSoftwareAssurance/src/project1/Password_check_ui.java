package project1;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Password_check_ui extends Application {
	Stage window;
	Scene scene1;
	Button button;
	
	public static void main(String[] args) {
		launch(args);
		
	}
	
	public void start(Stage primaryStage) throws Exception {
		
		window = primaryStage;
		window.setTitle("Reset Password");
		
		//Labels and TextFields
		Text label = new Text("Reset Password");
		label.setFont(Font.font("Calibri",20));
		Text label1 = new Text("Enter new password *");
		label1.setFont(Font.font("Calibri",15));
		TextField password1 = new TextField();
		Text label2 = new Text("Re-enter password *");
		label2.setFont(Font.font("Calibri",15));
		TextField password2 = new TextField();
		
		//Action when pressing Enter in TextFields and submit button
		password1.setOnKeyPressed(e -> {
			if (e.getCode().toString().equals("ENTER")) {
				check_action(password1, password2);
			}
		});
		password2.setOnKeyPressed(e -> {
			if (e.getCode().toString().equals("ENTER")) {
				check_action(password1, password2);
			}
		});
		
		button = new Button("Submit");
		button.setFont(Font.font("Calibri",12));
		button.setOnAction(e-> {
			check_action(password1, password2);
		});
		
		// Layout and setting scene
		VBox layout = new VBox();
		layout.setPadding(new Insets(30));
		layout.setSpacing(10);
		layout.getChildren().addAll(label,label1,password1,label2,password2,button);
		
		scene1 = new Scene(layout, 400, 300);
		
		window.setScene(scene1);
		window.show();
		
		
	}
	private void check_action(TextField password1, TextField password2) {
		String pass1 = password1.getCharacters().toString();
		String pass2 = password2.getCharacters().toString();
		
		PasswordCheck pc = new PasswordCheck();
		
		String feedback = pc.run(pass1,pass2);
		Alert alert;
		
		if (!feedback.equals("Password Confirmed.")) {
			alert = new Alert(AlertType.ERROR, feedback, ButtonType.OK);
			
		} else {
			alert = new Alert(AlertType.CONFIRMATION, feedback, ButtonType.OK);
		}
		
		alert.show();
		
		password1.clear();
		password2.clear();
	}
	

}
