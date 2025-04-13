package com.wolffsarmormod.util;

import com.wolffsarmormod.ArmorMod;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LogUtils
{
    public static void logWithoutStacktrace(Throwable throwable)
    {
        ArmorMod.log.error("{}: {}", throwable.getClass().getSimpleName(), throwable.getMessage() != null ? throwable.getMessage() : "(no message)");
        Throwable cause = throwable.getCause();
        for (int depth = 1; cause != null; depth++)
        {
            String indentation = "\t".repeat(depth);
            ArmorMod.log.error("{}Caused by {}: {}", indentation, cause.getClass().getSimpleName(), cause.getMessage() != null ? cause.getMessage() : "(no message)");
            cause = cause.getCause();
        }
    }
}
