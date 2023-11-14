package co.sys.procurement.tmsswiftserver.controller;

import co.sys.procurement.tmsswiftserver.model.Project;
import co.sys.procurement.tmsswiftserver.service.impl.ProjectImplService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping(value = "/pr")
public class ProjectController {

    private ProjectImplService projectImplService;

    public ProjectController(ProjectImplService projectImplService){
        this.projectImplService=projectImplService;
    }

    @PostMapping(value = "/project")
    public ResponseEntity<String> saveProject(@RequestBody Project project){
        String value=projectImplService.save(project);
        return ResponseEntity.ok(value);
    }
}
