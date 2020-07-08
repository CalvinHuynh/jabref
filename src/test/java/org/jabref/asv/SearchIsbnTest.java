package org.jabref.asv;

import java.util.Optional;

import org.jabref.logic.importer.FetcherException;
import org.jabref.logic.importer.ImportFormatPreferences;
import org.jabref.logic.importer.fetcher.IsbnFetcher;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;
import org.jabref.model.entry.types.StandardEntryType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;

import java.util.Optional;
class SearchIsbnTest {

    private BibEntry bibEntry;
    private IsbnFetcher fetcher;

    @BeforeEach
    public void setup() {
        fetcher = new IsbnFetcher(mock(ImportFormatPreferences.class, Answers.RETURNS_DEEP_STUBS));

        bibEntry = new BibEntry();
        bibEntry.setType(StandardEntryType.Book);
        bibEntry.setCiteKey("huber2018modern");
        bibEntry.setField(StandardField.ADDRESS, "New York, NY");
        bibEntry.setField(StandardField.AUTHOR, "Huber, David");
        bibEntry.setField(StandardField.TITLE, "Modern recording techniques");
        bibEntry.setField(StandardField.PUBLISHER, "Routledge");
        bibEntry.setField(StandardField.ISBN, "9781317356660");
        bibEntry.setField(StandardField.YEAR, "2018");
    }
    
    @Test
    void searchByIsbnTest() throws FetcherException { 
        Optional<BibEntry> fetchedEntry = fetcher.performSearchById("9781317356660");
        BibEntry bibEntry = fetchedEntry.isPresent() ? fetchedEntry.get() : null;
        bibEntry.clearCiteKey();
        assertEquals(Optional.of(bibEntry), fetchedEntry);
    }
}
