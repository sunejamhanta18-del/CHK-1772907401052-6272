# AgriPulse: The Heartbeat of Post-Harvest

AgriPulse is an automated environmental monitoring and protection system designed to increase the shelf life of stored harvests. This project was developed as a software-hardware integration for [Insert Hackathon Name].

## Overview
AgriPulse monitors critical storage conditions—temperature, humidity, and gas levels—to prevent spoilage. It utilizes an Arduino-based logic engine with real-time feedback and automated climate control.

## Hardware Setup
- **Microcontroller:** Arduino (Logic Engine)
- **Sensors:** - DHT22 (Temperature & Humidity)
  - MQ-series Gas Sensors (Environmental Quality)
- **Actuators:** - Automated Cooling Fan (Triggered at 40°C)
  - Humidifier Control (Triggered at 70% Humidity)
- **Display:** OLED SSD1306 for real-time local monitoring.

## Software Features
- **Real-time Monitoring:** Integration with Firebase Realtime Database.
- **Visual Interface:** 6-shelf digital interface developed in Android Studio.
- **Accessibility:** Voice-assisted notifications for complex terminology and localized multi-language support.

## 📁 File Structure
- `AgriPulse.ino`: Main Arduino logic and sensor calibration.
- `README.md`: Project documentation.

## How it Works
1. The system constantly polls data from the DHT and Gas sensors.
2. If the temperature exceeds **40°C**, the cooling fans are automatically engaged.
3. If humidity levels rise above **70%**, the humidifier logic triggers to maintain optimal conditions.
4. Data is synced to a mobile application for remote monitoring.

---
Developed by **Team AgriPulse**
