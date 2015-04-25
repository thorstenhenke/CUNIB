package main;

import model.Einstellungen;

import javax.swing.*;
import java.util.Enumeration;

public class InputValidator
{

    public static boolean hasValidKCode(String klassencode)
    {
        return validateCode(klassencode, Einstellungen.KCODESTELLEN);
    }

    public static boolean hasValidSCodes(String[] codes)
    {
        for (String code : codes) {
            if (!(code.equals("") || validateCode(code, Einstellungen.SCODESTELLEN))) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateCode(String strcode, int ndigits)
    {
        char[] digits = strcode.toCharArray();
        if (digits.length == 0 || digits.length != ndigits)
            return false;
        for (char c : digits) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

    public static boolean hasValidRdBtn(ButtonGroup g)
    {
        for (Enumeration e = g.getElements(); e.hasMoreElements(); ) {
            AbstractButton b = (AbstractButton) e.nextElement();
            if (b.isSelected()) {
                return true;
            }
        }
        return false;
    }
}
