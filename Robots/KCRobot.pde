//Makes function run once
class KCRobot {
  void KCRobot () {
  } 

  //Let x be xAnchor
  //Let y be yAnchor
  //Let b be horizontalShift
  //Let a be verticalShift
  //draw robot at specified location
  void drawAt(int x, int y, float b, float a) {
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
