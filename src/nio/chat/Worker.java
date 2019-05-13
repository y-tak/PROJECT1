package nio.chat;

import java.io.IOException;

public abstract class Worker implements Runnable {
    @Override
    public void run() {
        try {
            init();

            while (!isInterrupted()) {
                loop();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                stop();
            } catch (Exception e)
            { };
        }
    }


    protected void init() throws IOException {
    }

    protected void stop() throws IOException {
    }

    protected void loop() throws IOException{
    }

    protected boolean isInterrupted() {
        return Thread.currentThread().isInterrupted();
    }

}
