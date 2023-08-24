package _main;

import entity.Shark;
import util.EventProducer;

public class _Main {
    public static void main(String[] args) {
        Shark shark = new Shark();
        EventProducer eventProducer = new EventProducer();
        try {
            eventProducer.startSimulation(shark);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
