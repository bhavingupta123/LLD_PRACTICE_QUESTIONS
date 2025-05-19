package org.log.system.writters;

public class HostLogWritter implements WriterI{

    @Override
    public void write(String message) {
        System.out.println("writing to host log");
        System.out.println(message);
    }
}
