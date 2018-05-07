package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class JumpingCharacter extends Character {

    public JumpingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 3; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Jumping" + i + ".png")));
        }
    }

    @Override
    public void run() {
        int image = 0;
        int up = 370;
        int down = 0;

        ArrayList<Image> sprite = super.getSprite();

        while (true) {
            try {
                if (up == 370) {
                    System.out.println("estoy fuera");
                    for (int j = up; j >= 270; j = j -10) {
                        System.out.println("Entre perras");
                        image=0;
                        super.setImage(sprite.get(image));
                        super.setY(j);
                        Thread.sleep(120);
                        if (j == 270) {
                            image = 1;
                            up = 270;
                        }
                    }
                }
                System.out.println(up);
                if (up == 270) {
                    System.out.println("Entre al otro for perras");
                    for (int i = 270; i <= 370; i = i +10) {
                        image=2;
                        super.setImage(sprite.get(image));

                        super.setY(i);
                        Thread.sleep(120);
                        if (i == 370) {
                            image = 1;
                            super.setImage(sprite.get(image));
                            Thread.sleep(125);
                            up = 370;
                        }
                    }
                }

            } catch (InterruptedException ex) {
            }
        }
    }
}
