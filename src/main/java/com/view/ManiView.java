package com.view;

import java.util.Scanner;

public class ManiView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final UserView userView = new UserView();

    public ManiView() {}

    public static void start() {

        do {
            System.out.println(MENU);
            CHOICE_MENU = scanner.nextLong();

            if (CHOICE_MENU == 2) {
                userView.getAllUsers();
            }

        } while (CHOICE_MENU != 1);

    }

    private static String MENU = """
======================
_________MENU_________
 1.  Выход
 2.  Вывести всех разработчиков
""";
    private static Long CHOICE_MENU;
}
