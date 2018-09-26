import java.util.stream.Collectors;

class ArmstrongNumbers {

	boolean isArmstrongNumber(int numberToCheck) {
		String nr = String.valueOf(numberToCheck);
		int len = nr.length();
		int sum = nr.chars().map(c -> (int)(Math.pow(Character.getNumericValue(c), len))).sum();
		return sum == numberToCheck;
	}

}
