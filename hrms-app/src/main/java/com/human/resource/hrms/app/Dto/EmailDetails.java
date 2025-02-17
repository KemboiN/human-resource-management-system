package com.human.resource.hrms.app.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailDetails
{
    private  String recipient;
    private  String subject;
    private  String body;
    private  String attachment;

}
