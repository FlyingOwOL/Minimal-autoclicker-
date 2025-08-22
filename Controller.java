import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        // Initialize the controller with the model and view
        this.model = model;
        this.view = view;

        // Initialize clicks per hour, minute, and second from the view
        int hour = Integer.parseInt(view.getClicksPerHourField().getText());
        int minute = Integer.parseInt(view.getClicksPerMinuteField().getText());
        int second = Integer.parseInt(view.getClicksPerSecondField().getText());
        this.model.setClicksPerHour(hour);
        this.model.setClicksPerMinute(minute);
        this.model.setClicksPerSecond(second);

        // Set the action listener for the start/stop button
        this.view.setStartStopButton(new Action(model, view));
    }

    public class Action implements ActionListener {
        private Model model;
        private View view;
        private boolean isClicking; // To track the clicking state
        private Thread clickingThread;

        public Action(Model model, View view) {
            this.model = model;
            this.view = view;
            this.isClicking = false; // Initially, not clicking
        }

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (e.getSource() == view.getStartStopButton()) {
                toggleClicking();
            }
        }

        private void toggleClicking() {
            isClicking = !isClicking;

            if (isClicking) {
                System.out.println("Auto-clicking started");
                startClicking();
                view.getStartStopButton().setText("Stop");
            } else {
                System.out.println("Auto-clicking stopped");
                stopClicking();
                view.getStartStopButton().setText("Start");
            }
        }

        private void startClicking() {
            // Get total clicks per second from the model
            int totalClicksPerSecond = model.getTotalClicks();

            // Ensure minimum of 1 click per second
            if (totalClicksPerSecond < 1) {
                totalClicksPerSecond = 1;
            }

            final int clickInterval = 1000 / totalClicksPerSecond;

            clickingThread = new Thread(() -> {
                while (isClicking) {
                    // Perform the clicking action here
                    System.out.println("c l i ck o w o");

                    try {
                        Thread.sleep(clickInterval);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            clickingThread.start();
        }

        private void stopClicking() {
            isClicking = false;
            if (clickingThread != null) {
                clickingThread.interrupt();
            }
        }
    }
}
