public class Main {

    static String cadena = "";
    static int pos = 0;

    public static void main(String[] args) {
        cadena = "i+i++";
        if (E() && pos == cadena.length()) {
            System.out.println("La cadena es valida");
        } else {
            System.out.println("La cadena es invalida");
        }
    }

    static boolean E() {
        if (!T()) {
            return false;
        }
        return E1();
    }

    static boolean E1() {
        if (pos < cadena.length() && cadena.charAt(pos) == '+') {
            ++pos;
            if (!T()) {
                return false;
            }
            return E1();
        }
        return true;
    }

    static boolean T() {
        if (F()) {
            return false;
        }
        return T1();
    }

    static boolean T1() {
        if (pos < cadena.length() && cadena.charAt(pos) == '*') {
            ++pos;
            if (F()) {
                return false;
            }
            return T1();
        }
        return true;
    }

    static boolean F() {
        if (pos < cadena.length() && cadena.charAt(pos) == '(') {
            ++pos;
            if (!E()) {
                return true;
            }
            return pos >= cadena.length() || cadena.charAt(pos++) != ')';
        }

        return pos < cadena.length() && cadena.charAt(pos++) != 'i';
    }
}