package app;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import app.Schema.Item;

public class SchemaTest {
    private String config = "-l:bool,-p:int,-d:string";
    private List<String> schemas;

    @Before
    public void setUp() {
        schemas = Arrays.asList(config.split(","));
    }

    @Test
    public void splitWorkOK() {
        assertEquals(3, schemas.size());
        schemas.forEach(cfg -> assertTrue(cfg, cfg.contains(":")));
    }

    @Test
    public void queryWorkOK() {
        Optional<String> result = schemas.stream().filter(item -> item.contains(":")).findFirst();
        assertTrue("ok", result.isPresent());
    }
}