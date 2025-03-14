package com.stradaperroma.bookservice.mapper;

import com.stradaperroma.bookservice.dto.PageDTO;
import com.stradaperroma.bookservice.entity.Page;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface PageMapper {

    PageDTO pageToDTO(Page page);

    Page createPageFromDTO(PageDTO dto);
}
