package vn.chuot96.dbconn.dto;

import java.util.List;

public record SqlRequest(DbRequest db, String query, List<Object> params) {}
