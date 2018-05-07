package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

public class RunningCharacter extends Character {

    public RunningCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 8; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Running"+i+".png")));
        }
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        int image=0;
        int space=-15;
        ArrayList<Image> sprite = super.getSprite();
        while(true){
            try{
                super.setImage(sprite.get(image));
                super.setX(space);
                Thread.sleep(80);
                if(image==7){
                    image=0;
                }
                
                if(space==825){
                    
                    space=-15;
                }
                
                image++;
                space+=15;
                
            } catch (InterruptedException ex) {
                Logger.getLogger(RunningCharacter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
        
    }
}
