# Water Simulation on ESP32 LED Matrix

This project aims to create a realistic water simulation on an LED matrix controlled by an ESP32 microcontroller. The simulation will use data from an accelerometer to influence the movement of the "water" displayed on the matrix, making it respond to tilting, similar to how real water would behave in a container.

## Project Goals
- **ESP32**: Acts as the main controller, running the simulation and handling hardware communication.
- **LED Matrix**: Visualizes the water simulation, with each LED representing a part of the water surface.
- **Accelerometer**: Provides real-time orientation and movement data, allowing the water simulation to react to gravity and motion.

## Features
- Simulate water movement and flow on the LED matrix.
- Use accelerometer input to change the direction and behavior of the water (e.g., tilting the device causes water to "flow" in that direction).
- Real-time, visually appealing effects.

## Structure
- `main/`: Arduino/ESP32 code for hardware control and simulation logic.
- `java_physics/`: Java code for prototyping and testing water simulation algorithms on PC before deploying to ESP32.

## Future Plans
- Add a tiny screen to display air quality data from a sensor.