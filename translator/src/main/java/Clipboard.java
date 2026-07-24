import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.desktop.SystemSleepEvent;
import java.awt.event.KeyEvent;
import java.awt.datatransfer.Clipboard;
import java.io.IOException;

class Buffer{
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
    private static String takeClipboard()throws IOException, UnsupportedFlavorException, InterruptedException{
        String new_res = null;
        String old_res = null;
        Clipboard old_clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        old_res = (String) old_clip.getData(DataFlavor.stringFlavor);
        new_res = old_res;
        copy();
        while(old_res.equals(new_res)) { //потенциальная проблема
            Thread.sleep(20);
            Clipboard new_clip = Toolkit.getDefaultToolkit().getSystemClipboard();
            new_res = (String) new_clip.getData(DataFlavor.stringFlavor);
        }
        return new_res;
    }


    public static void main(String[] args) throws IOException, UnsupportedFlavorException, InterruptedException {
        String buffer = takeClipboard();
        System.out.println(buffer);
    }

}