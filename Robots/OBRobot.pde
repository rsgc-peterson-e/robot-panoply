class OBRobot {
  void OBRobot() {
  }

  
  void drawAt(int x, int y, float xScale, float yScale) {

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