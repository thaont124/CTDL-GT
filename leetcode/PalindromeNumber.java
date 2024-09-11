public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int originNumber = x;
        int reverseNumber = 0;
        while (x > 0) {
            reverseNumber = reverseNumber * 10 + x % 10;
            x /= 10;
        }
        if (originNumber != reverseNumber) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        int x = 121;
        System.out.println(palindromeNumber.isPalindrome(x));
    }
}
