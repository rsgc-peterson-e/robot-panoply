int xOff = 25; //variable for x offset
int yOff = 550; //used in second for loop to to take care of incrimenting y variable
int yOff2 = 50; // second y variable for other loop
int scene = 0; //variable that will store what slide the user is on for the storytelling of Romeo and Juliet
int nextX = 920;
int nextY = 100;
int nextWidth = 60;
int nextHeight = 30;
int prevX = 20;
int prevY = 100;
int prevWidth = 60;
int prevHeight = 30;
int mainX = 15;
int mainY = 15;
int mainWidth = 120;
int mainHeight = 30;
float distance = 0.5;
PFont cursive; // will be used for special titles to add more the scene
PFont quicksand; //will be used as default font
EPRobot ethanBot = new EPRobot();
TMRobots timBot = new TMRobots();
KCRobot kernBot = new KCRobot();
OBRobot owenBot = new OBRobot();
BDRobot benBot = new BDRobot();
EPRobot2 ethanBot2 = new EPRobot2();


void setup() { //runs once
  size(1000, 700);
  cursive = createFont("cursive.ttf", 32); //create the font using the font file in the sketch folder
  quicksand = createFont("quicksand.otf", 32);
  background(255);
} // end of setup preparing the program to run correctly

void draw() {
  background(255); //clear background
  //draw next and prev scene buttons
  buttons();
  //draw robot council
  robotCouncil();
  //draw first scene as long as user has navigated to it
  scene1();
} // end of draw which loops all the functions below

void mouseClicked() { //runs every time mouse is clicked (pressed and released)
  if (mouseOverRect(nextX, nextY, nextWidth, nextHeight)) { //checks if mouse has been clicked while over the next button
    scene++;
  }
  if (mouseOverRect(prevX, prevY, prevWidth, prevHeight) && scene > 0) {
    scene--;
  }
  if (mouseOverRect(mainX, mainY, mainWidth, mainHeight)) {
    scene = 0;
  }
}

void robotCouncil() { // function draws a council of my robot in a porabola type from
  if (scene == 0) {
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
}

boolean mouseOverRect(int rectX, int rectY, int rectWidth, int rectHeight) { // boolean function returning true when the mouse is hovering over rectangle specified
  if (mouseX >= rectX && mouseX <= rectX + rectWidth && mouseY >= rectY && mouseY <= rectY + rectHeight) { // checks if the points mouseX and mouseY are within the rectangle and returns true
    return true;
  } else { // if the conditional above is not true than return false
    return false;
  }
}

void buttons() { //draws the next and prev buttons and listens for the mouse hovering over them
  fill(255);
  stroke(5);
  textFont(quicksand);
  rect(prevX, prevY, prevWidth, prevHeight); // previous scene button
  rect(nextX, nextY, nextWidth, nextHeight); // next scene button
  rect(mainX, mainY, mainWidth, mainHeight); // main slide button (takes user back to robot council)
  // add text to the rectangles creating the impression of a button
  textSize(20);
  fill(0);
  //add text to the buttons
  text("Next", nextX + 5, nextY + 20);
  text("Prev", prevX + 5, prevY + 20);
  text("Front Page", mainX + 5, mainY + 20);
  if (mouseOverRect(nextX, nextY, nextWidth, nextHeight)) { //check if mouse is over next button
    fill(209);
    rect(nextX, nextY, nextWidth, nextHeight); //draw new grey rect to make it seem as though the button turns grey when the mouse hovers over
    fill(0); //change text color to black
    //redraw text so it is not overlapped by new rect (the same process is replicated for the next few buttons)
    text("Next", nextX + 5, nextY + 20);
  }
  if (mouseOverRect(prevX, prevY, prevWidth, prevHeight)) { //check if mouse is over prev button
    fill(209);
    rect(prevX, prevY, prevWidth, prevHeight);
    fill(0);
    text("Prev", prevX + 5, prevY + 20);
  }
  if (mouseOverRect(mainX, mainY, mainWidth, mainHeight)) {
    fill(209);
    rect(mainX, mainY, mainWidth, mainHeight);
    fill(0);
    text("Front Page", mainX + 5, mainY + 20);
  }
} // end of buttons function

void scene1() {
  if (scene == 1) { // makes sure it is the first scene before drawing the scene so the wrong function is not used
    timBot.drawAt(230, 450, 1, 1); // Juliet
    owenBot.drawAt(-70, 400, 0.7, 0.7); // Father Capulet
    kernBot.drawAt(-75, 420, 0.7, 0.7); // Mother Capulet
    // draw text with cursive font
    textFont(cursive);
    fill(0); // set text to black
    text("The Capulets", 100, 300);
    text("Juliet", 292, 425);
    stroke(5);
    //draw montague family
    ethanBot2.drawAt2(350, 200, 0.7, 0.7); // Romeo
    ethanBot.drawAt(725, 350, 0.6, 0.6); // Father Montague
    benBot.drawAt(680, 375, 0.5, 0.5); // Mother Montague
  }
} // end of scene 1 function
