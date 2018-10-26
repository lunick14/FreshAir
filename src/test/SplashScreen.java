/*
=================================================================================
MIT License

Copyright (c) 2018 Adrian D. Finlay, Lunick Dorcelus, Yunier Alvarez, Cheddae Grant, Adrian Silva

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

=================================================================================
**/

// package com.freshair;

import java.io.File;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Background;
import javafx.animation.FadeTransition;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundSize;

class SplashScreen {

  private SplashScreen() { }

  public static Stage render (double[] dimensions, Image ... img) {
    /* Splash Screen*/
    Stage splash = new Stage();

    //Add icon
    splash.getIcons().add(img[0]);

    //Root Node
    StackPane splashRootNode = new StackPane(new ImageView(img[1]));
    //Set a background image
    Background background = new Background(new BackgroundFill(Color.GAINSBORO, CornerRadii.EMPTY, Insets.EMPTY));

    //Background -> Root Node
    splashRootNode.setBackground(background);

    FadeTransition inAnim = new FadeTransition(Duration.seconds(1.5), splashRootNode);
    inAnim.setFromValue(0);
    inAnim.setToValue(1);
    inAnim.setCycleCount(1);

    FadeTransition outAnim = new FadeTransition(Duration.seconds(1.5), splashRootNode);
    outAnim.setFromValue(1);
    outAnim.setToValue(0);
    outAnim.setCycleCount(1);

    splash.setScene(new Scene(splashRootNode, 480, 615));

    inAnim.play();
    inAnim.setOnFinished((e) -> outAnim.play() );
    outAnim.setOnFinished((e) -> splash.close() );	

    return splash;
  }
}