class DDRobot {

  void DDRobot() {
  }
  
  void drawAt(int x, int y) {

    //This Robot is BB8

    noStroke();

    //d= distance between the 2 bots
    //default 300
    //

    float d = displayWidth/4.5;

    //Sketch Resolution Scaler
    //MASSIVE SCALING ISSUES
    //W.I.P

    float r = 1;

    //Scale of bots
    scale(1.6 * r);

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

    fill(#B7AA85);
    ellipse(x+ 300, y+ 550, 250, 80 );
    fill(#8B836C);
    ellipse(x+ 300, y+ 550, 230, 40 );

    fill(#746C55);
    ellipse(x+ 300, y+ 550, 200, 20 );

    fill(#393427);
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
    fill(#FC7303); //Orange ring
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
    fill(#FC7303); //orange accent 1 (outer)
    ellipse(x+ 300, y+ 400, 200, 200);
    fill(240); //white separator
    ellipse(x+ 300, y+ 400, 180, 180);
    fill(#FC7303); //orange accent 2 (inner)
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