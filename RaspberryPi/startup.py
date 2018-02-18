import RPi.GPIO as GPIO
import time

GPIO.setwarnings(False)
GPIO.setmode(GPIO.BCM)

m1f = 5
m1r = 6
m2f = 13
m2r = 19

GPIO.setup(m1f, GPIO.OUT)
GPIO.setup(m1r, GPIO.OUT)
GPIO.setup(m2f, GPIO.OUT)
GPIO.setup(m2r, GPIO.OUT)

time.sleep(1)

for i in range(5):
    GPIO.output(m1f, True)
    GPIO.output(m2f, True)
    time.sleep(1)
    GPIO.output(m1f, False)
    GPIO.output(m2f, False)
    time.sleep(0.5)

GPIO.cleanup()
