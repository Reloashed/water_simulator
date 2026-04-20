#include "LedControl.h"

LedControl lc=LedControl(11,9,10,4);  // Pin and # of Displays

void setup()
{
  lc.shutdown(0,false);  // Wake up displays
  lc.shutdown(1,false);
  lc.shutdown(2,false);
  lc.shutdown(3,false);
  lc.setIntensity(0,5);  // Set intensity levels
  lc.setIntensity(1,5);
  lc.setIntensity(2,5);
  lc.setIntensity(3,5);
  lc.clearDisplay(0);  // Clear Displays
  lc.clearDisplay(1);
  lc.clearDisplay(2);
  lc.clearDisplay(3);
}

void loop()
{
  lc.setLed(0, 0, 0, true);
  lc.setLed(1, 0, 0, true);
  lc.setLed(2, 0, 0, true);
  lc.setLed(3, 0, 0, true);
}