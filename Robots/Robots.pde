int xOff = 25; //variable for x offset
int yOff = 550; //used in second for loop to to take care of incrimenting y variable
int yOff2 = 50; // second y variable for other loop
int slide = 1; //variable that will store what slide the user is on for the storytelling of Romeo and Juliet
int counter = 1;
float distance = 0.5;
EPRobot ethanBot = new EPRobot();

void setup() { //runs once
  size(1000,700);
  background(255);
}

void draw() { //infinite loop
  slide1();
}

void slide1() { // Each slide will have its own function which will draw the correct content depending on what slide the user is on
  for (int i = 350; i > 125; i -= 75) { // left 3 bots of robot council
    distance = distance - 0.1;
    yOff = yOff - 125;
    ethanBot.drawAt(i - 75, yOff, distance, distance);
  }
  distance = 0;
  for (int j = 125; j < 500; j += 125) { // right 3 robots of the council
    distance = distance + 0.1;
    ethanBot.drawAt(xOff + 50 + (775 - j), (100 + j) - yOff2, 0.1 + distance, 0.1 + distance);
  }
  noLoop();
}
