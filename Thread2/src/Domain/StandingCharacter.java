package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class StandingCharacter extends Character {

    public StandingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }
    
    public void setSprite() throws FileNotFoundException{
        ArrayList<Image> sprite = super.getSprite();
        for(int i = 0; i < 4; i++){
            sprite.add(new Image(new FileInputStream("src/Assets/Standing"+i+".png")));
        }
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        int image=0;
        ArrayList<Image> sprite = super.getSprite();
        
        while (true) {
            try {
                super.setImage(sprite.get(image));
                Thread.sleep(400);
                image++;
                if(image==3){
                    image=0;
                }
            } 
            catch (InterruptedException ex) { }
        }
    }
}
