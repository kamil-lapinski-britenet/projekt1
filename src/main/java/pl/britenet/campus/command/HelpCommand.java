package pl.britenet.campus.command;

import pl.britenet.campus.Constants;

public class HelpCommand extends Command {

    public HelpCommand() {
        super(Constants.COMMAND_HELP);
    }

    @Override
    public void execute() {


        System.out.println(Constants.COMMAND_HELLO);
        System.out.println(Constants.COMMAND_RETRIEVE_PRODUCTS + ": wyswietl wszystkie produkty");
        System.out.println(Constants.COMMAND_GET_PRODUCT+": wyswietl produkt o konkretnym id");
        System.out.println(Constants.COMMAND_INSERT_PRODUCT+": dodaj produkt");
        System.out.println(Constants.COMMAND_DELETE_PRODUCT+": usun produkt z konkretnym id");
        System.out.println(Constants.COMMAND_RETRIEVE_USERS+": wyswietl wszystkich uzytkownikow");
        System.out.println(Constants.COMMAND_GET_USER+": wyswietl konkretnego uzytkownika");
        System.out.println(Constants.COMMAND_INSERT_USER+": dodaj uzytkownika");
        System.out.println(Constants.COMMAND_DELETE_USER+": usun konkretnego uzytkownika");
        System.out.println(Constants.COMMAND_RETRIEVE_CARTS+": wyswietl koszyki");
        System.out.println(Constants.COMMAND_RETRIEVE_ORDERS+": wyswietl zamowienia");
        System.out.println(Constants.COMMAND_INSERT_ORDER+": dodaj zamowienie");
        System.out.println(Constants.COMMAND_INSERT_ORDERPRODUCT+": dodaj orderproduct");
        System.out.println(Constants.COMMAND_INSERT_IMAGEPRODUCT+": dodaj zdj produktu");
        System.out.println(Constants.COMMAND_INSERT_IMAGEUSER+": dodaj zdj uzytkownika");
        System.out.println(Constants.COMMAND_DELETE_CART+ ": usun koszyk");
        System.out.println(Constants.COMMAND_DELETE_CARTPRODUCT+ ": usun cartproduct");
        System.out.println(Constants.COMMAND_UPDATE_USER+" aktualizacja uzytkownika");
        System.out.println(Constants.COMMAND_UPDATE_PRODUCT+" aktualizacja produktu");
        System.out.println(Constants.COMMAND_GET_ORDER+": wyswietl konkretne zamowienie");
        System.out.println(Constants.COMMAND_END+": koniec programu");
        System.out.println(Constants.COMMAND_HELP +": pomoc");


    }

}
