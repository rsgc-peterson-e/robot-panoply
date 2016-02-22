class DHRobot {

  void DHRobot() {
  }
  //draw my robot at specified location
  void drawAt(int xAnchor, int yAnchor, float horizontalScale, float verticalScale ) {

    ////create head and body 
    //rotate(PI/3.0);
    fill(90);
    stroke(146);
    triangle(xAnchor + 100*horizontalScale, yAnchor + 100*verticalScale, xAnchor + 500*horizontalScale, yAnchor +100*verticalScale, xAnchor + 300*horizontalScale, yAnchor + 300*verticalScale);
    fill(146);
    rect(xAnchor + 200*horizontalScale, yAnchor + 200*verticalScale, horizontalScale * 200, verticalScale* 200);

    //create the feet 
    stroke(0);
    fill(0);
    triangle(xAnchor + 250*horizontalScale, yAnchor + 460*verticalScale, xAnchor + 210*horizontalScale, yAnchor +  525*verticalScale, xAnchor + 290*horizontalScale, yAnchor + 525*verticalScale);
    triangle(xAnchor + 350*horizontalScale, yAnchor + 460*verticalScale, xAnchor + 310*horizontalScale, yAnchor + 525*verticalScale, xAnchor + 390*horizontalScale, yAnchor + 525*verticalScale);
    fill(146);
    stroke(255);

    //create the eyes
    ellipse(xAnchor + 200*horizontalScale, yAnchor+ 110*verticalScale, 75*horizontalScale, 75*verticalScale);
    ellipse(xAnchor + 400*horizontalScale, yAnchor + 110*verticalScale, 75*horizontalScale, 75*verticalScale);
    fill(#2C11EA);
    ellipse(xAnchor + 200*horizontalScale, yAnchor + 100*verticalScale, 30*horizontalScale, 30*verticalScale);
    ellipse(xAnchor + 400*horizontalScale, yAnchor + 100*verticalScale, 30*horizontalScale, 30*verticalScale);
    fill(0);
    stroke(15);

    //create the legs
    rect(xAnchor + 225*horizontalScale, yAnchor +  400*verticalScale, 50*horizontalScale, 100*verticalScale);
    rect(xAnchor + 325*horizontalScale, yAnchor + 400*verticalScale, 50*horizontalScale, 100*verticalScale);
    fill(146);
    stroke(0);

    //create the arms
    ellipse(xAnchor + 80*horizontalScale, yAnchor + 250*verticalScale, 50*horizontalScale, 50*verticalScale);
    ellipse(xAnchor + 520*horizontalScale, yAnchor + 250*verticalScale, 50*horizontalScale, 50*verticalScale);
    stroke(146);
    rect(xAnchor + 95*horizontalScale, yAnchor + 225*verticalScale, 110*horizontalScale, 50*verticalScale);
    rect(xAnchor + 400*horizontalScale, yAnchor + 225*verticalScale, 105*horizontalScale, 50*verticalScale);
    fill(0);
    fill(0);
  }
}