package se.alexandrakoch.adventofcode2025.day1;

public class Dial {
    private int dialPosition;

    public Dial() {
        dialPosition = 50;
    }

    public boolean turnDial(char direction, int steps) {
        //Takes a char for direction and integer for number of steps to move
        switch (direction) {
            //Turn left = decrement value
            case 'L':
                dialPosition -= steps;
                break;
            //Turn right = increment value
            case 'R':
                dialPosition += steps;
                break;
            default:
                throw new IllegalArgumentException("Invalid direction input");
        }
        //Loop around if value is under 0 or greater than 99
        if (dialPosition < 0) {
            int underrunTimes = (dialPosition * -1) / 100;
            int remainder = ((dialPosition + (100 * underrunTimes)) * -1);
            dialPosition = 100 - remainder;
            if (dialPosition >= 100) {
                dialPosition -= 100;
            }
        } else if (dialPosition >= 100) {
            int overrunTimes = dialPosition / 100;
            dialPosition -= overrunTimes * 100;
            if (dialPosition >= 100) {
                dialPosition -= 100;
            }
        }
        return dialPosition == 0;
    }
}
