class TMRobots {

  void TMRobots() {
  }

  // draws robot at specified location
  void drawAt(int posX, int posY, float horizScale, float vertScale) {

    stroke(1);
    rectMode(CORNER);

    fill(#aaaaaa);
    rect(posX + 25 * horizScale, posY + 0 * vertScale, 150 * horizScale, 50 * vertScale); //draw head
    fill(#ff0000);
    rect(posX + 25 * horizScale, posY + 50 * vertScale, 150 * horizScale, 100 * vertScale); // draw torso
    rect(posX + 0 * horizScale, posY + 50 * vertScale, 25 * horizScale, 75 * vertScale); // draw left arm
    rect(posX + 175 * horizScale, posY + 50 * vertScale, 25 * horizScale, 75 * vertScale); // draw right arm

    fill(#aaaaaa);
    rect(posX + 0 * horizScale, posY + 125 * vertScale, 25 * horizScale, 25 * vertScale); // draw left hand
    rect(posX + 175 * horizScale, posY + 125 * vertScale, 25 * horizScale, 25 * vertScale); // draw right hand

    fill(#0000ff);
    rect(posX + 25 * horizScale, posY + 150 * vertScale, 75 * horizScale, 100 * vertScale); //draw left leg
    rect(posX + 100 * horizScale, posY + 150 * vertScale, 75 * horizScale, 100 * vertScale); // draw right leg

    fill(#00ff00);
    ellipse(posX + 50 * horizScale, posY + 25 * vertScale, 25 * horizScale, 25 * vertScale); // draw left eye
    ellipse(posX + 150 * horizScale, posY + 25 * vertScale, 25 * horizScale, 25 * vertScale); // draw right eye

    //fill(#00ff00);
    //textAlign(CENTER,CENTER);
    //PFont arial; // create font arial
    //arial = createFont("arial.ttf", int(32 * vertScale)); // set arial equal to arial.ttf from data and set size correctly
    //textFont(arial); // set the text font to arial

    //text("( ͡° ͜ʖ ͡°)", posX + 100 * vertScale, posY + 100 * horizScale); // type "le lenny" on the robot's torso
  }
}