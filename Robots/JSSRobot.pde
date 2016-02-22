class JSSRobot {

  void JSSRobot() {
  } 

  void drawAt (int x, int y, float horizontalScale, float verticalScale) {
    ellipse(x + (75* horizontalScale), y + (75* verticalScale), 80* horizontalScale, 80* verticalScale);
    rect(x + (73* horizontalScale), y + (115* verticalScale), 1* horizontalScale, 100* verticalScale);
    rect(x + (59* horizontalScale), y + (200* verticalScale), 34* horizontalScale, 80* verticalScale);
    rect(x + (59* horizontalScale), y + (280* verticalScale), 1* horizontalScale, 60* verticalScale);
    rect(x + (92* horizontalScale), y + (280* verticalScale), 1* horizontalScale, 60* verticalScale);
    fill(#0AC111);
    ellipse(x + (75* horizontalScale), y + (250* verticalScale), 10* horizontalScale, 10* verticalScale);
    fill(#D6F71E);
    ellipse(x + (75* horizontalScale), y + (235* verticalScale), 10* horizontalScale, 10* verticalScale);
    fill(#F7240C);
    ellipse(x + (75* horizontalScale), y + (220* verticalScale), 10* horizontalScale, 10* verticalScale);
    fill(0);
    rect(x + (92* horizontalScale), y + (9* verticalScale), 1* horizontalScale, 30* verticalScale);
    rect(x + (59* horizontalScale), y + (9* verticalScale), 1* horizontalScale, 30* verticalScale);
  }
}