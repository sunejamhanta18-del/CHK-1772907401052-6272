#include <Wire.h>
#include <Adafruit_GFX.h>
#include <Adafruit_SSD1306.h>
#include <DHT.h>

#define SCREEN_WIDTH 128
#define SCREEN_HEIGHT 64
#define OLED_RESET -1
Adafruit_SSD1306 display(SCREEN_WIDTH, SCREEN_HEIGHT, &Wire, OLED_RESET);

#define DHTPIN 2
#define DHTTYPE DHT11
DHT dht(DHTPIN, DHTTYPE);

const int humidifier = 8;
const int fan = 9;
const int gas_A = A0;
const int gas_B = A1;

int val1 = 0;
int val2 = 0;

void setup() {
  Serial.begin(9600);

  pinMode(humidifier, OUTPUT);
  pinMode(fan, OUTPUT);
  pinMode(gas_A, INPUT);
  pinMode(gas_B, INPUT);

  dht.begin();

  if(!display.begin(SSD1306_SWITCHCAPVCC, 0x3C)) {
    Serial.println("Display Error");
    for(;;);
  }

  display.clearDisplay();
  display.setTextColor(WHITE);
  display.setTextSize(2);
  display.setCursor(10,20);
  display.println("System ON");
  display.display();
  delay(2000);
}

void loop() {
  float h = dht.readHumidity();
  float t = dht.readTemperature();

  val1 = analogRead(gas_A);
  val2 = analogRead(gas_B);

  if (isnan(h) || isnan(t)) {
    return;
  }

  if(t > 40) {
    digitalWrite(fan, HIGH);
  } else {
    digitalWrite(fan, LOW);
  }

  if(h > 70) {
    digitalWrite(humidifier, HIGH);
  } else {
    digitalWrite(humidifier, LOW);
  }

  Serial.println("--- LOG ---");
  Serial.print("Temp: "); Serial.print(t);
  Serial.print(" | Hum: "); Serial.println(h);
  Serial.print("G1: "); Serial.print(val1);
  Serial.print(" | G2: "); Serial.println(val2);

  display.clearDisplay();
  display.setTextSize(2);
  
  display.setCursor(0,0);
  display.print("T:"); display.print(t); display.print("C");

  display.setCursor(0,22);
  display.print("H:"); display.print(h); display.print("%");

  display.setTextSize(1);
  display.setCursor(0,48);
  display.print("G1:"); display.print(val1);

  display.setCursor(64,48);
  display.print("G2:"); display.print(val2);

  display.display();
  delay(2000);
}