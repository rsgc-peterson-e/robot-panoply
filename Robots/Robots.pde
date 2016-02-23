void setup() {
  size(1000,700);
  background(255);
  EPRobot panoplyDemo = new EPRobot();
  for (int i = 0; i < 375; i += 125) { //draws the left 3 robots of the robot council
    panoplyDemo.drawAt(i, i + 100, 0.5, 0.5);
  }
  for (int j = 375; j < 1000; j += 125) {
    //panoplyDemo.drawAt(j, j - 100, 0.5, 0.5);
  }
}
