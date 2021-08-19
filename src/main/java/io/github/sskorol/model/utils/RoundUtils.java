package io.github.sskorol.model.utils;

import lombok.experimental.UtilityClass;
import lombok.val;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * An utility class to perform rounding operations.
 */
@SuppressWarnings("HideUtilityClassConstructor")
@UtilityClass
public class RoundUtils {

    @SuppressWarnings("FinalLocalVariable")
    public static BigDecimal toDecimal(
            final double value,
            final RoundingMode mode,
            final boolean takeModule,
            final int decimalPoints
    ) {
        val scaledDecimal = new BigDecimal(String.valueOf(value)).setScale(decimalPoints, mode);
        return takeModule ? scaledDecimal.abs() : scaledDecimal;
    }

    public static BigDecimal toDecimal(final double value, final RoundingMode mode, final boolean takeModule) {
        return toDecimal(value, mode, takeModule, 2);
    }

    public static BigDecimal toDecimal(final double value, final RoundingMode mode) {
        return toDecimal(value, mode, true);
    }
}
