package net.hypnozcore.hypnozcore.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Size;

@ApiModel("Application Dto")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@ToString
public class DepartementsDto extends AbstractDto{
    @Size(max = 20)
    private String depCode;
    @Size(max = 100)
    private String depNomFr;
    private int depInactif;
    private double depPourcentage;

}