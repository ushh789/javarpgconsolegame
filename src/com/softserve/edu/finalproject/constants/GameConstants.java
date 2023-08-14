package com.softserve.edu.finalproject.constants;

import java.util.Scanner;

public class GameConstants {
    public static Scanner sc = new Scanner(System.in);
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";

    public static final String ITALIC = "\u001B[3m";
    public static final String BACKGROUND_RED = "\u001B[41m";
    public static final String TEXT_COLOR_CYAN = "\u001B[36m";

    public static final String TEXT_COLOR_GREEN = "\u001B[92m";

    public static final String TEXT_COLOR_YELLOW = "\u001B[93m";

    public static final String TEXT_COLOR_RED = "\u001B[31m";

    public static final String GAME_TITLE = """
                ____                                        ____                            \s
               / __ \\__  ______  ____ ____  ____  ____     / __ \\__  ______  ____  ___  _____
              / / / / / / / __ \\/ __ `/ _ \\/ __ \\/ __ \\   / /_/ / / / / __ \\/ __ \\/ _ \\/ ___/
             / /_/ / /_/ / / / / /_/ /  __/ /_/ / / / /  / _, _/ /_/ / / / / / / /  __/ /   \s
            /_____/\\__,_/_/ /_/\\__, /\\___/\\____/_/ /_/  /_/ |_|\\__,_/_/ /_/_/ /_/\\___/_/    \s
                              /____/                                                        \s
            """;

    public static final String LOAD_TITLE = """
                __    ____  ___    ____\s
               / /   / __ \\/   |  / __ \\
              / /   / / / / /| | / / / /
             / /___/ /_/ / ___ |/ /_/ /\s
            /_____/\\____/_/  |_/_____/ \s
                                       \s
            """;

    public static final String START_TITLE = """
               ______________    ____  ______
              / ___/_  __/   |  / __ \\/_  __/
              \\__ \\ / / / /| | / /_/ / / /  \s
             ___/ // / / ___ |/ _, _/ / /   \s
            /____//_/ /_/  |_/_/ |_| /_/    \s
                                            \s
            """;

    public static final String REST_TITLE = """
                ____  _________________            
               / __ \\/ ____/ ___/_  __/
              / /_/ / __/  \\__ \\ / /  \s
             / _, _/ /___ ___/ // /   \s
            /_/ |_/_____//____//_/    \s
                                      \s 
            """;

    public static final String CHARACTER_WARRIOR = """
              / \\
              | |
              |.|
              |.|
              |:|      __
            ,_|:|_,   /  )
              (Oo    / _I_
               +\\ \\  || __|
                  \\ \\||___|
                    \\ /.:.\\-\\
                     |.:. /-----\\
                     |___|::oOo::|
                     /   |:<_T_>:|
                    |_____\\ ::: /
                     | |  \\ \\:/
                     | |   | |
                     \\ /   | \\___
                     / |   \\_____\\
                     `-'
            """;

    public static final String CHARACTER_MAGE = """
                              .
                        
                               .
                     /^\\     .
                /\\   "V"
               /__\\   I      O  o
              //..\\\\  I     .
              \\].`[/  I
              /l\\/j\\  (]    .  O
             /. ~~ ,\\/I          .
             \\\\L__j^\\/I       o
              \\/--v}  I     o   .
              |    |  I   _________
              |    |  I c(`       ')o
              |    l  I   \\.     ,/
            _/j  L l\\_!  _//^---^\\\\_
            """;

    public static final String CHARACTER_PRIEST = """
                      /
                 /\\   |
                /  \\  |/
               |    | |>
               \\____/ |
               ( .. ) |
               /\\__/\\ |
              /\\ qp /\\|
             /  |  |  |
            /|  |db| /\\`\\
            | \\ |  | \\|_|
            \\  \\|qp|  |
             \\__/  |  |
             |/||db|  |
             |  |  |  |
            """;

    public static final String CHARACTER_ROGUE = """
                               ;
                               `,
                              ' :.
                        __      `;.
                      /' /\\   ,   \\
                    /   |**|      `;
                   (    |_,| ,     `,
                    )  , \\ '       `:
                   |    ""\""----,__,_.____,_  \s
                   ;      _     |--,_;    '
                  ,     ,' `"---'  ,:
                  |    ,  : /,     ,'
                  |       ,/'     ,;
                  |   '   :|  ,   /'
                  ,        |    ,;
                 ,         |  , :'
                 |         `   ,'
                ,'          `  ;
            __==' ___,  __/_
            """;

    public static final String REST_ROOM = """
                ____  _________________                        _______           \s
               / __ \\/ ____/ ___/_  __/                       /     / \\\\           \s
              / /_/ / __/  \\__ \\ / /                         /     /   \\\\          \s
             / _, _/ /___ ___/ // /                         /_____/-----\\\\_      \s
            /_/ |_/_____//____//_/                         "     "            \s
                                                  _____             o (:') o \s
                                                 (@))_))           o ~/~~\\\\~ o \s
                                                                    o  o  o
            """;

    public static final String CHEST_ROOM = """
                                                           __________
               ________  ___________________              /\\____;;___\\ \s
              / ____/ / / / ____/ ___/_  __/             | /         / \s
             / /   / /_/ / __/  \\__ \\ / /                `. ())oo() . \s
            / /___/ __  / /___ ___/ // /                  |\\(%()*^^()^\\ \s
            \\____/_/ /_/_____//____//_/                  %| |-%-------|  \s
                                                        % \\ | %  ))   | \s
                                                        %  \\|%________|\s
            """;

    public static final String FIGHT = """                                                                                                 
                __________________  ________                   ___/________ \s
               / ____/  _/ ____/ / / /_  __/                     /    \\  \\ \s
              / /_   / // / __/ /_/ / / /                   @___/      \\@/ \s
             / __/ _/ // /_/ / __  / / /                   /\\__/        | \s
            /_/   /___/\\____/_/ /_/ /_/                   / \\ /        / \\ \s
                                                         /  /          |  \\   \s
            """;
}
