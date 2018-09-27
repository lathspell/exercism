class RaindropConverter {

    String convert(int number) {
        String s = "";
        if (number % 3 == 0) s += "Pling";
        if (number % 5 == 0) s += "Plang";
        if (number % 7 == 0) s += "Plong";
        if (s.isEmpty()) s += number;
        return s;
    }

}
