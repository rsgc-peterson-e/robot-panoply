void setup() {
  size(1000,700);
  background(255);
  int xOff = 25; //variable for x offset
  int yOff = 475; //used in second for loop to to take care of incrimenting y variable
  int slide; //variable that will store what slide the user is on for the storytelling of Romeo and Juliet
  EPRobot ethanBot = new EPRobot();
  for (int i = 0; i < 375; i += 125) { //draws the left 3 robots of the council
    ethanBot.drawAt(xOff + i, i + 100, 0.5, 0.5);
  }
  for (int j = 400; j < 700; j += 125) { //draw right 3 robots of the council
    yOff = yOff - 125;
    ethanBot.drawAt(xOff + j, yOff, 0.5, 0.5);
  }
}
