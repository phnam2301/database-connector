package vn.chuot96.dbconn.service;

import static vn.chuot96.dbconn.constant.SqlJdbcUrl.*;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.chuot96.dbconn.dto.SqlRequest;
import vn.chuot96.dbconn.util.SqlHandler;

@Service
@RequiredArgsConstructor
public class SqlService {
    private final SqlHandler handler;

    public ResponseEntity<?> mysqlQuery(SqlRequest request) {
        return handler.execute(MYSQL.getDriverClass(), MYSQL.setJdbcUrl(request), request);
    }

    public ResponseEntity<?> postgresQuery(SqlRequest request) {
        return handler.execute(POSTGRES.getDriverClass(), POSTGRES.setJdbcUrl(request), request);
    }

    public ResponseEntity<?> mssqlQuery(SqlRequest request) {
        return handler.execute(MSSQL.getDriverClass(), MSSQL.setJdbcUrl(request), request);
    }

    // --> more SQL type here

}
