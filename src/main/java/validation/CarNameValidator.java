package validation;

import utils.SplitUtils;
import view.OutputView;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CarNameValidator {
    private static final int MINIMUM_CAR_NAME_LENGTH = 1;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    private CarNameValidator() {
    }

    public static void validateCarName(String carName) throws IllegalArgumentException {
        String[] carNames = SplitUtils.splitCarName(carName);
        validateCarNameCount(carNames);
        validateCarNameLength(carNames);
        validateCarNameDuplication(carNames);
    }

    private static void validateCarNameCount(String[] carNames) {
        if (carNames.length == 1) {
            throw new IllegalArgumentException(OutputView.getCarNameCountErrorMessage());
        }
    }

    private static void validateCarNameLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() < MINIMUM_CAR_NAME_LENGTH || MAXIMUM_CAR_NAME_LENGTH < carName.length()) {
                throw new IllegalArgumentException(OutputView.getCarNameLengthErrorMessage());
            }
        }
    }

    private static void validateCarNameDuplication(String[] carNames) {
        int originalSize = carNames.length;
        Set<String> carNameSet = new HashSet<String>(Arrays.asList(carNames));
        if (originalSize != carNameSet.size()) {
            throw new IllegalArgumentException(OutputView.getCarNameDuplicationErrorMessage());
        }
    }
}
