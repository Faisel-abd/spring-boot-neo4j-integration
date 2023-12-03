package com.trainig.neo4jboot.integration.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trainig.neo4jboot.integration.common.Constants;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class MovieDTO implements Serializable {

    @JsonIgnore
    private  Long id;
    @NotNull(message = Constants.DATA_VALIDATION_NOT_NULL)
    private  String title;
    @NotNull(message = Constants.DATA_VALIDATION_NOT_NULL)
    @Digits(integer =4, fraction = 0)
    private  int yearOfRelease;
    @NotNull(message = Constants.DATA_VALIDATION_NOT_NULL)
    @Size(min = 10, max = 200,message = Constants.DATA_VALIDATION_SIZE_MIN_MAX)
    private  String shortDescription;

    @NotNull(message = Constants.DATA_VALIDATION_NOT_NULL)
    private List<RolesDTO> actorsAndRoles;
    @NotNull(message = Constants.DATA_VALIDATION_NOT_NULL)
    private List<ActorDTO> directors;
}
