package vn.chuot96.dbconn.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.chuot96.dbconn.dto.NosqlRequest;
import vn.chuot96.dbconn.dto.SqlRequest;
import vn.chuot96.dbconn.service.MongodbService;
import vn.chuot96.dbconn.service.SqlService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/db")
public class Controller {
    private final SqlService sqlService;

    private final MongodbService mongodbService;

    @PostMapping("/sql/mysql")
    public ResponseEntity<?> mysql(@RequestBody SqlRequest request) {
        return sqlService.mysqlQuery(request);
    }

    @PostMapping("/sql/postgres")
    public ResponseEntity<?> postgres(@RequestBody SqlRequest request) {
        return sqlService.postgresQuery(request);
    }

    @PostMapping("/sql/mssql")
    public ResponseEntity<?> mssql(@RequestBody SqlRequest request) {
        return sqlService.mssqlQuery(request);
    }

    // --> more SQL type here

    @PostMapping("/mongodb/insert")
    public ResponseEntity<?> mongodbInsert(@RequestBody NosqlRequest request) {
        return mongodbService.insert(request);
    }

    @PostMapping("/mongodb/find")
    public ResponseEntity<?> mongodbFind(@RequestBody NosqlRequest request) {
        return mongodbService.find(request);
    }

    @PostMapping("/mongodb/update")
    public ResponseEntity<?> mongodbUpdate(@RequestBody NosqlRequest request) {
        return mongodbService.update(request);
    }

    @PostMapping("/mongodb/delete")
    public ResponseEntity<?> mongodbDelete(@RequestBody NosqlRequest request) {
        return mongodbService.delete(request);
    }

    // --> More operation here

    // --> More NoSQL type here

}
