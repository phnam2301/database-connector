package vn.chuot96.dbconn.dto;

public record DbRequest(String host, String port, String username, String password, String dbName) {}
