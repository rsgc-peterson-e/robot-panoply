class ASPRobot { 
  void ASPRobot() {
  } 

  //Draw At
  void drawAt(int x, int y, float horizontalScale, float verticalScale) {
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