class NTRobot {

  //Cpnstructor for class
  //MUST have name identical to name of the class
  void NTRobot() {
  }
  //To draw my robot at the specidied location
  void drawAt(int xAnchor, int yAnchor, float horizontalScale, float verticalScale) {

    // mark the spot where we should start drawing from
    fill(0);//Black
    ellipse(xAnchor + 200 * horizontalScale, yAnchor + 100 * verticalScale, 10, 10);


    rect(xAnchor + 200 * horizontalScale, yAnchor + 0 * verticalScale, 150*horizontalScale, 150*verticalScale);
    fill(0);
    ellipse(xAnchor + 270 * horizontalScale, yAnchor + 200* verticalScale, 200, 200);

    fill(0);
    rect(xAnchor + 170 * horizontalScale, yAnchor + 130* verticalScale, 200, 200);

    fill(0);
    ellipse(xAnchor + 240 * horizontalScale, yAnchor + 50* verticalScale, 50, 50);

    fill(255);
    ellipse(xAnchor + 240 * horizontalScale, yAnchor + 50* verticalScale, 50, 50);

    fill(0);
    ellipse(xAnchor + 310 * horizontalScale, yAnchor +  50* verticalScale, 50, 50);

    fill(255);
    ellipse(xAnchor + 310 * horizontalScale, yAnchor + 50* verticalScale, 50, 50);

    fill(0);
    ellipse(xAnchor + 200 * horizontalScale, yAnchor + 300* verticalScale, 200, 200);

    fill(0);
    ellipse(xAnchor + 330 * horizontalScale, yAnchor + 300* verticalScale, 200, 200);

    fill(255);
    rect(xAnchor + 180 * horizontalScale, yAnchor + 395* verticalScale, 50, 150);

    fill(255);
    rect(xAnchor + 300 * horizontalScale, yAnchor + 395* verticalScale, 50, 150);

    fill(255);
    rect(xAnchor + 170 * horizontalScale, yAnchor + 130* verticalScale, 200, 270);
  }
}