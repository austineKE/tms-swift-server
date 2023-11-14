package co.sys.procurement.tmsswiftserver.service;

import org.springframework.jdbc.core.JdbcTemplate;

public class QueryService {
    private JdbcTemplate userJdbcTemplate;
    private JdbcTemplate procurementJdbcTemplate;




    public void setUserJdbcTemplate(JdbcTemplate userJdbcTemplate) {
        this.userJdbcTemplate=userJdbcTemplate;
    }

    public void setProcurementJdbcTemplate(JdbcTemplate procurementJdbcTemplate) {
        this.procurementJdbcTemplate=procurementJdbcTemplate;
    }

    public JdbcTemplate getUserJdbcTemplate() {
        return userJdbcTemplate;
    }

    public JdbcTemplate getProcurementJdbcTemplate() {
        return procurementJdbcTemplate;
    }
}
