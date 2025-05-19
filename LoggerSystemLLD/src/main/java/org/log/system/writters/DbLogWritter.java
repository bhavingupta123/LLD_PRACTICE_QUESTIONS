package org.log.system.writters;

public class DbLogWritter implements WriterI{

    @Override
    public void write(String message) {
        System.out.println("writing to db log");
        System.out.println(message);
    }
}
