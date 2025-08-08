package vn.chuot96.dbconn.dto;

import java.util.Map;

public record NosqlRequest(DbRequest db, String collection, Map<String, Object> data, Map<String, Object> filter) {}
