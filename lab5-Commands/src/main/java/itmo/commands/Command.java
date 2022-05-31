package itmo.commands;

import java.io.Serializable;

/**
 * interface of all commands
 */
public interface Command extends Serializable{
    static final long serialVersionUID = 1L;


    /**
     * execute the command
     */
    void execute() throws Exception;
}
