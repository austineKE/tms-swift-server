package co.sys.procurement.tmsswiftserver.service.impl;

import co.sys.procurement.tmsswiftserver.model.Project;
import co.sys.procurement.tmsswiftserver.service.QueryService;
import co.sys.procurement.tmsswiftserver.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProjectImplService implements ProjectService {
    private Logger logger= LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private QueryService queryService;

    @Override
    public String save(Project project) {
//        String insertQuery="INSERT INTO project(projectname, projectcode, location, timeline) values ?,?,?,?";
//       int id= queryService.getProcurementJdbcTemplate().update(insertQuery, project.getNameOfProject(), project.getProjectCode(), project.getLocation(), project.getTimeline());
        Map<String, Object> params=new HashMap<>();
        params.put("projectname", project.getNameOfProject());
        params.put("projectcode", project.getProjectCode());
        params.put("location", project.getLocation());
        params.put("timeline", project.getTimeline());

        SimpleJdbcInsert simpleJdbcInsert=new SimpleJdbcInsert(queryService.getProcurementJdbcTemplate()).withTableName("project").usingGeneratedKeyColumns("id");
        int value= simpleJdbcInsert.executeAndReturnKey(params).intValue();
        return String.valueOf(value);
    }

    @Override
    public String updateConditions(Project project){
        String updateTermsAndConditions="UPDATE project set IsTermsAgreed=1 where id=?";
        try{
            queryService.getProcurementJdbcTemplate().update(updateTermsAndConditions, project.getId());
        }
        catch (Exception e){
            logger.error("Error while updating terms and conditions {}", e);
        }
        return null;
    }


}
