package com.dmdev.spring.database.repository;

import com.dmdev.spring.annotation.CustomRepository;
import com.dmdev.spring.database.pool.ConnectionPool;

@CustomRepository
public class CompanyRepository {

    private final ConnectionPool connectionPool;

    public CompanyRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public static CompanyRepository of(ConnectionPool connectionPool) {
        return new CompanyRepository(connectionPool);
    }
}
