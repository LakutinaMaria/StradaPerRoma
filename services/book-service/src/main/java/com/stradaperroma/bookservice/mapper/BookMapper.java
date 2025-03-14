package com.stradaperroma.bookservice.mapper;

import com.stradaperroma.bookservice.dto.BookDTO;
import com.stradaperroma.bookservice.entity.Book;
import com.stradaperroma.bookservice.entity.BookLevel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "started", ignore = true)
    @Mapping(source = "book.level", target = "level", qualifiedByName = "enumToString")
    BookDTO bookToBookDTO(Book book);

    @Mapping(source = "level", target = "level", qualifiedByName = "stringToEnum")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pages", ignore = true)
    Book bookDTOToBook(BookDTO bookDTO);

    @Named("enumToString")
    static String enumToString(BookLevel level) {
        return level != null ? level.name() : null;
    }

    @Named("stringToEnum")
    static BookLevel stringToEnum(String level) {
        return level != null ? BookLevel.valueOf(level) : null;
    }
}
