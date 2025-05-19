package org.log.system.writters;

public class FileLogWritter implements WriterI{

    @Override
    public void write(String message) {
        System.out.println("writing to file log");
        System.out.println(message);
    }
}
