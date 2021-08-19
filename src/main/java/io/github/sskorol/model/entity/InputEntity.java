package io.github.sskorol.model.entity;

import lombok.Data;
import lombok.val;
import one.util.streamex.IntStreamEx;

import java.util.Map;

import static io.github.sskorol.model.utils.RoundUtils.toDecimal;
import static java.math.RoundingMode.DOWN;

/**
 * Handles input entity payload.
 */
@Data
public class InputEntity {

    private Map<Long, Double> props;

    public InputEntity withProportionalDistribution(final Segment... props) {
        val segmentsLen = props.length;
        val estimatedSum = 100.00;
        val eqUnit = toDecimal(estimatedSum / segmentsLen, DOWN).doubleValue();
        val error = toDecimal(estimatedSum - (segmentsLen * eqUnit), DOWN).doubleValue();

        this.props.putAll(IntStreamEx.range(0, segmentsLen)
                .boxed()
                .toMap(i -> props[i].getId(), i -> eqUnit + (i < segmentsLen - 1 ? 0.00 : error))
        );

        return this;
    }
}
