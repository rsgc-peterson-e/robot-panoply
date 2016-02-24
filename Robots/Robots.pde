int xOff = 25; //variable for x offset
int yOff = 550; //used in second for loop to to take care of incrimenting y variable
int yOff2 = 50; // second y variable for other loop
int scene = 0; //variable that will store what slide the user is on for the storytelling of Romeo and Juliet
int nextX = 920;
int nextY = 300;
int nextWidth = 60;
int nextHeight = 30;
int prevX = 20;
int prevY = 300;
int prevWidth = 60;
int prevHeight = 30;
float distance = 0.5;
EPRobot ethanBot = new EPRobot();
TMRobots timBot = new TMRobots();

void setup() { //runs once
  size(1000, 700);
  background(255);
}

void draw() {
  background(255); //clear background
  //draw next and prev scene buttons
  buttons();
  //draw robot council
  robotCouncil();
}

void mouseClicked() { //runs every time mouse is clicked (pressed and released)

}

void robotCouncil() { // function draws a council of my robot in a porabola type from
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
  distance = 0.5; //reset variable values so the function can be looped infinitely
  yOff = 550;
}

boolean mouseOverRect(int rectX, int rectY, int rectWidth, int rectHeight) {
  if (mouseX >= rectX && mouseX <= rectX + rectWidth && mouseY >= rectY && mouseY <= rectY + rectHeight) {
    return true;
  }else{
    return false;
  }
}

void buttons() { //draws the next and prev buttons and listens for the mouse hovering over them
  fill(255);
  rect(prevX, prevY, prevWidth, prevHeight); // previous scene button
  rect(nextX, nextY, nextWidth, nextHeight); // next scene button
  // add text to the rectangles creating the impression of a button
  textSize(20);
  fill(0);
  //add text to the buttons
  text("Next", nextX + 5, nextY + 20);
  text("Prev", prevX + 5, prevY + 20);
  if (mouseOverRect(nextX, nextY, nextWidth, nextHeight)) { //check if mouse is over next button
    fill(209);
    rect(nextX, nextY, nextWidth, nextHeight); //draw new grey rect to make it seem as though the button turns grey when the mouse hovers over
    fill(0); //change text color to black
    //redraw text so it is not overlapped by new rect
    text("Next", nextX + 5, nextY + 20);

  }
  if (mouseOverRect(prevX, prevY, prevWidth, prevHeight)) { //check if mouse is over prev button
    fill(209);
    rect(prevX, prevY, prevWidth, prevHeight);
    fill(0);
    text("Prev", prevX + 5, prevY + 20);
  }
}

void scene1() {
  timBot.drawAt(25, 300, 1, 1);
}
