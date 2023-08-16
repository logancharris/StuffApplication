/**
 * Author: Logan C. Harris
 * Create Date: 5/4/2023
 * Last Edit Date: 5/22/2023
 */

public class Main {
    public static void main(String[] args) throws Exception {
        Windows w = new Windows();
        w.startWindow();

        w.startButton.addActionListener(e -> {
            try {
                w.selectWindow();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }


}
