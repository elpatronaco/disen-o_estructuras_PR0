package edu.uoc.ds.adt;


import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.adt.sequential.QueueArrayImpl;

public class PR0Queue {

    public final int CAPACITY = 37;

    private Queue<Double> queue;

    public PR0Queue() {
        newQueue();
    }

    public void newQueue() {
        queue = new QueueArrayImpl<>(CAPACITY);
    }


    public String clearFullQueue() {
        StringBuilder sb = new StringBuilder();
        char r;
        while (!queue.isEmpty()) {
            String value = queue.poll().toString().replace("0.0", "0");

            sb.append(value).append(" ");
        }
        return sb.toString();
    }

    public Queue<Double> getQueue() {
        return this.queue;
    }

    private double sinus(double angdeg) {
        double rads = Math.toRadians(angdeg);

        return Math.sin(rads);
    }

    private double round(double num, int decimalCount) {
        var notation = Math.pow(10, decimalCount);

        return Math.round(num * notation) / notation;
    }

    public void add(double angdeg) {
        var value = round(sinus(angdeg), 3);

        this.queue.add(value);
    }
}
