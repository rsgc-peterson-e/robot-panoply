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
int mainX = 440;
int mainY = 15;
int mainWidth = 120;
int mainHeight = 30;
color highLight = color(209, 209, 209);
color black = color(0, 0, 0);
color white = color(255, 255, 255);
float distance = 0.5;
PFont cursive; // will be used for special titles to add more the scene
PFont quicksand; //will be used as default font
PImage bg1; // background for first scene
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
  bg1 = loadImage("verona.jpg");
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
  rect(mainX, mainY, mainWidth, mainHeight); // main slide button (takes user back to robot council) centered horizontally on the canvas
  // add text to the rectangles creating the impression of a button
  textSize(20);
  fill(black);
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
    fill(highLight);
    rect(mainX, mainY, mainWidth, mainHeight);
    fill(black);
    text("Front Page", mainX + 5, mainY + 20);
  }
} // end of buttons function

void scene1() {
  if (scene == 1) { // makes sure it is the first scene before drawing the scene so the wrong function is not used
    //draw background
    image(bg1, 0, 0);
    buttons();
    timBot.drawAt(230, 450, 1, 1); // Juliet
    owenBot.drawAt(-70, 400, 0.7, 0.7); // Father Capulet
    kernBot.drawAt(-75, 420, 0.7, 0.7); // Mother Capulet
    // draw text with cursive font
    textFont(cursive);
    fill(white); // set text to black
    text("The Capulets", 100, 300);
    text("Juliet", 292, 425);
    stroke(5);
    //draw montague family
    ethanBot2.drawAt2(350, 200, 0.7, 0.7); // Romeo
    ethanBot.drawAt(725, 360, 0.6, 0.6); // Father Montague
    benBot.drawAt(680, 375, 0.5, 0.5); // Mother Montague
    fill(white);
    text("The Montagues", 725, 300);
    text("Romeo", 660, 400);
    // draw text box to complete the first scene
    textBox("Two households, both alike in dignity, In fair Verona, where we lay our scene...", width/2, 150); //text will not be drawn because string is too long
    text("Two households, both alike in", width/2 - width/4 + 5, 125);
    text("dignity, In fair Verona, where", width/2 - width/4 + 5, 150);
    text("we lay our scene...", width/2 - width/4 + 5, 175);
  }
} // end of scene 1 function
//             text displayed | x-pos | y-pos
void textBox(String text, int textX, int textY) { // function to draw text box for storytelling
  stroke(5);
  textFont(quicksand);
  fill(highLight);
  rectMode(CENTER);
  rect(textX, textY, width/2, height/6);
  rectMode(CORNER);
  fill(255);
  stroke(5);
  if (textWidth(text) > width/2) {
    // do not display any text if the width of the text is larger than the box
    // the user will handle drawing the text manually (text scaling within the box may be implemented depending on the need)
  } else { //only display the text if it fits in the rectangle
    text(text, textX - textX/2 + 5, textY - 25);
  }
} // end of text box function
