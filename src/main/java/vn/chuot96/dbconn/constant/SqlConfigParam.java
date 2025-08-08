package vn.chuot96.dbconn.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SqlConfigParam {
    MAXIMUM_POOL_SIZE(10), // int
    CONNECTION_TIMEOUT(5000), // 5s
    IDLE_TIMEOUT(30000), // 30s
    MAX_LIFE_TIME(600000), // 5m
    DEFAULT_SELECT_LIMIT(1000);

    private final long value;
}
