package org.log.system.chain;

import org.log.system.loglevels.LogLevel;
import org.log.system.writters.WriterI;

public interface Log {

    public void writeTo(WriterI writerI, String messsage, LogLevel logLevel);
    public void setNextLog(Log nextLog);
}
