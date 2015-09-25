package com.github.duganka.das.util;

import com.google.common.base.Joiner;
import org.joda.time.DateTime;

/**
 * @author vadik
 */
public class TsvUtil {

    public static final Joiner JOINER = Joiner.on('\t');

    private TsvUtil() {
    }

    public static String toTsv(final DateTime timestamp) {
        return JOINER.join(timestamp.toString("yyyy"), timestamp.toString("MM"), timestamp.toString("dd"), timestamp.toString("HH:mm:ss SSS"));
    }

}
