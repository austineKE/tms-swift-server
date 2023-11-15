package co.sys.procurement.tmsswiftserver.service;

import co.sys.procurement.tmsswiftserver.model.Project;

public interface ProjectService {
    String save(Project project);
    String updateConditions(Project project);
    String updateConditionsManually(Project project);
}
