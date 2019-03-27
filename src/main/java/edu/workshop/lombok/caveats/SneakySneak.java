package edu.workshop.lombok.caveats;

import lombok.SneakyThrows;

public class SneakySneak {

    public void doStuff() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //do nothing ;)
        }
    }

    @SneakyThrows
    public void doStuffSneakly() {
        Thread.sleep(1000);
    }
}
