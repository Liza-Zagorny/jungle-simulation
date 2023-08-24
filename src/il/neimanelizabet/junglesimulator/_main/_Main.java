package _main;

import entity.Shark;
import util.EventProducer;

public class _Main {
    public static void main(String[] args) {
        Shark shark = new Shark();
        EventProducer eventProducer = new EventProducer();
        eventProducer.startSimulation(shark);
    }
}
