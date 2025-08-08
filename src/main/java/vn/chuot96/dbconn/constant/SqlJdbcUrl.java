package vn.chuot96.dbconn.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import vn.chuot96.dbconn.dto.SqlRequest;

@Getter
@RequiredArgsConstructor
public enum SqlJdbcUrl {
    MYSQL("com.mysql.cj.jdbc.Driver", "jdbc:mysql://%s:%s/%s", "useSSL=false&characterEncoding=UTF-8"),
    POSTGRES("org.postgresql.Driver", "jdbc:postgresql://%s:%s/%s", "ssl=false&charSet=UTF8"),
    MSSQL(
            "com.microsoft.sqlserver.jdbc.SQLServerDriver",
            "jdbc:sqlserver://%s:%s;databaseName=%s",
            "encrypt=false;trustServerCertificate=true");

    private final String driverClass;

    private final String pattern;

    private final String defaultParams;

    public String setJdbcUrl(SqlRequest request) {
        String baseUrl = String.format(
                pattern, request.db().host(), request.db().port(), request.db().dbName());
        if (this == MSSQL) {
            return baseUrl + (defaultParams != null && !defaultParams.isBlank() ? ";" + defaultParams : "");
        }
        return baseUrl + (defaultParams != null && !defaultParams.isBlank() ? "?" + defaultParams : "");
    }
}
