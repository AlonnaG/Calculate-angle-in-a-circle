package application;
	
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;


public class Main extends Application {
	
	
	Circle[] circleSm = {new Circle(150, 300, 5),new Circle(300, 450, 5),new Circle(300, 150, 5)};
    Line line1 = new Line();
	Line line2 = new Line();
	Line line3 = new Line();
	Text[] text = {new Text(), new Text(), new Text()};
    double radius =10;
    
    /*circleSm.setFill(Color.RED);
	
	Circle circle2 = new Circle(300, 450, 5);
	circle2.setFill(Color.RED);
	
	Circle circle3 = new Circle(300, 150, 5);
	circle3.setFill(Color.RED);*/
	
	
	/*Text text1 = new Text();
	Text text2 = new Text();
	Text text3 = new Text();*/
	
	
	public void start(Stage primaryStage) {
		try {
			Circle mainCircle = new Circle(300, 300, 150);
			mainCircle.setFill(Color.LIGHTBLUE);
	      
			Group root = new Group(mainCircle, circleSm[0], circleSm[1], circleSm[2],line1,line2,line3,text[0],text[1],text[2]);
	        
			BorderPane border = new BorderPane();
			showLines();
			
			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Measuring Circle");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			// Show angles
		    circleSm[0].setOnMouseDragged(e -> { 
		        if (circleSm[0].contains(e.getX(), e.getY())) {
		        	circleSm[0].setCenterX(e.getX());
		        	circleSm[0].setCenterY(e.getY());
		          showLines();
		        }
		      });

		    circleSm[1].setOnMouseDragged(e -> { 
		        if (circleSm[1].contains(e.getX(), e.getY())) {
		        	circleSm[1].setCenterX(e.getX());
		        	circleSm[1].setCenterY(e.getY());
		          showLines();
		        }
		      });
		      
		    circleSm[2].setOnMouseDragged(e -> { 
		        if (circleSm[2].contains(e.getX(), e.getY())) {
		        	circleSm[2].setCenterX(e.getX());
		        	circleSm[2].setCenterY(e.getY());
		          showLines();
		        }
		      });
	   
		      
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

	private void showLines() {
		//get start and end of each line
		line1.setStartX(circleSm[0].getCenterX());
	    line1.setStartY(circleSm[0].getCenterY());
	    line1.setEndX(circleSm[1].getCenterX());
	    line1.setEndY(circleSm[1].getCenterY());
	    line2.setStartX(circleSm[0].getCenterX());
	    line2.setStartY(circleSm[0].getCenterY());
	    line2.setEndX(circleSm[2].getCenterX());
	    line2.setEndY(circleSm[2].getCenterY());
	    line3.setStartX(circleSm[1].getCenterX());
	    line3.setStartY(circleSm[1].getCenterY());
	    line3.setEndX(circleSm[2].getCenterX());
	    line3.setEndY(circleSm[2].getCenterY());
	    
	    // Calculate angles
	    double a = new Point2D(circleSm[2].getCenterX(), circleSm[2].getCenterY()).
	            distance(circleSm[1].getCenterX(), circleSm[1].getCenterY());
	    double b = new Point2D(circleSm[2].getCenterX(), circleSm[2].getCenterY()).
	            distance(circleSm[0].getCenterX(), circleSm[0].getCenterY());
	    double c = new Point2D(circleSm[1].getCenterX(), circleSm[1].getCenterY()).
	            distance(circleSm[0].getCenterX(), circleSm[0].getCenterY());     
	    double[] angle = new double[3];
	    angle[0] = Math.acos((a * a - b * b - c * c) / (-2 * b * c));
	    angle[1] = Math.acos((b * b - a * a - c * c) / (-2 * a * c));
	    angle[2] = Math.acos((c * c - b * b - a * a) / (-2 * a * b));

	    for (int i = 0; i < 3; i++) {
	      text[i].setX(circleSm[i].getCenterX());
	      text[i].setY(circleSm[i].getCenterY() - radius);
	      text[i].setText(String.format("%.2f", Math.toDegrees(angle[i])));
	    }
		
	}



	public static void main(String[] args) {
		launch(args);
	}
}
