public class Util {
    public static String gettingCase(int price) {
        String s = "рублей";
        if (price % 10 == 1) s = "рубль";
        if (price % 10 >= 2 && price % 10 <= 4) s = "рубля";
        if (price % 100 >= 11 & price % 100 <= 20) s = "рублей";
        return s;
    }
}
