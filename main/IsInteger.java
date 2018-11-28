package main;

public class IsInteger {

    public boolean isInteger(String s) {
        int i;
        try {
            i = Integer.valueOf(s);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
