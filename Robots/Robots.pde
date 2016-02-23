void setup() {
  size(1000,700);
  background(255);
  int xOff = 25; //variable for x offset
  int yOff = 475; //used in second for loop to to take care of incrimenting y variable
  EPRobot panoplyDemo = new EPRobot();
  for (int i = 0; i < 375; i += 125) { //draws the left 3 robots of the robot council
    panoplyDemo.drawAt(xOff + i, i + 100, 0.5, 0.5);
  }
  //panoplyDemo.drawAt(xOff + 400, 350, 0.5, 0.5); //use this robot as the basis for the right side of the council
  //panoplyDemo.drawAt(xOff + 525, 225, 0.5, 0.5);
  for (int j = 400; j < 700; j += 125) { //draw right side of the robot council
    yOff = yOff - 125;
    panoplyDemo.drawAt(xOff + j, yOff, 0.5, 0.5);
  }
}
