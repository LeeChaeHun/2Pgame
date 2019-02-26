package com.bliss.csc.spaceship;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

public class Spaceship2 {


    Bitmap imgSpaceship[] = new Bitmap[5];

    public int x, y;

    public Bitmap image;
    public int w, h;
    int imageNum;

    public Spaceship2(int x, int y) {

        this.x = x;
        this.y = y;
        Matrix matrix = new Matrix();

        for (int i = 0; i < 5; i++) {

            imgSpaceship[i] = BitmapFactory.decodeResource(SpaceshipGameView.context.getResources(), R.drawable.spaceship00 + i);
            int xWidth = SpaceshipGameView.Width / 5;
            int yWidth = xWidth;

            imgSpaceship[i] = Bitmap.createScaledBitmap(imgSpaceship[i], xWidth, yWidth, true);

        }

        w = imgSpaceship[0].getWidth() / 2;
        h = imgSpaceship[0].getHeight() / 2;
        matrix.preRotate(180f, w, h);

        for (int i = 0; i < 5; i++) {

            imgSpaceship[i] = Bitmap.createBitmap(imgSpaceship[i], 0, 0, w * 2, h * 2, matrix, true);
        }

        image = imgSpaceship[0];
    }


    public void moveSpaceship(boolean btnLeft, boolean btnRight, boolean btnMissile) {

        imageNum++;
        if (imageNum > 4) imageNum = 0;

        image = imgSpaceship[imageNum];

        if (btnLeft) {
            if (x==0){
                x=0;
            }
            else {
                x -= 4;
            }
        }

        if (btnRight) {


            if (x>SpaceshipGameView.Width-SpaceshipGameView.Width/5){
                x=SpaceshipGameView.Width-SpaceshipGameView.Width/5;
            }
            else {
                x += 4;
            }
        }

        if (btnMissile) {
            SpaceshipGameView.missileOk2 = 1;
        }
    }

}
