import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RuleTest {

    @Test
    void can_parse_schema() {
        Rule rule = new Rule("l:bool:true;p:int:0;d:string:/logs");
        assertEquals(true, rule.value("l"));
        assertEquals(8080, rule.value("p 8080"));
        assertEquals("/var/logs", rule.value("d /var/logs"));
    }
}