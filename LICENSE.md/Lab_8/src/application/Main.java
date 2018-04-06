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
	@Override
	public void start(Stage primaryStage) {
		try {
			Circle mainCircle = new Circle(300, 300, 150);
			mainCircle.setFill(Color.BLUE);
	        
	        
	        Circle circle1 = new Circle(150, 300, 5);
	        circle1.setFill(Color.RED);
			
			Circle circle2 = new Circle(300, 450, 5);
			circle2.setFill(Color.RED);
			
			Circle circle3 = new Circle(300, 150, 5);
			circle3.setFill(Color.RED);
			
			Line line1 = new Line();
			Line line2 = new Line();
			Line line3 = new Line();
			Text text1 = new Text();
			Text text2 = new Text();
			Text text3 = new Text();
			
			double radius =10;
			
			Group root = new Group(mainCircle, circle1, circle2, circle3,line1,line2,line3,text1,text2,text3);
	        
			BorderPane border = new BorderPane();
			showLines();
			/*border.getChildren().addAll(circle1,circle2,circle3, line1,line2,line3,angle1,angle2,angle3);
			*/Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Measuring Circle");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		    circle1.setOnMouseDragged(e -> { 
		        if (circle1.contains(e.getX(), e.getY())) {
		          // Recompute and display angles
		          circle1.setCenterX(e.getX());
		          circle1.setCenterY(e.getY());
		          setLines();
		        }
		      });

		      circle2.setOnMouseDragged(e -> { 
		        if (circle2.contains(e.getX(), e.getY())) {
		          // Recompute and display angles
		          circle2.setCenterX(e.getX());
		          circle2.setCenterY(e.getY());
		          setLines();
		        }
		      });
		      
		      circle3.setOnMouseDragged(e -> { 
		        if (circle3.contains(e.getX(), e.getY())) {
		          // Recompute and display angles
		          circle3.setCenterX(e.getX());
		          circle3.setCenterY(e.getY());
		          setLines();
		        }
		      });
	        
	        
		      
		      private void setLines() {
		    	    line1.setStartX(circle1.getCenterX());
		    	    line1.setStartY(circle1.getCenterY());
		    	    line1.setEndX(circle2.getCenterX());
		    	    line1.setEndY(circle2.getCenterY());
		    	    line2.setStartX(circle1.getCenterX());
		    	    line2.setStartY(circle1.getCenterY());
		    	    line2.setEndX(circle3.getCenterX());
		    	    line2.setEndY(circle3.getCenterY());
		    	    line3.setStartX(circle2.getCenterX());
		    	    line3.setStartY(circle2.getCenterY());
		    	    line3.setEndX(circle3.getCenterX());
		    	    line3.setEndY(circle3.getCenterY());
		    	    
		    	    // Compute angles
		    	    double a = new Point2D(circle3.getCenterX(), circle3.getCenterY()).
		    	            distance(circle2.getCenterX(), circle2.getCenterY());
		    	    double b = new Point2D(circle3.getCenterX(), circle3.getCenterY()).
		    	            distance(circle1.getCenterX(), circle1.getCenterY());
		    	    double c = new Point2D(circle2.getCenterX(), circle2.getCenterY()).
		    	            distance(circle1.getCenterX(), circle1.getCenterY());     
		    	    double[] angle = new double[3];
		    	    angle[0] = Math.acos((a * a - b * b - c * c) / (-2 * b * c));
		    	    angle[1] = Math.acos((b * b - a * a - c * c) / (-2 * a * c));
		    	    angle[2] = Math.acos((c * c - b * b - a * a) / (-2 * a * b));

		    	    for (int i = 0; i < 3; i++) {
		    	      text[i].setX(circle[i].getCenterX());
		    	      text[i].setY(circle[i].getCenterY() - radius);
		    	      text[i].setText(String.format("%.2f", Math.toDegrees(angle[i])));
		    	    }
		    	  }
		      
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void showLines() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
