import java.awt.*;
import java.awt.event.KeyEvent;

class Clipboard{
    private static void copy(){
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException create){
            throw new RuntimeException();
        }
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_C);
    }


    public static void main(String[] args) {
        copy();
    }

}