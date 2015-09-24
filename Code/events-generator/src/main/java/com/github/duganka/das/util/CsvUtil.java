package com.github.duganka.das.util;

import com.google.common.base.Joiner;
import org.joda.time.DateTime;

/**
 * @author vadik
 */
public class CsvUtil {

    public static final Joiner JOINER = Joiner.on(",");

    private CsvUtil() {
    }

    public static String toCsv(final DateTime timestamp) {
        return JOINER.join(timestamp.toString("yyyy"), timestamp.toString("MM"), timestamp.toString("dd"), timestamp.toString("HH:mm:ss SSS"));
    }

}
