package com.mycompany.myapp.projmngrefact.adapter.emp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.projmngrefact.common.SystemException;
import com.mycompany.myapp.projmngrefact.domain.emp.EmpNumCounter;
import com.mycompany.myapp.projmngrefact.domain.emp.EmpNumCounterRepository;

@Component
public class EmpNumCounterRepositoryJdbc implements EmpNumCounterRepository {

    private final JdbcTemplate template;
    private final SimpleJdbcInsert insertEmpNumCounter;

    public EmpNumCounterRepositoryJdbc(JdbcTemplate template) {
        this.template = template;
        this.insertEmpNumCounter = new SimpleJdbcInsert(template)
                .withTableName("emp_num_counter");
    }

    @Override
    public void save(EmpNumCounter empNumCounter) {
        Map<String, Object> params = new HashMap<>();

        params.put("tenant_id", empNumCounter.getTenantId());
        params.put("year_num", empNumCounter.getYearNum());
        params.put("max_emp_num", empNumCounter.getMaxEmpNum());

        insertEmpNumCounter.execute(params);
    }

    @Override
    public EmpNumCounter findByYear(Long tenantId, int yearNum) {
        final String sql = " select tenant_id"
                + ", year_num"
                + ", max_emp_num"
                + " from emp_num_counter "
                + " where tenant_id = ?  and year_num = ? ";

        try {
            return template.queryForObject(sql,
                    (rs, rowNum) -> new EmpNumCounter(rs.getLong("tenant_id"), rs.getInt("year_num"),
                            rs.getInt("max_emp_num")),
                    tenantId, yearNum);
        } catch (IncorrectResultSizeDataAccessException e) {
            throw new SystemException(yearNum + "年度的员工编号计数器不存在");
        }
    }

    @Override
    public Integer increaseMaxNumByYear(Long tenantId, int yearNum) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'increaseMaxNumByYear'");
    }

}
