package ReverseModule;

public class StringReverseImpl extends StringReversePOA {
    @Override
    public String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}

