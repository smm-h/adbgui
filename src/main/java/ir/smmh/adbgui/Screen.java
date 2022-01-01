package ir.smmh.adbgui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Screen implements KeyEvents {

    final float ratio = 2.8f;
    final int x;
    final int y;
    final int w = (int) (1080f / ratio);
    final int h = (int) (1920f / ratio);
    final String filename = "screencap.png";
    final String filenameOnPhone = "/storage/self/primary/sc.png";
    final File file = new File(filename);
    final DoubleBufferedImagePanel panel;
    final Frame frame = new Frame();
    final Collection<TapRing> tapRings = new ConcurrentLinkedQueue<>();
    BufferedImage image;
    boolean running = false;

    Screen() {
        frame.add(panel = new DoubleBufferedImagePanel());
        frame.setVisible(true);
        var i = frame.getInsets();
        x = i.left;
        y = i.top;
        frame.setSize(x + w + i.right, y + h + i.bottom);
        new Thread(() -> {
            while (true) {
                Iterator<TapRing> iterator = tapRings.iterator();
                while (iterator.hasNext()) {
                    TapRing tapRing = iterator.next();
                    tapRing.radius += 0.00001;
                    if (tapRing.radius > 30) {
                        iterator.remove();
                    }
                }
                panel.repaint();
            }
        }).start();
    }

    public static void main(String[] args) {
        new Screen().start();
    }

    void start() {
        running = true;
        new Thread(() -> {
            while (running) {
                try {
                    Thread.sleep(100);
                    refresh();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    void stop() {
        running = false;
//        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

    void run(String command) {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
        builder.redirectErrorStream(true);
        Process process;
        try {
            process = builder.start();
        } catch (IOException e) {
            System.err.println("Could not start process builder");
            return;
        }
        BufferedReader r = new BufferedReader(new InputStreamReader(process.getInputStream()));
        int tolerance = 10;
        String line;
        while (tolerance > 0) {
            try {
                line = r.readLine();
                if (line == null) {
                    return;
                }
                System.out.println(line);
                tolerance = 10;
            } catch (IOException e) {
                tolerance--;
            }
        }
        System.err.println("Too many consequent IOExceptions while reading from stream");
    }

    void refresh() {
//            SwingUtilities.invokeLater(() -> {
        run("adb shell screencap " + filenameOnPhone + " && adb pull " + filenameOnPhone + " " + filename);
        try {
            image = ImageIO.read(file);
            panel.repaint();
        } catch (IOException e) {
            System.err.println("Failed to read PNG");
        }
//        });
    }

    void performTap(int x, int y) {
//        run("adb shell input tap " + x + " " + y);
        System.out.println("Tapping on pixel at: (" + x + ", " + y + ")");
        refresh();
    }

    void performKeyEvent(int keyEvent) {
        if (keyEvent != KEYCODE_UNKNOWN) {
            run("adb shell input keyevent " + keyEvent);
            System.out.println("Sending key event: " + keyEvent);
            refresh();
        } else {
            System.err.println("Could not send unknown key event");
        }
    }

    void performSwipe(int x1, int y1, int x2, int y2) {
        run("adb shell input swipe " + x1 + " " + y1 + " " + x2 + " " + y2);
    }

//    void beginTouch() {
//        // /dev/input/event2
//        run("adb shell sendevent /dev/input/event0 3 57 0");
//        run("adb shell sendevent /dev/input/event0 3 53 " + x);
//        run("adb shell sendevent /dev/input/event0 3 54 " + y);
//        run("adb shell sendevent /dev/input/event0 3 48 5");
//        run("adb shell sendevent /dev/input/event0 3 58 50");
//        run("adb shell sendevent /dev/input/event0 0 2 0");
//        run("adb shell sendevent /dev/input/event0 0 0 0");
//    }
//    https://ktnr74.blogspot.com/2013/06/emulating-touchscreen-interaction-with.html
//      https://stackoverflow.com/questions/54505498/adb-drag-vs-swipe-manual-drag-via-events?noredirect=1&lq=1
//    void endAllTouches() {
//        run("adb shell sendevent /dev/input/event0 3 57 -1");
//        run("adb shell sendevent /dev/input/event0 0 2 0");
//        run("adb shell sendevent /dev/input/event0 0 0 0");
//    }

    class Frame extends JFrame implements WindowListenerAdapter, KeyListenerAdapter, MouseListenerAdapter {

        Frame() {
            addWindowListener(this);
            addKeyListener(this);
            addMouseListener(this);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            performKeyEvent(KeyEvents.translateKeyCode(e));
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX() - Screen.this.x;
            int y = e.getY() - Screen.this.y;
            new TapRing(x, y);
            performTap((int) (x * ratio), (int) (y * ratio));
        }

        @Override
        public void windowClosing(WindowEvent e) {
            stop();
        }

    }

    class DoubleBufferedImagePanel extends JPanel {
        DoubleBufferedImagePanel() {
            setDoubleBuffered(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.drawLine(0, 0, w, h);
            g2.drawLine(w, 0, 0, h);
            if (image != null)
                g2.drawImage(image, 0, 0, w, h, null);
            g2.setColor(Color.YELLOW);
            for (TapRing tapRing : tapRings) {
                tapRing.beDrawnOn(g2);
            }
        }
    }

    class TapRing {
        final int x, y;
        float radius = 0;

        TapRing(int x, int y) {
            this.x = x;
            this.y = y;
            tapRings.add(this);
        }

        void beDrawnOn(Graphics2D g) {
            int r = (int) radius;
            g.drawOval(x - r, y - r, 2 * r, 2 * r);
        }
    }
}
