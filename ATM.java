/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.KeyCode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Jarno
 */
public class ATM {

    ATMScreen as;
    DisplayText displayText;
    String cardNumber;
    private Bank bank;

    String inputPin = "";
    boolean transactionComplete = false;
    String WithdrawString = "";
    int WithdrawInt;
    String UserWantsReciept = "";
    String UserWantsRecieptCompare = "";

    public ATM(Bank b) throws InterruptedException {
        bank = b;
        as = new ATMScreen();
        Frame f = new Frame("ATM");
        f.setBounds(400, 400, 400, 400);
        f.setBackground(Color.BLUE);
        f.addWindowListener(new MyWindowAdapter(f));
        f.add(as);
        f.setVisible(true);
        doTransaction();

    }

    public void doTransaction() throws InterruptedException {

        displayText = new DisplayText("Display", new Point(0, 0));
        while (true) {
            as.add(displayText);
            displayText.giveOutput("Steek uw pas in de atm");
            CardReader cardReader = new CardReader("CardReader");

            //Via de arraylists kan makkelijk gekeken worden of een van de knoppen is ingedrukt.
            ArrayList<InputDevice> KeypadButtons = new ArrayList<>();
            ArrayList<InputDevice> CashAmmountButtons = new ArrayList<>();
            ArrayList<InputDevice> RecieptButtons = new ArrayList<>();

            //instances maken van alle buttons
            ScreenButton button1 = new ScreenButton("1", new Point(180, 130));
            ScreenButton button2 = new ScreenButton("2", new Point(210, 130));
            ScreenButton button3 = new ScreenButton("3", new Point(240, 130));
            ScreenButton button4 = new ScreenButton("4", new Point(180, 160));
            ScreenButton button5 = new ScreenButton("5", new Point(210, 160));
            ScreenButton button6 = new ScreenButton("6", new Point(240, 160));
            ScreenButton button7 = new ScreenButton("7", new Point(180, 190));
            ScreenButton button8 = new ScreenButton("8", new Point(210, 190));
            ScreenButton button9 = new ScreenButton("9", new Point(240, 190));
            ScreenButton button0 = new ScreenButton("0", new Point(210, 220));
            ScreenButton button20 = new ScreenButton("20", new Point(20, 70));
            ScreenButton button50 = new ScreenButton("50", new Point(100, 70));
            ScreenButton button100 = new ScreenButton("100", new Point(20, 100));
            ScreenButton button200 = new ScreenButton("200", new Point(100, 100));
            ScreenButton buttonJA = new ScreenButton("JA", new Point(30, 80));
            ScreenButton buttonNEE = new ScreenButton("NEE", new Point(100, 80));

            //toevoegen van alle knoppen aan bijbehorende arraylists
            KeypadButtons.add(button1);
            KeypadButtons.add(button2);
            KeypadButtons.add(button3);
            KeypadButtons.add(button4);
            KeypadButtons.add(button5);
            KeypadButtons.add(button6);
            KeypadButtons.add(button7);
            KeypadButtons.add(button8);
            KeypadButtons.add(button9);
            KeypadButtons.add(button0);

            CashAmmountButtons.add(button20);
            CashAmmountButtons.add(button50);
            CashAmmountButtons.add(button100);
            CashAmmountButtons.add(button200);

            RecieptButtons.add(buttonJA);
            RecieptButtons.add(buttonNEE);

            as.add(button1);
            as.add(button2);
            as.add(button3);
            as.add(button4);
            as.add(button5);
            as.add(button6);
            as.add(button7);
            as.add(button8);
            as.add(button9);
            as.add(button0);

            try {
                cardNumber = cardReader.getInput();

                while (bank.get(cardNumber) == null) {
//                    System.out.println("That card number does not exist, try again...");
                    cardNumber = cardReader.getInput();
                    System.out.println(cardNumber);
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }

            as.add(button1);
            as.add(button2);
            as.add(button3);
            as.add(button4);
            as.add(button5);
            as.add(button6);
            as.add(button7);
            as.add(button8);
            as.add(button9);
            as.add(button0);

            displayText.giveOutput("Voer uw pin in");
            System.out.println("Voer uw pin in");

            try {
                String X = "";
                //Deze loop draait zolang de lengte van string input pin kleiner is dan 4. Voor elke knop wordt continue gekeken of deze is ingedrukt. Als dit het geval is, wordt de input bij de string toegevoegd.
                //Er verschijnt ook een X op het scherm om aan te geven dat een cijfer is ingedrukt.

                while (inputPin.length() != 4) {
                    for (InputDevice i : KeypadButtons) {
                        String inputOfUser = i.getInput();
                        if (inputOfUser != null) {
                            X += "X";
                            displayText.giveOutput(X);
                            inputPin += inputOfUser;
                        }
                    }
                    Thread.yield();
                }

                // Als de code niet klopt, wordt dit aangegeven en kan de gebruiker
                //het weer opniew proberen. Dit gaat door totdat de gebruiker de juiste pin invoert.
                while (!bank.get(cardNumber).checkPin(inputPin)) {
                    if (!bank.get(cardNumber).checkPin(inputPin)) {
                        System.out.println("Verkeerde pin.. Probeer opnieuw...");
                        displayText.giveOutput("Incorrecte Pin");
                        TimeUnit.SECONDS.sleep(10);
                        displayText.giveOutput("");

                    }
                    inputPin = "";
                    X = "";

                    while (inputPin.length() < 4) {
                        for (InputDevice i : KeypadButtons) {
                            String inputOfUser = i.getInput();

                            if (inputOfUser != null) {
                                X += "X";
                                displayText.giveOutput(X);
                                inputPin += inputOfUser;
                            }
                        }
                        Thread.yield();
                    }
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            bank.get(cardNumber);
            System.out.println("U bent ingelogd");

            //verwijdert alle vorige schermelementen
            as.clear();

            displayText.giveOutput("Kies hier hoeveel u wil pinnen");

            //voegt nieuwe scherm elementen toe
            as.add(displayText);
            as.add(button20);
            as.add(button50);
            as.add(button100);
            as.add(button200);

            System.out.println("Kies hoeveelheid...");

//            System.out.println(userPin);
            //Hier blijven alle elementen op het scherm totdat de gebruiker een keuze maakt.
            while (transactionComplete == false) {
                for (InputDevice i : CashAmmountButtons) {
                    String UserWithdrawAmount = i.getInput();
                    if (UserWithdrawAmount != null) {
                        WithdrawInt = Integer.parseInt(UserWithdrawAmount);
                        System.out.println(UserWithdrawAmount);

                        if (Integer.parseInt(bank.get(cardNumber).getBalance(inputPin)) < WithdrawInt) {
                            System.out.println("U heeft niet genoeg geld...");
                        } else if (Integer.parseInt(bank.get(cardNumber).getBalance(inputPin)) >= WithdrawInt) {
                            bank.get(cardNumber).withdraw(WithdrawInt, inputPin);
                            System.out.println(Integer.parseInt(bank.get(cardNumber).getBalance(inputPin)));
                            transactionComplete = true;
                            inputPin = "";
                        }
                    }
                }
                Thread.yield();
            }
            System.out.println("Transactie compleet");
            as.clear();
            displayText.giveOutput("Wil u het bonnetje");
            as.add(buttonJA);
            as.add(buttonNEE);
            as.add(displayText);
            DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
            String formattedDate = formatter.format(LocalDate.now());
            while (UserWantsReciept.length() == 0) {
                for (InputDevice i : RecieptButtons) {
                    UserWantsRecieptCompare = i.getInput();

                    if (UserWantsRecieptCompare != null) {
                        if (UserWantsRecieptCompare == "JA") {
                            as.clear();
                            System.out.println("BONN");
                            System.out.println("Datum: " + formattedDate);
                            System.out.println("Hoeveelheid: " + WithdrawInt);
                            displayText.giveOutput("Nu aan het pakken $ " + WithdrawInt);
                            as.add(displayText);
                            TimeUnit.SECONDS.sleep(4);
                            displayText.giveOutput("Neem uw geld en kaart uit de atm ");
                            TimeUnit.SECONDS.sleep(4);
                            UserWantsReciept = UserWantsRecieptCompare;
                        } else {
                            as.clear();
                            displayText.giveOutput("Nu aan het pakken $ " + WithdrawInt);
                            as.add(displayText);
                            TimeUnit.SECONDS.sleep(4);
                            displayText.giveOutput("Neem uw geld en kaart uit de atm");
                            TimeUnit.SECONDS.sleep(4);
                            UserWantsReciept = UserWantsRecieptCompare;
                        }
                    }
                }
                Thread.yield();
            }

            //Het process is verlopen. Na een delay van 4 seconden begint het process weer opnieuw
            displayText.giveOutput("Tot ziens");
            System.out.println("Tot ziens");
            as.add(displayText);
            TimeUnit.SECONDS.sleep(10);
            as.clear();

            //Inloggegevens gewist voor nieuwe gebruiker
            cardNumber = "";
            inputPin = "";
            WithdrawInt = 0;
            WithdrawString = "";
            UserWantsRecieptCompare = "";
            UserWantsReciept = "";
            transactionComplete = false;

            inputPin = "";
            transactionComplete = false;
            WithdrawString = "";
            WithdrawInt = 0;
            UserWantsReciept = "";
            UserWantsRecieptCompare = "";
        }
    }
}
