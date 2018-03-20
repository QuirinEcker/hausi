import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.virtual.DefaultVirtualTerminal;

import javax.swing.*;
import java.io.IOException;

public class Ecker_Hausi {

    public static void main(String[] args) throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        TextGraphics tg = screen.newTextGraphics();
        screen.startScreen();
        readButton(terminal, screen, tg);
    }

    private static void readButton(Terminal terminal , Screen screen, TextGraphics tg) throws IOException {
        boolean keepRunning = true;
        int numberofSteps = 1;

        while (keepRunning || numberofSteps < 4) {
            char currenKeypress;
            KeyStroke keyPressed = screen.readInput();
            currenKeypress = keyPressed.getCharacter();
            buildHouse(tg, numberofSteps, terminal);
            numberofSteps++;
            screen.refresh();
        }
    }

    private static void buildHouse(TextGraphics tg, int numberOfSteps, Terminal terminal) {
        switch (numberOfSteps) {
            case 1:
                houseBlock(tg, terminal);
                break;
            case 2:
                houseRoof(tg);
                break;
            case 3:
                houseDoor(tg, terminal);
                break;
            case 4:
                housWindows(tg, terminal);
        }

    }

    private static void housWindows(TextGraphics tg, Terminal terminal) {
        tg.drawRectangle(new TerminalPosition(6,8), new TerminalSize(4,5), Symbols.BLOCK_SOLID);
        tg.drawRectangle(new TerminalPosition(12,8), new TerminalSize(4,5), Symbols.BLOCK_SOLID);
        tg.drawRectangle(new TerminalPosition(18,8), new TerminalSize(4,5), Symbols.BLOCK_SOLID);
        tg.drawRectangle(new TerminalPosition(24,8), new TerminalSize(4,5), Symbols.BLOCK_SOLID);
        tg.drawRectangle(new TerminalPosition(30,8), new TerminalSize(4,5), Symbols.BLOCK_SOLID);
        tg.drawRectangle(new TerminalPosition(36,8), new TerminalSize(4,5), Symbols.BLOCK_SOLID);
        tg.drawRectangle(new TerminalPosition(42,8), new TerminalSize(4,5), Symbols.BLOCK_SOLID);
        tg.drawRectangle(new TerminalPosition(48,8), new TerminalSize(4,5), Symbols.BLOCK_SOLID);
        tg.drawRectangle(new TerminalPosition(54,8), new TerminalSize(4,5), Symbols.BLOCK_SOLID);
        tg.drawRectangle(new TerminalPosition(60,8), new TerminalSize(4,5), Symbols.BLOCK_SOLID);
        tg.drawRectangle(new TerminalPosition(66,8), new TerminalSize(4,5), Symbols.BLOCK_SOLID);
    }


    private static void houseDoor(TextGraphics tg, Terminal terminal) {
        tg.drawRectangle(new TerminalPosition(34, 15), new TerminalSize(1,5), Symbols.BLOCK_SOLID);
        tg.drawRectangle(new TerminalPosition(34, 15), new TerminalSize(4,1), Symbols.BLOCK_SOLID);
        tg.drawRectangle(new TerminalPosition(38, 15), new TerminalSize(1,5), Symbols.BLOCK_SOLID);

    }

    private static void houseRoof(TextGraphics tg) {
        tg.drawLine(39, 0,74, 5, '*');
        tg.drawLine(37, 0, 3,5,'*');
    }

    private static void houseBlock(TextGraphics tg, Terminal terminal) {
        tg.drawRectangle(new TerminalPosition(4,5), new TerminalSize(70,15), Symbols.BLOCK_SOLID);
    }
}
