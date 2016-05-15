package org.home.remote;

import org.home.command.*;

public class RemoteControl {
    public static final int NUMBER_OF_SLOTS = 7;

    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;

    public RemoteControl() {
        onCommands = new Command[NUMBER_OF_SLOTS];
        offCommands = new Command[NUMBER_OF_SLOTS];

        Command noCommand = new NoCommand();
        for(int i = 0; i < NUMBER_OF_SLOTS; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPressed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPressed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPressed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("\n---Remote Control---\n");
        for(int i = 0; i < NUMBER_OF_SLOTS; i++) {
            stringBuffer.append("[slot " + (i+1) + "] " + onCommands[i].getClass().getSimpleName() + "\t" + offCommands[i].getClass().getSimpleName() + "\n");
        }
        stringBuffer.append("[undo] " + undoCommand.getClass().getSimpleName());
        stringBuffer.append("\n");

        return stringBuffer.toString();
    }
}
