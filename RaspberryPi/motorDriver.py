import RPi.GPIO as GPIO
import time

GPIO.setwarnings(False)
GPIO.setmode(GPIO.BCM)

m1f = 5
m1r = 6
m2f = 26
m2r = 19

GPIO.setup(m1f, GPIO.OUT)
GPIO.setup(m1r, GPIO.OUT)
GPIO.setup(m2f, GPIO.OUT)
GPIO.setup(m2r, GPIO.OUT)

print "starting up motor"
time.sleep(1)

print "testing motor 1 forward"
GPIO.output(m1f, True)
GPIO.output(m1r, False)
time.sleep(1)
GPIO.output(m1f, False)
GPIO.output(m1r, False)
time.sleep(1)

print "testing motor 1 reverse"
GPIO.output(m1f, False)
GPIO.output(m1r, True)
time.sleep(1)
GPIO.output(m1f, False)
GPIO.output(m1r, False)
time.sleep(1)

#motor 2
print "testing motor 2 forward"
GPIO.output(m2f, True)
GPIO.output(m2r, False)
time.sleep(1)
GPIO.output(m2f, False)
GPIO.output(m2r, False)
time.sleep(1)

print "testing motor 2 reverse"
GPIO.output(m2f, False)
GPIO.output(m2r, True)
time.sleep(1)
GPIO.output(m2f, False)
GPIO.output(m2r, False)
time.sleep(1)

GPIO.cleanup()
