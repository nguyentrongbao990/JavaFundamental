package Session14.Ex4;

public class InvalidPhoneNumberLengthException extends Exception {

    public InvalidPhoneNumberLengthException(String message) {
        super(message);
    }

    public static void validatePhoneNumber(String phone)
            throws InvalidPhoneNumberLengthException {

        if (phone.contains(" ")) {
            throw new InvalidPhoneNumberLengthException("Không được chứa khoảng trắng");
        }

        if (phone.length() != 10) {
            throw new InvalidPhoneNumberLengthException("Phải gồm đúng 10 chữ số");
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                throw new InvalidPhoneNumberLengthException("Chứa ký tự không hợp lệ");
            }
        }
    }
}