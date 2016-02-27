class EPRobot2 {
void EPRobot2() {/*Nothing to Construct*/}

void drawAt2(int cx, int cy, float cHorizontal, float cVertical) { //function drawing circlular bot
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
