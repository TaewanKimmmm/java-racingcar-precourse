package validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CarNameValidator {
    private static final int MINIMUM_CAR_NAME_LENGTH = 1;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    private CarNameValidator() {
    }

    public static void validateCarName(String carName) throws IllegalArgumentException {
        String[] carNames = splitCarName(carName);
        validateCarNameCount(carNames);
        validateCarNameLength(carNames);
        validateCarNameDuplication(carNames);
    }

    private static String[] splitCarName(String carNames) {
        if (!carNames.contains(",")) {
            String[] carName = {carNames};
            return carName;
        }
        return carNames.split(",");
    }

    private static void validateCarNameCount(String[] carNames) {
        if (carNames.length == 1) {
            throw new IllegalArgumentException("[ERROR] 경주할 자동차는 한 대 이상이어야 합니다.");
        }
    }

    private static void validateCarNameLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() < MINIMUM_CAR_NAME_LENGTH || MAXIMUM_CAR_NAME_LENGTH < carName.length()) {
                throw new IllegalArgumentException("[ERROR] 경주할 자동차의 이름은 1 이상 5이하여야 합니다.");
            }
        }
    }

    private static void validateCarNameDuplication(String[] carNames) {
        int originalSize = carNames.length;
        Set<String> carNameSet = new HashSet<String>(Arrays.asList(carNames));
        if (originalSize != carNameSet.size()) {
            throw new IllegalArgumentException("[ERROR] 경주할 자동차의 이름이 중복됩니다.");
        }
    }
}
