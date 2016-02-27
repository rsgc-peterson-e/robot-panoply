import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Robots extends PApplet {

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
int highLight = color(209, 209, 209);
int black = color(0, 0, 0);
int white = color(255, 255, 255);
float distance = 0.5f;
PFont cursive; // will be used for special titles to add more the scene
PFont quicksand; //will be used as default font
PImage hearts; // image used to demonstrate Romeo and Juliet falling in love
PImage brokenHeart;
PImage poison;
PImage dagger;
PImage bg1; // background for first scene etc.
PImage bg2;
PImage bg3;
PImage bg4;
EPRobot ethanBot = new EPRobot();
TMRobots timBot = new TMRobots();
KCRobot kernBot = new KCRobot();
OBRobot owenBot = new OBRobot();
BDRobot benBot = new BDRobot();
EPRobot2 ethanBot2 = new EPRobot2();


public void setup() { //runs once
  
  cursive = createFont("cursive.ttf", 32); //create the font using the font file in the sketch folder
  quicksand = createFont("quicksand.otf", 32);
  hearts = loadImage("hearts.png");
  brokenHeart = loadImage("heart_broken.png");
  brokenHeart.resize(128, 128);
  poison = loadImage("poison.png");
  poison.resize(65, 116);
  dagger = loadImage("dagger.png");
  dagger.resize(42, 145);
  bg2 = loadImage("ballroom.jpg");
  bg2.resize(1000, 700);
  bg3 = loadImage("cemetery.jpg");
  bg4 = loadImage("shakespeare.jpg");
  bg4.resize(1000, 900);
  hearts.resize(150, 125); // resize the image to allow it to fit the canvas properly
  bg1 = loadImage("verona.jpg");
  background(255);
} // end of setup preparing the program to run correctly

public void draw() {
  background(255); //clear background
  //draw next and prev scene buttons
  buttons();
  //draw robot council
  robotCouncil();
  //draw first scene as long as user has navigated to it
  scene1();
  // draw second scene as long as user has navigated to it
  scene2();
  // draw third scene
  scene3();
  // draw fourth scene
  scene4();
} // end of draw which loops all the functions below

public void mouseClicked() { //runs every time mouse is clicked (pressed and released)
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

public void robotCouncil() { // function draws a council of my robot in a porabola type from
  if (scene == 0) {
    for (int i = 350; i > 125; i -= 75) { // left 3 bots of robot council
      distance = distance - 0.1f;
      yOff = yOff - 125;
      ethanBot.drawAt(i - 75, yOff, distance, distance);
    }
    distance = 0;
    for (int j = 125; j < 500; j += 125) { // right 3 robots of the council
      distance = distance + 0.1f;
      ethanBot.drawAt(xOff + 50 + (775 - j), (100 + j) - yOff2, 0.1f + distance, 0.1f + distance);
    }
    distance = 0.5f; //reset variable values so the function can be looped infinitely
    yOff = 550;
  }
}

public boolean mouseOverRect(int rectX, int rectY, int rectWidth, int rectHeight) { // boolean function returning true when the mouse is hovering over rectangle specified
  if (mouseX >= rectX && mouseX <= rectX + rectWidth && mouseY >= rectY && mouseY <= rectY + rectHeight) { // checks if the points mouseX and mouseY are within the rectangle and returns true
    return true;
  } else { // if the conditional above is not true than return false
    return false;
  }
}

public void buttons() { //draws the next and prev buttons and listens for the mouse hovering over them
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

//             text displayed | x-pos | y-pos
public void textBox(String text, int textX, int textY) { // function to draw text box for storytelling
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

public void scene1() {
  if (scene == 1) { // makes sure it is the first scene before drawing the scene so the wrong function is not used
    //draw background
    image(bg1, 0, 0);
    buttons();
    timBot.drawAt(230, 450, 1, 1); // Juliet
    owenBot.drawAt(-70, 400, 0.7f, 0.7f); // Father Capulet
    kernBot.drawAt(-75, 420, 0.7f, 0.7f); // Mother Capulet
    // draw text with cursive font
    textFont(cursive);
    fill(white); // set text to black
    text("The Capulets", 100, 300);
    text("Juliet", 292, 425);
    stroke(5);
    //draw montague family
    ethanBot2.drawAt2(350, 200, 0.7f, 0.7f); // Romeo
    ethanBot.drawAt(725, 358, 0.6f, 0.6f); // Father Montague
    benBot.drawAt(680, 375, 0.5f, 0.5f); // Mother Montague
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

public void scene2() {
  if (scene == 2) {
    image(bg2,0,0);
    image(hearts, 425, 300);
    ethanBot2.drawAt2(140, 0, 1, 1);
    timBot.drawAt(150, 325, 1.5f, 1.5f);
    textBox("Romeo and Juliet meet at a Capulet party and fall in love...", width/2, 150); // text will also not be shown because the string is too long
    text("Romeo and Juliet meet at a", width/2 - width/4 + 5, 125);
    text("Capulet party and fall in love...", width/2 - width/4 + 5, 150);
    buttons();
  }
} // end of scene 2 function

public void scene3() {
  if (scene == 3) {
    image(bg3, 0,0);
    buttons();
    ethanBot2.drawAt2(140, 0, 1, 1);
    timBot.drawAt(150, 325, 1.5f, 1.5f);
    image(brokenHeart, 500 - 64, 300);
    image(poison, 680, 410);
    image(dagger, 150, 515);
    textBox("Romeo takes his life believing Juliet is dead, when Juliet awakes she realizes Romeo is dead and takes her own life as well", width/2, 150);
    fill(highLight);
    rectMode(CENTER);
    rect(width/2, 150, width/2, height/4);
    rectMode(CORNER);
    fill(white);
    text("Romeo takes his life believing", width/2 - width/4 + 5, 100);
    text("Juliet is dead, when Juliet", width/2 - width/4 + 5, 125);
    text("awakes she realizes Romeo is", width/2 - width/4 + 5, 150);
    text("dead and takes her own life", width/2 - width/4 + 5, 175);
    text("as well using Romeo's dagger.", width/2 - width/4 + 5, 200);
  }
} // end of scene 3 function

public void scene4() {
  if (scene == 4) {
    image(bg4, 0, -50);
    buttons();
    textFont(cursive);
    fill(white);
    textSize(64);
    text("The End", width/2 - textWidth("The End")/2 - 20, 115);
    textFont(quicksand);
  }
} // end of scene 4 function
class ASPRobot { 
  public void ASPRobot() {
  }

  //Draw At
  public void drawAt(int x, int y, float horizontalScale, float verticalScale) {
    //body
    strokeWeight(2);
    fill(100);
    ellipse((300+x)*horizontalScale, (400+y)*verticalScale, horizontalScale*400, verticalScale*400);

//head
    fill(255);
    ellipse((300+y)*horizontalScale, (150+y)*verticalScale, horizontalScale*150, verticalScale*150);

 //antenae
    line((x+356)*horizontalScale, (y+100)*verticalScale, (x+356)*horizontalScale, (y+80)*verticalScale);
    line((x+350)*horizontalScale, (y+94)*verticalScale, (x+350)*horizontalScale, (y+60)*verticalScale);

//left eye
    fill(20);
    ellipse((x+275)*horizontalScale, (y+130)*verticalScale, 20*horizontalScale, 25*verticalScale);

 //right eye
    fill(20);
    ellipse((x+325)*horizontalScale, (y+130)*verticalScale, 20*horizontalScale, 25*verticalScale);

//nose
    triangle((x+300)*horizontalScale, (y+140)*verticalScale, (x+290)*horizontalScale, (y+160)*verticalScale, (x+310)*horizontalScale, (y+160)*verticalScale);

    //left Arm
    line((x+127)*horizontalScale, (y+300)*verticalScale, (x+100)*horizontalScale, (y+250)*verticalScale); //left arm
    line((x+100)*horizontalScale, (y+250)*verticalScale, (x+110)*horizontalScale, (y+238)*verticalScale); //left arm finer right
    line((x+100)*horizontalScale, (y+250)*verticalScale, (x+90)*horizontalScale, (y+238)*verticalScale); //left arm finger left
    line((x+100)*horizontalScale, (y+250)*verticalScale, (x+100)*horizontalScale, (y+234)*verticalScale); //left arm finger middle

    //right arm
    line((x+474)*horizontalScale, (y+300)*verticalScale, (x+500)*horizontalScale, (y+250)*verticalScale); //right arm
    line((x+500)*horizontalScale, (y+250)*verticalScale, (x+490)*horizontalScale, (y+238)*verticalScale); //right arm finger left
    line((x+500)*horizontalScale, (y+250)*verticalScale, (x+510)*horizontalScale, (y+238)*verticalScale); //right arm finger right
    line((x+500)*horizontalScale, (y+250)*verticalScale, (x+500)*horizontalScale, (y+234)*verticalScale); //right arm finger middle

    //details on body

    fill(50);
    ellipse((x+300)*horizontalScale, (y+400)*verticalScale, 300*horizontalScale, 300*verticalScale); //black circle

    stroke(255);
    fill(255);
    ellipse((x+250)*horizontalScale, (y+300)*verticalScale, 50*horizontalScale, 50*verticalScale); //circle top left white
    ellipse((x+350)*horizontalScale, (y+500)*verticalScale, 50*horizontalScale, 50*verticalScale); //circle bottom right white

    stroke (50);
    fill(5);
    ellipse((x+250)*horizontalScale, (y+300)*verticalScale, 10*horizontalScale, 25*verticalScale); //circle top left black
    ellipse((x+350)*horizontalScale, (y+500)*verticalScale, 10*horizontalScale, 25*verticalScale); //circle bottom right black

    stroke(255);
    line((x+250)*horizontalScale, (y+325)*verticalScale, (x+350)*horizontalScale, (y+472)*verticalScale); //connecting line
  }
}
class BDRobot {

  public void BDRobot() {
  }

  //void drawAt will draw the robot at the specified location
  //xAnchor - horizotal anchor for where the robot is drawn
  //yAnchor - vertical anchor for where the robot is drawn
  public void drawAt(int xAnchor, int yAnchor, float horizontalScale, float verticalScale) {
    noStroke();
    //moon
    //fill(140);
    //ellipse(300, 800, 900, 600);
    //strokeWeight(2);
    //fill(90);
    //ellipse(xAnchor * horizontalScale + 150, yAnchor * verticalScale + 600, 150, 80);
    //ellipse (xAnchor * horizontalScale + 400, yAnchor * verticalScale + 680, 150, 80);
    //ellipse(xAnchor * horizontalScale + 600, yAnchor * verticalScale + 640, 150, 80);
    fill(169);
    rect(xAnchor + 200 * horizontalScale, yAnchor + 200 * verticalScale, 200 * horizontalScale, 150 * verticalScale);
    fill(130);
    ellipse(xAnchor + 250 * horizontalScale, yAnchor + 240 * verticalScale, 20 * horizontalScale, 20 * verticalScale);
    ellipse(xAnchor + 352 * horizontalScale, yAnchor + 240 * verticalScale, 20 * horizontalScale, 20 * verticalScale);
    stroke(130);
    strokeWeight(5);
    noStroke();
    fill(0xff00CE9C);
    arc(xAnchor + 300 * horizontalScale, yAnchor + 200 * verticalScale, 130 * horizontalScale, 120 * verticalScale, radians(180), radians(360));
    fill(169);
    rect(xAnchor + 200 * horizontalScale, yAnchor + 140 * verticalScale, 10 * verticalScale, 70 * horizontalScale);
    fill(0xff00CE9C);
    ellipse(xAnchor + 205 * horizontalScale, yAnchor + 135 * verticalScale, 20 * horizontalScale, 20 * verticalScale);
    fill(169);
    rect(xAnchor + 390 * horizontalScale, yAnchor + 140 * verticalScale, 10 * horizontalScale, 70 * verticalScale);
    fill(0xff00CE9C);
    ellipse(xAnchor + 395 * horizontalScale, yAnchor + 140 * verticalScale, 20 * horizontalScale, 20 * verticalScale);
    fill(0xff01272C);
    ellipse(xAnchor + 303.5f * horizontalScale, yAnchor + 575 * verticalScale, 110 * horizontalScale, 110 * verticalScale);
    fill(169);
    rect(xAnchor + 230 * horizontalScale, yAnchor + 350 * verticalScale, 143.5f * horizontalScale, 240 * verticalScale);
    stroke(130);
    strokeWeight(4);
    rect(xAnchor + 245 * horizontalScale, yAnchor + 370 * verticalScale, 113.5f * horizontalScale, 150 * verticalScale);
    noStroke();
    fill(130);
    ellipse(xAnchor + 345.5f * horizontalScale, yAnchor + 440 * verticalScale, 20 * horizontalScale, 20 * verticalScale);
    strokeWeight(1);
  }
}
class DDRobot {

  public void DDRobot() {
  }

  public void drawAt(int x, int y) {

    //This Robot is BB8

    noStroke();

    //d= distance between the 2 bots
    //default 300
    //

    float d = displayWidth/4.5f;

    //Sketch Resolution Scaler
    //MASSIVE SCALING ISSUES
    //W.I.P

    float r = 1;

    //Scale of bots
    scale(1 * r);

    //Lighting, robot bloom effects
    //slightly fiddly, blur broken between layers
    //(W.I.P)

    //lightBB
    fill(245);
    arc(x + 300, y + 270, 185, 185, -PI, 0);  // upper half of circle



    //Background Blur
    //moved passed shadow

    //BB8Shadow
    //Out of frame usually, still properly implimented

    fill(0xffB7AA85);
    ellipse(x+ 300, y+ 550, 250, 80 );
    fill(0xff8B836C);
    ellipse(x+ 300, y+ 550, 230, 40 );

    fill(0xff746C55);
    ellipse(x+ 300, y+ 550, 200, 20 );

    fill(0xff393427);
    ellipse(x+ 300, y+ 545, 110, 10 );



    filter( BLUR, 4 );

    //ROBOT 1 (BB8) Left

    //BB8antenna
    fill(50);
    rect(x+ 325, y+ 160, 2, 40 );
    fill(50);
    rect(x+ 335, y+ 155, 3, 60 );


    //body
    //shading should get proggressively darker
    fill(250);
    ellipse(x+ 300, y+ 400, 300, 300 ); //1st ring (lightest)
    //ellipse(300, 400, 300, 300);
    fill(248);
    ellipse(x+ 300, y+ 400, 280, 280 ); //2nd ring
    fill(245);
    ellipse(x+ 300, y+ 400, 270, 270 ); //3rd ring (middle)
    fill(242);
    ellipse(x+ 300, y+ 400, 240, 240 ); //4th ring
    fill(239);
    ellipse(x+ 300, y+ 400, 230, 230 ); //5th ring (darkest

    //Head
    fill(245);
    arc(x+ 300, y+ 270, 185, 185, -PI, 0);  // 1st arc (lighter)
    fill(240);
    arc(x+ 300, y+ 270, 170, 170, -PI, 0);  // 2nd arc (darker)
    fill(100);
    arc(x+ 300, y+ 270, 175, 10, 0, PI, 0); // under arc (dark)

    //coloreyering
    fill(0xffFC7303); //Orange ring
    ellipse(x+ 300, y+ 215, 50, 50);

    //eye
    fill(0); //black eye
    ellipse(x+ 300, y+ 215, 40, 40);

    //eyereflection
    fill(120);
    ellipse(x+ 295, y+ 210, 20, 15); //1st reflection ellipse (darker)
    fill(150);
    ellipse(x+ 292, y+ 209, 10, 5); //2nd reflection ellipse (lighter)

    //indicator light ring
    fill(120);
    ellipse(x+ 340, y+ 230, 20, 20); //grey ring around black indicator

    //indicator light
    fill(0); //black indicator
    ellipse(x+ 340, y+ 230, 15, 15);

    //indicator reflection
    fill(150);
    ellipse(x+ 339, y+ 229, 6, 4); //reflection inside black indicator

    noStroke();

    //centredot
    fill(0xffFC7303); //orange accent 1 (outer)
    ellipse(x+ 300, y+ 400, 200, 200);
    fill(240); //white separator
    ellipse(x+ 300, y+ 400, 180, 180);
    fill(0xffFC7303); //orange accent 2 (inner)
    ellipse(x+ 300, y+ 400, 140, 140);
    fill(240); //1st ring

    //redundant
    //enable if issues seen with ring
    ellipse(x+ 300, y+ 400, 110, 110);
    fill(150);
    ellipse(x+ 300, y+ 400, 90, 90);
    fill(220);
    ellipse(x+ 300, y+ 400, 80, 80);
    fill(190);
  }
}
class DHRobot {

  public void DHRobot() {
  }
  //draw my robot at specified location
  public void drawAt(int xAnchor, int yAnchor, float horizontalScale, float verticalScale ) {

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
    fill(0xff2C11EA);
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
class EPRobot {
//integers to store values for the rectangle making up the robots torso
   float tx = 195;
   float ty = 100;
   float tWidth = 200;
   float tHeight = 300;
   //ints for cordinates of the robots head
   float hx = tx + tWidth/2 + 5;
   float hy = 152;
   float hDiameter = 75;
   //ints for eye cordinates
   float ex = 280;
   float ey = 55;
   float eDiameter = 15;
   //ints for mouth
   float mx = 275;
   float my = 70;
   float mWidth = 50;
   float mHeight = 10;
   // ints for arms
   float ax = 165;
   float ay = 125;
   float aWidth = 30;
   float aHeight = 240;
   //ints for legs
   float lx = tx + aWidth + 83;
   float ly = ty + tHeight;
   float lWidth = tWidth/4;
   float lHeight = tHeight/2;
   //ints for feet
   float fx = lx + lWidth/2;
   float fy = ly + lHeight + lWidth/2 - 10;
   float fDiamter = lWidth;


 public void EPRobot() {/* Nothing to construct */}

   public void drawAt(int x, int y, float horizontalScale, float verticalScale) {
    fill(255, 0, 213);
    //draw cape at the beginning to layer it behind the other shapes
    rect(x + tx*horizontalScale, y + ty*verticalScale, tWidth*horizontalScale, (tHeight*2 - lHeight)*verticalScale);
    fill(255);
    rect(x + (tx*horizontalScale), y + (ty * verticalScale), tWidth*horizontalScale, tHeight*verticalScale);
    ellipse(x + hx*horizontalScale, y + (hy - 90)*verticalScale, hDiameter*horizontalScale, hDiameter*verticalScale);
    fill(0); //make eyes for the robot that will be the color black
    ellipse(x + ex*horizontalScale, y + ey*verticalScale, eDiameter*horizontalScale, eDiameter*verticalScale);
    // draw other eye
    ellipse(x + (ex + 40)*horizontalScale, y + ey*verticalScale, eDiameter*horizontalScale, eDiameter*verticalScale);
    //draw mouth
    fill(209);
    rect(x + mx*horizontalScale, y + my*verticalScale, mWidth*horizontalScale, mHeight*verticalScale);
    // draw lines in the mouth creating the old school boxy robot look
    line(x + (mx + 8)*horizontalScale,  y + my*horizontalScale, x + (mx + 8)*horizontalScale, y + (my + mHeight)*verticalScale);
    line(x + (mx + 12)*horizontalScale, y + my*verticalScale, x +(mx + 12)*horizontalScale, y + (my + mHeight)*verticalScale);
    line(x + (mx + 16)*horizontalScale, y + my*verticalScale, x + (mx + 16)*horizontalScale, y + (my + mHeight)*verticalScale);
    line(x + (mx + 20)*horizontalScale, y + my*verticalScale, x + (mx + 20)*horizontalScale, y + (my + mHeight)*verticalScale);
    line(x + (mx + 24)*horizontalScale, y + my*verticalScale, x + (mx + 24)*horizontalScale, y + (my + mHeight)*verticalScale);
    line(x + (mx + 28)*horizontalScale, y + my*verticalScale, x + (mx + 28)*horizontalScale, y + (my + mHeight)*verticalScale);
    line(x + (mx + 32)*horizontalScale, y + my*verticalScale, x + (mx + 32)*horizontalScale, y + (my + mHeight)*verticalScale);
    line(x + (mx + 36)*horizontalScale, y + my*verticalScale, x + (mx + 36)*horizontalScale, y + (my + mHeight)*verticalScale);
    line(x + (mx + 40)*horizontalScale, y + my*verticalScale, x + (mx + 40)*horizontalScale, y + (my + mHeight)*verticalScale);
    line(x + (mx + 44)*horizontalScale, y + my*verticalScale, x + (mx + 44)*horizontalScale, y + (my + mHeight)*verticalScale);
    //draw arms
    fill(209);
    rect(x + ax*horizontalScale, y + (ay - 5)*verticalScale, aWidth*horizontalScale, aHeight*verticalScale); // left arm
    rect(x + (ax + aWidth + tWidth)*horizontalScale, y + (ay - 5)*verticalScale, aWidth*horizontalScale, aHeight*verticalScale); // right Arm
    // draw Iron Man type circle in the middle
    fill(255, 174, 0);
    ellipse(x + (tx + tWidth/2)*horizontalScale, y + (ty + 50)*verticalScale, (hDiameter - 25)*horizontalScale, (hDiameter - 25)*verticalScale);
    ellipse(x + (tx + tWidth/2 - 65)*horizontalScale, y + (ty + 50)*verticalScale, (hDiameter/2 - 10)*horizontalScale, (hDiameter/2 - 10)*verticalScale);
    ellipse(x + (tx + tWidth/2 + 65)*horizontalScale, y + (ty + 50)*verticalScale, (hDiameter/2 - 10)*horizontalScale, (hDiameter/2 - 10)*verticalScale);
    //draw feet
    ellipse(x + fx*horizontalScale, y + fy*verticalScale, fDiamter*horizontalScale, fDiamter*verticalScale);
    noStroke();
    fill(255);
    rect(x + (fx - fDiamter)*horizontalScale, y + (ly + lHeight + 22)*verticalScale, hDiameter*horizontalScale, hDiameter*verticalScale);
    fill(0);
    stroke(5);
    line(x + (fx - fDiamter + 26)*horizontalScale, y + (ly + lHeight + 22)*verticalScale, x + (fx - fDiamter + 24 + fDiamter)*horizontalScale, y + (ly + lHeight + 22)*verticalScale); //draw line where the rect overlaps circle to give the impression of a semicircle with a stroke around it
    // draw left foot
    fill(255, 174, 0);
    ellipse(x + (fx - 75)*horizontalScale, y + (ly + lHeight + fDiamter/2 - 10)*verticalScale, fDiamter*horizontalScale, fDiamter*verticalScale);
    fill(255);
    noStroke();
    rect(x + (fx - 75 - fDiamter)*horizontalScale, y + (ly + lHeight + fDiamter/2 - 3)*verticalScale, (hDiameter + 3)*horizontalScale, fDiamter*verticalScale);
    stroke(5);
    fill(0);
    line(x + (fx - 100)*horizontalScale, y + (ly + lHeight + fDiamter/2 - 4)*verticalScale, x + (fx - 50)*horizontalScale, y + (ly + lHeight + fDiamter/2 - 4)*verticalScale);
    //draw legs
    stroke(5);
    fill(209);
    rect(x + lx*horizontalScale, y + ly*verticalScale, (tWidth/4)*horizontalScale, (tHeight/2)*verticalScale); //left leg
    rect(x + (lx - aWidth - 45)*horizontalScale,  y + ly*verticalScale, lWidth*horizontalScale, lHeight*verticalScale); //right leg
    //draw shoulders
    fill(255, 0, 213);
    triangle(x + (ax + aWidth)*horizontalScale, y + (ty + aWidth)*verticalScale, x + (tx + tWidth/4)*horizontalScale, y + ty*verticalScale, x + tx*horizontalScale,  y + ty*verticalScale); //left
    triangle(x + (tx + tWidth)*horizontalScale, y + ty*verticalScale, x + (tx + tWidth)*horizontalScale, y + ay*verticalScale, x + (tx + tWidth - tWidth/4)*horizontalScale,  y + ty*verticalScale); //right
   }
}
class EPRobot2 {
public void EPRobot2() {/*Nothing to Construct*/}

public void drawAt2(int cx, int cy, float cHorizontal, float cVertical) { //function drawing circlular bot
  //draw head
  stroke(5);
  fill(255);
  ellipse(cx + (width/2)*cHorizontal, cy + (height/2)*cVertical, 100*cHorizontal, 100*cVertical);
  //draw eyes
  fill(0);
  ellipse(cx + (width/2 + 5) * cHorizontal, cy + (height/2)*cVertical, 25*cHorizontal, 25*cVertical);
  //draw mouth
  fill(209,209,209);
  rectMode(CENTER);
  rect(cx + (width/2)*cHorizontal, cy + (height/2 + 30)*cVertical, 50*cHorizontal, 10*cVertical);
  rectMode(CORNER);
  //draw BB8 style body
  fill(255);
  ellipse(cx + (width/2)*cHorizontal, cy + (height/2 + 200)*cVertical, 300*cHorizontal, 300*cVertical);
  fill(0);
  //draw orange spots like on bb8
  fill(255,179,0);
  ellipse(cx + (width/2)*cHorizontal, cy + (height/2 + 120)*cVertical, 100*cHorizontal, 100*cVertical);
  ellipse(cx + (width/2 + 80)*cHorizontal, cy + (height/2 + 220)*cVertical, 100*cHorizontal, 100*cVertical);
  ellipse(cx + (width/2 - 80)*cHorizontal, cy + (height/2 + 220)*cVertical, 100*cHorizontal, 100*cVertical);
  }
}
class JSSRobot {

  public void JSSRobot() {
  } 

  public void drawAt (int x, int y, float horizontalScale, float verticalScale) {
    ellipse(x + (75* horizontalScale), y + (75* verticalScale), 80* horizontalScale, 80* verticalScale);
    rect(x + (73* horizontalScale), y + (115* verticalScale), 1* horizontalScale, 100* verticalScale);
    rect(x + (59* horizontalScale), y + (200* verticalScale), 34* horizontalScale, 80* verticalScale);
    rect(x + (59* horizontalScale), y + (280* verticalScale), 1* horizontalScale, 60* verticalScale);
    rect(x + (92* horizontalScale), y + (280* verticalScale), 1* horizontalScale, 60* verticalScale);
    fill(0xff0AC111);
    ellipse(x + (75* horizontalScale), y + (250* verticalScale), 10* horizontalScale, 10* verticalScale);
    fill(0xffD6F71E);
    ellipse(x + (75* horizontalScale), y + (235* verticalScale), 10* horizontalScale, 10* verticalScale);
    fill(0xffF7240C);
    ellipse(x + (75* horizontalScale), y + (220* verticalScale), 10* horizontalScale, 10* verticalScale);
    fill(0);
    rect(x + (92* horizontalScale), y + (9* verticalScale), 1* horizontalScale, 30* verticalScale);
    rect(x + (59* horizontalScale), y + (9* verticalScale), 1* horizontalScale, 30* verticalScale);
  }
}
//Makes function run once
class KCRobot {
  public void KCRobot () {
  } 

  //Let x be xAnchor
  //Let y be yAnchor
  //Let b be horizontalShift
  //Let a be verticalShift
  //draw robot at specified location
  public void drawAt(int x, int y, float b, float a) {
    noStroke(); 

    //green rectangle
    fill(0, 255, 0); 
    rect(x+(200*b), y+(200*a), b*200, a*200);

    //blue rectangle
    fill(0, 0, 255); 
    rect(x+(275*b), y+(100*a), b*50, a*100);

    //red rectangle
    fill(255, 0, 0); 
    rect(x+(210*b), y+(100*a), 180*b, a*25);

    //yellow circle
    fill(255, 255, 0 ); 
    ellipse(x+(210*b), y+(113*a), b*50, a*50);

    //yellow circle
    ellipse(x+(390*b), y+(113*a), b*50, a*50);


    //blue circle
    fill(0, 255, 255); 
    ellipse(x+(220*b), y+(120*a), (b*25), a*25);

    //blue circle
    ellipse(x+(380*b), y+(120*a), b*25, a*25);

    //violet rectangle
  }
}
class MCRobot {
  public void MCRobot() {
  }

  public void drawAt(int x, int y, float xScale, float yScale) {

    fill(230); 
    //creat head
    ellipse(200*xScale+ x, 100*yScale+ y, 80*xScale, 80*yScale); 
    //creats body
    rect(150*xScale+ x, 100*yScale+ y, 100*xScale, 100*yScale);
    //creat left leg
    rect(150*xScale+ x, 200*yScale+ y, 20*xScale, 100*yScale);
    //creat right leg
    rect(230*xScale+ x, 200*yScale+ y, 20*xScale, 100*yScale);
    //creat left eye
    ellipse(185*xScale+ x, 80*yScale+ y, 10*xScale, 10*yScale);
    //creat right eye
    ellipse(215*xScale+ x, 80*yScale+ y, 10*xScale, 10*yScale);
    //creat left arm
    rect(50*xScale+ x, 100*yScale+ y, 100*xScale, 20*yScale); 
    //creat right arm
    rect( 250*xScale+ x, 100*yScale+ y, 100*xScale, 20*yScale);

    //// Draw head
    //fill(255);
    //ellipse(xAnchor + 200 * horizontalScale, yAnchor + 100 * verticalScale, 100 * horizontalScale, 100 * verticalScale);

    //// Draw vision bar (eye)
    //rectMode(CENTER);
    //fill(225);
    //rect(xAnchor + 200 * horizontalScale, yAnchor + 85 * verticalScale, 50 * horizontalScale, 15 * verticalScale);

    //// Draw body
    //fill(200);  // grey
    //arc(xAnchor + 200 * horizontalScale, yAnchor + 400 * verticalScale, 300 * horizontalScale, 600 * verticalScale, PI, TWO_PI);
    //fill(245);  // light grey
    //arc(xAnchor + 200 * horizontalScale, yAnchor + 400 * verticalScale, 300 * horizontalScale, 500 * verticalScale, PI, TWO_PI);

    //// Side wheels
    //fill(100); // darker grey
    //ellipse(xAnchor + 60 * horizontalScale, yAnchor + 350 * verticalScale, 100 * horizontalScale, 100 * verticalScale); 
    //ellipse(xAnchor + 340 * horizontalScale, yAnchor + 350 * verticalScale, 100 * horizontalScale, 100 * verticalScale);

    //// Complete body bottom
    //line(xAnchor + 60 * horizontalScale, yAnchor + 400 * verticalScale, xAnchor + 350 * horizontalScale, yAnchor + 400 * verticalScale); 

    //// Add "front and back" wheel
    //// (Back wheel is directly behind front wheel, so not visible when looking straight on)
    //rectMode(CENTER);
    //fill(100); // darker grey
    //rect(xAnchor + 200 * horizontalScale, yAnchor + 350 * verticalScale, 20 * horizontalScale, 100 * verticalScale);
    //rectMode(CORNER);

    //// Leg down to front wheel
    //fill(200);  // grey
    //noStroke();
    //quad(xAnchor + 185 * horizontalScale, yAnchor + 150 * verticalScale, xAnchor + 195 * horizontalScale, yAnchor + 300 * verticalScale, xAnchor + 205 * horizontalScale, yAnchor + 300 * verticalScale, xAnchor + 215 * horizontalScale, yAnchor + 150 * verticalScale);
    //strokeWeight(1);
    //stroke(0);
    //line(xAnchor + 185 * horizontalScale, yAnchor + 150 * verticalScale, xAnchor + 195 * horizontalScale, yAnchor + 300 * verticalScale); // left side
    //line(xAnchor + 205 * horizontalScale, yAnchor + 300 * verticalScale, xAnchor + 215 * horizontalScale, yAnchor + 150 * verticalScale); // right side
  }
}
class NTRobot {

  //Cpnstructor for class
  //MUST have name identical to name of the class
  public void NTRobot() {
  }
  //To draw my robot at the specidied location
  public void drawAt(int xAnchor, int yAnchor, float horizontalScale, float verticalScale) {

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
class OBRobot {
  public void OBRobot() {
  }

  
  public void drawAt(int x, int y, float xScale, float yScale) {

  //creat head of robot
  fill(255);
  ellipse(250 * xScale + x, 100 * yScale + y, 100 * xScale, 100 * yScale);
  fill(0);
  ellipse(230 * xScale + x, 67 * yScale + y, 10 * xScale, 10 * yScale);
  ellipse(270 * xScale + x, 67 * yScale + y, 10 * xScale, 10 * yScale);
  rect(226 * xScale + x, 90 * yScale + y, 50 * xScale, 10 * yScale);
  rect(243 * xScale + x, 20 * yScale + y, 10 * xScale, 30 * yScale);

  //Make body 
  fill(0);
  rect(160 * xScale + x, 100 * yScale + y, 200 * xScale, 200 * yScale);

  //Make arms 
  fill(0);                // black fill
  rect(100 * xScale + x, 100 * yScale + y, 50 * xScale, 80 * yScale);
  rect(100 * xScale + x, 180 * yScale + y, 50 * xScale, 90 * yScale);
  rect(110 * xScale + x, 100 * yScale + y, 50 * xScale, 50 * yScale);
  rect(350 * xScale + x, 100 * yScale + y, 50 * xScale, 50 * yScale);
  rect(370 * xScale + x, 100 * yScale + y, 50 * xScale, 80 * yScale);
  rect(370 * xScale + x, 180 * yScale + y, 50 * xScale, 90 * yScale);
}
} 
class TMRobots {

  public void TMRobots() {
  }

  // draws robot at specified location
  public void drawAt(int posX, int posY, float horizScale, float vertScale) {

    stroke(1);
    rectMode(CORNER);

    fill(0xffaaaaaa);
    rect(posX + 25 * horizScale, posY + 0 * vertScale, 150 * horizScale, 50 * vertScale); //draw head
    fill(0xffff0000);
    rect(posX + 25 * horizScale, posY + 50 * vertScale, 150 * horizScale, 100 * vertScale); // draw torso
    rect(posX + 0 * horizScale, posY + 50 * vertScale, 25 * horizScale, 75 * vertScale); // draw left arm
    rect(posX + 175 * horizScale, posY + 50 * vertScale, 25 * horizScale, 75 * vertScale); // draw right arm

    fill(0xffaaaaaa);
    rect(posX + 0 * horizScale, posY + 125 * vertScale, 25 * horizScale, 25 * vertScale); // draw left hand
    rect(posX + 175 * horizScale, posY + 125 * vertScale, 25 * horizScale, 25 * vertScale); // draw right hand

    fill(0xff0000ff);
    rect(posX + 25 * horizScale, posY + 150 * vertScale, 75 * horizScale, 100 * vertScale); //draw left leg
    rect(posX + 100 * horizScale, posY + 150 * vertScale, 75 * horizScale, 100 * vertScale); // draw right leg

    fill(0xff00ff00);
    ellipse(posX + 50 * horizScale, posY + 25 * vertScale, 25 * horizScale, 25 * vertScale); // draw left eye
    ellipse(posX + 150 * horizScale, posY + 25 * vertScale, 25 * horizScale, 25 * vertScale); // draw right eye

    //fill(#00ff00);
    //textAlign(CENTER,CENTER);
    //PFont arial; // create font arial
    //arial = createFont("arial.ttf", int(32 * vertScale)); // set arial equal to arial.ttf from data and set size correctly
    //textFont(arial); // set the text font to arial

    //text("( \u0361\u00b0 \u035c\u0296 \u0361\u00b0)", posX + 100 * vertScale, posY + 100 * horizScale); // type "le lenny" on the robot's torso
  }
}
  public void settings() {  size(1000, 700); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Robots" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
