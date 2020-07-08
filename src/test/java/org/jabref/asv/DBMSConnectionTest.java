package org.jabref.asv;

import org.jabref.logic.shared.DBMSConnection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class DBMSConnectionTest {
    
    public DBMSConnection dbmsconnection;

    @BeforeEach
    public void setup() {
        dbmsconnection = mock(DBMSConnection.class);
    }

    @Test
    void checkDBTypeTest() {
        assertTrue(DBMSConnection.getAvailableDBMSTypes().toString().contains("MySQL"));
    }
}
