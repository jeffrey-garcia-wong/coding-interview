package io.jeffrey.codewars.common;

/**
 * <h1>Killer Garage Door</h1>
 *
 * <b>Situation</b><br/>
 * You have been hired by a company making electric garage doors.
 * Accidents with the present product line have resulted in numerous
 * damaged cars, broken limbs and several killed pets. Your mission
 * is to write a safer version of their controller software.<p/>
 *
 * <b>Specification</b><br/>
 * We always start with a closed door. The remote control has
 * exactly one button, with the following behaviour.<p/>
 * <ul>
 *     <li>If the door is closed, a push starts opening the door, and vice-versa</li>
 *     <li>It takes 5 seconds for the door to open or close completely</li>
 *     <li>While the door is moving, one push pauses movement, another push resumes movement in the same direction</li>
 * </ul>
 * In order to make the door safer, it has been equiped with resistance-based
 * obstacle detection. When the door detects an obstacle, it must immediately
 * reverse the direction of movement.<p/>
 *
 * <b>Input</b><br/>
 * A string where each character represents one second, with the following possible values.
 * <ul>
 *     <li>'.' No event</li>
 *     <li>'P' Button has been pressed</li>
 *     <li>'O' Obstacle has been detected (supersedes P)</li>
 * </ul>
 * As an example, '..P....' means that nothing happens for two seconds,
 * then the button is pressed, then no further events.<p/>
 *
 * <b>Output</b><br/>
 * A string where each character represents one second and indicates
 * the position of the door (0 if fully closed and 5 fully open).
 * The door starts moving immediately, hence its position changes
 * at the same second as the event.<p/>
 *
 * <b>Example</b><br/>
 * <pre>
 * {@code
 * ..P...O.....
 * }
 * </pre> as input should yield
 * <pre>
 * {@code
 * 001234321000
 * }
 * </pre>as output.
 */
public class KillerGarageDoor {

    public static String execute(String events) {
        return solutionV1(events);
    }

    public static String solutionV1(String events) {
        char [] input = events.toCharArray();
        StringBuilder output = new StringBuilder();

        State state = new State();

        for (int i=0; i<input.length; i++) {
            char event = input[i];
            switch (event) {
                case '.':
                    output.append(state.idle());
                    break;
                case 'P':
                    output.append(state.buttonPressed());
                    break;
                case 'O':
                    output.append(state.obstacleDetected());
                    break;
            }

        }
        return output.toString();
    }

    private static class State {
        private enum GateMotion {
            CLOSED,
            OPENED,
            OPENING_UP,
            CLOSING_DOWN,
            OPENING_UP_PAUSED,
            CLOSING_DOWN_PAUSED
        }

        private int currentPosition = 0;
        private GateMotion currentMotion = GateMotion.CLOSED;

        int buttonPressed() {
            switch (currentMotion) {
                case CLOSED:
                case OPENING_UP_PAUSED:
                    currentMotion = GateMotion.OPENING_UP;
                    currentPosition += 1;
                    break;
                case OPENED:
                case CLOSING_DOWN_PAUSED:
                    currentMotion = GateMotion.CLOSING_DOWN;
                    currentPosition -= 1;
                    break;
                case OPENING_UP:
                    currentMotion = GateMotion.OPENING_UP_PAUSED;
                    break;
                case CLOSING_DOWN:
                    currentMotion = GateMotion.CLOSING_DOWN_PAUSED;
                    break;
            }
            return currentPosition;
        }

        int idle() {
            if (currentMotion == GateMotion.OPENING_UP) {
                currentPosition += 1;
                if (currentPosition >= 5) {
                    currentMotion = GateMotion.OPENED;
                }
            } else if (currentMotion == GateMotion.CLOSING_DOWN) {
                currentPosition -= 1;
                if (currentPosition <= 0) {
                    currentMotion = GateMotion.CLOSED;
                }
            } else {
                // nothing happen
            }
            return currentPosition;
        }

        int obstacleDetected() {
            if (currentMotion == GateMotion.OPENING_UP) {
                currentMotion = GateMotion.CLOSING_DOWN;
                currentPosition -= 1;
                return currentPosition;
            }
            if (currentMotion == GateMotion.CLOSING_DOWN) {
                currentMotion = GateMotion.OPENING_UP;
                currentPosition += 1;
                return currentPosition;
            }
            return currentPosition;
        }
    }
}
