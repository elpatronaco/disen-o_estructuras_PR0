package edu.uoc.ds.adt;


import edu.uoc.ds.adt.sequential.Stack;
import edu.uoc.ds.adt.sequential.StackArrayImpl;

public class PR0Stack {
    public final int CAPACITY = 37;

    private Stack<Double> stack;

    public PR0Stack() {
        newStack();
    }

    public void newStack() {
        stack = new StackArrayImpl<>(CAPACITY);
    }


    public String clearAllStack() {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            String value = stack.pop().toString().replace(".0", "");

            sb.append(value).append(" ");
        }

        return sb.toString();
    }

    public Stack<Double> getStack() {
        return this.stack;
    }

    private double sinus(double angdeg) {
        double rads = Math.toRadians(angdeg);

        return Math.sin(rads);
    }

    private double round(double num, int decimalCount) {
        var notation = Math.pow(10, decimalCount);

        return Math.round(num * notation) / notation;
    }

    public void push(double angdeg) {
        var value = round(sinus(angdeg), 3);

        this.stack.push(value);
    }
}
