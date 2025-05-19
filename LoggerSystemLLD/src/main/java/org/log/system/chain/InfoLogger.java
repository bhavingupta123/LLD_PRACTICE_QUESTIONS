package org.log.system.chain;

import org.log.system.loglevels.LogLevel;
import org.log.system.loglevels.SetTheLogLevel;
import org.log.system.writters.WriterI;

import java.time.LocalDateTime;

public class InfoLogger implements Log{

    Log nextLog;

    public Log getNextLog() {
        return nextLog;
    }

    public void setNextLog(Log nextLog) {
        this.nextLog = nextLog;
    }


    @Override
    public void writeTo(WriterI writerI, String messsage, LogLevel logLevel) {
        if(logLevel == LogLevel.INFO && (SetTheLogLevel.logLevel== LogLevel.INFO
                || SetTheLogLevel.logLevel== LogLevel.DEBUG)){
            writerI.write("INFO:" + messsage + ":" + LocalDateTime.now());
        }
        else{
            nextLog.writeTo(writerI, messsage, logLevel);
        }

    }
}
