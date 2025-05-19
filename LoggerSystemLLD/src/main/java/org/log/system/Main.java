package org.log.system;

import org.log.system.chain.*;
import org.log.system.loglevels.LogLevel;
import org.log.system.loglevels.SetTheLogLevel;
import org.log.system.writters.DbLogWritter;
import org.log.system.writters.WriterI;

public class Main {

    public static void main(String[] args) {
        System.out.println("main");

        Log errorLogger = new ErrorLogger();
        Log warnLogger = new WarningLogger();
        Log infoLogger = new InfoLogger();
        Log logger = new DebugLogger();

        logger.setNextLog(infoLogger);
        infoLogger.setNextLog(warnLogger);
        warnLogger.setNextLog(errorLogger);

        SetTheLogLevel.logLevel = LogLevel.INFO;

        WriterI dbLogWritter = new DbLogWritter();

        logger.writeTo(dbLogWritter, "this is a log", LogLevel.INFO);

    }
}
