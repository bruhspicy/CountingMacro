import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.awt.event.KeyEvent;

public class CountingMacro extends Thread {
    
    private int initialValue;

    public void startProgram(int initial) {
        int start = initial;
        // System.out.println("confirmed");
        String used = Integer.toString(start);
        ArrayList<Integer> update = new ArrayList<>();
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (Exception e){

        }

        while (Frame.getRun()) {
            if (!Frame.getRun()) {
                break;
            }
            
            update = read(used);
            for (int x : update) {
                try {
                    Robot r = new Robot();
                    r.keyPress(Integer.toString(x).charAt(0));
                    r.keyRelease(Integer.toString(x).charAt(0));
                } catch (Exception e) {}
            }
            ++start;
            used = Integer.toString(start);

            try {
                Robot r = new Robot();
                r.keyPress(KeyEvent.VK_ENTER);
                r.keyRelease(KeyEvent.VK_ENTER);
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {

            }
            
        }
    }

    public static ArrayList<Integer> read(String x) {
        ArrayList<Integer> broken = new ArrayList<>();
        int y = 0;

        for (int i = 0; i < x.length(); ++i) {
            broken.add(Integer.parseInt(x.substring(y, y+1)));
            ++y;
        }
        return broken;
    }

    public void setInitialValue(int x) {
        initialValue = x;
    }

    @Override
    public void run() {
        this.startProgram(initialValue);
    }
}
