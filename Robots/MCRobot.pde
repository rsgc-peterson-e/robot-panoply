class MCRobot {
  void MCRobot() {
  }

  void drawAt(int x, int y, float xScale, float yScale) {

    fill(230); 
    //creat head
    ellipse(200*xScale+ x, 100*yScale+ y, 80*xScale, 80*yScale); 
    //creats body
    rect(150*xScale+ x, 100*yScale+ y, 100*xScale, 100*yScale);
    //creat left leg
    rect(150*xScale+ x, 200*yScale+ y, 20*xScale, 100*yScale);
    //creat right leg
    rect(230*xScale+ x, 200*yScale+ y, 20*xScale, 100*yScale);
    //creat left eye
    ellipse(185*xScale+ x, 80*yScale+ y, 10*xScale, 10*yScale);
    //creat right eye
    ellipse(215*xScale+ x, 80*yScale+ y, 10*xScale, 10*yScale);
    //creat left arm
    rect(50*xScale+ x, 100*yScale+ y, 100*xScale, 20*yScale); 
    //creat right arm
    rect( 250*xScale+ x, 100*yScale+ y, 100*xScale, 20*yScale);

    //// Draw head
    //fill(255);
    //ellipse(xAnchor + 200 * horizontalScale, yAnchor + 100 * verticalScale, 100 * horizontalScale, 100 * verticalScale);

    //// Draw vision bar (eye)
    //rectMode(CENTER);
    //fill(225);
    //rect(xAnchor + 200 * horizontalScale, yAnchor + 85 * verticalScale, 50 * horizontalScale, 15 * verticalScale);

    //// Draw body
    //fill(200);  // grey
    //arc(xAnchor + 200 * horizontalScale, yAnchor + 400 * verticalScale, 300 * horizontalScale, 600 * verticalScale, PI, TWO_PI);
    //fill(245);  // light grey
    //arc(xAnchor + 200 * horizontalScale, yAnchor + 400 * verticalScale, 300 * horizontalScale, 500 * verticalScale, PI, TWO_PI);

    //// Side wheels
    //fill(100); // darker grey
    //ellipse(xAnchor + 60 * horizontalScale, yAnchor + 350 * verticalScale, 100 * horizontalScale, 100 * verticalScale); 
    //ellipse(xAnchor + 340 * horizontalScale, yAnchor + 350 * verticalScale, 100 * horizontalScale, 100 * verticalScale);

    //// Complete body bottom
    //line(xAnchor + 60 * horizontalScale, yAnchor + 400 * verticalScale, xAnchor + 350 * horizontalScale, yAnchor + 400 * verticalScale); 

    //// Add "front and back" wheel
    //// (Back wheel is directly behind front wheel, so not visible when looking straight on)
    //rectMode(CENTER);
    //fill(100); // darker grey
    //rect(xAnchor + 200 * horizontalScale, yAnchor + 350 * verticalScale, 20 * horizontalScale, 100 * verticalScale);
    //rectMode(CORNER);

    //// Leg down to front wheel
    //fill(200);  // grey
    //noStroke();
    //quad(xAnchor + 185 * horizontalScale, yAnchor + 150 * verticalScale, xAnchor + 195 * horizontalScale, yAnchor + 300 * verticalScale, xAnchor + 205 * horizontalScale, yAnchor + 300 * verticalScale, xAnchor + 215 * horizontalScale, yAnchor + 150 * verticalScale);
    //strokeWeight(1);
    //stroke(0);
    //line(xAnchor + 185 * horizontalScale, yAnchor + 150 * verticalScale, xAnchor + 195 * horizontalScale, yAnchor + 300 * verticalScale); // left side
    //line(xAnchor + 205 * horizontalScale, yAnchor + 300 * verticalScale, xAnchor + 215 * horizontalScale, yAnchor + 150 * verticalScale); // right side
  }
}