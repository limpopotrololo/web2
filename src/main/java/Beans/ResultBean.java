package Beans;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ResultBean {
    private  Deque<Bean> response;

    public ResultBean() {
        response = new ConcurrentLinkedDeque<>();
    }

    public Deque<Bean> getResponse() {
        return response;
    }
}
