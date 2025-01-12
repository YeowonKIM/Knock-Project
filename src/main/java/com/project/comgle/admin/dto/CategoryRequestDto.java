package com.project.comgle.admin.dto;

import com.project.comgle.global.utils.SchemaDescriptionUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import javax.validation.constraints.NotBlank;

@Getter
public class CategoryRequestDto {

    @NotBlank(message = "Please enter a category name.")
    @Schema(description = SchemaDescriptionUtils.Category.NAME, example = "공지사항" , maxLength = 20)
    private String categoryName;

}
