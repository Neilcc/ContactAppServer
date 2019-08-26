package com.zcc.contactapp.server.common;

import com.zcc.contactapp.server.exception.IllegalParamsException;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2019/4/2.
 */
public class Utils {

    private static final char[] ALPHA_BET = new char[]{
            'd', 'g', 'z', 'i', '2',
            '@', 'o', 'P', 'W', 'A'
    };
    private static final char DIVIDER = 'C';

    private static Map<Character, Integer> decodeMap;

    public static String encode(int pageIndex, int pageSize) {
        int start = pageSize * pageIndex;
        int end = (pageIndex + 1) * pageSize;
        StringBuilder sb1 = decToString(start);
        sb1.append(DIVIDER);
        sb1.append(decToString(end));
        return sb1.toString();
    }

    public static Pair<Integer, Integer> decode(String code) throws IllegalParamsException {
        String[] pairs = code.split(String.valueOf(DIVIDER));
        if (pairs.length != 2) {
            throw new IllegalParamsException("illegal token format");
        }
        int start = stringToDec(pairs[0]);
        int end = stringToDec(pairs[1]);
        return new Pair<>(start, end);
    }


    private static StringBuilder decToString(int val) {
        StringBuilder stringBuilder = new StringBuilder();
        while (val > 9) {
            int lower = val % 10;
            val = val / 10;
            stringBuilder.insert(0, ALPHA_BET[lower]);
        }
        stringBuilder.insert(0, ALPHA_BET[val]);
        return stringBuilder;
    }

    private static int stringToDec(String val) {
        int ret = 0;
        for (char c : val.toCharArray()) {
            ret += getInt(c);
            ret = ret * 10;
        }
        return ret / 10;
    }


    private static int getInt(char c) {
        if (decodeMap == null) {
            decodeMap = new HashMap<>();
            for (int i = 0; i < ALPHA_BET.length; i++) {
                decodeMap.put(ALPHA_BET[i], i);
            }
        }
        return decodeMap.get(c);
    }


}
