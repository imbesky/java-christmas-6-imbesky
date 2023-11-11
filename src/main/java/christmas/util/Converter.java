package christmas.util;

import static christmas.constant.Format.BLANK;
import static christmas.constant.Format.COMMA;
import static christmas.constant.Format.DASH;
import static christmas.constant.Format.SPACE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static List<String[]> toOrderFormat(String orders) {
        return Arrays.stream(orders.replace(SPACE, BLANK).split(COMMA))
                .map(order -> order.split(DASH))
                .collect(Collectors.toList());
    }
}