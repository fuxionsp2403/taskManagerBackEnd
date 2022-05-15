package com.max.taskmanagermax_api.DTO;

import lombok.Data;


import java.util.List;

@Data
public class ProjectResponseDTO {
    
    private List<ProjectDTO> content;
    private int              numberPage;
    private int              sizePage;
    private long             totalElements;
    private int              totalPages;
    private boolean          last;
}
