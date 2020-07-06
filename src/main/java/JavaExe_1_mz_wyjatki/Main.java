package JavaExe_1_mz_wyjatki;

public class Main {
    public static boolean containsE(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == 'e') {
                return true;
            }
        }
        return false;
    }

    public static String modifyName(String name) {
        return name.replace("e", "").replace("i", "");
    }

    public static void nameTab(String name) {

        for (int i = 0; i < name.length(); i++) {
            System.out.println("["+(i+1)+"]" + " = " + name.charAt(i));
        }

    }


    public static void main(String[] args) {
        String name = "Olgierd";
        System.out.println(containsE(name));
        System.out.println(modifyName(name));
        nameTab(name);
    }
}
