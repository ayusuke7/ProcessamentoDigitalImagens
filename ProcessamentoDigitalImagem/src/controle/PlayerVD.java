package controle;

/**
 *
 * @author YU7
 */
import java.io.File;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PlayerVD extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        String path = System.getProperty("user.dir");
        
        final File arquivo = new File(path, "Video1.mp4");
        final Media media = new Media(arquivo.toURI().toString());
        final MediaPlayer player = new MediaPlayer(media);
        final MediaView mediavw = new MediaView(player);
        
        final DoubleProperty width = mediavw.fitWidthProperty();
        final DoubleProperty height = mediavw.fitHeightProperty();
        
        width.bind(Bindings.selectDouble(mediavw.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(mediavw.sceneProperty(), "height"));
        
        mediavw.setPreserveRatio(true);
        
        StackPane root = new StackPane();
        root.getChildren().add(mediavw);
        Scene scene = new Scene(root, 960, 540);
        scene.setFill(Color.BLACK);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Video Player");
        primaryStage.show();
        
        player.play();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
