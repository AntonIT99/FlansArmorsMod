package com.wolffsarmormod.util;

import com.wolffsarmormod.ArmorMod;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LogUtils
{
    public static void logWithoutStacktrace(Throwable throwable)
    {
        ArmorMod.log.error("\t{}: {}", throwable.getClass().getSimpleName(), throwable.getMessage() != null ? throwable.getMessage() : StringUtils.EMPTY);
        Throwable cause = throwable.getCause();
        for (int depth = 1; cause != null; depth++)
        {
            String indentation = "\t".repeat(depth + 1);
            ArmorMod.log.error("{}Caused by {}: {}", indentation, cause.getClass().getSimpleName(), cause.getMessage() != null ? cause.getMessage() : StringUtils.EMPTY);
            cause = cause.getCause();
        }
    }
}
