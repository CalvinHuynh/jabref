package org.jabref.asv;

import org.jabref.logic.msbib.MSBibConverter;
import org.jabref.logic.msbib.MSBibEntry;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;
import org.jabref.model.entry.types.StandardEntryType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MsBibTest {

    BibEntry convertedEntry;
    BibEntry notConvertedEntry;
    MSBibEntry convertedMsBibEntry;
    MSBibEntry notConvertedMsBibEntry;

    @BeforeEach
    public void setup() {
        convertedEntry = new BibEntry();
        notConvertedEntry = new BibEntry();
        convertedMsBibEntry = new MSBibEntry();
        notConvertedMsBibEntry = new MSBibEntry();
    }

    @Test
    public void MsBibTypeConversionTest() {
        convertedEntry.setField(StandardField.TITLE, "A new Article");
        convertedEntry.setType(StandardEntryType.Book);
        convertedMsBibEntry = MSBibConverter.convert(convertedEntry);
        assertEquals(StandardEntryType.Book, convertedMsBibEntry.getType());
    }

    @Test
    public void MsBibNoTypeConversionTest() {
        notConvertedEntry.setField(StandardField.TITLE, "A new Article");
        notConvertedMsBibEntry = MSBibConverter.convert(notConvertedEntry);
        assertEquals(StandardEntryType.Misc, notConvertedMsBibEntry.getType());
    }
}
