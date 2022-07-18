package pl.britenet.campus.command;

import pl.britenet.campus.Constants;

public class EndCommand extends Command{

    public EndCommand() {
        super(Constants.COMMAND_END);
    }

    @Override
    public void execute() {
        System.out.println("koniec");
        System.exit(0);
    }


}
