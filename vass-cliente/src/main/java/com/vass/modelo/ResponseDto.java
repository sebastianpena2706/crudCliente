package com.vass.modelo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
/**
 *Formato de respuesta estandarizado
 */
public class ResponseDto<Response> {

    private String status;
    private String message = "Operacion Realizada con Exito";
    private Response data;

}
